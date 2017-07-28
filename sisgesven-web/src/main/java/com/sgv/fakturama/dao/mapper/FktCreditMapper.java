package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktCredit;

public interface FktCreditMapper {
    int deleteByPrimaryKey(Long CREDIT_PARENT_ID);

    int insert(FktCredit record);

    int insertSelective(FktCredit record);
}