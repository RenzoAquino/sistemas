package commons.util;

import commons.TypeDocument_ES;
import commons.util.impresion.pos.Extenso;
import commons.util.impresion.pos.PrinterMatrix;
import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ImprimirNotaPedido extends ImprimirDocumento{

    public ImprimirNotaPedido(){
        super();
    }
    public ImprimirNotaPedido(FktDocument documento) throws Exception {
        super(documento);
        this.documento = documento;
    }
	public static void main(String[] args) throws Exception {
		ImprimirNotaPedido impr = new ImprimirNotaPedido();
		impr.imprimir();
	}


	public void calcularTamanioImpresion(){
        int cantidadItems = documento.items.size();
        //int cantidadCaracteresPorFila = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;
        //int cantidadLineasPorRegistro = 2;
        cantidadLineas = cantidadItems + PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL + PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO + PARAM_TICKET_LINEAS_DETALLE + PARAM_TICKET_LINEAS_PIE + PARAM_TICKET_LINEAS_ESPACIOS_BLANCO ;
        cantidadColumnas = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;// * cantidadLineasPorRegistro;

        System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
    }

    public void imprimir() throws Exception {
	//public void imprimir(FktDocument documento) throws Exception {
     //   int cantidadItems = documento.items.size();
        //int PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;
        //int cantidadLineasPorRegistro = 2;
     //   int cantidadLineas = cantidadItems + PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL + PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO + PARAM_TICKET_LINEAS_DETALLE + PARAM_TICKET_LINEAS_PIE + PARAM_TICKET_LINEAS_ESPACIOS_BLANCO ;
        //int cantidadColumnas = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA * cantidadLineasPorRegistro;

        //System.out.println("cantidadLineas " + cantidadLineas);
        //-----------------------------------------------------------------------------------------------------------------
/*
        String nombreComercialEmpresa = "";
        String nombreEmpresa = documento.empresa.getRazonSocial(); //"INVERSIONES UNOCC S.A.C.";
        String telefonoEmpresa = PARAM_TICKET_ETIQUETA_TELEFONO.concat(documento.empresa.getTelefono());//"Telefono: 470-8565";
        String correoEmpresa = documento.empresa.getEmail();//"ventas@inversionesunocc.com";
*/
        //-----------------------------------------------------------------------------------------------------------------
/*
        DateFormat df = new SimpleDateFormat(PARAM_TICKET_FORMATO_FECHA);
        String fechaPedido = df.format(documento.ORDERDATE);

        System.out.println("Report Date: " + fechaPedido);



        //System.out.println("******************** "+documento.DTYPE+" - "+ TypeDocument_ES.getByName(documento.DTYPE));

        String _documento = TypeDocument_ES.getByName(documento.DTYPE).toString().toUpperCase()+": "
                .concat(completarTamanio(documento.NAME, 14, " ", false))
                .concat(PARAM_TICKET_ETIQUETA_FECHA).concat(fechaPedido);

*/
        //PEDIDO: PD02-00000011  FECHA: 12/12/2017
        //-----------------------------------------------------------------------------------------------------------------
        //String nombreCliente = documento.contact.COMPANY;

        //-----------------------------------------------------------------------------------------------------------------
        String cabeceraDetalle = "Cantidad  Unidad  Producto              ";

        //-----------------------------------------------------------------------------------------------------------------

        String nombreItem = "FIDEO SPAGUETTI AL HUEVO  500 GR - DON VITTORIO";
        String cantidadItem = "" + 900.099;
        String unidadMedida = "UND";

        int tamanioCI = 7;
        int tamanioUM = 4;
        int tamanioProducto = 27;

        //-----------------------------------------------------------------------------------------------------------------


        String valor = "";
        int numeroLinea = 0;
        int linea = 0;
        //String fechaEmision = "Fecha de Emision: "+fechaPedido.substring(0,10);
        //String fechaEmision = "Fecha de Emision: "+fechaPedido.substring(0,10)+" Hora: "+fechaPedido.substring(10);//"Fecha de Emision: "+documento.ORDERDATE+" Hora: "+"15:30";
        String mensajeFinPagina = "Revisar los productos entregados.";

        //PrinterMatrix printer = new PrinterMatrix();

        //Extenso e = new Extenso();

        //e.setNumber(101.85);
        //e.setNumber(20.30);


        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        //printer.setOutSize(cantidadLineas, cantidadColumnas);//setOutSize(60, 80);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        // printer.printCharAtLin(2, 25, 1, "*");
       /* 
        //Imprimir * 1ra linea de la columa de 1 a 80
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printCharAtCol(linea, linea, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, "-");//printCharAtCol(1, 1, 80, "=");
       */

        //Imprimir Encabezado nombre del La Empresa
///*

        agregarLinea(nombreComercialEmpresa,true);
        agregarLinea(nombreEmpresa,true);
        agregarLinea(telefonoEmpresa,true);
        agregarLinea(correoEmpresa,true);

        /*
        valor = nombreComercialEmpresa;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "] - valor ["+valor+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);

        //printer.printTextWrap(linI, linE, colI, colE, null);
        valor = nombreEmpresa;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
 fv
        valor = telefonoEmpresa;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);

        valor = correoEmpresa;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
*/
        //-------------------------------------------------------------------------------
        agregarLinea("",false);
        agregarLinea(registroDocumentoCliente,true);
        agregarLinea(razonSocialCliente,true);
/*
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, "");

        valor = registroDocumentoCliente;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);

        //-------------------------------------------------------------------------------

        valor = razonSocialCliente;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
*/
        //-------------------------------------------------------------------------------
        agregarLineaRepetirValor("-");
        agregarLinea(cabeceraDetalle,true);
        agregarLineaRepetirValor("-");

/*
        valor = "-";
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, repetirValor(valor, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA));

        valor = cabeceraDetalle;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);

        //-------------------------------------------------------------------------------
        valor = "-";
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, repetirValor(valor, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA));
*/

        StringBuilder tmpItem = new StringBuilder();
        System.out.println("******************cantidadProductos [" + documento.items.size() + "]");
        FktDocumentitem item = null;
        for (int x = 0; x < documento.items.size(); x++) {
            item = documento.items.get(x);

            nombreItem = item.NAME;
            cantidadItem = "" + item.QUANTITY;
            unidadMedida = item.QUANTITYUNIT;

            tmpItem = new StringBuilder();
            tmpItem.append(nombreItem);

            valor = (tmpItem.length() > 40) ? (tmpItem.substring(0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA)) : tmpItem.toString();
/*
           numeroLinea++; linea = numeroLinea;
           System.out.println("linea ["+linea+"] - nombreItem.length ["+valor.length()+"] - PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA ["+PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA+"]");
           printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
*/
            tmpItem = new StringBuilder();

            int tamanioTotalRegistro = tamanioCI + 1 + tamanioUM + 1 + tamanioProducto;
            /*
            System.out.println("cantidadItem[" + cantidadItem.length() + "] valor [" + cantidadItem + "]");
            System.out.println("unidadMedida[" + unidadMedida.length() + "] valor [" + unidadMedida + "]");
            System.out.println("nombreItem[" + nombreItem.length() + "] valor [" + nombreItem + "]");
            System.out.println("tamanioTotalRegistro [" + tamanioTotalRegistro + "]");
            */

            tmpItem.append(completarTamanio(cantidadItem, tamanioCI, " ", true)).append(" ").append(completarTamanio(unidadMedida, tamanioUM, " ", false)).append(" ").append(completarTamanio(nombreItem, tamanioProducto, " ", false));
            valor = tmpItem.toString();
/*
            numeroLinea++;
            linea = numeroLinea;
            //System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
            printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
*/
            agregarLinea(valor,true);
        }

        //-------------------------------------------------------------------------------
        agregarLineaRepetirValor("-");
        agregarLinea("",false);

/*
        valor = "-";
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, repetirValor(valor, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA));

        //-------------------------------------------------------------------------------
        valor = "";
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        printer.printTextWrap(linea, linea, 0, PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);
*/

        agregarLinea(mensajeFinPagina,true);
        agregarLinea(""+documento.items.size()+" Items.",true);

/*
        valor = mensajeFinPagina;
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea [" + linea + "] - numeroLinea [" + numeroLinea + "]");
        //printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), cantidadColumnas, valor);
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor);

        valor = ""+documento.items.size()+" Items.";
        numeroLinea++;
        linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA, valor), cantidadColumnas, valor);
*/


        printer.toFile(nombreArchivo);
        //enviarAImpresora();

        /*
      FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion_.txt");
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
        
        System.err.println("PrintService :"+service);
        
        Doc document = new SimpleDoc(inputStream, flavor, null);
        DocPrintJob printJob;
        if (service != null) {

            printJob = service.createPrintJob();
            //printJob.addPrintJobListener(new JobCompleteMonitor());
            try {            	
                printJob.print(document, pras);
                
                printJob = service.createPrintJob();
                
                //byte[] bytes = {27, 100, 3};  //Para impresora STAR
                byte[] cutP = new byte[] { 0x1d, 'V', 1 };  //Para impresora BIXOLON
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
        System.out.println("Termino de Impresion");
        */

    }



    public void imprimirXX() throws Exception{
        int cantidadItems = 2;
        int cantidadCaracteresPorFila = 40;
        int cantidadLineasPorRegistro = 2;
        int cantidadLineas =24+(cantidadItems*2)+8; //(CABECERA+PIE)+(CANTIDAD ITEMS)+(ESPACIO PARA CORTE)
        int cantidadColumnas = cantidadCaracteresPorFila*cantidadLineasPorRegistro;

        //-----------------------------------------------------------------------------------------------------------------
        String nombreComercialEmpresa = "";
        String nombreEmpresa = "INVERSIONES UNOCC S.A.C.";
        String direccionEmpresa = "JR. BRIG. PUMACAHUA 2480";
        //String direccionEmpresa = "JR. BRIG. PUMACAHUA 2480 - JR. BRIG. PUMACAHUA 2480 - JR. BRIG. PUMACAHUA 2480";
        String ubigeoEmpresa = "";
        String telefonoEmpresa = "Telefono: 470 8565";
        String rucEmpresa = "RUC 204779543";
        String correoEmpresa = "ventas@inversionesunocc.com";

        //-----------------------------------------------------------------------------------------------------------------
        String tipoDocumento = "FACTURA ELECTRONICA";
        String numeroDocumento = "F001-00000088";

        //-----------------------------------------------------------------------------------------------------------------
        String codigoCliente = "CODIGO: "+"CLI-12345678"+"    RUC:"+"20477954350";
        String nombreCliente = "CENCOSUD REATIL PERU S.A.C.";
        String direccionCliente = "";//"CA. MARIA CURIE N 312 URB. SANTA ROSA";
        String ubigeoCliente = "";//"LIMA-LIMA-LINCE";

        //-----------------------------------------------------------------------------------------------------------------
        String cabeceraDetalle = "Producto  Cantidad  Precio  Importe";

        //-----------------------------------------------------------------------------------------------------------------
        String codigoItem = "AC0012";
        String nombreItem = "FIDEO SPAGUETTI AL HUEVO  500 GR - DON VITTORIO";
        String cantidadItem = ""+90000.099;
        String valorUnitarioItem = ""+1888.808;
        String valorVentaItem = ""+800989.808;

        int tamanioCI = 9;
        int tamanioVUI = 8;
        int tamanioVVI = 12;
        int tamanioOtros = 4;
        int tamanioCodigo = 0;

        //-----------------------------------------------------------------------------------------------------------------
        int tamanioEspacioBlanco = 6;

        String valor = "";
        //int posicionInicialNombreEmpresa = (cantidadCaracteresPorFila-nombreEmpresa.length())/2;
        //int posicionInicial = 0;
        int numeroLinea = 0;
        int linea = 0;
        String fechaEmision = "Fecha de Emision: "+"09/08/2017"+" Hora: "+"15:30";
        String mensajeFinPagina = "Representaci￳n impresa de la factura electr￳nica generada desde el sistema facturador SUNAT. Puede verificarla utilizando su clave SOL";

        PrinterMatrix printer = new PrinterMatrix();

        Extenso e = new Extenso();

        //e.setNumber(101.85);
        e.setNumber(20.30);



        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(cantidadLineas, cantidadColumnas);//setOutSize(60, 80);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        // printer.printCharAtLin(2, 25, 1, "*");
       /*
        //Imprimir * 1ra linea de la columa de 1 a 80
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printCharAtCol(linea, linea, cantidadCaracteresPorFila, "-");//printCharAtCol(1, 1, 80, "=");
       */

        //Imprimir Encabezado nombre del La Empresa
///*
        valor = nombreComercialEmpresa;
        /*numeroLinea++;*/ linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        //printer.printTextWrap(linI, linE, colI, colE, null);
        valor = nombreEmpresa;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = direccionEmpresa;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = ubigeoEmpresa;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = telefonoEmpresa;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = rucEmpresa;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        //-------------------------------------------------------------------------------

        //valor = "-";
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, "");


        valor = tipoDocumento;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = numeroDocumento;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        //-------------------------------------------------------------------------------
       /*
       valor = "-";
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));
       */
        valor = codigoCliente;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        valor = nombreCliente;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        if(direccionCliente != null && direccionCliente.trim().length() > 0){
            valor = direccionCliente;
            numeroLinea++; linea = numeroLinea;
            System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
            printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

            valor = ubigeoCliente;
            numeroLinea++; linea = numeroLinea;
            System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
            printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);
        }

        //-------------------------------------------------------------------------------
        valor = "-";
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));

        valor = cabeceraDetalle;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        //-------------------------------------------------------------------------------
        valor = "-";
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));

        StringBuilder tmpItem = new StringBuilder();
        System.out.println("******************cantidadProductos ["+cantidadItems+"]");
        for(int x = 0; x <cantidadItems; x++){
            System.out.println(""+(x+1)+" - ------------- 01");
            tmpItem = new StringBuilder();
            tmpItem.append(nombreItem);
            System.out.println(""+(x+1)+" - ------------- 02");
            valor = tmpItem.substring(0,cantidadCaracteresPorFila);
            System.out.println(""+(x+1)+" - ------------- 03");
            numeroLinea++; linea = numeroLinea;
            System.out.println("linea ["+linea+"] - nombreItem.length ["+valor.length()+"] - cantidadCaracteresPorFila ["+cantidadCaracteresPorFila+"]");
            printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, valor);

            tmpItem = new StringBuilder();
            if(codigoItem != null && codigoItem.trim().length() > 0) {
                tmpItem.append(codigoItem).append(" ");
            } else {
                tmpItem.append("       ");
            }

            tamanioCodigo = tmpItem.toString().trim().length();
            if(tamanioCodigo < 1){
                tamanioCI = tamanioCI + 3;
                tamanioVUI = tamanioVUI + 2;
                tamanioVVI = tamanioVVI + 2;
            }
            int tamanioTotalRegistro = tamanioCI + tamanioVUI + tamanioVVI + tamanioOtros;
            System.out.println("cantidadItem["+cantidadItem.length()+"] valor ["+cantidadItem+"]");
            System.out.println("valorUnitarioItem["+valorUnitarioItem.length()+"] valor ["+valorUnitarioItem+"]");
            System.out.println("valorVentaItem["+valorVentaItem.length()+"] valor ["+valorVentaItem+"]");
            System.out.println("tamanioTotalRegistro ["+tamanioTotalRegistro+"]");


            tmpItem.append(completarTamanio(cantidadItem,tamanioCI," ",true)).append(" x ").append(completarTamanio(valorUnitarioItem,tamanioVUI," ",true)).append(" ").append(completarTamanio(valorVentaItem,tamanioVVI," ",true));
            valor = tmpItem.toString();
            numeroLinea++; linea = numeroLinea;
            System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
            printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        }

        //-------------------------------------------------------------------------------
        valor = "-";
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));

        //-------------------------------------------------------------------------------
        valor = "";
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, valor);


        valor = fechaEmision;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

        //-------------------------------------------------------------------------------
