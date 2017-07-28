package com.sgv.core.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sgv.core.dao.domain.Company;

@Mapper
public interface CompanyMapper {
    
    //@Select("SELECT * FROM company ORDER BY id")
    List<Company> findAll();
    
    Company findOne(Long id);
    
    void save(Company company);
    
    //@Update("UPDATE company SET name=#{name}, website=#{website} WHERE id=#{id}")
    void update(Company company);
    
    void delete(Company company);

	List<Company> findByFilter(@Param("myFilter")String filterText);
}
