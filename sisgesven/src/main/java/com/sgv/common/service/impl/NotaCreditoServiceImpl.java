package com.sgv.common.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.model.ControlVenta;
import com.sgv.common.constants.Catalogo01SUNAT;
import com.sgv.common.constants.Constants;
import com.sgv.common.exception.DocumentoException;
import com.sgv.common.service.DocumentoService;
import com.sgv.common.util.DateUtil;
import com.sgv.common.util.MoneyUtil;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.DocumentDAO;
import com.sgv.fakturama.dao.impl.DocumentoDAOImpl;
import com.sgv.fakturama.dao.model.FktDocument;
import com.sgv.fakturama.dao.model.FktDocumentitem;

public class NotaCreditoServiceImpl extends AbstractDocumento implements DocumentoService {

	public NotaCreditoServiceImpl(){		
		super();
	}
	public NotaCreditoServiceImpl(FktDocument document){
		super(document);
	}
	void crearArchivoCabecera() throws DocumentoException, IOException {
		
		DocumentDAO dao = new DocumentoDAOImpl();
		FktDocument referencia = dao.selectById(documento.getFK_SRCDOCUMENT());
		System.out.println("******"+referencia.getDTYPE());
		switch (Catalogo01SUNAT.valueOf(referencia.getDTYPE())) {
		case Invoice:
			
			List<String> lContenido = new ArrayList<String>();
			//String text = null;
			StringJoiner sj = new StringJoiner("|");
			sj.add(DateUtil.formatDate(documento.getDOCUMENTDATE(),Constants.FORMAT_DATE_YYYY_MM_DD));
			sj.add(Constants.CATALOGO_09_DEVOLUCION_POR_ITEM);
			sj.add("ERROR AL INGRESAR PRODUCTO");
			sj.add((Catalogo01SUNAT.valueOf(referencia.getDTYPE())).getText());//tipo de documento(Factura,boleta, maq registradora) emisor
			sj.add(referencia.getNAME());//numero de documento(Factura) emisor
			sj.add(Constants.CATALOGO_06_RUC);
			sj.add(documento.getContact().getVATNUMBER());
			sj.add(documento.getContact().getCOMPANY());
			sj.add(Constants.CABECERA_TIPO_MONEDA_PERU);
			sj.add(Constants.VALOR_CERO_STRING);//SUMATORIO OTROS CARGOS
			sj.add(MoneyUtil.convertDoubleToString(documento.getOperacionGravadaTotal()));//OPERACIONES GRABADAS
			sj.add(Constants.VALOR_CERO_STRING);//OPERACIONES INAFECTAS
			sj.add(MoneyUtil.convertDoubleToString(documento.getOperacionExoneradaTotal()));//OPERACIONES EXONERADAS
			sj.add(MoneyUtil.convertDoubleToString(documento.getIgvTotal()));//IGV
			sj.add(Constants.VALOR_CERO_STRING);//ISC
			sj.add(Constants.VALOR_CERO_STRING);//SUMATORIA OTROS TRIBUTOS
			sj.add(MoneyUtil.convertDoubleToString(documento.getImporteTotal()));//IMPORTE TOTAL
			
			System.out.println("FILE_CONTENT : "+sj.toString());
			lContenido.add(sj.toString());
			
			crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_NOTA_CREDITO_CABECERA_EXTENSION), lContenido.toArray(new String[0]));
			break;

