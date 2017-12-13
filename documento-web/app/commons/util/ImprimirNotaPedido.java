package commons.util;

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

public class ImprimirNotaPedido {

	/*private static boolean jobRunning = true;*/

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImprimirNotaPedido impr = new ImprimirNotaPedido();
		impr.imprimirFactura();

	}

	int obtenerPosicionInicialParaCentrar(int cantidadCaracteresPorFila, String valor){
		return (cantidadCaracteresPorFila-valor.length())/2;
	}
	
	public void imprimirFactura(FktDocument documento) throws Exception{
		int cantidadItems = documento.items.size();

		if(cantidadItems < 4) cantidadItems = cantidadItems + 3;

		int cantidadCaracteresPorFila = 40;
		int cantidadLineasPorRegistro = 2;
		int cantidadLineas =10+(cantidadItems*2)+4; //(CABECERA+PIE)+(CANTIDAD ITEMS)+(ESPACIO PARA CORTE)
		int cantidadColumnas = cantidadCaracteresPorFila*cantidadLineasPorRegistro;

		System.out.println("cantidadLineas "+cantidadLineas);
		//-----------------------------------------------------------------------------------------------------------------		
		String nombreComercialEmpresa = "";
		String nombreEmpresa = "INVERSIONES UNOCC S.A.C.";
		String telefonoEmpresa = "Telefono: 470-8565";
		String correoEmpresa = "ventas@inversionesunocc.com";
		
		//-----------------------------------------------------------------------------------------------------------------
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPedido = df.format(documento.ORDERDATE);

        System.out.println("Report Date: " + fechaPedido);


        //String _documento = "NOTA DE ENVIO:         "+documento.NAME;
        String _documento = "PEDIDO: "
                .concat(completarTamanio(documento.NAME,13," ",true))
                .concat(" FECHA: ").concat(fechaPedido);


        //PEDIDO: PD02-00000011  FECHA: 12/12/2017
		//-----------------------------------------------------------------------------------------------------------------
		String nombreCliente = documento.contact.COMPANY;

		//-----------------------------------------------------------------------------------------------------------------
		String cabeceraDetalle = "Cantidad  Unidad  Producto              ";

		//-----------------------------------------------------------------------------------------------------------------

		String nombreItem = "FIDEO SPAGUETTI AL HUEVO  500 GR - DON VITTORIO";
        String cantidadItem = ""+900.099;
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
		String mensajeFinPagina = "Gracias por su compra.";
				
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

       valor = telefonoEmpresa;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);
       
       valor = correoEmpresa;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);
              
       //-------------------------------------------------------------------------------
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, "");
       
       valor = _documento;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);

       //-------------------------------------------------------------------------------

       valor = nombreCliente;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);
       
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
       System.out.println("******************cantidadProductos ["+documento.items.size()+"]");
        FktDocumentitem item = null;
       for(int x = 0; x <documento.items.size(); x++){
           item = documento.items.get(x);

           nombreItem = item.NAME;
           cantidadItem = ""+item.QUANTITY;
           unidadMedida = item.QUANTITYUNIT;

    	   tmpItem = new StringBuilder();
    	   tmpItem.append(nombreItem);

    	   valor = (tmpItem.length() > 40)?(tmpItem.substring(0,cantidadCaracteresPorFila)): tmpItem.toString();
/*
           numeroLinea++; linea = numeroLinea;
           System.out.println("linea ["+linea+"] - nombreItem.length ["+valor.length()+"] - cantidadCaracteresPorFila ["+cantidadCaracteresPorFila+"]");
           printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, valor);
*/
           tmpItem = new StringBuilder();

           int tamanioTotalRegistro = tamanioCI + 1 + tamanioUM + 1 + tamanioProducto;
           System.out.println("cantidadItem["+cantidadItem.length()+"] valor ["+cantidadItem+"]");
           System.out.println("unidadMedida["+unidadMedida.length()+"] valor ["+unidadMedida+"]");
           System.out.println("nombreItem["+nombreItem.length()+"] valor ["+nombreItem+"]");
           System.out.println("tamanioTotalRegistro ["+tamanioTotalRegistro+"]");
           
           
           tmpItem.append(completarTamanio(cantidadItem,tamanioCI," ",true)).append(" ").append(completarTamanio(unidadMedida,tamanioUM," ",false)).append(" ").append(completarTamanio(nombreItem,tamanioProducto," ",false));
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

/*
       valor = fechaEmision;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadCaracteresPorFila, valor);
*/
       //-------------------------------------------------------------------------------
/*       valor = "-";
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
       printer.printTextWrap(linea, linea, 0, cantidadCaracteresPorFila, repetirValor(valor,cantidadCaracteresPorFila));
*/

       valor = mensajeFinPagina;
       numeroLinea++; linea = numeroLinea;
       System.out.println("linea ["+linea+"] - numeroLinea ["+numeroLinea+"]");
        printer.printTextWrap(linea, linea, obtenerPosicionInicialParaCentrar(cantidadCaracteresPorFila, valor), cantidadColumnas, valor);


        
        printer.toFile("impresion.txt");

      FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
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
        /*    printJob.addPrintJobListener(new JobCompleteMonitor());*/
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
        System.out.println("*******");


    }

    public void imprimirFactura() throws Exception{
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



        printer.toFile("impresion.txt");

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
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
            /*    printJob.addPrintJobListener(new JobCompleteMonitor());*/
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
	
	private String completarTamanio(String valor, int tamanioMaximo,String valorCompletar, boolean completarLadoIzquierdo) throws Exception {
		StringBuilder stb = new StringBuilder();
		String tmp = "";
		int tamanioValor = valor.length();
		if(tamanioValor > tamanioMaximo) throw new Exception("ERROR: El tama￱o del n￺mero ["+valor+"] excede el maximo valor de ["+tamanioMaximo+"]");
		
		for(int x=0; x < (tamanioMaximo-tamanioValor); x++){
			stb.append(valorCompletar);
		}
		tmp = stb.toString();
		
		stb = new StringBuilder();
		stb.append(valor);
		stb.insert((completarLadoIzquierdo)?0:tamanioValor, tmp);
		return stb.toString();
	}

	private String repetirValor(String valor, int cantidadCaracteresPorFila) {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i <cantidadCaracteresPorFila;i++)
			stb.append(valor);
		
		return stb.toString();
	}
	
	private PrintService findPrintService(String printerName,
			PrintService[] services) {
		for (PrintService service : services) {
			System.out.println("********************"+service.getName());
			if (service.getName().equalsIgnoreCase(printerName)) {
				return service;
			}
		}
 
		return null;
	}
}