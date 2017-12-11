package models.fakturama;

import io.ebean.Finder;
import models.fakturama.FktVat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="fkt_documentitem")
public class FktDocumentitem {

    @Id
    public Long ID;

    public Date DATEADDED;

    public Boolean DELETED;

    public Long GTIN;

    public String ITEMNUMBER;

    public Double ITEMREBATE;

    public String ITEMTYPE;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public Boolean NOVAT;

    public Boolean OPTIONAL;

    public Integer POSNR;

    public Double PRICE;

    public Double QUANTITY;

    public String QUANTITYUNIT;

    public Double TARA;

    public Date VALIDFROM;

    public Date VALIDTO;

    public Date VESTINGPERIODEND;

    public Date VESTINGPERIODSTART;

    public Double WEIGHT;

    public Long FK_PRODUCT;

    public Long FK_DOCUMENT;

    public String DESCRIPTION;

    public byte[] PICTURE;

	@ManyToOne
	@JoinColumn(name = "FK_VAT", referencedColumnName = "ID")
	public FktVat vat;
/*
	@Transient
	public Long FK_VAT;
*/
	public static Finder<Long,FktDocumentitem> find = new Finder<>(FktDocumentitem.class);
	//public static Finder<Long, FktDocumentitem> find2 = new Finder<Long, FktDocumentitem>(Long.class, FktDocumentitem.class);


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
/*		if (FK_VAT != null) {
			builder.append("FK_VAT=");
			builder.append(FK_VAT);
			builder.append(", ");
		}
*/		if (FK_PRODUCT != null) {
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