/*       valor = "-";
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));
*/
        valor = mensajeFinPagina;
        numeroLinea++; linea = numeroLinea;
        System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, (linea+(mensajeFinPagina.length()/cantidadCaracteresPorFila)+1), 0, cantidadColumnas, valor);



        printer.toFile("impresion_.txt");



        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion_.txt");
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
                System.out.print("LLLLLLLLLLLLLLLLLLLLLLLLLLL1");
                printJob.print(document, pras);
                System.out.print("LLLLLLLLLLLLLLLLLLLLLLLLLLLl2");
                printJob = service.createPrintJob();
                System.out.print("LLLLLLLLLLLLLLLLLLLLLLLLLLLl3");
                //byte[] bytes = {27, 100, 3};  //Para impresora STAR
                byte[] cutP = new byte[] { 0x1d, 'V', 1 };  //Para impresora BIXOLON
                flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                document = new SimpleDoc(cutP, flavor, null);

                printJob.print(document, null);
System.out.print("LLLLLLLLLLLLLLLLLLLLLLLLLLLl4");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        inputStream.close();
        System.out.println("*******");


    }
/*	
    private static class JobCompleteMonitor extends PrintJobAdapter {
        @Override
        public void printJobCompleted(PrintJobEvent jobEvent) {
            System.out.println("Job completed");
            jobRunning = false;
        }
    }
*/	
	



	
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
}