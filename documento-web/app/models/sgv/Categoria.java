package models.sgv;

import io.ebean.Finder;
import models.Auditoria;
import models.dto.ParametroDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria extends Auditoria {

    @Id
    public Long id;
    public String codigo;
    public String nombre;
    public String descripcion;
    public Categoria categoriaPadre;
    public ParametroDTO tipoCategoria;

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
        sb.append(", usuarioCreacionRegistro='").append(usuarioCreacionRegistro).append('\'');
        sb.append(", usuarioModificacionRegistro='").append(usuarioModificacionRegistro).append('\'');
        sb.append(", fechaCreacionRegistro=").append(fechaCreacionRegistro);
        sb.append(", fechaModificacionRegistro=").append(fechaModificacionRegistro);
        sb.append(", estadoRegistro=").append(estadoRegistro);
        sb.append('}');
        return sb.toString();
    }
}
