package com.sgv.base.dao.mapper;

import com.sgv.base.dao.model.ControlCompra;

public interface ControlCompraMapper {
    int deleteByPrimaryKey(Long CCMP_ID);

    int insert(ControlCompra record);

    int insertSelective(ControlCompra record);

    ControlCompra selectByPrimaryKey(Long CCMP_ID);

    int updateByPrimaryKeySelective(ControlCompra record);

    int updateByPrimaryKey(ControlCompra record);
}