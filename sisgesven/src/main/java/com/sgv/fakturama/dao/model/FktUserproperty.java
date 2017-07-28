package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktUserproperty {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private String t_USER;

    private Date VALIDFROM;

    private Date VALIDTO;

    private String t_VALUE;

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

    public String getT_USER() {
        return t_USER;
    }

    public void setT_USER(String t_USER) {
        this.t_USER = t_USER;
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

    public String getT_VALUE() {
        return t_VALUE;
    }

    public void setT_VALUE(String t_VALUE) {
        this.t_VALUE = t_VALUE;
    }
}