/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Article_;
import entite.Batch;
import entite.Company;
import entite.Generation;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilities.ForItem;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class BatchManager {
   @PersistenceContext
    protected EntityManager em;
   
   @Inject CreateOrUpdateArticle createOrUpdateArticle;
    
            
    public Article createOrUpdateArticle (String idarticle, String idstage, String idspecie, String idvariety,String idgeneration){
        Article a = new Article (idarticle);
        Stage stage=new Stage(idstage);
        Specie specie = new Specie(idspecie);
        Variety variety = new Variety(idvariety, idspecie);
        Generation generation = new Generation(idgeneration);
        //Specie specie=new Specie(idspecie);
        //em.merge(specie);
        a.setIdspecie(specie);
        a.setIdvariety(variety);
        a.setIdstage(stage);
        a.setIdgeneration(generation);
        return createOrUpdateArticle(a);
    }
    protected Article createOrUpdateArticle(Article article){
        return em.merge(article);
    }

    Batch createOrUpdateBatch(String batchName, String idCompagny, String idstage, String idspecie, String idvariety,String idgeneration) {
        Article article=createOrUpdateArticle.createOrUpdateArticle(  idspecie, idvariety,idgeneration, idstage);
        
        return null;
    }

    Batch createBatch(String idvariety, String stageLabel, String idgeneration, String batchName, String idCompagny) {
        Article article= createOrUpdateArticle.getArticleByVarietyStageLagel(idvariety, stageLabel, idgeneration);
        Batch batch =new Batch();
        batch.setBatchname(batchName);
        Company company =new Company(idCompagny);
        batch.setIdcompany(company);
        batch.setIdarticle(article);
        em.merge(batch);
        return batch;
    }

    Batch getBatchCurrent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addresults(String humidityPc, Double humidityPc0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
