package com.sgv.base.dao.mapper;

import com.sgv.base.dao.model.TxxxxBandfact;
import org.apache.ibatis.annotations.Param;

public interface TxxxxBandfactMapper {
    int deleteByPrimaryKey(@Param("NUM_RUC") String NUM_RUC, @Param("TIP_DOCU") String TIP_DOCU, @Param("NUM_DOCU") String NUM_DOCU);

    int insert(TxxxxBandfact record);

    int insertSelective(TxxxxBandfact record);

    TxxxxBandfact selectByPrimaryKey(@Param("NUM_RUC") String NUM_RUC, @Param("TIP_DOCU") String TIP_DOCU, @Param("NUM_DOCU") String NUM_DOCU);

    int updateByPrimaryKeySelective(TxxxxBandfact record);

    int updateByPrimaryKey(TxxxxBandfact record);
}