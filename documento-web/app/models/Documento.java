package models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Documento extends Model{
    @Id
    @Constraints.Min(1)
    @Constraints.Required
    public Long id;
    @Constraints.Required
    public String typeDocumento;
    @Constraints.MaxLength(13)
    @Constraints.MinLength(5)
    @Constraints.Required
    public String name;
    @Constraints.Max(1000)
    @Constraints.Min(10)
    @Constraints.Required
    public BigDecimal igv;
    @Constraints.Required
    public String menssage1;
    public String menssage2;
    public String menssage3;

    public static Finder<Long,Documento> find = new Finder<>(Documento.class);
    /*
    private static Set<Documento> documentos;

    static{
        documentos = new HashSet<Documento>();
        documentos.add(new Documento(2L,"Order","PD01-00000002"));
        documentos.add(new Documento(10L,"Order","PD01-00000011"));
    }

    public static Set<Documento> obtenerTodos(){
        return documentos;
    }
    public static Documento buscarPorId(Long id){
        for (Documento documento: documentos){
            if(id.equals(documento.id)) return documento;
        }
        return null;
    }
    public static void guardar(Documento documento){
        documentos.add(documento);
    }
    public static void eliminar(Documento documento){
        documentos.remove(documento);
    }

    public Documento() {
    }

    public Documento(Long id, String type, String name) {

        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Long getId() {

        return id;
    }
    */
}
