package repository.sgv;

import commons.util.DBConnectionUtil;
import io.ebean.EbeanServer;

public class SVGConnection {
    public static EbeanServer db = DBConnectionUtil.getDBServerSGV();
}
