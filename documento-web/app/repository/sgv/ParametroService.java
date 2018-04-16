package repository.sgv;

import commons.Constantes;

import commons.DatosSession;
import models.sgv.Parametro;
import models.sgv.ParametroSistema;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;

public class ParametroService extends SVGConnection{

    public static Seq<Parametro> cargarTipoContactoSeq() throws Exception {
        return convertListToSeq(obtenerListaTipoContacto());
    }
    public static Seq<Parametro> cargarTipoPersonaSeq() throws Exception {
        return convertListToSeq(obtenerListaTipoPersona());
    }
    public static List<Parametro> obtenerListaTipoContacto() throws Exception {
        return obtenerLista(DatosSession.getInstance().ruc,Constantes.PARAMETRO_TIPO_CONTACTO);
    }
    public static List<Parametro> obtenerListaTipoPersona() throws Exception {
        return obtenerLista(DatosSession.getInstance().ruc,Constantes.PARAMETRO_TIPO_PERSONA);
    }

    public static Parametro obtenerTipoContacto(String tipo) throws Exception {
        return obtener(DatosSession.getInstance().ruc,tipo,Constantes.PARAMETRO_TIPO_CONTACTO);
    }

    public static List<Parametro> obtenerLista(String ruc, String codigoPadre) throws Exception {
        List<Parametro> lista = db.find(Parametro.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .findList();
        return lista;
    }

    public static Parametro obtener(String ruc, String codigo, String codigoPadre) throws Exception {
        System.out.println("obtener : ruc ["+ruc+"] - codigo ["+codigo+"] - codigoPadre ["+codigoPadre+"]");
        Parametro parametro = db.find(Parametro.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .eq("codigo", codigo)
                .findOne();
        System.out.println(parametro);
        return parametro;
    }

    private static Seq<Parametro> convertListToSeq(List<Parametro> lista){
        lista.add(0,new Parametro("","0000","","SELECCIONAR"));
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

}
