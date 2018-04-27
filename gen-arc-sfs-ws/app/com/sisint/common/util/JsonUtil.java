package com.sisint.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.libs.Json;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtil<T> {

    public static <T> List<T> getListByTag(String fileName, String tagName, Class<T> clase) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(FileUtil.getISOfFile(fileName));
        List<T> lista = new ArrayList<>();

        JsonNode jsonNode = rootNode.path(tagName);
        Iterator<JsonNode> elements = jsonNode.elements();
        elements.forEachRemaining(json -> {
                    lista.add(Json.fromJson(json, clase));
                }
        );

        return lista;
    }
}
