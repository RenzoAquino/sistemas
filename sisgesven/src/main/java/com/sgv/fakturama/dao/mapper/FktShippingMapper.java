package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktShipping;

public interface FktShippingMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktShipping record);

    int insertSelective(FktShipping record);

    FktShipping selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktShipping record);

    int updateByPrimaryKey(FktShipping record);
}