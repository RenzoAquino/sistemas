package controllers.dto;

import models.sgv.Parametro;

import java.util.List;

public class DocumentoDTO {

    public Parametro tipoDocumento;

    public String numero;
    public String radTipoOperacion;
    public String rucEmpresa;
    public String tipoDetalle;
    public List<String> listaTipoAccion;

    @Override
    public String toString() {
        return "DocumentoDTO{" +
                "numero='" + numero + '\'' +
                ", radTipoOperacion='" + radTipoOperacion + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", rucEmpresa='" + rucEmpresa + '\'' +
                ", tipoDetalle='" + tipoDetalle + '\'' +
                ", listaTipoAccion=" + listaTipoAccion +
                '}';
    }
}
