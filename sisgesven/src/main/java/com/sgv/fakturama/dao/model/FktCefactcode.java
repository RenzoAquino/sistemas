package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktCefactcode {
    private Long ID;

    private String ABBREVIATION_DE;

    private String ABBREVIATION_EN;

    private String CODE;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private String NAME_DE;

    private String TARGET;

    private Date VALIDFROM;

    private Date VALIDTO;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getABBREVIATION_DE() {
        return ABBREVIATION_DE;
    }

    public void setABBREVIATION_DE(String ABBREVIATION_DE) {
        this.ABBREVIATION_DE = ABBREVIATION_DE;
    }

    public String getABBREVIATION_EN() {
        return ABBREVIATION_EN;
    }

    public void setABBREVIATION_EN(String ABBREVIATION_EN) {
        this.ABBREVIATION_EN = ABBREVIATION_EN;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public Date getDATEADDED() {
        return DATEADDED;
    }

    public void setDATEADDED(Date DATEADDED) {
        this.DATEADDED = DATEADDED;
    }

    public Boolean getDELETED() {
        return DELETED;
    }

    public void setDELETED(Boolean DELETED) {
        this.DELETED = DELETED;
    }

    public Date getMODIFIED() {
        return MODIFIED;
    }

    public void setMODIFIED(Date MODIFIED) {
        this.MODIFIED = MODIFIED;
    }

    public String getMODIFIEDBY() {
        return MODIFIEDBY;
    }

    public void setMODIFIEDBY(String MODIFIEDBY) {
        this.MODIFIEDBY = MODIFIEDBY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME_DE() {
        return NAME_DE;
    }

    public void setNAME_DE(String NAME_DE) {
        this.NAME_DE = NAME_DE;
    }

    public String getTARGET() {
        return TARGET;
    }

    public void setTARGET(String TARGET) {
        this.TARGET = TARGET;
    }

    public Date getVALIDFROM() {
        return VALIDFROM;
    }

    public void setVALIDFROM(Date VALIDFROM) {
        this.VALIDFROM = VALIDFROM;
    }

    public Date getVALIDTO() {
        return VALIDTO;
    }

    public void setVALIDTO(Date VALIDTO) {
        this.VALIDTO = VALIDTO;
    }
}