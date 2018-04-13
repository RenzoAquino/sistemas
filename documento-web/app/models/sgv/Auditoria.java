package models.sgv;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class Auditoria implements Serializable {

    //protected Long id;
    //protected String codigo;
    public String usuarioCreacionRegistro;
    public String usuarioModificacionRegistro;
    public Timestamp fechaCreacionRegistro;
    public Timestamp fechaModificacionRegistro;
    public Character estadoRegistro; //E: Eliminado,C: Creado


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auditoria{");
        sb.append("usuarioCreacionRegistro='").append(usuarioCreacionRegistro).append('\'');
        sb.append(", usuarioModificacionRegistro='").append(usuarioModificacionRegistro).append('\'');
        sb.append(", fechaCreacionRegistro=").append(fechaCreacionRegistro);
        sb.append(", fechaModificacionRegistro=").append(fechaModificacionRegistro);
        sb.append(", estadoRegistro=").append(estadoRegistro);
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
        final Auditoria other = (Auditoria) obj;
        if ((this.usuarioCreacionRegistro == null) ? (other.usuarioCreacionRegistro != null) : !this.usuarioCreacionRegistro.equals(other.usuarioCreacionRegistro)) {
            return false;
        }
        if ((this.usuarioModificacionRegistro == null) ? (other.usuarioModificacionRegistro != null) : !this.usuarioModificacionRegistro.equals(other.usuarioModificacionRegistro)) {
            return false;
        }
        if ((this.fechaCreacionRegistro == null) ? (other.fechaCreacionRegistro != null) : !this.fechaCreacionRegistro.equals(other.fechaCreacionRegistro)) {
            return false;
        }
        if ((this.fechaModificacionRegistro == null) ? (other.fechaModificacionRegistro != null) : !this.fechaModificacionRegistro.equals(other.fechaModificacionRegistro)) {
            return false;
        }
        if ((this.estadoRegistro == null) ? (other.estadoRegistro != null) : !this.estadoRegistro.equals(other.estadoRegistro)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.usuarioCreacionRegistro != null ? this.usuarioCreacionRegistro.hashCode() : 0);
        hash = 89 * hash + (this.usuarioModificacionRegistro != null ? this.usuarioModificacionRegistro.hashCode() : 0);
        hash = 89 * hash + (this.fechaCreacionRegistro != null ? this.fechaCreacionRegistro.hashCode() : 0);
        hash = 89 * hash + (this.fechaModificacionRegistro != null ? this.fechaModificacionRegistro.hashCode() : 0);
        hash = 89 * hash + (this.estadoRegistro != null ? this.estadoRegistro.hashCode() : 0);
        return hash;
    }
}
