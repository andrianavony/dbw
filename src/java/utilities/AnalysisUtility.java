/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Analysis;
import entite.Method;
import entite.Modelanalysis;
import entite.Results;
import entite.Samples;
import error.AnalysisWithoutSamplesError;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;


/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class AnalysisUtility {

    @PersistenceContext ()
    protected EntityManager em;
    
    
    @Inject ResultsUtility resultsUtility;
    
    public AnalysisUtility(){
        System.out.println("Creation analysis uti =========================================================");
    }

     public Analysis createAnalysisViaInfoLims(Samples samplesCurrent, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname,  String methodname, BigInteger limsidseries) 
                        throws AnalysisWithoutSamplesError
     {
         if(null==samplesCurrent){
             throw new AnalysisWithoutSamplesError("Dans Creation Analysis Via Info LIMS sample is null ");
         }
        Method method = createOrRetreiveMethodeFromLims(limsanalysisid,  methodname);
        Analysis a=setDifferentInfo(samplesCurrent, method);
        a.setLimsidanalysis(limsanalysisid);
        a.setLimsidseries(limsidseries);
        a.setCreationdate(utilities.DateManager.getNow());
        a.setLimsanalysisorigrec(limsanalysisorigrec);
        a=em.merge(a);
        return a ;
    }
     public Analysis setDifferentInfo(Samples samplesCurrent,Method method) {
        Analysis analysis=new Analysis();
        setInfoFromSample(analysis, samplesCurrent);
        System.out.println(" *************** method.getIdmodelanalysis()  "+method.getIdmodelanalysis());
        setInfoFromModeleAnalysis(analysis, method.getIdmodelanalysis());
        setInfoFromMethod(analysis,  method);
        //analysisCurrent=em.merge(analysis);
        return analysis;
    }
    
     public Analysis setInfoFromModeleAnalysis(Analysis analysis, Modelanalysis modelanalysis) {
        System.out.println(" ==<= modelanalysis"+modelanalysis);
        analysis.setIdmodelanalysis(modelanalysis);
        analysis.setAnalysisname(modelanalysis.getAnalysisname());
        analysis.setOfficialename(modelanalysis.getOfficialname());

        return analysis;
    }
     
     public Analysis setInfoFromMethod(Analysis analysis, Method method) {
         System.out.println(" dans setInfoFromMethod debut "+analysis.getIdsamples() );
        analysis.setIdmethod(method);
        analysis.setMethodname(method.getMethodname());
         System.out.println(" dans setInfoFromMethod avant retour "+analysis.getIdsamples() );
         analysis.setCreationdate(DateManager.getNow());
        return analysis;
    }
     
     
     public Analysis getOrCreateAnalysisViaLimsAnalysisOrigrec(Samples idsamples, BigInteger limsanalysisorigrec, BigInteger limsanalysisid, String analysisname, String methodname, BigInteger limsidseries) throws AnalysisWithoutSamplesError {
        
        Analysis a=getAnalysisViaLimsAnalysisOrigrec(limsanalysisorigrec);
        
        if(null==a){
            return createAnalysisViaInfoLims( idsamples,  limsanalysisorigrec,  limsanalysisid,  analysisname,    methodname,  limsidseries);
        }
        return a;           
        }
     
    public Analysis getAnalysisViaLimsAnalysisOrigrec( BigInteger limsanalysisorigrec){
        TypedQuery<Analysis> query ; 
        query= em.createNamedQuery("Analysis.findByLimsanalysisorigrec", Analysis.class);
            query.setParameter("limsanalysisorigrec",limsanalysisorigrec);
            List<Analysis> analysisesList =query.getResultList();
            if(analysisesList.isEmpty()){ 
             return null;
            }else {                    
                return analysisesList.get(0);
        }
            
    }
    
    public Analysis copierAnalysis(Analysis analysisACopier, Samples samples, Constant.typeDeCopie typeDeCopie) {
        Analysis analysisCopier = new Analysis();
        switch (typeDeCopie) {
            case HERITAGE :
                    analysisCopier = copierAnalysisHeritage(analysisACopier, samples);
                    break;
            }
                
            
        return analysisCopier;
    }

    public Analysis copierAnalysisHeritage(Analysis analysisACopier, Samples samples) {
        Analysis copie = copieAnalysis(analysisACopier);
        setInfoFromSample(copie,  samples);
        copie.setHerited(Boolean.TRUE);
        return copie;
    }
    
    public Analysis setInfoFromSample(Analysis analysis, Samples samples) {
        analysis.setIdarticle(samples.getIdarticle());
        analysis.setBatchname(samples.getBatchname());
        analysis.setLimssampleid(samples.getLimssampleid());
        analysis.setIdbatch(samples.getIdbatch());
        analysis.setIdcasefile(samples.getIdcasefile());
        analysis.setLimsbatchid(samples.getLimsbatchid());
        analysis.setLimsfolderno(samples.getLimsfolderno());
        analysis.setProdgroup(samples.getProdgroup());
        analysis.setIdspecie(samples.getIdspecie());
        analysis.setIdstage(samples.getIdstage());
        analysis.setIdsamples(samples);
        return analysis;
    }

    public Analysis copieAnalysis(Analysis analysisACopier) {
        Analysis copie = new Analysis();
        copie.setAnalysisname(analysisACopier.getAnalysisname());
        //q.setApporved(w.getApporved());
        //q.setApporvedby(w.getApporvedby());
        //q.setApporveddate(w.getApporveddate());
        copie.setCopiedfromidbatch(analysisACopier.getIdbatch());
        copie.setCopiedfromidsample(analysisACopier.getIdsamples());
        copie.setCreationdate(utilities.DateManager.getNow());
        copie.setIdanalysis(analysisACopier.getIdanalysis());
        copie.setIdmethod(analysisACopier.getIdmethod());
        copie.setIdmethoddetails(analysisACopier.getIdmethoddetails());
        copie.setIdmodelanalysis(analysisACopier.getIdmodelanalysis());
        copie.setIdmotheranalysis(analysisACopier.getIdmotheranalysis());
        //q.setIdseries(w.getIdseries());
        copie.setIsvirtual(Boolean.TRUE);
        copie.setMethodname(analysisACopier.getMethodname());
        
        recopieResults(analysisACopier,copie);
        return copie;
    }

    public void recopieResults(Analysis analysisACopier, Analysis copie) {
        List<Results> resultsListAcopier= getResultsListFromAnalysis(analysisACopier);
        for(Results r : resultsListAcopier){
            copierResults(r, copie);
        }
    }

    public List<Results> getResultsListFromAnalysis(Analysis analysisACopier) {
        TypedQuery<Results> query = em.createNamedQuery("Results.findByIdanalysis", Results.class);
        query.setParameter("idanalysis", analysisACopier);
        return query.getResultList();        
    }

    public void copierResults(Results r, Analysis copie) {
        Results c =ResultsUtility.getCopieResults(r);
        c.setIdanalysis(copie);
        em.merge(c);
    }

    public Analysis createAnalysis(Samples samples, BigInteger limsidanalysis, String methodname) throws AnalysisWithoutSamplesError {
       if(null == samples){
           throw new AnalysisWithoutSamplesError(" Sample cannot be null ");
       }
         Method method = createOrRetreiveMethodeFromLims(limsidanalysis, methodname);
         System.out.println(" dans Analysis Utilitie createAnalysis "+method);
         Modelanalysis idmodelanalysis = createOrRetreiveModelanalysisFromLims(limsidanalysis);
         System.out.println(" dans Analysis Utilitie createAnalysis "+ idmodelanalysis);
         
         return createAnalysis(samples, idmodelanalysis, method, limsidanalysis);
    }
    
    public Method createOrRetreiveMethodeFromLims(BigInteger limsanalysisid, String methodname) {
        Modelanalysis modelanalysis = createOrRetreiveModelanalysisFromLims(limsanalysisid);
        
        //em.merge(modelanalysis);
        
        System.out.println("modelanalysis ************************* "+modelanalysis.getIdmodelanalysis() );
        
        List<Method> methodsList = fingExistingMethodFromLims(limsanalysisid,  methodname);
        
        if(methodsList.isEmpty()){            
            Method method=new Method();
            method.setMethodname(methodname);
            method.setIdmodelanalysis(modelanalysis);
            method.setLimsanalysisid(limsanalysisid);
            method=em.merge(method);
            em.flush();
            System.out.println(" ............................ lors de la creation de  la methode Idmethod="+method.getIdmethod()+"    "+method.getIdmodelanalysis().getIdmodelanalysis());
            return method;
        }else {
            System.out.println("****************** "+methodsList.get(0));
            Method methodSansModeleanalyse = methodsList.get(0);
            methodSansModeleanalyse.setIdmodelanalysis(modelanalysis);
            em.merge(methodSansModeleanalyse);
            return methodsList.get(0);
        }
    }
    
        public Modelanalysis createOrRetreiveModelanalysisFromLims(BigInteger limsidanalysis) {
        List<Modelanalysis> modelanalysisesList =fingExistingModelanalysisFromLims( limsidanalysis);
        if(modelanalysisesList.isEmpty()){
            return createModelAnalysis(limsidanalysis);
        }else{
            System.out.println(" modelanalysisesList.get(0) "+modelanalysisesList.get(0));
            return modelanalysisesList.get(0);
        }
            
    }
     public List<Modelanalysis> fingExistingModelanalysisFromLims(BigInteger limsidanalysis){
        TypedQuery<Modelanalysis> query ;
        Contracts.assertNotNull(em);
        System.out.println("Em not null *********** limsidanalysis "+limsidanalysis);
        query= em.createNamedQuery("Modelanalysis.findByLimsidanalysis", Modelanalysis.class);
            query.setParameter("limsidanalysis",limsidanalysis);
            List<Modelanalysis> modelanalysisesList =query.getResultList();
            System.out.println("modelanalysisesList.size "+modelanalysisesList.size());
            return modelanalysisesList;
    }    
    
      public Modelanalysis createModelAnalysis(BigInteger limsidanalysis) {
        Modelanalysis modelanalysis = new Modelanalysis();
        modelanalysis.setLimsidanalysis(limsidanalysis);
        modelanalysis=em.merge(modelanalysis);
        em.flush();
        System.out.println(modelanalysis.getIdmodelanalysis() + " *********** modelanalysis ******************** "+modelanalysis.getLimsidanalysis());
        return modelanalysis;
    }
    public List<Method> fingExistingMethodFromLims(BigInteger limsanalysisid, String methodname){
        TypedQuery<Method> query ; 
        query= em.createNamedQuery("Method.findByLimsanalysisidMethodname", Method.class);
            query.setParameter("limsanalysisid",limsanalysisid);
            query.setParameter("methodname", methodname);
            List<Method> methodList =query.getResultList();
            return methodList;
    }  

    public Results addresultsToAnalysis(Analysis analysisCurrent, String mesureName, String rawresult) {
        Results r = new Results();
        r.setDateofentry(DateManager.getNow());
        r.setIdbatch(analysisCurrent.getIdbatch());
        r.setMeasurename(mesureName);
        r.setRawresults(rawresult);
        r.setIdanalysis(analysisCurrent);
        System.out.println("************ Creation de nouvelle annalyse dans dans addresultsToAnalysis "+r);
        return r;
    }
    
 public Analysis createAnalysisFromResults(Samples samplesCurrent, Results resultatInserted, BigInteger limsidanalysis) throws AnalysisWithoutSamplesError {
            
        return createAnalysis(samplesCurrent, resultatInserted.getIdmodelanalysis(),resultatInserted.getIdmethod(), limsidanalysis);
        
    }
  public Results getOrCreateAnalysisViaLimsAnalysisOrigrec(Analysis analysisCurrent, String measurename, BigInteger limsmeasureid, String rawresults, String formated, Short repetition, String username, Date dateofentry, String statutsLabel) {
        
        entite.Results r = new Results();
        r.setIdanalysis(analysisCurrent);
        r.setIdarticle(analysisCurrent.getIdarticle());
        r.setBatchname(analysisCurrent.getBatchname());
        r.setLimssampleid(analysisCurrent.getLimssampleid());
        r.setLimsidanalysis(analysisCurrent.getLimsidanalysis());
                r.setAnalysisname(analysisCurrent.getAnalysisname());
        r.setMethodname(analysisCurrent.getMethodname());
        
        
        r.setRepetition(repetition);
        r.setMeasurename(measurename);
        r.setRawresults(rawresults);
        r.setFormated(formated);
        r.setLimsidseries(limsmeasureid);
        r.setDateofentry(dateofentry);
        r.setStatuslabel(statutsLabel);
        r.setIdseries(analysisCurrent.getIdseries());
        
        return r;
        
    }

    public  Analysis createAnalysis(Samples samplesCurrent, Modelanalysis idmodelanalysis, Method idmethod, BigInteger limsidanalysis ) throws AnalysisWithoutSamplesError {
        if(null == samplesCurrent){
            throw new AnalysisWithoutSamplesError("Cannot create a analysis with a null Sample ");
        }
        Analysis a =new Analysis();
        System.out.println(" dans Analysis Utilitie createAnalysis a (null OK) "+a.getIdsamples());
        
        a=setInfoFromSample(a , samplesCurrent);
        System.out.println(" dans Analysis Utilitie createAnalysis a "+a.getIdsamples());
        a=setInfoFromModeleAnalysis(a, idmodelanalysis);
        System.out.println(" dans Analysis Utilitie createAnalysis a "+a.getIdmodelanalysis());
        a=setInfoFromMethod(a, idmethod);
        System.out.println(" dans Analysis Utilitie createAnalysis a "+a.getIdmethod());
        
        System.out.println(" avant retour "+a);
        a.setLimsidanalysis(limsidanalysis);
        return a;
    }

    public Results copyResultsToAnalysis(Analysis analysisCurrent, Results resultACopier) {
        String mesureName=resultACopier.getMeasurename();
        String rawresult=resultACopier.getRawresults();
        return addresultsToAnalysis(analysisCurrent,  mesureName,  rawresult);
    }
      
}
