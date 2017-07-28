package com.sgv.customer.procesar.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgv.customer.procesar.dao.domain.EquivalenciaProducto;
import com.sgv.customer.procesar.dao.mapper.EquivalenciaProductoMapper;

@Service
public class EquivalenciaProductoService {

    @Autowired
	private EquivalenciaProductoMapper equivalenciaProductoMapper;
	
	public List<EquivalenciaProducto> obtenerListaEquivalenciaProductos(String ruc) {
		return equivalenciaProductoMapper.obtenerListaEquivalenciaProductos(ruc);
	}

	public Map<String,EquivalenciaProducto> obtenerMapEquivalenciaProductos(String ruc) {
		return equivalenciaProductoMapper.obtenerMapEquivalenciaProductos(ruc);
	}
}
