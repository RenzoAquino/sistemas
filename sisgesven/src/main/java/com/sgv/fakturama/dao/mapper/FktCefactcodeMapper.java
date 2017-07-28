package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktCefactcode;

public interface FktCefactcodeMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktCefactcode record);

    int insertSelective(FktCefactcode record);

    FktCefactcode selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktCefactcode record);

    int updateByPrimaryKey(FktCefactcode record);
}