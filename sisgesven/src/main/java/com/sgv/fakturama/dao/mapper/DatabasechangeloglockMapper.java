package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.Databasechangeloglock;

public interface DatabasechangeloglockMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Databasechangeloglock record);

    int insertSelective(Databasechangeloglock record);

    Databasechangeloglock selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Databasechangeloglock record);

    int updateByPrimaryKey(Databasechangeloglock record);
}