package com.sgv.fakturama.dao.model;

import java.util.Arrays;
import java.util.Date;

public class FktDocumentitem {
    private Long ID;

    private Date DATEADDED;

    private Boolean DELETED;

    private Long GTIN;

    private String ITEMNUMBER;

    private Double ITEMREBATE;

    private String ITEMTYPE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Boolean NOVAT;

    private Boolean OPTIONAL;

    private Integer POSNR;

    private Double PRICE;

    private Double QUANTITY;

    private String QUANTITYUNIT;

    private Double TARA;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Date VESTINGPERIODEND;

    private Date VESTINGPERIODSTART;

    private Double WEIGHT;

    private Long FK_VAT;

    private Long FK_PRODUCT;

    private Long FK_DOCUMENT;

    private String DESCRIPTION;

    private byte[] PICTURE;
    private FktVat vat;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getDATEADDED() {
        return DATEADDED;
    }

    public void setDATEADDED(Date DATEADDED) {
        this.DATEADDED = DATEADDED;
    }

    public Boolean getDELETED() {
        return DELETED;
    }

    public void setDELETED(Boolean DELETED) {
        this.DELETED = DELETED;
    }

    public Long getGTIN() {
        return GTIN;
    }

    public void setGTIN(Long GTIN) {
        this.GTIN = GTIN;
    }

    public String getITEMNUMBER() {
        return ITEMNUMBER;
    }

    public void setITEMNUMBER(String ITEMNUMBER) {
        this.ITEMNUMBER = ITEMNUMBER;
    }

    public Double getITEMREBATE() {
        return ITEMREBATE;
    }

    public void setITEMREBATE(Double ITEMREBATE) {
        this.ITEMREBATE = ITEMREBATE;
    }

    public String getITEMTYPE() {
        return ITEMTYPE;
    }

    public void setITEMTYPE(String ITEMTYPE) {
        this.ITEMTYPE = ITEMTYPE;
    }

    public Date getMODIFIED() {
        return MODIFIED;
    }

    public void setMODIFIED(Date MODIFIED) {
        this.MODIFIED = MODIFIED;
    }

    public String getMODIFIEDBY() {
        return MODIFIEDBY;
    }

