START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `CALIBRATIONDIAGRAM`;

DROP TABLE IF EXISTS `CALIBRATIONDIAGRAM`;
CREATE TABLE IF NOT EXISTS `calibrationdiagram` (
  `IDDIAGRAM` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL,
PRIMARY KEY (`IDDIAGRAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='DIAGRAMME DE CALIBRAGE';
COMMIT;
SET foreign_key_checks = 1;
