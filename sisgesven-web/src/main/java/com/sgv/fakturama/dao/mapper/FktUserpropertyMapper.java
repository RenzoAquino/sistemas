package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktUserproperty;

public interface FktUserpropertyMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktUserproperty record);

    int insertSelective(FktUserproperty record);

    FktUserproperty selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktUserproperty record);

    int updateByPrimaryKey(FktUserproperty record);
}