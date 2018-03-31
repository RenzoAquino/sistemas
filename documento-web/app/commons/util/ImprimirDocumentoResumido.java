package commons.util;

import models.fakturama.FktDocument;
import models.fakturama.FktDocumentitem;

public class ImprimirDocumentoResumido extends ImprimirDocumentoBase {

    public ImprimirDocumentoResumido(){
        super();
    }
    public ImprimirDocumentoResumido(FktDocument documento) throws Exception {
        super(documento);
    }

    public static void main(String[] args) throws Exception {
		ImprimirDocumentoResumido impr = new ImprimirDocumentoResumido();
		impr.imprimir();
	}

    @Override
    protected void cargarConfiguracionTamanioDetalle() {
        tamanioCantidadItem = 7;
        tamanioUnidadMedida = 3;
        tamanioProducto = 28;
    }

	public void calcularTamanioImpresion(){
        cantidadLineas = documento.items.size() + PARAM_TICKET_LINEAS_CABECERA_PRINCIPAL + PARAM_TICKET_LINEAS_CABECERA_DOCUMENTO + PARAM_TICKET_LINEAS_DETALLE + PARAM_TICKET_LINEAS_PIE + PARAM_TICKET_LINEAS_ESPACIOS_BLANCO ;
        cantidadColumnas = PARAM_TICKET_CANTIDAD_CARACTERES_POR_FILA;// * cantidadLineasPorRegistro;

        System.out.println("cantidadLineas ["+cantidadLineas+"] - cantidadColumnas ["+cantidadColumnas+"]");
    }

    public void imprimir() throws Exception {
        String mensajeFinPagina = "Revisar los productos entregados.";

        agregarLinea(nombreComercialEmpresa,true);
        agregarLinea(nombreEmpresa,true);
        agregarLinea(telefonoEmpresa,true);
        agregarLinea(correoEmpresa,true);
        //-------------------------------------------------------------------------------
        agregarLinea("",false);
        agregarLinea(registroDocumentoCliente,true);
        agregarLinea(razonSocialCliente,true);
        agregarLineaRepetirValor("-");
        agregarLinea(cabeceraDetalleResumido,true);
        agregarLineaRepetirValor("-");

        agregarLineaProductos();
        //-------------------------------------------------------------------------------
        agregarLineaRepetirValor("-");
        agregarLinea("",false);
        agregarLinea(mensajeFinPagina,true);
        agregarLinea(""+documento.items.size()+" Items.",true);

        printer.toFile(nombreArchivoTXT);
        enviarAImpresora();
    }

    protected void agregarLineaProductos() throws  Exception{
        System.out.println("******************cantidadProductos [" + documento.items.size() + "]");

        for (FktDocumentitem item:documento.items) {
            nombreItem = item.NAME;
            cantidadItem = "" + item.QUANTITY;
            unidadMedida = item.QUANTITYUNIT;

            /*int tamanioTotalRegistro = tamanioCantidadItem + 1 + tamanioUnidadMedida + 1 + tamanioProducto;

            System.out.println("cantidadItem[" + cantidadItem.length() + "] valor [" + cantidadItem + "]");
            System.out.println("unidadMedida[" + unidadMedida.length() + "] valor [" + unidadMedida + "]");
            System.out.println("nombreItem[" + nombreItem.length() + "] valor [" + nombreItem + "]");
            System.out.println("tamanioTotalRegistro [" + tamanioTotalRegistro + "]");
            */

            tmpItem = new StringBuilder();
            tmpItem.append(StringUtil.completarTamanio(cantidadItem, tamanioCantidadItem, " ", true));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(unidadMedida, tamanioUnidadMedida, " ", false));
            tmpItem.append(" ");
            tmpItem.append(StringUtil.completarTamanio(nombreItem, tamanioProducto, " ", false));

            agregarLinea(tmpItem.toString(),true);
        }
    }
}