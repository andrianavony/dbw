/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Measures;
import entite.Method;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class MethodDetailsManager {

    @PersistenceContext ()
    protected EntityManager em;
    
    public MethodDetailsManager() {
    }

    
    public Measures getOrCreateMeasure(Method method, String measurename) {
        List<Measures> measureList =getMeasureList(method,  measurename);
        if(measureList.isEmpty()){
            return createMeasure(method, measurename);
        }else {
            return measureList.get(0);
        }
            
    }
    
    public List<Measures> getMeasureList(Method method, String measurename) {
        BigInteger limsanalysisid=method.getLimsanalysisid();
        TypedQuery<Measures> query= em.createNamedQuery("Measures.findByLimsanalysisidMeasurename",Measures.class);
        query.setParameter("limsanalysisid", limsanalysisid);
        query.setParameter("measurename", measurename);
        
        List<Measures> measurList=query.getResultList();
                
        return measurList;
    }

    public Measures createMeasure(Method method, String measurename) {
        Measures measures = new Measures();
        measures.setLimsanalysisid(method.getLimsanalysisid());
        measures.setMeasurename(measurename);
        measures=em.merge(measures);
        em.flush();
        System.out.println("+++++++++++++++++++++++++++++++++createMeasure "+measures.getIdmeasure());
        return measures;
    }
    
    
}
