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
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.validator.internal.util.Contracts;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class FacadeSaisieResultats implements I_FacadeSaisieResultats{

    @PersistenceContext ()
    protected EntityManager em;
    
    @Inject BatchManager batchManager;
    @Inject CasefileManager casefileManager;
    @Inject SamplesManager samplesManager;
    @Inject AnalysisManager analysisManager;
    
    
    public FacadeSaisieResultats(){
        
    }
    
    
    @Override
    public Batch createBatch(BigInteger idbatch) {
        Batch b=null;
        if(idbatch!=null){
            b = findExistingBatchByBatchId(idbatch);
        }
        b=em.merge(b);
        return b;        
    }

    @Override
    public Batch createBatch(String batchname, String articlename, String idcompany, String limsbatchid) {
        Batch b=null;
        System.out.println("entrer dans Facade Create batch");
        if(limsbatchid!= null ){
            b = findExistingBatchByLimsBatchId(limsbatchid);
        }
        System.out.println("Step 1 ");
        if(b==null){
            Article idarticle= batchManager.createOrUpdateArticle(articlename);
            System.out.println("idarticle "+idarticle);
            b=createBatch(batchname, idarticle, idcompany, limsbatchid);
        }
        System.out.println("Step final ");
        b=em.merge(b);
        return b;
    }
    
    @Override
    public Batch createBatch(String batchname, Article idarticle, String idcompany, String limsbatchid) {
        Batch b=null;
        System.out.println("Step inter  1 ");
        if(limsbatchid!= null ){
            b = findExistingBatchByLimsBatchId(limsbatchid);
        }
                System.out.println("Step inter  2");
        if(b==null){
            System.out.println("Step inter  3");
            b=batchManager.createBatch(batchname,idarticle  , idcompany, limsbatchid);
            System.out.println("Step inter  4");
            //b.setLimsbatchid(limsbatchid);            
        }
        System.out.println("Step inter  5");
        //b=em.merge(b);
        return b;//em.merge(b);
    }
    

    @Override
    public Casefile createCasefile(BigInteger idcasefile) {
        Casefile c=null;
        
        if(idcasefile==null){
            return null;
        }
        
        c=findExistingCasefile (idcasefile);
        
        if(null==c){
            return null;
        }
        
        c=em.merge(c);
        return c;
    }
    
    @Override
    public entite.Casefile createCasefileForHeritage(entite.Batch idbatch){
        Casefile c=null;
        casefileManager.setCurrentBatch(idbatch);
        c= casefileManager.createCaseFile();
        c=em.merge(c);
        return c;
    }

    @Override
    public Casefile createCasefile(Batch idbatch, String limsfolderno, Integer numdemandelims) {
        Casefile c=null;
        Batch batchForRetreiveInformation=null;
        if(null!= idbatch){
             batchForRetreiveInformation=batchManager.findExistingBatchByIdBatch(idbatch.getIdbatch());
        }
        Contracts.assertNotNull(batchForRetreiveInformation);
        casefileManager.setCurrentBatch(batchForRetreiveInformation);
        if(limsfolderno!=null){
            c=findExistingFolderno (limsfolderno,numdemandelims);
        }        
        if(null==c){
            c= casefileManager.createCaseFile(limsfolderno, numdemandelims);
        }
        c=em.merge(c);
        return c;
    }

    @Override
    public Samples createSample(Casefile idcasefile, String limssampleid) {
        Samples s =null;
        samplesManager.setCasefile(idcasefile);
        s =samplesManager.createSamples(limssampleid);
        return s;
    }
    
    @Override
    public Samples findExistingSamples(String limssampleid){
        return samplesManager.findExistingSamples(limssampleid);
    }

    @Override
    public Analysis createAnalysis(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger idmethod) {
        Analysis a=null;
        return a;
    }
    
    @Override
    public Analysis createAnalysisViaInfoLims(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries) {
        analysisManager.setSamplesCurrent(idsamples);
        Analysis a=analysisManager.createAnalysisViaInfoLims( idsamples,  limsanalysisorigrec,  limsanalysisid,  analysisname,    methodname,  limsidseries) ;
        return a;
    }
    
    @Override
    public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries){
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


    @Override
    public void copieResultats(Results resultatInserted, Batch descendantsBatch, String heritage) {
        Casefile casefileHeritage= createCasefileForHeritage(descendantsBatch);
        String limSampleid=heritage;
        Samples samples= createSample(casefileHeritage, limSampleid);
        
        BigInteger limsanalysisorigrec;
        BigInteger idmethod;
        
        createAnalysis(samples, resultatInserted);
    }

    @Override
    public void createAnalysis(Samples samples, Results resultatInserted) {
        analysisManager.setSamplesCurrent(samples);
        analysisManager.createAnalysisFromResults(resultatInserted);
        
    }
    
}
