package models.sgv;


import io.ebean.Finder;
import models.Auditoria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="listaPrecioDetalle")
public class ListaPrecioDetalle extends Auditoria {

    @Id
    public Long id;
    public String codigo;
    public String alias;
    public Double precio;

    public ListaPrecio listaPrecio;

    public static Finder<Long,ListaPrecioDetalle> find = new Finder<>(ListaPrecioDetalle.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListaPrecioDetalle{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", listaPrecio=").append(listaPrecio);
        sb.append(", usuarioCreacionRegistro='").append(usuarioCreacionRegistro).append('\'');
        sb.append(", usuarioModificacionRegistro='").append(usuarioModificacionRegistro).append('\'');
        sb.append(", fechaCreacionRegistro=").append(fechaCreacionRegistro);
        sb.append(", fechaModificacionRegistro=").append(fechaModificacionRegistro);
        sb.append(", estadoRegistro=").append(estadoRegistro);
        sb.append('}');
        return sb.toString();
    }
}
