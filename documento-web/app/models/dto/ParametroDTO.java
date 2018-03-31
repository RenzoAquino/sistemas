package models.dto;

public class ParametroDTO {
    public ParametroDTO(){

    }
    public ParametroDTO(String codigo,String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    public String codigo;
    public String descripcion;

    @Override
    public String toString() {
        return "ParametroDTO{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
