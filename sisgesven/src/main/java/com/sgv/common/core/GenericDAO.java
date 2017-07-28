package com.sgv.common.core;

import org.apache.ibatis.session.SqlSession;

import com.sgv.common.util.DBSessionUtil;

public class GenericDAO {

    protected SqlSession session = null;

    public GenericDAO(){
        this.session = DBSessionUtil.getSession();
    }

    public <T> T getMapper (Class<T> type){
    	return session.getMapper(type);
    }

}
