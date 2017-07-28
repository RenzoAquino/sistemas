package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktContact;

public interface FktContactMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktContact record);

    int insertSelective(FktContact record);

    FktContact selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktContact record);

    int updateByPrimaryKey(FktContact record);
}