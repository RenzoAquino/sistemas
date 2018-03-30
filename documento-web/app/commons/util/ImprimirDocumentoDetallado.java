package commons.util;

import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;

public class ImprimirDocumentoDetallado extends ImprimirDocumentoBase {

    public ImprimirDocumentoDetallado(){
        super();
    }
    public ImprimirDocumentoDetallado(FktDocument documento) throws Exception {
        super(documento);
    }

    public static void main(String[] args) throws Exception {
		ImprimirDocumentoDetallado impr = new ImprimirDocumentoDetallado();
		impr.imprimir();
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
    }

	public void calcularTamanioImpresion(){
        cantidadLineas = (documento.items.size() * 2) +
                PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL + 1+ //Se agrego el RUC
                PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO +
                PARAM_TICKET_LINEAS_DETALLE +
                PARAM_TICKET_LINEAS_PIE +
                PARAM_TICKET_LINEAS_ESPACIOS_BLANCO ;
        cantidadColumnas = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;// * cantidadLineasPorRegistro;

        System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
    }

    public void imprimir() throws Exception {
        String mensajeFinPagina = "Revisar los productos entregados.";

        agregarLinea(nombreComercialEmpresa,true);
        agregarLinea(nombreEmpresa,true);
        //agregarLinea(direccionEmpresa,true);
        //agregarLinea(ubigeoEmpresa,true);
        agregarLinea(telefonoEmpresa,true);
        agregarLinea(correoEmpresa,true);
        agregarLinea(rucEmpresa,true); //*
        //-------------------------------------------------------------------------------
        agregarLinea("",false);
        agregarLinea(registroDocumentoCliente,true);
        agregarLinea(razonSocialCliente,true);
        agregarLineaRepetirValor("-");
        agregarLinea(cabeceraDetalleDetallado,true);
        agregarLineaRepetirValor("-");

        agregarLineaProductos();

        agregarLineaRepetirValor("-");
        
        agregarTotales();
        agregarLinea("",false);
        agregarLinea(mensajeFinPagina,true);
        agregarLinea(""+documento.items.size()+" Items.",true);

        printer.toFile(nombreArchivo);
        //enviarAImpresora();
    }

    private void agregarTotales() {
    }

    protected void agregarLineaProductos() throws  Exception{
        System.out.println("******************cantidadProductos [" + documento.items.size() + "]");

        for (FktDocumentitem item:documento.items) {
            codigoItem = (item.ITEMNUMBER==null)?"":item.ITEMNUMBER;
            nombreItem = item.NAME;
            cantidadItem = StringUtil.completarTamanioDecimal(""+item.QUANTITY,3,"0",true);
            unidadMedida = item.QUANTITYUNIT;
            //precioUnitario =  "" + item.PRICE;

            if(item.vat.TAXVALUE.equals(0.0)){
                marcaIGV = " ";
                precioUnitario =  NumeroUtil.roundString(item.PRICE,2);
                importeItem = NumeroUtil.roundString((item.QUANTITY*item.PRICE),2);
            } else {
                marcaIGV = TICKET_MARCA_IGV;
                precioUnitario = NumeroUtil.roundString(((item.vat.TAXVALUE+1)*item.PRICE),2);
                importeItem = NumeroUtil.roundString(((item.vat.TAXVALUE+1)*item.PRICE*item.QUANTITY),2);
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
}