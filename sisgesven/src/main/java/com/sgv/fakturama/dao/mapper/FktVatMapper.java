package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktVat;

public interface FktVatMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktVat record);

    int insertSelective(FktVat record);

    FktVat selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktVat record);

    int updateByPrimaryKey(FktVat record);
}