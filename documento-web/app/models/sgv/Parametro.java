package models.sgv;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="maestro_parametro")
public class Parametro extends Model{
    public Parametro(){
    }
    public Parametro(String codigo, String descripcion){
        this.parametroId = new ParametroId(codigo,"");
        this.descripcion = descripcion;
    }
    public Parametro(String codigo, String codigoPadre, String descripcion){
        this.parametroId = new ParametroId(codigo,codigoPadre);
        this.descripcion = descripcion;
    }
    @EmbeddedId
    public ParametroId parametroId;
    public String descripcion;
    public int orden;
    @Embedded
    public Auditoria auditoria;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parametro{");
        sb.append("parametroId=").append(parametroId);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", orden=").append(orden);
        sb.append(", auditoria=").append(auditoria);
        sb.append('}');
        return sb.toString();
    }
}
