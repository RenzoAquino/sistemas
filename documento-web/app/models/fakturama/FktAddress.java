package models.fakturama;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "fkt_address")
public class FktAddress {
    @Id
    public Long ID;

    public String CITY;

    public String CITYADDON;

    public String COUNTRYCODE;

    public Date DATEADDED;

    public Boolean DELETED;

    public String MANUALADDRESS;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public String STREET;

    public Date VALIDFROM;

    public Date VALIDTO;

    public String ZIP;
}