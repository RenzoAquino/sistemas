package models;

import models.dto.ParametroDTO;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaDatos {
    // options = Seq("S"->"Resumido","N"->"Detallado"),
    //options = options(CargaDatos.cargarTipoImpresionTicket),
    //options = CargaDatos.cargarTipoImpresionTicketSeq.map(dto => dto.codigo -> dto.descripcion)

    public static Map<String, String> cargarTipoImpresionTicket() {
        Map<String, String> lista = new HashMap<String, String>();
        lista.put("R", "Resumido");
        lista.put("D", "Detallado");
        return lista;
    }

    public static Seq<ParametroDTO> cargarTipoImpresionTicketSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipoImpresionTicket();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }
    public List<ParametroDTO> obtenerListaTipoImpresionTicket(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("R","Resumido");
        lista.add(dto);
        dto = new ParametroDTO("D","Detallado");
        lista.add(dto);
        return lista;
    }
    public static List<String> cargarTipoImpresion(){
        List<String> lista = new ArrayList<String>();
        lista.add("Resumido");
        lista.add("Detallado");
        return lista;
    }


    public static Seq<ParametroDTO> cargarTipoAccionSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipoAccion();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaTipoAccion(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("IMP","Impresión");
        lista.add(dto);
        dto = new ParametroDTO("PDF","Generar PDF");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarTipoLibroSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipLibro();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaTipLibro(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("LCOM","LIBRO DE COMPRAS");
        lista.add(dto);
        dto = new ParametroDTO("LVEN","LIBRO DE VENTAS");
        lista.add(dto);
        dto = new ParametroDTO("LDSM","LIBRO SIMPLIFICADO DIARIO");
        lista.add(dto);
        dto = new ParametroDTO("ANUL","ANULACIONES");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarAniosSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaAnios();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaAnios(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("2018","2018");
        lista.add(dto);
        dto = new ParametroDTO("2019","2019");
        lista.add(dto);
        dto = new ParametroDTO("2020","2020");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarMesesSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaMeses();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaMeses(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","Enero");
        lista.add(dto);
        dto = new ParametroDTO("02","Febrero");
        lista.add(dto);
        dto = new ParametroDTO("03","Marzo");
        lista.add(dto);
        dto = new ParametroDTO("04","Abril");
        lista.add(dto);
        dto = new ParametroDTO("05","Mayo");
        lista.add(dto);
        dto = new ParametroDTO("06","Junio");
        lista.add(dto);
        dto = new ParametroDTO("07","Julio");
        lista.add(dto);
        dto = new ParametroDTO("08","Agosto");
        lista.add(dto);
        dto = new ParametroDTO("09","Setiembre");
        lista.add(dto);
        dto = new ParametroDTO("10","Octubre");
        lista.add(dto);
        dto = new ParametroDTO("11","Noviembre");
        lista.add(dto);
        dto = new ParametroDTO("12","Diciembre");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarTipoDocumentoSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipoDocumento();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaTipoDocumento(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("Pedido","Pedido");
        lista.add(dto);
        dto = new ParametroDTO("Factura","Factura");
        lista.add(dto);
        dto = new ParametroDTO("Corrección factura","Corrección factura");
        lista.add(dto);
        dto = new ParametroDTO("Proforma","Proforma");
        lista.add(dto);
        dto = new ParametroDTO("Albarán envío","Albarán envío");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarRazonesSocialesSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaRazonesSociales();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaRazonesSociales(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("20477954350","INVERSIONES UNOCC S.A.C.");
        lista.add(dto);
        dto = new ParametroDTO("20601017564","D'UNOCC S.A.C.");
        lista.add(dto);
        dto = new ParametroDTO("20602885772","INVERSIONES AQUINO Y UNOCC S.A.C.");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarTipoContactoSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipoContacto();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaTipoContacto(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","CLIENTE");
        lista.add(dto);
        dto = new ParametroDTO("02","PROVEEDOR");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarTipoPersonaSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaTipoPersona();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaTipoPersona(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","PERSONA NATURAL");
        lista.add(dto);
        dto = new ParametroDTO("02","PERSONA JURIDICA");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarPaisesSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaPais();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaPais(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","PERU");
        lista.add(dto);
        dto = new ParametroDTO("02","CHILE");
        lista.add(dto);
        dto = new ParametroDTO("03","ARGENTINA");
        lista.add(dto);
        return lista;
    }

    public static Seq<ParametroDTO> cargarCiudadSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaCiudad();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaCiudad(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","LIMA");
        lista.add(dto);
        dto = new ParametroDTO("02","JUNIN");
        lista.add(dto);
        dto = new ParametroDTO("03","CALLAO");
        lista.add(dto);
        return lista;
    }
    public static Seq<ParametroDTO> cargarDistritoSeq() {
        CargaDatos datos = new CargaDatos();
        List<ParametroDTO> lista = datos.obtenerListaDistrito();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<ParametroDTO> obtenerListaDistrito(){
        List<ParametroDTO> lista = new ArrayList<ParametroDTO>();
        ParametroDTO dto = null;
        dto = new ParametroDTO("0000","SELECCIONAR");
        lista.add(dto);
        dto = new ParametroDTO("01","LINCE");
        lista.add(dto);
        dto = new ParametroDTO("02","SANTA ANITA");
        lista.add(dto);
        dto = new ParametroDTO("03","SAN ISIDRO");
        lista.add(dto);
        return lista;
    }
}
