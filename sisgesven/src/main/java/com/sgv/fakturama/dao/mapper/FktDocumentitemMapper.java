package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktDocumentitem;

public interface FktDocumentitemMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktDocumentitem record);

    int insertSelective(FktDocumentitem record);

    FktDocumentitem selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktDocumentitem record);

    int updateByPrimaryKeyWithBLOBs(FktDocumentitem record);

    int updateByPrimaryKey(FktDocumentitem record);
}