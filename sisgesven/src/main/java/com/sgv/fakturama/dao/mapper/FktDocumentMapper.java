package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktDocument;

public interface FktDocumentMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktDocument record);

    int insertSelective(FktDocument record);

    FktDocument selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktDocument record);

    int updateByPrimaryKeyWithBLOBs(FktDocument record);

    int updateByPrimaryKey(FktDocument record);
}