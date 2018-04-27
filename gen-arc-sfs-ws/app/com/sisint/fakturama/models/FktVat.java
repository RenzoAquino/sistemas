package com.sisint.fakturama.models;

import java.util.Date;

public class FktVat {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private String DESCRIPTION;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Double TAXVALUE;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long VAT_CATEGORY;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Double getTAXVALUE() {
        return TAXVALUE;
    }

    public void setTAXVALUE(Double TAXVALUE) {
        this.TAXVALUE = TAXVALUE;
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

    public Long getVAT_CATEGORY() {
        return VAT_CATEGORY;
    }

    public void setVAT_CATEGORY(Long VAT_CATEGORY) {
        this.VAT_CATEGORY = VAT_CATEGORY;
    }
}