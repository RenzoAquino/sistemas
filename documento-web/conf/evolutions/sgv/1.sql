# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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


# --- !Downs

alter table contacto drop foreign key fk_contacto_direccion_id;

alter table contacto drop foreign key fk_contacto_tipocontacto;
drop index ix_contacto_tipocontacto on contacto;

alter table contacto drop foreign key fk_contacto_tipopersona;
drop index ix_contacto_tipopersona on contacto;

drop table if exists categoria;

drop table if exists contacto;

drop table if exists control_venta;

drop table if exists direccion;

drop table if exists listaprecio;

drop table if exists listapreciodetalle;

drop table if exists parametro;

drop table if exists parametro_sistema;

drop table if exists producto;

drop table if exists secuencia;

