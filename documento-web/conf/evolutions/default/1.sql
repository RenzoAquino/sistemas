# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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

alter table fkt_document add constraint fk_fkt_document_fk_contact foreign key (fk_contact) references fkt_contact (id) on delete restrict on update restrict;
create index ix_fkt_document_fk_contact on fkt_document (fk_contact);

alter table fkt_documentitem add constraint fk_fkt_documentitem_fk_vat foreign key (fk_vat) references fkt_vat (id) on delete restrict on update restrict;
create index ix_fkt_documentitem_fk_vat on fkt_documentitem (fk_vat);


# --- !Downs

alter table fkt_document drop foreign key fk_fkt_document_fk_contact;
drop index ix_fkt_document_fk_contact on fkt_document;

alter table fkt_documentitem drop foreign key fk_fkt_documentitem_fk_vat;
drop index ix_fkt_documentitem_fk_vat on fkt_documentitem;

drop table if exists documento;

drop table if exists fkt_address;

drop table if exists fkt_contact;

drop table if exists fkt_document;

drop table if exists fkt_documentitem;

drop table if exists fkt_userproperty;

drop table if exists fkt_vat;

