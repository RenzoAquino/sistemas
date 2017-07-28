package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktVouchers;

public interface FktVouchersMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktVouchers record);

    int insertSelective(FktVouchers record);

    FktVouchers selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktVouchers record);

    int updateByPrimaryKey(FktVouchers record);
}