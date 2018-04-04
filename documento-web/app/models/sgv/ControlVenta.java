package models.sgv;

import io.ebean.Finder;
import io.ebean.Model;
import models.sunat.facturador.BandejaFactura;
import models.sunat.facturador.BandejaFacturaId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="control_venta")
public class ControlVenta extends Model {

    @Id
    public Long CVNT_ID;
    public Date CVNT_FEC_EMI_DOCUMENTO;
    public Date CVNT_FEC_VEN_DOCUMENTO;
    public Character  CVNT_TIP_DOCUMENTO;
    public String CVNT_NUM_DOCUMENTO;
    public Character  CVNT_TIP_DOC_EMISOR;
    public String CVNT_NUM_DOC_EMISOR;
    public String CVNT_RAZ_SOC_EMISOR;
    public Character  CVNT_TIP_DOC_RECEPTOR;
    public String CVNT_NUM_DOC_RECEPTOR;
    public String CVNT_RAZ_SOC_RECEPTOR;
    public Double CVNT_VAL_FAC_EXPORTACION;
    public Double CVNT_VAL_OPE_GRAVADA;
    public Double CVNT_VAL_OPE_EXONERADA;
    public Double CVNT_VAL_OPE_INAFECTA;
    public Double CVNT_ISC;
    public Double CVNT_IGV;
    public Double CVNT_OTR_TRIBUTOS;
    public Double CVNT_IMP_TOTAL;
    public Double CVNT_TIP_CAMBIO;
    public Date CVNT_FEC_DOC_REFERENCIA;
    public Character CVNT_TIP_DOC_REFERENCIA;
    public String CVNT_NUM_DOC_REFERENCIA;
    public Character CVNT_ESTADO;
    public String CVNT_OBSERVACION;
    public Character CVNT_EST_ANTERIOR;
    public String CVNT_OBS_ANTERIOR;
    public Date CVNT_PERIDO;
    public Character CVNT_TIP_MONEDA;
    public Timestamp CVNT_FEC_CREACION;
    public Timestamp CVNT_FEC_MODIFICACION;
    public String CVNT_USU_CREACION;
    public String CVNT_US_MODIFICACION;
    public Date CVNT_FEC_ORD_PEDIDO;
    public Date CVNT_FEC_SER_PEDIDO;
    public Date CVNT_FEC_REC_PEDIDO;
    public Date CVNT_FEC_PAG_PEDIDO;
    public Character CVNT_IND_PAGADO;
    public String CVNT_NUM_OC_PEDIDO;
    public String CVNT_CMM_DOCUMENTO;
    public Character CVNT_ES_DIGITAL;
    public Character CVNT_EST_DOCUMENTO;

    public static Finder<Long,ControlVenta> find = new Finder<>(ControlVenta.class);

    @Override
    public String toString() {
        return "ControlVenta{" +
                "CVNT_ID=" + CVNT_ID +
                ", CVNT_FEC_EMI_DOCUMENTO=" + CVNT_FEC_EMI_DOCUMENTO +
                ", CVNT_FEC_VEN_DOCUMENTO=" + CVNT_FEC_VEN_DOCUMENTO +
                ", CVNT_TIP_DOCUMENTO=" + CVNT_TIP_DOCUMENTO +
                ", CVNT_NUM_DOCUMENTO='" + CVNT_NUM_DOCUMENTO + '\'' +
                ", CVNT_TIP_DOC_EMISOR=" + CVNT_TIP_DOC_EMISOR +
                ", CVNT_NUM_DOC_EMISOR='" + CVNT_NUM_DOC_EMISOR + '\'' +
                ", CVNT_RAZ_SOC_EMISOR='" + CVNT_RAZ_SOC_EMISOR + '\'' +
                ", CVNT_TIP_DOC_RECEPTOR=" + CVNT_TIP_DOC_RECEPTOR +
                ", CVNT_NUM_DOC_RECEPTOR='" + CVNT_NUM_DOC_RECEPTOR + '\'' +
                ", CVNT_RAZ_SOC_RECEPTOR='" + CVNT_RAZ_SOC_RECEPTOR + '\'' +
                ", CVNT_VAL_FAC_EXPORTACION=" + CVNT_VAL_FAC_EXPORTACION +
                ", CVNT_VAL_OPE_GRAVADA=" + CVNT_VAL_OPE_GRAVADA +
                ", CVNT_VAL_OPE_EXONERADA=" + CVNT_VAL_OPE_EXONERADA +
                ", CVNT_VAL_OPE_INAFECTA=" + CVNT_VAL_OPE_INAFECTA +
                ", CVNT_ISC=" + CVNT_ISC +
                ", CVNT_IGV=" + CVNT_IGV +
                ", CVNT_OTR_TRIBUTOS=" + CVNT_OTR_TRIBUTOS +
                ", CVNT_IMP_TOTAL=" + CVNT_IMP_TOTAL +
                ", CVNT_TIP_CAMBIO=" + CVNT_TIP_CAMBIO +
                ", CVNT_FEC_DOC_REFERENCIA=" + CVNT_FEC_DOC_REFERENCIA +
                ", CVNT_TIP_DOC_REFERENCIA=" + CVNT_TIP_DOC_REFERENCIA +
                ", CVNT_NUM_DOC_REFERENCIA='" + CVNT_NUM_DOC_REFERENCIA + '\'' +
                ", CVNT_ESTADO=" + CVNT_ESTADO +
                ", CVNT_OBSERVACION='" + CVNT_OBSERVACION + '\'' +
                ", CVNT_EST_ANTERIOR=" + CVNT_EST_ANTERIOR +
                ", CVNT_OBS_ANTERIOR='" + CVNT_OBS_ANTERIOR + '\'' +
                ", CVNT_PERIDO=" + CVNT_PERIDO +
                ", CVNT_TIP_MONEDA=" + CVNT_TIP_MONEDA +
                ", CVNT_FEC_CREACION=" + CVNT_FEC_CREACION +
                ", CVNT_FEC_MODIFICACION=" + CVNT_FEC_MODIFICACION +
                ", CVNT_USU_CREACION='" + CVNT_USU_CREACION + '\'' +
                ", CVNT_US_MODIFICACION='" + CVNT_US_MODIFICACION + '\'' +
                ", CVNT_FEC_ORD_PEDIDO=" + CVNT_FEC_ORD_PEDIDO +
                ", CVNT_FEC_SER_PEDIDO=" + CVNT_FEC_SER_PEDIDO +
                ", CVNT_FEC_REC_PEDIDO=" + CVNT_FEC_REC_PEDIDO +
                ", CVNT_FEC_PAG_PEDIDO=" + CVNT_FEC_PAG_PEDIDO +
                ", CVNT_IND_PAGADO=" + CVNT_IND_PAGADO +
                ", CVNT_NUM_OC_PEDIDO='" + CVNT_NUM_OC_PEDIDO + '\'' +
                ", CVNT_CMM_DOCUMENTO='" + CVNT_CMM_DOCUMENTO + '\'' +
                ", CVNT_ES_DIGITAL=" + CVNT_ES_DIGITAL +
                ", CVNT_EST_DOCUMENTO=" + CVNT_EST_DOCUMENTO +
                '}';
    }
}
