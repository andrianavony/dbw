/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Article;
import entite.Casefile;
import entite.Results;
import entite.Samples;
import error.AnalysisWithoutSamplesError;
import error.BatchIdNotFindError;
import error.ResultsWithoutAnalysisError;
import error.SampleWithoutCasefileError;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.validator.internal.util.Contracts;
import utilities.BatchFind;
import utilities.BatchUtility;
import utilities.CaseFileFind;
import utilities.Constant;
import utilities.SamplesFind;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class FacadeSaisieResultats implements I_FacadeSaisieResultats{

    @PersistenceContext ()
    protected EntityManager em;
    
    @Inject BatchManager batchManager;
    @Inject BatchUtility batchUtility;
    @Inject BatchFind batchFind;
    
    @Inject CasefileManager casefileManager;
    @Inject CaseFileFind caseFileFind;
    
    @Inject SamplesManager samplesManager;
    @Inject SamplesFind samplesFind;
    
    @Inject AnalysisManager analysisManager;
    
    
    
    public FacadeSaisieResultats(){
        
    }
    
    
    @Override
    public Batch retrieveBatchFromIdBatch(BigInteger idbatch) throws BatchIdNotFindError {
        return em.merge(batchManager.retrieveBatchFromIdBatch(idbatch));
    }

    @Override
    public Batch createOrRetrieveBatch(String batchname, String articlename, String idcompany, String limsbatchid) {
        BigInteger bi_limsbatchid= new BigInteger(limsbatchid);
        return createOrRetrieveBatch(batchname, articlename, idcompany, bi_limsbatchid);
    }
    
    @Override
    public Batch createOrRetrieveBatch(String batchname, String articlename, String idcompany, BigInteger limsbatchid) {
        Batch bTemp=batchManager.createOrRetrieveBatch(batchname, articlename, idcompany, limsbatchid);       
        Batch b=em.merge(bTemp);
        return b;
    }
    
    @Override
    public Batch createOrRetrieveBatch(String batchname, Article idarticle, String idcompany, String limsbatchid) {
        BigInteger bi_limsbatchid= new BigInteger(limsbatchid);
        return createOrRetrieveBatch( batchname,  idarticle,  idcompany,  bi_limsbatchid);
    }
    
    @Override
    public Batch createOrRetrieveBatch(String batchname, Article idarticle, String idcompany, BigInteger limsbatchid) {
        Batch bTemp =batchManager.createOrRetrieveBatch( batchname,  idarticle,  idcompany,  limsbatchid);
        Batch b=em.merge(bTemp);
        return b;
    }

    @Override
    public Casefile retrieveCasefile(BigInteger idcasefile) {
        Casefile cTemp=null;
        
        if(idcasefile==null){
            return null;
        }
        
        cTemp=caseFileFind.findExistingCasefile (idcasefile);
        
        if(null==cTemp){
            return null;
        }
        
        Casefile c=em.merge(cTemp);
        return c;
    }
    
    @Override
    public entite.Casefile createOrRretriveCasefileForTypeDeCopie(entite.Batch idbatch, Constant.typeDeCopie typeDeCopie){
        Casefile cTemp=null;
        casefileManager.setCurrentBatch(idbatch);
        cTemp= casefileManager.createOrRretriveCasefileForTypeDeCopie(idbatch,typeDeCopie);
        cTemp.setCasefiletype(typeDeCopie.toString());
        Casefile c=em.merge(cTemp);
        return c;
    }

    @Override
    public Casefile createOrRetrieveCasefile(Batch idbatch, String limsfolderno, Integer numdemandelims) throws BatchIdNotFindError {
        return batchManager.createOrRetrieveCasefile(idbatch, limsfolderno, numdemandelims);
    }

    @Override
    public Samples createSample(Casefile idcasefile, String limssampleid) throws SampleWithoutCasefileError {
        Samples sTemp =null;
        System.out.println(idcasefile + " creation sample avec idcasefile "+ limssampleid);
        samplesManager.setCasefile(idcasefile);
        sTemp =samplesManager.createSamples(limssampleid);
        Samples s = em.merge(sTemp);
        return s;
    }
    
    @Override
    public Analysis createAnalysis(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger idmethod) {
        Analysis a=null;
        return a;
    }
    
    @Override
    public Analysis createAnalysisViaInfoLims(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries)
                    throws AnalysisWithoutSamplesError 
    {
        analysisManager.setSamplesCurrent(idsamples);
        Analysis a=analysisManager.createAnalysisViaInfoLims( idsamples,  limsanalysisorigrec,  limsanalysisid,  analysisname,    methodname,  limsidseries) ;
        return a;
    }
    
    @Override
    public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries)
            throws AnalysisWithoutSamplesError 
    {
        analysisManager.setSamplesCurrent(idsamples);
        Analysis a=analysisManager.getOrCreateAnalysisViaLimsAnalysisOrigrec( idsamples,  limsanalysisorigrec,  limsanalysisid,  analysisname,    methodname,  limsidseries) ;
        return a;
    }

    @Override
    public Analysis createAnalysisViaMethodDetails(Samples idsamples, BigInteger idmethoddetails) {
        Analysis a=null;
        return a;
    }

    @Override
    public Analysis createAnalysisViaLimsAnalysis(Samples idsamples, BigInteger limsidanalysis, String limsidmethod) {
        Analysis a=null;
        return a;
    }
    
    @Override
    public entite.Analysis saisirResultat(entite.Analysis idanalysis, String measurename, BigInteger idmeasure , String rawresults,String formated, Short repetition,String username, Date dateofentry, String statutsLabel){
        Analysis a=null;
        return a;
    }
    
    /***
     * il faut que l analyse existe déjà
     */
    public entite.Analysis saisirResultatIssusLims(entite.Analysis idanalysis, BigInteger limsanalysisorigrec, String measurename, BigInteger limsmeasureid , String rawresults,String formated, Short repetition,  String username, Date dateofentry, String statutsLabel){
        System.out.println(" ***************************** dans saisirResultatIssusLims "+idanalysis.getIdanalysis()+" measurename "+ measurename+ " rawresults "+rawresults);
        Analysis a=idanalysis;
        if(null==idanalysis){
            a=analysisManager.getAnalysisViaLimsAnalysisOrigrec( limsanalysisorigrec);
        }
        if(null==a){
            return null;
        }
        analysisManager.setAnalysis(a);
        a=analysisManager.getOrCreateAnalysisViaLimsAnalysisOrigrec( measurename, limsmeasureid , rawresults,formated, repetition,  username, dateofentry, statutsLabel) ;
        return a;
    }

    /*
    public Batch findExistingBatchByBatchId(BigInteger idbatch) {
        return batchManager.findExistingBatchByIdBatch(idbatch);
    }

    public Batch findExistingBatchByLimsBatchId(String limsbatchid) {
        return batchManager.findExistingBatchByLimsBatchId(limsbatchid) ;
    }

    public Casefile findExistingCasefile(BigInteger idcasefile) {
        return casefileManager.findExistingCasefile(idcasefile);
    }

    public Casefile findExistingFolderno(String limsfolderno, Integer numdemandelims) {
        return casefileManager.findExistingFolderno(limsfolderno, numdemandelims);
    }
    */


    @Override
    public entite.Analysis copieResultats(Results resultatInserted, Batch descendantsBatch, Constant.typeDeCopie typeDeCopie,Samples samplesDescendantsBatch, Analysis analysisDescendantsBatch) throws SampleWithoutCasefileError , AnalysisWithoutSamplesError{
        Casefile casefileTypedeCopie= createOrRretriveCasefileForTypeDeCopie(descendantsBatch,typeDeCopie);
        
        Samples samples= createSample(casefileTypedeCopie, null);
        
        BigInteger limsanalysisorigrec;
        BigInteger idmethod;
        
        return createAnalysis(samples, resultatInserted);
    }

    @Override
    public entite.Analysis createAnalysis(Samples samples, Results resultatInserted) throws AnalysisWithoutSamplesError{
        analysisManager.setSamplesCurrent(samples);
        return analysisManager.createAnalysisFromResults(samples, resultatInserted);
        
    }
    
    /****
     * analysisDescendantsBatch a déjà les informations sur les ES, DL et batch
     * @throws error.ResultsWithoutAnalysisError
     */
    //public entite.Analysis copieResultats(Analysis analysisACopier, Batch descendantsBatch, Constant.typeDeCopie typeDeCopie,Samples samplesDescendantsBatch, Analysis analysisDescendantsBatch){
    @Override
    public entite.Analysis copieResultats(Analysis analysisACopier,  Constant.typeDeCopie typeDeCopie, Analysis analysisDescendantsBatch) throws ResultsWithoutAnalysisError{
        
        System.out.println("Dans Facade analysisDescendantsBatch.getIdsamples() "+analysisDescendantsBatch.getIdsamples());
        analysisManager.setSamplesCurrent(analysisDescendantsBatch.getIdsamples());
        return analysisManager.copierAnalysis(analysisACopier,typeDeCopie,analysisDescendantsBatch);
        
    }
    
    //public void onAnalysis(@Observes(during = TransactionPhase.AFTER_SUCCESS) Analysis event){
        //analysisManager.doOnAnalysis(event);
    //    System.out.println(" dans Facade declenchement evenement " + event.getIdanalysis());
    //}

    @Override
    public Samples createOrRetreiveSampleCurrent(Casefile casefileHeritage) throws SampleWithoutCasefileError {
        System.out.println("dans getSampleCurrent casefileHeritage "+casefileHeritage);
       return samplesManager.createOrRetreiveSampleCurrent(casefileHeritage);
    }
    
    @Override
    public void doHeritage() {
        System.out.println(" dans facade demande de do heritage");
        analysisManager.validation();
    }
    
    @Override
    public entite.Analysis getAnalysisCurrent(){
        return analysisManager.analysisCurrent;
    }
    
}
