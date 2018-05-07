package com.sgv.common.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import com.sgv.common.exception.BusinessException;
import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.base.dao.ControlCompraDAO;
import com.sgv.base.dao.ControlVentaDAO;
import com.sgv.base.dao.RegistroFacturadorSunatDAO;
import com.sgv.base.dao.impl.ControlCompraDAOImp;
import com.sgv.base.dao.impl.ControlVentaDAOImp;
import com.sgv.base.dao.impl.RegistroFacturadorSunatDAOImp;
import com.sgv.base.dao.model.ControlVenta;
import com.sgv.base.dao.model.TxxxxBandfact;
import com.sgv.common.constants.Catalogo01SUNAT;
import com.sgv.common.constants.Constants;
import com.sgv.common.constants.TypeAction;
import com.sgv.common.constants.TypeOperationSUNAT;
import com.sgv.common.exception.DocumentoException;
import com.sgv.common.util.DateUtil;
import com.sgv.common.util.FileUtil;
import com.sgv.common.util.SequenceBajaDocumento;
import com.sgv.fakturama.dao.model.FktDocument;

public abstract class  AbstractDocumento {

	protected FktDocument documento;
	protected String nombreBaseDelArchivo; 
	protected ControlCompraDAO controlCompraDAO;
	protected ControlVentaDAO controlVentaDAO;
	protected RegistroFacturadorSunatDAO registroFacturadorSunatDAO;
	private TypeAction accion;
	
	public AbstractDocumento() {
		super();
	}
	public AbstractDocumento(FktDocument documento) {
		this.documento = documento;		
		this.controlCompraDAO = new ControlCompraDAOImp();
		this.controlVentaDAO = new ControlVentaDAOImp();
		this.registroFacturadorSunatDAO = new RegistroFacturadorSunatDAOImp();
		
		//this.nombreBaseDelArchivo = generarNombreArchivo();
	}

	public void generarDocumentoSUNAT(String tipoOperacion) throws DocumentoException, PersistenceException, IOException, BusinessException {
		
		//Validar si se encunetra registrado y enviado
		

		switch (TypeOperationSUNAT.getByName(tipoOperacion)) {
		case ALTA:
			System.out.println("=================>REALIZAR OPERACION DE ALTA.....");
			this.nombreBaseDelArchivo = generarNombreArchivo();
			accion = obtenerAccion();			
			switch (accion) {
			case Create:
				crearArchivoDetalle();		
				crearArchivoCabecera();
				crearArchivoDocumentoRelacionado();
				crearArchivoAdicionalCabecera();
				crearArchivoLeyenda();
				crearArchivoOtrosAdicionales();
				
				//procesos complementarios
				crearRegistrarDocumento();
				break;
			case Update:				
				crearArchivoDetalle();		
				crearArchivoCabecera();
				crearArchivoDocumentoRelacionado();
				crearArchivoAdicionalCabecera();
				crearArchivoLeyenda();
				crearArchivoOtrosAdicionales();
				
				//procesos complementarios
				actualizarRegistrarDocumento();
				break;
			case Error:
				throw new DocumentoException("EL DOCUMENTO HA SIDO REGISTRADO ANTERIORMENTE EN LA SUNAT.");			
			}

			break;
		case BAJA:
			System.out.println("=================>REALIZAR OPERACION DE BAJA.....");
			this.nombreBaseDelArchivo = "NO SE UTILIZA";
			accion = obtenerAccionBaja();
			
			switch (accion) {
			case Create:
				this.nombreBaseDelArchivo = generarNombreArchivoBaja();
				crearArchivoCabeceraBaja();
				
				//procesos complementarios
				crearRegistrarDocumentoBaja();
				break;
			case Update:				
				//crearArchivoCabeceraBaja();
				
				//procesos complementarios
				//actualizarRegistrarDocumentoBaja();
				throw new DocumentoException("El documento ["+documento.getNAME()+"] se encuentra pediente de GENERADO/ENVIADO/ACEPTADO para ser ANULADO.");
			case Error:
				throw new DocumentoException("EL DOCUMENTO HA SIDO REGISTRADO ANTERIORMENTE EN LA SUNAT.");			
			}
			
			break;
		}
		
		documento.setRespuesta("SE CREARON LOS ARCHIVOS \""+nombreBaseDelArchivo+"\" CORRECTAMENTE PARA EL DOCUMENTO : "+documento.getNAME());
		
	}
	
