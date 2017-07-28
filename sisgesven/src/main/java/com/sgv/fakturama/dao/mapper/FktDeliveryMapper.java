package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktDelivery;

public interface FktDeliveryMapper {
    int deleteByPrimaryKey(Long DELIVERY_PARENT_ID);

    int insert(FktDelivery record);

    int insertSelective(FktDelivery record);
}