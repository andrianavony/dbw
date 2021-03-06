
START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `RESULTSTEMP`;
CREATE TABLE IF NOT EXISTS `RESULTSTEMP` (
 `IDRESULT` bigint(20) NULL AUTO_INCREMENT,
`IDMEASURE` bigint(20) NULL ,
`LIMSMEASUREID` bigint(20) NULL ,
 `LIMSID` bigint(20) NULL ,
`LIMSIDSERIES` bigint(20) NULL ,
`IDSERIES`       bigint(20) NULL ,
`LIMSSAMPLEID`       varchar(50) NULL,
  `IDANALYSIS` bigint(20) NULL ,
  `IDMODELANALYSIS` bigint(20) NULL,
`LIMSIDANALYSIS` bigint(20) NULL ,
`LIMSIDMETHOD`  varchar(50) NULL,
  `IDMETHOD` bigint(20) NULL,
`IDMETHODDETAILS` bigint(20) NULL ,

`IDSPECIFICATION` bigint(20),

`IDSAMPLES` bigint(20) NULL,
`IDCASEFILE`    bigint(20)              NULL,
`IDBATCH` bigint(20) NULL,
`LIMSBATCHID` bigint(20) NULL,
`LIMSFOLDERNO`       varchar(50) NULL,
`BATCHNAME`       varchar(50) NULL,
`IDSTATUS` tinyint(1) NULL,
`STATUSLABEL`       varchar(50) NULL,
`IDAPPROBATIONSTATUS` tinyint(1) NULL,
`APPROBATIONSTATUSLABEL`       varchar(50) NULL,

`ANALYSISIDSTATUS` tinyint(1) NULL,
`ANALYSISSTATUSLABEL`       varchar(50) NULL,
`ANALYSISIDAPPROBATIONSTATUS` tinyint(1) NULL,
`ANALYSISAPPROBATIONSTATUSLABEL`       varchar(50) NULL,

  `DESCRIPTION`     varchar(50) NULL,
 
  `ISVIRTUAL` tinyint(1) NULL,
  `ISFINAL` tinyint(1) NULL,
  `ISRESULTS` tinyint(1) NULL,
  `ISREQUIRED` tinyint(1) NULL,
  `OCCURENCE` smallint(6) NULL,
  `COUNTERANALYSIS` smallint(6) NULL,
  `COUNTERANALYSISIDLIMS`  varchar(50) NULL,
  `OFFICIALENAME` varchar(50) NULL,
  `MAINGROUP` varchar(50) NULL,
  `SUBGROUP` varchar(50) NULL,
  `MEASUREMASTER` varchar(50) NULL,
  `MEASUREDETAILS` varchar(50) NULL,
  `REPETITION` smallint(6) NULL,
  `SUBREPETITION` smallint(6) NULL,
  `RAWRESULTS` varchar(50) NULL,
  `FORMATED` varchar(50) NULL,
  `APPORVED` tinyint(1) NULL,
  `APPORVEDDATE` datetime NULL,
  `APPORVEDBY` varchar(50) NULL,
  `DATEOFENTRY` datetime NULL,
  `IDUSER` bigint(20) NULL,
  `USERNAME` varchar(50) NULL,
  `HERITED` tinyint(1) NULL,
`MEASURENAME` varchar(50) NULL,
`ANALYSISNAME` varchar(50) NULL,
`METHODNAME` varchar(50) NULL,
`COPIEDFROM` varchar(50) NULL,
 `ISRESULTSINSERTED` tinyint(1) NULL DEFAULT 1,
`LIMSANALYSISORIGREC` bigint(20) NULL ,

PRIMARY KEY (`IDRESULT`), 
KEY `IDBATCH` (`IDBATCH`),
KEY `BATCHNAME` (`BATCHNAME`),
KEY `IDSAMPLES` (`IDSAMPLES`),

KEY `IDSPECIFICATION` (`IDSPECIFICATION`),
KEY `IDANALYSIS` (`IDANALYSIS` ),
KEY `IDMODELANALYSIS` (`IDMODELANALYSIS`),
KEY `IDMETHOD` (`IDMETHOD`),
KEY `IDMETHODDETAILS` (`IDMETHODDETAILS`),
KEY `KEY_RESULTS_IDMEASURE`  (`IDMEASURE` ),
KEY `IDUSER`  (`IDUSER` )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

COMMIT;

