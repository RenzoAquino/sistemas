package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktBankaccount {
    private Long ID;

    private String ACCOUNTHOLDER;

    private Integer BANKCODE;

    private String BANKNAME;

    private String BIC;

    private Date DATEADDED;

    private Boolean DELETED;

    private String IBAN;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Date VALIDFROM;

    private Date VALIDTO;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getACCOUNTHOLDER() {
        return ACCOUNTHOLDER;
    }

    public void setACCOUNTHOLDER(String ACCOUNTHOLDER) {
        this.ACCOUNTHOLDER = ACCOUNTHOLDER;
    }

    public Integer getBANKCODE() {
        return BANKCODE;
    }

    public void setBANKCODE(Integer BANKCODE) {
        this.BANKCODE = BANKCODE;
    }

    public String getBANKNAME() {
        return BANKNAME;
    }

    public void setBANKNAME(String BANKNAME) {
        this.BANKNAME = BANKNAME;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
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

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
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
}