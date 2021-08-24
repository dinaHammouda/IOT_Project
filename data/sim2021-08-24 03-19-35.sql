Select id, operator_code, country, status from iot_shop.sim
USE iot_shop;

CREATE TABLE `sim` (
  `id` bigint(20) NOT NULL,
  `operator_code` int(11) DEFAULT NULL,
  `country` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_country_idx` (`country`),
  KEY `fk_status_idx` (`status`),
  CONSTRAINT `fk_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_status` FOREIGN KEY (`status`) REFERENCES `sim_status` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO iot_shop.sim(id,operator_code,country,status) VALUES (1,112,1,5);
