# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table txxxx_bandfact (
  num_ruc                       varchar(255) not null,
  tip_docu                      varchar(255) not null,
  num_docu                      varchar(255) not null,
  fec_carg                      varchar(255),
  fec_gene                      varchar(255),
  fec_envi                      varchar(255),
  des_obse                      varchar(255),
  nom_arch                      varchar(255),
  ind_situ                      varchar(255),
  tip_arch                      varchar(255),
  firm_digital                  varchar(255),
  constraint pk_txxxx_bandfact primary key (num_ruc,tip_docu,num_docu)
);

create table categoria (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  nombre                        varchar(255),
  descripcion                   varchar(255),
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_categoria primary key (id)
);

create table contacto (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  tipocontacto_ruc              varchar(255),
  tipocontacto_codigo           varchar(255),
  tipocontacto_codigo_padre     varchar(255),
  tipopersona_ruc               varchar(255),
  tipopersona_codigo            varchar(255),
  tipopersona_codigo_padre      varchar(255),
  ruc                           varchar(255),
  numero_documento              varchar(255),
  alias                         varchar(255),
  nombres                       varchar(255),
  apellido_paterno              varchar(255),
  apellido_materno              varchar(255),
  razon_social                  varchar(255),
  fecha_creacion                datetime(6),
  email                         varchar(255),
  telefono_fijo                 varchar(255),
  telefono_movil                varchar(255),
  web_site                      varchar(255),
  comentario                    varchar(255),
  direccion_id                  bigint,
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint uq_contacto_direccion_id unique (direccion_id),
  constraint pk_contacto primary key (id)
);

create table control_venta (
  cvnt_id                       bigint auto_increment not null,
  cvnt_fec_emi_documento        datetime(6),
  cvnt_fec_ven_documento        datetime(6),
  cvnt_tip_documento            varchar(255),
  cvnt_num_documento            varchar(255),
  cvnt_tip_doc_emisor           varchar(255),
  cvnt_num_doc_emisor           varchar(255),
  cvnt_raz_soc_emisor           varchar(255),
  cvnt_tip_doc_receptor         varchar(255),
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
  cvnt_tip_doc_referencia       varchar(255),
  cvnt_num_doc_referencia       varchar(255),
  cvnt_estado                   varchar(255),
  cvnt_observacion              varchar(255),
  cvnt_est_anterior             varchar(255),
  cvnt_obs_anterior             varchar(255),
  cvnt_perido                   datetime(6),
  cvnt_tip_moneda               varchar(255),
  cvnt_fec_creacion             datetime(6),
  cvnt_fec_modificacion         datetime(6),
  cvnt_usu_creacion             varchar(255),
  cvnt_us_modificacion          varchar(255),
  cvnt_fec_ord_pedido           datetime(6),
  cvnt_fec_ser_pedido           datetime(6),
  cvnt_fec_rec_pedido           datetime(6),
  cvnt_fec_pag_pedido           datetime(6),
  cvnt_ind_pagado               varchar(255),
  cvnt_num_oc_pedido            varchar(255),
  cvnt_cmm_documento            varchar(255),
  cvnt_es_digital               varchar(255),
  cvnt_est_documento            varchar(255),
  constraint pk_control_venta primary key (cvnt_id)
);

create table direccion (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  calle                         varchar(255),
  codigo_postal                 varchar(255),
  referencia                    varchar(255),
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_direccion primary key (id)
);

create table documento (
  id                            bigint auto_increment not null,
  type_documento                varchar(255),
  name                          varchar(255),
  igv                           decimal(38),
  menssage1                     varchar(255),
  menssage2                     varchar(255),
  menssage3                     varchar(255),
  constraint pk_documento primary key (id)
);

create table fkt_address (
  id                            bigint auto_increment not null,
  city                          varchar(255),
  cityaddon                     varchar(255),
  countrycode                   varchar(255),
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  manualaddress                 varchar(255),
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  street                        varchar(255),
  validfrom                     datetime(6),
  validto                       datetime(6),
  zip                           varchar(255),
  constraint pk_fkt_address primary key (id)
);

