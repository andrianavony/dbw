START TRANSACTION;
show engine innodb status;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `batch`;
CREATE TABLE IF NOT EXISTS `batch` (
  `IDBATCH`         bigint(20)  NULL AUTO_INCREMENT,
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
  `IDTRACE`          bigint(20)  NULL,
  `QUANTITY`        double      NULL,
  `UNITS`           varchar(50) NULL,
  `LIMSBATCHID`     bigint(20)  NULL,
  `IDCOMPANY`       varchar(50) NULL,
  `CONTRACT`        varchar(50) NULL,
  `PRODUCERNAME`    varchar(50) NULL,
  `IDTREATEMENT`    varchar(50) NULL,
  `LIMSFOLDERNO`    varchar(50) NULL,
PRIMARY KEY (`IDBATCH`) COMMENT 'identifiant du lot',
    KEY `Key_Batch_IDARTICLE`            (`IDARTICLE`), 
    KEY `Key_stade`           (`IDSTAGE`)         COMMENT 'pour faire la jointure avec Stade', 
    KEY `Key_BATCH_Species`   (`IDSPECIE`)        COMMENT 'I_BATCH_Species', 
    KEY `Key_BATCH_Variety`   (`IDVARIETY`)       COMMENT 'I_BATCH_Variety', 
    KEY `Key_BATCH_Genration` (`IDGENERATION`)    COMMENT 'I_BATCH_Genration',
    KEY `Key_BATCH_IDCOMPANY` (`IDCOMPANY`),
    KEY `Key_BATCH_IDWO` (`IDWO`),
    KEY `Key_BATCH_BATCHNAME` (`BATCHNAME`),
    KEY `Key_BATCH_IDTREATEMENT` (`IDTREATEMENT`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

START TRANSACTION;
    ALTER TABLE `batch`
        ADD CONSTRAINT `FK_BATCH_ARTICLE` 
            FOREIGN KEY             (`IDARTICLE`) 
            REFERENCES `article`    (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `batch`
    ADD CONSTRAINT `FK_batch_IDSPECIE` 
    FOREIGN KEY                                  (`IDSPECIE`) 
    REFERENCES                          `specie` (`IDSPECIE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


START TRANSACTION;
    ALTER TABLE                         `batch`
    ADD CONSTRAINT `FK_batch_IDVARIETY` 
    FOREIGN KEY                                     (`IDVARIETY`) 
    REFERENCES                          `variety`    (`IDVARIETY`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


START TRANSACTION;
    ALTER TABLE                         `batch`
    ADD CONSTRAINT `FK_batch_IDGENERATION` 
    FOREIGN KEY                                         (`IDGENERATION`) 
    REFERENCES                          `generation`    (`IDGENERATION`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `batch`
    ADD CONSTRAINT `FK_batch_IDSTAGE` 
    FOREIGN KEY                                     (`IDSTAGE`) 
    REFERENCES                          `stage` (`IDSTAGE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE `batch` 
        ADD CONSTRAINT `FK_BATCH_COMPANY` 
        FOREIGN KEY                 (`IDCOMPANY`) 
        REFERENCES     `company`    (`IDCOMPANY`) 
        ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE `batch`
    ADD CONSTRAINT `FK_BATCH_WO` 
    FOREIGN KEY                     (`IDWO`) 
    REFERENCES `wo`                 (`IDWO`)
    ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE `batch`
    ADD CONSTRAINT `FK_BATCH_TRACE` 
    FOREIGN KEY                        (`IDTRACE`) 
    REFERENCES `trace`                 (`IDTRACE`)
    ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


START TRANSACTION;
ALTER TABLE `batch` 
    ADD CONSTRAINT `FK_IDTREATEMENT` 
    FOREIGN KEY             (`IDTREATEMENT`) 
    REFERENCES `treatement` (`IDTREATEMENT`) 
    ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
SET foreign_key_checks = 1;