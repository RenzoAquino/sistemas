package models.sgv;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="parametro")
public class Parametro extends Model{
    public Parametro(){
    }
    public Parametro(String ruc, String codigo, String codigoPadre){
        this.id = new ParametroId(ruc,codigo,codigoPadre);
    }
    public Parametro(String ruc,String codigo, String codigoPadre, String valor){
        this.id = new ParametroId(ruc,codigo,codigoPadre);
        this.valor = valor;
    }
    @EmbeddedId
    public ParametroId id;

    public String valor;
    public String descripcion;
    public String etiqueta;
    public int orden;
    @Embedded
    public Auditoria auditoria;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parametro{");
        sb.append("id=").append(id);
        sb.append(", valor='").append(valor).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", etiqueta='").append(etiqueta).append('\'');
        sb.append(", orden=").append(orden);
        sb.append(", auditoria=").append(auditoria);
        sb.append('}');
        return sb.toString();
    }
}
