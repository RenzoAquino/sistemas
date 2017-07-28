package com.sgv.customer.procesar.dto;

public class Producto {

	long id;
	String categoria;
	String numero;
	String nombre;
	double precio;
	String unidadMedida;
	Vat impuesto = new Vat();
	String nombreEquivalente;
	String descripcion;
	
	public Producto(){
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String getNombreEquivalente() {
		return nombreEquivalente;
	}
	public void setNombreEquivalente(String nombreEquivalente) {
		this.nombreEquivalente = nombreEquivalente;
	}
	public Vat getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Vat impuesto) {
		this.impuesto = impuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [id=");
		builder.append(id);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", unidadMedida=");
		builder.append(unidadMedida);
		builder.append(", impuesto=");
		builder.append(impuesto);
		builder.append(", nombreEquivalente=");
		builder.append(nombreEquivalente);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}

}
