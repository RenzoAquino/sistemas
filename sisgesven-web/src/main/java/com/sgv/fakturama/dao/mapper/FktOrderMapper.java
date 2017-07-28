package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktOrder;

public interface FktOrderMapper {
    int deleteByPrimaryKey(Long ORDER_PARENT_ID);

    int insert(FktOrder record);

    int insertSelective(FktOrder record);
}