	void crearRegistrarDocumentoBaja() throws PersistenceException {
		ControlVenta item = cargarControlVentaBaja();
		getControlVentaDAO().insertSelective(item);
		System.out.println(cargarRegistroFacturadorSunatCrearBaja());
		getRegistroFacturadorSunatDAO().insertSelective(cargarRegistroFacturadorSunatCrearBaja());
		
		System.out.println("El nuevo ID es ["+item.getCVNT_ID()+"]");
	}

	
	void actualizarRegistrarDocumentoBaja() throws PersistenceException {
		/*
		ControlVenta item = cargarControlVentaBaja();
		getControlVentaDAO().updateByDocumento(item);
		getRegistroFacturadorSunatDAO().updateByPrimaryKeySelective(cargarRegistroFacturadorSunatCrearBaja());
		
		System.out.println("Se Actualizo el documento ["+item.getCVNT_NUM_DOCUMENTO()+"]");
		*/
	}
	private void crearArchivoCabeceraBaja() throws IOException {
		List<String> lContenido = new ArrayList<String>();
		StringJoiner sj = null;
		//String msg = documento.getMESSAGE().trim().toUpperCase();

		//if(msg.startsWith(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS_OC)){
			//documento.setOc(msg.replaceAll(Constants.INDICADOR_DOCUMENTOS_RELACIONADOS_OC, "").trim());
			sj = new StringJoiner("|");
			sj.add(DateUtil.formatDate(documento.getDOCUMENTDATE(), Constants.FORMAT_DATE_YYYY_MM_DD));
			sj.add(DateUtil.formatDate(new Date(), Constants.FORMAT_DATE_YYYY_MM_DD));			
			sj.add(Catalogo01SUNAT.valueOf(documento.getDTYPE()).getText());
			sj.add(documento.getNAME());		
			switch (Catalogo01SUNAT.valueOf(documento.getDTYPE())) {
			case Invoice:
				sj.add("ERROR AL CREAR LA FACTURA.");
				break;
			case Proforma:
				sj.add("ERROR AL CREAR LA BOLETA.");
				break;			
			case Credit:
				sj.add("ERROR AL CREAR LA NOTA DE CREDITO.");	
				break;
			}
			
			System.out.println("FILE_CONTENT : "+sj.toString());
			lContenido.add(sj.toString());
			//System.out.println("FILE_NAME : "+nombreBaseDelArchivo.concat(Constants.ARCHIVO_BAJA_CABECERA_EXTENSION));
			crearArchivo(Constants.FACTURADOR_PATH_FILE, nombreBaseDelArchivo.concat(Constants.ARCHIVO_BAJA_CABECERA_EXTENSION), lContenido.toArray(new String[0]));		
		//}
	}
	private TypeAction obtenerAccion() {
		ControlVenta controlVenta = getControlVentaDAO().selectByDocumento(cargarControlVenta());
		if(null != controlVenta){
			System.out.println("CVNT_TIP_DOCUMENTO ["+controlVenta.getCVNT_TIP_DOCUMENTO()+"] - CVNT_NUM_DOCUMENTO ["+controlVenta.getCVNT_NUM_DOCUMENTO()+"]");
			
			TxxxxBandfact registroFacturadorSunat = getRegistroFacturadorSunatDAO().selectByPrimaryKey(cargarRegistroFacturadorSunatCrear());
			if(null != registroFacturadorSunat && ( 
					Constants.SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT.equals(registroFacturadorSunat.getIND_SITU()) || 
					Constants.SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT_CON_OBS.equals(registroFacturadorSunat.getIND_SITU()))){
				return TypeAction.Error;	
			} else {
				return TypeAction.Update;
			}
		} else {
			return TypeAction.Create;
		}
		
	}
	private TypeAction obtenerAccionBaja() {
		ControlVenta controlVenta = getControlVentaDAO().selectByReference(cargarControlVentaBaja());
		if(null != controlVenta){
			System.out.println("obtenerAccionBaja(): CVNT_TIP_DOCUMENTO ["+controlVenta.getCVNT_TIP_DOCUMENTO()+"] - CVNT_NUM_DOCUMENTO ["+controlVenta.getCVNT_NUM_DOCUMENTO()+"]");
			
			TxxxxBandfact registroFacturadorSunat = getRegistroFacturadorSunatDAO().selectByReference(cargarRegistroFacturadorSunatCrearBaja());
			if(null != registroFacturadorSunat && ( 
					Constants.SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT_BAJA.equals(registroFacturadorSunat.getIND_SITU()) || 
					Constants.SFS_ESTADO_ENVIADO_A_SUNAT_PROCESANDO_BAJA.equals(registroFacturadorSunat.getIND_SITU()))){
				//VALIDAR CAMPOS DE REFERENCIA AL DOCUMENTO ORIGINAL 
				return TypeAction.Error;	
			} else {
				return TypeAction.Update;
			}
		} else {
			//System.out.println("obtenerAccionBaja(): CVNT_TIP_DOCUMENTO ["+controlVenta.getCVNT_TIP_DOCUMENTO()+"] - CVNT_NUM_DOCUMENTO ["+controlVenta.getCVNT_NUM_DOCUMENTO()+"]");
			return TypeAction.Create;
		}
		
	}
	protected TxxxxBandfact cargarRegistroFacturadorSunatCrear() {
		String nombreArchivo = Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR)
				.concat("-")
				.concat(Catalogo01SUNAT.valueOf(documento.getDTYPE()).getText())
				.concat("-")
				.concat(documento.getNAME());
		TxxxxBandfact item = new TxxxxBandfact();		
		item.setTIP_DOCU(Catalogo01SUNAT.valueOf(documento.getDTYPE()).getText());
		item.setNUM_DOCU(documento.getNAME());
		item.setNUM_RUC(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		item.setFEC_CARG(new Date());
		item.setNOM_ARCH(nombreArchivo);
		item.setIND_SITU(Constants.SFS_ESTADO_POR_GENERAR_XML_SUNAT);
		item.setTIP_ARCH(Constants.SFS_TIPO_ARCHIVO_TXT);
		return item;
	}
	protected TxxxxBandfact cargarRegistroFacturadorSunatCrearBaja() {
		TxxxxBandfact item = new TxxxxBandfact();		
		item.setTIP_DOCU(Constants.SFS_TIPO_OPERACION_BAJA);
		item.setNUM_DOCU(nombreBaseDelArchivo.replace(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR).concat("-"), ""));
		item.setNUM_RUC(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		item.setFEC_CARG(new Date());
		item.setNOM_ARCH(nombreBaseDelArchivo);
		item.setIND_SITU(Constants.SFS_ESTADO_POR_GENERAR_XML_SUNAT);
		item.setTIP_ARCH(Constants.SFS_TIPO_ARCHIVO_TXT);
		item.setTIP_DOC_REFERENCIA(Catalogo01SUNAT.valueOf(documento.getDTYPE()).getText());
		item.setNUM_DOC_REFERENCIA(documento.getNAME());
		//CREAR CAMPOS DE REFERENCIA (RUC,TIPO, NUMERO) 
		return item;
	}
	abstract void crearArchivoCabecera() throws DocumentoException, IOException, BusinessException;
	abstract void crearArchivoDetalle() throws DocumentoException, IOException;
	abstract void crearArchivoDocumentoRelacionado() throws DocumentoException, IOException;
	abstract void crearArchivoAdicionalCabecera() throws DocumentoException, IOException;
	abstract void crearArchivoLeyenda() throws DocumentoException, IOException;
	abstract void crearArchivoOtrosAdicionales() throws DocumentoException, IOException;
	
