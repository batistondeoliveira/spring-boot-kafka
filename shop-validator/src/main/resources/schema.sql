create schema if not exists shop;

create table shop.product (
  id bigserial primary key auto_increment,
  product_identifier varchar(100) not null,
  amount int not null
);