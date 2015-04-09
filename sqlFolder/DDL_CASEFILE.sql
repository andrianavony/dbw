
START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `casefile`;

CREATE TABLE IF NOT EXISTS `casefile` (
  `IDCASEFILE`      bigint(20)  NULL AUTO_INCREMENT,
  `ISCURRENT` tinyint(1) NULL,  
  `IDARTICLE`       varchar(50) NULL,
  `BATCHNAME`       varchar(50) NULL,
  `CREATIONDATE`  datetime NULL,
  `STATUSLABEL`       varchar(50) NULL,
  `APPROBATIONSTATUSLABEL`       varchar(50) NULL,
  `APPORVED` smallint(6) NULL,
  `APPORVEDBY` varchar(50) NULL,
  `APPORVEDDATE` datetime NULL,

  `PRODGROUP`       varchar(50) NULL,
  `CASEFILETYPE`       varchar(50) NULL            COMMENT 'PROCESS, REPORT, RETOUR',
  `DESCRIPTION`     varchar(50) NULL,
  `LIMSFOLDERNO`       varchar(50) NULL,
  `IDBATCH`         bigint(20)  NULL,
  `IDSPECIE`        varchar(50) NULL,
  `IDSTAGE`         varchar(50) NULL,
  
  `LIMSBATCHID` bigint(20) NULL,
  
  `IDSTATUS` tinyint(1) NULL,
  `IDAPPROBATIONSTATUS` tinyint(1) NULL,
  NUMDEMANDELIMS smallint(6) DEFAULT NULL,

  
PRIMARY KEY (`IDCASEFILE`) COMMENT 'PK_CASEFILE_IDCASEFILE'
,KEY `KEY_CASEFILE_IDARTICLE`            (`IDARTICLE`)
,KEY `KEY_CASEFILE_Species`   (`IDSPECIE`)        COMMENT 'KEY_CASEFILE_Species'
,KEY `KEY_CASEFILE_IDBATCH` (`IDBATCH`) COMMENT 'KEY_CASEFILE_IDBATCH'
,KEY `KEY_CASEFILE_LIMSFOLDERNO` (`LIMSFOLDERNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;


START TRANSACTION;
ALTER TABLE `casefile`
ADD CONSTRAINT `FK_CASEFILE__IDBATCH` FOREIGN KEY (`IDBATCH`) REFERENCES `batch` (`IDBATCH`);
COMMIT;

START TRANSACTION;
    ALTER TABLE `casefile`
        ADD CONSTRAINT `FK_casefile_ARTICLE` 
            FOREIGN KEY             (`IDARTICLE`) 
            REFERENCES `article`    (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `casefile`
    ADD CONSTRAINT `FK_casefile_IDSPECIE` 
    FOREIGN KEY                                  (`IDSPECIE`) 
    REFERENCES                          `specie` (`IDSPECIE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `casefile`
    ADD CONSTRAINT `FK_casefile_IDSTAGE` 
    FOREIGN KEY                                     (`IDSTAGE`) 
    REFERENCES                          `stage` (`IDSTAGE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
SET foreign_key_checks = 1;