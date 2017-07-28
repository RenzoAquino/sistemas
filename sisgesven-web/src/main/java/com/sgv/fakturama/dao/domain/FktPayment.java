package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktPayment {
    private Long ID;

    private String CODE;

    private Date DATEADDED;

    private Boolean DELETED;

    private String DEPOSITTEXT;

    private String DESCRIPTION;

    private Integer DISCOUNTDAYS;

    private Double DISCOUNTVALUE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Integer NETDAYS;

    private String PAIDTEXT;

    private String UNPAIDTEXT;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long PAYMENT_CATEGORY;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public String getDEPOSITTEXT() {
        return DEPOSITTEXT;
    }

    public void setDEPOSITTEXT(String DEPOSITTEXT) {
        this.DEPOSITTEXT = DEPOSITTEXT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Integer getDISCOUNTDAYS() {
        return DISCOUNTDAYS;
    }

    public void setDISCOUNTDAYS(Integer DISCOUNTDAYS) {
        this.DISCOUNTDAYS = DISCOUNTDAYS;
    }

    public Double getDISCOUNTVALUE() {
        return DISCOUNTVALUE;
    }

    public void setDISCOUNTVALUE(Double DISCOUNTVALUE) {
        this.DISCOUNTVALUE = DISCOUNTVALUE;
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

    public Integer getNETDAYS() {
        return NETDAYS;
    }

    public void setNETDAYS(Integer NETDAYS) {
        this.NETDAYS = NETDAYS;
    }

    public String getPAIDTEXT() {
        return PAIDTEXT;
    }

    public void setPAIDTEXT(String PAIDTEXT) {
        this.PAIDTEXT = PAIDTEXT;
    }

    public String getUNPAIDTEXT() {
        return UNPAIDTEXT;
    }

    public void setUNPAIDTEXT(String UNPAIDTEXT) {
        this.UNPAIDTEXT = UNPAIDTEXT;
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

    public Long getPAYMENT_CATEGORY() {
        return PAYMENT_CATEGORY;
    }

    public void setPAYMENT_CATEGORY(Long PAYMENT_CATEGORY) {
        this.PAYMENT_CATEGORY = PAYMENT_CATEGORY;
    }
}