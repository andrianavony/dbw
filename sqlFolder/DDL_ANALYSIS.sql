START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `ANALYSIS`;
CREATE TABLE IF NOT EXISTS `ANALYSIS` (
`HERITED` tinyint(1) NULL,
`IDARTICLE`     varchar(50)             NULL,
`BATCHNAME`       varchar(50) NULL,
`LIMSSAMPLEID`       varchar(50) NULL,
`LIMSIDANALYSIS` bigint(20) NULL,
`ANALYSISNAME` varchar(50) NULL,
`METHODNAME` varchar(50) NULL,
`LIMSIDSERIES` bigint(20) NULL ,
`IDSERIES`       bigint(20) NULL ,

    `CREATIONDATE`  datetime NULL,
    `STATUSLABEL`       varchar(50) NULL,

    `APPROBATIONSTATUSLABEL`       varchar(50) NULL,
    `APPORVED` smallint(6) NULL,
    `APPORVEDBY` varchar(50) NULL,
    `APPORVEDDATE` datetime NULL,

`LIMSCOUNTERANALYSISSAMPELID` varchar(50) NULL,
`COUNTERANALYSIS` smallint(6) NULL,

`IDBATCH` bigint(20) NULL,
`IDCASEFILE`    bigint(20)              NULL,
`IDSAMPLES` bigint(20) NULL,

`LIMSID` bigint(20) NULL ,
`LIMSBATCHID` bigint(20) NULL,
`LIMSFOLDERNO`       varchar(50) NULL,



`IDMETHOD` bigint(20) NULL,
`IDMETHODDETAILS` bigint(20) NULL ,
`IDSPECIFICATION` bigint(20),

`IDANALYSIS` bigint(20) NULL AUTO_INCREMENT,
`IDMODELANALYSIS` bigint(20) NULL,

`IDSTATUS` tinyint(1) NULL,
`IDAPPROBATIONSTATUS` tinyint(1) NULL,


  `DESCRIPTION`     varchar(50) NULL,
 
  `ISVIRTUAL` tinyint(1) NULL  COMMENT 'Analyses pas réélement faite mais calculés.',
  `ISFINAL` tinyint(1) NULL COMMENT 'Analyses dont les resultats seront les résultats finaux .',
  `OCCURENCE` smallint(6) NULL,
  `OFFICIALENAME` varchar(50) NULL,


  
  `IDMOTHERANALYSIS` bigint(20) NULL,
`CONSIDERED` tinyint(1) NULL COMMENT 'Les résultats seront utililisé pour les calcul des analyses virtuelle',
      `PRODGROUP`       varchar(50) NULL,
      `IDSPECIE`        varchar(50) NULL,
      `IDSTAGE`         varchar(50) NULL,
    `COPIEDFROMIDANALYSIS`         bigint(20) NULL,
    `COPIEDFROMIDSAMPLE`         bigint(20) NULL,
    `COPIEDFROMLIMSBATHCNAME`         varchar(50) NULL,
    `COPIEDFROMIDBATCH`         bigint(20) NULL,
 `ISRESULTSINSERTED` tinyint(1) NULL DEFAULT 0,
`LIMSANALYSISORIGREC` bigint(20) NULL ,
`COPYSTATUS` INT NULL DEFAULT 1 COMMENT 'Si 1 alors heritage a faire',
`COPYTYPE` VARCHAR(50) NULL COMMENT 'Heritage ou regroupement' ,
PRIMARY KEY (`IDANALYSIS`),
KEY `KEY_ANALYSIS_IDBATCH` (`IDBATCH`),
KEY `KEY_ANALYSIS_BATCHNAME` (`BATCHNAME`),
KEY `KEY_ANALYSIS_IDSAMPLES` (`IDSAMPLES`),
KEY `KEY_ANALYSIS_IDMOTHERANALYSIS` (`IDMOTHERANALYSIS`), 
KEY `KEY_ANALYSIS_IDSPECIFICATION` (`IDSPECIFICATION`),
KEY `KEY_ANALYSIS_IDMODELANALYSIS` (`IDMODELANALYSIS`),
KEY `KEY_ANALYSIS_IDMETHOD` (`IDMETHOD`),
KEY `KEY_ANALYSIS_IDMETHODDETAILS` (`IDMETHODDETAILS`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_ANALYSIS_COPIEDFROMIDSAMPLE` 
                                        FOREIGN KEY             (`COPIEDFROMIDSAMPLE`) 
 REFERENCES `samples`(`IDSAMPLES`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_ANALYSIS_COPIEDFROMIDANALISIS` 
                                        FOREIGN KEY             (`COPIEDFROMIDANALYSIS`) 
REFERENCES                                          `analysis`     (`IDANALYSIS`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_analysis_COPIEDFROMIDBATCH`             FOREIGN KEY                 (`COPIEDFROMIDBATCH`) 
REFERENCES                                          `batch`         (`IDBATCH`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_ANALYSIS_IDANALYSIS_IDMOTHERANALYSIS` 
                                        FOREIGN KEY             (`IDMOTHERANALYSIS`) 
REFERENCES                                          `analysis`     (`IDANALYSIS`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;

START TRANSACTION;
ALTER TABLE                                         `analysis` 
ADD CONSTRAINT `FK_analysis_IDBATCH`             FOREIGN KEY                 (`IDBATCH`) 
REFERENCES                                          `batch`         (`IDBATCH`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;

START TRANSACTION;
ALTER TABLE `analysis` 
ADD CONSTRAINT `FK_analysis_IDCASEFILE` 
FOREIGN KEY (`IDCASEFILE`) 
    REFERENCES `CASEFILE`(`IDCASEFILE`) 
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;





START TRANSACTION;
    ALTER TABLE `analysis`
        ADD CONSTRAINT `FK_analysis_IDARTICLE` 
            FOREIGN KEY             (`IDARTICLE`) 
            REFERENCES `article`    (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `analysis`
    ADD CONSTRAINT `FK_analysis_IDSPECIE` 
    FOREIGN KEY                                  (`IDSPECIE`) 
    REFERENCES                          `specie` (`IDSPECIE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `analysis`
    ADD CONSTRAINT `FK_analysis_IDSTAGE` 
    FOREIGN KEY                                     (`IDSTAGE`) 
    REFERENCES                          `stage` (`IDSTAGE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

ALTER TABLE `analysis` ADD CONSTRAINT `FK_ANALYSIS_IDSAMPLES` FOREIGN KEY (`IDSAMPLES`) REFERENCES `samples`(`IDSAMPLES`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `analysis` ADD CONSTRAINT `FK_ANALYSIS_IDSPECIFICATION` FOREIGN KEY (`IDSPECIFICATION`) REFERENCES `specification`(`IDSPECIFICATION`) ON DELETE RESTRICT ON UPDATE RESTRICT;
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