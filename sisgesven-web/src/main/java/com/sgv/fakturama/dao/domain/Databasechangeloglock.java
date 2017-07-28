package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class Databasechangeloglock {
    private Integer ID;

    private Boolean LOCKED;

    private Date LOCKGRANTED;

    private String LOCKEDBY;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Boolean getLOCKED() {
        return LOCKED;
    }

    public void setLOCKED(Boolean LOCKED) {
        this.LOCKED = LOCKED;
    }

    public Date getLOCKGRANTED() {
        return LOCKGRANTED;
    }

    public void setLOCKGRANTED(Date LOCKGRANTED) {
        this.LOCKGRANTED = LOCKGRANTED;
    }

    public String getLOCKEDBY() {
        return LOCKEDBY;
    }

    public void setLOCKEDBY(String LOCKEDBY) {
        this.LOCKEDBY = LOCKEDBY;
    }
}