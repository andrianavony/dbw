/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Method;
import entite.Modelanalysis;
import entite.Samples;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class AnalysisManager {

    @PersistenceContext ()
    protected EntityManager em;
    
    
    Analysis analysisCurrent;
    
    @Inject ResultsManager resultsManager; 
    
    /***
     * une analyse doit etre faite sur un ES
     */
    public Samples samplesCurrent;
    
    public AnalysisManager(){
       
    }
    
    
    public void setSamplesCurrent(    Samples samplesCurrent){
        this.samplesCurrent=samplesCurrent;
    }

    
    /**
     * Cette methode permet de saisir les résultats avec l'identifiant LIMS de l'analyses et une des methode qui lui est associée.
     * On crée l'objet Methode qui contient une référence à une modele d'analyse.
    **/
    public Analysis addresults( BigInteger limsanalysisid, String methodname, String mesureName, String rawresult) {
        if(null==samplesCurrent) {
            return null;
        }
            
        Contracts.assertNotNull(samplesCurrent," l'échantillon ne doit pas etre null");
        Method method = createOrRetreiveMethodeFromLims(limsanalysisid, methodname);
        
        addresults( method, mesureName, rawresult);
        em.flush();
        return analysisCurrent;
    }       
      
    public entite.Results addresults( Method method, String mesureName, String rawresult) {
        List<Analysis> analysisList= fingExistingAnalysis(  method);
        if(analysisList.isEmpty()){
            analysisCurrent=createAnalysis(samplesCurrent, method);
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

    public Analysis createAnalysis(Samples samplesCurrent,Method method) {
        Analysis analysis=new Analysis();
        setInfoFromSample(analysis, samplesCurrent);
        setInfoFromModeleAnalysis(analysis, method.getIdmodelanalysis());
        setInfoFromMethod(analysis,  method);
        analysisCurrent=em.merge(analysis);
        return analysisCurrent;
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

    public Analysis setInfoFromModeleAnalysis(Analysis analysis, Modelanalysis modelanalysis) {
        analysis.setIdmodelanalysis(modelanalysis);
        analysis.setAnalysisname(modelanalysis.getAnalysisname());
        analysis.setOfficialename(modelanalysis.getOfficialname());

        return analysis;
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
        
    public Analysis setInfoFromMethod(Analysis analysis, Method method) {
        analysis.setIdmethod(method);
        analysis.setMethodname(method.getMethodname());
        
        return analysis;
    }

    public Method createOrRetreiveMethodeFromLims(BigInteger limsanalysisid, String methodname) {
        Modelanalysis modelanalysis = createOrRetreiveModelanalysisFromLims(limsanalysisid);
        
        //em.merge(modelanalysis);
        
        //System.out.println("modelanalysis ************************* "+modelanalysis.getIdmodelanalysis() );
        
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
            return methodsList.get(0);
        }
    }
    
    
    public List<Method> fingExistingMethodFromLims(BigInteger limsanalysisid, String methodname){
        TypedQuery<Method> query ; 
        query= em.createNamedQuery("Method.findByLimsanalysisidMethodname", Method.class);
            query.setParameter("limsanalysisid",limsanalysisid);
            query.setParameter("methodname", methodname);
            List<Method> methodList =query.getResultList();
            return methodList;
    }

    
    public Modelanalysis createOrRetreiveModelanalysisFromLims(BigInteger limsidanalysis) {
        List<Modelanalysis> modelanalysisesList =fingExistingModelanalysisFromLims( limsidanalysis);
        if(modelanalysisesList.isEmpty()){
            return createModelAnalysis(limsidanalysis);
        }else{
            return modelanalysisesList.get(0);
        }
            
    }
    
    public List<Modelanalysis> fingExistingModelanalysisFromLims(BigInteger limsidanalysis){
        TypedQuery<Modelanalysis> query ;
        Contracts.assertNotNull(em);
        System.out.println("Em not null ***********");
        query= em.createNamedQuery("Modelanalysis.findByLimsidanalysis", Modelanalysis.class);
            query.setParameter("limsidanalysis",limsidanalysis);
            List<Modelanalysis> modelanalysisesList =query.getResultList();
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

    public void setAnalysis(Analysis analysis) {
        samplesCurrent=analysis.getIdsamples();
        Contracts.assertNotNull(samplesCurrent);
        analysisCurrent=analysis;
    }

   
    
}
