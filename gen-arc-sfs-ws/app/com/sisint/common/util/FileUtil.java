package com.sisint.common.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    public static void readFile(String fileName){
        //String fileName = "D:\\WS_INTELLIJ\\sistemas\\play-java-rest-api-example\\public\\javascripts\\data\\TipoComprobante.json";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getLinesOfFile(String fileName){
        //String fileName = "c://lines.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    //.filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

        return list;
    }

    public static InputStream getISOfFile(String fileName) throws FileNotFoundException {
        return new FileInputStream(new File(fileName));
    }

    public static byte[] getByteArrayOfFile(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }
}
