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


# --- !Downs

drop table if exists txxxx_bandfact;

