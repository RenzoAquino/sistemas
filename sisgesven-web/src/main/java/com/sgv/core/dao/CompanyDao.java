package com.sgv.core.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgv.core.dao.domain.Company;

@Component
//@Transactional
public class CompanyDao {

	@Autowired
	private final SqlSession sqlSession;

	public CompanyDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Company> findAll() {
		return this.sqlSession.selectList("findAll");
	}
	
	public void update(Company company) {
		this.sqlSession.update("update",company);
	}
}
