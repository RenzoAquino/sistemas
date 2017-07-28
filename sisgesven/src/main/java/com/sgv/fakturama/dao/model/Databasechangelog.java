package com.sgv.fakturama.dao.model;

import java.util.Date;

public class Databasechangelog {
    private String ID;

    private String AUTHOR;

    private String FILENAME;

    private Date DATEEXECUTED;

    private Integer ORDEREXECUTED;

    private String EXECTYPE;

    private String MD5SUM;

    private String DESCRIPTION;

    private String COMMENTS;

    private String TAG;

    private String LIQUIBASE;

    private String CONTEXTS;

    private String LABELS;

    private String DEPLOYMENT_ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR = AUTHOR;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public Date getDATEEXECUTED() {
        return DATEEXECUTED;
    }

    public void setDATEEXECUTED(Date DATEEXECUTED) {
        this.DATEEXECUTED = DATEEXECUTED;
    }

    public Integer getORDEREXECUTED() {
        return ORDEREXECUTED;
    }

    public void setORDEREXECUTED(Integer ORDEREXECUTED) {
        this.ORDEREXECUTED = ORDEREXECUTED;
    }

    public String getEXECTYPE() {
        return EXECTYPE;
    }

    public void setEXECTYPE(String EXECTYPE) {
        this.EXECTYPE = EXECTYPE;
    }

    public String getMD5SUM() {
        return MD5SUM;
    }

    public void setMD5SUM(String MD5SUM) {
        this.MD5SUM = MD5SUM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getCOMMENTS() {
        return COMMENTS;
    }

    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public String getLIQUIBASE() {
        return LIQUIBASE;
    }

    public void setLIQUIBASE(String LIQUIBASE) {
        this.LIQUIBASE = LIQUIBASE;
    }

    public String getCONTEXTS() {
        return CONTEXTS;
    }

    public void setCONTEXTS(String CONTEXTS) {
        this.CONTEXTS = CONTEXTS;
    }

    public String getLABELS() {
        return LABELS;
    }

    public void setLABELS(String LABELS) {
        this.LABELS = LABELS;
    }

    public String getDEPLOYMENT_ID() {
        return DEPLOYMENT_ID;
    }

    public void setDEPLOYMENT_ID(String DEPLOYMENT_ID) {
        this.DEPLOYMENT_ID = DEPLOYMENT_ID;
    }
}