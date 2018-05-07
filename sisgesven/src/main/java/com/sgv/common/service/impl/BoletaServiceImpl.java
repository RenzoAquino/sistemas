package com.sgv.common.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.model.ControlVenta;
import com.sgv.common.constants.Constants;
import com.sgv.common.service.DocumentoService;
import com.sgv.common.util.DateUtil;
import com.sgv.common.util.MoneyUtil;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.model.FktDocument;
import com.sgv.fakturama.dao.model.FktDocumentitem;

public class BoletaServiceImpl extends AbstractDocumento implements DocumentoService {

	boolean conDireccionFiscal = true;
	public BoletaServiceImpl(){		
		super();
	}
	public BoletaServiceImpl(FktDocument document){
		super(document);
	}
	void crearArchivoCabecera() throws IOException {
		List<String> lContenido = new ArrayList<String>();
		//String text = null;
		StringJoiner sj = new StringJoiner("|");
		sj.add(Constants.CATALOGO_17_NO_DOMICILIADOS);
		sj.add(DateUtil.formatDate(documento.getDOCUMENTDATE(),Constants.FORMAT_DATE_YYYY_MM_DD));

        if(documento.getContact().getGENDER() == 3){//TIPO EMPRESA
            sj.add(Constants.CABECERA_CODIGO_DOMICILIO_FISCAL_01_PRIMERA_DIRECCION);
            sj.add(Constants.CATALOGO_06_RUC);
            sj.add(documento.getContact().getVATNUMBER());
            sj.add(documento.getContact().getCOMPANY());
        } else if(documento.getContact().getGENDER() == 0){//TIPO CLIENTE GENERICO
            sj.add(Constants.CABECERA_CODIGO_DOMICILIO_FISCAL_00_SIN_DIRECCION);
            sj.add(Constants.CATALOGO_06_SIN_RUC);
            //sj.add("00000000");
            //sj.add("SIN DNI");
            sj.add(documento.getContact().getVATNUMBER());
            sj.add(documento.getContact().getCOMPANY());
            conDireccionFiscal = false;
        } else {//TIPO HOMBRE, MUJER, FAMILIA
            if(documento.getContact().getVATNUMBER().length() != 8 ){
                sj.add(Constants.CABECERA_CODIGO_DOMICILIO_FISCAL_00_SIN_DIRECCION);
                sj.add(Constants.CATALOGO_06_DNI);
                conDireccionFiscal = false;
            } else if(documento.getContact().getVATNUMBER().length() != 11 ) {
                sj.add(Constants.CABECERA_CODIGO_DOMICILIO_FISCAL_01_PRIMERA_DIRECCION);
                sj.add(Constants.CATALOGO_06_RUC);
            }
            sj.add(documento.getContact().getVATNUMBER());
            sj.add(documento.getContact().getFIRSTNAME().concat(", ").concat(documento.getContact().getNAME()));
        }

		sj.add(Constants.CABECERA_TIPO_MONEDA_PERU);
		//sj.add(Constants.CABECERA_CTE_DESCUENTO_GLOBAL);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_SUMATORIA_OTROS_CARGOS);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_TOTAL_DESCUENTOS);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_GRABADAS);
		sj.add(MoneyUtil.convertDoubleToString(documento.getOperacionGravadaTotal()));
		//sj.add(Constants.CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS);
		sj.add(MoneyUtil.convertDoubleToString(documento.getOperacionExoneradaTotal()));
		//sj.add(Constants.CABECERA_CTE_SUMATORIA_IGV);
		sj.add(MoneyUtil.convertDoubleToString(documento.getIgvTotal()));
		//sj.add(Constants.CABECERA_CTE_SUMATORIA_ISC);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_SUMATORIA_OTROS_TRIBUTOS);
		sj.add(Constants.VALOR_CERO_STRING);
		//sj.add(Constants.CABECERA_CTE_IMPORTE_TOTAL);
		sj.add(MoneyUtil.convertDoubleToString(documento.getImporteTotal()));

		System.out.println("FILE_CONTENT : "+sj.toString());
		lContenido.add(sj.toString());
		
		crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_CABECERA_EXTENSION), lContenido.toArray(new String[0]));		
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
        if(conDireccionFiscal){
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
			sj.add(" ");
			System.out.println("FILE_CONTENT : "+sj.toString());
			lContenido.add(sj.toString());
			
			crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_ADICIONAL_CABECERA_EXTENSION), lContenido.toArray(new String[0]));
		}
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
