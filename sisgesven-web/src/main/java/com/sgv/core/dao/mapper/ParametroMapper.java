package com.sgv.core.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgv.core.dao.domain.Parametro;

@Mapper
public interface ParametroMapper {

	List<Parametro> obtenerListaParameto(int codigoPadre);

}
