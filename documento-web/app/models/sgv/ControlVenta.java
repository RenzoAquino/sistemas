package models.sgv;

import commons.Constantes;
import commons.util.FechaUtil;
import commons.util.NumeroUtil;
import io.ebean.Finder;
import io.ebean.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="control_venta")
public class ControlVenta extends Model {

    @Id
    public Long CVNT_ID;
    public Date CVNT_FEC_EMI_DOCUMENTO;
    public Date CVNT_FEC_VEN_DOCUMENTO;
    public String  CVNT_TIP_DOCUMENTO;
    public String CVNT_NUM_DOCUMENTO;
    public String  CVNT_TIP_DOC_EMISOR;
    public String CVNT_NUM_DOC_EMISOR;
    public String CVNT_RAZ_SOC_EMISOR;
    public String  CVNT_TIP_DOC_RECEPTOR;
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
    public String CVNT_TIP_DOC_REFERENCIA;
    public String CVNT_NUM_DOC_REFERENCIA;
    public String CVNT_ESTADO;
    public String CVNT_OBSERVACION;
    public String CVNT_EST_ANTERIOR;
    public String CVNT_OBS_ANTERIOR;
    public Date CVNT_PERIDO;
    public String CVNT_TIP_MONEDA;
    public Timestamp CVNT_FEC_CREACION;
    public Timestamp CVNT_FEC_MODIFICACION;
    public String CVNT_USU_CREACION;
    public String CVNT_US_MODIFICACION;
    public Date CVNT_FEC_ORD_PEDIDO;
    public Date CVNT_FEC_SER_PEDIDO;
    public Date CVNT_FEC_REC_PEDIDO;
    public Date CVNT_FEC_PAG_PEDIDO;
    public String CVNT_IND_PAGADO;
    public String CVNT_NUM_OC_PEDIDO;
    public String CVNT_CMM_DOCUMENTO;
    public String CVNT_ES_DIGITAL;
    public String CVNT_EST_DOCUMENTO;

    public static Finder<Long,ControlVenta> find = new Finder<>(ControlVenta.class);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ControlVenta{");
        if(CVNT_ID!=null)sb.append("CVNT_ID=").append(CVNT_ID);
        if(CVNT_FEC_EMI_DOCUMENTO!=null)sb.append(", CVNT_FEC_EMI_DOCUMENTO=").append(CVNT_FEC_EMI_DOCUMENTO);
        if(CVNT_FEC_VEN_DOCUMENTO!=null)sb.append(", CVNT_FEC_VEN_DOCUMENTO=").append(CVNT_FEC_VEN_DOCUMENTO);
        if(CVNT_TIP_DOCUMENTO!=null)sb.append(", CVNT_TIP_DOCUMENTO=").append(CVNT_TIP_DOCUMENTO);
        if(CVNT_NUM_DOCUMENTO!=null)sb.append(", CVNT_NUM_DOCUMENTO='").append(CVNT_NUM_DOCUMENTO).append('\'');
        if(CVNT_TIP_DOC_EMISOR!=null)sb.append(", CVNT_TIP_DOC_EMISOR=").append(CVNT_TIP_DOC_EMISOR);
        if(CVNT_NUM_DOC_EMISOR!=null)sb.append(", CVNT_NUM_DOC_EMISOR='").append(CVNT_NUM_DOC_EMISOR).append('\'');
        if(CVNT_RAZ_SOC_EMISOR!=null)sb.append(", CVNT_RAZ_SOC_EMISOR='").append(CVNT_RAZ_SOC_EMISOR).append('\'');
        if(CVNT_TIP_DOC_RECEPTOR!=null)sb.append(", CVNT_TIP_DOC_RECEPTOR=").append(CVNT_TIP_DOC_RECEPTOR);
        if(CVNT_NUM_DOC_RECEPTOR!=null)sb.append(", CVNT_NUM_DOC_RECEPTOR='").append(CVNT_NUM_DOC_RECEPTOR).append('\'');
        if(CVNT_RAZ_SOC_RECEPTOR!=null)sb.append(", CVNT_RAZ_SOC_RECEPTOR='").append(CVNT_RAZ_SOC_RECEPTOR).append('\'');
        if(CVNT_VAL_FAC_EXPORTACION!=null)sb.append(", CVNT_VAL_FAC_EXPORTACION=").append(CVNT_VAL_FAC_EXPORTACION);
        if(CVNT_VAL_OPE_GRAVADA!=null)sb.append(", CVNT_VAL_OPE_GRAVADA=").append(CVNT_VAL_OPE_GRAVADA);
        if(CVNT_VAL_OPE_EXONERADA!=null)sb.append(", CVNT_VAL_OPE_EXONERADA=").append(CVNT_VAL_OPE_EXONERADA);
        if(CVNT_VAL_OPE_INAFECTA!=null)sb.append(", CVNT_VAL_OPE_INAFECTA=").append(CVNT_VAL_OPE_INAFECTA);
        if(CVNT_ISC!=null)sb.append(", CVNT_ISC=").append(CVNT_ISC);
        if(CVNT_IGV!=null)sb.append(", CVNT_IGV=").append(CVNT_IGV);
        if(CVNT_OTR_TRIBUTOS!=null)sb.append(", CVNT_OTR_TRIBUTOS=").append(CVNT_OTR_TRIBUTOS);
        if(CVNT_IMP_TOTAL!=null)sb.append(", CVNT_IMP_TOTAL=").append(CVNT_IMP_TOTAL);
        if(CVNT_TIP_CAMBIO!=null)sb.append(", CVNT_TIP_CAMBIO=").append(CVNT_TIP_CAMBIO);
        if(CVNT_FEC_DOC_REFERENCIA!=null)sb.append(", CVNT_FEC_DOC_REFERENCIA=").append(CVNT_FEC_DOC_REFERENCIA);
        if(CVNT_TIP_DOC_REFERENCIA!=null)sb.append(", CVNT_TIP_DOC_REFERENCIA=").append(CVNT_TIP_DOC_REFERENCIA);
        if(CVNT_NUM_DOC_REFERENCIA!=null)sb.append(", CVNT_NUM_DOC_REFERENCIA='").append(CVNT_NUM_DOC_REFERENCIA).append('\'');
        if(CVNT_ESTADO!=null)sb.append(", CVNT_ESTADO=").append(CVNT_ESTADO);
        if(CVNT_OBSERVACION!=null)sb.append(", CVNT_OBSERVACION='").append(CVNT_OBSERVACION).append('\'');
        if(CVNT_EST_ANTERIOR!=null)sb.append(", CVNT_EST_ANTERIOR=").append(CVNT_EST_ANTERIOR);
        if(CVNT_OBS_ANTERIOR!=null)sb.append(", CVNT_OBS_ANTERIOR='").append(CVNT_OBS_ANTERIOR).append('\'');
        if(CVNT_PERIDO!=null)sb.append(", CVNT_PERIDO=").append(CVNT_PERIDO);
        if(CVNT_TIP_MONEDA!=null)sb.append(", CVNT_TIP_MONEDA=").append(CVNT_TIP_MONEDA);
        if(CVNT_FEC_CREACION!=null)sb.append(", CVNT_FEC_CREACION=").append(CVNT_FEC_CREACION);
        if(CVNT_FEC_MODIFICACION!=null)sb.append(", CVNT_FEC_MODIFICACION=").append(CVNT_FEC_MODIFICACION);
        if(CVNT_USU_CREACION!=null)sb.append(", CVNT_USU_CREACION='").append(CVNT_USU_CREACION).append('\'');
        if(CVNT_US_MODIFICACION!=null)sb.append(", CVNT_US_MODIFICACION='").append(CVNT_US_MODIFICACION).append('\'');
        if(CVNT_FEC_ORD_PEDIDO!=null)sb.append(", CVNT_FEC_ORD_PEDIDO=").append(CVNT_FEC_ORD_PEDIDO);
        if(CVNT_FEC_SER_PEDIDO!=null)sb.append(", CVNT_FEC_SER_PEDIDO=").append(CVNT_FEC_SER_PEDIDO);
        if(CVNT_FEC_REC_PEDIDO!=null)sb.append(", CVNT_FEC_REC_PEDIDO=").append(CVNT_FEC_REC_PEDIDO);
        if(CVNT_FEC_PAG_PEDIDO!=null)sb.append(", CVNT_FEC_PAG_PEDIDO=").append(CVNT_FEC_PAG_PEDIDO);
        if(CVNT_IND_PAGADO!=null)sb.append(", CVNT_IND_PAGADO=").append(CVNT_IND_PAGADO);
        if(CVNT_NUM_OC_PEDIDO!=null)sb.append(", CVNT_NUM_OC_PEDIDO='").append(CVNT_NUM_OC_PEDIDO).append('\'');
        if(CVNT_CMM_DOCUMENTO!=null)sb.append(", CVNT_CMM_DOCUMENTO='").append(CVNT_CMM_DOCUMENTO).append('\'');
        if(CVNT_ES_DIGITAL!=null)sb.append(", CVNT_ES_DIGITAL=").append(CVNT_ES_DIGITAL);
        if(CVNT_EST_DOCUMENTO!=null)sb.append(", CVNT_EST_DOCUMENTO=").append(CVNT_EST_DOCUMENTO);
        sb.append('}');
        return sb.toString();
    }

