package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktAddress;

public interface FktAddressMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktAddress record);

    int insertSelective(FktAddress record);

    FktAddress selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktAddress record);

    int updateByPrimaryKey(FktAddress record);
}