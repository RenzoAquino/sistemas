package com.sgv.common.vo;

import java.util.ArrayList;
import java.util.List;

public class ConsolidadorPedidoVO {

	private String emisorRUC;
	private String clienteRUC;
	private String clienteNombre;
	private String fechaInicio;
	private String fechaFin;
	private String tipoDocumento;
	private boolean unido;
	private boolean deleted = false;
	private List<String> listaNumeroDocumento = new ArrayList<String>();
	
	public String getEmisorRUC() {
		return emisorRUC;
	}
	public void setEmisorRUC(String emisorRUC) {
		this.emisorRUC = emisorRUC;
	}
	public String getClienteRUC() {
		return clienteRUC;
	}
	public void setClienteRUC(String clienteRUC) {
		this.clienteRUC = clienteRUC;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public List<String> getListaNumeroDocumento() {
		return listaNumeroDocumento;
	}
	public void setListaNumeroDocumento(List<String> listaNumeroDocumento) {
		this.listaNumeroDocumento = listaNumeroDocumento;
	}
	public boolean isUnido() {
		return unido;
	}
	public void setUnido(boolean unido) {
		this.unido = unido;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsolidadorPedidoVO [");
		if (emisorRUC != null) {
			builder.append("emisorRUC=");
			builder.append(emisorRUC);
			builder.append(", ");
		}
		if (clienteRUC != null) {
			builder.append("clienteRUC=");
			builder.append(clienteRUC);
			builder.append(", ");
		}
		if (clienteNombre != null) {
			builder.append("clienteNombre=");
			builder.append(clienteNombre);
			builder.append(", ");
		}
		if (fechaInicio != null) {
			builder.append("fechaInicio=");
			builder.append(fechaInicio);
			builder.append(", ");
		}
		if (fechaFin != null) {
			builder.append("fechaFin=");
			builder.append(fechaFin);
			builder.append(", ");
		}
		if (tipoDocumento != null) {
			builder.append("tipoDocumento=");
			builder.append(tipoDocumento);
			builder.append(", ");
		}
		builder.append("unido=");
		builder.append(unido);
		builder.append(", ");
		if (listaNumeroDocumento != null) {
			builder.append("listaNumeroDocumento=");
			builder.append(listaNumeroDocumento);
		}
		builder.append("]");
		return builder.toString();
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
