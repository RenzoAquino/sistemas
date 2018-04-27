package com.sisint.fakturama.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fkt_document")
public class FktDocument {

	public FktDocument(){
	}

	public FktDocument(String NAME, String DTYPE){
		this.NAME = NAME;
		this.DTYPE = DTYPE;
	}

	@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    public Long ID;

    public String DTYPE;

    public String ADDRESSFIRSTLINE;

    public Integer BILLINGTYPE;

    public String CONSULTANT;

    public String CUSTOMERREF;

    public Date DATEADDED;

    public Boolean DELETED;

    public Boolean DEPOSIT;

    public Date DOCUMENTDATE;

    public Integer DUEDAYS;

    public Double ITEMSREBATE;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public Integer NETGROSS;

    public String ODTPATH;

    public Date ORDERDATE;

    public Boolean PAID;

    public Double PAIDVALUE;

    public Date PAYDATE;

    public String PDFPATH;

    public String PRINTTEMPLATE;

    public Boolean PRINTED;

    public Integer PROGRESS;

    public Date SERVICEDATE;

    public String SHIPPINGAUTOVAT;

    public Double SHIPPINGVALUE;

    public Double TOTALVALUE;

    public Integer TRANSACTIONID;

    public Date VALIDFROM;

    public Date VALIDTO;

    public Date WEBSHOPDATE;

    public String WEBSHOPID;

    public Long FK_INDIVIDUALINFO;

    public Long FK_CONTACT;

    public Long FK_DELIVERYCONTACT;

    public Long DOCUMENT_INVOICEREFERENCE;

    public Long FK_NOVATREF;

    public Long FK_PAYMENT;

    public Long FK_SHIPPING;

    public Long FK_SRCDOCUMENT;

    public String MESSAGE;

    public String MESSAGE2;

    public String MESSAGE3;
    
    //public FktContact contact;
    //public List<FktDocumentitem> items;

	@Transient
    public Date DUEDATE;
    @Transient
    public Double operacionGravadaTotal;
	@Transient
    public Double operacionExoneradaTotal;
	@Transient
    public Double operacionInafectaTotal;
	@Transient
    public Double igvTotal;
	@Transient
    public Double importeTotal;
	@Transient
    public String respuesta;
	@Transient
    public String oc;


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
/*
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
*/
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