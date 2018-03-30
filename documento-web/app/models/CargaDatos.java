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
}
