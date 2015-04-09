START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `TRACE`;
CREATE TABLE IF NOT EXISTS `trace` (
  `IDTRACE`     bigint(20)  NULL AUTO_INCREMENT,
  `IDWO`        varchar(50) NULL,
  `IDCOMPANY`   varchar(50) NULL ,
  `TRACETYPE`   varchar(50) NULL,
  `QUANTITY`    varchar(50) NULL,
  `UNITS`       varchar(50) NULL,
  `IDARTICLE`   varchar(50) NULL,
  `BATCHNAME`   varchar(50) NULL,
  `DESCRIPTION` varchar(50) NULL,
`WAREHOUSE` varchar(50) NULL,
PRIMARY KEY (`IDTRACE`),
KEY `Key_Trace_IDWO` (`IDWO`),
KEY `Key_Trace_IDARTICLE` (`IDARTICLE`), 
KEY `Key_Trace_BATCHNAME` (`BATCHNAME`), 
KEY `Key_Trace_IDCOMPANY` (`IDCOMPANY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE `trace`
    ADD CONSTRAINT `FK_Trace_BATCHNAME` FOREIGN KEY           (`BATCHNAME`) 
                                  REFERENCES `batch`    (`BATCHNAME`);
COMMIT;

START TRANSACTION;
ALTER TABLE `trace`
    ADD CONSTRAINT `FK_Trace_ARTICLE` FOREIGN KEY             (`IDARTICLE`) 
                                        REFERENCES `article`    (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE `trace`
    ADD CONSTRAINT `FK_Trace_BATCH`   FOREIGN KEY         (`IDARTICLE`) 
                                        REFERENCES `batch`  (`IDARTICLE`);
COMMIT;

START TRANSACTION;
    ALTER TABLE `trace`
    ADD CONSTRAINT `FK_Trace_WO`  FOREIGN KEY     (`IDWO`) 
                            REFERENCES `wo` (`IDWO`);
COMMIT;

START TRANSACTION;
ALTER TABLE `trace` 
ADD CONSTRAINT `IDCOMPANY`  FOREIGN KEY         (`IDCOMPANY`) 
                            REFERENCES `company`(`IDCOMPANY`) 
                            ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
SET foreign_key_checks = 1;
