CREATE DATABASE 'vehicle_rent';
USE vehicle_rent;

create table customer_res (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	number varchar(20) NOT NULL,
	type varchar(120) NOT NULL,
	Address varchar(500) NOT NULL,
	sdate varchar(20) NOT NULL,
	edate varchar(20) NOT NULL,
	PRIMARY KEY (id)
);

