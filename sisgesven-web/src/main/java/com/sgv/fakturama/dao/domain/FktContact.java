package com.sgv.fakturama.dao.domain;

import java.util.Date;

public class FktContact {
    private Long ID;

    private String DTYPE;

    private Date BIRTHDAY;

    private String COMPANY;

    private Integer CONTACTTYPE;

    private String CUSTOMERNUMBER;

    private Date DATEADDED;

    private Boolean DELETED;

    private Double DISCOUNT;

    private String EMAIL;

    private String FAX;

    private String FIRSTNAME;

    private Integer GENDER;

    private Long GLN;

    private String MANDATEREFERENCE;

    private String MOBILE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private String NOTE;

    private String PHONE;

    private String RELIABILITY;

    private String SUPPLIERNUMBER;

    private String TITLE;

    private Short USENETGROSS;

    private Date VALIDFROM;

    private Date VALIDTO;

    private String VATNUMBER;

    private Boolean VATNUMBERVALID;

    private String WEBSHOPNAME;

    private String WEBSITE;

    private Long FK_ADDRESS;

    private Long FK_ALTERNATECONTACT;

    private Long FK_BANKACCOUNT;

    private Long FK_CATEGORY;

    private Long FK_PAYMENT;
    
    private FktAddress address;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDTYPE() {
        return DTYPE;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }

    public Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public Integer getCONTACTTYPE() {
        return CONTACTTYPE;
    }

    public void setCONTACTTYPE(Integer CONTACTTYPE) {
        this.CONTACTTYPE = CONTACTTYPE;
    }

    public String getCUSTOMERNUMBER() {
        return CUSTOMERNUMBER;
    }

