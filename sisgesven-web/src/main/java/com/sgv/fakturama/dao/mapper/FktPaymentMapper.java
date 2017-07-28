package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktPayment;

public interface FktPaymentMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktPayment record);

    int insertSelective(FktPayment record);

    FktPayment selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktPayment record);

    int updateByPrimaryKey(FktPayment record);
}