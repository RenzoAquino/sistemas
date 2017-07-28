package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktCategory;

public interface FktCategoryMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktCategory record);

    int insertSelective(FktCategory record);

    FktCategory selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktCategory record);

    int updateByPrimaryKey(FktCategory record);
}