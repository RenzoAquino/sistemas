package controllers.dto;

import models.dto.ParametroDTO;

public class ContabilidadDTO {

    public ParametroDTO razonSocial;
    public ParametroDTO tipoLibro;
    public ParametroDTO anio;
    public ParametroDTO mes;

    @Override
    public String toString() {
        return "ContabilidadDTO{" +
                "razonSocial='" + razonSocial + '\'' +
                "tipoLibro='" + tipoLibro + '\'' +
                "anio='" + anio + '\'' +
                "mes='" + mes + '\'' +
                '}';
    }
}
