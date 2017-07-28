package com.sgv.common.vo;

import com.sgv.common.constants.TypeDocument_ES;
import com.sgv.common.constants.TypeOperationSUNAT;

public class DocumentoVO {

	private String emisorRUC;
	private String documentoTipo;
	private String documentoNumero;
	private String tipoOperacion;
	private boolean eliminado = false;
	
	public DocumentoVO() {
	}
	public DocumentoVO(String documentoNumero, String documentoTipo) {
		this.documentoNumero = documentoNumero;
		this.documentoTipo = documentoTipo;
	}
	
	public String getEmisorRUC() {
		return emisorRUC;
	}
	public void setEmisorRUC(String emisorRUC) {
		this.emisorRUC = emisorRUC;
	}
	public String getDocumentoTipo() {
		return documentoTipo;
	}
	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}
	public String getDocumentoNumero() {
		return documentoNumero;
	}
	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}
	public void traducirVariablesFakturamaASUNAT(){
		try {
			this.documentoTipo = TypeDocument_ES.valueOf(documentoTipo).getText();
			this.tipoOperacion = TypeOperationSUNAT.valueOf(tipoOperacion).getText();	
		} catch (Exception e) {
			System.out.println("***SE GENERO UN ERROR AL TRADUCIR LAS VARIABLES****");
		}		
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentoVO [");
		if (emisorRUC != null) {
			builder.append("emisorRUC=");
			builder.append(emisorRUC);
			builder.append(", ");
		}
		if (documentoTipo != null) {
			builder.append("documentoTipo=");
			builder.append(documentoTipo);
			builder.append(", ");
		}
		if (documentoNumero != null) {
			builder.append("documentoNumero=");
			builder.append(documentoNumero);
			builder.append(", ");
		}
		if (tipoOperacion != null) {
			builder.append("tipoOperacion=");
			builder.append(tipoOperacion);
			builder.append(", ");
		}
		builder.append("eliminado=");
		builder.append(eliminado);
		builder.append("]");
		return builder.toString();
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