    public void setMODIFIEDBY(String MODIFIEDBY) {
        this.MODIFIEDBY = MODIFIEDBY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Boolean getNOVAT() {
        return NOVAT;
    }

    public void setNOVAT(Boolean NOVAT) {
        this.NOVAT = NOVAT;
    }

    public Boolean getOPTIONAL() {
        return OPTIONAL;
    }

    public void setOPTIONAL(Boolean OPTIONAL) {
        this.OPTIONAL = OPTIONAL;
    }

    public Integer getPOSNR() {
        return POSNR;
    }

    public void setPOSNR(Integer POSNR) {
        this.POSNR = POSNR;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public Double getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Double QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getQUANTITYUNIT() {
        return QUANTITYUNIT;
    }

    public void setQUANTITYUNIT(String QUANTITYUNIT) {
        this.QUANTITYUNIT = QUANTITYUNIT;
    }

    public Double getTARA() {
        return TARA;
    }

    public void setTARA(Double TARA) {
        this.TARA = TARA;
    }

    public Date getVALIDFROM() {
        return VALIDFROM;
    }

    public void setVALIDFROM(Date VALIDFROM) {
        this.VALIDFROM = VALIDFROM;
    }

    public Date getVALIDTO() {
        return VALIDTO;
    }

    public void setVALIDTO(Date VALIDTO) {
        this.VALIDTO = VALIDTO;
    }

    public Date getVESTINGPERIODEND() {
        return VESTINGPERIODEND;
    }

    public void setVESTINGPERIODEND(Date VESTINGPERIODEND) {
        this.VESTINGPERIODEND = VESTINGPERIODEND;
    }

    public Date getVESTINGPERIODSTART() {
        return VESTINGPERIODSTART;
    }

    public void setVESTINGPERIODSTART(Date VESTINGPERIODSTART) {
        this.VESTINGPERIODSTART = VESTINGPERIODSTART;
    }

    public Double getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(Double WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public Long getFK_VAT() {
        return FK_VAT;
    }

    public void setFK_VAT(Long FK_VAT) {
        this.FK_VAT = FK_VAT;
    }

    public Long getFK_PRODUCT() {
        return FK_PRODUCT;
    }

    public void setFK_PRODUCT(Long FK_PRODUCT) {
        this.FK_PRODUCT = FK_PRODUCT;
    }

    public Long getFK_DOCUMENT() {
        return FK_DOCUMENT;
    }

    public void setFK_DOCUMENT(Long FK_DOCUMENT) {
        this.FK_DOCUMENT = FK_DOCUMENT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public byte[] getPICTURE() {
        return PICTURE;
    }

    public void setPICTURE(byte[] PICTURE) {
        this.PICTURE = PICTURE;
    }

	public FktVat getVat() {
		return vat;
	}

	public void setVat(FktVat vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FktDocumentitem [");
		if (ID != null) {
			builder.append("ID=");
			builder.append(ID);
			builder.append(", ");
		}
		if (DATEADDED != null) {
			builder.append("DATEADDED=");
			builder.append(DATEADDED);
			builder.append(", ");
		}
		if (DELETED != null) {
			builder.append("DELETED=");
			builder.append(DELETED);
			builder.append(", ");
		}
		if (GTIN != null) {
			builder.append("GTIN=");
			builder.append(GTIN);
			builder.append(", ");
		}
		if (ITEMNUMBER != null) {
			builder.append("ITEMNUMBER=");
			builder.append(ITEMNUMBER);
			builder.append(", ");
		}
		if (ITEMREBATE != null) {
			builder.append("ITEMREBATE=");
			builder.append(ITEMREBATE);
			builder.append(", ");
		}
		if (ITEMTYPE != null) {
			builder.append("ITEMTYPE=");
			builder.append(ITEMTYPE);
			builder.append(", ");
		}
		if (MODIFIED != null) {
			builder.append("MODIFIED=");
			builder.append(MODIFIED);
			builder.append(", ");
		}
		if (MODIFIEDBY != null) {
			builder.append("MODIFIEDBY=");
			builder.append(MODIFIEDBY);
			builder.append(", ");
		}
		if (NAME != null) {
			builder.append("NAME=");
			builder.append(NAME);
			builder.append(", ");
		}
		if (NOVAT != null) {
			builder.append("NOVAT=");
			builder.append(NOVAT);
			builder.append(", ");
		}
		if (OPTIONAL != null) {
			builder.append("OPTIONAL=");
			builder.append(OPTIONAL);
			builder.append(", ");
		}
		if (POSNR != null) {
			builder.append("POSNR=");
			builder.append(POSNR);
			builder.append(", ");
		}
		if (PRICE != null) {
			builder.append("PRICE=");
			builder.append(PRICE);
			builder.append(", ");
		}
		if (QUANTITY != null) {
			builder.append("QUANTITY=");
			builder.append(QUANTITY);
			builder.append(", ");
		}
		if (QUANTITYUNIT != null) {
			builder.append("QUANTITYUNIT=");
			builder.append(QUANTITYUNIT);
			builder.append(", ");
		}
		if (TARA != null) {
			builder.append("TARA=");
			builder.append(TARA);
			builder.append(", ");
		}
		if (VALIDFROM != null) {
			builder.append("VALIDFROM=");
			builder.append(VALIDFROM);
			builder.append(", ");
		}
		if (VALIDTO != null) {
			builder.append("VALIDTO=");
			builder.append(VALIDTO);
			builder.append(", ");
		}
		if (VESTINGPERIODEND != null) {
			builder.append("VESTINGPERIODEND=");
			builder.append(VESTINGPERIODEND);
			builder.append(", ");
		}
		if (VESTINGPERIODSTART != null) {
			builder.append("VESTINGPERIODSTART=");
			builder.append(VESTINGPERIODSTART);
			builder.append(", ");
		}
		if (WEIGHT != null) {
			builder.append("WEIGHT=");
			builder.append(WEIGHT);
			builder.append(", ");
		}
		if (FK_VAT != null) {
			builder.append("FK_VAT=");
			builder.append(FK_VAT);
			builder.append(", ");
		}
		if (FK_PRODUCT != null) {
			builder.append("FK_PRODUCT=");
			builder.append(FK_PRODUCT);
			builder.append(", ");
		}
		if (FK_DOCUMENT != null) {
			builder.append("FK_DOCUMENT=");
			builder.append(FK_DOCUMENT);
			builder.append(", ");
		}
		if (DESCRIPTION != null) {
			builder.append("DESCRIPTION=");
			builder.append(DESCRIPTION);
			builder.append(", ");
		}
		if (PICTURE != null) {
			builder.append("PICTURE=");
			builder.append(Arrays.toString(PICTURE));
			builder.append(", ");
		}
		if (vat != null) {
			builder.append("vat=");
			builder.append(vat);
		}
		builder.append("]");
		return builder.toString();
	}

	
}