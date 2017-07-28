package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktTextmodule;

public interface FktTextmoduleMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktTextmodule record);

    int insertSelective(FktTextmodule record);

    FktTextmodule selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktTextmodule record);

    int updateByPrimaryKeyWithBLOBs(FktTextmodule record);

    int updateByPrimaryKey(FktTextmodule record);
}