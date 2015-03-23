START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `TRACE`;
CREATE TABLE IF NOT EXISTS `trace` (
  `IDTRACE`     bigint(20)  NULL AUTO_INCREMENT,
  `IDWO`        varchar(50) NULL,
  `IDCOMPANY`   varchar(50) NULL ,
  `TRACETYPE`   varchar(50) NULL,
  `QUANTITY`    double      NULL,
  `UNITS`       varchar(50) NULL,
  `IDARTICLE`   varchar(50) NULL,
  `BATCHNAME`   varchar(50) NULL,
  `DESCRIPTION` varchar(50) NULL,
`WAREHOUSE` varchar(50) NULL,
PRIMARY KEY (`IDTRACE`),
KEY `IDWO` (`IDWO`),
KEY `IDARTICLE` (`IDARTICLE`), 
KEY `BATCHNAME` (`BATCHNAME`), 
KEY `IDCOMPANY` (`IDCOMPANY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE `trace`
    ADD CONSTRAINT `FK_BATCHNAME` FOREIGN KEY           (`BATCHNAME`) 
                                  REFERENCES `batch`    (`BATCHNAME`);
COMMIT;

START TRANSACTION;
ALTER TABLE `trace`
    ADD CONSTRAINT `FK_ARTICLE_ARTICLE` FOREIGN KEY             (`IDARTICLE`) 
                                        REFERENCES `article`    (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE `trace`
    ADD CONSTRAINT `FK_ARTICLE_BATCH`   FOREIGN KEY         (`IDARTICLE`) 
                                        REFERENCES `batch`  (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE `trace`
    ADD CONSTRAINT `FK_WO`  FOREIGN KEY     (`IDWO`) 
                            REFERENCES `wo` (`IDWO`);
COMMIT;

START TRANSACTION;
ALTER TABLE `trace` 
ADD CONSTRAINT `IDCOMPANY`  FOREIGN KEY         (`IDCOMPANY`) 
                            REFERENCES `company`(`IDCOMPANY`) 
                            ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
SET foreign_key_checks = 1;
