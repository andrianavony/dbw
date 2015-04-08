/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Generation;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import entite.VarietyPK;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.validator.internal.util.Contracts;
import utilities.ForItem;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class CreateOrUpdateArticle {
   @PersistenceContext
    protected EntityManager em;
    
   public Article createOrUpdateArticle (String idarticle){
       if (idarticle==null){
           return null;
       }
        String idspecie = ForItem.getIdSpecie(idarticle);
        String idvariety = ForItem.getIdVariety(idarticle);
        String idstage = ForItem.getIdStageFromItem(idarticle);
        String idgeneration=ForItem.getIdGeneration(idarticle);
        return createOrUpdateArticle ( idarticle,  idstage,  idspecie,  idvariety,idgeneration);
    }
   
   public Article getArticleByVarietyStageLagel(String idvariety, String stageLabel, String idGeneration) {
       
        String idStage = ForItem.getIdStageFromStageLabel(stageLabel);
        TypedQuery<Article> query = em.createNamedQuery("Article.findByVarietyStadeGeneration", Article.class);
            query.setParameter("idvariety", idvariety);
            query.setParameter("idstage", idStage);
            query.setParameter("idgeneration", idGeneration);
            
        List<Article> articleList =query.getResultList();
        
        if(articleList.isEmpty()){
            return null;
        }else {
            return articleList.get(0);
        }
                
    }
     
   public Article createOrUpdateArticle ( String idspecie, String idvariety,String idgeneration, String idstage){
       String idarticle = ForItem.getIdArticle(idspecie, idvariety,idgeneration, idstage);
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

    /***
     * une variete n'appartent qu à un seul espece
     */
    
    public Variety getArticleByVariety(String idvariety) {
        VarietyPK varietyPK = new VarietyPK();
        varietyPK.setIdvariety(idvariety);
        TypedQuery<Variety> query = em.createNamedQuery("Variety.findByIdvariety", Variety.class);
            query.setParameter("idvariety", idvariety);
            List<Variety> varietyList =query.getResultList();
        
        if(varietyList.isEmpty()){
            return null;
        }else {
            return varietyList.get(0);
        }
    }

    public Variety getArticleBySpecieVariety(String idspecie, String idvariety) {
        
        TypedQuery<Variety> query = em.createNamedQuery("Variety.findByIdSpecieIdVariety", Variety.class);
            query.setParameter("idspecie", idspecie);
            query.setParameter("idvariety", idvariety);
            List<Variety> varietyList =query.getResultList();
        
        if(varietyList.isEmpty()){
            return null;
        }else {
            return varietyList.get(0);
        }
    }
    
}
