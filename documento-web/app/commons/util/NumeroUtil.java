package commons.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumeroUtil {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        //https://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html
        bd = bd.setScale(places, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    public static String roundString(double value, int places) throws Exception {
        String result = ""+round(value,places);
        //String tmp = (result.split("\\.")[1].length() == 1)?result.concat("0"):result;

        String part01 = result.split("\\.")[0];
        String part02 = result.split("\\.")[1];
        //System.out.println("result ["+result+"]");
        //System.out.println("roundString ["+result.split("\\.")[1]+"]");
        part02 = StringUtil.completarTamanio(part02,places,"0",true);
        return part01.concat(".").concat(part02);// (part02.length() == 3)?result:part01.concat(".").concat(part02) ;
    }
}
