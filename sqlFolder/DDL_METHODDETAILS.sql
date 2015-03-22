START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `METHODDETAILS`;
CREATE TABLE IF NOT EXISTS `METHODDETAILS` (
  `IDMETHODDETAILS` bigint(20) NULL AUTO_INCREMENT,
  `IDMETHOD` bigint(20) NULL,
  `DESCRIPTION` varchar(50) NULL,
  `DELETED` tinyint(1) NULL,
  `MAINGROUP` varchar(50) NULL,
  `SUBGROUP` varchar(50) NULL,
  `IDSUBMETHOD` bigint(20) NULL,
  `IDMODELANALYSIS` bigint(20) NULL,
  `MEASUREMASTER` varchar(50) NULL,
  `IDMEASURE` bigint(20) NULL,
  `ISRESULTS` tinyint(1) NULL,
  `ISREQUIRED` tinyint(1) NULL,
  `DEFAULTVALUE` varchar(50) NULL,
  `IDPOSSIBLEVALUE` bigint(20) NULL,
  `ISVIRTUAL` tinyint(1) NULL,
  `MEASUREVALUE` varchar(50) NULL,
  `VALUEMIN` varchar(50) NULL,
  `VALUEMAX` varchar(50) NULL,
  `VALID` tinyint(1) NULL,
  `REPETITION` smallint(6) NULL,
  `SUBREPETITION` smallint(6) NULL,
  PRIMARY KEY (`IDMETHODDETAILS`,`IDMETHOD`),
	KEY `IDSUBMETHOD` (`IDSUBMETHOD`), 
	KEY `IDMODELANALYSIS` (IDMODELANALYSIS),
	KEY `IDMEASURE` (`IDMEASURE`),
        KEY `FK_IDPOSSIBLEVALUEMEASURES` (`IDPOSSIBLEVALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE `methoddetails` 
ADD CONSTRAINT `FK_IDMETHOD` FOREIGN KEY (`IDMETHOD`) 
REFERENCES `method`(`IDMETHOD`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `methoddetails` ADD CONSTRAINT `FK_IDSUBMETHOD` 
FOREIGN KEY (`IDSUBMETHOD`) REFERENCES `method`(`IDMETHOD`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `methoddetails` ADD CONSTRAINT `FK_IDMEASURES` 
FOREIGN KEY (`IDMEASURE`) REFERENCES `measures`(`IDMEASURE`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `methoddetails` 
ADD CONSTRAINT `FK_methoddetails_IDPOSSIBLEVALUEMEASURES` 
FOREIGN KEY (`IDPOSSIBLEVALUE`) REFERENCES `POSSIBLEVALUES` (`IDPOSSIBLEVALUE`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

SET foreign_key_checks = 1;