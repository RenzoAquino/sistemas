package com.sgv.fakturama.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.vo.ConsolidadorPedidoVO;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.model.FktDocument;

public interface DocumentDAO {

	/**
	     * Select instance of Person from the database.
	     * @param person the instance to be persisted.
	     */
	FktDocument selectByNumero(DocumentoVO documento)throws PersistenceException;
	
	FktDocument selectByNumeroBasico(DocumentoVO documento)throws PersistenceException;

	FktDocument selectById(Long id)throws PersistenceException;

	List<FktDocument> obtenerPedidos(ConsolidadorPedidoVO vo)throws PersistenceException;

	void resetearPedido(FktDocument fktDocument)throws PersistenceException;

	void updateByPrimaryKey(FktDocument fktDocument)throws PersistenceException;

}