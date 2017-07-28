package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktProductoptions {
    private Long ID;

    private String ATTRIBUTEVALUE;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Integer SEQUENCENUMBER;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long FK_PRODUCT;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getATTRIBUTEVALUE() {
        return ATTRIBUTEVALUE;
    }

    public void setATTRIBUTEVALUE(String ATTRIBUTEVALUE) {
        this.ATTRIBUTEVALUE = ATTRIBUTEVALUE;
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

    public Integer getSEQUENCENUMBER() {
        return SEQUENCENUMBER;
    }

    public void setSEQUENCENUMBER(Integer SEQUENCENUMBER) {
        this.SEQUENCENUMBER = SEQUENCENUMBER;
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

    public Long getFK_PRODUCT() {
        return FK_PRODUCT;
    }

    public void setFK_PRODUCT(Long FK_PRODUCT) {
        this.FK_PRODUCT = FK_PRODUCT;
    }
}