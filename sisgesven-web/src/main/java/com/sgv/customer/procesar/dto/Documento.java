package com.sgv.customer.procesar.dto;

import java.util.ArrayList;
import java.util.List;

import com.sgv.fakturama.dao.domain.FktDocument;

public class Documento extends FktDocument {

	public Documento(String numero){
		this.numero = numero;
		this.emisor = new PersonaJuridica();
		this.receptor = new PersonaJuridica();
		this.listaItems = new ArrayList<Item>();
	}
	
	String numero;
	PersonaJuridica emisor;
	PersonaJuridica receptor;
	Double igv;
	Double precioTotal;
	String lugarEntrega;
	
	List<Item> listaItems;
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public PersonaJuridica getEmisor() {
		return emisor;
	}

	public void setEmisor(PersonaJuridica emisor) {
		this.emisor = emisor;
	}

	public PersonaJuridica getReceptor() {
		return receptor;
	}

	public void setReceptor(PersonaJuridica receptor) {
		this.receptor = receptor;
	}

	public List<Item> getListaItems() {
		return listaItems;
	}

	public void setListaItems(List<Item> listaItems) {
		this.listaItems = listaItems;
	}
	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}



	public String getLugarEntrega() {
		return lugarEntrega;
	}

	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Documento [");
		if (numero != null) {
			builder.append("numero=");
			builder.append(numero);
			builder.append(", ");
		}
		if (emisor != null) {
			builder.append("emisor=");
			builder.append(emisor);
			builder.append(", ");
		}
		if (receptor != null) {
			builder.append("receptor=");
			builder.append(receptor);
			builder.append(", ");
		}
		if (igv != null) {
			builder.append("igv=");
			builder.append(igv);
			builder.append(", ");
		}
		if (precioTotal != null) {
			builder.append("precioTotal=");
			builder.append(precioTotal);
			builder.append(", ");
		}
		if (lugarEntrega != null) {
			builder.append("lugarEntrega=");
			builder.append(lugarEntrega);
			builder.append(", ");
		}
		if (listaItems != null) {
			builder.append("listaItems=");
			for (Item item : listaItems) {
				builder.append("\n"+item);
			}
		}

		builder.append("]");
		return builder.toString();
	}
}