    public void setCUSTOMERNUMBER(String CUSTOMERNUMBER) {
        this.CUSTOMERNUMBER = CUSTOMERNUMBER;
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

    public Double getDISCOUNT() {
        return DISCOUNT;
    }

    public void setDISCOUNT(Double DISCOUNT) {
        this.DISCOUNT = DISCOUNT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public Integer getGENDER() {
        return GENDER;
    }

    public void setGENDER(Integer GENDER) {
        this.GENDER = GENDER;
    }

    public Long getGLN() {
        return GLN;
    }

    public void setGLN(Long GLN) {
        this.GLN = GLN;
    }

    public String getMANDATEREFERENCE() {
        return MANDATEREFERENCE;
    }

    public void setMANDATEREFERENCE(String MANDATEREFERENCE) {
        this.MANDATEREFERENCE = MANDATEREFERENCE;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
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

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getRELIABILITY() {
        return RELIABILITY;
    }

    public void setRELIABILITY(String RELIABILITY) {
        this.RELIABILITY = RELIABILITY;
    }

    public String getSUPPLIERNUMBER() {
        return SUPPLIERNUMBER;
    }

    public void setSUPPLIERNUMBER(String SUPPLIERNUMBER) {
        this.SUPPLIERNUMBER = SUPPLIERNUMBER;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public Short getUSENETGROSS() {
        return USENETGROSS;
    }

    public void setUSENETGROSS(Short USENETGROSS) {
        this.USENETGROSS = USENETGROSS;
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

    public String getVATNUMBER() {
        return VATNUMBER;
    }

    public void setVATNUMBER(String VATNUMBER) {
        this.VATNUMBER = VATNUMBER;
    }

    public Boolean getVATNUMBERVALID() {
        return VATNUMBERVALID;
    }

    public void setVATNUMBERVALID(Boolean VATNUMBERVALID) {
        this.VATNUMBERVALID = VATNUMBERVALID;
    }

    public String getWEBSHOPNAME() {
        return WEBSHOPNAME;
    }

    public void setWEBSHOPNAME(String WEBSHOPNAME) {
        this.WEBSHOPNAME = WEBSHOPNAME;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public Long getFK_ADDRESS() {
        return FK_ADDRESS;
    }

    public void setFK_ADDRESS(Long FK_ADDRESS) {
        this.FK_ADDRESS = FK_ADDRESS;
    }

    public Long getFK_ALTERNATECONTACT() {
        return FK_ALTERNATECONTACT;
    }

    public void setFK_ALTERNATECONTACT(Long FK_ALTERNATECONTACT) {
        this.FK_ALTERNATECONTACT = FK_ALTERNATECONTACT;
    }

    public Long getFK_BANKACCOUNT() {
        return FK_BANKACCOUNT;
    }

    public void setFK_BANKACCOUNT(Long FK_BANKACCOUNT) {
        this.FK_BANKACCOUNT = FK_BANKACCOUNT;
    }

    public Long getFK_CATEGORY() {
        return FK_CATEGORY;
    }

    public void setFK_CATEGORY(Long FK_CATEGORY) {
        this.FK_CATEGORY = FK_CATEGORY;
    }

    public Long getFK_PAYMENT() {
        return FK_PAYMENT;
    }

    public void setFK_PAYMENT(Long FK_PAYMENT) {
        this.FK_PAYMENT = FK_PAYMENT;
    }

	public FktAddress getAddress() {
		return address;
	}

	public void setAddress(FktAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FktContact [");
		if (ID != null) {
			builder.append("ID=");
			builder.append(ID);
			builder.append(", ");
		}
		if (DTYPE != null) {
			builder.append("DTYPE=");
			builder.append(DTYPE);
			builder.append(", ");
		}
		if (BIRTHDAY != null) {
			builder.append("BIRTHDAY=");
			builder.append(BIRTHDAY);
			builder.append(", ");
		}
		if (COMPANY != null) {
			builder.append("COMPANY=");
			builder.append(COMPANY);
			builder.append(", ");
		}
		if (CONTACTTYPE != null) {
			builder.append("CONTACTTYPE=");
			builder.append(CONTACTTYPE);
			builder.append(", ");
		}
		if (CUSTOMERNUMBER != null) {
			builder.append("CUSTOMERNUMBER=");
			builder.append(CUSTOMERNUMBER);
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
		if (DISCOUNT != null) {
			builder.append("DISCOUNT=");
			builder.append(DISCOUNT);
			builder.append(", ");
		}
		if (EMAIL != null) {
			builder.append("EMAIL=");
			builder.append(EMAIL);
			builder.append(", ");
		}
		if (FAX != null) {
			builder.append("FAX=");
			builder.append(FAX);
			builder.append(", ");
		}
		if (FIRSTNAME != null) {
			builder.append("FIRSTNAME=");
			builder.append(FIRSTNAME);
			builder.append(", ");
		}
		if (GENDER != null) {
			builder.append("GENDER=");
			builder.append(GENDER);
			builder.append(", ");
		}
		if (GLN != null) {
			builder.append("GLN=");
			builder.append(GLN);
			builder.append(", ");
		}
		if (MANDATEREFERENCE != null) {
			builder.append("MANDATEREFERENCE=");
			builder.append(MANDATEREFERENCE);
			builder.append(", ");
		}
		if (MOBILE != null) {
			builder.append("MOBILE=");
			builder.append(MOBILE);
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
		if (NOTE != null) {
			builder.append("NOTE=");
			builder.append(NOTE);
			builder.append(", ");
		}
		if (PHONE != null) {
			builder.append("PHONE=");
			builder.append(PHONE);
			builder.append(", ");
		}
		if (RELIABILITY != null) {
			builder.append("RELIABILITY=");
			builder.append(RELIABILITY);
			builder.append(", ");
		}
		if (SUPPLIERNUMBER != null) {
			builder.append("SUPPLIERNUMBER=");
			builder.append(SUPPLIERNUMBER);
			builder.append(", ");
		}
		if (TITLE != null) {
			builder.append("TITLE=");
			builder.append(TITLE);
			builder.append(", ");
		}
		if (USENETGROSS != null) {
			builder.append("USENETGROSS=");
			builder.append(USENETGROSS);
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
		if (VATNUMBER != null) {
			builder.append("VATNUMBER=");
			builder.append(VATNUMBER);
			builder.append(", ");
		}
		if (VATNUMBERVALID != null) {
			builder.append("VATNUMBERVALID=");
			builder.append(VATNUMBERVALID);
			builder.append(", ");
		}
		if (WEBSHOPNAME != null) {
			builder.append("WEBSHOPNAME=");
			builder.append(WEBSHOPNAME);
			builder.append(", ");
		}
		if (WEBSITE != null) {
			builder.append("WEBSITE=");
			builder.append(WEBSITE);
			builder.append(", ");
		}
		if (FK_ADDRESS != null) {
			builder.append("FK_ADDRESS=");
			builder.append(FK_ADDRESS);
			builder.append(", ");
		}
		if (FK_ALTERNATECONTACT != null) {
			builder.append("FK_ALTERNATECONTACT=");
			builder.append(FK_ALTERNATECONTACT);
			builder.append(", ");
		}
		if (FK_BANKACCOUNT != null) {
			builder.append("FK_BANKACCOUNT=");
			builder.append(FK_BANKACCOUNT);
			builder.append(", ");
		}
		if (FK_CATEGORY != null) {
			builder.append("FK_CATEGORY=");
			builder.append(FK_CATEGORY);
			builder.append(", ");
		}
		if (FK_PAYMENT != null) {
			builder.append("FK_PAYMENT=");
			builder.append(FK_PAYMENT);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
		}
		builder.append("]");
		return builder.toString();
	}

	
}