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
    public Batch batchCurrent ;
    
    public Casefile createOrRetriveCaseFileCurrent() {
        List<Casefile> casefilesList = findCaseFile(batchCurrent);
        
        if(casefilesList.isEmpty()){
            System.out.println("Liste vide ");
            casefileCurrent=createCaseFile();
            return casefileCurrent;
        }
        
        for(Casefile casefile : casefilesList){
            if(casefile.getIscurrent()){
                casefileCurrent=casefile;
                return casefileCurrent;
            }
        }
        // aucun dossier n'est courant
        casefileCurrent=createCaseFile();        
        return casefileCurrent;
    }

    
    public Casefile merge(){
        return em.merge(casefileCurrent);
    }
    
    public Casefile createCaseFile() {
        System.out.println("passe dans creation DL ******************");
        casefileCurrent=new Casefile();
        setInfoFromBatchCurrent();
        /*
        casefileCurrent =em.merge(casefileCurrent);
        samplesManager.setCasefile(casefileCurrent);
        //em.flush();
        System.out.println("casefileCurrent "+casefileCurrent.getIdcasefile());
        */        
        return merge ();
    }
    
    public void setInfoFromBatchCurrent(){
        casefileCurrent.setIdbatch(batchCurrent);
        casefileCurrent.setIdarticle(batchCurrent.getIdarticle());
        System.out.println(" ========================================= "+batchCurrent.getBatchname());
        Contracts.assertNotNull(batchCurrent.getBatchname());
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

   public  void setCurrentBatch(Batch idbatch) {
        this.batchCurrent=idbatch;
    }

   public Casefile createCaseFile(String limsfolderno, Integer numdemandelims) {
       Casefile c =createCaseFile();
       c.setLimsfolderno(limsfolderno);
       c.setNumdemandelims(numdemandelims);
       c=em.merge(c);
        return c;
    }
   
   

   public  Casefile findExistingCasefile(BigInteger idcasefile) {
        Casefile c =null; 
       TypedQuery<Casefile> q = em.createNamedQuery("Casefile.findByIdcasefile", Casefile.class);
        q.setParameter("idcasefile", idcasefile);
        List<Casefile> casefiles =q.getResultList();
        if(casefiles.isEmpty()){
            return null;
        }
        c=casefiles.get(0);
        return c;
    }

   public  Casefile findExistingFolderno(String limsfolderno, Integer numdemandelims) {
        Casefile c =null; 
       TypedQuery<Casefile> q = em.createNamedQuery("Casefile.findByLimsfoldernoNumdemandelims", Casefile.class);
        q.setParameter("limsfolderno", limsfolderno);
        q.setParameter("numdemandelims", numdemandelims);
        List<Casefile> casefiles =q.getResultList();
        if(casefiles.isEmpty()){
            return null;
        }
        c=casefiles.get(0);
        return c;
    }
    
}
