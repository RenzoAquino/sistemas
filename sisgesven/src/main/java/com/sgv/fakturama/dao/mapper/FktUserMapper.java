package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktUser;

public interface FktUserMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktUser record);

    int insertSelective(FktUser record);

    FktUser selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktUser record);

    int updateByPrimaryKey(FktUser record);
}