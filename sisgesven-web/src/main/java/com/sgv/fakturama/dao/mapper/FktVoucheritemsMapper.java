package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktVoucheritems;

public interface FktVoucheritemsMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktVoucheritems record);

    int insertSelective(FktVoucheritems record);

    FktVoucheritems selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktVoucheritems record);

    int updateByPrimaryKey(FktVoucheritems record);
}