package com.sgv.base.dao.model;

import java.util.Date;

public class ControlVenta {
    private Long CVNT_ID;

    private Date CVNT_FEC_EMI_DOCUMENTO;

    private Date CVNT_FEC_VEN_DOCUMENTO;

    private String CVNT_TIP_DOCUMENTO;

    private String CVNT_NUM_DOCUMENTO;

    private String CVNT_TIP_DOC_EMISOR;

    private String CVNT_NUM_DOC_EMISOR;

    private String CVNT_RAZ_SOC_EMISOR;

    private String CVNT_TIP_DOC_RECEPTOR;

    private String CVNT_NUM_DOC_RECEPTOR;

    private String CVNT_RAZ_SOC_RECEPTOR;

    private Double CVNT_VAL_FAC_EXPORTACION;

    private Double CVNT_VAL_OPE_GRAVADA;

    private Double CVNT_VAL_OPE_EXONERADA;

    private Double CVNT_VAL_OPE_INAFECTA;

    private Double CVNT_ISC;

    private Double CVNT_IGV;

    private Double CVNT_OTR_TRIBUTOS;

    private Double CVNT_IMP_TOTAL;

    private Double CVNT_TIP_CAMBIO;

    private Date CVNT_FEC_DOC_REFERENCIA;

    private String CVNT_TIP_DOC_REFERENCIA;

    private String CVNT_NUM_DOC_REFERENCIA;

    private String CVNT_ESTADO;

    private String CVNT_OBSERVACION;

    private String CVNT_EST_ANTERIOR;

    private String CVNT_OBS_ANTERIOR;

    private String CVNT_IND_SITU;

    private String CVNT_IND_SITU_ANTERIOR;

    private Date CVNT_PERIDO;

    private String CVNT_TIP_MONEDA;

    private Date CVNT_FEC_CREACION;

    private Date CVNT_FEC_MODIFICACION;

    private String CVNT_USU_CREACION;

    private String CVNT_US_MODIFICACION;

    private Date CVNT_FEC_ORD_PEDIDO;

    private Date CVNT_FEC_SER_PEDIDO;

    private Date CVNT_FEC_REC_PEDIDO;

    private Date CVNT_FEC_PAG_PEDIDO;

    private String CVNT_IND_PAGADO;

    private String CVNT_NUM_OC_PEDIDO;

    private String CVNT_CMM_DOCUMENTO;

    private String CVNT_EST_DOCUMENTO;

    private String CVNT_ES_DIGITAL;
    
    TxxxxBandfact registroFacturadorSunat;

    public Long getCVNT_ID() {
        return CVNT_ID;
    }

    public void setCVNT_ID(Long CVNT_ID) {
        this.CVNT_ID = CVNT_ID;
    }

    public Date getCVNT_FEC_EMI_DOCUMENTO() {
        return CVNT_FEC_EMI_DOCUMENTO;
    }

    public void setCVNT_FEC_EMI_DOCUMENTO(Date CVNT_FEC_EMI_DOCUMENTO) {
        this.CVNT_FEC_EMI_DOCUMENTO = CVNT_FEC_EMI_DOCUMENTO;
    }

    public Date getCVNT_FEC_VEN_DOCUMENTO() {
        return CVNT_FEC_VEN_DOCUMENTO;
    }

    public void setCVNT_FEC_VEN_DOCUMENTO(Date CVNT_FEC_VEN_DOCUMENTO) {
        this.CVNT_FEC_VEN_DOCUMENTO = CVNT_FEC_VEN_DOCUMENTO;
    }

    public String getCVNT_TIP_DOCUMENTO() {
        return CVNT_TIP_DOCUMENTO;
    }

    public void setCVNT_TIP_DOCUMENTO(String CVNT_TIP_DOCUMENTO) {
        this.CVNT_TIP_DOCUMENTO = CVNT_TIP_DOCUMENTO;
    }

    public String getCVNT_NUM_DOCUMENTO() {
        return CVNT_NUM_DOCUMENTO;
    }

    public void setCVNT_NUM_DOCUMENTO(String CVNT_NUM_DOCUMENTO) {
        this.CVNT_NUM_DOCUMENTO = CVNT_NUM_DOCUMENTO;
    }

    public String getCVNT_TIP_DOC_EMISOR() {
        return CVNT_TIP_DOC_EMISOR;
    }

