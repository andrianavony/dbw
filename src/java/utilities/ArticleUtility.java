/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Article;
import entite.Generation;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import entite.VarietyPK;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
public class ArticleUtility {
   
   @Inject ArticleFind articleFind; 
    
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
        
        List<Article> articleList = articleFind.findByVarietyStadeGeneration(idvariety,idStage,idGeneration);
        if(articleList.isEmpty()){
            return null;
        }else {
            return articleList.get(0);
        }
                
    }
     
   public Article createOrUpdateArticle ( String idspecie, String idvariety,String idgeneration, String idstage){
       String idarticle = ForItem.getIdArticle(idspecie, idvariety,idgeneration, idstage);
        return createOrUpdateArticle (idarticle, idstage, idspecie, idvariety,idgeneration);
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
        return a;
    }
    
    
    
    public Variety createOrRetrieveVariety(String idvariety,String  SpecieCode,String varietyname) {
        List<Variety> varietyList =articleFind.getArticleByVariety(idvariety);
        if(varietyList.isEmpty()){
            return null;
        }else {
            return varietyList.get(0);
        }
    }
    
    public Variety createVariety(String VarietyCode,String  SpecieCode,String Variety){
        Variety variety=new Variety(VarietyCode, SpecieCode);
        variety.setVarietyname(Variety);
        return variety;
    }
    
    
    /***
     * une variete n'appartent qu à un seul espece
     */
    
    public Variety getArticleByVariety(String idvariety) {
        List<Variety> varietyList =articleFind.getArticleByVariety(idvariety);
        if(varietyList.isEmpty()){
            return null;
        }else {
            return varietyList.get(0);
        }
    }

    public Variety getArticleBySpecieVariety(String idspecie, String idvariety) {
        List<Variety> varietyList =articleFind.getArticleBySpecieVariety(idspecie, idvariety);
        if(varietyList.isEmpty()){
            return null;
        }else {
            return varietyList.get(0);
        }
    }
    
}
