-- phpMyAdmin SQL Dump
-- version 4.3.12
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 21 Mars 2015 à 16:09
-- Version du serveur :  5.5.32
-- Version de PHP :  5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `ticket`
--

-- --------------------------------------------------------

--
-- Structure de la table `possiblevaluesdetails`
--
START TRANSACTION;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `possiblevaluesdetails`;
CREATE TABLE IF NOT EXISTS `possiblevaluesdetails` (
  `IDMEASURE`               bigint(20) NULL ,
  `IDPOSSIBLEVALUE`         bigint(20) NULL ,
  `RAWRESULTS`              varchar(50) NULL,
  `POSSIBLEVALUENAME`       varchar(50) NULL,
  `DESCRIPTION`             varchar(50) NULL,
  `DEFAULTSTATUS`           smallint(6) NULL,
PRIMARY KEY (`IDMEASURE`,`IDPOSSIBLEVALUE`)
,KEY `FK_POSS_VAL_Det_POSS_VALUE` (`IDPOSSIBLEVALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

--
-- Index pour les tables exportées
--


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `possiblevaluesdetails`
--
START TRANSACTION;
ALTER TABLE `possiblevaluesdetails`
ADD CONSTRAINT `FK_POSS_VALDet_IDMEASURE` 
    FOREIGN KEY (`IDMEASURE`) 
    REFERENCES `measures` (`IDMEASURE`),

ADD CONSTRAINT `FK_POSS_VAL_Det_POSS_VALUE` 
    FOREIGN KEY (`IDPOSSIBLEVALUE`) 
    REFERENCES `possiblevalues` (`IDPOSSIBLEVALUE`);
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
SET foreign_key_checks = 0;
