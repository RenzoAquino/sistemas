package com.sgv.customer.procesar.dto;

import com.sgv.fakturama.dao.domain.FktDocumentitem;
import com.sgv.fakturama.dao.domain.FktVat;

public class Item extends FktDocumentitem{

	public Item(){
		super();
		setVat(new FktVat());
	}
	//double cantidad;
	double precioTotalItem;
	boolean existeEnDB = false; 
	//String descripcion;
	
	
	public boolean isExisteEnDB() {
		return existeEnDB;
	}
	public void setExisteEnDB(boolean existeEnDB) {
		this.existeEnDB = existeEnDB;
	}/*
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}*/
	public double getPrecioTotalItem() {
		return precioTotalItem;
	}
	public void setPrecioTotalItem(double precioItem) {
		this.precioTotalItem = precioItem;
	}
	/*
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [cantidad=");
		builder.append(getQUANTITY());
		builder.append(", precioItem=");
		builder.append(precioTotalItem);
		builder.append(", existeEnDB=");
		builder.append(existeEnDB);
		builder.append(", descripcion=");
		builder.append(getDESCRIPTION());
		builder.append(", id=");
		builder.append(getID());
		builder.append(", categoria=");
		//builder.append(categoria);
		builder.append(", numero=");
		builder.append(getITEMNUMBER());
		builder.append(", nombre=");
		builder.append(getNAME());
		builder.append(", precio=");
		builder.append(getPRICE());
		builder.append(", unidadMedida=");
		builder.append(getQUANTITYUNIT());
		builder.append(", impuesto=");
		builder.append(getVat().getTAXVALUE());
		builder.append(", nombreEquivalente=");
		//builder.append(nombreEquivalente);
		builder.append("]");
		return builder.toString();
	}

}
