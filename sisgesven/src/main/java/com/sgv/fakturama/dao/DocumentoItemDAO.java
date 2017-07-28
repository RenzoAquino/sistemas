package com.sgv.fakturama.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.fakturama.dao.model.FktDocumentitem;

public interface DocumentoItemDAO {

	int insertSelective(FktDocumentitem item) throws PersistenceException;

	int deleteByFKDocument(Long id) throws PersistenceException;

}