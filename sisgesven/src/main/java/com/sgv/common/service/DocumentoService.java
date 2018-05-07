package com.sgv.common.service;

import java.io.IOException;
import java.util.List;

import com.sgv.common.exception.BusinessException;
import org.apache.ibatis.exceptions.PersistenceException;

import com.sgv.common.exception.DocumentoException;
import com.sgv.common.vo.DocumentoVO;

public interface DocumentoService {

	void generarDocumentoSUNAT(String tipoOperacion)  throws DocumentoException, PersistenceException, IOException, BusinessException;

	DocumentoVO obtenerDocumento(DocumentoVO documento);

	List<DocumentoVO> obtenerListadoDocumento(DocumentoVO documento);

}