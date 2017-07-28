package com.sgv.common.constants;

import java.util.HashMap;
import java.util.Map;

import com.sgv.fakturama.dao.impl.UserPropertyDAOImpl;

public class Constants {
	
	public static final String FACTURADOR_PATH_FILE = "D:\\sunat_archivos\\sfs\\DATA\\";
	public static final String FACTURADOR_PATH_REPO = "D:\\sunat_archivos\\sfs\\REPO\\";
	public static final String FACTURADOR_PATH_RPTA = "D:\\sunat_archivos\\sfs\\RPTA\\";
	public static final String FAKTURAMA_PATH_BASE = "D:\\WS_FAKTURAMA\\WS_INVERSIONES_UNOCC";
	public static final String FAKTURAMA_PATH_FACTURAS = "\\Documentos\\PDF\\Facturas";	
	public static final String FAKTURAMA_PATH_NOTA_ENVIO = "\\Documentos\\PDF\\Notas de Envío";
	
	public static final String STRING_PIPE = "|";
	
	public static final String REGEXP_BACK_SLASH = "\\";
	public static final String REGEXP_PIPE = "\\|";
	public static final String REGEXP_LETRAS = "[a-zA-Z]";
	public static final String REGEXP_NEW_LINE = "\\n";
	
	public static final String OPE_GRABADAS = "10";
	public static final String OPE_EXONERADAS = "20";
	public static final String OPE_INAFECTAS = "30";
	
	public static final String FORMAT_DATE_DD_MM_YYYY_01 = "dd/MM/yyyy";
	public static final String FORMAT_DATE_DD_MM_YYYY_02 = "dd-MM-yyyy";
	public static final String FORMAT_DATE_DD_MMM_YYYY = "dd-MMM-yyyy";
	public static final String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FORMAT_DATE_DIR = "\\yyyy\\MM\\dd";
	public static final String FORMAT_DATE_DIR_YYYYMM = "\\yyyy\\MM";
	public static final String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";
	
	public static final String VALIDAR_ARCHIVOS_PROCESADOS_ANTERIORMENTE = "T";
	public static final String EMPRESA_RUT = "20477954350";
	
	public static final String TIPO_DOCUMENTO_FACTURA = "01";
	
	public static final String SERIE_FACTURA = "F001";
	
	public static final String TIPO_ARCHIVO_PDF = ".pdf";
	public static final String TIPO_ARCHIVO_ZIP = ".zip";
	
	public static final String EXTENSION_FILE_ACA = "ACA";
	public static final String EXTENSION_FILE_CAB = "CAB";
	public static final String EXTENSION_FILE_DET = "DET";
	public static final String EXTENSION_FILE_LEY = "LEY";
	public static final String EXTENSION_FILE_REL = "REL";
	public static final String EXTENSION_FILE_PDF = "pdf";
	public static final String EXTENSION_FILE_ZIP = "zip";
	
	public static final Map<String, String> EMPRESAS = new HashMap<>();
	static {
		EMPRESAS.put("BAKERY", "REX_BAKERY_PERU_SAC");
		EMPRESAS.put("POSITIVA", "");
		EMPRESAS.put("NEW YORK", "");
		EMPRESAS.put("3 MARES", "");
		EMPRESAS.put("GOL MARINO", "");
		EMPRESAS.put("", "");
	}
	public static final Map<String, String> MESES = new HashMap<>();
	static {
		MESES.put("ENERO", "01");
		MESES.put("FEBRERO", "02");
		MESES.put("MARZO", "03");
		MESES.put("ABRIL", "04");
		MESES.put("MAYO", "05");
		MESES.put("JUNIO", "06");
		MESES.put("JULIO", "07");
		MESES.put("AGOSTO", "08");
		MESES.put("SEPTIEMBRE", "09");
		MESES.put("OCTUBRE", "10");
		MESES.put("NOVIEMBRE", "11");
		MESES.put("DICIEMBRE", "12");
	}

	public static final String UM_SUNAT_UNIDAD = "NIU";
	public static final Map<String, String> UM = new HashMap<>();
	static {
		UM.put("ATD", "PK");
		UM.put("BAL", "BJ");
		UM.put("BLS", "BG");
		UM.put("BOL", "BG");
		UM.put("BOT", "BO");
		UM.put("CAJ", "BX");
		UM.put("FRC", "NIU");
		UM.put("GAL", "GLI");
		UM.put("KG", "KGM");
		UM.put("LAT", "CA");
		UM.put("PQT", "PK");
		UM.put("SOB", "NIU");
		UM.put("UND", "NIU");
		UM.put("LT", "LTR");
		UM.put("GR", "GRM");
		UM.put("DOC", "DZN");
	}
	
