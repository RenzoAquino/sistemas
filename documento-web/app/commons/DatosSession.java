package commons;

import models.sgv.Secuencia;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DatosSession {
    private static DatosSession ourInstance = new DatosSession();

    public static DatosSession getInstance() {
        return ourInstance;
    }

    private DatosSession() {
    }
    public final String ruc = "20477954350";
    private Map<String,Secuencia> mapSecuencia = new HashMap<String,Secuencia>();

    public Secuencia getSecuencia(String key){
        System.out.println("===============================DatosSession.getSecuencia : id ["+key+"] - "+mapSecuencia);
        return mapSecuencia.getOrDefault(key, new Secuencia());
    }
    public void putSecuencia(Secuencia sec){
        mapSecuencia.put(sec.id.toString(), sec);
        System.out.println("===============================DatosSession.putSecuencia : id ["+sec.id.toString()+"] - "+mapSecuencia);
    }
}
