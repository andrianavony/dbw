START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `variety`;
CREATE TABLE IF NOT EXISTS variety (
    IDVARIETY       VARCHAR(50) NULL ,
    IDSPECIE        VARCHAR(50) NULL ,
    `DESCRIPTION`     varchar(50) NULL,
    `VARIETYNAME`     varchar(50) NULL,
    `OFFICIALNAME`     varchar(50) NULL,
PRIMARY KEY (IDVARIETY, IDSPECIE)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

START TRANSACTION;
    ALTER TABLE                          `variety`
    ADD CONSTRAINT `FK_variety_IDSPECIE` 
    FOREIGN KEY                                      (`IDSPECIE`) 
    REFERENCES                              `specie` (`IDSPECIE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


SET foreign_key_checks = 1;
