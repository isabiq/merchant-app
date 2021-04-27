INSERT INTO merchant
(id, create_date, name, lastname, birthdate)
values
(1,'2020-04-1','Dorian','Choi', '1990-05-1');
INSERT INTO merchant
(id, create_date, name, lastname, birthdate)
values
(2,'2020-04-2','Maisey','Michael','1985-05-2');
INSERT INTO merchant
(id, create_date, name, lastname, birthdate)
values
(3,'2020-04-3','Luca','Rowe','1970-05-3');


INSERT INTO product
(id, create_date, label, unit_price, currency, height, weight)
values
(1, '2020-04-4', 'phone', 200, 'EUR', 20, 30);

INSERT INTO product
(id, create_date, label, unit_price, currency, height, weight)
values
(2, '2020-04-5', 'tv', 500, 'EUR', 50, 50);

INSERT INTO product
(id, create_date, label, unit_price, currency, height, weight)
values
(3, '2020-05-5', 'book', 30, 'EUR', 50, 50);

INSERT INTO merchant_product
(merchant_id, product_id)
values
(1, 1);