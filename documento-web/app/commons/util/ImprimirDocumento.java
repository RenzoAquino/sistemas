package commons.util;

import commons.TypeDocument_ES;
import commons.util.impresion.pos.Extenso;
import commons.util.impresion.pos.PrinterMatrix;
import models.fakturama.FktDocument;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ImprimirDocumento {

    public static int PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA = 40;
    public static int PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL = (4+1); //CABECERA PRINCIPAL + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO = (2+0); //CABECERA DE DOCUMENTO + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_DETALLE = (1+3+1); //CABECERA DE DETALLE + LINEAS + ESPACIO EN BLANCO
    public static int PARAM_TICKET_LINEAS_PIE = (2); //PIE TICKET
    public static int PARAM_TICKET_LINEAS_ESPACIOS_BLANCO = (10); //ESPACIOS EN BLANCO DE PIE DE TICKET

    public static final String PARAM_TICKET_ETIQUETA_TELEFONO = "TELEFONO: ";
    public static final String PARAM_TICKET_ETIQUETA_FECHA = " FECHA: ";
    public static final String PARAM_TICKET_ETIQUETA_RUC = "RUC: ";

    public static final String PARAM_TICKET_FORMATO_FECHA = "dd/MM/yyyy";



    public ImprimirDocumento(){
        super();
    }

    public ImprimirDocumento(FktDocument documento) throws Exception {
        super();
        this.documento = documento;
        cargarDatosCabeceraPrincipal();
        cargarDatosCabeceraDocumento();

        calcularTamanioImpresion();
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

    protected int tamanioIGV;
    protected int tamanioCantidadItem;
    protected int tamanioUnidadMedida;
    protected int tamanioProducto;
    protected int tamanioPrecioUnitario;
    protected int tamanioPrecioTotal;

    protected String cabeceraDetalleResumido  = "Cantidad  Unidad  Producto              ";
    protected String cabeceraDetalleDetallado = "Producto   Cantidad   Precio   Importe  ";
    protected String simpoloIGV = "*";
    protected String nombreItem = "FIDEO SPAGUETTI AL HUEVO  500 GR - DON VITTORIO";
    protected String cantidadItem = "" + 900.099;
    protected String unidadMedida = "UND";
    protected String importeItem = "" + 9900.099;

    protected String nombreArchivo = "ticket.txt";
    protected String nombreImpresora = "BIXOLON SRP-270";

    protected PrinterMatrix printer;
    protected Extenso e;

    protected int cantidadLineas = 0;
    protected int cantidadColumnas = 0;

    //atributos usados para imprimir
    protected String _valor = "";
    protected int _numeroLinea = 0;
    protected int _linea = 0;

    public void cargarDatosCabeceraPrincipal(){
        this.nombreComercialEmpresa = "";
        this.nombreEmpresa = documento.empresa.getRazonSocial(); //"INVERSIONES UNOCC S.A.C.";
        this.telefonoEmpresa = PARAM_TICKET_ETIQUETA_TELEFONO.concat(documento.empresa.getTelefono());//"Telefono: 470-8565";
        this.correoEmpresa = documento.empresa.getEmail();//"ventas@inversionesunocc.com";
    }

    public void cargarDatosCabeceraDocumento() throws Exception {
        fechaDocumento = FechaUtil.convertirDateAString(documento.ORDERDATE,PARAM_TICKET_FORMATO_FECHA);
        //PEDIDO: PD02-00000011  FECHA: 12/12/2017
        registroDocumentoCliente = TypeDocument_ES.getByName(documento.DTYPE).toString().toUpperCase()+": "
                .concat(completarTamanio(documento.NAME, 14, " ", false))
                .concat(PARAM_TICKET_ETIQUETA_FECHA).concat(fechaDocumento);
        rucCliente = PARAM_TICKET_ETIQUETA_RUC.concat(documento.contact.VATNUMBER);
        razonSocialCliente = documento.contact.COMPANY;
    }

    public void cargarConfiguracionImpresion() throws Exception {
        printer = new PrinterMatrix();
        e = new Extenso();
        e.setNumber(20.30);//Como configurar ?

        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        //System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
        printer.setOutSize(cantidadLineas, cantidadColumnas);//setOutSize(60, 80);
    }

    public abstract void calcularTamanioImpresion();
    public abstract void imprimir() throws Exception;

    public void enviarAImpresora( ) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(nombreArchivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        //DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;


        //PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        //attributeSet.add(OrientationRequested.PORTRAIT);
        //attributeSet.add(new Copies(2));

        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        PrintService service = findPrintService("BIXOLON SRP-270", printService);
        //PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        System.out.println("PrintService :"+service);

        Doc document = new SimpleDoc(inputStream, flavor, null);
        DocPrintJob printJob;
        if (service != null) {

            printJob = service.createPrintJob();
            /*    printJob.addPrintJobListener(new JobCompleteMonitor());*/
            try {

                printJob.print(document, pras);
                printJob = service.createPrintJob();
                //byte[] bytes = {27, 100, 3};  //CORTE DE HOJA: Para impresora STAR
                byte[] cutP = new byte[] { 0x1d, 'V', 1 };  //CORTE DE HOJA: Para impresora BIXOLON
                flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                document = new SimpleDoc(cutP, flavor, null);

                printJob.print(document, null);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        inputStream.close();
    }

    private PrintService findPrintService(String printerName,
                                          PrintService[] services) {
        for (PrintService service : services) {
            //System.out.println("********************"+service.getName());
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }

    protected String completarTamanio(String valor, int tamanioMaximo,String valorCompletar, boolean completarLadoIzquierdo) throws Exception {
        StringBuilder stb = new StringBuilder();
        String tmp = "";
        int tamanioValor = valor.length();
        if(tamanioValor > tamanioMaximo){
            valor = valor.substring(0,tamanioMaximo);

            System.err.println("ERROR: El tama￱o del n￺mero ["+valor+"] tamañoValor ["+tamanioValor+"] excede el maximo valor de ["+tamanioMaximo+"]");
            tamanioValor = valor.length();
            //throw new Exception("ERROR: El tama￱o del n￺mero ["+valor+"] excede el maximo valor de ["+tamanioMaximo+"]");
        }

        for(int x=0; x < (tamanioMaximo-tamanioValor); x++){
            stb.append(valorCompletar);
        }
        tmp = stb.toString();

        stb = new StringBuilder();
        stb.append(valor);
        stb.insert((completarLadoIzquierdo)?0:tamanioValor, tmp);
        return stb.toString();
    }

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
        System.out.println("numeroLinea [" + _numeroLinea + "] - valor ["+valor+"]");
        if(centrar){
            printer.printTextWrap(_numeroLinea, _numeroLinea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
        } else {
            printer.printTextWrap(_numeroLinea, _numeroLinea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
        }
        ++_numeroLinea;
    }

    protected void agregarLineaRepetirValor(String valor) {
        System.out.println("numeroLinea [" + _numeroLinea + "] - valor ["+valor+"]");
        printer.printTextWrap(_numeroLinea, _numeroLinea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, repetirValor(valor, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA));
        ++_numeroLinea;
    }
}
