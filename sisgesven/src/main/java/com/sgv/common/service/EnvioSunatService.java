package com.sgv.common.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.exception.BusinessException;
import com.sgv.common.exception.DocumentoException;
import com.sgv.common.vo.DocumentoVO;
import com.sgv.fakturama.dao.model.FktDocument;

public interface EnvioSunatService {

	public FktDocument enviarDocumentoSUNAT(DocumentoVO documento) throws BusinessException, PersistenceException, DocumentoException, IOException;
}