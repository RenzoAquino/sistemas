package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktProforma;

public interface FktProformaMapper {
    int deleteByPrimaryKey(Long PROFORMA_PARENT_ID);

    int insert(FktProforma record);

    int insertSelective(FktProforma record);
}