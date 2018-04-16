package models.sgv;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//@MappedSuperclass
@Embeddable
public class ParametroId implements Serializable {

    private static final long serialVersionUID = 1L;

    public String ruc;
    public String codigo;
    @Column(name = "codigo_padre")
    public String codigoPadre;

    public ParametroId(String ruc, String codigo, String codigoPadre){
        this.ruc = ruc;
        this.codigo = codigo;
        this.codigoPadre = codigoPadre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ParametroId{");
        sb.append("ruc='").append(ruc).append('\'');
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", codigoPadre='").append(codigoPadre).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParametroId other = (ParametroId) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if ((this.codigoPadre == null) ? (other.codigoPadre != null) : !this.codigoPadre.equals(other.codigoPadre)) {
            return false;
        }
        if ((this.ruc == null) ? (other.ruc != null) : !this.ruc.equals(other.ruc)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 89 * hash + (this.codigoPadre != null ? this.codigoPadre.hashCode() : 0);
        hash = 89 * hash + (this.ruc != null ? this.ruc.hashCode() : 0);
        return hash;
    }
}
