/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import entite.Company;
import entite.Company_;
import entite.Variety;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
@LocalBean
public class BatchManager {
   @PersistenceContext ()
    protected EntityManager em;
   
   @Inject CreateOrUpdateArticle createOrUpdateArticle;
   
   
   
           
   
   @Inject
   CasefileManager casefileManagerCurrent;
    
   Batch batchCurrent;
           
   public BatchManager(){
       
   }
   
   
   
    public Batch createOrUpdateBatch(String idspecie, String idvariety, String idstage, String idgeneration, String batchname, String companyname) {
        Article idarticle=createOrUpdateArticle(  idspecie, idvariety,idgeneration, idstage);
        return createOrUpdateBatch(batchname,idarticle, companyname);
    }

    public Batch createOrUpdateBatch(String idvariety, String stageLabel, String idgeneration, String batchName, String compagnyName) {    
        Article article=getArticleByVarietyStageLagel(idvariety, stageLabel, idgeneration);
        System.out.println(stageLabel + " stageLabel => "+article);
        if(null==article){
            return null;
        }
        return createOrUpdateBatch(batchName,article,compagnyName);
    }
    
    public List<Batch> fingBatchExisting(String batchName,String idarticle,String idcompany){
        TypedQuery<Batch> query = em.createNamedQuery("Batch.findByIdarticleBatchnameCompanyname", Batch.class);
            query.setParameter("batchname", batchName);
            query.setParameter("idarticle", idarticle);
            query.setParameter("idcompany", idcompany);
            System.out.println(" Query "+query);
            System.out.println("batchName "+batchName);
            System.out.println("idarticle "+idarticle);
            System.out.println("companyName "+idcompany);
            List<Batch> batchsList =query.getResultList();
            System.out.println("dans fingBatchExisting isEmpty "+batchsList.isEmpty());
            return batchsList;
    }
    
    public Batch createOrUpdateBatch(String batchName,String idarticle,String companyName){     
        List<Batch> batchsList= fingBatchExisting(batchName,idarticle,companyName);
        if(batchsList.isEmpty()){
            Article article = createOrUpdateArticle.createOrUpdateArticle(idarticle);
            return createBatch(batchName,article,companyName);
        }
        else return batchsList.get(0);
    }
    
    public Batch createOrUpdateBatch(String batchName,Article idarticle,String companyName){
        List<Batch> batchsList= fingBatchExisting(batchName,idarticle.getIdarticle(),companyName);
        
        if(batchsList.isEmpty()){
            return createBatch (batchName,idarticle,companyName);
        } else {
            batchCurrent = batchsList.get(0);
        }    
        return batchCurrent;

    }

    public Batch getBatchCurrent() {
        return batchCurrent;
    }

    public entite.Analysis addresults( BigInteger idModelanalysis,String methodname, String mesurename, String rawresults) {
        entite.Casefile casefile= createOrRetriveCaseFileCurrent(batchCurrent); 
        return casefileManagerCurrent.addresults( idModelanalysis, methodname, mesurename, rawresults);
    }

    public Article getArticleByVarietyStageLagel(String idvariety, String stageLabel, String idgeneration) {
        return createOrUpdateArticle.getArticleByVarietyStageLagel(idvariety, stageLabel, idgeneration);
        
    }

    public Article createOrUpdateArticle(String idspecie, String idvariety, String idgeneration, String idstage) {
        return createOrUpdateArticle.createOrUpdateArticle(idspecie, idvariety, idgeneration, idstage);
    }

    public  entite.Casefile createOrRetriveCaseFileCurrent(Batch batch) {
        entite.Casefile casefile = casefileManagerCurrent.createOrRetriveCaseFileCurrent(batch);
        return casefile;
    }

    public Batch createBatch(String batchName, Article idarticle, String companyName) {
            Batch batch =new Batch();
            batch.setBatchname(batchName);
            Company company =new Company(companyName);
            System.out.println("dans Creation Batch createOrUpdateBatch 3 args company "+company);
            batch.setIdcompany(company);
            batch.setIdarticle(idarticle);
            
            Contracts.assertNotNull(idarticle.getIdspecie());
            batch.setIdspecie(idarticle.getIdspecie());
            Contracts.assertNotNull(idarticle.getIdvariety());
            batch.setIdvariety(idarticle.getIdvariety());
            Contracts.assertNotNull(idarticle.getIdgeneration());
            batch.setIdgeneration(idarticle.getIdgeneration());
            Contracts.assertNotNull(idarticle.getIdstage());
            batch.setIdstage(idarticle.getIdstage());

            batchCurrent = em.merge(batch);
            /*
            em.flush();
            query=(TypedQuery<Batch>) em.createQuery("Update Batch b set b.idcompany = :company where b.idbatch = :batch");
            query.setParameter("company", company);
            query.setParameter("batch", batchCurrent.getIdbatch());
            query.executeUpdate();
            System.out.println(batchCurrent.getIdbatch() +" MAJ nom Company faite " +company);
            //em.merge(batchCurrent);
            em.flush();
            em.merge(batchCurrent);
            */        
            //entite.Casefile tmp = casefileManagerCurrent.createOrRetriveCaseFileCurrent(batchCurrent);
            
            
            return batchCurrent;

    }
    
    
}