create table fkt_contact (
  id                            bigint auto_increment not null,
  dtype                         varchar(255),
  birthday                      datetime(6),
  company                       varchar(255),
  contacttype                   integer,
  customernumber                varchar(255),
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  discount                      double,
  email                         varchar(255),
  fax                           varchar(255),
  firstname                     varchar(255),
  gender                        integer,
  gln                           bigint,
  mandatereference              varchar(255),
  mobile                        varchar(255),
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  note                          varchar(255),
  phone                         varchar(255),
  reliability                   varchar(255),
  suppliernumber                varchar(255),
  title                         varchar(255),
  usenetgross                   smallint,
  validfrom                     datetime(6),
  validto                       datetime(6),
  vatnumber                     varchar(255),
  vatnumbervalid                tinyint(1) default 0,
  webshopname                   varchar(255),
  website                       varchar(255),
  fk_address                    bigint,
  fk_alternatecontact           bigint,
  fk_bankaccount                bigint,
  fk_category                   bigint,
  fk_payment                    bigint,
  constraint pk_fkt_contact primary key (id)
);

create table fkt_document (
  id                            bigint auto_increment not null,
  dtype                         varchar(255),
  addressfirstline              varchar(255),
  billingtype                   integer,
  consultant                    varchar(255),
  customerref                   varchar(255),
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  deposit                       tinyint(1) default 0,
  documentdate                  datetime(6),
  duedays                       integer,
  itemsrebate                   double,
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  netgross                      integer,
  odtpath                       varchar(255),
  orderdate                     datetime(6),
  paid                          tinyint(1) default 0,
  paidvalue                     double,
  paydate                       datetime(6),
  pdfpath                       varchar(255),
  printtemplate                 varchar(255),
  printed                       tinyint(1) default 0,
  progress                      integer,
  servicedate                   datetime(6),
  shippingautovat               varchar(255),
  shippingvalue                 double,
  totalvalue                    double,
  transactionid                 integer,
  validfrom                     datetime(6),
  validto                       datetime(6),
  webshopdate                   datetime(6),
  webshopid                     varchar(255),
  fk_individualinfo             bigint,
  fk_deliverycontact            bigint,
  document_invoicereference     bigint,
  fk_novatref                   bigint,
  fk_payment                    bigint,
  fk_shipping                   bigint,
  fk_srcdocument                bigint,
  message                       varchar(255),
  message2                      varchar(255),
  message3                      varchar(255),
  fk_contact                    bigint,
  constraint pk_fkt_document primary key (id)
);

create table fkt_documentitem (
  id                            bigint auto_increment not null,
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  gtin                          bigint,
  itemnumber                    varchar(255),
  itemrebate                    double,
  itemtype                      varchar(255),
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  novat                         tinyint(1) default 0,
  optional                      tinyint(1) default 0,
  posnr                         integer,
  price                         double,
  quantity                      double,
  quantityunit                  varchar(255),
  tara                          double,
  validfrom                     datetime(6),
  validto                       datetime(6),
  vestingperiodend              datetime(6),
  vestingperiodstart            datetime(6),
  weight                        double,
  fk_product                    bigint,
  fk_document                   bigint,
  description                   varchar(255),
  picture                       varbinary(255),
  fk_vat                        bigint,
  constraint pk_fkt_documentitem primary key (id)
);

create table fkt_userproperty (
  id                            bigint auto_increment not null,
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  t_user                        varchar(255),
  validfrom                     datetime(6),
  validto                       datetime(6),
  t_value                       varchar(255),
  constraint pk_fkt_userproperty primary key (id)
);

create table fkt_vat (
  id                            bigint auto_increment not null,
  dateadded                     datetime(6),
  deleted                       tinyint(1) default 0,
  description                   varchar(255),
  modified                      datetime(6),
  modifiedby                    varchar(255),
  name                          varchar(255),
  taxvalue                      double,
  validfrom                     datetime(6),
  validto                       datetime(6),
  fk_category                   bigint,
  constraint pk_fkt_vat primary key (id)
);

create table listaprecio (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  alias                         varchar(255),
  fecha_inicio                  datetime(6),
  fecha_termino                 datetime(6),
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_listaprecio primary key (id)
);

create table listapreciodetalle (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  alias                         varchar(255),
  precio                        double,
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_listapreciodetalle primary key (id)
);

