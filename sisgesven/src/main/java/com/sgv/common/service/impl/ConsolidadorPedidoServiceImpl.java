package com.sgv.common.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.sgv.common.constants.Constants;
import com.sgv.common.constants.TypeDocument_ES;
import com.sgv.common.exception.BusinessException;
import com.sgv.common.service.ConsolidadorPedidoService;
import com.sgv.common.util.FileUtil;
import com.sgv.common.util.MoneyUtil;
import com.sgv.common.vo.ConsolidadorPedidoVO;
import com.sgv.common.vo.ConsolidadorProductoVO;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.DocumentDAO;
import com.sgv.fakturama.dao.DocumentoItemDAO;
import com.sgv.fakturama.dao.impl.DocumentoDAOImpl;
import com.sgv.fakturama.dao.impl.DocumentoItemDAOImpl;
import com.sgv.fakturama.dao.model.FktDocument;
import com.sgv.fakturama.dao.model.FktDocumentitem;

public class ConsolidadorPedidoServiceImpl implements ConsolidadorPedidoService {


	@Override
	public FktDocument consolidarPedido(ConsolidadorPedidoVO vo) throws BusinessException, IOException {
		FktDocument result = new FktDocument();
		DocumentDAO dao = new DocumentoDAOImpl();
		ConsolidadorProductoVO consolidador = null;
		List<String> listaDias =  null;
		List<String> lContenido = null;
		List<FktDocument> listaPedidosInicial = null;
		List<FktDocumentitem> listaItems = null;
		Map<String,ConsolidadorProductoVO> mProducto = new TreeMap<String,ConsolidadorProductoVO>();
		Map<String,ConsolidadorProductoVO> mProductoConIGV = new TreeMap<String,ConsolidadorProductoVO>();
		Map<String,ConsolidadorProductoVO> mProductoSinIGV = new TreeMap<String,ConsolidadorProductoVO>();
		String nombreProducto = null;
				
		listaPedidosInicial = dao.obtenerPedidos(vo);
		
		if(listaPedidosInicial.size() == 0){
			throw new BusinessException("NO SE ENCONTRO NINGUN REGISTRO PARA GENERAR CONSOLIDACION REQUERIDA.");
		}
		
		for (FktDocument fktDocument : listaPedidosInicial) {
			listaItems = fktDocument.getItems();

			for (FktDocumentitem item : listaItems) {	
				nombreProducto = (""+item.getVat().getTAXVALUE()*100).
						concat("_").
						concat(item.getNAME()).
						concat("_S/. ").
						concat(MoneyUtil.convertDoubleToString(item.getPRICE()));
				consolidador = new ConsolidadorProductoVO();
				consolidador = mProducto.getOrDefault(nombreProducto,consolidador);

				mProducto.put(nombreProducto,consolidador.cargar(item,fktDocument.getDOCUMENTDATE()));
				if(nombreProducto.startsWith("0")){
					mProductoSinIGV.put(nombreProducto,consolidador);
				} else {
					mProductoConIGV.put(nombreProducto,consolidador);
				}
			}
		}

		/* CREACION DE ARCHIVO CSV
		 * 
		 * 
		 * */			
		listaDias = obtenerListaDias(vo.getFechaInicio(),vo.getFechaFin());		
		lContenido = new ArrayList<String>();	
		
		lContenido.add(generarCabeceraCSV(mProducto,listaDias));
		lContenido.addAll(generarDetalleCSV(mProducto,listaDias));
		String nombreCSV = "CONSOLIDADO "+vo.getClienteNombre()+" "+vo.getFechaInicio()+" AL "+vo.getFechaFin()+".CSV";
		//System.out.println("**************** "+nombreCSV);
		nombreCSV = nombreCSV.replaceAll("/","-");
		//System.out.println("**************** "+nombreCSV);
		FileUtil.createFile(Constants.SISGESVEN_PATH_FILE, nombreCSV, lContenido.toArray(new String[0]));

		/*
		 * 
		 * 
		 * */
		//RECORER LIST DE NRO DE DOCUMENTOS
		//	LIMPIAR CADA DOCUMENTO ELIMINAR DOCUMENTOTIEMS 

		
		DocumentoItemDAO docItemDAO = null;
		FktDocument documentoBase = listaPedidosInicial.get(0);
		List<FktDocument> listaPedidosFinal =  generarListaPedidos(documentoBase, vo, mProductoConIGV, mProductoSinIGV);
		int nPosition = 0;
//		int numeroId = 0;
		DocumentoVO documentoVO;
		int cantidadPedidos = listaPedidosFinal.size();
		
		docItemDAO = new DocumentoItemDAOImpl();
		
		if(cantidadPedidos < vo.getListaNumeroDocumento().size()){
			FktDocument remove = new FktDocument();
			for (int i = cantidadPedidos; i < vo.getListaNumeroDocumento().size(); i++) {
				;
				//
				//documentoVO = new DocumentoVO(vo.getListaNumeroDocumento().get(i),TypeDocument_ES.Orden.getText());
				
				//docItemDAO.deleteByFKDocument(dao.selectByNumeroBasico(documentoVO).getID());
				remove.setNAME(vo.getListaNumeroDocumento().get(i));
				remove.setDTYPE(TypeDocument_ES.Pedido.getText());
				remove.setDELETED(false);
				remove.setItems(new ArrayList<FktDocumentitem>());
			}
			listaPedidosFinal.add(remove);
		}
		
		//FktDocument tmp ;
		for (FktDocument documento : listaPedidosFinal) {
			documentoVO = new DocumentoVO(documento.getNAME(),documento.getDTYPE());
			/*
			tmp = dao.selectByNumeroBasico(documentoVO);
			//System.out.println("CONSOLIDADOR : "+tmp);
			documento.setID(tmp.getID());
			*/

			//System.out.print("====>>>>>>  get FktDocument "+dao.selectByNumeroBasico(documentoVO));

			documento.setID(dao.selectByNumeroBasico(documentoVO).getID());
			dao.updateByPrimaryKey(documento);			
			docItemDAO.deleteByFKDocument(documento.getID());	
			nPosition = 0;
			for (FktDocumentitem item : documento.getItems()) {
				nPosition++;
				item.setPOSNR(nPosition);
				item.setFK_DOCUMENT(documento.getID());
				docItemDAO.insertSelective(item);
			}
			//numeroId++;
		}	
		
		result.setRespuesta("SE GENERO EL ARCHIVO");
		
		return result;
	}

