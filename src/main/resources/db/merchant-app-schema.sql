create table merchant (
	
	id int PRIMARY KEY,
	create_date timestamp,
	name character varying(50),
	lastname character varying(50),
	birthdate date

);

create table product (
	
	id int PRIMARY KEY,
	create_date timestamp,
	label character varying(255),
	unit_price numeric,
	currency character varying(3),
	height numeric,
	weight numeric
);

create table merchant_product (
	
	merchant_id int NOT NULL,
	product_id int NOT NULL,
	create_date timestamp,
	PRIMARY KEY (merchant_id,product_id),
  	CONSTRAINT fk_merchant_product 
   	  FOREIGN KEY (merchant_id) 
   	  REFERENCES merchant (id),
  	CONSTRAINT fk_product_merchant  
   	  FOREIGN KEY (product_id) 
   	  REFERENCES product (id)
);


create table address (
	
	id int PRIMARY KEY,
	number int,
	street character varying(255),
	currency character varying(3),
	merchant_id int,
	CONSTRAINT fk_merchant_addess
      FOREIGN KEY(merchant_id) 
	  REFERENCES merchant(id)
);
