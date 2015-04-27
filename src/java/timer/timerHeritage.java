/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import entite.Resultstemp;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import objet.metier.creation.LectureResultesTemp;
import session.ejb.RecopieAnalysis;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class timerHeritage {

    @PersistenceContext ()
    protected EntityManager em;
    
    //@Inject RecopieAnalysis recopieAnalysis;
    @Inject LectureResultesTemp lectureResultesTemp;
    
    //@Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "3", second = "0")
    public void myTimer() {
        System.out.println("**********************************************Timer event: " + new Date());
        TypedQuery<entite.Resultstemp> q = em.createNamedQuery("Resultstemp.findByIsresultsinsertedMinIdBatch", entite.Resultstemp.class);
        q.setParameter("isresultsinserted", false);
        q.setParameter("isresultsinsertedmin", false);
        List<Resultstemp> listeResults=q.getResultList();
    
        lectureResultesTemp.process(listeResults);
        System.out.println("*************************************************** proces terminer ");
        //recopieAnalysis.doHeritage();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
