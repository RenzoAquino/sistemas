package com.sgv.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.core.dao.domain.Company;
import com.sgv.core.dao.mapper.CompanyMapper;

@Service
//@Transactional
public class CompanyService {

    @Autowired
	private CompanyMapper companyData;
	//@Autowired
	//private CompanyDao companyData;

	public List<Company> findAll() {
		return companyData.findAll();
	}

	public Company findOne(Long id) {
		return companyData.findOne(id);
	}

	public void save(Company company) {
		companyData.save(company);		
	}
	
	public void update(Company company) {
		companyData.update(company);		
	}
	
	public void delete(Company company) {
		companyData.delete(company);		
	}

	public List<Company> findByFilter(String filterText) {
		return companyData.findByFilter(filterText);
	}
	
}
