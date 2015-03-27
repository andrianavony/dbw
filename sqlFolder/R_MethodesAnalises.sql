/*
select mes.*
from  resultstemp     as mes 
where mes.`LIMSSAMPLEID`='E00003932001'
*/




select * from variety
where `VARIETYNAME` ='LG56.61 CL'

/*
select distinct
es.LIMSBATCHID,es.IDBATCH,  es.BATCHNAME, es.LIMSFOLDERNO, es.IDCASEFILE
, mes.LIMSSAMPLEID
,mes.IDMODELANALYSIS, mes.LIMSIDANALYSIS, mes.LIMSIDSERIES, mes.ANALYSISSTATUSLABEL, mes.ANALYSISAPPROBATIONSTATUSLABEL, mes.COUNTERANALYSISIDLIMS,mes.ANALYSISNAME, mes.METHODNAME
from        resultstemp     as mes 
inner join  samples         as es on es.LIMSSAMPLEID = mes.LIMSSAMPLEID

where mes.LIMSSAMPLEID='E00003932001'
*/
/*
select distinct met.IDMETHOD,
es.`LIMSBATCHID`,es.`IDBATCH`,  es.`BATCHNAME`, es.`LIMSFOLDERNO`, es.`IDCASEFILE`
, mes.`LIMSSAMPLEID`
,mes.`IDMODELANALYSIS`, mes.`LIMSIDANALYSIS`, mes.`LIMSIDSERIES`, mes.`ANALYSISSTATUSLABEL`, mes.`ANALYSISAPPROBATIONSTATUSLABEL`, mes.`COUNTERANALYSISIDLIMS`,mes.`ANALYSISNAME`, mes.`METHODNAME`
from        resultstemp     as mes 
inner join  samples         as es on es.`LIMSSAMPLEID` = mes.`LIMSSAMPLEID`

where mes.`LIMSSAMPLEID`='E00003932001'
*/
--mes.`LIMSFOLDERNO` like '%E00003932%'


-- `ANALYSISPRIORITY` smallint(6) NULL,

--SELECT * FROM `method` WHERE `LIMSANALYSISID`=307 --and `LIMSMETHODID` = 'Buvard' 
--and `METHODNAME`='Buvard' 
--Method.METHODNAME 

--SELECT measures.`MEASURENAME`, `methoddetails`.* FROM `methoddetails` 
--inner join measures on methoddetails.`IDMEASURE`= measures.`IDMEASURE`
--WHERE `methoddetails`.`LIMSANALYSISID`=307 and `methoddetails`.`LIMSMETHODID` = 350 --'Buvard' 

/* -- OK
select met.`IDMETHOD`, met.`METHODNAME`, met.`LIMSMETHODID`, met.`LIMSANALYSISID`, mes.`MEASURENAME`,mes.*  
from `method` met 
inner join measures mes on mes.`LIMSANALYSISID`=met.`LIMSANALYSISID`
where met.`LIMSANALYSISID`=311
--and met.`METHODNAME`='Buvard'
and `IDMETHOD`=422
*/

/*
select * from batch lot
where  `IDWO` ='LMG_023074'
*/



/*--OK pour peupler DL
select distinct
lot.`IDBATCH` , lot.`BATCHNAME` ,mes.LIMSBATCHID ,mes.LIMSFOLDERNO
from resultstemp as mes 
inner join 
batchTemp as lot on lot.`LIMSBATCHID` = mes.`LIMSBATCHID`
where mes.`LIMSFOLDERNO` like '%E00003932%'
Limit 5 
*/

/*
-- CreationSample
select distinct
dossierLot.`IDBATCH` , dossierLot.`BATCHNAME`, dossierLot.`IDCASEFILE` ,mes.LIMSBATCHID ,mes.LIMSFOLDERNO
, mes.`LIMSSAMPLEID`
from resultstemp as mes 
inner join 
casefile as dossierLot on dossierLot.`LIMSFOLDERNO` = mes.`LIMSFOLDERNO`
where mes.`LIMSFOLDERNO` like  '%E00003932%'
*/


