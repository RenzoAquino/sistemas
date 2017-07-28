package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktTextmodule {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long TEXTMODULE_CATEGORIES;

    private String t_TEXT;

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

    public Long getTEXTMODULE_CATEGORIES() {
        return TEXTMODULE_CATEGORIES;
    }

    public void setTEXTMODULE_CATEGORIES(Long TEXTMODULE_CATEGORIES) {
        this.TEXTMODULE_CATEGORIES = TEXTMODULE_CATEGORIES;
    }

    public String getT_TEXT() {
        return t_TEXT;
    }

    public void setT_TEXT(String t_TEXT) {
        this.t_TEXT = t_TEXT;
    }
}