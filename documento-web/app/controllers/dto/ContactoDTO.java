package controllers.dto;

public class ContactoDTO extends CommonDTO {
    public String codigo;
    public String tipoContacto;
    public String tipoPersona;
    public String numero;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactoDTO{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", tipoContacto='").append(tipoContacto).append('\'');
        sb.append(", tipoPersona='").append(tipoPersona).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
