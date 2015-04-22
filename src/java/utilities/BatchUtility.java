/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Article;
import entite.Batch;
import entite.Company;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class BatchUtility {
    @Inject BatchFind batchFind;
    
    @Inject ArticleUtility articleUtility;
    
    
    public Batch createBatch(String idspecie, String idvariety, String idstage, String idgeneration, String batchname, String companyname) {

        Article idarticle=articleUtility.createOrUpdateArticle(  idspecie, idvariety,idgeneration, idstage);
        return createBatch(batchname,idarticle, companyname);
    }
    
    public Batch createOrRetrieveBatch(String idspecie, String idvariety, String idstage, String idgeneration, String batchname, String companyname) {
        Article idarticle=articleUtility.createOrUpdateArticle(  idspecie, idvariety,idgeneration, idstage);
        BigInteger nullLimsbatchid=null;
        return createOrRetrieveBatch(batchname,idarticle, companyname, nullLimsbatchid);
    }
    
    
    

    public Batch createOrRetrieveBatch(String batchname, String articlename, String idcompany, BigInteger limsbatchid) {
        Article idarticle= articleUtility.createOrUpdateArticle(articlename);
        return createOrRetrieveBatch(batchname, idarticle, idcompany, limsbatchid);
    }
    
    
    public Batch createOrRetrieveBatch(String batchname, Article idarticle, String idcompany, BigInteger limsbatchid) {
         Batch b = null;
        List<Batch> batchsList =null;
        System.out.println("entrer dans Facade Create batch");
        batchsList = batchFind.findExistingBatchByLimsBatchId(limsbatchid);
        
        if(batchsList.isEmpty()){
            return createBatch(batchname, idarticle, idcompany, limsbatchid);
        }
        return batchsList.get(0);
    }
    
        public Batch createBatch(String batchName, Article idarticle, String companyName){ // {, String limsbatchid) {
            Batch batch =new Batch();
            batch.setBatchname(batchName);
            Company company =new Company(companyName);
            batch.setIdcompany(company);
            batch.setIdarticle(idarticle); 

            batch.setIdspecie(idarticle.getIdspecie());

            batch.setIdvariety(idarticle.getIdvariety());

            batch.setIdgeneration(idarticle.getIdgeneration());

            batch.setIdstage(idarticle.getIdstage());
                       
            return batch;

    }
        
    public Batch createBatch(String batchName, Article idarticle, String companyName, BigInteger limsbatchid) {
            Batch batch =createBatch(batchName, idarticle, companyName);
            batch.setLimsbatchid(limsbatchid);                      
            return batch;

    }    
}
