package com.sgv.customer.procesar.dto;

import java.util.ArrayList;
import java.util.List;

public class OrdenCompra {

	String numero;
	List<Documento> listaDocumento;
	
	public OrdenCompra(String numero){
		this.numero = numero;
		this. listaDocumento = new ArrayList<Documento>();
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<Documento> getListaDocumento() {
		return listaDocumento;
	}
	public void setListaDocumento(List<Documento> listaDocumento) {
		this.listaDocumento = listaDocumento;
	}
}