    public String stringParaAnulacionesCSV(String separador) throws Exception {

        List<String> toCSV = new ArrayList<>();
        toCSV.add(FechaUtil.convertirDateAString(CVNT_FEC_EMI_DOCUMENTO, Constantes.FORMATO_FECHA_DD_MM_YYYY));
        toCSV.add(CVNT_NUM_DOCUMENTO);
        toCSV.add(FechaUtil.convertirDateAString(CVNT_FEC_DOC_REFERENCIA, Constantes.FORMATO_FECHA_DD_MM_YYYY));
        toCSV.add(CVNT_TIP_DOC_REFERENCIA.toString());
        toCSV.add(CVNT_NUM_DOC_REFERENCIA);

        return toCSV.stream().collect(Collectors.joining(separador)).concat("\n");
    }
    public String stringParaLibroVentasCSV(String separador) throws Exception {

        List<String> toCSV = new ArrayList<>();
        toCSV.add(FechaUtil.convertirDateAString(CVNT_FEC_EMI_DOCUMENTO, Constantes.FORMATO_FECHA_DD_MM_YYYY));
        toCSV.add(CVNT_NUM_DOCUMENTO);
        toCSV.add(CVNT_NUM_DOC_EMISOR);
        toCSV.add(CVNT_RAZ_SOC_EMISOR);
        toCSV.add(CVNT_NUM_DOC_RECEPTOR);
        toCSV.add(CVNT_RAZ_SOC_RECEPTOR);
        toCSV.add(NumeroUtil.roundStringNull(CVNT_VAL_OPE_GRAVADA,2));
        toCSV.add(NumeroUtil.roundStringNull(CVNT_VAL_OPE_EXONERADA,2));
        toCSV.add(NumeroUtil.roundStringNull(CVNT_VAL_OPE_INAFECTA,2));
        toCSV.add(NumeroUtil.roundStringNull(CVNT_IGV,2));
        toCSV.add(NumeroUtil.roundStringNull(CVNT_IMP_TOTAL,2));

        return toCSV.stream().collect(Collectors.joining(separador)).concat("\n");
    }
}
