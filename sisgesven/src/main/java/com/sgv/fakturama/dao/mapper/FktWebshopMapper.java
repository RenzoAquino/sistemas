package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktWebshop;

public interface FktWebshopMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktWebshop record);

    int insertSelective(FktWebshop record);

    FktWebshop selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktWebshop record);

    int updateByPrimaryKey(FktWebshop record);
}