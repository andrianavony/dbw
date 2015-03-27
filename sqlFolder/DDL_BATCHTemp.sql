START TRANSACTION;
show engine innodb status;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `batchtemp`;
CREATE TABLE IF NOT EXISTS `batchtemp` (
  `IDBATCH`         bigint(20)  NULL ,
  `BATCHNAME`       varchar(50) NULL,
  `DESCRIPTION`     varchar(50) NULL,
  `IDARTICLE`       varchar(50) NULL,
  `IDSTAGE`         varchar(50) NULL,
  `IDSPECIE`        varchar(50) NULL,
  `IDVARIETY`       varchar(50) NULL,
  `IDGENERATION`    varchar(50) NULL,
  `PRODGROUP`       varchar(50) NULL,
  `IDPEA`           varchar(50) NULL,
  `ORIGIN1`         varchar(50) NULL,
  `ORIGIN2`         varchar(50) NULL,
  `IDDIAGRAM`       varchar(50) NULL,
  `IDCALIBER`       varchar(50) NULL,
  `IDWO`            varchar(50) NULL,
  `QUANTITY`        double      NULL,
  `UNITS`           varchar(50) NULL,
  `LIMSBATCHID`     bigint(20)  NULL,
  `IDCOMPANY`       varchar(50) NULL,
  `CONTRACT`        varchar(50) NULL,
  `IDTREATEMENT`    varchar(50) NULL,
  `LIMSFOLDERNO`    varchar(50) NULL,
 `NUMDEMANDELIMS`   smallint(6) NULL,
PRIMARY KEY (`IDBATCH`) COMMENT 'identifiant du lot'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

SET foreign_key_checks = 1;