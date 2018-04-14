package repository.sgv;

import commons.Constantes;

import models.sgv.Parametro;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;

public class ParametroService extends SVGConnection{

    public static Seq<Parametro> cargarTipoContactoSeq() throws Exception {
        return convertListToSeq(ParametroService.obtenerListaTipoContacto());
    }

    public static Seq<Parametro> cargarTipoPersonaSeq() throws Exception {
        return convertListToSeq(ParametroService.obtenerListaTipoPersona());
    }

    public static List<Parametro> obtenerListaTipoContacto() throws Exception {
        return obtenerLista(Constantes.PARAMETRO_TIPO_CONTACTO);
    }
    public static List<Parametro> obtenerListaTipoPersona() throws Exception {
        return obtenerLista(Constantes.PARAMETRO_TIPO_PERSONA);
    }

    public static List<Parametro> obtenerLista(String codigoPadre) throws Exception {
        List<Parametro> lista = db.find(Parametro.class).select("codigo, codigo_padre, descripcion")
                .where().eq("codigo_padre", codigoPadre)
                .findList();
        return lista;
    }

    public static Parametro obtenerParametro(String codigo, String codigoPadre) throws Exception {
        System.out.println("obtenerParametro : codigo ["+codigo+"] - codigoPadre ["+codigoPadre+"]");
        Parametro parametro = db.find(Parametro.class).select("codigo, codigo_padre, descripcion")
                .where()
                .eq("codigo_padre", codigoPadre)
                .eq("codigo", codigo)
                .findOne();
        System.out.println(parametro);
        return parametro;
    }

    private static Seq<Parametro> convertListToSeq(List<Parametro> lista){
        lista.add(0,new Parametro("0000","","SELECCIONAR"));
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

}
