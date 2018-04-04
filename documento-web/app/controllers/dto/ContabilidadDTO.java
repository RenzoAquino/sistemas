package controllers.dto;

import models.dto.ParametroDTO;

import java.util.List;

public class ContabilidadDTO {

    public ParametroDTO tipoLibro;
    public ParametroDTO anio;
    public ParametroDTO mes;

    public String numero;
    public String tipoDocumento;
    public String rucEmpresa;
    public String tipoDetalle;
    public List<String> listaTipoAccion;

    @Override
    public String toString() {
        return "ContabilidadDTO{" +
                "tipoLibro='" + tipoLibro + '\'' +
                "anio='" + anio + '\'' +
                "mes='" + mes + '\'' +

                "numero='" + numero + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                ", tipoDetalle='" + tipoDetalle + '\'' +
                ", listaTipoAccion=" + listaTipoAccion +
                '}';
    }
}
