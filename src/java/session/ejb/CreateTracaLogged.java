/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import entite.Company;
import entite.Trace;
import entite.Wo;
import entite.WoPK;
import entite.Traca;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class CreateTracaLogged {
    

    @PersistenceContext
    protected EntityManager em;
    
    
    @Inject TracaBean tracaBean;

    

    /**
     * Prendre en charge les traces au statut Logged
     */
    public void createTraceAndBatchForTracaLogged(){
        TypedQuery<Traca> query =em.createNamedQuery("Traca.findTracaLogged",Traca.class);
        List<Traca>  tracaLoggedList = query.getResultList();
        System.out.println(" Nb de tracaLoggedList **************************************************************  "+tracaLoggedList.size());
        for(Traca tracaLogged : tracaLoggedList ){
            System.out.println("dans Boucle createTraceAndBatchForTracaLogged ******************************************* "+tracaLogged.getIdarticle());
            tracaBean.setInfo(tracaLogged);
            System.out.println(" demande de création ***************************************************");
            tracaBean.createTraca();
        }        
    }

    

}
