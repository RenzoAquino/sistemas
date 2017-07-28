package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktAddress {
    private Long ID;

    private String CITY;

    private String CITYADDON;

    private String COUNTRYCODE;

    private Date DATEADDED;

    private Boolean DELETED;

    private String MANUALADDRESS;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private String STREET;

    private Date VALIDFROM;

    private Date VALIDTO;

    private String ZIP;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getCITYADDON() {
        return CITYADDON;
    }

    public void setCITYADDON(String CITYADDON) {
        this.CITYADDON = CITYADDON;
    }

    public String getCOUNTRYCODE() {
        return COUNTRYCODE;
    }

    public void setCOUNTRYCODE(String COUNTRYCODE) {
        this.COUNTRYCODE = COUNTRYCODE;
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

    public String getMANUALADDRESS() {
        return MANUALADDRESS;
    }

    public void setMANUALADDRESS(String MANUALADDRESS) {
        this.MANUALADDRESS = MANUALADDRESS;
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

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
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

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }
}