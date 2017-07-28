package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.FktIndividualdocumentinfo;

public interface FktIndividualdocumentinfoMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktIndividualdocumentinfo record);

    int insertSelective(FktIndividualdocumentinfo record);

    FktIndividualdocumentinfo selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktIndividualdocumentinfo record);

    int updateByPrimaryKey(FktIndividualdocumentinfo record);
}