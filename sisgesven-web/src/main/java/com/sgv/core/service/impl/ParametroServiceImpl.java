package com.sgv.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.common.constants.Constants;
import com.sgv.core.dao.domain.Parametro;
import com.sgv.core.dao.mapper.ParametroMapper;
import com.sgv.core.service.ParametroService;

@Service
public class ParametroServiceImpl implements ParametroService{

    @Autowired
	private ParametroMapper mapper;
	
	@Override
	public List<Parametro> obtenerListaNumeroPedidosReservados() {
		return obtenerListaParameto(Constants.PARAMETROS_COD_PADRE_LISTA_NUMERO_PEDIDOS_RESERVADOS);
	}

	@Override
	public List<Parametro> obtenerListaParameto(int codigoPadre) {
		return mapper.obtenerListaParameto(codigoPadre);
	}

}
