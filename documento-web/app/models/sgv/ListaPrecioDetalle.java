package models.sgv;


import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="listaPrecioDetalle")
public class ListaPrecioDetalle extends Model {

    @Id
    public Long id;
    public String codigo;
    public String alias;
    public Double precio;

    public ListaPrecio listaPrecio;

    @Embedded
    //@EmbeddedId
    public Auditoria auditoria;

    public static Finder<Long,ListaPrecioDetalle> find = new Finder<>(ListaPrecioDetalle.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListaPrecioDetalle{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", listaPrecio=").append(listaPrecio);
        sb.append('}');
        return sb.toString();
    }
}
