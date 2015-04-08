/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Batch;
import entite.Casefile;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;
import utilities.DateManager;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class CasefileManager {

    @PersistenceContext ()
    protected EntityManager em;
    
    public CasefileManager() {
    }

    
    @Inject SamplesManager samplesManager;  
    
    public Casefile casefileCurrent;
    
    public Casefile createOrRetriveCaseFileCurrent(Batch batchCurrent) {
        List<Casefile> casefilesList = findCaseFile(batchCurrent);
        
        if(casefilesList.isEmpty()){
            System.out.println("Liste vide ");
            casefileCurrent=createCaseFile(batchCurrent);
            return casefileCurrent;
        }
        
        for(Casefile casefile : casefilesList){
            if(casefile.getIscurrent()){
                casefileCurrent=casefile;
                return casefileCurrent;
            }
        }
        // aucun dossier n'est courant
        casefileCurrent=createCaseFile(batchCurrent);        
        return casefileCurrent;
    }

    public Casefile createCaseFile(Batch batchCurrent) {
        System.out.println("passe dans creation DL ******************");
        casefileCurrent=new Casefile();
        casefileCurrent.setIdbatch(batchCurrent);
        casefileCurrent.setIdarticle(batchCurrent.getIdarticle());
        casefileCurrent.setBatchname(batchCurrent.getBatchname());
        casefileCurrent.setCreationdate(DateManager.getNow());
        casefileCurrent.setStatuslabel("current");
        casefileCurrent.setIdstatus(Boolean.TRUE);
        casefileCurrent.setIscurrent(Boolean.TRUE);
        
        casefileCurrent.setProdgroup(batchCurrent.getProdgroup());
        casefileCurrent.setIdspecie(batchCurrent.getIdspecie());
        casefileCurrent.setIdstage(batchCurrent.getIdstage());
        casefileCurrent.setLimsbatchid(batchCurrent.getLimsbatchid());
        casefileCurrent.setLimsfolderno(batchCurrent.getLimsfolderno());
        
        casefileCurrent =em.merge(casefileCurrent);
        samplesManager.setCasefile(casefileCurrent);
        //em.flush();
        System.out.println("casefileCurrent "+casefileCurrent.getIdcasefile());
        return casefileCurrent;
    }

    public entite.Analysis addresults(BigInteger idModelanalysis, String methodname, String mesurename, String rawresults) {
        System.out.println("********************** dans DL manager addResults");
        return samplesManager.addresults(casefileCurrent,idModelanalysis,methodname , mesurename, rawresults);
    }

    public void setCasefileCurrent(Casefile casefile) {
        casefileCurrent=casefile;
    }

    public List<Casefile> findCaseFile(Batch batchCurrent) {
        Contracts.assertNotNull(batchCurrent);
        
        TypedQuery<Casefile> query= em.createNamedQuery("Casefile.findByIdbatch", Casefile.class);
            query.setParameter("idbatch", batchCurrent);
            return query.getResultList();
    }
    
}
