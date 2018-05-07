package models;

import commons.DatosSession;
import models.sgv.Parametro;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaDatos {
    // options = Seq("S"->"Resumido","N"->"Detallado"),
    //options = options(CargaDatos.cargarTipoImpresionTicket),
    //options = CargaDatos.cargarTipoImpresionTicketSeq.map(dto => dto.codigo -> dto.valor)

    public static Map<String, String> cargarTipoImpresionTicket() {
        Map<String, String> lista = new HashMap<String, String>();
        lista.put("R", "Resumido");
        lista.put("D", "Detallado");
        return lista;
    }

    public static Seq<Parametro> cargarTipoImpresionTicketSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipoImpresionTicket();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }
    public List<Parametro> obtenerListaTipoImpresionTicket(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"R","","Resumido");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"D","","Detallado");
        lista.add(dto);
        return lista;
    }
    public static List<String> cargarTipoImpresion(){
        List<String> lista = new ArrayList<String>();
        lista.add("Resumido");
        lista.add("Detallado");
        return lista;
    }


    public static Seq<Parametro> cargarTipoAccionSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipoAccion();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaTipoAccion(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"IMP","","Impresión");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"PDF","","Generar PDF");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarTipoLibroSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipLibro();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaTipLibro(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"LCOM","","LIBRO DE COMPRAS");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"LVEN","","LIBRO DE VENTAS");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"LDSM","","LIBRO SIMPLIFICADO DIARIO");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"ANUL","","ANULACIONES");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarAniosSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaAnios();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaAnios(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"2018","","2018");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"2019","","2019");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"2020","","2020");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarMesesSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaMeses();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaMeses(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","Enero");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","Febrero");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"03","","Marzo");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"04","","Abril");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"05","","Mayo");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"06","","Junio");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"07","","Julio");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"08","","Agosto");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"09","","Setiembre");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"10","","Octubre");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"11","","Noviembre");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"12","","Diciembre");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarTipoDocumentoSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipoDocumento();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaTipoDocumento(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"Pedido","","Pedido");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"Factura","","Factura");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"Corrección factura","","Corrección factura");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"Proforma","","Proforma");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"Albarán envío","","Albarán envío");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarRazonesSocialesSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaRazonesSociales();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaRazonesSociales(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"20477954350","","INVERSIONES UNOCC S.A.C.");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"20601017564","","D'UNOCC S.A.C.");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"20602885772","","INVERSIONES AQUINO Y UNOCC S.A.C.");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarTipoContactoSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipoContacto();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaTipoContacto(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","CLIENTE");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","PROVEEDOR");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarTipoPersonaSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaTipoPersona();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaTipoPersona(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","PERSONA NATURAL");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","PERSONA JURIDICA");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarPaisesSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaPais();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaPais(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","PERU");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","CHILE");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"03","","ARGENTINA");
        lista.add(dto);
        return lista;
    }

    public static Seq<Parametro> cargarCiudadSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaCiudad();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaCiudad(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","LIMA");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","JUNIN");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"03","","CALLAO");
        lista.add(dto);
        return lista;
    }
    public static Seq<Parametro> cargarDistritoSeq() {
        CargaDatos datos = new CargaDatos();
        List<Parametro> lista = datos.obtenerListaDistrito();
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public List<Parametro> obtenerListaDistrito(){
        List<Parametro> lista = new ArrayList<Parametro>();
        Parametro dto = null;
        dto = new Parametro(DatosSession.getInstance().ruc,"0000","","SELECCIONAR");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"01","","LINCE");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"02","","SANTA ANITA");
        lista.add(dto);
        dto = new Parametro(DatosSession.getInstance().ruc,"03","","SAN ISIDRO");
        lista.add(dto);
        return lista;
    }
}
