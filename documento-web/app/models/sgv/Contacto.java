package models.sgv;


import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.Date;

@Entity
@Table(name="contacto")
public class Contacto extends Model {

    @Id
    public Long id;
    public String codigo;
    public String codigoTipoContacto;
    public String codigoTipoPersona;

    public String numeroDocumento;
    public String alias;
    public String nombres;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String razonSocial;


    public Date fechaCreacion;
    @Constraints.Email
    public String email;
    public String telefonoFijo;
    public String telefonoMovil;
    public String webSite;
    public String comentario;

    public Direccion direccion = new Direccion();
    public ListaPrecio listaPrecio = new ListaPrecio();

    @Embedded
    public Auditoria auditoria;

    public static Finder<Long,Contacto> find = new Finder<>(Contacto.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contacto{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", codigoTipoContacto='").append(codigoTipoContacto).append('\'');
        sb.append(", codigoTipoPersona='").append(codigoTipoPersona).append('\'');
        sb.append(", numeroDocumento='").append(numeroDocumento).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", nombres='").append(nombres).append('\'');
        sb.append(", apellidoPaterno='").append(apellidoPaterno).append('\'');
        sb.append(", apellidoMaterno='").append(apellidoMaterno).append('\'');
        sb.append(", razonSocial='").append(razonSocial).append('\'');
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefonoFijo='").append(telefonoFijo).append('\'');
        sb.append(", telefonoMovil='").append(telefonoMovil).append('\'');
        sb.append(", webSite='").append(webSite).append('\'');
        sb.append(", comentario='").append(comentario).append('\'');
        sb.append(", direccion=").append(direccion);
        sb.append(", auditoria=").append(auditoria);
        sb.append('}');
        return sb.toString();
    }
}
