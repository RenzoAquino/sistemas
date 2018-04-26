package com.sisint.sfs.handler;

import com.sisint.common.resources.Mapa;
import com.sisint.sfs.resources.TipoComprobante;
import com.sisint.sfs.resources.TipoEstado;
import com.sisint.common.util.JsonUtil;

import java.io.IOException;
import java.util.List;

public class SFSHandler {

    private static String PATH_TIPO_COMPROBANTE = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\sfs\\TipoComprobante.json";
    private static String TAG_TIPO_COMPROBANTE = "TipoComprobante";
    private static String PATH_TIPO_ESTADO = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\sfs\\Situacion.json";
    private static String TAG_TIPO_ESTADO = "ListaSituacion";

    private static String PATH_TIPO_OPERACION = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\sfs\\EquivalenciaTipoOperacion.json";
    private static String TAG_TIPO_OPERACION = "MapTipoOperacion";

    public static List<TipoComprobante> obtenerListaTipoComprobante() throws IOException {
        //String fileName = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\sfs\\TipoComprobante.json";
        List<TipoComprobante> lista = JsonUtil.getListByTag(PATH_TIPO_COMPROBANTE,TAG_TIPO_COMPROBANTE,TipoComprobante.class);
        //JsonUtil.getListByTag(PATH_TIPO_COMPROBANTE,TAG_TIPO_COMPROBANTE,TipoComprobante.class).forEach(System.out::println);
        return lista;
    }

    public static List<TipoEstado> obtenerListaEstado() throws IOException {
        return JsonUtil.getListByTag(PATH_TIPO_ESTADO,TAG_TIPO_ESTADO,TipoEstado.class);
    }

    public static List<Mapa> obtenerListaOperacion() throws IOException {
        return JsonUtil.getListByTag(PATH_TIPO_OPERACION,TAG_TIPO_OPERACION,Mapa.class);
    }
}
