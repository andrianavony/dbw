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
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilities.ForItem;

/**
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
        String idstage = ForItem.getIdStage(idarticle);
        String idgeneration=ForItem.getIdGeneration(idarticle);
        return createOrUpdateArticle ( idarticle,  idstage,  idspecie,  idvariety,idgeneration);
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
}
