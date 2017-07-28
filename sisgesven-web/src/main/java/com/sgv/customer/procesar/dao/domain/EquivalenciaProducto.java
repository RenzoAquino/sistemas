package com.sgv.customer.procesar.dao.domain;

import com.sgv.fakturama.dao.domain.FktProduct;

public class EquivalenciaProducto {
	
	FktProduct producto;
	String equivalencia;
	String ruc;
	String postFijo;
	
	public FktProduct getProducto() {
		return producto;
	}
	public void setProducto(FktProduct producto) {
		this.producto = producto;
	}
	public String getEquivalencia() {
		return equivalencia;
	}
	public void setEquivalencia(String equivalencia) {
		this.equivalencia = equivalencia;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getPostFijo() {
		return postFijo;
	}
	public void setPostFijo(String postFijo) {
		this.postFijo = postFijo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalenciaProducto [");
		if (producto != null) {
			builder.append("producto=");
			builder.append(producto);
			builder.append(", ");
		}
		if (equivalencia != null) {
			builder.append("equivalencia=");
			builder.append(equivalencia);
			builder.append(", ");
		}
		if (ruc != null) {
			builder.append("ruc=");
			builder.append(ruc);
			builder.append(", ");
		}
		if (postFijo != null) {
			builder.append("postFijo=");
			builder.append(postFijo);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
