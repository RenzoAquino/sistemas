package com.sgv.customer.procesar.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sgv.customer.procesar.dao.domain.EquivalenciaProducto;

@Mapper
public interface EquivalenciaProductoMapper {

	String QUERY = "SELECT PDR.ID 'producto.ID', PDR.ITEMNUMBER 'producto.ITEMNUMBER', PDR.NAME 'producto.NAME', PDR.PRICE1 'producto.PRICE1', PDR.QUANTITYUNIT 'producto.QUANTITYUNIT', VAT.ID 'producto.vat.ID', VAT.TAXVALUE 'producto.vat.TAXVALUE', EQP.EQPD_NOM_EQUIVALENTE 'equivalencia', EQP.EQPD_POSTFIJO 'postfijo' FROM sistemagestionventa.equivalencia_producto EQP, sistemafacturacion.fkt_product PDR, sistemafacturacion.fkt_vat VAT WHERE EQP.EQPD_PRD_ID = PDR.ID AND PDR.FK_VAT = VAT.ID AND EQP.VATNUMBER = #{myFilter}";
	
	@Select(QUERY)
	@MapKey("equivalencia")
	Map<String, EquivalenciaProducto> obtenerMapEquivalenciaProductos(@Param("myFilter")String ruc);
	
	List<EquivalenciaProducto> obtenerListaEquivalenciaProductos(@Param("myFilter")String ruc);
}
