package repository.sgv;

import commons.Constantes;
import commons.DatosSession;
import models.sgv.Secuencia;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;

public class SecuenciaService extends SVGConnection{

    public static Secuencia obtenerFormatoCliente() throws Exception {
        return obtener(DatosSession.getInstance().ruc,Constantes.PARAMETRO_CODIGO_FORMATO_CLIENTE,Constantes.PARAMETRO_FORMATO_CODIGO);
    }

    public static Secuencia obtenerFormatoProveedor() throws Exception {
        return obtener(DatosSession.getInstance().ruc,Constantes.PARAMETRO_CODIGO_FORMATO_PROVEEDOR,Constantes.PARAMETRO_FORMATO_CODIGO);
    }

    public static List<Secuencia> obtenerLista(String ruc, String codigoPadre) throws Exception {
        List<Secuencia> lista = db.find(Secuencia.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .findList();
        return lista;
    }

    public static Secuencia obtener(String ruc, String codigo, String codigoPadre) throws Exception {
        System.out.println("obtener : ruc ["+ruc+"] - codigo ["+codigo+"] - codigoPadre ["+codigoPadre+"]");
        Secuencia obj = db.find(Secuencia.class).select(Constantes.SELECT_BASE_PARAMETROS)
                .where()
                .eq("ruc", ruc)
                .eq("codigo_padre", codigoPadre)
                .eq("codigo", codigo)
                .findOne();
        System.out.println(obj);
        return obj;
    }

    private static Seq<Secuencia> convertListToSeq(List<Secuencia> lista){
        //lista.add(0,new Parametro("","0000","","SELECCIONAR"));
        return JavaConverters.asScalaIteratorConverter(lista.iterator()).asScala().toSeq();
    }

    public static void actualizar(Secuencia secuencia) throws Exception {
        System.out.println("SecuenciaService.actualizar : "+secuencia);
        db.update(secuencia);
    }
}
