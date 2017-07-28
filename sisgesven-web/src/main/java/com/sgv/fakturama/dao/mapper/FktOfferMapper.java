package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktOffer;

public interface FktOfferMapper {
    int deleteByPrimaryKey(Long OFFER_PARENT_ID);

    int insert(FktOffer record);

    int insertSelective(FktOffer record);
}