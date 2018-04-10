package commons.util.ticket;

import commons.Constantes;
import commons.util.MoneyUtil;
import commons.util.NumeroUtil;
import commons.util.StringUtil;
import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;

public class GenerarTicketDetallado extends GenerarTicketBase {

    private String montoEnLetras;
    private String mensajeFinalFactura;

    public GenerarTicketDetallado(){
        super();
    }
    public GenerarTicketDetallado(FktDocument documento) throws Exception {
        super(documento);
    }

    public GenerarTicketDetallado(FktDocument documento, boolean esParaSUNAT) throws Exception {
        super(documento,esParaSUNAT);
    }

    public static void main(String[] args) throws Exception {
		GenerarTicketDetallado impr = new GenerarTicketDetallado();
		impr.generarTicket();
	}

    @Override
    protected void cargarConfiguracionTamanioDetalle() {
        tamanioMarcaIGV = 1;
        tamanioCodigoProducto = 6;
        tamanioCantidadItem = 7;
        tamanioUnidadMedida = 3;
        tamanioPrecioUnitario = 8;
        tamanioImporteItem = 10;
        tamanioProducto = 39;
        tamanioTotales = 30;
        tamanioValorTotales = 10;
    }

	public void calcularTamanioTicket(){
        cantidadLineas = (documento.items.size() * 2) +
                PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL + 1+ 1 + //Se agrego el RUC Emisor y RUC Cliente
                PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO +
                PARAM_TICKET_LINEAS_DETALLE +
                PARAM_TICKET_LINEAS_PIE +
                PARAM_TICKET_LINEAS_ESPACIOS_BLANCO +
                PARAM_TICKET_LINEAS_TOTALES;
        System.out.println("**********************cantidadLineas "+cantidadLineas);
        cantidadLineas = cantidadLineas + (esParaSUNAT? (2+ 3+ 2 + 1 + 4 ): 0); //Se agrego nombre y numero de documento + monto en letras + hash de SUNAT + espacio SUNAT + mensaje SUNAT
        System.out.println("**********************cantidadLineas "+cantidadLineas);
        cantidadColumnas = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;// * cantidadLineasPorRegistro;

        System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
    }

    public void generarTicket() throws Exception {


        String mensajeFinPagina = "Revisar los productos entregados.";

        agregarLinea(nombreComercialEmpresa,true);
        agregarLinea(nombreEmpresa,true);
        agregarLinea(rucEmpresa,true); //*
        //agregarLinea(direccionEmpresa,true);
        //agregarLinea(ubigeoEmpresa,true);
        agregarLinea(telefonoEmpresa,true);
        agregarLinea(correoEmpresa,true);

        //-------------------------------------------------------------------------------
        agregarLinea("",false);
        if(esParaSUNAT) {
            agregarLinea(nombreDocumento,true);
            agregarLinea(numeroDocumento,true);
            agregarLinea(fechaEmisionDocumento.substring(1,fechaEmisionDocumento.length()),true);
            agregarLinea(" ",false);
        } else {
            agregarLinea(registroDocumentoCliente,true);
        }

        agregarLinea(razonSocialCliente,false);
        agregarLinea(rucCliente,false); //*
        agregarLineaRepetirValor("-");
        agregarLinea(cabeceraDetalleDetallado,true);
        agregarLineaRepetirValor("-");

        agregarLineaProductos();

        agregarLineaRepetirValor("-");
        
        agregarTotales();

        if(esParaSUNAT) {
            cargarDatosParaSUNAT();
            agregarLinea(" ", false);
            agregarLinea(montoEnLetras.concat("            ."), false);
            agregarLinea(" ", false);
            agregarLinea(hashSUNAT, true);
            agregarLinea(" ", false);
            agregarLinea(mensajeFinalFactura, false);
        } else {
            agregarLinea(" ", false);
            agregarLinea(mensajeFinPagina, true);
            agregarLinea("" + documento.items.size() + " Items.", true);
        }
        ticket.toFile(Constantes.NOMBRE_ARCHIVO_TXT);

        //ImpresoraUtil.enviarAImpresora();
        //PDFUtil.convertirTXTaPDF(documento.NAME+"_"+documento.contact.COMPANY+".pdf");
    }