    public void setCVNT_TIP_DOC_EMISOR(String CVNT_TIP_DOC_EMISOR) {
        this.CVNT_TIP_DOC_EMISOR = CVNT_TIP_DOC_EMISOR;
    }

    public String getCVNT_NUM_DOC_EMISOR() {
        return CVNT_NUM_DOC_EMISOR;
    }

    public void setCVNT_NUM_DOC_EMISOR(String CVNT_NUM_DOC_EMISOR) {
        this.CVNT_NUM_DOC_EMISOR = CVNT_NUM_DOC_EMISOR;
    }

    public String getCVNT_RAZ_SOC_EMISOR() {
        return CVNT_RAZ_SOC_EMISOR;
    }

    public void setCVNT_RAZ_SOC_EMISOR(String CVNT_RAZ_SOC_EMISOR) {
        this.CVNT_RAZ_SOC_EMISOR = CVNT_RAZ_SOC_EMISOR;
    }

    public String getCVNT_TIP_DOC_RECEPTOR() {
        return CVNT_TIP_DOC_RECEPTOR;
    }

    public void setCVNT_TIP_DOC_RECEPTOR(String CVNT_TIP_DOC_RECEPTOR) {
        this.CVNT_TIP_DOC_RECEPTOR = CVNT_TIP_DOC_RECEPTOR;
    }

    public String getCVNT_NUM_DOC_RECEPTOR() {
        return CVNT_NUM_DOC_RECEPTOR;
    }

    public void setCVNT_NUM_DOC_RECEPTOR(String CVNT_NUM_DOC_RECEPTOR) {
        this.CVNT_NUM_DOC_RECEPTOR = CVNT_NUM_DOC_RECEPTOR;
    }

    public String getCVNT_RAZ_SOC_RECEPTOR() {
        return CVNT_RAZ_SOC_RECEPTOR;
    }

    public void setCVNT_RAZ_SOC_RECEPTOR(String CVNT_RAZ_SOC_RECEPTOR) {
        this.CVNT_RAZ_SOC_RECEPTOR = CVNT_RAZ_SOC_RECEPTOR;
    }

    public Double getCVNT_VAL_FAC_EXPORTACION() {
        return CVNT_VAL_FAC_EXPORTACION;
    }

    public void setCVNT_VAL_FAC_EXPORTACION(Double CVNT_VAL_FAC_EXPORTACION) {
        this.CVNT_VAL_FAC_EXPORTACION = CVNT_VAL_FAC_EXPORTACION;
    }

    public Double getCVNT_VAL_OPE_GRAVADA() {
        return CVNT_VAL_OPE_GRAVADA;
    }

    public void setCVNT_VAL_OPE_GRAVADA(Double CVNT_VAL_OPE_GRAVADA) {
        this.CVNT_VAL_OPE_GRAVADA = CVNT_VAL_OPE_GRAVADA;
    }

    public Double getCVNT_VAL_OPE_EXONERADA() {
        return CVNT_VAL_OPE_EXONERADA;
    }

    public void setCVNT_VAL_OPE_EXONERADA(Double CVNT_VAL_OPE_EXONERADA) {
        this.CVNT_VAL_OPE_EXONERADA = CVNT_VAL_OPE_EXONERADA;
    }

    public Double getCVNT_VAL_OPE_INAFECTA() {
        return CVNT_VAL_OPE_INAFECTA;
    }

    public void setCVNT_VAL_OPE_INAFECTA(Double CVNT_VAL_OPE_INAFECTA) {
        this.CVNT_VAL_OPE_INAFECTA = CVNT_VAL_OPE_INAFECTA;
    }

    public Double getCVNT_ISC() {
        return CVNT_ISC;
    }

    public void setCVNT_ISC(Double CVNT_ISC) {
        this.CVNT_ISC = CVNT_ISC;
    }

    public Double getCVNT_IGV() {
        return CVNT_IGV;
    }

    public void setCVNT_IGV(Double CVNT_IGV) {
        this.CVNT_IGV = CVNT_IGV;
    }

    public Double getCVNT_OTR_TRIBUTOS() {
        return CVNT_OTR_TRIBUTOS;
    }

    public void setCVNT_OTR_TRIBUTOS(Double CVNT_OTR_TRIBUTOS) {
        this.CVNT_OTR_TRIBUTOS = CVNT_OTR_TRIBUTOS;
    }

    public Double getCVNT_IMP_TOTAL() {
        return CVNT_IMP_TOTAL;
    }

