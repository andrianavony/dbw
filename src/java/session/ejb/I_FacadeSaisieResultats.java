/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Article;
import entite.Batch;
import entite.Casefile;
import entite.Samples;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author S.ANDRIANAVONY
 */
public interface I_FacadeSaisieResultats {
    /***
     * @param idbatch Si IdBatch est connu (lors des imports des résutlats via batchtemp par exemple)
     *                on utilisera cette info pour retourne ce batch
     */
    public entite.Batch createBatch(BigInteger idbatch);
    
    
    /***
     * @param batchname
     * @param idarticle 
     * @param idcompany
     * @param  limsbatchid 
     */
    public entite.Batch createBatch( String batchname, String idarticle, String idcompany ,String limsbatchid);
    
    /***
     * @param batchname
     * @param idarticle 
     * @param idcompany
     * @param  limsbatchid 
     */
    public entite.Batch createBatch( String batchname, Article idarticle, String idcompany ,String limsbatchid);
    
    public entite.Casefile createCasefile(BigInteger idcasefile);
    
    public entite.Casefile createCasefile(entite.Batch idbatch,String limsfolderno, Integer numdemandelims);
    
    public entite.Samples createSample(entite.Casefile idcasefile,    String limssampleid);
    
    public Analysis createAnalysisViaInfoLims(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries);
    
    /****
     * On souhaite reciperer l'analyse sur l'échantillon si elle existe au lieu de créee une nouvelle.
     * @param 
     */
    public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries);
            
    public entite.Analysis createAnalysis(entite.Samples idsamples,BigInteger idmodelanalysis, BigInteger idmethod);
    
    public entite.Analysis createAnalysisViaMethodDetails(entite.Samples idsamples,BigInteger idmethoddetails);
    
    public entite.Analysis createAnalysisViaLimsAnalysis(entite.Samples idsamples,BigInteger limsidanalysis, String limsidmethod);
    
       
    public entite.Analysis saisirResultat(entite.Analysis idanalysis, String measurename, BigInteger idmeasure , String rawresults,String formated, Short repetition,String username, Date dateofentry, String statutsLabel);
    
    public entite.Analysis saisirResultatIssusLims(entite.Analysis idanalysis, BigInteger limsanalysisorigrec, String measurename, BigInteger limsmeasureid , String rawresults,String formated, Short repetition,  String username, Date dateofentry, String statutsLabel);

    public Batch findExistingBatchByBatchId(BigInteger idbatch);

    public Batch findExistingBatchByLimsBatchId(String limsbatchid);

    public Casefile findExistingCasefile(BigInteger idcasefile);

    public Casefile findExistingFolderno(String limsfolderno, Integer numdemandelims);
    
    public Samples findExistingSamples(String limssampleid);
    
    
    
    
    
}
