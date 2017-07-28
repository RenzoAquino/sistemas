package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.domain.FktConfirmation;

public interface FktConfirmationMapper {
    int deleteByPrimaryKey(Long CONFIRMATION_PARENT_ID);

    int insert(FktConfirmation record);

    int insertSelective(FktConfirmation record);
}