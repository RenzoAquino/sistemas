package com.sgv.core.dao.domain;

public class Parametro {

	Long id;
	Long idPadre;
	String codigo;
	String nombre;
	String descripcion;
	int orden;
	String estado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parametro [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (idPadre != null) {
			builder.append("idPadre=");
			builder.append(idPadre);
			builder.append(", ");
		}
		if (codigo != null) {
			builder.append("codigo=");
			builder.append(codigo);
			builder.append(", ");
		}
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (descripcion != null) {
			builder.append("descripcion=");
			builder.append(descripcion);
			builder.append(", ");
		}
		builder.append("orden=");
		builder.append(orden);
		builder.append(", ");
		if (estado != null) {
			builder.append("estado=");
			builder.append(estado);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
