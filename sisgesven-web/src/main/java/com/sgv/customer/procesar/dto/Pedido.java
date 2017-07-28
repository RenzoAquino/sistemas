package com.sgv.customer.procesar.dto;

import java.util.Date;
import java.util.List;

public class Pedido {
	
	Long id;
	Date fecha;
	List<Documento> ordenCOmpra;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Documento> getOrdenCOmpra() {
		return ordenCOmpra;
	}
	public void setOrdenCOmpra(List<Documento> ordenCOmpra) {
		this.ordenCOmpra = ordenCOmpra;
	}
}
