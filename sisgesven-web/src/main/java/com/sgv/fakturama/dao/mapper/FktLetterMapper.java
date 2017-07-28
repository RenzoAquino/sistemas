package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktLetter;

public interface FktLetterMapper {
    int deleteByPrimaryKey(Long LETTER_PARENT_ID);

    int insert(FktLetter record);

    int insertSelective(FktLetter record);
}