SET foreign_key_checks = 0;
START TRANSACTION;
DROP TABLE IF EXISTS `groupofsampleplangroup`;

CREATE TABLE IF NOT EXISTS `groupofsampleplangroup` (
  `IDGROUPOFSAMPLEPLANGROUP`                bigint(20) NULL AUTO_INCREMENT,
  `GROUPOFSAMPLEPLANGROUPNAME`              varchar(50) NULL,  
  `DESCRIPTION`                             varchar(50) NULL,
PRIMARY KEY (`IDGROUPOFSAMPLEPLANGROUP`) COMMENT 'PK_GROUPOFSAMPLEPLANGROUP'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;
SET foreign_key_checks = 1;
