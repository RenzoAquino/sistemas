package controllers.dto;

public class DocumentoDTO {

    public String numero;
    public String tipoDocumento;
    public String rucEmpresa;
    public String resumido;


    @Override
    public String toString() {
        return "DocumentoDTO{" +
                "resumido='" + resumido + '\'' +
                "numero='" + numero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                '}';
    }
}