    public void setCVNT_IMP_TOTAL(Double CVNT_IMP_TOTAL) {
        this.CVNT_IMP_TOTAL = CVNT_IMP_TOTAL;
    }

    public Double getCVNT_TIP_CAMBIO() {
        return CVNT_TIP_CAMBIO;
    }

    public void setCVNT_TIP_CAMBIO(Double CVNT_TIP_CAMBIO) {
        this.CVNT_TIP_CAMBIO = CVNT_TIP_CAMBIO;
    }

    public Date getCVNT_FEC_DOC_REFERENCIA() {
        return CVNT_FEC_DOC_REFERENCIA;
    }

    public void setCVNT_FEC_DOC_REFERENCIA(Date CVNT_FEC_DOC_REFERENCIA) {
        this.CVNT_FEC_DOC_REFERENCIA = CVNT_FEC_DOC_REFERENCIA;
    }

    public String getCVNT_TIP_DOC_REFERENCIA() {
        return CVNT_TIP_DOC_REFERENCIA;
    }

    public void setCVNT_TIP_DOC_REFERENCIA(String CVNT_TIP_DOC_REFERENCIA) {
        this.CVNT_TIP_DOC_REFERENCIA = CVNT_TIP_DOC_REFERENCIA;
    }

    public String getCVNT_NUM_DOC_REFERENCIA() {
        return CVNT_NUM_DOC_REFERENCIA;
    }

    public void setCVNT_NUM_DOC_REFERENCIA(String CVNT_NUM_DOC_REFERENCIA) {
        this.CVNT_NUM_DOC_REFERENCIA = CVNT_NUM_DOC_REFERENCIA;
    }

    public String getCVNT_ESTADO() {
        return CVNT_ESTADO;
    }

    public void setCVNT_ESTADO(String CVNT_ESTADO) {
        this.CVNT_ESTADO = CVNT_ESTADO;
    }

    public String getCVNT_OBSERVACION() {
        return CVNT_OBSERVACION;
    }

    public void setCVNT_OBSERVACION(String CVNT_OBSERVACION) {
        this.CVNT_OBSERVACION = CVNT_OBSERVACION;
    }

    public String getCVNT_EST_ANTERIOR() {
        return CVNT_EST_ANTERIOR;
    }

    public void setCVNT_EST_ANTERIOR(String CVNT_EST_ANTERIOR) {
        this.CVNT_EST_ANTERIOR = CVNT_EST_ANTERIOR;
    }

    public String getCVNT_OBS_ANTERIOR() {
        return CVNT_OBS_ANTERIOR;
    }

    public void setCVNT_OBS_ANTERIOR(String CVNT_OBS_ANTERIOR) {
        this.CVNT_OBS_ANTERIOR = CVNT_OBS_ANTERIOR;
    }

    public String getCVNT_IND_SITU() {
        return CVNT_IND_SITU;
    }

    public void setCVNT_IND_SITU(String CVNT_IND_SITU) {
        this.CVNT_IND_SITU = CVNT_IND_SITU;
    }

    public String getCVNT_IND_SITU_ANTERIOR() {
        return CVNT_IND_SITU_ANTERIOR;
    }

    public void setCVNT_IND_SITU_ANTERIOR(String CVNT_IND_SITU_ANTERIOR) {
        this.CVNT_IND_SITU_ANTERIOR = CVNT_IND_SITU_ANTERIOR;
    }

    public Date getCVNT_PERIDO() {
        return CVNT_PERIDO;
    }

    public void setCVNT_PERIDO(Date CVNT_PERIDO) {
        this.CVNT_PERIDO = CVNT_PERIDO;
    }

    public String getCVNT_TIP_MONEDA() {
        return CVNT_TIP_MONEDA;
    }

    public void setCVNT_TIP_MONEDA(String CVNT_TIP_MONEDA) {
        this.CVNT_TIP_MONEDA = CVNT_TIP_MONEDA;
    }

    public Date getCVNT_FEC_CREACION() {
        return CVNT_FEC_CREACION;
    }

    public void setCVNT_FEC_CREACION(Date CVNT_FEC_CREACION) {
        this.CVNT_FEC_CREACION = CVNT_FEC_CREACION;
    }

    public Date getCVNT_FEC_MODIFICACION() {
        return CVNT_FEC_MODIFICACION;
    }

    public void setCVNT_FEC_MODIFICACION(Date CVNT_FEC_MODIFICACION) {
        this.CVNT_FEC_MODIFICACION = CVNT_FEC_MODIFICACION;
    }

