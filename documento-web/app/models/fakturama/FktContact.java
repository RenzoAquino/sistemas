package models.fakturama;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="fkt_contact")
public class FktContact {
    @Id
    public Long ID;

    public String DTYPE;

    public Date BIRTHDAY;

    public String COMPANY;

    public Integer CONTACTTYPE;

    public String CUSTOMERNUMBER;

    public Date DATEADDED;

    public Boolean DELETED;

    public Double DISCOUNT;

    public String EMAIL;

    public String FAX;

    public String FIRSTNAME;

    public Integer GENDER;

    public Long GLN;

    public String MANDATEREFERENCE;

    public String MOBILE;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public String NOTE;

    public String PHONE;

    public String RELIABILITY;

    public String SUPPLIERNUMBER;

    public String TITLE;

    public Short USENETGROSS;

    public Date VALIDFROM;

    public Date VALIDTO;

    public String VATNUMBER;

    public Boolean VATNUMBERVALID;

    public String WEBSHOPNAME;

    public String WEBSITE;

    public Long FK_ADDRESS;

    public Long FK_ALTERNATECONTACT;

    public Long FK_BANKACCOUNT;

    public Long FK_CATEGORY;

    public Long FK_PAYMENT;
	@Transient
    public FktAddress address;

	public static Finder<Long,FktContact> find = new Finder<>(FktContact.class);

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