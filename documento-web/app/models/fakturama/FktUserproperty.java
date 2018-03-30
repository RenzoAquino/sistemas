package models.fakturama;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="fkt_userproperty")
public class FktUserproperty  extends Model {

    public static Finder<Long,FktUserproperty> find = new Finder<>(FktUserproperty.class);

    @Id
    public Long ID;

    public Date DATEADDED;

    public Boolean DELETED;

    public Date MODIFIED;

    public String MODIFIEDBY;

    public String NAME;

    public String t_USER;

    public Date VALIDFROM;

    public Date VALIDTO;

    public String t_VALUE;


    @Override
    public String toString() {
        return "FktUserproperty{" +
                "ID=" + ID +
                ", DATEADDED=" + DATEADDED +
                ", DELETED=" + DELETED +
                ", MODIFIED=" + MODIFIED +
                ", MODIFIEDBY='" + MODIFIEDBY + '\'' +
                ", NAME='" + NAME + '\'' +
                ", t_USER='" + t_USER + '\'' +
                ", VALIDFROM=" + VALIDFROM +
                ", VALIDTO=" + VALIDTO +
                ", t_VALUE='" + t_VALUE + '\'' +
                '}';
    }
}