	public static final String MESES_[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	public static final String QUINCENA_01[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"};
	public static final String QUINCENA_02[] = {"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

	public static final Map<String, String> PRODUCTOS = new HashMap<>();
	static {
		PRODUCTOS.put("AZUCAR RUBIA", "001");
		PRODUCTOS.put("GELATINA DE COCO", "002");
		PRODUCTOS.put("GELATINA DE FRESAX KLG.", "003");
		
	}
	

	
	public static final String CATALOGO_17_VENTA_INTERNA = "01";
	public static final String CATALOGO_17_NO_DOMICILIADOS = "03";
	public static final String CATALOGO_06_RUC = "6";
	public static final String CATALOGO_06_SIN_RUC = "0";
	public static final String CATALOGO_06_DNI = "1";
	public static final String CABECERA_CODIGO_DOMICILIO_FISCAL_00_SIN_DIRECCION = "0";
	public static final String CABECERA_CODIGO_DOMICILIO_FISCAL_01_PRIMERA_DIRECCION = "1";
	public static final String CABECERA_TIPO_MONEDA_PERU = "PEN";
	public static final String CABECERA_CTE_DESCUENTO_GLOBAL = "DSG";
	public static final String CABECERA_CTE_SUMATORIA_OTROS_CARGOS = "SOC";
	public static final String CABECERA_CTE_TOTAL_DESCUENTOS = "TDS";
	public static final String CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_GRABADAS = "TOG";
	public static final String CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS = "TOI";
	public static final String CABECERA_CTE_TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS = "TOE";
	public static final String CABECERA_CTE_SUMATORIA_IGV = "IGV";
	public static final String CABECERA_CTE_SUMATORIA_ISC = "ISC";
	public static final String CABECERA_CTE_SUMATORIA_OTROS_TRIBUTOS = "SOT";
	public static final String CABECERA_CTE_IMPORTE_TOTAL = "ITT";

	public static final String YOURCOMPANY_COMPANY_VATNR = "YOURCOMPANY_COMPANY_VATNR";
	public static final String YOURCOMPANY_COMPANY_NAME = "YOURCOMPANY_COMPANY_NAME";
	

	public static final Map<String, String> YOURCOMPANY = new HashMap<>();
	static {
		UserPropertyDAOImpl dao = new UserPropertyDAOImpl();
		YOURCOMPANY.putAll(dao.selectByLikeName("YOURCOMPANY_"));
	}
	
	public static final String ARCHIVO_CABECERA_EXTENSION = ".CAB";
	public static final String ARCHIVO_DETALLE_EXTENSION = ".DET";
	public static final String ARCHIVO_RELACIONADO_EXTENSION = ".REL";
	public static final String ARCHIVO_ADICIONAL_CABECERA_EXTENSION = ".ACA";
	public static final String ARCHIVO_LEYENDAS_EXTENSION = ".LEY";
	
	public static final String ARCHIVO_BAJA_CABECERA_EXTENSION = ".CBA";
	public static final String ARCHIVO_NOTA_CREDITO_CABECERA_EXTENSION = ".NOT";
	
	public static final String INDICADOR_DOCUMENTOS_RELACIONADOS_OC = "OC";
	public static final Map<String, String> INDICADOR_DOCUMENTOS_RELACIONADOS = new HashMap<>();
	static {
		INDICADOR_DOCUMENTOS_RELACIONADOS.put("GUIA", "1");
		INDICADOR_DOCUMENTOS_RELACIONADOS.put("ANTICIPO", "2");
		INDICADOR_DOCUMENTOS_RELACIONADOS.put("OC", "3");
		INDICADOR_DOCUMENTOS_RELACIONADOS.put("OTROS", "99");
	}
	
	public static final Map<String, String> CATALOGO_17 = new HashMap<>();
	static {
		CATALOGO_17.put("VENTA INTERNA","01");
		CATALOGO_17.put("EXPORTACION","02");
		CATALOGO_17.put("NO DOMICILIADOS","03");
		CATALOGO_17.put("VENTA INTERNA - ANTICIPOS","04");
		CATALOGO_17.put("VENTA INTENERANTE","05");
		CATALOGO_17.put("FACTURA GUIA","06");
		CATALOGO_17.put("VENTA ARROZ PILADO","07");
		CATALOGO_17.put("FACTURA - COMPROBANTE DE PERCEPCION","08");
		CATALOGO_17.put("FACTURA - GUIA REMITENTE","10");
		CATALOGO_17.put("FACTURA - GUIA TRANSPORTISTA","11");
		CATALOGO_17.put("BOLETA DE VENTA - COMPROBANTE DE PERCEPCION","12");
	}
	
	public static final String CATALOGO_12_OTROS = "OTROS";
	public static final Map<String, String> CATALOGO_12 = new HashMap<>();
	static {
		CATALOGO_12.put("FACTURA – EMITIDA POR CORREGIR ERROR EN EL RUC","01");
		CATALOGO_12.put("FACTURA - EMITIDA POR ANTICIPOS","02");
		CATALOGO_12.put("BOLETA DE VENTA - EMITIDA POR ANTICIPOS","03");
		CATALOGO_12.put("TICKECT DE SALIDA - NAPU","04");
		CATALOGO_12.put("CODIGO SCOP","05");
		CATALOGO_12.put("OTROS","99");
	}
	
	public static final String CATALOGO_15_MONTO_EN_LETRAS = "MONTO EN LETRAS";
	public static final Map<String, String> CATALOGO_15 = new HashMap<>();
	static {
		CATALOGO_15.put("MONTO EN LETRAS","1000");
	}
	
	public static final String CATALOGO_07_GRAVADO = "GRAVADO - OPERACION ONEROSA";
	public static final String CATALOGO_07_EXONERADO = "EXONERADO - OPERACION ONEROSA";
	public static final String CATALOGO_07_INAFECTO = "INAFECTO - OPERACION ONEROSA";
	public static final Map<String, String> CATALOGO_07 = new HashMap<>();
	static {
		CATALOGO_07.put("GRAVADO - OPERACION ONEROSA","10");
		CATALOGO_07.put("EXONERADO - OPERACION ONEROSA","20");
		CATALOGO_07.put("INAFECTO - OPERACION ONEROSA","30");
	}
	public static final String VALOR_CERO_STRING = "0.0";
	public static final Double VALOR_CERO_DOUBLE = new Double(0.0);
	
	public static final String CATALOGO_08_SISTEMA_AL_VALOR = "01";
	/*
	public static final String CATALOGO_08_SISTEMA_AL_VALOR = "SISTEMA AL VALOR";
	public static final Map<String, String> CATALOGO_08 = new HashMap<>();
	static {
		CATALOGO_08.put("SISTEMA AL VALOR","01");
	}
	*/
	public static final String CONTROL_VENTA_ESTADO_REGISTRADO = "01"; //REGISTRADO EN LA TABLA
	public static final String CONTROL_VENTA_ESTADO_PROCESADO_CON_ERROR = "02";//PROCESADO EN EL FACTURADOR CON ERROR
	public static final String CONTROL_VENTA_ESTADO_PROCESADO = "03"; //PROCESADO EN EL FACTURADOR
	public static final String ESTADO_DOCUMENTO_REGISTRADO = "01"; //GENERADO
	public static final String ESTADO_DOCUMENTO_RECHAZADO = "02"; //RECHAZADO POR SUNAT
	public static final String ESTADO_DOCUMENTO_ACEPTADO = "03"; //ACEPTADO POR SUNAT
	public static final String ESTADO_DOCUMENTO_ANULADO = "04"; //ANULADO
	
	public static final String SFS_ESTADO_POR_GENERAR_XML_SUNAT = "01";
	public static final String SFS_ESTADO_XML_GENERADO_SUNAT = "02";
	public static final String SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT = "03";
	public static final String SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT_CON_OBS = "04";
	
	public static final String SFS_TIPO_ARCHIVO_TXT = "TXT";
	
	public static final String SFS_TIPO_OPERACION_BAJA = "RA";
	public static final String SFS_ESTADO_ENVIADO_ACEPTADO_SUNAT_BAJA = "03";
	//Enviado a SUNAT Procesando
	public static final String SFS_ESTADO_ENVIADO_A_SUNAT_PROCESANDO_BAJA = "09";
	
	public static final String CATALOGO_09_ANULACION_DE_OPERACION = "01";
	public static final String CATALOGO_09_ANULACION_POR_ERROR_EN_EL_RUC = "02";
	public static final String CATALOGO_09_CORRECION_POR_ERROR_EN_LA_DESCRIPCION = "03";
	public static final String CATALOGO_09_DESCUENTO_GLOBAL = "04";
	public static final String CATALOGO_09_DESCUENTO_POR_ITEM = "05";
	public static final String CATALOGO_09_DEVOLUCION_TOTAL = "06";
	public static final String CATALOGO_09_DEVOLUCION_POR_ITEM = "07";
	public static final String FAKTURAMA_TIPO_DOCUMENTO_ORDER = "Order";
	
	
}
