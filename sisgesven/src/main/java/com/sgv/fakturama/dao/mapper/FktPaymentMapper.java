package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktPayment;

public interface FktPaymentMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktPayment record);

    int insertSelective(FktPayment record);

    FktPayment selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktPayment record);

    int updateByPrimaryKey(FktPayment record);
}