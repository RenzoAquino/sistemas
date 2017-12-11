package controllers.dto;

public class DocumentoDTO {

    public String numero;
    public String tipoDocumento;
    public String rucEmpresa;

    @Override
    public String toString() {
        return "DocumentoDTO{" +
                "numero='" + numero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                '}';
    }
}
