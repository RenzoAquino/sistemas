package com.sisint.fakturama.handler;

import com.sisint.common.resources.Mapa;
import com.sisint.common.util.JsonUtil;

import java.io.IOException;
import java.util.List;

public class FakturamaHandler {

    private static String PATH_TIPO_DOCUMENTO = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\fakturama\\EquivalenciaTipoDocumento.json";
    private static String TAG_TIPO_DOCUMENTO = "MapTipoDocumento";


    public static List<Mapa> obtenerListaTipoDocumento() throws IOException {
        return JsonUtil.getListByTag(PATH_TIPO_DOCUMENTO,TAG_TIPO_DOCUMENTO,Mapa.class);
    }
}