	abstract void crearRegistrarDocumento();
	abstract void actualizarRegistrarDocumento();

	protected ControlVenta cargarControlVenta() {
		ControlVenta item = new ControlVenta();
		
		item.setCVNT_FEC_EMI_DOCUMENTO(documento.getDOCUMENTDATE());
		item.setCVNT_FEC_VEN_DOCUMENTO(documento.getDUEDATE());
		item.setCVNT_TIP_DOCUMENTO((Catalogo01SUNAT.valueOf(documento.getDTYPE())).getText());
		item.setCVNT_NUM_DOCUMENTO(documento.getNAME());
		item.setCVNT_TIP_DOC_RECEPTOR(Constants.CATALOGO_06_RUC);
		item.setCVNT_NUM_DOC_RECEPTOR(documento.getContact().getVATNUMBER());
		item.setCVNT_RAZ_SOC_RECEPTOR(documento.getContact().getCOMPANY());
		item.setCVNT_TIP_DOC_EMISOR(Constants.CATALOGO_06_RUC);
		item.setCVNT_NUM_DOC_EMISOR(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		item.setCVNT_RAZ_SOC_EMISOR(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_NAME));		
		item.setCVNT_VAL_OPE_GRAVADA(documento.getOperacionGravadaTotal());
		item.setCVNT_VAL_OPE_INAFECTA(documento.getOperacionExoneradaTotal());
		item.setCVNT_VAL_OPE_EXONERADA(documento.getOperacionInafectaTotal());
		item.setCVNT_IGV(documento.getIgvTotal());
		item.setCVNT_IMP_TOTAL(documento.getImporteTotal());
		item.setCVNT_ESTADO(Constants.CONTROL_VENTA_ESTADO_REGISTRADO);
		item.setCVNT_PERIDO(documento.getDOCUMENTDATE());
		item.setCVNT_TIP_MONEDA("PE");
		item.setCVNT_FEC_ORD_PEDIDO(documento.getORDERDATE());
		item.setCVNT_FEC_SER_PEDIDO(documento.getSERVICEDATE());
		item.setCVNT_NUM_OC_PEDIDO(documento.getOc());
		item.setCVNT_EST_DOCUMENTO(Constants.ESTADO_DOCUMENTO_REGISTRADO);
		//IDENTIFICAR CUAL DOCUMENTO RELACIONADO
		return item;
	}
	protected ControlVenta cargarControlVentaBaja() {
		ControlVenta item = new ControlVenta();
		Date toDate = new Date();
		item.setCVNT_FEC_EMI_DOCUMENTO(toDate);
		//item.setCVNT_FEC_VEN_DOCUMENTO(documento.getDUEDATE());
		item.setCVNT_TIP_DOCUMENTO(Constants.SFS_TIPO_OPERACION_BAJA);
		item.setCVNT_NUM_DOCUMENTO(nombreBaseDelArchivo.replace(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR).concat("-"), ""));
		//item.setCVNT_TIP_DOC_RECEPTOR(Constants.CATALOGO_06_RUC);
		//item.setCVNT_NUM_DOC_RECEPTOR(documento.getContact().getVATNUMBER());
		//item.setCVNT_RAZ_SOC_RECEPTOR(documento.getContact().getCOMPANY());
		item.setCVNT_TIP_DOC_EMISOR(Constants.CATALOGO_06_RUC);
		item.setCVNT_NUM_DOC_EMISOR(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		item.setCVNT_RAZ_SOC_EMISOR(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_NAME));		
		//item.setCVNT_VAL_OPE_GRAVADA(documento.getOperacionGravadaTotal());
		//item.setCVNT_VAL_OPE_INAFECTA(documento.getOperacionExoneradaTotal());
		//item.setCVNT_VAL_OPE_EXONERADA(documento.getOperacionInafectaTotal());
		//item.setCVNT_IGV(documento.getIgvTotal());
		//item.setCVNT_IMP_TOTAL(documento.getImporteTotal());
		item.setCVNT_ESTADO(Constants.CONTROL_VENTA_ESTADO_REGISTRADO);
		item.setCVNT_PERIDO(toDate);
		//item.setCVNT_TIP_MONEDA("PE");
		//item.setCVNT_FEC_ORD_PEDIDO(documento.getORDERDATE());
		//item.setCVNT_FEC_SER_PEDIDO(documento.getSERVICEDATE());
		//item.setCVNT_NUM_OC_PEDIDO(documento.getOc());
		item.setCVNT_EST_DOCUMENTO(Constants.ESTADO_DOCUMENTO_REGISTRADO);
		item.setCVNT_FEC_DOC_REFERENCIA(documento.getDOCUMENTDATE());
		item.setCVNT_TIP_DOC_REFERENCIA((Catalogo01SUNAT.valueOf(documento.getDTYPE())).getText());		//IDENTIFICAR CUAL DOCUMENTO RELACIONADO
		item.setCVNT_NUM_DOC_REFERENCIA(documento.getNAME());
		return item;
	}
	
	public void crearArchivo(String ruta, String nombreArchivo, String[] contenidoArchivo) throws IOException {
		FileUtil.createFile(ruta, nombreArchivo, contenidoArchivo);		
	}
	private String generarNombreArchivo(){
		String fileName = null;
		StringJoiner sjNombre = new StringJoiner("-");
		sjNombre.add(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		sjNombre.add((Catalogo01SUNAT.valueOf(documento.getDTYPE())).getText());
		sjNombre.add(documento.getNAME());		
		fileName = sjNombre.toString();
		System.out.println("BASE_FILE_NAME : "+fileName);
		return fileName;
	}
	private String generarNombreArchivoBaja(){
		String fileName = null;
		StringJoiner sjNombre = new StringJoiner("-");
		sjNombre.add(Constants.YOURCOMPANY.get(Constants.YOURCOMPANY_COMPANY_VATNR));
		sjNombre.add(Constants.SFS_TIPO_OPERACION_BAJA);
		sjNombre.add(DateUtil.formatDate(new Date(),Constants.FORMAT_DATE_YYYYMMDD));
		sjNombre.add(SequenceBajaDocumento.getInstance().getNextVal());		
		fileName = sjNombre.toString();
		System.out.println("BASE_FILE_NAME : "+fileName);
		return fileName;
	}
	
	public ControlCompraDAO getControlCompraDAO(){
		return this.controlCompraDAO;
	}
	
	public ControlVentaDAO getControlVentaDAO(){
		return this.controlVentaDAO;
	}
	public RegistroFacturadorSunatDAO getRegistroFacturadorSunatDAO() {
		return registroFacturadorSunatDAO;
	}

}