/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Company;
import entite.Method;
import entite.Modelanalysis;
import entite.Results;
import entite.Samples;
import entite.Traca;
import entite.Wo;
import error.AnalysisWithoutSamplesError;
import error.SampleWithoutCasefileError;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;
import utilities.AnalysisUtility;
import utilities.Constant;
import utilities.DateManager;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class AnalysisManager {

    @PersistenceContext ()
    protected EntityManager em;
    
    
    Analysis analysisCurrent;
    
    
//    @EJB I_FacadeSaisieResultats facadeSaisieResultats;
    
    @Inject ResultsManager resultsManager;
    
    @Inject AnalysisUtility analysisUtility;
    
    @Inject @Any Event<Analysis> eventOnAnalysis;
    
    /***
     * une analyse doit etre faite sur un ES
     */
    public Samples samplesCurrent;
    
    public AnalysisManager(){
       
    }
    
    
    public void setSamplesCurrent(    Samples samplesCurrent){
        this.samplesCurrent=samplesCurrent;
    }

        /****
     * Si le lot descendant n'existe pas dans le systeme on ne le cree pas le
     * @throws il n'est pas normale qu'on ne puisse pas ajouter DL, un ES ou une analyses sue le DL
     */
 /*   
    public List<Analysis> doHeritage(Analysis analysisACopier) throws AnalysisWithoutSamplesError, SampleWithoutCasefileError {
        System.out.println("**************************Heritage ");
        List<Analysis> analyseHerited = new ArrayList<>();
         Batch batch= getIdBatch(analysisACopier);
        List<entite.Batch> descendantsList= getListBatchDescendants(batch);
        if(null==descendantsList){
            return analyseHerited;
        }
        
        for (entite.Batch descendantsBatch: descendantsList ){
            System.out.println("Insertion heritage dans "+descendantsBatch);
            entite.Casefile casefileHeritage = facadeSaisieResultats.createOrRretriveCasefileForTypeDeCopie(batch, Constant.typeDeCopie.HERITAGE);
            
            Samples samplesCurrentDLBatchDescendants=null;
            samplesCurrentDLBatchDescendants = facadeSaisieResultats.getSampleCurrent(casefileHeritage);
            em.merge(samplesCurrentDLBatchDescendants);
            
            BigInteger limsidanalysis=analysisACopier.getLimsidanalysis();
            String methodName = analysisACopier.getMethodname();
            Analysis analysisDescendantsBatch= analysisUtility.createAnalysis(samplesCurrent,limsidanalysis , methodName);
            
            analysisDescendantsBatch = facadeSaisieResultats.copieResultats(analysisACopier,Constant.typeDeCopie.HERITAGE,analysisDescendantsBatch );
            analyseHerited.add(em.merge(analysisDescendantsBatch));
        }
        return analyseHerited;
    }
 */   
    public Analysis createAnalysis(BigInteger limsanalysisid, String methodname) throws AnalysisWithoutSamplesError {
        Analysis a;
        try {
            a = analysisUtility.createAnalysis(samplesCurrent, limsanalysisid, methodname);
        } catch (AnalysisWithoutSamplesError ex) {
            throw new AnalysisWithoutSamplesError("Sample Current is null");
        }
        System.out.println(" dans createAnalysis ***************** " +a);
        return em.merge(a);
    }
    
    /**
     * Cette methode permet de saisir les résultats avec l'identifiant LIMS de l'analyses et une des methode qui lui est associée.
     * On crée l'objet Methode qui contient une référence à une modele d'analyse.
     * Si c'est la même identifiant limsanalysisid on ajoute sur la même analyse
     * Sinon on crée une autre analyse
    **/
    public Analysis addresults( BigInteger limsanalysisid, String methodname, String mesureName, String rawresult) throws AnalysisWithoutSamplesError{
        if(null==samplesCurrent) {
            throw new AnalysisWithoutSamplesError("No Sample current available ");
        }
        
        if(null==analysisCurrent){
            System.out.println("Creation nouvelle analyses analyses car null ");
            analysisCurrent = createAnalysis(limsanalysisid, methodname);
            
        }else{
            if(! (limsanalysisid.compareTo(analysisCurrent.getLimsidanalysis())==0)){
                System.out.println(limsanalysisid +" Creation nouvelle analyses analyses car différente "+analysisCurrent.getLimsidanalysis());
                analysisCurrent = createAnalysis(limsanalysisid, methodname);
            }
        }
        addresultsToAnalysisCurrent( mesureName, rawresult);
        em.flush();
        return analysisCurrent;
    }
    
    public Analysis addresultsToAnalysisCurrent(  String mesureName, String rawresult){
        Results r =analysisUtility.addresultsToAnalysis( analysisCurrent, mesureName,  rawresult);
        em.merge(r);
        analysisCurrent.setCopystatus(Constant.HERITAGETODO);
        return em.merge(analysisCurrent);
    }
            
      
    public entite.Results addresults( Method method, String mesureName, String rawresult) {
        List<Analysis> analysisList= fingExistingAnalysis(  method);
        if(analysisList.isEmpty()){
//            analysisCurrent=createAnalysis(samplesCurrent, method);
        }else{
            analysisCurrent=analysisList.get(0);
        }
        analysisCurrent=em.merge(analysisCurrent);
        em.flush();
        return resultsManager.addresults(analysisCurrent, method, mesureName, rawresult);
        
        
    }
    
    public List<Analysis> fingExistingAnalysis(  Method idmethod){
        Modelanalysis idmodelanalysis = idmethod.getIdmodelanalysis();
        Contracts.assertNotNull(idmodelanalysis);
        
        TypedQuery<Analysis> query ;
        query= em.createNamedQuery("Analysis.findByIdsampleIdModelanalysisIdMethod", Analysis.class);
            query.setParameter("idsamples", samplesCurrent);
            query.setParameter("idmodelanalysis", idmodelanalysis);
            query.setParameter("idmethod",idmethod);
            
            List<Analysis> analysisesList =query.getResultList();
            return analysisesList;
    }

    

    public Analysis setInfoFromSample(Analysis analysis, Samples samples) {
        return analysisUtility.setInfoFromSample(analysis, samples);
    }

    

    
    
    public Modelanalysis createOrUpdateModelanalysisXXX(BigInteger idmodelanalysis) {
        
        TypedQuery<Modelanalysis> query =em.createNamedQuery("Modelanalysis.findByIdmodelanalysis",Modelanalysis.class);
        query.setParameter("idmodelanalysis", idmodelanalysis);        
        List<Modelanalysis> modelanalysisesList = query.getResultList();
        if(modelanalysisesList.isEmpty()){
            Modelanalysis modelanalysis=new Modelanalysis(idmodelanalysis);
            return em.merge(modelanalysis);
        }else{
            return modelanalysisesList.get(0);
        }
    }

        public Analysis setInfoFromMethodXXX(Analysis analysis, BigInteger idmethod) {
        Method method;
        TypedQuery<Method> query =em.createNamedQuery("Method.findByIdmethod",Method.class);
        query.setParameter("idmethod", idmethod);        
        List<Method> methodList = query.getResultList();
        if(methodList.isEmpty()){
            method=new Method(idmethod);
            method= em.merge(method);
        }else{
            method= methodList.get(0);
        }
        
        analysis.setIdmethod(method);
        analysis.setMethodname(method.getMethodname());
        
        return analysis;
    }
        
    

    
    
    
    

    

    
   

   

    public void setAnalysis(Analysis analysis) {
        samplesCurrent=analysis.getIdsamples();
        Contracts.assertNotNull(samplesCurrent);
        analysisCurrent=analysis;
    }

   

    
    
    

    
    
 
    
public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname, String methodname, BigInteger limsidseries) throws AnalysisWithoutSamplesError {
        
        Analysis a= analysisUtility.getOrCreateAnalysisViaLimsAnalysisOrigrec(idsamples, limsanalysisorigrec, limsanalysisid, analysisname, methodname, limsidseries);
        
        return em.merge(a);           
        }

    public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(String measurename, BigInteger limsmeasureid, String rawresults, String formated, Short repetition, String username, Date dateofentry, String statutsLabel) {
        Results r = analysisUtility.getOrCreateAnalysisViaLimsAnalysisOrigrec(analysisCurrent, measurename, limsmeasureid, rawresults, formated, repetition, username, dateofentry, statutsLabel);
        em.merge(r);
        return em.merge(analysisCurrent);
        
    }

    
    
    public void validation(Analysis analyseAValider){
        
        eventOnAnalysis.fire(analyseAValider);
        System.out.println(" evenement declencher ************");
        //return null;
    }

    public Analysis createAnalysisViaInfoLims(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname, String methodname, BigInteger limsidseries) 
          throws AnalysisWithoutSamplesError 
    {
        if(null== idsamples){
            throw new AnalysisWithoutSamplesError("Dans Creation Analysis Via Info LIMS sample is null ");
        }
        return analysisUtility.createAnalysisViaInfoLims(samplesCurrent, limsanalysisorigrec, limsanalysisid, analysisname, methodname, limsidseries);
    }

     public Analysis createAnalysisFromResults(Samples sample, Results resultatInserted) throws AnalysisWithoutSamplesError {
        samplesCurrent = sample;
        Analysis a =analysisUtility.createAnalysisFromResults(samplesCurrent, resultatInserted, resultatInserted.getLimsidanalysis());
        return em.merge(a);
    }
     
     public Analysis getAnalysisViaLimsAnalysisOrigrec( BigInteger limsanalysisorigrec){
        Analysis a = analysisUtility.getAnalysisViaLimsAnalysisOrigrec(limsanalysisorigrec);
        return em.merge(a);
    }


    public Batch getIdBatch(Analysis analysis) {        
        if(analysis == null){
            return null;
        }
        return getBatchByIdbatch(analysis.getIdbatch().getIdbatch());
    }

    public Batch getBatchByIdbatch(BigInteger bi_idbatch) {
        Batch idbatch = new Batch(bi_idbatch);
        TypedQuery<Batch> q =em.createNamedQuery("Batch.findByIdbatch", Batch.class);
        q.setParameter("idbatch",bi_idbatch );
        if(q.getResultList().isEmpty()){
            return null;
        }
        return q.getResultList().get(0); 
    }
    
    /***
     * trouve les lots qui ont été produits a partir du lot du résultats d'analyse
     * OF028712
     **/
    public List<entite.Batch> getListBatchDescendants(Batch lotParent){
         System.out.println("*********** Dans FIND **************============================================"+em);
        List<entite.Traca> woProduction = listeWoProduction (lotParent);
        if(null==woProduction){
            return null;
        }
        if(woProduction.isEmpty()){
            return null;
        }
        
        List<entite.Batch> descendants = null; //new ArrayList<>(woProduction.size());
        for(entite.Traca traca : woProduction){
            System.out.println(" traca trouver "+traca );
            descendants=getBatchFromTraca(traca);
            System.out.println("descendants "+descendants.size());
        }
        
        return descendants;
    }
    
    public List<entite.Traca> listeWoProduction(Batch batchProduit) {
        System.out.println("*********** Dans FIND **************============================================"+em);
        if(null == batchProduit){
            return null;
        }
        Wo idWo= batchProduit.getIdwo();
        Company idcompany =batchProduit.getIdcompany();
        System.out.println("idWo "+idWo);
        System.out.println("idcompany"+idcompany);
        TypedQuery<entite.Traca> q = em.createNamedQuery("Traca.findByIdwo_Production", entite.Traca.class);
        q.setParameter("idwo", idWo); 
        q.setParameter("idcompany", idcompany.getIdcompany());
        List<entite.Traca> tmp=q.getResultList();
        System.out.println("q "+q);
        return tmp;
        
    }
    
    public List<Batch>  getBatchFromTraca(Traca traca) {
        TypedQuery<Batch> q =em.createNamedQuery("Batch.findByIdarticleBatchnameCompanynameIdWo", Batch.class);
        q.setParameter("batchname",traca.getBatchname() ); 
        q.setParameter("idarticle", traca.getIdarticle()); 
        q.setParameter("idcompany", traca.getIdcompany());
        String idwo =traca.getIdwo().getWoPK().getIdwo();
        System.out.println("idwo "+idwo);
        q.setParameter("idwo", traca.getIdwo());
        
        return q.getResultList(); 
        
    }

  

    /****
     * l'analyse est déjà rataccher à un lot, DL, ES
     */
    public Analysis copierAnalysis(Analysis analysisACopier, Constant.typeDeCopie typeDeCopie, Analysis analyseFille) {
        if(typeDeCopie== Constant.typeDeCopie.HERITAGE){
            analyseFille.setHerited(Boolean.TRUE);
        }
        
        analyseFille.setCreationdate(DateManager.getNow());
        analyseFille.setCopiedfromidbatch(analysisACopier.getIdbatch());
        analyseFille.setCopiedfromidsample(analysisACopier.getIdsamples());
        
        List<Results> listResults= analysisUtility.getResultsListFromAnalysis(analysisACopier);
        for(Results resultACopier : listResults){
            Results c= analysisUtility.copyResultsToAnalysis(analysisCurrent, resultACopier);
            em.merge(c);
        }
        analyseFille=em.merge(analyseFille);
        return analyseFille;
    }
    
}

  

