package controllers.dto;

import models.dto.ParametroDTO;

import java.util.List;

public class DocumentoDTO {

    public ParametroDTO tipoDocumento;

    public String numero;
    //public String tipoDocumento;
    public String rucEmpresa;
    public String tipoDetalle;
    public List<String> listaTipoAccion;

    @Override
    public String toString() {
        return "DocumentoDTO{" +
                "numero='" + numero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                //", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                ", tipoDetalle='" + tipoDetalle + '\'' +
                ", listaTipoAccion=" + listaTipoAccion +
                '}';
    }
}
