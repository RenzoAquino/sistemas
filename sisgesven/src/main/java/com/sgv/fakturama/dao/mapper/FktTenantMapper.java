package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktTenant;

public interface FktTenantMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktTenant record);

    int insertSelective(FktTenant record);

    FktTenant selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktTenant record);

    int updateByPrimaryKey(FktTenant record);
}