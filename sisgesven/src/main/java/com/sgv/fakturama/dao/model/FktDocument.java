package com.sgv.fakturama.dao.model;

import java.util.Date;
import java.util.List;

public class FktDocument {
    private Long ID;

    private String DTYPE;

    private String ADDRESSFIRSTLINE;

    private Integer BILLINGTYPE;

    private String CONSULTANT;

    private String CUSTOMERREF;

    private Date DATEADDED;

    private Boolean DELETED;

    private Boolean DEPOSIT;

    private Date DOCUMENTDATE;

    private Integer DUEDAYS;

    private Double ITEMSREBATE;

    private Date MODIFIED;

    private String MODIFIEDBY;

    private String NAME;

    private Integer NETGROSS;

    private String ODTPATH;

    private Date ORDERDATE;

    private Boolean PAID;

    private Double PAIDVALUE;

    private Date PAYDATE;

    private String PDFPATH;

    private String PRINTTEMPLATE;

    private Boolean PRINTED;

    private Integer PROGRESS;

    private Date SERVICEDATE;

    private String SHIPPINGAUTOVAT;

    private Double SHIPPINGVALUE;

    private Double TOTALVALUE;

    private Integer TRANSACTIONID;

    private Date VALIDFROM;

    private Date VALIDTO;

    private Date WEBSHOPDATE;

    private String WEBSHOPID;

    private Long FK_INDIVIDUALINFO;

    private Long FK_CONTACT;

    private Long FK_DELIVERYCONTACT;

    private Long DOCUMENT_INVOICEREFERENCE;

    private Long FK_NOVATREF;

    private Long FK_PAYMENT;

    private Long FK_SHIPPING;

    private Long FK_SRCDOCUMENT;

    private String MESSAGE;

    private String MESSAGE2;

    private String MESSAGE3;
    
    private FktContact contact; 
    private List<FktDocumentitem> items;

    private Date DUEDATE;
    private Double operacionGravadaTotal;
    private Double operacionExoneradaTotal;
    private Double operacionInafectaTotal;
    private Double igvTotal;
    private Double importeTotal;
    private String respuesta;
    private String oc;
    
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

    public String getADDRESSFIRSTLINE() {
        return ADDRESSFIRSTLINE;
    }

    public void setADDRESSFIRSTLINE(String ADDRESSFIRSTLINE) {
        this.ADDRESSFIRSTLINE = ADDRESSFIRSTLINE;
    }

    public Integer getBILLINGTYPE() {
        return BILLINGTYPE;
    }

    public void setBILLINGTYPE(Integer BILLINGTYPE) {
        this.BILLINGTYPE = BILLINGTYPE;
    }

    public String getCONSULTANT() {
        return CONSULTANT;
    }

    public void setCONSULTANT(String CONSULTANT) {
        this.CONSULTANT = CONSULTANT;
    }

    public String getCUSTOMERREF() {
        return CUSTOMERREF;
    }

