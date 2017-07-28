drop table if exists company;

create table company (id bigint auto_increment, name varchar(255) not null,website varchar(255) null, constraint id unique (id));

INSERT INTO company(name, website) VALUES ('Vaadin', 'vaadin.com');
INSERT INTO company(name, website) VALUES ('Red Hat', 'redhat.com');
INSERT INTO company(name, website) VALUES ('Canonical', 'canonical.com');
INSERT INTO company(name, website) VALUES ('Sonatype', 'sonatype.com');
INSERT INTO company(name, website) VALUES ('Alfresco', 'alfresco.com');