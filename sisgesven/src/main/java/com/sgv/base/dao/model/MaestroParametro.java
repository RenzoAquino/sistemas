package com.sgv.base.dao.model;

public class MaestroParametro {
    private Long MPRM_ID;

    private Long MPRM_ID_PADRE;

    private String NPRM_CODIGO;

    private String NPRM_NOMBRE;

    private String NPRM_DESCRIPCION;

    private Integer NPRM_ORDEN;

    private String NPRM_ESTADO;

    public Long getMPRM_ID() {
        return MPRM_ID;
    }

    public void setMPRM_ID(Long MPRM_ID) {
        this.MPRM_ID = MPRM_ID;
    }

    public Long getMPRM_ID_PADRE() {
        return MPRM_ID_PADRE;
    }

    public void setMPRM_ID_PADRE(Long MPRM_ID_PADRE) {
        this.MPRM_ID_PADRE = MPRM_ID_PADRE;
    }

    public String getNPRM_CODIGO() {
        return NPRM_CODIGO;
    }

    public void setNPRM_CODIGO(String NPRM_CODIGO) {
        this.NPRM_CODIGO = NPRM_CODIGO;
    }

    public String getNPRM_NOMBRE() {
        return NPRM_NOMBRE;
    }

    public void setNPRM_NOMBRE(String NPRM_NOMBRE) {
        this.NPRM_NOMBRE = NPRM_NOMBRE;
    }

    public String getNPRM_DESCRIPCION() {
        return NPRM_DESCRIPCION;
    }

    public void setNPRM_DESCRIPCION(String NPRM_DESCRIPCION) {
        this.NPRM_DESCRIPCION = NPRM_DESCRIPCION;
    }

    public Integer getNPRM_ORDEN() {
        return NPRM_ORDEN;
    }

    public void setNPRM_ORDEN(Integer NPRM_ORDEN) {
        this.NPRM_ORDEN = NPRM_ORDEN;
    }

    public String getNPRM_ESTADO() {
        return NPRM_ESTADO;
    }

    public void setNPRM_ESTADO(String NPRM_ESTADO) {
        this.NPRM_ESTADO = NPRM_ESTADO;
    }
}