create table parametro (
  ruc                           varchar(255) not null,
  codigo                        varchar(255) not null,
  codigo_padre                  varchar(255) not null,
  valor                         varchar(255),
  descripcion                   varchar(255),
  etiqueta                      varchar(255),
  orden                         integer not null,
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_parametro primary key (ruc,codigo,codigo_padre)
);

create table parametro_sistema (
  ruc                           varchar(255) not null,
  codigo                        varchar(255) not null,
  codigo_padre                  varchar(255) not null,
  valor                         varchar(255),
  descripcion                   varchar(255),
  etiqueta                      varchar(255),
  orden                         integer not null,
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_parametro_sistema primary key (ruc,codigo,codigo_padre)
);

create table producto (
  id                            bigint auto_increment not null,
  codigo                        varchar(255),
  nombre                        varchar(255),
  descripcion                   varchar(255),
  precio_venta                  double,
  precio_compra                 double,
  peso                          double,
  ruta_imagen                   varchar(255),
  codigo_barra                  varchar(255),
  cantidad_actual               double,
  cantidad_minima               double,
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_producto primary key (id)
);

create table secuencia (
  ruc                           varchar(255) not null,
  codigo                        varchar(255) not null,
  codigo_padre                  varchar(255) not null,
  valor                         varchar(255),
  secuencia                     bigint,
  orden                         integer not null,
  etiqueta                      varchar(255),
  descripcion                   varchar(255),
  usuario_creacion_registro     varchar(255),
  usuario_modificacion_registro varchar(255),
  fecha_creacion_registro       datetime(6),
  fecha_modificacion_registro   datetime(6),
  constraint pk_secuencia primary key (ruc,codigo,codigo_padre)
);

alter table contacto add constraint fk_contacto_direccion_id foreign key (direccion_id) references direccion (id) on delete restrict on update restrict;

alter table contacto add constraint fk_contacto_tipocontacto foreign key (tipocontacto_ruc,tipocontacto_codigo,tipocontacto_codigo_padre) references parametro (ruc,codigo,codigo_padre) on delete restrict on update restrict;
create index ix_contacto_tipocontacto on contacto (tipocontacto_ruc,tipocontacto_codigo,tipocontacto_codigo_padre);

alter table contacto add constraint fk_contacto_tipopersona foreign key (tipopersona_ruc,tipopersona_codigo,tipopersona_codigo_padre) references parametro (ruc,codigo,codigo_padre) on delete restrict on update restrict;
create index ix_contacto_tipopersona on contacto (tipopersona_ruc,tipopersona_codigo,tipopersona_codigo_padre);

alter table fkt_document add constraint fk_fkt_document_fk_contact foreign key (fk_contact) references fkt_contact (id) on delete restrict on update restrict;
create index ix_fkt_document_fk_contact on fkt_document (fk_contact);

alter table fkt_documentitem add constraint fk_fkt_documentitem_fk_vat foreign key (fk_vat) references fkt_vat (id) on delete restrict on update restrict;
create index ix_fkt_documentitem_fk_vat on fkt_documentitem (fk_vat);


# --- !Downs

alter table contacto drop foreign key fk_contacto_direccion_id;

alter table contacto drop foreign key fk_contacto_tipocontacto;
drop index ix_contacto_tipocontacto on contacto;

alter table contacto drop foreign key fk_contacto_tipopersona;
drop index ix_contacto_tipopersona on contacto;

alter table fkt_document drop foreign key fk_fkt_document_fk_contact;
drop index ix_fkt_document_fk_contact on fkt_document;

alter table fkt_documentitem drop foreign key fk_fkt_documentitem_fk_vat;
drop index ix_fkt_documentitem_fk_vat on fkt_documentitem;

drop table if exists txxxx_bandfact;

drop table if exists categoria;

drop table if exists contacto;

drop table if exists control_venta;

drop table if exists direccion;

drop table if exists documento;

drop table if exists fkt_address;

drop table if exists fkt_contact;

drop table if exists fkt_document;

drop table if exists fkt_documentitem;

drop table if exists fkt_userproperty;

drop table if exists fkt_vat;

drop table if exists listaprecio;

drop table if exists listapreciodetalle;

drop table if exists parametro;

drop table if exists parametro_sistema;

drop table if exists producto;

drop table if exists secuencia;