	private List<FktDocument> generarListaPedidos(FktDocument documentoBase, ConsolidadorPedidoVO vo,Map<String,ConsolidadorProductoVO> mProductoConIGV, Map<String,ConsolidadorProductoVO> mProductoSinIGV) throws BusinessException {
		//Declaraci�n de Variables
		FktDocument documento = null;
		List<FktDocument> listaPedidos = new ArrayList<FktDocument>();
		List<FktDocumentitem> listaItemsTMP = null;
		List<FktDocumentitem> listaItems = new ArrayList<FktDocumentitem>();
		List<FktDocumentitem> listaItemsSIGV = new ArrayList<FktDocumentitem>();
		List<FktDocumentitem> listaItemsCIGV = new ArrayList<FktDocumentitem>();
		Map<String,ConsolidadorProductoVO> mProducto = new TreeMap<String,ConsolidadorProductoVO>();

		String numeroPedido = null;
		int cantidadPedidos = 0;
		int cantidadPedidosConIGV = 0;
		int cantidadPedidosSinIGV = 0;
		int cantidadResiduo = 0;
		int cantidadResiduoConIGV = 0;
		int cantidadResiduoSinIGV = 0;
		int maximaCantidadRegistros = 34;
		int nPCI = 0;
		int nPSI = 0;
    	int registroInicial = 0;
    	int registroFinal = 0;
		
		//Calcular cantidad registros		
		nPCI = mProductoConIGV.size();
		nPSI = mProductoSinIGV.size();
		if(vo.isUnido()){
			cantidadPedidos = ((nPSI + nPCI)/maximaCantidadRegistros) + (((nPSI + nPCI)%maximaCantidadRegistros == 0)?0:1);
			
			if(cantidadPedidos > vo.getListaNumeroDocumento().size()){
				throw new BusinessException("SE REQUIEREN GENERAR "+(cantidadPedidos-vo.getListaNumeroDocumento().size())+"DOCUMENTO(S).");
			}
			
			cantidadResiduo = (nPSI + nPCI)%maximaCantidadRegistros;
			mProducto.putAll(mProductoSinIGV);
			mProducto.putAll(mProductoConIGV);

			listaItems = mProducto.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
					//.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
					.map(e -> convertirConsolidadirProductoAFktDocumentItem(e.getValue()))
					.collect(Collectors.toList());
			Collections.sort(listaItems, new FktDocumentitemComparator());
			
			//Cargar Pedidos
			for (int i = 0; i < cantidadPedidos; i++) {
				numeroPedido = vo.getListaNumeroDocumento().get(i);			
				documento = cargarDocumento(numeroPedido, documentoBase, vo);
				
		    	registroInicial = maximaCantidadRegistros*i;
		    	registroFinal = (maximaCantidadRegistros*(i+1));//-1;
		    	if(i+1 == cantidadPedidos)registroFinal=registroInicial+cantidadResiduo;//-1;
		    	listaItemsTMP = listaItems.subList(registroInicial, registroFinal);
		    	
		    	System.out.println("RegIni["+registroInicial+"] - RegEnd["+registroFinal+"]");
							
				documento.setItems(listaItemsTMP);		
				
				listaPedidos.add(documento);
			}
			
		} else {
			cantidadPedidosSinIGV = (nPSI/maximaCantidadRegistros)+((nPSI%maximaCantidadRegistros == 0)?0:1);
			cantidadPedidosConIGV = (nPCI/maximaCantidadRegistros)+((nPCI%maximaCantidadRegistros == 0)?0:1);
			cantidadPedidos = cantidadPedidosConIGV+cantidadPedidosSinIGV;
			
			if(cantidadPedidos > vo.getListaNumeroDocumento().size()){
				throw new BusinessException("SE REQUIEREN GENERAR "+(cantidadPedidos-vo.getListaNumeroDocumento().size())+"DOCUMENTO(S).");
            }

            cantidadResiduoSinIGV = nPSI%maximaCantidadRegistros;
            cantidadResiduoConIGV = nPCI%maximaCantidadRegistros;

            listaItemsSIGV = mProductoSinIGV.entrySet()
                    .stream()
                    //.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                    //.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .map(e -> convertirConsolidadirProductoAFktDocumentItem(e.getValue()))
                    .collect(Collectors.toList());
            //Collections.sort(listaItemsSIGV, new FktDocumentitemComparator());

            listaItemsCIGV = mProductoConIGV.entrySet()
                    .stream()
                    //.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                    //.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .map(e -> convertirConsolidadirProductoAFktDocumentItem(e.getValue()))
                    .collect(Collectors.toList());
            //Collections.sort(listaItemsCIGV, new FktDocumentitemComparator());

            //Cargar Pedidos
            for (int i = 0; i < cantidadPedidosSinIGV; i++) {
                numeroPedido = vo.getListaNumeroDocumento().get(i);
                documento = cargarDocumento(numeroPedido, documentoBase, vo);
				
		    	registroInicial = maximaCantidadRegistros*i;
		    	registroFinal = (maximaCantidadRegistros*(i+1));//-1;
		    	if(i+1 == cantidadPedidosSinIGV)registroFinal=registroInicial+cantidadResiduoSinIGV;//-1;
		    	listaItemsTMP = listaItemsSIGV.subList(registroInicial, registroFinal);
		    	
				for (FktDocumentitem fktDocumentitem : listaItemsTMP) {
					System.out.println("==================="+fktDocumentitem.getNAME());
				}
		    	System.out.println("RegIni["+registroInicial+"] - RegEnd["+registroFinal+"]");
							
				documento.setItems(listaItemsTMP);		
				
				listaPedidos.add(documento);
			}
			
			for (int i = 0; i < cantidadPedidosConIGV; i++) {
				numeroPedido = vo.getListaNumeroDocumento().get(cantidadPedidosSinIGV+i);			
				documento = cargarDocumento(numeroPedido, documentoBase, vo);
				
		    	registroInicial = maximaCantidadRegistros*i;
		    	registroFinal = (maximaCantidadRegistros*(i+1));//-1;
		    	if(i+1 == cantidadPedidosConIGV)registroFinal=registroInicial+cantidadResiduoConIGV;//-1;
		    	listaItemsTMP = listaItemsCIGV.subList(registroInicial, registroFinal);
		    	
		    	System.out.println("RegIni["+registroInicial+"] - RegEnd["+registroFinal+"]");
							
				documento.setItems(listaItemsTMP);		
				
				listaPedidos.add(documento);
			}
		}	
	
		
		return listaPedidos;
	}

