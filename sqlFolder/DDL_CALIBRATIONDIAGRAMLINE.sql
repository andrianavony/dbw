START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `calibrationdiagramline`;
CREATE TABLE IF NOT EXISTS `calibrationdiagramline` (
  `IDDIAGRAM`       varchar(50)     NULL,
  `IDCALIBER`       varchar(50)     NULL,
  `QUANTITY`        double          NULL,
  `UNITS`           varchar(50)     NULL,
  `DESCRIPTION`     varchar(50)     NULL,
PRIMARY KEY (`IDDIAGRAM`,`IDCALIBER`),
KEY `FK_CALIBER` (`IDCALIBER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

START TRANSACTION;
    ALTER TABLE `calibrationdiagramline`
        ADD CONSTRAINT `FK_CALIBER` FOREIGN KEY             (`IDCALIBER`) 
                                    REFERENCES `caliber`    (`IDCALIBER`);

COMMIT;
SET foreign_key_checks = 1;
