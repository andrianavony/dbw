START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `POSSIBLEVALUES`;
CREATE TABLE IF NOT EXISTS `POSSIBLEVALUES` (
  `IDPOSSIBLEVALUE` bigint(20) NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(50) NULL,
PRIMARY KEY (`IDPOSSIBLEVALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;


SET foreign_key_checks = 1;