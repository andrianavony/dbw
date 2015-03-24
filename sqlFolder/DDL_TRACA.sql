START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `traca`;
CREATE TABLE IF NOT EXISTS `traca` (
  `IDCOMPANY`   varchar(50) NULL ,
  `WAREHOUSE` varchar(50) NULL,
  `IDWO`        varchar(50) NULL,
  `TRACETYPE`   varchar(50) NULL,
  `MGRQUANTITY` varchar(50) NULL,
  `MGVQUANTITY` varchar(50) NULL,
  `KGQUANTITY` varchar(50) NULL,
  `UNITS`       varchar(50) NULL,
  `IDARTICLE`   varchar(50) NULL,
  `BATCHNAME`   varchar(50) NULL,
  `YEAR`   varchar(50) NULL,
  `BASSIN`   varchar(50) NULL,
  `PRODUCTEUR` varchar(50) NULL,
`CONTRAT` varchar(50) NULL,
`STATUSTRACA` smallint(6) NULL,
`IDTRACA`     bigint(20)  NULL AUTO_INCREMENT,
PRIMARY KEY (`IDTRACA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

SET foreign_key_checks = 1;
