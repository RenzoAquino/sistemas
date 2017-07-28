package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktVoucheritems {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private String ITEMVOUCHERTYPE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Integer POSNR;

    private Double PRICE;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long VOUCHERITEM_ACCOUNTTYPE;

    private Long FK_VAT;

    private Long FK_VOUCHER;

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

    public String getITEMVOUCHERTYPE() {
        return ITEMVOUCHERTYPE;
    }

    public void setITEMVOUCHERTYPE(String ITEMVOUCHERTYPE) {
        this.ITEMVOUCHERTYPE = ITEMVOUCHERTYPE;
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

    public Integer getPOSNR() {
        return POSNR;
    }

    public void setPOSNR(Integer POSNR) {
        this.POSNR = POSNR;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
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

    public Long getVOUCHERITEM_ACCOUNTTYPE() {
        return VOUCHERITEM_ACCOUNTTYPE;
    }

    public void setVOUCHERITEM_ACCOUNTTYPE(Long VOUCHERITEM_ACCOUNTTYPE) {
        this.VOUCHERITEM_ACCOUNTTYPE = VOUCHERITEM_ACCOUNTTYPE;
    }

    public Long getFK_VAT() {
        return FK_VAT;
    }

    public void setFK_VAT(Long FK_VAT) {
        this.FK_VAT = FK_VAT;
    }

    public Long getFK_VOUCHER() {
        return FK_VOUCHER;
    }

    public void setFK_VOUCHER(Long FK_VOUCHER) {
        this.FK_VOUCHER = FK_VOUCHER;
    }
}