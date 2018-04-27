package com.sisint.common.util;

import com.sisint.common.resources.Mapa;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertUtil<T> {

    public static  Map<String,String> convertListMapaToMap(List<Mapa> list){

        Map result1 = list.stream()
                .sorted(Comparator.comparing(Mapa::getKey).reversed())
                .collect(
                        Collectors.toMap(
                                Mapa::getKey, Mapa::getValue, // key = key, value = value
                                (oldValue, newValue) -> newValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        return result1;
    }
}
