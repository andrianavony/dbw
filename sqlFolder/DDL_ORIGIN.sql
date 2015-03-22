SET foreign_key_checks = 0;
START TRANSACTION;
DROP TABLE IF EXISTS `origin`;
CREATE TABLE IF NOT EXISTS `origin` (
  `IDORIGIN`        bigint(20) NULL  AUTO_INCREMENT,
  `ORIGINNAME`     varchar(50) NULL,
  `ORIGINCODE`     varchar(50) NULL,  
  `DESCRIPTION`    varchar(50) NULL,
PRIMARY KEY (
    `IDORIGIN`
) COMMENT 'PK_ORIGIN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;


SET foreign_key_checks = 1;

