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
import entite.Results;
import entite.Samples;
import error.AnalysisWithoutSamplesError;
import error.BatchIdNotFindError;
import error.IdcasefileNotFoundError;
import error.ResultsWithoutAnalysisError;
import error.SampleWithoutCasefileError;
import java.math.BigInteger;
import java.util.Date;
import utilities.Constant;
import javax.enterprise.event.Observes;

/**
 *
 * @author S.ANDRIANAVONY
 */
public interface I_FacadeSaisieResultats {
    /***
     * Le lot existe déjà dans la base et on souhaite le recuperer.
     * @param idbatch IdBatch doit être connu (lors des imports des résutlats via batchtemp par exemple)
     *                on utilisera cette info pour retourne ce batch
     * @exception Si IdBatch ne correspond pas à un lot on le signale à l'appelant
     */
    public entite.Batch retrieveBatchFromIdBatch(BigInteger idbatch)  throws BatchIdNotFindError ;
    
    
    /***
     * On cherche d'abord à trouver un lot ayant l'identifiant LIMS 
     * S'il n'y a pas on crée un nouveau lot
     * @param batchname
     * @param idarticle 
     * @param idcompany
     * @param  limsbatchid 
     */
    public entite.Batch createOrRetrieveBatch( String batchname, String idarticle, String idcompany ,String limsbatchid);
    
    public entite.Batch createOrRetrieveBatch( String batchname, String idarticle, String idcompany ,BigInteger limsbatchid);
    
    /***
     * @param batchname
     * @param idarticle 
     * @param idcompany
     * @param  limsbatchid 
     */
    public entite.Batch createOrRetrieveBatch( String batchname, Article idarticle, String idcompany ,String limsbatchid);
    
    public entite.Batch createOrRetrieveBatch( String batchname, Article idarticle, String idcompany ,BigInteger limsbatchid);
    
    public entite.Casefile retrieveCasefile(BigInteger idcasefile) throws IdcasefileNotFoundError;
    
    public entite.Casefile createOrRetrieveCasefile(entite.Batch idbatch,String limsfolderno, Integer numdemandelims) throws BatchIdNotFindError;
    
    public entite.Casefile createOrRretriveCasefileForTypeDeCopie(entite.Batch idbatch,Constant.typeDeCopie typeDeCopie);
    
    public entite.Analysis  createAnalysis(Samples samples, Results resultatInserted) throws AnalysisWithoutSamplesError;
    
    public entite.Samples createSample(entite.Casefile idcasefile,    String limssampleid) throws SampleWithoutCasefileError ;
    
    public Analysis createAnalysisViaInfoLims(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries)
            throws AnalysisWithoutSamplesError ;
    
    /****
     * On souhaite reciperer l'analyse sur l'échantillon si elle existe au lieu de créee une nouvelle.
     * @param 
     */
    public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries)
            throws AnalysisWithoutSamplesError 
            ;
            
    public entite.Analysis createAnalysis(entite.Samples idsamples,BigInteger idmodelanalysis, BigInteger idmethod);
    
    public entite.Analysis createAnalysisViaMethodDetails(entite.Samples idsamples,BigInteger idmethoddetails);
    
    public entite.Analysis createAnalysisViaLimsAnalysis(entite.Samples idsamples,BigInteger limsidanalysis, String limsidmethod);
    
       
    public entite.Analysis saisirResultat(entite.Analysis idanalysis, String measurename, BigInteger idmeasure , String rawresults,String formated, Short repetition,String username, Date dateofentry, String statutsLabel);
    
    public entite.Analysis saisirResultatIssusLims(entite.Analysis idanalysis, BigInteger limsanalysisorigrec, String measurename, BigInteger limsmeasureid , String rawresults,String formated, Short repetition,  String username, Date dateofentry, String statutsLabel);
    
    /***
     * permet de faire une copie d'un résulta sur un lot données
     * 
     * @param resultat le srésultat à copier sur le lot descendant
     * @param descendantsBatch le lot qui va recevoir le résultat
     * @param  typeDeCopie  heritage, regroupement, ...
     * @param  samplesDescendantsBatch l échantillon qui portera le résultat.
     *        Si null on crée un nouveau échantillon sur le dossier lot de Type typeDeCopie
     * @param analysisDescendantsBatch l'analyse qui portera le résultat.
     *        Si null on crée une nouvelle analyse.
     * @return  l'analyse sur laquelle on a fait copie des résultats. Cette amanyse pourra être utiliser pour d'autres copie de résultats
     */
    public entite.Analysis copieResultats(Results resultat, Batch descendantsBatch, Constant.typeDeCopie typeDeCopie,Samples samplesDescendantsBatch, Analysis analysisDescendantsBatch) throws SampleWithoutCasefileError , AnalysisWithoutSamplesError;
    
        /***
     * permet de faire une copie d'un résulta sur un lot données
     * 
     * @param analysisACopier l'analyse dont on souhaite recopier les srésultats sur le lot descendant
     * @param descendantsBatch le lot qui va recevoir le résultat
     * @param  typeDeCopie  heritage, regroupement, ...
     * @param  samplesDescendantsBatch l échantillon qui portera le résultat.
     *        Si null on crée un nouveau échantillon sur le dossier lot de Type typeDeCopie
     * @param analysisDescendantsBatch l'analyse qui portera le résultat.
     *        Si null on crée une nouvelle analyse.
     * @return  l'analyse sur laquelle on a fait copie des résultats. Cette amanyse pourra être utiliser pour d'autres copie de résultats
     */
    //public entite.Analysis copieResultats(Analysis analysisACopier, Batch descendantsBatch, Constant.typeDeCopie typeDeCopie,Samples samplesDescendantsBatch, Analysis analysisDescendantsBatch);
    
   public entite.Analysis copieResultats(Analysis analysisACopier,  Constant.typeDeCopie typeDeCopie, Analysis analysisDescendantsBatch)throws ResultsWithoutAnalysisError; 

    public Samples createOrRetreiveSampleCurrent(Casefile casefileHeritage) throws SampleWithoutCasefileError ;

    
    
}
