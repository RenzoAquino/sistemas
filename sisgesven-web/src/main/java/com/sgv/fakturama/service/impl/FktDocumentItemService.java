package com.sgv.fakturama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.fakturama.dao.domain.FktDocumentitem;
import com.sgv.fakturama.dao.mapper.FktDocumentitemMapper;

@Service
public class FktDocumentItemService {

    @Autowired
	private FktDocumentitemMapper mapper;

	public void deleteByFKDocument(Long id) {
		mapper.deleteByFKDocument(id);
	}

	public int insertSelective(FktDocumentitem item) {
		return mapper.insertSelective(item);		
	}
	/*
	public int updateByPrimaryKeyWithBLOBs(FktDocumentitem item) {
		return mapper.updateByPrimaryKeyWithBLOBs(item);		
	}
	*/
}
