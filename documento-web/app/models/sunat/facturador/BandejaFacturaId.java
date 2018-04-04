package models.sunat.facturador;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BandejaFacturaId implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //@Id
    public String  NUM_RUC;
    //@Id
    public String  TIP_DOCU;
    //@Id
    public String  NUM_DOCU;

    @Override
    public String toString() {
        return "BandejaFacturaId{" +
                "NUM_RUC='" + NUM_RUC + '\'' +
                ", TIP_DOCU='" + TIP_DOCU + '\'' +
                ", NUM_DOCU='" + NUM_DOCU + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BandejaFacturaId other = (BandejaFacturaId) obj;
        if ((this.NUM_RUC == null) ? (other.NUM_RUC != null) : !this.NUM_RUC.equals(other.NUM_RUC)) {
            return false;
        }
        if ((this.TIP_DOCU == null) ? (other.TIP_DOCU != null) : !this.TIP_DOCU.equals(other.TIP_DOCU)) {
            return false;
        }
        if ((this.NUM_DOCU == null) ? (other.NUM_DOCU != null) : !this.NUM_DOCU.equals(other.NUM_DOCU)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.NUM_RUC != null ? this.NUM_RUC.hashCode() : 0);
        hash = 89 * hash + (this.TIP_DOCU != null ? this.TIP_DOCU.hashCode() : 0);
        hash = 89 * hash + (this.NUM_DOCU != null ? this.NUM_DOCU.hashCode() : 0);
        return hash;
    }
}