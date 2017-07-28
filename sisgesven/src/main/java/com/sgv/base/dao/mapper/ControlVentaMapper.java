package com.sgv.base.dao.mapper;

import com.sgv.base.dao.model.ControlVenta;

public interface ControlVentaMapper {
    int deleteByPrimaryKey(Long CVNT_ID);

    int insert(ControlVenta record);

    int insertSelective(ControlVenta record);

    ControlVenta selectByPrimaryKey(Long CVNT_ID);

    int updateByPrimaryKeySelective(ControlVenta record);

    int updateByPrimaryKey(ControlVenta record);
}