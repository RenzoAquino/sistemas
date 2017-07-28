package com.sgv.customer.procesar.dto;

public class PersonaJuridica {


	String ruc;
	String razonSocial;
	Direccion direccion;

	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "PersonaJuridica [ruc=" + ruc + ", razonSocial=" + razonSocial + ", direccion=" + direccion + "]";
	}
	
}
