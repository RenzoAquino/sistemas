package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktOffer;

public interface FktOfferMapper {
    int deleteByPrimaryKey(Long OFFER_PARENT_ID);

    int insert(FktOffer record);

    int insertSelective(FktOffer record);
}