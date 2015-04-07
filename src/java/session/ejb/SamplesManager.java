/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;


import entite.Casefile;
import entite.Samples;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    Samples samplesCurrent;
    
    public SamplesManager (){
        System.out.println("entrerdans SamplesManager *************");
    }
    
    public void addresults(Casefile casefileCurrent, BigInteger idModelanalysis, String methodname, String mesureName, String rawresult) {
        System.out.println("entrer dans SamplesManager Addresults **************************"+analysisManager);

        //setCasefile(casefileCurrent);        
        analysisManager.addresults(samplesCurrent,idModelanalysis,  methodname,  mesureName,  rawresult);
    }

    public Samples setCasefile(Casefile casefileCurrent) {
        System.out.println("Jaona passe dans setcaseFile de SamplesManager ***************");
        List<Samples> samplesList = casefileCurrent.getSamplesList();
        for(Samples sample : samplesList){
            if(sample.getIscurrent()){
                samplesCurrent=sample;
            }
        }
        if(null==samplesCurrent){
            samplesCurrent=createSamples(casefileCurrent);
        }
        return samplesCurrent;
    }

    public Samples createSamples(Casefile casefileCurrent) {
        System.out.println("Dans create sample ******************************");
        samplesCurrent = new Samples();
        samplesCurrent.setIscurrent(Boolean.TRUE);
        samplesCurrent.setIdarticle(casefileCurrent.getIdarticle());
        samplesCurrent.setBatchname(casefileCurrent.getBatchname());
        samplesCurrent.setCreationdate(utilities.DateManager.getNow());
        samplesCurrent.setStatuslabel("logged");
        samplesCurrent.setIdbatch(casefileCurrent.getIdbatch());
        samplesCurrent.setIdcasefile(casefileCurrent);
        samplesCurrent.setIdspecie(casefileCurrent.getIdspecie());
        samplesCurrent.setIdstage(casefileCurrent.getIdstage());
        em.merge(samplesCurrent);
        //em.flush();
        return samplesCurrent;
    }
    
    
    
}