    public String getCVNT_USU_CREACION() {
        return CVNT_USU_CREACION;
    }

    public void setCVNT_USU_CREACION(String CVNT_USU_CREACION) {
        this.CVNT_USU_CREACION = CVNT_USU_CREACION;
    }

    public String getCVNT_US_MODIFICACION() {
        return CVNT_US_MODIFICACION;
    }

    public void setCVNT_US_MODIFICACION(String CVNT_US_MODIFICACION) {
        this.CVNT_US_MODIFICACION = CVNT_US_MODIFICACION;
    }

    public Date getCVNT_FEC_ORD_PEDIDO() {
        return CVNT_FEC_ORD_PEDIDO;
    }

    public void setCVNT_FEC_ORD_PEDIDO(Date CVNT_FEC_ORD_PEDIDO) {
        this.CVNT_FEC_ORD_PEDIDO = CVNT_FEC_ORD_PEDIDO;
    }

    public Date getCVNT_FEC_SER_PEDIDO() {
        return CVNT_FEC_SER_PEDIDO;
    }

    public void setCVNT_FEC_SER_PEDIDO(Date CVNT_FEC_SER_PEDIDO) {
        this.CVNT_FEC_SER_PEDIDO = CVNT_FEC_SER_PEDIDO;
    }

    public Date getCVNT_FEC_REC_PEDIDO() {
        return CVNT_FEC_REC_PEDIDO;
    }

    public void setCVNT_FEC_REC_PEDIDO(Date CVNT_FEC_REC_PEDIDO) {
        this.CVNT_FEC_REC_PEDIDO = CVNT_FEC_REC_PEDIDO;
    }

    public Date getCVNT_FEC_PAG_PEDIDO() {
        return CVNT_FEC_PAG_PEDIDO;
    }

    public void setCVNT_FEC_PAG_PEDIDO(Date CVNT_FEC_PAG_PEDIDO) {
        this.CVNT_FEC_PAG_PEDIDO = CVNT_FEC_PAG_PEDIDO;
    }

    public String getCVNT_IND_PAGADO() {
        return CVNT_IND_PAGADO;
    }

    public void setCVNT_IND_PAGADO(String CVNT_IND_PAGADO) {
        this.CVNT_IND_PAGADO = CVNT_IND_PAGADO;
    }

    public String getCVNT_NUM_OC_PEDIDO() {
        return CVNT_NUM_OC_PEDIDO;
    }

    public void setCVNT_NUM_OC_PEDIDO(String CVNT_NUM_OC_PEDIDO) {
        this.CVNT_NUM_OC_PEDIDO = CVNT_NUM_OC_PEDIDO;
    }

    public String getCVNT_CMM_DOCUMENTO() {
        return CVNT_CMM_DOCUMENTO;
    }

    public void setCVNT_CMM_DOCUMENTO(String CVNT_CMM_DOCUMENTO) {
        this.CVNT_CMM_DOCUMENTO = CVNT_CMM_DOCUMENTO;
    }

    public String getCVNT_EST_DOCUMENTO() {
        return CVNT_EST_DOCUMENTO;
    }

    public void setCVNT_EST_DOCUMENTO(String CVNT_EST_DOCUMENTO) {
        this.CVNT_EST_DOCUMENTO = CVNT_EST_DOCUMENTO;
    }

    public String getCVNT_ES_DIGITAL() {
        return CVNT_ES_DIGITAL;
    }

    public void setCVNT_ES_DIGITAL(String CVNT_ES_DIGITAL) {
        this.CVNT_ES_DIGITAL = CVNT_ES_DIGITAL;
    }

	public TxxxxBandfact getRegistroFacturadorSunat() {
		return registroFacturadorSunat;
	}

