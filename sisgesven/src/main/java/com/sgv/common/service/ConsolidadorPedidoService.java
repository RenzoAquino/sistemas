package com.sgv.common.service;

import java.io.IOException;

import com.sgv.common.exception.BusinessException;
import com.sgv.common.vo.ConsolidadorPedidoVO;
import com.sgv.fakturama.dao.model.FktDocument;

public interface ConsolidadorPedidoService {

	public FktDocument consolidarPedido(ConsolidadorPedidoVO vo) throws BusinessException, IOException;
}