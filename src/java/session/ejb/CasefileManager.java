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
    
    Casefile casefileCurrent;
    
    public void setBatch(Batch batchCurrent) {
        System.out.println(" passe dans set Batch ********************");
        List<Casefile> casefilesList =batchCurrent.getCasefileList();
        for (Casefile casefile: casefilesList){
            if(casefile.getIscurrent()){
                casefileCurrent=casefile;
            }
        }
        if(null==casefileCurrent){
            casefileCurrent = createCaseFile(batchCurrent);
        }
        
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
        
        em.merge(casefileCurrent);
        samplesManager.setCasefile(casefileCurrent);
        
        return casefileCurrent;
    }

    public void addresults(BigInteger idModelanalysis, String methodname, String mesurename, String rawresults) {
        System.out.println("********************** dans DL manager addResults");
        samplesManager.addresults(casefileCurrent,idModelanalysis,methodname , mesurename, rawresults);
    }
    
}
