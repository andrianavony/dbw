SELECT IDTRACA, BASSIN, BATCHNAME, CONTRAT, IDARTICLE, IDCOMPANY, KGQUANTITY, MGRQUANTITY, MGVQUANTITY, PRODUCTEUR, STATUSTRACA, TRACETYPE, UNITS, WAREHOUSE, YEAR, IDWO FROM TRACA 
WHERE ((((IDCOMPANY = 'LNS') AND (IDWO = 'OP1101385')) AND (IDCOMPANY = 'LNS')) AND (TRACETYPE = 'Production'));

SELECT IDTRACA, BASSIN, BATCHNAME, CONTRAT, IDARTICLE, IDCOMPANY, KGQUANTITY, MGRQUANTITY, MGVQUANTITY, PRODUCTEUR, STATUSTRACA, TRACETYPE, UNITS, WAREHOUSE, YEAR, IDWO FROM TRACA 
WHERE IDTRACA='1649';


SELECT * FROM results WHERE `IDBATCH` =2894

--SELECT t0.IDTRACA, t0.BASSIN, t0.BATCHNAME, t0.CONTRAT, t0.IDARTICLE, t0.IDCOMPANY, t0.KGQUANTITY, t0.MGRQUANTITY, t0.MGVQUANTITY, t0.PRODUCTEUR, t0.STATUSTRACA, t0.TRACETYPE, t0.UNITS, t0.WAREHOUSE, t0.YEAR, t0.IDWO FROM TRACA t0, wo t1 
/*WHERE ((((t0.IDCOMPANY = 'LNS') AND (t1.IDWO = 'OP1101385')) 
AND (t0.TRACETYPE = 'Production'))) 
AND ((t1.IDWO = t0.IDWO) 
AND (t1.IDCOMPANY = t0.IDCOMPANY))
*/


--SELECT * from traca  WHERE (((IDCOMPANY = 'LNS') AND (IDWO = 'OP1101385')) AND (TRACETYPE = 'Production'))
--SELECT * -- t1.IDTRACA, t1.BASSIN, t1.BATCHNAME, t1.CONTRAT, t1.IDARTICLE, t1.IDCOMPANY, t1.KGQUANTITY, t1.MGRQUANTITY, t1.MGVQUANTITY, t1.PRODUCTEUR, t1.STATUSTRACA, t1.TRACETYPE, t1.UNITS, t1.WAREHOUSE, t1.YEAR, t1.IDWO 
--FROM wo t0, TRACA t1 WHERE ((((t0.IDWO = 'OP1101385') AND (t0.IDCOMPANY =  'LNS'))
 --AND (t1.TRACETYPE = 'Production' )) AND ((t0.IDWO = 'OP1101385') AND (t0.IDCOMPANY = t1.IDCOMPANY)))

--SELECT * from traca  WHERE (((IDCOMPANY = 'OP1101385') AND (IDWO = 'LNS')) AND (TRACETYPE = 'Production'))

--and t.tracetype = 'Production'"

--SELECT IDTRACA, BASSIN, BATCHNAME, CONTRAT, IDARTICLE, IDCOMPANY, KGQUANTITY, MGRQUANTITY, MGVQUANTITY, PRODUCTEUR, STATUSTRACA, TRACETYPE, UNITS, WAREHOUSE, YEAR, IDWO FROM TRACA WHERE IDWO = 'OP1101385' AND IDCOMPANY = 'LNS' AND TRACETYPE = 'Production'

--alter table footable drop foreign key fooconstraint
--(`ticket`.`trace`, CONSTRAINT `FK_ARTICLE_BATCH` FOREIGN KEY (`IDARTICLE`) REFERENCES `batch` (`IDARTICLE`)) 

--SELECT IDBATCH, BATCHNAME, CONTRACT, DESCRIPTION, IDCALIBER, IDDIAGRAM, IDPEA, LIMSBATCHID, LIMSFOLDERNO, ORIGIN1, ORIGIN2, PRODGROUP, PRODUCERNAME, QUANTITY, UNITS, IDARTICLE, IDGENERATION, IDSPECIE, IDSTAGE, IDTRACE, IDTREATEMENT, IDVARIETY, IDWO, IDCOMPANY 
--FROM batch WHERE 1=1
--IDBATCH=3201
--and BATCHNAME = 'lotInexistant' --'unknomnCompagny'
--AND IDARTICLE = AND (IDCOMPANY
