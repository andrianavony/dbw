/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;


import entite.Casefile;
import entite.Samples;
import entite.Analysis;
import error.AnalysisWithoutSamplesError;
import error.ResultsWithoutAnalysisError;
import error.SampleWithoutCasefileError;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import utilities.SamplesUtility;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class SamplesManager {
    @PersistenceContext ()
    protected EntityManager em;
    
    @Inject  
    AnalysisManager analysisManager ;
    @Inject SamplesUtility samplesUtility;
    
    Samples samplesCurrent;
    
    Casefile casefileCurrent;
            
    public SamplesManager (){
        //System.out.println("entrerdans SamplesManager *************");
    }
    
    public entite.Analysis addresults(Casefile casefileCurrent, BigInteger idModelanalysis, String methodname, String mesureName, String rawresult) throws SampleWithoutCasefileError, ResultsWithoutAnalysisError {
        
        //setCasefile(casefileCurrent);
        if(null==samplesCurrent){
            samplesCurrent=samplesUtility.createOrRetreiveSampleCurrent(casefileCurrent);
        }
        analysisManager.setSamplesCurrent(samplesCurrent);
        Analysis a =null;
        try {
            a = analysisManager.addresults(idModelanalysis,  methodname,  mesureName,  rawresult);
        } catch (AnalysisWithoutSamplesError ex) {
            Logger.getLogger(SamplesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }

    public void setCasefile(Casefile casefileCurrent) {
        this.casefileCurrent=casefileCurrent;
    }
    
    public Samples createSamples(String limssampleid) throws SampleWithoutCasefileError {
        Samples samples = createSamplesWithLimssampleid(limssampleid);
         samplesCurrent = em.merge(samples);
         //System.out.println(samplesCurrent +" on retourne pour "+samplesCurrent.getLimssampleid());
         return samplesCurrent;
    }
    
    public Samples createSamplesWithLimssampleid(String limssampleid) throws SampleWithoutCasefileError {
        Samples s =createSamples();
        s.setLimssampleid(limssampleid);
        em.persist(s);
        return s;
    }
        
    public Samples createSamples() throws SampleWithoutCasefileError {
        return  samplesUtility.createSample(casefileCurrent);
    } 

    public Samples createOrRetreiveSampleCurrent(Casefile casefile) throws SampleWithoutCasefileError {
        setCasefile(casefile);
        Samples samples =samplesUtility.createOrRetreiveSampleCurrent(casefile);
        //em.merge(casefileCurrent);
        samplesCurrent = em.merge(samples);
        return samplesCurrent; 
    }

    
    
    
    
}
