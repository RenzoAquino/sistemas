package commons.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {

    public static String convertirDateAString(Date fecha, String formato){
        DateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha);
    }
}
