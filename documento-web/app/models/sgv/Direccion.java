package models.sgv;

import io.ebean.Finder;
import io.ebean.Model;
import models.dto.ParametroDTO;

import javax.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion extends Model {

    @Id
    public Long id;
    public String codigo;
    public String calle;
    public ParametroDTO distrito;
    public ParametroDTO ciudad;
    public ParametroDTO pais;
    public String codigoPostal;
    public String referencia;

    @Embedded
    //@EmbeddedId
    public Auditoria auditoria;

    public static Finder<Long,Direccion> find = new Finder<>(Direccion.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Direccion{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", calle='").append(calle).append('\'');
        sb.append(", distrito=").append(distrito);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", pais=").append(pais);
        sb.append(", codigoPostal='").append(codigoPostal).append('\'');
        sb.append(", referencia='").append(referencia).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
