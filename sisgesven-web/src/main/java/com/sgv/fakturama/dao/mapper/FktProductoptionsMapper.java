package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktProductoptions;

public interface FktProductoptionsMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktProductoptions record);

    int insertSelective(FktProductoptions record);

    FktProductoptions selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktProductoptions record);

    int updateByPrimaryKey(FktProductoptions record);
}