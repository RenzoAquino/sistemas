package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktWebshopstatemapping {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private String FAKTURAMAORDERSTATE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Date VALIDFROM;

    private Date VALIDTO;

    private String WEBSHOPSTATE;

    private Long FK_WEBSHOP;

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

    public String getFAKTURAMAORDERSTATE() {
        return FAKTURAMAORDERSTATE;
    }

    public void setFAKTURAMAORDERSTATE(String FAKTURAMAORDERSTATE) {
        this.FAKTURAMAORDERSTATE = FAKTURAMAORDERSTATE;
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

    public String getWEBSHOPSTATE() {
        return WEBSHOPSTATE;
    }

    public void setWEBSHOPSTATE(String WEBSHOPSTATE) {
        this.WEBSHOPSTATE = WEBSHOPSTATE;
    }

    public Long getFK_WEBSHOP() {
        return FK_WEBSHOP;
    }

    public void setFK_WEBSHOP(Long FK_WEBSHOP) {
        this.FK_WEBSHOP = FK_WEBSHOP;
    }
}