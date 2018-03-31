package controllers.dto;

import models.dto.ParametroDTO;

import java.util.List;

public class DocumentoDTO {

    public String numero;
    public String tipoDocumento;
    public String rucEmpresa;
    public String tipoDetalle;
    public String tipoAccion;
    public List<String> listaTipoAccion;

    @Override
    public String toString() {
        return "DocumentoDTO{" +
                "numero='" + numero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                ", tipoDetalle='" + tipoDetalle + '\'' +
                ", tipoAccion='" + tipoAccion + '\'' +
                ", listaTipoAccion=" + listaTipoAccion +
                '}';
    }
}