	class FktDocumentitemComparator implements Comparator<FktDocumentitem> {
	    @Override
	    public int compare(FktDocumentitem a, FktDocumentitem b) {
	        return a.getNAME().compareToIgnoreCase(b.getNAME());
	    }
	}
	
	private FktDocumentitem convertirConsolidadirProductoAFktDocumentItem(ConsolidadorProductoVO vo){
		FktDocumentitem item = new FktDocumentitem();
		item.setDATEADDED(new Date());
		item.setDELETED(false);
		item.setDESCRIPTION("");
		item.setGTIN(null);
		item.setITEMNUMBER(vo.getCodigo());
		item.setITEMREBATE(0.00);//****
		item.setITEMTYPE("POSITION");
		item.setMODIFIED(null);
		item.setMODIFIEDBY("CONSOLIDADOR");
		item.setNAME(vo.getNombre());
		item.setNOVAT(false);
		item.setOPTIONAL(false);
		item.setPICTURE(null);
		//item.setPOSNR(1);//*****
		item.setPRICE(vo.getPrecioUnitario());
		item.setQUANTITY(vo.getCantidad());
		item.setQUANTITYUNIT(vo.getUnidadMedida());
		item.setTARA(null);
		item.setVALIDFROM(new Date());
		item.setVALIDTO(null);
		item.setVESTINGPERIODEND(null);
		item.setVESTINGPERIODSTART(null);
		item.setWEIGHT(null);
		item.setFK_VAT(vo.getIdVAT());
		item.setFK_PRODUCT(null);
		//item.setFK_DOCUMENT(new Long(0));//****
		
		return item;
	}

	
	private FktDocument cargarDocumento(String numeroPedido, FktDocument documentoBase, ConsolidadorPedidoVO vo) {
		System.out.println("cargarDocumento : "+documentoBase);

		FktDocument fktDocument = new FktDocument();
		fktDocument.setNAME(numeroPedido);
		fktDocument.setDTYPE(TypeDocument_ES.Pedido.getText());
		fktDocument.setADDRESSFIRSTLINE(documentoBase.getContact().getCOMPANY()
				.concat(", ")
				.concat((documentoBase.getContact().getNAME() != null)? (documentoBase.getContact().getNAME()):"")
				.concat(" ")
                .concat((documentoBase.getContact().getFIRSTNAME() != null)? (documentoBase.getContact().getFIRSTNAME()):""));
		fktDocument.setBILLINGTYPE(3);
		fktDocument.setCONSULTANT("AUTOGENERADO");
		fktDocument.setCUSTOMERREF("CONSOLIDADO DEL "+vo.getFechaInicio()+" AL "+vo.getFechaFin());
		fktDocument.setDELETED(false);
		fktDocument.setDEPOSIT(false);
		fktDocument.setDOCUMENTDATE(new Date());
		fktDocument.setDUEDAYS(0);
		fktDocument.setITEMSREBATE(0.0);
		fktDocument.setMESSAGE(fktDocument.getCUSTOMERREF());
		fktDocument.setMESSAGE2("");
		fktDocument.setMESSAGE3("");
		fktDocument.setMODIFIED(new Date());
		fktDocument.setMODIFIEDBY("CONSOLIDADOR");
		fktDocument.setNETGROSS(2);
		fktDocument.setODTPATH("");
		fktDocument.setORDERDATE(new Date());
		fktDocument.setPAID(false);
		fktDocument.setPAIDVALUE(0.0);
		fktDocument.setPAYDATE(null);//*****
		fktDocument.setPDFPATH("");
		fktDocument.setPRINTTEMPLATE("");
		fktDocument.setPRINTED(false);
		fktDocument.setPROGRESS(0);
		fktDocument.setSERVICEDATE(new Date());
		fktDocument.setSHIPPINGAUTOVAT("SHIPPINGVATGROSS");
		fktDocument.setSHIPPINGVALUE(0.0);
		fktDocument.setTOTALVALUE(0.00);
		fktDocument.setTRANSACTIONID(fktDocument.getTRANSACTIONID());
		fktDocument.setVALIDFROM(new Date());
		fktDocument.setVALIDTO(new Date());
		fktDocument.setWEBSHOPDATE(null);
		fktDocument.setWEBSHOPID("");
		fktDocument.setFK_INDIVIDUALINFO(fktDocument.getFK_INDIVIDUALINFO());
		fktDocument.setFK_CONTACT(documentoBase.getContact().getID());
		fktDocument.setFK_DELIVERYCONTACT(null);
		fktDocument.setDOCUMENT_INVOICEREFERENCE(null);
		fktDocument.setFK_NOVATREF(null);
		fktDocument.setFK_PAYMENT(documentoBase.getFK_PAYMENT());
		fktDocument.setFK_SHIPPING(new Long(1));
		fktDocument.setFK_SRCDOCUMENT(null);
		return fktDocument;
	}

