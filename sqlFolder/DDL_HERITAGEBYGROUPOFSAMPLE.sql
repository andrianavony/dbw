SET foreign_key_checks = 0;
START TRANSACTION;
DROP TABLE IF EXISTS `heritagebygroupofsample`;
CREATE TABLE IF NOT EXISTS `heritagebygroupofsample` (
  `IDGROUPOFSAMPLEPLANGROUP`        bigint(20) NULL,
  `IDMODELANALYSIS`                 bigint(20) NULL ,
  `DOWNUPBOTH`                      smallint(6) NULL,
  `HERITAGEBYGROUPOFSAMPLENAME`     varchar(50) NULL,  
  `DESCRIPTION`                     varchar(50) NULL,
PRIMARY KEY (
    `IDGROUPOFSAMPLEPLANGROUP`,
    `IDMODELANALYSIS`,
    `DOWNUPBOTH`
) COMMENT 'PK_HERITAGEBYGROUPOFSAMPLE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

START TRANSACTION;
ALTER TABLE                             `heritagebygroupofsample`
ADD CONSTRAINT `FK_HERITAGEBYGROUPOFSAMPLE_IDGROUPOFSAMPLEPLANGROUP` 
FOREIGN KEY                             (`IDGROUPOFSAMPLEPLANGROUP`) 
REFERENCES     `groupofsampleplangroup` (`IDGROUPOFSAMPLEPLANGROUP`);
COMMIT;

START TRANSACTION;
ALTER TABLE                             `heritagebygroupofsample`
ADD CONSTRAINT `FK_HERITAGEBYGROUPOFSAMPLE_IDMODELANALYSIS` 
FOREIGN KEY                             (`IDMODELANALYSIS`) 
REFERENCES     `modelanalysis`          (`IDMODELANALYSIS`);
COMMIT;


SET foreign_key_checks = 1;