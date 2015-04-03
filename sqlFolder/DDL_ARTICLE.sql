SET foreign_key_checks = 0;
START TRANSACTION;
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `IDARTICLE`       varchar(50) NULL,
  `IDSPECIE`        varchar(50) NULL,
  `IDVARIETY`       varchar(50) NULL,
  `IDGENERATION`    varchar(50) NULL,
  `IDSTAGE`         varchar(50) NULL,
  `DESCRIPTION`     varchar(50) NULL,
  `ARTICLENAME`     varchar(50) NULL,
  `OFFICIALNAME`     varchar(50) NULL,
PRIMARY KEY (`IDARTICLE`)
,KEY `KEY_article_IDVARIETY` (`IDVARIETY`)
,KEY `KEY_article_IDSTAGE` (`IDSTAGE`)
,KEY `KEY_article_IDSPECIE` (`IDSPECIE`)
,KEY `KEY_article_IDGENERATION` (`IDGENERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;



START TRANSACTION;
    ALTER TABLE                         `article`
    ADD CONSTRAINT `FK_article_IDSPECIE` 
    FOREIGN KEY                                  (`IDSPECIE`) 
    REFERENCES                          `specie` (`IDSPECIE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


START TRANSACTION;
    ALTER TABLE                         `article`
    ADD CONSTRAINT `FK_article_IDVARIETY` 
    FOREIGN KEY                                     (`IDVARIETY`) 
    REFERENCES                          `variety`    (`IDVARIETY`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


START TRANSACTION;
    ALTER TABLE                         `article`
    ADD CONSTRAINT `FK_article_IDGENERATION` 
    FOREIGN KEY                                         (`IDGENERATION`) 
    REFERENCES                          `generation`    (`IDGENERATION`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

START TRANSACTION;
    ALTER TABLE                         `article`
    ADD CONSTRAINT `FK_article_IDSTAGE` 
    FOREIGN KEY                                     (`IDSTAGE`) 
    REFERENCES                          `stage` (`IDSTAGE`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;


SET foreign_key_checks = 1;

