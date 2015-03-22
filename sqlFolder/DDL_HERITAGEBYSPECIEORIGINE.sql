SET foreign_key_checks = 0;
START TRANSACTION;
DROP TABLE IF EXISTS `heritagebyspecieorigin`;
CREATE TABLE IF NOT EXISTS `heritagebyspecieorigin` (
  `IDSPECIE`                        varchar(50) NULL,
  `IDORIGIN`                        bigint(20) NULL,
  `IDMODELANALYSIS`                 bigint(20) NULL ,
  `DOWNUPBOTH`                      smallint(6) NULL,
  `HERITAGEBYSPECIEORIGINNAME`      varchar(50) NULL,  
  `DESCRIPTION`                     varchar(50) NULL,
PRIMARY KEY (
    `IDSPECIE`,
    `IDORIGIN`,
    `IDMODELANALYSIS`,
    `DOWNUPBOTH`
) COMMENT 'PK_HERITAGEBYSPECIEORIGIN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;


START TRANSACTION;
ALTER TABLE                `heritagebyspecieorigin`
ADD CONSTRAINT `FK_HERITAGEBYSPECIEORIGINE_IDSPECIE` 
FOREIGN KEY                             (`IDSPECIE`) 
REFERENCES     `specie`                 (`IDSPECIE`);
COMMIT;

START TRANSACTION;
ALTER TABLE                             `heritagebyspecieorigin`
ADD CONSTRAINT `FK_FK_HERITAGEBYSPECIEORIGINE_IDORIGIN` 
FOREIGN KEY                             (`IDORIGIN`) 
REFERENCES     `origin` (`IDORIGIN`);
COMMIT;

START TRANSACTION;
ALTER TABLE                             `heritagebyspecieorigin`
ADD CONSTRAINT `FK_HERITAGEBYSPECIEORIGINE_IDMODELANALYSIS` 
FOREIGN KEY                             (`IDMODELANALYSIS`) 
REFERENCES     `modelanalysis`          (`IDMODELANALYSIS`);
COMMIT;


SET foreign_key_checks = 1;
