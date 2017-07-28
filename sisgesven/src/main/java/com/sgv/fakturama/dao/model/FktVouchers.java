package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktVouchers {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private Boolean DISCOUNTED;

    private Boolean DONOTBOOK;

    private String DOCUMENTNUMBER;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Double PAIDVALUE;

    private Double TOTALVALUE;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Date VOUCHERDATE;

    private String VOUCHERNUMBER;

    private String VOUCHERTYPE;

    private Long FK_CATEGORY;

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

    public Boolean getDISCOUNTED() {
        return DISCOUNTED;
    }

    public void setDISCOUNTED(Boolean DISCOUNTED) {
        this.DISCOUNTED = DISCOUNTED;
    }

    public Boolean getDONOTBOOK() {
        return DONOTBOOK;
    }

    public void setDONOTBOOK(Boolean DONOTBOOK) {
        this.DONOTBOOK = DONOTBOOK;
    }

    public String getDOCUMENTNUMBER() {
        return DOCUMENTNUMBER;
    }

    public void setDOCUMENTNUMBER(String DOCUMENTNUMBER) {
        this.DOCUMENTNUMBER = DOCUMENTNUMBER;
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

    public Double getPAIDVALUE() {
        return PAIDVALUE;
    }

    public void setPAIDVALUE(Double PAIDVALUE) {
        this.PAIDVALUE = PAIDVALUE;
    }

    public Double getTOTALVALUE() {
        return TOTALVALUE;
    }

    public void setTOTALVALUE(Double TOTALVALUE) {
        this.TOTALVALUE = TOTALVALUE;
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

    public Date getVOUCHERDATE() {
        return VOUCHERDATE;
    }

    public void setVOUCHERDATE(Date VOUCHERDATE) {
        this.VOUCHERDATE = VOUCHERDATE;
    }

    public String getVOUCHERNUMBER() {
        return VOUCHERNUMBER;
    }

    public void setVOUCHERNUMBER(String VOUCHERNUMBER) {
        this.VOUCHERNUMBER = VOUCHERNUMBER;
    }

    public String getVOUCHERTYPE() {
        return VOUCHERTYPE;
    }

    public void setVOUCHERTYPE(String VOUCHERTYPE) {
        this.VOUCHERTYPE = VOUCHERTYPE;
    }

    public Long getFK_CATEGORY() {
        return FK_CATEGORY;
    }

    public void setFK_CATEGORY(Long FK_CATEGORY) {
        this.FK_CATEGORY = FK_CATEGORY;
    }
}