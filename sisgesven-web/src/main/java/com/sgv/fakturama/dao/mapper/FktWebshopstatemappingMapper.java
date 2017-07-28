package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktWebshopstatemapping;

public interface FktWebshopstatemappingMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktWebshopstatemapping record);

    int insertSelective(FktWebshopstatemapping record);

    FktWebshopstatemapping selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktWebshopstatemapping record);

    int updateByPrimaryKey(FktWebshopstatemapping record);
}