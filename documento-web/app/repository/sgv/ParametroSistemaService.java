package repository.sgv;

import commons.Constantes;
import commons.DatosSession;
import models.sgv.ParametroSistema;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;

public class ParametroSistemaService extends SVGConnection{

    public static Seq<ParametroSistema> cargarTipoContactoSeq() throws Exception {
        return convertListToSeq(obtenerListaTipoPersona());
    }
    public static List<ParametroSistema> obtenerListaTipoPersona() throws Exception {
        return obtenerLista(DatosSession.getInstance().ruc,Constantes.PARAMETRO_TIPO_PERSONA);
    }

    public static List<ParametroSistema> obtenerLista(String ruc, String codigoPadre) throws Exception {
        List<ParametroSistema> lista = db.find(ParametroSistema.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .findList();
        return lista;
    }

    public static ParametroSistema  obtener(String ruc, String codigo, String codigoPadre) throws Exception {
        System.out.println("obtener : ruc ["+ruc+"] - codigo ["+codigo+"] - codigoPadre ["+codigoPadre+"]");
        ParametroSistema parametro = db.find(ParametroSistema.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .eq("codigo", codigo)
                .findOne();
        System.out.println(parametro);
        return parametro;
    }

    private static Seq<ParametroSistema> convertListToSeq(List<ParametroSistema> lista){
        lista.add(0,new ParametroSistema("","0000","","SELECCIONAR"));
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

}
