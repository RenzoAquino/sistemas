package commons.util;

import commons.Constantes;
import io.ebean.Ebean;
import io.ebean.EbeanServer;

public class DBConnectionUtil {

    private static EbeanServer getDBServer(String id){
        return Ebean.getServer(id);
    }
    public static EbeanServer getDBServerSGV(){
        return getDBServer(Constantes.DB_ID_SGV);
    }
    public static EbeanServer getDBServerFacturador(){
        return getDBServer(Constantes.DB_ID_FACTURADOR_SUNAT);
    }
    public static EbeanServer getDBServerFakturama01(){
        return getDBServer(Constantes.DB_ID_FAKTURAMA01);
    }
}
