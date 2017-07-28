package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktItemaccounttype;

public interface FktItemaccounttypeMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktItemaccounttype record);

    int insertSelective(FktItemaccounttype record);

    FktItemaccounttype selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktItemaccounttype record);

    int updateByPrimaryKey(FktItemaccounttype record);
}