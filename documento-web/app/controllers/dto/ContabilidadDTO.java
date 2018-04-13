package controllers.dto;

import models.sgv.Parametro;

public class ContabilidadDTO {

    public Parametro razonSocial;
    public Parametro tipoLibro;
    public Parametro anio;
    public Parametro mes;

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
