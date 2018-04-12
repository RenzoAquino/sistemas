package models.sgv;


import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="listaPrecio")
public class ListaPrecio extends Model {

    @Id
    public Long id;
    public String codigo;
    public String alias;
    public Contacto contacto;

    public Character vigente;
    public Date fechaInicio;
    public Date fechaTermino;

    @Embedded
    //@EmbeddedId
    public Auditoria auditoria;

    public static Finder<Long,ListaPrecio> find = new Finder<>(ListaPrecio.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListaPrecio{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", listado=").append(contacto);
        sb.append(", vigente=").append(vigente);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaTermino=").append(fechaTermino);
        sb.append('}');
        return sb.toString();
    }
}
