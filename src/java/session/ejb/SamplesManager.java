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
import javax.persistence.TypedQuery;

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
    
    Casefile casefileCurrent;
            
    public SamplesManager (){
        System.out.println("entrerdans SamplesManager *************");
    }
    
    public entite.Analysis addresults(Casefile casefileCurrent, BigInteger idModelanalysis, String methodname, String mesureName, String rawresult) {
        System.out.println("entrer dans SamplesManager Addresults **************************"+analysisManager);

        //setCasefile(casefileCurrent);
        analysisManager.setSamplesCurrent(samplesCurrent);
        return analysisManager.addresults(idModelanalysis,  methodname,  mesureName,  rawresult);
    }

    public void setCasefile(Casefile casefileCurrent) {
        this.casefileCurrent=casefileCurrent;
    }
    
    public Samples createSamples(String limssampleid) {
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
        samplesCurrent.setLimssampleid(limssampleid);
        samplesCurrent.setLimsfolderno(casefileCurrent.getLimsfolderno());
        
        
        em.merge(samplesCurrent);
        //em.flush();
        return samplesCurrent;
    }

    public Samples findExistingSamples(String limssampleid) {
        TypedQuery<Samples> q = em.createNamedQuery("Samples.findByLimssampleid", Samples.class);
        q.setParameter("limssampleid", limssampleid);
        
        List<Samples> samplesList = q.getResultList();
        if(samplesList.isEmpty()){
                return null;
        }
        samplesCurrent=samplesList.get(0);
        return samplesCurrent;
    }
    
    
    
}