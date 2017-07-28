package com.sgv.fakturama.dao.domain;

import java.util.Arrays;
import java.util.Date;

public class FktProduct {
    private Long ID;

    private Integer BLOCK1;

    private Integer BLOCK2;

    private Integer BLOCK3;

    private Integer BLOCK4;

    private Integer BLOCK5;

    private String CDF01;

    private String CDF02;

    private String CDF03;

    private Double COSTPRICE;

    private Date DATEADDED;

    private Boolean DELETED;

    private Long GTIN;

    private String ITEMNUMBER;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Double PRICE1;

    private Double PRICE2;

    private Double PRICE3;

    private Double PRICE4;

    private Double PRICE5;

    private Double QUANTITY;

    private String QUANTITYUNIT;

    private Integer SELLINGUNIT;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Long WEBSHOPID;

    private Double WEIGHT;

    private Long PRODUCT_CATEGORIES;

    private Long FK_VAT;

    private String DESCRIPTION;

    private byte[] PICTURE;
    
    private FktVat vat;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getBLOCK1() {
        return BLOCK1;
    }

    public void setBLOCK1(Integer BLOCK1) {
        this.BLOCK1 = BLOCK1;
    }

    public Integer getBLOCK2() {
        return BLOCK2;
    }

    public void setBLOCK2(Integer BLOCK2) {
        this.BLOCK2 = BLOCK2;
    }

    public Integer getBLOCK3() {
        return BLOCK3;
    }

    public void setBLOCK3(Integer BLOCK3) {
        this.BLOCK3 = BLOCK3;
    }

    public Integer getBLOCK4() {
        return BLOCK4;
    }

    public void setBLOCK4(Integer BLOCK4) {
        this.BLOCK4 = BLOCK4;
    }

    public Integer getBLOCK5() {
        return BLOCK5;
    }

    public void setBLOCK5(Integer BLOCK5) {
        this.BLOCK5 = BLOCK5;
    }

    public String getCDF01() {
        return CDF01;
    }

    public void setCDF01(String CDF01) {
        this.CDF01 = CDF01;
    }

    public String getCDF02() {
        return CDF02;
    }

    public void setCDF02(String CDF02) {
        this.CDF02 = CDF02;
    }

    public String getCDF03() {
        return CDF03;
    }

    public void setCDF03(String CDF03) {
        this.CDF03 = CDF03;
    }

    public Double getCOSTPRICE() {
        return COSTPRICE;
    }

    public void setCOSTPRICE(Double COSTPRICE) {
        this.COSTPRICE = COSTPRICE;
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

    public Double getPRICE1() {
        return PRICE1;
    }

    public void setPRICE1(Double PRICE1) {
        this.PRICE1 = PRICE1;
    }

    public Double getPRICE2() {
        return PRICE2;
    }

    public void setPRICE2(Double PRICE2) {
        this.PRICE2 = PRICE2;
    }

    public Double getPRICE3() {
        return PRICE3;
    }

    public void setPRICE3(Double PRICE3) {
        this.PRICE3 = PRICE3;
    }

    public Double getPRICE4() {
        return PRICE4;
    }

    public void setPRICE4(Double PRICE4) {
        this.PRICE4 = PRICE4;
    }

    public Double getPRICE5() {
        return PRICE5;
    }

    public void setPRICE5(Double PRICE5) {
        this.PRICE5 = PRICE5;
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

    public Integer getSELLINGUNIT() {
        return SELLINGUNIT;
    }

    public void setSELLINGUNIT(Integer SELLINGUNIT) {
        this.SELLINGUNIT = SELLINGUNIT;
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

    public Long getWEBSHOPID() {
        return WEBSHOPID;
    }

    public void setWEBSHOPID(Long WEBSHOPID) {
        this.WEBSHOPID = WEBSHOPID;
    }

    public Double getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(Double WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public Long getPRODUCT_CATEGORIES() {
        return PRODUCT_CATEGORIES;
    }

    public void setPRODUCT_CATEGORIES(Long PRODUCT_CATEGORIES) {
        this.PRODUCT_CATEGORIES = PRODUCT_CATEGORIES;
    }

    public Long getFK_VAT() {
        return FK_VAT;
    }

    public void setFK_VAT(Long FK_VAT) {
        this.FK_VAT = FK_VAT;
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
		builder.append("FktProduct [");
		if (ID != null) {
			builder.append("ID=");
			builder.append(ID);
			builder.append(", ");
		}
		if (BLOCK1 != null) {
			builder.append("BLOCK1=");
			builder.append(BLOCK1);
			builder.append(", ");
		}
		if (BLOCK2 != null) {
			builder.append("BLOCK2=");
			builder.append(BLOCK2);
			builder.append(", ");
		}
		if (BLOCK3 != null) {
			builder.append("BLOCK3=");
			builder.append(BLOCK3);
			builder.append(", ");
		}
		if (BLOCK4 != null) {
			builder.append("BLOCK4=");
			builder.append(BLOCK4);
			builder.append(", ");
		}
		if (BLOCK5 != null) {
			builder.append("BLOCK5=");
			builder.append(BLOCK5);
			builder.append(", ");
		}
		if (CDF01 != null) {
			builder.append("CDF01=");
			builder.append(CDF01);
			builder.append(", ");
		}
		if (CDF02 != null) {
			builder.append("CDF02=");
			builder.append(CDF02);
			builder.append(", ");
		}
		if (CDF03 != null) {
			builder.append("CDF03=");
			builder.append(CDF03);
			builder.append(", ");
		}
		if (COSTPRICE != null) {
			builder.append("COSTPRICE=");
			builder.append(COSTPRICE);
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
		if (PRICE1 != null) {
			builder.append("PRICE1=");
			builder.append(PRICE1);
			builder.append(", ");
		}
		if (PRICE2 != null) {
			builder.append("PRICE2=");
			builder.append(PRICE2);
			builder.append(", ");
		}
		if (PRICE3 != null) {
			builder.append("PRICE3=");
			builder.append(PRICE3);
			builder.append(", ");
		}
		if (PRICE4 != null) {
			builder.append("PRICE4=");
			builder.append(PRICE4);
			builder.append(", ");
		}
		if (PRICE5 != null) {
			builder.append("PRICE5=");
			builder.append(PRICE5);
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
		if (SELLINGUNIT != null) {
			builder.append("SELLINGUNIT=");
			builder.append(SELLINGUNIT);
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
		if (WEBSHOPID != null) {
			builder.append("WEBSHOPID=");
			builder.append(WEBSHOPID);
			builder.append(", ");
		}
		if (WEIGHT != null) {
			builder.append("WEIGHT=");
			builder.append(WEIGHT);
			builder.append(", ");
		}
		if (PRODUCT_CATEGORIES != null) {
			builder.append("PRODUCT_CATEGORIES=");
			builder.append(PRODUCT_CATEGORIES);
			builder.append(", ");
		}
		if (FK_VAT != null) {
			builder.append("FK_VAT=");
			builder.append(FK_VAT);
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