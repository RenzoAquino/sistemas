package commons;

import models.sgv.Secuencia;

public class Constantes {

    public static final String XPATH_XML_FIRMADO_HASH_SFS = "/Invoice/UBLExtensions/UBLExtension/ExtensionContent/Signature/SignedInfo/Reference/DigestValue";
    public static final String RUTA_XML_FIRMADO_SFS = "D:\\SISGESVEN\\SFS\\sunat_archivos\\sfs\\FIRMA\\";
    public static final String RUTA_BASE_TICKET = "D:\\SISGESVEN\\TICKETS\\";

    //public static final String URL_GENERAR_XML_SFS = "http://localhost:9999/FacturadorSunat/generarXml.htm";
    //public static final String URL_ACTUALIZAR_DB_SFS = "http://localhost:9999/FacturadorSunat/index.htm";
    public static final String URL_GENERAR_XML_SFS = "http://localhost:9999/api/GenerarComprobante.htm";
    public static final String URL_ACTUALIZAR_DB_SFS = "http://localhost:9999/api/ActualizarPantalla.htm";

    public static final String URL_GENERAR_TXT_ALTA_SUNAT = "http://localhost:8092/sisgesven/enviarDocumentoSUNAT";
    public static final String WEB_UNIR_PARAMETRO = "&";
    public static final String WEB_UNIR_PARAMETRO_JSON = ",";
    public static final String WEB_TIPO_ENVIO_GET = "GET";
    public static final String WEB_TIPO_ENVIO_POST = "POST";


    public static final String YOURCOMPANY_COMPANY_BANK      = "YOURCOMPANY_COMPANY_BANK";
    public static final String YOURCOMPANY_COMPANY_BIC       = "YOURCOMPANY_COMPANY_BIC";
    public static final String YOURCOMPANY_COMPANY_CITY      = "YOURCOMPANY_COMPANY_CITY";
    public static final String YOURCOMPANY_COMPANY_COUNTRY   = "YOURCOMPANY_COMPANY_COUNTRY";
    public static final String YOURCOMPANY_COMPANY_EMAIL     = "YOURCOMPANY_COMPANY_EMAIL";
    public static final String YOURCOMPANY_COMPANY_FAX       = "YOURCOMPANY_COMPANY_FAX";
    public static final String YOURCOMPANY_COMPANY_IBAN      = "YOURCOMPANY_COMPANY_IBAN";
    public static final String YOURCOMPANY_COMPANY_NAME      = "YOURCOMPANY_COMPANY_NAME";
    public static final String YOURCOMPANY_COMPANY_OWNER     = "YOURCOMPANY_COMPANY_OWNER";
    public static final String YOURCOMPANY_COMPANY_STREET    = "YOURCOMPANY_COMPANY_STREET";
    public static final String YOURCOMPANY_COMPANY_TAXOFFICE = "YOURCOMPANY_COMPANY_TAXOFFICE";
    public static final String YOURCOMPANY_COMPANY_TEL       = "YOURCOMPANY_COMPANY_TEL";
    public static final String YOURCOMPANY_COMPANY_VATNR     = "YOURCOMPANY_COMPANY_VATNR";
    public static final String YOURCOMPANY_COMPANY_WEBSITE   = "YOURCOMPANY_COMPANY_WEBSITE";
    public static final String YOURCOMPANY_COMPANY_ZIP       = "YOURCOMPANY_COMPANY_ZIP";



    public static final String PALABRA_ELECTRONICA = "ELECTRONICA";

    public static final String NOMBRE_ARCHIVO_TXT = "ticket.txt";
    public static final String NOMBRE_ARCHIVO_PDF = "ticket.pdf";
    public static final String NOMBRE_IMPRESORA = "BIXOLON SRP-270";

    public static final String DB_ID_FAKTURAMA01 = "fakturama01";
    public static final String DB_ID_SGV = "sgv";
    public static final String DB_ID_FACTURADOR_SUNAT = "facturador";


    public static final String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";

    public static final String RUTA_ARCHIVO_CSV = "D:\\SISGESVEN\\archivoCSV.csv";

    public static final String EXTENSION_CSV = ".CSV";
    public static final String EXTENSION_XML = ".xml";

    public static final String SELECT_LIBRO_VENTA = "CVNT_FEC_EMI_DOCUMENTO, CVNT_NUM_DOCUMENTO, CVNT_NUM_DOC_EMISOR, CVNT_RAZ_SOC_EMISOR, " +
            "CVNT_NUM_DOC_RECEPTOR, CVNT_RAZ_SOC_RECEPTOR, " +
            "CVNT_VAL_OPE_GRAVADA, CVNT_VAL_OPE_EXONERADA, CVNT_VAL_OPE_INAFECTA, CVNT_IGV, CVNT_IMP_TOTAL";

    public static final String SELECT_ANULACIONES = "CVNT_FEC_EMI_DOCUMENTO, CVNT_NUM_DOCUMENTO, CVNT_FEC_DOC_REFERENCIA, CVNT_TIP_DOC_REFERENCIA, CVNT_NUM_DOC_REFERENCIA";

    public static final String SELECT_BASE_PARAMETROS = "ruc, codigo, codigo_padre, valor";



    public static final String CABECERA_CSV_LIBRO_VENTA = "FECHA EMISION; NUMERO DOCUMENTO; NUMERO DOCUMENTO EMISOR; RAZON SOCIAL EMISOR; " +
            "NUMERO DOCUMENTO RECEPTOR; RAZON SOCIAL RECEPTOR; " +
            "OPERACION GRAVADA; OPERACION EXONERADA; OPERACION INAFECTA; IGV; IMPORTE TOTAL\n";

    public static final String CABECERA_CSV_ANULACIONES = "FECHA EMISION; NUMERO DOCUMENTO; FECHA DE DOCUMENTO ANULADO;  TIPO DE DOCUMENTO; NUMERO DOCUMENTO ANULADO\n";



    public static final String PARAMETRO_TIPO_CONTACTO = "TBL_TIPO_CONTACTO";
    public static final String PARAMETRO_TIPO_PERSONA = "TBL_TIPO_PERSONA";

    public static final String PARAMETRO_CODIGO_TIPO_PERSONA_NATURAL = "01";
    public static final String PARAMETRO_CODIGO_TIPO_PERSONA_JURIDICA = "02";

    public static final String PARAMETRO_CODIGO_TIPO_CONTACTO_CLIENTE = "01";
    public static final String PARAMETRO_CODIGO_TIPO_CONTACTO_PROVEEDOR = "02";

    public static final String PARAMETRO_FORMATO_CODIGO = "TBL_FORMATO_CODIGO";
    public static final String PARAMETRO_CODIGO_FORMATO_CLIENTE = "01";
    public static final String PARAMETRO_CODIGO_FORMATO_PROVEEDOR = "02";
    public static final String MAP_SEQ_TIPO_CLIENTE = "TBL_FORMATO_CODIGO_01";
    public static final String MAP_SEQ_TIPO_PROVEEDOR = "TBL_FORMATO_CODIGO_02";
}
