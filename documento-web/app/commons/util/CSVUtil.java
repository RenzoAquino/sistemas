package commons.util;

import models.sgv.ControlVenta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUtil {

    public static File generarCSV(List lista, String cabecera, String nombreArchivo) throws IOException {

        FileWriter writer = new FileWriter(nombreArchivo);

        writer.write(cabecera);
        for (Object string : lista) {
            //System.out.println("*********** " + string);
            writer.write((String)string);
        }

        writer.close();

        return new File(nombreArchivo);
    }
}
