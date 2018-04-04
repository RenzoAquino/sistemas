package models.sunat.facturador;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TXXXX_BANDFACT")
public class BandejaFactura extends Model {

    @EmbeddedId BandejaFacturaId id;

    public String FEC_CARG;
    public String FEC_GENE;
    public String  FEC_ENVI;
    public String  DES_OBSE;
    public String  NOM_ARCH;
    public String  IND_SITU;
    public String  TIP_ARCH;
    public String  FIRM_DIGITAL;

    public static Finder<BandejaFacturaId,BandejaFactura> find = new Finder<>(BandejaFactura.class);

    @Override
    public String toString() {
        return "BandejaFactura{" +
                "id=" + id +
                ", FEC_CARG=" + FEC_CARG +
                ", FEC_GENE=" + FEC_GENE +
                ", FEC_ENVI=" + FEC_ENVI +
                ", DES_OBSE='" + DES_OBSE + '\'' +
                ", NOM_ARCH='" + NOM_ARCH + '\'' +
                ", IND_SITU='" + IND_SITU + '\'' +
                ", TIP_ARCH='" + TIP_ARCH + '\'' +
                ", FIRM_DIGITAL='" + FIRM_DIGITAL + '\'' +
                '}';
    }
}
