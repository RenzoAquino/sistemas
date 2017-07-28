package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktProductblockprice;

public interface FktProductblockpriceMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktProductblockprice record);

    int insertSelective(FktProductblockprice record);

    FktProductblockprice selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktProductblockprice record);

    int updateByPrimaryKey(FktProductblockprice record);
}