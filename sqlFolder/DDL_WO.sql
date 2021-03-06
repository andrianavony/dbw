START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `wo`;
CREATE TABLE IF NOT EXISTS `wo` (
  `IDWO`            varchar(50) NULL ,
  `IDCOMPANY`       varchar(50) NULL ,
  `IDDIAGRAM`       varchar(50) NULL,
  `DESCRIPTION`     varchar(50) NULL,
PRIMARY KEY (`IDWO`,`IDCOMPANY`), 
KEY `IDDIAGRAM` (`IDDIAGRAM`), 
KEY `FK_COMPANY` (`IDCOMPANY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
ALTER TABLE `wo`
ADD CONSTRAINT `FK_IDDIAGRAM`   FOREIGN KEY                     (`IDDIAGRAM`) 
                                REFERENCES `calibrationdiagram` (`IDDIAGRAM`);

COMMIT;
START TRANSACTION;
ALTER TABLE `wo`
    ADD CONSTRAINT `FK_COMPANY` FOREIGN KEY             (`IDCOMPANY`) 
                                REFERENCES `company`    (`IDCOMPANY`);
COMMIT;



SET foreign_key_checks = 1;
