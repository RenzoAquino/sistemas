package models.sgv;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria extends Model {

    @Id
    public Long id;
    public String codigo;
    public String nombre;
    public String descripcion;
    public Categoria categoriaPadre;
    public Parametro tipoCategoria;

    @Embedded
    //@EmbeddedId
    public Auditoria auditoria;

    public static Finder<Long,Categoria> find = new Finder<>(Categoria.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categoria{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", categoriaPadre=").append(categoriaPadre);
        sb.append(", tipoCategoria=").append(tipoCategoria);
        sb.append('}');
        return sb.toString();
    }
}
