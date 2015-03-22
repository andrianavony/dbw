
START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `SPECIFICATIONDETAILS` ;
CREATE TABLE IF NOT EXISTS `SPECIFICATIONDETAILS` (
  `IDSPECIFICATION` bigint(20) NULL,
  `IDMEASURE` bigint(20) NULL,
  
  `IDMETHOD` bigint(20)  NULL,
  `IDMETHODDETAILS` bigint(20) NULL ,
  
  `DESCRIPTION` varchar(50) NULL,
  `MINVALUE` bigint(20) NULL,
  `MAXVALUE` bigint(20) NULL,
`IDSTATUS` smallint(6) NULL,

PRIMARY KEY (`IDSPECIFICATION`,`IDMEASURE`),
KEY `IDMETHOD` (`IDMETHOD`),
KEY `IDMETHODDETAILS` (`IDMETHODDETAILS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;


START TRANSACTION;
ALTER TABLE `SPECIFICATIONDETAILS` 
    ADD CONSTRAINT `FK_SPECIFICATIONDETAILS_IDSPECIFICATION` 
    FOREIGN KEY (`IDSPECIFICATION`) 
    REFERENCES `SPECIFICATION`(`IDSPECIFICATION`) 
    ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;



START TRANSACTION;
ALTER TABLE `SPECIFICATIONDETAILS` 
ADD CONSTRAINT `FK_SPECIFICATIONDETAILS_IDMETHOD` 
FOREIGN KEY (`IDMETHOD`) REFERENCES `METHOD`(`IDMETHOD`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE `specificationdetails` 
ADD CONSTRAINT `FK_SPECIFICATIONDETAILS_IDMEASURE` 
FOREIGN KEY (`IDMEASURE`) REFERENCES `measures`(`IDMEASURE`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


SET foreign_key_checks = 1;