	private String generarCabeceraCSV(Map<String, ConsolidadorProductoVO> mProducto, List<String> listaDias) {
		// TODO Auto-generated method stub
		//List<String> lContenido = null;
		//lContenido = new ArrayList<String>();	
		StringJoiner sjCabecera = new StringJoiner(";");
		
		sjCabecera.add("CODIGO");
		sjCabecera.add("CANTIDAD");
		sjCabecera.add("UM");
		sjCabecera.add("NOMBRE");
		sjCabecera.add("PU");
		sjCabecera.add("VAL. VTA.");
		sjCabecera.add("IGV");
		sjCabecera.add("PV");
				
		listaDias.stream().forEach(day -> sjCabecera.add(day));
		//lContenido.add(sjCabecera.toString());	
		return sjCabecera.toString();
	}

	private List<String> generarDetalleCSV(Map<String, ConsolidadorProductoVO> map,
			List<String> listaDias) {
		// TODO Auto-generated method stub
		List<String> lContenido = new ArrayList<String>(); 
		ConsolidadorProductoVO vo = null;
		Set<String> sets = map.keySet();
		StringJoiner sj = null;
		String dia = "";
		Double cantidad = 0.00;
		Double precioUnitario = 0.00;		
		Double valorVenta = 0.00;
		Double igv = 0.00;
		Double precioVenta =  0.00;
		
		Double ventaTotal =  0.00;
		Double igvTotal =  0.00;
		Double importeTotal =  0.00;
		
		Double total = new Double(0.00);
		
		for (String key : sets) {
			vo = map.get(key);
			
			cantidad = vo.getCantidad();
			precioUnitario = vo.getPrecioUnitario();		
			valorVenta = MoneyUtil.convertStringToDouble(MoneyUtil.convertDoubleToString(cantidad))*MoneyUtil.convertStringToDouble(MoneyUtil.convertDoubleToString(precioUnitario));
			igv = valorVenta*vo.getPorcentajeIGV();
			precioVenta =  valorVenta+igv;
			
			ventaTotal = ventaTotal + valorVenta;
			igvTotal = igvTotal + igv;
			importeTotal = importeTotal + precioVenta;
						
			sj = new StringJoiner(";");
			sj.add(vo.getCodigo());
			sj.add(MoneyUtil.convertDoubleToString(cantidad));
			sj.add(vo.getUnidadMedida());
			sj.add(vo.getNombre());
			sj.add(MoneyUtil.convertDoubleToString(precioUnitario));
			sj.add(MoneyUtil.convertDoubleToString(valorVenta));
			sj.add(MoneyUtil.convertDoubleToString(igv));
			sj.add(MoneyUtil.convertDoubleToString(precioVenta));
			total = total + vo.getImporteTotal();
			//System.out.println("DIAS"+cpVO.getMapDias());
			for (int i = 0; i < listaDias.size(); i++) {
				dia = listaDias.get(i);
				//System.out.println("DIA "+dia);
				sj.add(MoneyUtil.convertDoubleToString(vo.getMapDias().getOrDefault(dia,new Double(0.00))));
			}
			lContenido.add(sj.toString());
		}
		lContenido.add(";;;;TOTALES;"+MoneyUtil.convertDoubleToString(ventaTotal)+";"+MoneyUtil.convertDoubleToString(igvTotal)+";"+MoneyUtil.convertDoubleToString(importeTotal)+";;;;;;;;");
		
		return lContenido;
	}

	private List<String> obtenerListaDias(String fechaInicio, String fechaFin) {
		// Format for input
		DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.FORMAT_DATE_DD_MM_YYYY_01);
		// Parsing the date
		DateTime jFechaInicio = dtf.parseDateTime(fechaInicio);
		DateTime jFechaFin = dtf.parseDateTime(fechaFin);
		DateTimeFormatter dtfOut = null;
		int days = Days.daysBetween(jFechaInicio, jFechaFin).getDays();
		List<String> listaDias = new ArrayList<String>();
		
		for (int i = 0; i <= days; i++) {
			// Format for output
			dtfOut = DateTimeFormat.forPattern(Constants.FORMAT_DATE_DD_MM_YYYY_01);
			listaDias.add(dtfOut.print(jFechaInicio.plusDays(i)));
			// Printing the date
			//sjCabecera.add(listaDias.get(i));
		}
		
		return listaDias;
	}
}