		default:
			throw new DocumentoException("TIPO DE DOCUMENTO ["+referencia.getDTYPE()+"] REFERENCIADO ES INVADLIDO.");
		}
		
				
	}
	/* (non-Javadoc)
	 * @see com.sgv.common.service.impl.DocumentoService#obtenerDocumento(com.sgv.common.vo.DocumentoVO)
	 */
	@Override
	public DocumentoVO obtenerDocumento(DocumentoVO documento){
		return null;
	}
	/* (non-Javadoc)
	 * @see com.sgv.common.service.impl.DocumentoService#obtenerListadoDocumento(com.sgv.common.vo.DocumentoVO)
	 */
	@Override
	public List<DocumentoVO> obtenerListadoDocumento(DocumentoVO documento){
		return null;
	}
	@Override
	void crearArchivoDetalle() throws IOException {
		List<String> lContenido = new ArrayList<String>();
		StringJoiner sj = null;
		boolean  esOperacionExonerada =  false;		
		Double cantidad = null;
		Double valorInicial = null;
		Double descuento = null;
		Double valor = null;
		Double igvItem = null;
		Double valorItem = null;
		Double precioItem = null;
		
		Double operacionGravadaTotal = 0.0;
		Double operacionExoneradaTotal = 0.0;
		Double igvTotal = 0.0;
		Double importeTotal = 0.0;
		
		List<FktDocumentitem> lista = documento.getItems();
		for (FktDocumentitem item : lista) {
			
			//Constants.UM.getOrDefault(item.getQUANTITYUNIT(),"NIU");		
			//String um = (null != Constants.UM.get(item.getQUANTITYUNIT()))?Constants.UM.get(item.getQUANTITYUNIT()): Constants.UM.get("UND");
			
			cantidad = item.getQUANTITY();
			valorInicial = item.getPRICE();
			descuento = Math.abs(valorInicial*-item.getITEMREBATE());
			valor = (valorInicial-descuento); //valorInicial;
			igvItem = ((cantidad*valor)*item.getVat().getTAXVALUE());
			valorItem = cantidad*valor;
			precioItem = valorItem+igvItem;
			
			esOperacionExonerada =  item.getVat().getTAXVALUE().equals(Constants.VALOR_CERO_DOUBLE);
			if(esOperacionExonerada){
				operacionExoneradaTotal = operacionExoneradaTotal + valorItem;
			} else {
				operacionGravadaTotal = operacionGravadaTotal + valorItem;
			}
			igvTotal = igvTotal +igvItem;
			importeTotal = importeTotal + precioItem;
			
			sj = new StringJoiner("|");
			sj.add(Constants.UM.getOrDefault(item.getQUANTITYUNIT(),Constants.UM_SUNAT_UNIDAD));
			sj.add(MoneyUtil.convertDoubleToString(cantidad));
			sj.add(item.getITEMNUMBER());
			sj.add("");
			sj.add(item.getNAME());
			sj.add(MoneyUtil.convertDoubleToString(valorInicial));
			sj.add(MoneyUtil.convertDoubleToString(descuento));
			sj.add(MoneyUtil.convertDoubleToString(igvItem));
			sj.add((esOperacionExonerada)?Constants.CATALOGO_07.get(Constants.CATALOGO_07_EXONERADO):Constants.CATALOGO_07.get(Constants.CATALOGO_07_GRAVADO));
			sj.add(Constants.VALOR_CERO_STRING);
			sj.add(Constants.CATALOGO_08_SISTEMA_AL_VALOR);
			sj.add(MoneyUtil.convertDoubleToString(precioItem));
			sj.add(MoneyUtil.convertDoubleToString(valorItem));			
			System.out.println("FILE_CONTENT : "+sj.toString());
			lContenido.add(sj.toString());
		}
		
		documento.setOperacionExoneradaTotal(operacionExoneradaTotal);
		documento.setOperacionGravadaTotal(operacionGravadaTotal);
		documento.setIgvTotal(igvTotal);
		documento.setImporteTotal(importeTotal);
		
		crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_DETALLE_EXTENSION), lContenido.toArray(new String[0]));		
	}

	@Override
	void crearArchivoDocumentoRelacionado() throws IOException {
		List<String> lContenido = new ArrayList<String>();
		StringJoiner sj = null;
		String msg = documento.getMESSAGE().trim().toUpperCase();

		if(msg.startsWith(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS_OC)){
			documento.setOc(msg.replaceAll(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS_OC, "").trim());
			sj = new StringJoiner("|");
			sj.add(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS.get(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS_OC));
			sj.add(Constants.CATALOGO_12.get(Constants.CATALOGO_12_OTROS));
			sj.add(documento.getOc());
			sj.add("0");
			sj.add("0");
			sj.add("0");
			System.out.println("FILE_CONTENT : "+sj.toString());
			lContenido.add(sj.toString());
			
			crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_RELACIONADO_EXTENSION), lContenido.toArray(new String[0]));		
		}
	}
	@Override
	void crearArchivoAdicionalCabecera() throws IOException {
		List<String> lContenido = new ArrayList<String>();
		StringJoiner sj = new StringJoiner("|");
		sj.add("0");
		sj.add("0");
		sj.add("0");
		sj.add("0");
		sj.add("0");
		sj.add("0");
		sj.add(documento.getContact().getAddress().getCOUNTRYCODE());
		sj.add(documento.getContact().getAddress().getZIP());
		sj.add(documento.getContact().getAddress().getSTREET());
		sj.add(documento.getContact().getAddress().getCOUNTRYCODE());
		sj.add(documento.getContact().getAddress().getZIP());
		sj.add(documento.getContact().getAddress().getSTREET());
		sj.add(DateUtil.formatDate(documento.getDUEDATE(),Constants.FORMAT_DATE_YYYY_MM_DD));
		System.out.println("FILE_CONTENT : "+sj.toString());
		lContenido.add(sj.toString());
		
		crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_ADICIONAL_CABECERA_EXTENSION), lContenido.toArray(new String[0]));			
	}
	@Override
	void crearArchivoLeyenda() throws IOException {
		String monto = MoneyUtil.convertirNumeroAPalabra(documento.getImporteTotal(), false).toUpperCase();
		List<String> lContenido = new ArrayList<String>();
		StringJoiner sj = new StringJoiner("|");
		sj.add(Constants.CATALOGO_15.get(Constants.CATALOGO_15_MONTO_EN_LETRAS));
		sj.add(monto);

		System.out.println("FILE_CONTENT : "+sj.toString());
		lContenido.add(sj.toString());
		
		crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_LEYENDAS_EXTENSION), lContenido.toArray(new String[0]));			
	}
	@Override
	void crearArchivoOtrosAdicionales() {
		//NO SE IMPLEMENTA
	}
	@Override
	void crearRegistrarDocumento() throws PersistenceException {
		ControlVenta item = cargarControlVenta();
		getControlVentaDAO().insertSelective(item);
		getRegistroFacturadorSunatDAO().insertSelective(cargarRegistroFacturadorSunatCrear());
		
		System.out.println("El nuevo ID es ["+item.getCVNT_ID()+"]");
	}

	@Override
	void actualizarRegistrarDocumento() throws PersistenceException {
		ControlVenta item = cargarControlVenta();
		getControlVentaDAO().updateByDocumento(item);
		getRegistroFacturadorSunatDAO().updateByPrimaryKeySelective(cargarRegistroFacturadorSunatCrear());
		
		System.out.println("Se Actualizo el documento ["+item.getCVNT_NUM_DOCUMENTO()+"]");
	}
}
