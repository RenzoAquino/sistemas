package models.sgv;

import io.ebean.Finder;
import io.ebean.Model;
import models.dto.ParametroDTO;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto extends Model {

    @Id
    public Long id;
    public String codigo;
    public String nombre;
    public String descripcion;
    public ParametroDTO unidadMedida;
    public Double precioVenta;
    public Double precioCompra;
    public ParametroDTO impuesto;
    public Double peso;
    public String rutaImagen;
    public String codigoBarra;

    public Double cantidadActual;
    public Double cantidadMinima;

    @Embedded
    //@EmbeddedId
    public Auditoria auditoria;

    public Categoria categoria;


    public static Finder<Long,Producto> find = new Finder<>(Producto.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Producto{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", unidadMedida=").append(unidadMedida);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append(", precioCompra=").append(precioCompra);
        sb.append(", impuesto=").append(impuesto);
        sb.append(", peso=").append(peso);
        sb.append(", rutaImagen=").append(rutaImagen);
        sb.append(", codigoBarra=").append(codigoBarra);
        sb.append(", cantidadActual=").append(cantidadActual);
        sb.append(", cantidadMinima=").append(cantidadMinima);
        sb.append(", categoria=").append(categoria);
        /*
        sb.append(", usuarioCreacionRegistro='").append(usuarioCreacionRegistro).append('\'');
        sb.append(", usuarioModificacionRegistro='").append(usuarioModificacionRegistro).append('\'');
        sb.append(", fechaCreacionRegistro=").append(fechaCreacionRegistro);
        sb.append(", fechaModificacionRegistro=").append(fechaModificacionRegistro);
        sb.append(", estadoRegistro=").append(estadoRegistro);
        */
        sb.append('}');
        return sb.toString();
    }
}
