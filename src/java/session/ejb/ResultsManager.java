/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Measures;
import entite.Method;
import entite.Results;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class ResultsManager {

    @PersistenceContext ()
    protected EntityManager em;

    @Inject 
    MethodDetailsManager methodDetailsManager;
    
    public ResultsManager() {
        System.out.println("entrer dans ResultsManager ******************");
    }

    public Results addresults(Analysis analysis, Method method, String mesureName, String rawresult) {
        Measures measures = createOrUpdateMeasure(method, mesureName);
        return addresults( analysis,  method, measures,  rawresult);
        
    }

    public Measures createOrUpdateMeasure(Method method, String measurename) {
        return methodDetailsManager.getOrCreateMeasure( method, measurename);
    }

    public Results addresults(Analysis a, Method method, Measures measures, String rawresult) {
        System.out.println("entrer dans addresults ******************");
        Results r = new Results();
        r.setRawresults(rawresult);
        
        System.out.println("========================"+a.getIdanalysis());
        r.setIdanalysis(a);
        r.setAnalysisname(a.getAnalysisname());
        
        System.out.println("========================"+a.getIdarticle());
        r.setIdarticle(a.getIdarticle());
        System.out.println("========================"+a.getBatchname());
        r.setBatchname(a.getBatchname());
        r.setAnalysisname(a.getAnalysisname());
        
        System.out.println("========================"+method.getIdmethod());
        r.setIdmethod(method);
        r.setMethodname(a.getMethodname());
        
        r.setIdanalysis(a);
        r.setIdmodelanalysis(a.getIdmodelanalysis());
        
        System.out.println("========================"+a.getIdbatch());
        r.setIdbatch(a.getIdbatch());
        r.setIdcasefile(a.getIdcasefile());
        r.setIdsamples(a.getIdsamples());
        
        System.out.println("========================"+measures.getIdmeasure());
        r.setIdmeasure(measures);
        System.out.println("========================"+measures.getMeasurename());
        r.setMeasurename(measures.getMeasurename());
        
        
        
        r.setCreationdate(utilities.DateManager.getNow());
        
        return em.merge(r);
        
    }
    
    
    
}
