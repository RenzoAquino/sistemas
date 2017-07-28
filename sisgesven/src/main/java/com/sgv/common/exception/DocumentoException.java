package com.sgv.common.exception;

public class DocumentoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoDocumento;
	private String numeroDocumento;
	
	public DocumentoException(){
		super();
	}
	public DocumentoException(String message) {
		super(message);
	}
	public DocumentoException(String message,String tipoDocumento, String numeroDocumento) {
		super(message);
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
