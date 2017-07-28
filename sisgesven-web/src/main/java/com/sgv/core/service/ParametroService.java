package com.sgv.core.service;

import java.util.List;

import com.sgv.core.dao.domain.Parametro;

public interface ParametroService {

	List<Parametro> obtenerListaNumeroPedidosReservados();
	
	List<Parametro> obtenerListaParameto(int codigoPadre);

}
