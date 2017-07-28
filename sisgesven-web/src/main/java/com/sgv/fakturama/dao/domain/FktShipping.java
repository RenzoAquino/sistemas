package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktShipping {
    private Long ID;

    private String AUTOVAT;

    private String CODE;

    private Date DATEADDED;

    private Boolean DELETED;

    private String DESCRIPTION;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Double SHIPPINGVALUE;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long SHIPPING_CATEGORIES;

    private Long FK_VAT;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAUTOVAT() {
        return AUTOVAT;
    }

    public void setAUTOVAT(String AUTOVAT) {
        this.AUTOVAT = AUTOVAT;
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

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
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

    public Double getSHIPPINGVALUE() {
        return SHIPPINGVALUE;
    }

    public void setSHIPPINGVALUE(Double SHIPPINGVALUE) {
        this.SHIPPINGVALUE = SHIPPINGVALUE;
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

    public Long getSHIPPING_CATEGORIES() {
        return SHIPPING_CATEGORIES;
    }

    public void setSHIPPING_CATEGORIES(Long SHIPPING_CATEGORIES) {
        this.SHIPPING_CATEGORIES = SHIPPING_CATEGORIES;
    }

    public Long getFK_VAT() {
        return FK_VAT;
    }

    public void setFK_VAT(Long FK_VAT) {
        this.FK_VAT = FK_VAT;
    }
}