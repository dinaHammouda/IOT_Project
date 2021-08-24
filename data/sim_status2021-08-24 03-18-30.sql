Select id, status_key, status_value from iot_shop.sim_status
USE iot_shop;

CREATE TABLE `sim_status` (
  `id` int(11) NOT NULL,
  `status_key` varchar(255) DEFAULT NULL,
  `status_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO iot_shop.sim_status(id,status_key,status_value) VALUES (1,'active','Active');
INSERT INTO iot_shop.sim_status(id,status_key,status_value) VALUES (2,'waiting','Waiting For Activation');
INSERT INTO iot_shop.sim_status(id,status_key,status_value) VALUES (3,'blocked','Blocked ');
INSERT INTO iot_shop.sim_status(id,status_key,status_value) VALUES (4,'deactivated','Deactivated');
INSERT INTO iot_shop.sim_status(id,status_key,status_value) VALUES (5,'ready','Ready');
