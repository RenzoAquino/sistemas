package models.sgv;

import io.ebean.Model;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name="secuencia")
public class Secuencia extends Model{
    public Secuencia(){
    }
    public Secuencia(String ruc,String codigo, String codigoPadre){
        this.id = new ParametroId(ruc, codigo,codigoPadre);
    }
    public Secuencia(String ruc, String codigo, String codigoPadre, String descripcion){
        this.id = new ParametroId(ruc, codigo,codigoPadre);
        this.valor = descripcion;
    }
    @EmbeddedId
    public ParametroId id;

    public String valor;
    public BigInteger secuencia;
    public int orden;
    public String etiqueta;
    public String descripcion;

    @Embedded
    public Auditoria auditoria;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Secuencia{");
        sb.append("id=").append(id);
        sb.append(", valor='").append(valor).append('\'');
        sb.append(", secuencia=").append(secuencia);
        sb.append(", orden=").append(orden);
        sb.append(", etiqueta='").append(etiqueta).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", auditoria=").append(auditoria);
        sb.append('}');
        return sb.toString();
    }
}
