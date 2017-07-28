package com.sgv.fakturama.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sgv.fakturama.dao.domain.FktContact;

@Mapper
public interface FktContactMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(FktContact record);

    int insertSelective(FktContact record);

    FktContact selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(FktContact record);

    int updateByPrimaryKey(FktContact record);

	FktContact obtenerContacto(String ruc);
}