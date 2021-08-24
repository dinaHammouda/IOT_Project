Select id, code, name from iot_shop.country
USE iot_shop;

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO iot_shop.country(id,code,name) VALUES (1,'it','italy');
INSERT INTO iot_shop.country(id,code,name) VALUES (2,'uk','united kingdom');
INSERT INTO iot_shop.country(id,code,name) VALUES (3,'eg','Egypt');
