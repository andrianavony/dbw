SELECT results.`BATCHNAME`, results.`IDSAMPLES`, results.`ANALYSISNAME`, results.`MEASURENAME`, results.`RAWRESULTS`
 
FROM              batch 
INNER JOIN results      ON batch.`IDBATCH`= results.`IDBATCH`
