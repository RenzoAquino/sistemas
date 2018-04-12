package models.sgv;


import io.ebean.Finder;
import models.Auditoria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="listaPrecio")
public class ListaPrecio extends Auditoria {

    @Id
    public Long id;
    public String codigo;
    public String alias;
    public Contacto contacto;

    public Character vigente;
    public Date fechaInicio;
    public Date fechaTermino;

    public static Finder<Long,ListaPrecio> find = new Finder<>(ListaPrecio.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListaPrecio{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", contacto=").append(contacto);
        sb.append(", vigente=").append(vigente);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaTermino=").append(fechaTermino);
        sb.append(", usuarioCreacionRegistro='").append(usuarioCreacionRegistro).append('\'');
        sb.append(", usuarioModificacionRegistro='").append(usuarioModificacionRegistro).append('\'');
        sb.append(", fechaCreacionRegistro=").append(fechaCreacionRegistro);
        sb.append(", fechaModificacionRegistro=").append(fechaModificacionRegistro);
        sb.append(", estadoRegistro=").append(estadoRegistro);
        sb.append('}');
        return sb.toString();
    }
}
