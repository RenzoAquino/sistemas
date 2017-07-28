package com.sgv.fakturama.dao.mapper;

import com.sgv.fakturama.dao.model.Databasechangelog;

public interface DatabasechangelogMapper {
    int insert(Databasechangelog record);

    int insertSelective(Databasechangelog record);
}