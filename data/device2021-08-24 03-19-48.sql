Select id, temperature, device_status, sim_id from iot_shop.device
USE iot_shop;

CREATE TABLE `device` (
  `id` bigint(20) NOT NULL,
  `temperature` int(11) DEFAULT NULL,
  `device_status` int(11) DEFAULT NULL,
  `sim_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_device_status_idx` (`device_status`),
  KEY `fk_sim_idx` (`sim_id`),
  CONSTRAINT `FKgtwpndrkcut6pw7d8497rnuf` FOREIGN KEY (`device_status`) REFERENCES `device_status` (`id`),
  CONSTRAINT `fk_sim` FOREIGN KEY (`sim_id`) REFERENCES `sim` (`id`) ON DELETE NO ACTION ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO iot_shop.device(id,temperature,device_status,sim_id) VALUES (1,null,2,null);
INSERT INTO iot_shop.device(id,temperature,device_status,sim_id) VALUES (2,null,2,null);
INSERT INTO iot_shop.device(id,temperature,device_status,sim_id) VALUES (3,-30,1,1);
