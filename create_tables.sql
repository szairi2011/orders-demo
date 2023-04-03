-- use this script to create the tables in MySQL DB
-- Don't use the SpringBoot auto-generated script, i.e. create.sql
create table invoices (id varchar(50) not null, order_id varchar(255), total_amount integer, primary key (id)) engine=MyISAM;
create table order_item (id varchar(50) not null, price float(53), product_name varchar(255), quantity integer, order_id varchar(50), primary key (id)) engine=MyISAM;
create table orders (id varchar(50) not null, order_status smallint, primary key (id)) engine=MyISAM;
alter table order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders (id);
