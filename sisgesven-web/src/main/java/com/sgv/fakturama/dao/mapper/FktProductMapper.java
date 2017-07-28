package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktProduct;

public interface FktProductMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktProduct record);

    int insertSelective(FktProduct record);

    FktProduct selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktProduct record);

    int updateByPrimaryKeyWithBLOBs(FktProduct record);

    int updateByPrimaryKey(FktProduct record);
}