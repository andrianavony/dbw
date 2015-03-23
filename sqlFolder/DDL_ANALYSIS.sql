START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `ANALYSIS`;
CREATE TABLE IF NOT EXISTS `ANALYSIS` (
  `IDANALYSIS` bigint(20) NULL AUTO_INCREMENT,
  `IDMODELANALYSIS` bigint(20) NULL,

  `IDMETHOD` bigint(20) NULL,
`IDMETHODDETAILS` bigint(20) NULL ,

`IDSPECIFICATION` bigint(20),

`IDSAMPLES` bigint(20) NULL,
`IDBATCH` bigint(20) NULL,
`BATCHNAME`       varchar(50) NULL,
`IDSTATUS` tinyint(1) NULL,

  `DESCRIPTION`     varchar(50) NULL,
 
  `ISVIRTUAL` tinyint(1) NULL,
  `ISFINAL` tinyint(1) NULL,
  `OCCURENCE` smallint(6) NULL,
  `OFFICIALENAME` varchar(50) NULL,
  `COUNTERANALYSIS` smallint(6) NULL,
  `STATUS` smallint(6) NULL,
  `APPORVED` smallint(6) NULL,
  `APPORVEDBY` varchar(50) NULL,
  `APPORVEDDATE` datetime NULL,
  `HERITED` tinyint(1) NULL,
  `IDMOTHERANALYSIS` bigint(20) NULL,
`CONSIDERED` tinyint(1) NULL,
`ANALYSISNAME` varchar(50) NULL,
`METHODNAME` varchar(50) NULL,
PRIMARY KEY (`IDANALYSIS`),
KEY `IDBATCH` (`IDBATCH`),
KEY `BATCHNAME` (`BATCHNAME`),
KEY `IDSAMPLES` (`IDSAMPLES`),
KEY `IDMOTHERANALYSIS` (`IDMOTHERANALYSIS`), 
KEY `IDSPECIFICATION` (`IDSPECIFICATION`),
KEY `IDMODELANALYSIS` (`IDMODELANALYSIS`),
KEY `IDMETHOD` (`IDMETHOD`),
KEY `IDMETHODDETAILS` (`IDMETHODDETAILS`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_ANALYSIS_IDANALYSIS_IDMOTHERANALYSIS` 
                                        FOREIGN KEY             (`IDMOTHERANALYSIS`) 
REFERENCES                                          `analysis`     (`IDANALYSIS`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_IDBATCH`             FOREIGN KEY                 (`IDBATCH`) 
REFERENCES                                          `batch`         (`IDBATCH`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE `analysis` ADD CONSTRAINT `FK_IDSAMPLES` FOREIGN KEY (`IDSAMPLES`) REFERENCES `samples`(`IDSAMPLES`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `analysis` ADD CONSTRAINT `FK_IDSPECIFICATION` FOREIGN KEY (`IDSPECIFICATION`) REFERENCES `specification`(`IDSPECIFICATION`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `ANALYSIS` ADD CONSTRAINT `FK_ANALYSIS_IDMOTHERANALYSIS` FOREIGN KEY (`IDMOTHERANALYSIS`) REFERENCES `analysis`(`IDANALYSIS`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `ANALYSIS` ADD CONSTRAINT `FK_ANALYSIS_IDMODELANALYSIS` FOREIGN KEY (`IDMODELANALYSIS`) REFERENCES `modelanalysis`(`IDMODELANALYSIS`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `ANALYSIS` ADD CONSTRAINT `FK_ANALYSIS_IDMETHOD` FOREIGN KEY (`IDMETHOD`) REFERENCES `METHOD`(`IDMETHOD`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

SET foreign_key_checks = 1;