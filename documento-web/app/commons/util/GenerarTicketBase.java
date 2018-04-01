package commons.util;

import commons.TypeDocument_ES;
import commons.util.impresion.pos.Extenso;
import commons.util.impresion.pos.TicketMatrix;
import models.fakturama.FktDocument;

public abstract class GenerarTicketBase {

    public static int PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA = 40;
    public static int PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL = (4+1); //CABECERA PRINCIPAL + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO = (2+0); //CABECERA DE DOCUMENTO + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_DETALLE = (1+3+1); //CABECERA DE DETALLE + LINEAS + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_PIE = (2); //PIE TICKET
    public static int PARAM_TICKET_LINEAS_ESPACIOS_BLANCO = (10); //ESPACIOS EN BLANCO DE PIE DE TICKET
    public static int PARAM_TICKET_LINEAS_TOTALES = (4); //ESPACIOS DE LOS TOTALES DE PIE DE TICKET



    public static final String TICKET_ETIQUETA_TELEFONO = "TELEFONO: ";
    public static final String TICKET_ETIQUETA_FECHA = " FECHA: ";
    public static final String TICKET_ETIQUETA_RUC = "RUC: ";

    public static final String TICKET_ETIQUETA_TOTAL_OPERACION_EXONERADA = "     OP EXONERADA";
    public static final String TICKET_ETIQUETA_TOTAL_OPERACION_GRAVADA = "     OP GRAVADA";
    public static final String TICKET_ETIQUETA_TOTAL_IGV = "     IGV";
    public static final String TICKET_ETIQUETA_IMPORTE_TOTAL = "     IMPORTE TOTAL S/";

    public static final String TICKET_MARCA_IGV = "*";

    public static final String PARAM_TICKET_FORMATO_FECHA = "dd/MM/yyyy";



    public GenerarTicketBase(){
        super();
    }

    public GenerarTicketBase(FktDocument documento) throws Exception {
        super();
        this.documento = documento;

        cargarDatosCabeceraPrincipal();
        cargarDatosCabeceraDocumento();

        cargarConfiguracionTamanioDetalle();

        calcularTamanioTicket();
        cargarConfiguracionImpresion();
    }



    protected FktDocument documento;
    protected String nombreComercialEmpresa;
    protected String rucEmpresa;
    protected String nombreEmpresa;
    protected String direccionEmpresa;
    protected String ubigeoEmpresa;
    protected String telefonoEmpresa;
    protected String correoEmpresa;

    protected String fechaDocumento;
    protected String registroDocumentoCliente;
    protected String rucCliente;
    protected String razonSocialCliente;

    protected int tamanioCodigoProducto;
    protected int tamanioMarcaIGV;
    protected int tamanioCantidadItem;
    protected int tamanioUnidadMedida;
    protected int tamanioProducto;
    protected int tamanioPrecioUnitario;
    protected int tamanioImporteItem;
    protected int tamanioTotales;
    protected int tamanioValorTotales;

    protected String cabeceraDetalleResumido  = "Cantidad  Unidad  Producto              ";
    protected String cabeceraDetalleDetallado = "Codigo Cantidad U.M. P.Unitario  Importe";
    protected String marcaIGV = "";
    protected String codigoItem = "";
    protected String nombreItem = "FIDEO SPAGUETTI AL HUEVO  500 GR - DON VITTORIO";
    protected String cantidadItem = "" + 900.099;
    protected String unidadMedida = "UND";
    protected String precioUnitario = "" + 9900.099;
    protected String importeItem = "" + 989900.099;

    protected Double dTotalOperacionExonerada;
    protected Double dTotalOperacionGravada;
    protected Double dTotalIgv;
    protected Double dImporteTotal;

    protected String totalOperacionExonerada;
    protected String totalOperacionGravada;
    protected String totalIgv;
    protected String importeTotal;

    protected StringBuilder tmpItem;

    protected TicketMatrix ticket;
    protected Extenso e;

    protected int cantidadLineas = 0;
    protected int cantidadColumnas = 0;

    //atributos usados para generarTicket
    protected String _valor = "";
    protected int numeroLinea = 0;
    //protected int linea = 0;

    public void cargarDatosCabeceraPrincipal(){
        this.nombreComercialEmpresa = "";
        this.nombreEmpresa = documento.empresa.getRazonSocial(); //"INVERSIONES UNOCC S.A.C.";
        this.telefonoEmpresa = TICKET_ETIQUETA_TELEFONO.concat(documento.empresa.getTelefono());//"Telefono: 470-8565";
        this.correoEmpresa = documento.empresa.getEmail();//"ventas@inversionesunocc.com";
        this.rucEmpresa  = TICKET_ETIQUETA_RUC.concat(documento.empresa.getRuc());
    }

    public void cargarDatosCabeceraDocumento() throws Exception {
        fechaDocumento = FechaUtil.convertirDateAString(documento.ORDERDATE,PARAM_TICKET_FORMATO_FECHA);
        //PEDIDO: PD02-00000011  FECHA: 12/12/2017
        registroDocumentoCliente = TypeDocument_ES.getByName(documento.DTYPE).toString().toUpperCase()+": "
                .concat(StringUtil.completarTamanio(documento.NAME, 14, " ", false))
                .concat(TICKET_ETIQUETA_FECHA).concat(fechaDocumento);
        rucCliente = TICKET_ETIQUETA_RUC.concat(documento.contact.VATNUMBER);
        razonSocialCliente = documento.contact.COMPANY;
    }

    public void cargarConfiguracionImpresion() throws Exception {
        ticket = new TicketMatrix();
        e = new Extenso();
        e.setNumber(20.30);//Como configurar ?

        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        //System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
        ticket.setOutSize(cantidadLineas, cantidadColumnas);//setOutSize(60, 80);
    }

    protected abstract void cargarConfiguracionTamanioDetalle();
    protected abstract void calcularTamanioTicket();
    protected abstract void generarTicket() throws Exception;



    protected int obtenerPosicionInicialParaCentrar(int cantidadCaracteresPorFila, String valor){
        return (cantidadCaracteresPorFila-valor.length())/2;
    }
    protected String repetirValor(String valor, int cantidadCaracteresPorFila) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i <cantidadCaracteresPorFila;i++)
            stb.append(valor);
        return stb.toString();
    }

    protected void agregarLinea(String valor, boolean centrar) {
        System.out.println("numeroLinea [" + numeroLinea + "] - valor ["+valor+"]");
        if(centrar){
            ticket.printTextWrap(numeroLinea, numeroLinea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
        } else {
            ticket.printTextWrap(numeroLinea, numeroLinea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
        }
        ++numeroLinea;
    }

    protected void agregarLineaRepetirValor(String valor) {
        System.out.println("numeroLinea [" + numeroLinea + "] - valor ["+valor+"]");
        ticket.printTextWrap(numeroLinea, numeroLinea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, repetirValor(valor, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA));
        ++numeroLinea;
    }
}
