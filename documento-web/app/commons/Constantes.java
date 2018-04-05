package commons;

public class Constantes {

    public static String YOURCOMPANY_COMPANY_BANK      = "YOURCOMPANY_COMPANY_BANK";
    public static String YOURCOMPANY_COMPANY_BIC       = "YOURCOMPANY_COMPANY_BIC";
    public static String YOURCOMPANY_COMPANY_CITY      = "YOURCOMPANY_COMPANY_CITY";
    public static String YOURCOMPANY_COMPANY_COUNTRY   = "YOURCOMPANY_COMPANY_COUNTRY";
    public static String YOURCOMPANY_COMPANY_EMAIL     = "YOURCOMPANY_COMPANY_EMAIL";
    public static String YOURCOMPANY_COMPANY_FAX       = "YOURCOMPANY_COMPANY_FAX";
    public static String YOURCOMPANY_COMPANY_IBAN      = "YOURCOMPANY_COMPANY_IBAN";
    public static String YOURCOMPANY_COMPANY_NAME      = "YOURCOMPANY_COMPANY_NAME";
    public static String YOURCOMPANY_COMPANY_OWNER     = "YOURCOMPANY_COMPANY_OWNER";
    public static String YOURCOMPANY_COMPANY_STREET    = "YOURCOMPANY_COMPANY_STREET";
    public static String YOURCOMPANY_COMPANY_TAXOFFICE = "YOURCOMPANY_COMPANY_TAXOFFICE";
    public static String YOURCOMPANY_COMPANY_TEL       = "YOURCOMPANY_COMPANY_TEL";
    public static String YOURCOMPANY_COMPANY_VATNR     = "YOURCOMPANY_COMPANY_VATNR";
    public static String YOURCOMPANY_COMPANY_WEBSITE   = "YOURCOMPANY_COMPANY_WEBSITE";
    public static String YOURCOMPANY_COMPANY_ZIP       = "YOURCOMPANY_COMPANY_ZIP";


    public static String NOMBRE_ARCHIVO_TXT = "ticket.txt";
    public static String NOMBRE_ARCHIVO_PDF = "ticket.pdf";
    public static String NOMBRE_IMPRESORA = "BIXOLON SRP-270";

    public static String DB_ID_FAKTURAMA = "fakturama";
    public static String DB_ID_SGV = "sgv";
    public static String DB_ID_FACTURADOR_SUNAT = "facturador";

    public static String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";

    public static String RUTA_ARCHIVO_CSV = "D:\\SISGESVEN\\archivoCSV.csv";

    public static final String EXTENSION_CSV = ".CSV";

    public static String SELECT_LIBRO_VENTA = "CVNT_FEC_EMI_DOCUMENTO, CVNT_NUM_DOCUMENTO, CVNT_NUM_DOC_EMISOR, CVNT_RAZ_SOC_EMISOR, " +
            "CVNT_NUM_DOC_RECEPTOR, CVNT_RAZ_SOC_RECEPTOR, " +
            "CVNT_VAL_OPE_GRAVADA, CVNT_VAL_OPE_EXONERADA, CVNT_VAL_OPE_INAFECTA, CVNT_IGV, CVNT_IMP_TOTAL";

    public static String SELECT_ANULACIONES = "CVNT_FEC_EMI_DOCUMENTO, CVNT_NUM_DOCUMENTO, CVNT_FEC_DOC_REFERENCIA, CVNT_TIP_DOC_REFERENCIA, CVNT_NUM_DOC_REFERENCIA";

    public static String CABECERA_CSV_LIBRO_VENTA = "FECHA EMISION; NUMERO DOCUMENTO; NUMERO DOCUMENTO EMISOR; RAZON SOCIAL EMISOR; " +
            "NUMERO DOCUMENTO RECEPTOR; RAZON SOCIAL RECEPTOR; " +
            "OPERACION GRAVADA; OPERACION EXONERADA; OPERACION INAFECTA; IGV; IMPORTE TOTAL\n";

    public static String CABECERA_CSV_ANULACIONES = "FECHA EMISION; NUMERO DOCUMENTO; FECHA DE DOCUMENTO ANULADO;  TIPO DE DOCUMENTO; NUMERO DOCUMENTO ANULADO\n";
}
