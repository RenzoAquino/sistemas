package com.sgv.common.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sgv.common.constants.Constants;
import com.sgv.common.util.DateUtil;
import com.sgv.common.util.MoneyUtil;
import com.sgv.fakturama.dao.model.FktDocumentitem;

public class ConsolidadorProductoVO {

	String codigo;
	String nombreKey;
	String nombre;
	String unidadMedida;
	Double precioUnitario = 0.00;
	Double cantidad = 0.00;
	Double valorTotal = 0.00;
	Double porcentajeIGV = 0.00;
	Double igv = 0.00;
	Double importeTotal = 0.00;
	Long idVAT;
	boolean tieneIGV = false;
	boolean esPrimeraCarga = true;
	Map<String, Double> mapDias = new HashMap<String, Double>();
	//FktDocumentitem item;
	//Date fechaDocumento;
	
	public ConsolidadorProductoVO(){
	}

	public ConsolidadorProductoVO cargar(FktDocumentitem item, Date fechaDocumento){
		if(esPrimeraCarga){
			codigo = item.getITEMNUMBER();
			unidadMedida = item.getQUANTITYUNIT();
			nombre = item.getNAME();
			nombreKey = (""+item.getVat().getTAXVALUE()*100).concat("_").concat(this.nombre).concat("_S/. ").concat(MoneyUtil.convertDoubleToString(item.getPRICE()));		
			precioUnitario = item.getPRICE();
			tieneIGV = (item.getVat().getTAXVALUE().intValue() == 0)?false:true;
			porcentajeIGV = item.getVat().getTAXVALUE();
			idVAT = item.getFK_VAT();
			esPrimeraCarga = false;
		}
		
		Double tCantidad = item.getQUANTITY();

		String sFechaDocumento = DateUtil.formatDate(fechaDocumento, Constants.FORMAT_DATE_DD_MM_YYYY_01);
		Double  cantidadDia = mapDias.getOrDefault(sFechaDocumento,0.00);
		mapDias.put(sFechaDocumento, (cantidadDia + tCantidad));
				
		cantidad = cantidad +tCantidad;

		return this;
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
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getIgv() {
		return igv;
	}
	public void setIgv(Double igv) {
		this.igv = igv;
	}
	public Double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public boolean isTieneIGV() {
		return tieneIGV;
	}
	public void setTieneIGV(boolean tieneIGV) {
		this.tieneIGV = tieneIGV;
	}
	public Map<String, Double> getMapDias() {
		return mapDias;
	}
	public void setMapDias(Map<String, Double> mapDias) {
		this.mapDias = mapDias;
	}
	public String getNombreKey() {
		return nombreKey;
	}

	public void setNombreKey(String nombreKey) {
		this.nombreKey = nombreKey;
	}

	public Double getPorcentajeIGV() {
		return porcentajeIGV;
	}

	public void setPorcentajeIGV(Double porcentajeIGV) {
		this.porcentajeIGV = porcentajeIGV;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsolidadorProductoVO [");
		if (codigo != null) {
			builder.append("codigo=");
			builder.append(codigo);
			builder.append(", ");
		}
		if (nombreKey != null) {
			builder.append("nombreKey=");
			builder.append(nombreKey);
			builder.append(", ");
		}
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (unidadMedida != null) {
			builder.append("unidadMedida=");
			builder.append(unidadMedida);
			builder.append(", ");
		}
		if (precioUnitario != null) {
			builder.append("precioUnitario=");
			builder.append(precioUnitario);
			builder.append(", ");
		}
		if (cantidad != null) {
			builder.append("cantidad=");
			builder.append(cantidad);
			builder.append(", ");
		}
		if (valorTotal != null) {
			builder.append("valorTotal=");
			builder.append(valorTotal);
			builder.append(", ");
		}
		if (porcentajeIGV != null) {
			builder.append("porcentajeIGV=");
			builder.append(porcentajeIGV);
			builder.append(", ");
		}
		if (igv != null) {
			builder.append("igv=");
			builder.append(igv);
			builder.append(", ");
		}
		if (importeTotal != null) {
			builder.append("importeTotal=");
			builder.append(importeTotal);
			builder.append(", ");
		}
		if (idVAT != null) {
			builder.append("idVAT=");
			builder.append(idVAT);
			builder.append(", ");
		}
		builder.append("tieneIGV=");
		builder.append(tieneIGV);
		builder.append(", esPrimeraCarga=");
		builder.append(esPrimeraCarga);
		builder.append(", ");
		if (mapDias != null) {
			builder.append("mapDias=");
			builder.append(mapDias);
		}
		builder.append("]");
		return builder.toString();
	}

	public Long getIdVAT() {
		return idVAT;
	}

	public void setIdVAT(Long idVAT) {
		this.idVAT = idVAT;
	}

}
