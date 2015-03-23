SELECT results.`BATCHNAME`, 
analyseInitiale.`IDSAMPLES`, analyseInitiale.`ANALYSISNAME`, analyseInitiale.`MEASURENAME`, analyseInitiale.`RAWRESULTS`
 
FROM              batch 
INNER JOIN results  analyseInitiale ON batch.`IDBATCH`= results.`IDBATCH`
inner join results  contreAnalyse   ON batch.`IDBATCH`= results.`IDBATCH`
                                    and contreAnalyse.`IDMODELANALYSIS` = analyseInitiale.`IDMODELANALYSIS`
                                    and contreAnalyse.`IDMEASURE`=analyseInitiale.`IDMEASURE`