	public void setRegistroFacturadorSunat(TxxxxBandfact registroFacturadorSunat) {
		this.registroFacturadorSunat = registroFacturadorSunat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ControlVenta [");
		if (CVNT_ID != null) {
			builder.append("CVNT_ID=");
			builder.append(CVNT_ID);
			builder.append(", ");
		}
		if (CVNT_FEC_EMI_DOCUMENTO != null) {
			builder.append("CVNT_FEC_EMI_DOCUMENTO=");
			builder.append(CVNT_FEC_EMI_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_FEC_VEN_DOCUMENTO != null) {
			builder.append("CVNT_FEC_VEN_DOCUMENTO=");
			builder.append(CVNT_FEC_VEN_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_TIP_DOCUMENTO != null) {
			builder.append("CVNT_TIP_DOCUMENTO=");
			builder.append(CVNT_TIP_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_NUM_DOCUMENTO != null) {
			builder.append("CVNT_NUM_DOCUMENTO=");
			builder.append(CVNT_NUM_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_TIP_DOC_EMISOR != null) {
			builder.append("CVNT_TIP_DOC_EMISOR=");
			builder.append(CVNT_TIP_DOC_EMISOR);
			builder.append(", ");
		}
		if (CVNT_NUM_DOC_EMISOR != null) {
			builder.append("CVNT_NUM_DOC_EMISOR=");
			builder.append(CVNT_NUM_DOC_EMISOR);
			builder.append(", ");
		}
		if (CVNT_RAZ_SOC_EMISOR != null) {
			builder.append("CVNT_RAZ_SOC_EMISOR=");
			builder.append(CVNT_RAZ_SOC_EMISOR);
			builder.append(", ");
		}
		if (CVNT_TIP_DOC_RECEPTOR != null) {
			builder.append("CVNT_TIP_DOC_RECEPTOR=");
			builder.append(CVNT_TIP_DOC_RECEPTOR);
			builder.append(", ");
		}
		if (CVNT_NUM_DOC_RECEPTOR != null) {
			builder.append("CVNT_NUM_DOC_RECEPTOR=");
			builder.append(CVNT_NUM_DOC_RECEPTOR);
			builder.append(", ");
		}
		if (CVNT_RAZ_SOC_RECEPTOR != null) {
			builder.append("CVNT_RAZ_SOC_RECEPTOR=");
			builder.append(CVNT_RAZ_SOC_RECEPTOR);
			builder.append(", ");
		}
		if (CVNT_VAL_FAC_EXPORTACION != null) {
			builder.append("CVNT_VAL_FAC_EXPORTACION=");
			builder.append(CVNT_VAL_FAC_EXPORTACION);
			builder.append(", ");
		}
		if (CVNT_VAL_OPE_GRAVADA != null) {
			builder.append("CVNT_VAL_OPE_GRAVADA=");
			builder.append(CVNT_VAL_OPE_GRAVADA);
			builder.append(", ");
		}
		if (CVNT_VAL_OPE_EXONERADA != null) {
			builder.append("CVNT_VAL_OPE_EXONERADA=");
			builder.append(CVNT_VAL_OPE_EXONERADA);
			builder.append(", ");
		}
		if (CVNT_VAL_OPE_INAFECTA != null) {
			builder.append("CVNT_VAL_OPE_INAFECTA=");
			builder.append(CVNT_VAL_OPE_INAFECTA);
			builder.append(", ");
		}
		if (CVNT_ISC != null) {
			builder.append("CVNT_ISC=");
			builder.append(CVNT_ISC);
			builder.append(", ");
		}
		if (CVNT_IGV != null) {
			builder.append("CVNT_IGV=");
			builder.append(CVNT_IGV);
			builder.append(", ");
		}
		if (CVNT_OTR_TRIBUTOS != null) {
			builder.append("CVNT_OTR_TRIBUTOS=");
			builder.append(CVNT_OTR_TRIBUTOS);
			builder.append(", ");
		}
		if (CVNT_IMP_TOTAL != null) {
			builder.append("CVNT_IMP_TOTAL=");
			builder.append(CVNT_IMP_TOTAL);
			builder.append(", ");
		}
		if (CVNT_TIP_CAMBIO != null) {
			builder.append("CVNT_TIP_CAMBIO=");
			builder.append(CVNT_TIP_CAMBIO);
			builder.append(", ");
		}
		if (CVNT_FEC_DOC_REFERENCIA != null) {
			builder.append("CVNT_FEC_DOC_REFERENCIA=");
			builder.append(CVNT_FEC_DOC_REFERENCIA);
			builder.append(", ");
		}
		if (CVNT_TIP_DOC_REFERENCIA != null) {
			builder.append("CVNT_TIP_DOC_REFERENCIA=");
			builder.append(CVNT_TIP_DOC_REFERENCIA);
			builder.append(", ");
		}
		if (CVNT_NUM_DOC_REFERENCIA != null) {
			builder.append("CVNT_NUM_DOC_REFERENCIA=");
			builder.append(CVNT_NUM_DOC_REFERENCIA);
			builder.append(", ");
		}
		if (CVNT_ESTADO != null) {
			builder.append("CVNT_ESTADO=");
			builder.append(CVNT_ESTADO);
			builder.append(", ");
		}
		if (CVNT_OBSERVACION != null) {
			builder.append("CVNT_OBSERVACION=");
			builder.append(CVNT_OBSERVACION);
			builder.append(", ");
		}
		if (CVNT_EST_ANTERIOR != null) {
			builder.append("CVNT_EST_ANTERIOR=");
			builder.append(CVNT_EST_ANTERIOR);
			builder.append(", ");
		}
		if (CVNT_OBS_ANTERIOR != null) {
			builder.append("CVNT_OBS_ANTERIOR=");
			builder.append(CVNT_OBS_ANTERIOR);
			builder.append(", ");
		}
		if (CVNT_IND_SITU != null) {
			builder.append("CVNT_IND_SITU=");
			builder.append(CVNT_IND_SITU);
			builder.append(", ");
		}
		if (CVNT_IND_SITU_ANTERIOR != null) {
			builder.append("CVNT_IND_SITU_ANTERIOR=");
			builder.append(CVNT_IND_SITU_ANTERIOR);
			builder.append(", ");
		}
		if (CVNT_PERIDO != null) {
			builder.append("CVNT_PERIDO=");
			builder.append(CVNT_PERIDO);
			builder.append(", ");
		}
		if (CVNT_TIP_MONEDA != null) {
			builder.append("CVNT_TIP_MONEDA=");
			builder.append(CVNT_TIP_MONEDA);
			builder.append(", ");
		}
		if (CVNT_FEC_CREACION != null) {
			builder.append("CVNT_FEC_CREACION=");
			builder.append(CVNT_FEC_CREACION);
			builder.append(", ");
		}
		if (CVNT_FEC_MODIFICACION != null) {
			builder.append("CVNT_FEC_MODIFICACION=");
			builder.append(CVNT_FEC_MODIFICACION);
			builder.append(", ");
		}
		if (CVNT_USU_CREACION != null) {
			builder.append("CVNT_USU_CREACION=");
			builder.append(CVNT_USU_CREACION);
			builder.append(", ");
		}
		if (CVNT_US_MODIFICACION != null) {
			builder.append("CVNT_US_MODIFICACION=");
			builder.append(CVNT_US_MODIFICACION);
			builder.append(", ");
		}
		if (CVNT_FEC_ORD_PEDIDO != null) {
			builder.append("CVNT_FEC_ORD_PEDIDO=");
			builder.append(CVNT_FEC_ORD_PEDIDO);
			builder.append(", ");
		}
		if (CVNT_FEC_SER_PEDIDO != null) {
			builder.append("CVNT_FEC_SER_PEDIDO=");
			builder.append(CVNT_FEC_SER_PEDIDO);
			builder.append(", ");
		}
		if (CVNT_FEC_REC_PEDIDO != null) {
			builder.append("CVNT_FEC_REC_PEDIDO=");
			builder.append(CVNT_FEC_REC_PEDIDO);
			builder.append(", ");
		}
		if (CVNT_FEC_PAG_PEDIDO != null) {
			builder.append("CVNT_FEC_PAG_PEDIDO=");
			builder.append(CVNT_FEC_PAG_PEDIDO);
			builder.append(", ");
		}
		if (CVNT_IND_PAGADO != null) {
			builder.append("CVNT_IND_PAGADO=");
			builder.append(CVNT_IND_PAGADO);
			builder.append(", ");
		}
		if (CVNT_NUM_OC_PEDIDO != null) {
			builder.append("CVNT_NUM_OC_PEDIDO=");
			builder.append(CVNT_NUM_OC_PEDIDO);
			builder.append(", ");
		}
		if (CVNT_CMM_DOCUMENTO != null) {
			builder.append("CVNT_CMM_DOCUMENTO=");
			builder.append(CVNT_CMM_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_EST_DOCUMENTO != null) {
			builder.append("CVNT_EST_DOCUMENTO=");
			builder.append(CVNT_EST_DOCUMENTO);
			builder.append(", ");
		}
		if (CVNT_ES_DIGITAL != null) {
			builder.append("CVNT_ES_DIGITAL=");
			builder.append(CVNT_ES_DIGITAL);
			builder.append(", ");
		}
		if (registroFacturadorSunat != null) {
			builder.append("registroFacturadorSunat=");
			builder.append(registroFacturadorSunat);
		}
		builder.append("]");
		return builder.toString();
	}
}