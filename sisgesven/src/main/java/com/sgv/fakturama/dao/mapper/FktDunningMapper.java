package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktDunning;

public interface FktDunningMapper {
    int deleteByPrimaryKey(Long DUNNING_PARENT_ID);

    int insert(FktDunning record);

    int insertSelective(FktDunning record);

    FktDunning selectByPrimaryKey(Long DUNNING_PARENT_ID);

    int updateByPrimaryKeySelective(FktDunning record);

    int updateByPrimaryKey(FktDunning record);
}