    public void setCUSTOMERREF(String CUSTOMERREF) {
        this.CUSTOMERREF = CUSTOMERREF;
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

    public Boolean getDEPOSIT() {
        return DEPOSIT;
    }

    public void setDEPOSIT(Boolean DEPOSIT) {
        this.DEPOSIT = DEPOSIT;
    }

    public Date getDOCUMENTDATE() {
        return DOCUMENTDATE;
    }

    public void setDOCUMENTDATE(Date DOCUMENTDATE) {
        this.DOCUMENTDATE = DOCUMENTDATE;
    }

    public Integer getDUEDAYS() {
        return DUEDAYS;
    }

    public void setDUEDAYS(Integer DUEDAYS) {
        this.DUEDAYS = DUEDAYS;
    }

    public Double getITEMSREBATE() {
        return ITEMSREBATE;
    }

    public void setITEMSREBATE(Double ITEMSREBATE) {
        this.ITEMSREBATE = ITEMSREBATE;
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

    public Integer getNETGROSS() {
        return NETGROSS;
    }

    public void setNETGROSS(Integer NETGROSS) {
        this.NETGROSS = NETGROSS;
    }

    public String getODTPATH() {
        return ODTPATH;
    }

    public void setODTPATH(String ODTPATH) {
        this.ODTPATH = ODTPATH;
    }

    public Date getORDERDATE() {
        return ORDERDATE;
    }

    public void setORDERDATE(Date ORDERDATE) {
        this.ORDERDATE = ORDERDATE;
    }

    public Boolean getPAID() {
        return PAID;
    }

    public void setPAID(Boolean PAID) {
        this.PAID = PAID;
    }

    public Double getPAIDVALUE() {
        return PAIDVALUE;
    }

    public void setPAIDVALUE(Double PAIDVALUE) {
        this.PAIDVALUE = PAIDVALUE;
    }

    public Date getPAYDATE() {
        return PAYDATE;
    }

    public void setPAYDATE(Date PAYDATE) {
        this.PAYDATE = PAYDATE;
    }

    public String getPDFPATH() {
        return PDFPATH;
    }

    public void setPDFPATH(String PDFPATH) {
        this.PDFPATH = PDFPATH;
    }

    public String getPRINTTEMPLATE() {
        return PRINTTEMPLATE;
    }

    public void setPRINTTEMPLATE(String PRINTTEMPLATE) {
        this.PRINTTEMPLATE = PRINTTEMPLATE;
    }

    public Boolean getPRINTED() {
        return PRINTED;
    }

    public void setPRINTED(Boolean PRINTED) {
        this.PRINTED = PRINTED;
    }

    public Integer getPROGRESS() {
        return PROGRESS;
    }

    public void setPROGRESS(Integer PROGRESS) {
        this.PROGRESS = PROGRESS;
    }

    public Date getSERVICEDATE() {
        return SERVICEDATE;
    }

    public void setSERVICEDATE(Date SERVICEDATE) {
        this.SERVICEDATE = SERVICEDATE;
    }

    public String getSHIPPINGAUTOVAT() {
        return SHIPPINGAUTOVAT;
    }

    public void setSHIPPINGAUTOVAT(String SHIPPINGAUTOVAT) {
        this.SHIPPINGAUTOVAT = SHIPPINGAUTOVAT;
    }

    public Double getSHIPPINGVALUE() {
        return SHIPPINGVALUE;
    }

    public void setSHIPPINGVALUE(Double SHIPPINGVALUE) {
        this.SHIPPINGVALUE = SHIPPINGVALUE;
    }

    public Double getTOTALVALUE() {
        return TOTALVALUE;
    }

    public void setTOTALVALUE(Double TOTALVALUE) {
        this.TOTALVALUE = TOTALVALUE;
    }

    public Integer getTRANSACTIONID() {
        return TRANSACTIONID;
    }

    public void setTRANSACTIONID(Integer TRANSACTIONID) {
        this.TRANSACTIONID = TRANSACTIONID;
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

    public Date getWEBSHOPDATE() {
        return WEBSHOPDATE;
    }

    public void setWEBSHOPDATE(Date WEBSHOPDATE) {
        this.WEBSHOPDATE = WEBSHOPDATE;
    }

    public String getWEBSHOPID() {
        return WEBSHOPID;
    }

    public void setWEBSHOPID(String WEBSHOPID) {
        this.WEBSHOPID = WEBSHOPID;
    }

    public Long getFK_INDIVIDUALINFO() {
        return FK_INDIVIDUALINFO;
    }

    public void setFK_INDIVIDUALINFO(Long FK_INDIVIDUALINFO) {
        this.FK_INDIVIDUALINFO = FK_INDIVIDUALINFO;
    }

    public Long getFK_CONTACT() {
        return FK_CONTACT;
    }

    public void setFK_CONTACT(Long FK_CONTACT) {
        this.FK_CONTACT = FK_CONTACT;
    }

    public Long getFK_DELIVERYCONTACT() {
        return FK_DELIVERYCONTACT;
    }

    public void setFK_DELIVERYCONTACT(Long FK_DELIVERYCONTACT) {
        this.FK_DELIVERYCONTACT = FK_DELIVERYCONTACT;
    }

    public Long getDOCUMENT_INVOICEREFERENCE() {
        return DOCUMENT_INVOICEREFERENCE;
    }

    public void setDOCUMENT_INVOICEREFERENCE(Long DOCUMENT_INVOICEREFERENCE) {
        this.DOCUMENT_INVOICEREFERENCE = DOCUMENT_INVOICEREFERENCE;
    }

    public Long getFK_NOVATREF() {
        return FK_NOVATREF;
    }

    public void setFK_NOVATREF(Long FK_NOVATREF) {
        this.FK_NOVATREF = FK_NOVATREF;
    }

    public Long getFK_PAYMENT() {
        return FK_PAYMENT;
    }

    public void setFK_PAYMENT(Long FK_PAYMENT) {
        this.FK_PAYMENT = FK_PAYMENT;
    }

    public Long getFK_SHIPPING() {
        return FK_SHIPPING;
    }

    public void setFK_SHIPPING(Long FK_SHIPPING) {
        this.FK_SHIPPING = FK_SHIPPING;
    }

    public Long getFK_SRCDOCUMENT() {
        return FK_SRCDOCUMENT;
    }

    public void setFK_SRCDOCUMENT(Long FK_SRCDOCUMENT) {
        this.FK_SRCDOCUMENT = FK_SRCDOCUMENT;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getMESSAGE2() {
        return MESSAGE2;
    }

    public void setMESSAGE2(String MESSAGE2) {
        this.MESSAGE2 = MESSAGE2;
    }

    public String getMESSAGE3() {
        return MESSAGE3;
    }

    public void setMESSAGE3(String MESSAGE3) {
        this.MESSAGE3 = MESSAGE3;
    }

	public FktContact getContact() {
		return contact;
	}

	public void setContact(FktContact contact) {
		this.contact = contact;
	}

	public List<FktDocumentitem> getItems() {
		return items;
	}

	public void setItems(List<FktDocumentitem> items) {
		this.items = items;
	}

	public Date getDUEDATE() {
		return DUEDATE;
	}

	public void setDUEDATE(Date dUEDATE) {
		DUEDATE = dUEDATE;
	}

	

	public Double getOperacionGravadaTotal() {
		return operacionGravadaTotal;
	}

	public void setOperacionGravadaTotal(Double operacionGravadaTotal) {
		this.operacionGravadaTotal = operacionGravadaTotal;
	}

	public Double getOperacionExoneradaTotal() {
		return operacionExoneradaTotal;
	}

	public void setOperacionExoneradaTotal(Double operacionExoneradaTotal) {
		this.operacionExoneradaTotal = operacionExoneradaTotal;
	}

	public Double getOperacionInafectaTotal() {
		return operacionInafectaTotal;
	}

	public void setOperacionInafectaTotal(Double operacionInafectaTotal) {
		this.operacionInafectaTotal = operacionInafectaTotal;
	}

	public Double getIgvTotal() {
		return igvTotal;
	}

	public void setIgvTotal(Double igvTotal) {
		this.igvTotal = igvTotal;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getOc() {
		return oc;
	}

	public void setOc(String oc) {
		this.oc = oc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FktDocument [");
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
		if (ADDRESSFIRSTLINE != null) {
			builder.append("ADDRESSFIRSTLINE=");
			builder.append(ADDRESSFIRSTLINE);
			builder.append(", ");
		}
		if (BILLINGTYPE != null) {
			builder.append("BILLINGTYPE=");
			builder.append(BILLINGTYPE);
			builder.append(", ");
		}
		if (CONSULTANT != null) {
			builder.append("CONSULTANT=");
			builder.append(CONSULTANT);
			builder.append(", ");
		}
		if (CUSTOMERREF != null) {
			builder.append("CUSTOMERREF=");
			builder.append(CUSTOMERREF);
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
		if (DEPOSIT != null) {
			builder.append("DEPOSIT=");
			builder.append(DEPOSIT);
			builder.append(", ");
		}
		if (DOCUMENTDATE != null) {
			builder.append("DOCUMENTDATE=");
			builder.append(DOCUMENTDATE);
			builder.append(", ");
		}
		if (DUEDAYS != null) {
			builder.append("DUEDAYS=");
			builder.append(DUEDAYS);
			builder.append(", ");
		}
		if (ITEMSREBATE != null) {
			builder.append("ITEMSREBATE=");
			builder.append(ITEMSREBATE);
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
		if (NETGROSS != null) {
			builder.append("NETGROSS=");
			builder.append(NETGROSS);
			builder.append(", ");
		}
		if (ODTPATH != null) {
			builder.append("ODTPATH=");
			builder.append(ODTPATH);
			builder.append(", ");
		}
		if (ORDERDATE != null) {
			builder.append("ORDERDATE=");
			builder.append(ORDERDATE);
			builder.append(", ");
		}
		if (PAID != null) {
			builder.append("PAID=");
			builder.append(PAID);
			builder.append(", ");
		}
		if (PAIDVALUE != null) {
			builder.append("PAIDVALUE=");
			builder.append(PAIDVALUE);
			builder.append(", ");
		}
		if (PAYDATE != null) {
			builder.append("PAYDATE=");
			builder.append(PAYDATE);
			builder.append(", ");
		}
		if (PDFPATH != null) {
			builder.append("PDFPATH=");
			builder.append(PDFPATH);
			builder.append(", ");
		}
		if (PRINTTEMPLATE != null) {
			builder.append("PRINTTEMPLATE=");
			builder.append(PRINTTEMPLATE);
			builder.append(", ");
		}
		if (PRINTED != null) {
			builder.append("PRINTED=");
			builder.append(PRINTED);
			builder.append(", ");
		}
		if (PROGRESS != null) {
			builder.append("PROGRESS=");
			builder.append(PROGRESS);
			builder.append(", ");
		}
		if (SERVICEDATE != null) {
			builder.append("SERVICEDATE=");
			builder.append(SERVICEDATE);
			builder.append(", ");
		}
		if (SHIPPINGAUTOVAT != null) {
			builder.append("SHIPPINGAUTOVAT=");
			builder.append(SHIPPINGAUTOVAT);
			builder.append(", ");
		}
		if (SHIPPINGVALUE != null) {
			builder.append("SHIPPINGVALUE=");
			builder.append(SHIPPINGVALUE);
			builder.append(", ");
		}
		if (TOTALVALUE != null) {
			builder.append("TOTALVALUE=");
			builder.append(TOTALVALUE);
			builder.append(", ");
		}
		if (TRANSACTIONID != null) {
			builder.append("TRANSACTIONID=");
			builder.append(TRANSACTIONID);
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
		if (WEBSHOPDATE != null) {
			builder.append("WEBSHOPDATE=");
			builder.append(WEBSHOPDATE);
			builder.append(", ");
		}
		if (WEBSHOPID != null) {
			builder.append("WEBSHOPID=");
			builder.append(WEBSHOPID);
			builder.append(", ");
		}
		if (FK_INDIVIDUALINFO != null) {
			builder.append("FK_INDIVIDUALINFO=");
			builder.append(FK_INDIVIDUALINFO);
			builder.append(", ");
		}
		if (FK_CONTACT != null) {
			builder.append("FK_CONTACT=");
			builder.append(FK_CONTACT);
			builder.append(", ");
		}
		if (FK_DELIVERYCONTACT != null) {
			builder.append("FK_DELIVERYCONTACT=");
			builder.append(FK_DELIVERYCONTACT);
			builder.append(", ");
		}
		if (DOCUMENT_INVOICEREFERENCE != null) {
			builder.append("DOCUMENT_INVOICEREFERENCE=");
			builder.append(DOCUMENT_INVOICEREFERENCE);
			builder.append(", ");
		}
		if (FK_NOVATREF != null) {
			builder.append("FK_NOVATREF=");
			builder.append(FK_NOVATREF);
			builder.append(", ");
		}
		if (FK_PAYMENT != null) {
			builder.append("FK_PAYMENT=");
			builder.append(FK_PAYMENT);
			builder.append(", ");
		}
		if (FK_SHIPPING != null) {
			builder.append("FK_SHIPPING=");
			builder.append(FK_SHIPPING);
			builder.append(", ");
		}
		if (FK_SRCDOCUMENT != null) {
			builder.append("FK_SRCDOCUMENT=");
			builder.append(FK_SRCDOCUMENT);
			builder.append(", ");
		}
		if (MESSAGE != null) {
			builder.append("MESSAGE=");
			builder.append(MESSAGE);
			builder.append(", ");
		}
		if (MESSAGE2 != null) {
			builder.append("MESSAGE2=");
			builder.append(MESSAGE2);
			builder.append(", ");
		}
		if (MESSAGE3 != null) {
			builder.append("MESSAGE3=");
			builder.append(MESSAGE3);
			builder.append(", ");
		}
		if (contact != null) {
			builder.append("contact=");
			builder.append(contact);
			builder.append(", ");
		}
		if (items != null) {
			builder.append("items=");
			for (FktDocumentitem item : items) {
				builder.append("\n"+item);
			}
			builder.append(", ");
		}
		if (DUEDATE != null) {
			builder.append("DUEDATE=");
			builder.append(DUEDATE);
			builder.append(", ");
		}
		if (operacionGravadaTotal != null) {
			builder.append("operacionGravadaTotal=");
			builder.append(operacionGravadaTotal);
			builder.append(", ");
		}
		if (operacionExoneradaTotal != null) {
			builder.append("operacionExoneradaTotal=");
			builder.append(operacionExoneradaTotal);
			builder.append(", ");
		}
		if (operacionInafectaTotal != null) {
			builder.append("operacionInafectaTotal=");
			builder.append(operacionInafectaTotal);
			builder.append(", ");
		}
		if (igvTotal != null) {
			builder.append("igvTotal=");
			builder.append(igvTotal);
			builder.append(", ");
		}
		if (importeTotal != null) {
			builder.append("importeTotal=");
			builder.append(importeTotal);
			builder.append(", ");
		}
		if (respuesta != null) {
			builder.append("respuesta=");
			builder.append(respuesta);
			builder.append(", ");
		}
		if (oc != null) {
			builder.append("oc=");
			builder.append(oc);
		}
		builder.append("]");
		return builder.toString();
	}


	
    
}