START TRANSACTION;
DROP TABLE IF EXISTS `batch`;
CREATE TABLE IF NOT EXISTS `batch` (
  `IDBATCH`         varchar(50) NULL ,
  `IDARTICLE`       varchar(50) NULL,
  `IDSTAGE`         varchar(50) NULL,
  `IDSPECIE`        varchar(50) NULL,
  `IDVARIETY`       varchar(50) NULL,
  `IDGENERATION`    varchar(50) NULL,
  `PRODGROUP`       varchar(50) NULL,
  `IDPEA`           varchar(50) NULL,
  `ORIGIN1`         varchar(50) NULL,
  `ORIGIN2`         varchar(50) NULL,
  `IDDIAGRAM`       varchar(50) NULL,
  `IDCALIBER`       varchar(50) NULL,
  `IDWO`            varchar(50) NULL,
  `QUANTITY`        double DEFAULT NULL,
  `UNITS`           varchar(50) NULL,
  `BATCHNAME`        varchar(50) NULL,
  `IDBATCHLIMS`     bigint(20) NULL,
  `IDCOMPANY`        varchar(50) NULL,
  `CONTRACT`        varchar(50) NULL,
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

START TRANSACTION;
--
-- Index pour la table `batch`
--
ALTER TABLE `batch`
    ADD PRIMARY KEY (`IDBATCH`) COMMENT 'identifiant du lot',
    ADD KEY `IDITEM` (`IDARTICLE`), 
    ADD KEY `I_stade` (`IDSTAGE`) COMMENT 'pour faire la jointure avec Stade', 
    ADD KEY `I_BATCH_Species` (`IDSPECIE`) COMMENT 'I_BATCH_Species', 
    ADD KEY `I_BATCH_Variety` (`IDVARIETY`) COMMENT 'I_BATCH_Variety', 
    ADD KEY `I_BATCH_Genration` (`IDGENERATION`) COMMENT 'I_BATCH_Genration';
COMMIT;

START TRANSACTION;
    ALTER TABLE `batch`
        ADD CONSTRAINT `FK_BATCH_ARTICLE` FOREIGN KEY (`IDARTICLE`) REFERENCES `article` (`IDARTICLE`);
COMMIT;