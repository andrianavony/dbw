/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Casefile;
import entite.Samples;
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
public class SamplesFind {
    @PersistenceContext ()
    protected EntityManager em;

    public List<Samples>  findSamplesCurrent(Casefile casefile) {
        TypedQuery<Samples> query = em.createNamedQuery("Samples.findByIdcasefileIscurrent", Samples.class);
        query.setParameter("idcasefile", casefile);
        return query.getResultList();
    }
    
    public List<Samples> findExistingSamples(String limssampleid) {
        TypedQuery<Samples> q = em.createNamedQuery("Samples.findByLimssampleid", Samples.class);
        q.setParameter("limssampleid", limssampleid);
        return q.getResultList();
    }
    
    
}
