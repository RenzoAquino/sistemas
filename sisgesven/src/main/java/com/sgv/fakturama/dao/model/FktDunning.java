package com.sgv.fakturama.dao.model;

public class FktDunning {
    private Long DUNNING_PARENT_ID;

    private Integer DUNNINGLEVEL;

    public Long getDUNNING_PARENT_ID() {
        return DUNNING_PARENT_ID;
    }

    public void setDUNNING_PARENT_ID(Long DUNNING_PARENT_ID) {
        this.DUNNING_PARENT_ID = DUNNING_PARENT_ID;
    }

    public Integer getDUNNINGLEVEL() {
        return DUNNINGLEVEL;
    }

    public void setDUNNINGLEVEL(Integer DUNNINGLEVEL) {
        this.DUNNINGLEVEL = DUNNINGLEVEL;
    }
}