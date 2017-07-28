package com.sgv.base.dao.model;

import java.util.Date;

public class TxxxxBandfact {
    private String NUM_RUC;

    private String TIP_DOCU;

    private String NUM_DOCU;

    private Date FEC_CARG;

    private Date FEC_GENE;

    private Date FEC_ENVI;

    private String DES_OBSE;

    private String NOM_ARCH;

    private String IND_SITU;

    private String TIP_ARCH;

    private String FIRM_DIGITAL;
    
    private String TIP_DOC_REFERENCIA;

    private String NUM_DOC_REFERENCIA;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TxxxxBandfact [");
		if (NUM_RUC != null) {
			builder.append("NUM_RUC=");
			builder.append(NUM_RUC);
			builder.append(", ");
		}
		if (TIP_DOCU != null) {
			builder.append("TIP_DOCU=");
			builder.append(TIP_DOCU);
			builder.append(", ");
		}
		if (NUM_DOCU != null) {
			builder.append("NUM_DOCU=");
			builder.append(NUM_DOCU);
			builder.append(", ");
		}
		if (FEC_CARG != null) {
			builder.append("FEC_CARG=");
			builder.append(FEC_CARG);
			builder.append(", ");
		}
		if (FEC_GENE != null) {
			builder.append("FEC_GENE=");
			builder.append(FEC_GENE);
			builder.append(", ");
		}
		if (FEC_ENVI != null) {
			builder.append("FEC_ENVI=");
			builder.append(FEC_ENVI);
			builder.append(", ");
		}
		if (DES_OBSE != null) {
			builder.append("DES_OBSE=");
			builder.append(DES_OBSE);
			builder.append(", ");
		}
		if (NOM_ARCH != null) {
			builder.append("NOM_ARCH=");
			builder.append(NOM_ARCH);
			builder.append(", ");
		}
		if (IND_SITU != null) {
			builder.append("IND_SITU=");
			builder.append(IND_SITU);
			builder.append(", ");
		}
		if (TIP_ARCH != null) {
			builder.append("TIP_ARCH=");
			builder.append(TIP_ARCH);
			builder.append(", ");
		}
		if (FIRM_DIGITAL != null) {
			builder.append("FIRM_DIGITAL=");
			builder.append(FIRM_DIGITAL);
			builder.append(", ");
		}
		if (TIP_DOC_REFERENCIA != null) {
			builder.append("TIP_DOC_REFERENCIA=");
			builder.append(TIP_DOC_REFERENCIA);
			builder.append(", ");
		}
		if (NUM_DOC_REFERENCIA != null) {
			builder.append("NUM_DOC_REFERENCIA=");
			builder.append(NUM_DOC_REFERENCIA);
		}
		builder.append("]");
		return builder.toString();
	}

	public String getNUM_RUC() {
		return NUM_RUC;
	}

	public void setNUM_RUC(String nUM_RUC) {
		NUM_RUC = nUM_RUC;
	}

	public String getTIP_DOCU() {
		return TIP_DOCU;
	}

	public void setTIP_DOCU(String tIP_DOCU) {
		TIP_DOCU = tIP_DOCU;
	}

	public String getNUM_DOCU() {
		return NUM_DOCU;
	}

	public void setNUM_DOCU(String nUM_DOCU) {
		NUM_DOCU = nUM_DOCU;
	}

	public Date getFEC_CARG() {
		return FEC_CARG;
	}

	public void setFEC_CARG(Date fEC_CARG) {
		FEC_CARG = fEC_CARG;
	}

	public Date getFEC_GENE() {
		return FEC_GENE;
	}

	public void setFEC_GENE(Date fEC_GENE) {
		FEC_GENE = fEC_GENE;
	}

	public Date getFEC_ENVI() {
		return FEC_ENVI;
	}

	public void setFEC_ENVI(Date fEC_ENVI) {
		FEC_ENVI = fEC_ENVI;
	}

	public String getDES_OBSE() {
		return DES_OBSE;
	}

	public void setDES_OBSE(String dES_OBSE) {
		DES_OBSE = dES_OBSE;
	}

	public String getNOM_ARCH() {
		return NOM_ARCH;
	}

	public void setNOM_ARCH(String nOM_ARCH) {
		NOM_ARCH = nOM_ARCH;
	}

	public String getIND_SITU() {
		return IND_SITU;
	}

	public void setIND_SITU(String iND_SITU) {
		IND_SITU = iND_SITU;
	}

	public String getTIP_ARCH() {
		return TIP_ARCH;
	}

	public void setTIP_ARCH(String tIP_ARCH) {
		TIP_ARCH = tIP_ARCH;
	}

	public String getFIRM_DIGITAL() {
		return FIRM_DIGITAL;
	}

	public void setFIRM_DIGITAL(String fIRM_DIGITAL) {
		FIRM_DIGITAL = fIRM_DIGITAL;
	}

	public String getTIP_DOC_REFERENCIA() {
		return TIP_DOC_REFERENCIA;
	}

	public void setTIP_DOC_REFERENCIA(String tIP_DOC_REFERENCIA) {
		TIP_DOC_REFERENCIA = tIP_DOC_REFERENCIA;
	}

	public String getNUM_DOC_REFERENCIA() {
		return NUM_DOC_REFERENCIA;
	}

	public void setNUM_DOC_REFERENCIA(String nUM_DOC_REFERENCIA) {
		NUM_DOC_REFERENCIA = nUM_DOC_REFERENCIA;
	}

}