    private void agregarTotales() throws Exception {

        totalOperacionExonerada =
                StringUtil.completarTamanio(TICKET_ETIQUETA_TOTAL_OPERACION_EXONERADA, tamanioTotales," ",false)+
                StringUtil.completarTamanio(NumeroUtil.roundString((dTotalOperacionExonerada),2), tamanioValorTotales," ",true);

        totalOperacionGravada =
                StringUtil.completarTamanio(TICKET_ETIQUETA_TOTAL_OPERACION_GRAVADA, tamanioTotales," ",false)+
                StringUtil.completarTamanio(NumeroUtil.roundString((dTotalOperacionGravada),2), tamanioValorTotales," ",true);

        dTotalIgv = dTotalOperacionGravada*0.18;
        totalIgv =
                StringUtil.completarTamanio(TICKET_ETIQUETA_TOTAL_IGV, tamanioTotales," ",false)+
                StringUtil.completarTamanio(NumeroUtil.roundString((dTotalIgv),2), tamanioValorTotales," ",true);

        dImporteTotal = dTotalOperacionExonerada + dTotalOperacionGravada + dTotalIgv;
        importeTotal =
                StringUtil.completarTamanio(TICKET_ETIQUETA_IMPORTE_TOTAL, tamanioTotales," ",false)+
                StringUtil.completarTamanio(NumeroUtil.roundString((dImporteTotal),2), tamanioValorTotales," ",true);

        agregarLinea(totalOperacionGravada,false);
        agregarLinea(totalOperacionExonerada,false);
        agregarLinea(totalIgv,false);
        agregarLinea(importeTotal,false);
    }

    protected void agregarLineaProductos() throws  Exception{
        System.out.println("******************cantidadProductos [" + documento.items.size() + "]");

        dTotalOperacionExonerada = new Double(0);
        dTotalOperacionGravada = new Double(0);
//        dTotalIgv = new Double(0);
//        dImporteTotal = new Double(0);

        for (FktDocumentitem item:documento.items) {
            codigoItem = (item.ITEMNUMBER==null)?"":item.ITEMNUMBER;
            nombreItem = item.NAME;
            cantidadItem = StringUtil.completarTamanioDecimal(""+item.QUANTITY,3,"0",false);
            unidadMedida = item.QUANTITYUNIT;
            //precioUnitario =  "" + item.PRICE;

            if(item.vat.TAXVALUE.equals(0.0)){
                marcaIGV = " ";
                precioUnitario =  NumeroUtil.roundString(item.PRICE,2);
                importeItem = NumeroUtil.roundString((item.QUANTITY*item.PRICE),2);

                dTotalOperacionExonerada = dTotalOperacionExonerada + item.QUANTITY*item.PRICE;
            } else {
                marcaIGV = TICKET_MARCA_IGV;
                precioUnitario = NumeroUtil.roundString(((item.vat.TAXVALUE+1)*item.PRICE),2);
                importeItem = NumeroUtil.roundString(((item.vat.TAXVALUE+1)*item.PRICE*item.QUANTITY),2);

                dTotalOperacionGravada = dTotalOperacionGravada + item.QUANTITY*item.PRICE;
            }

            //marcaIGV = ((("" + item.vat.TAXVALUE).trim().equals("0.0"))? " ":TICKET_MARCA_IGV);
            //"0.0" "0.18"
            //System.out.println(marcaIGV +" --- "+item.vat.TAXVALUE);
            /*int tamanioTotalRegistro = tamanioCantidadItem + 1 + tamanioUnidadMedida + 1 + tamanioProducto;

            System.out.println("cantidadItem[" + cantidadItem.length() + "] valor [" + cantidadItem + "]");
            System.out.println("unidadMedida[" + unidadMedida.length() + "] valor [" + unidadMedida + "]");
            System.out.println("nombreItem[" + nombreItem.length() + "] valor [" + nombreItem + "]");
            System.out.println("tamanioTotalRegistro [" + tamanioTotalRegistro + "]");
            */

            tmpItem = new StringBuilder();
            tmpItem.append(StringUtil.completarTamanio(codigoItem, tamanioCodigoProducto, " ", false));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(cantidadItem, tamanioCantidadItem, " ", true));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(unidadMedida, tamanioUnidadMedida, " ", false));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(precioUnitario, tamanioPrecioUnitario, " ", true));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(importeItem, tamanioImporteItem, " ", true));
            agregarLinea(tmpItem.toString(),true);

            tmpItem = new StringBuilder();
            tmpItem.append(marcaIGV);
            tmpItem.append(StringUtil.completarTamanio(nombreItem, tamanioProducto, " ", false));
            agregarLinea(tmpItem.toString(),true);
        }
    }

    public void cargarDatosParaSUNAT() {
        mensajeFinalFactura = "Representación impresa de la factura electrónica generada desde el sistema facturador SUNAT. Puede verificarla utilizando su clave SOL";
        montoEnLetras = MoneyUtil.convertirNumeroAPalabra(dImporteTotal, false).toUpperCase();
    }
}