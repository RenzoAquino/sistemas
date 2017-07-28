package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktBankaccount;

public interface FktBankaccountMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktBankaccount record);

    int insertSelective(FktBankaccount record);

    FktBankaccount selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktBankaccount record);

    int updateByPrimaryKey(FktBankaccount record);
}