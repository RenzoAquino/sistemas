package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktIndividualdocumentinfo {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private String NOVATDESCRIPTION;

    private String NOVATNAME;

    private String PAYMENTDESCRIPTION;

    private String PAYMENTNAME;

    private String PAYMENTTEXT;

    private Integer SHIPPINGAUTOVAT;

    private String SHIPPINGDESCRIPTION;

    private String SHIPPINGNAME;

    private Double SHIPPINGVALUE;

    private String SHIPPINGVATDESCRIPTION;

    private Double SHIPPINGVATVALUE;

    private Date VALIDFROM;

    private Date VALIDTO;

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

    public String getNOVATDESCRIPTION() {
        return NOVATDESCRIPTION;
    }

    public void setNOVATDESCRIPTION(String NOVATDESCRIPTION) {
        this.NOVATDESCRIPTION = NOVATDESCRIPTION;
    }

    public String getNOVATNAME() {
        return NOVATNAME;
    }

    public void setNOVATNAME(String NOVATNAME) {
        this.NOVATNAME = NOVATNAME;
    }

    public String getPAYMENTDESCRIPTION() {
        return PAYMENTDESCRIPTION;
    }

    public void setPAYMENTDESCRIPTION(String PAYMENTDESCRIPTION) {
        this.PAYMENTDESCRIPTION = PAYMENTDESCRIPTION;
    }

    public String getPAYMENTNAME() {
        return PAYMENTNAME;
    }

    public void setPAYMENTNAME(String PAYMENTNAME) {
        this.PAYMENTNAME = PAYMENTNAME;
    }

    public String getPAYMENTTEXT() {
        return PAYMENTTEXT;
    }

    public void setPAYMENTTEXT(String PAYMENTTEXT) {
        this.PAYMENTTEXT = PAYMENTTEXT;
    }

    public Integer getSHIPPINGAUTOVAT() {
        return SHIPPINGAUTOVAT;
    }

    public void setSHIPPINGAUTOVAT(Integer SHIPPINGAUTOVAT) {
        this.SHIPPINGAUTOVAT = SHIPPINGAUTOVAT;
    }

    public String getSHIPPINGDESCRIPTION() {
        return SHIPPINGDESCRIPTION;
    }

    public void setSHIPPINGDESCRIPTION(String SHIPPINGDESCRIPTION) {
        this.SHIPPINGDESCRIPTION = SHIPPINGDESCRIPTION;
    }

    public String getSHIPPINGNAME() {
        return SHIPPINGNAME;
    }

    public void setSHIPPINGNAME(String SHIPPINGNAME) {
        this.SHIPPINGNAME = SHIPPINGNAME;
    }

    public Double getSHIPPINGVALUE() {
        return SHIPPINGVALUE;
    }

    public void setSHIPPINGVALUE(Double SHIPPINGVALUE) {
        this.SHIPPINGVALUE = SHIPPINGVALUE;
    }

    public String getSHIPPINGVATDESCRIPTION() {
        return SHIPPINGVATDESCRIPTION;
    }

    public void setSHIPPINGVATDESCRIPTION(String SHIPPINGVATDESCRIPTION) {
        this.SHIPPINGVATDESCRIPTION = SHIPPINGVATDESCRIPTION;
    }

    public Double getSHIPPINGVATVALUE() {
        return SHIPPINGVATVALUE;
    }

    public void setSHIPPINGVATVALUE(Double SHIPPINGVATVALUE) {
        this.SHIPPINGVATVALUE = SHIPPINGVATVALUE;
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