package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktRole;

public interface FktRoleMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktRole record);

    int insertSelective(FktRole record);

    FktRole selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktRole record);

    int updateByPrimaryKey(FktRole record);
}