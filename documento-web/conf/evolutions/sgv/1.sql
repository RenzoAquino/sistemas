# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table control_venta (
  cvnt_id                       bigint auto_increment not null,
  cvnt_fec_emi_documento        datetime(6),
  cvnt_fec_ven_documento        datetime(6),
  cvnt_num_documento            varchar(255),
  cvnt_num_doc_emisor           varchar(255),
  cvnt_raz_soc_emisor           varchar(255),
  cvnt_num_doc_receptor         varchar(255),
  cvnt_raz_soc_receptor         varchar(255),
  cvnt_val_fac_exportacion      double,
  cvnt_val_ope_gravada          double,
  cvnt_val_ope_exonerada        double,
  cvnt_val_ope_inafecta         double,
  cvnt_isc                      double,
  cvnt_igv                      double,
  cvnt_otr_tributos             double,
  cvnt_imp_total                double,
  cvnt_tip_cambio               double,
  cvnt_fec_doc_referencia       datetime(6),
  cvnt_num_doc_referencia       varchar(255),
  cvnt_observacion              varchar(255),
  cvnt_obs_anterior             varchar(255),
  cvnt_perido                   datetime(6),
  cvnt_fec_creacion             datetime(6),
  cvnt_fec_modificacion         datetime(6),
  cvnt_usu_creacion             varchar(255),
  cvnt_us_modificacion          varchar(255),
  cvnt_fec_ord_pedido           datetime(6),
  cvnt_fec_ser_pedido           datetime(6),
  cvnt_fec_rec_pedido           datetime(6),
  cvnt_fec_pag_pedido           datetime(6),
  cvnt_num_oc_pedido            varchar(255),
  cvnt_cmm_documento            varchar(255),
  constraint pk_control_venta primary key (cvnt_id)
);


# --- !Downs

drop table if exists control_venta;

