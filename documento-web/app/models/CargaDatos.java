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
        dto = new ParametroDTO("LCOM","Libro de Compra");
        lista.add(dto);
        dto = new ParametroDTO("LVEN","Libro de Venta");
        lista.add(dto);
        dto = new ParametroDTO("LDSM","Libro Simplificado Diario");
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
        dto = new ParametroDTO("1","Enero");
        lista.add(dto);
        dto = new ParametroDTO("2","Febrero");
        lista.add(dto);
        dto = new ParametroDTO("3","Marzo");
        lista.add(dto);
        dto = new ParametroDTO("4","Abril");
        lista.add(dto);
        dto = new ParametroDTO("5","Mayo");
        lista.add(dto);
        dto = new ParametroDTO("6","Junio");
        lista.add(dto);
        dto = new ParametroDTO("7","Julio");
        lista.add(dto);
        dto = new ParametroDTO("8","Agosto");
        lista.add(dto);
        dto = new ParametroDTO("9","Setiembre");
        lista.add(dto);
        dto = new ParametroDTO("10","Octubre");
        lista.add(dto);
        dto = new ParametroDTO("11","Noviembre");
        lista.add(dto);
        dto = new ParametroDTO("12","Diciembre");
        lista.add(dto);
        return lista;
    }
}
