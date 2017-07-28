package com.sgv.fakturama.dao.model;

import java.util.Date;

public class FktCategory {
    private Long ID;

    private String categoryName;

    private Date DATEADDED;

    private Boolean DELETED;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long ABSTRACTCATEGORY_PARENT;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public Long getABSTRACTCATEGORY_PARENT() {
        return ABSTRACTCATEGORY_PARENT;
    }

    public void setABSTRACTCATEGORY_PARENT(Long ABSTRACTCATEGORY_PARENT) {
        this.ABSTRACTCATEGORY_PARENT = ABSTRACTCATEGORY_PARENT;
    }
}