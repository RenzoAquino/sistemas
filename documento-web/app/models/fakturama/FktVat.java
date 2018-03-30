package models.fakturama;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="fkt_vat")
public class FktVat extends Model {
    @Id
    public Long ID;

    public Date DATEADDED;

    public Boolean DELETED;

    public String DESCRIPTION;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public Double TAXVALUE;

    public Date VALIDFROM;

    public Date VALIDTO;

    public Long FK_CATEGORY;

	@Override
	public String toString() {
		return "FktVat{" +
				"ID=" + ID +
				", DATEADDED=" + DATEADDED +
				", DELETED=" + DELETED +
				", DESCRIPTION='" + DESCRIPTION + '\'' +
				", MODIFIED=" + MODIFIED +
				", MODIFIEDBY='" + MODIFIEDBY + '\'' +
				", NAME='" + NAME + '\'' +
				", TAXVALUE=" + TAXVALUE +
				", VALIDFROM=" + VALIDFROM +
				", VALIDTO=" + VALIDTO +
				", FK_CATEGORY=" + FK_CATEGORY +
				'}';
	}
}