/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Article;
import entite.Variety;
import entite.VarietyPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class ArticleFind {

    @PersistenceContext
    protected EntityManager em;

    public List<Article> findByVarietyStadeGeneration(String idvariety, String idStage, String idGeneration) {
        TypedQuery<Article> query = em.createNamedQuery("Article.findByVarietyStadeGeneration", Article.class);
            query.setParameter("idvariety", idvariety);
            query.setParameter("idstage", idStage);
            query.setParameter("idgeneration", idGeneration);
            
        return query.getResultList();
    }
    
    public List<Variety> getArticleByVariety(String idvariety) {
        VarietyPK varietyPK = new VarietyPK();
        varietyPK.setIdvariety(idvariety);
        TypedQuery<Variety> query = em.createNamedQuery("Variety.findByIdvariety", Variety.class);
            query.setParameter("idvariety", idvariety);
        return  query.getResultList();
        }
    
    public List<Variety>  getArticleBySpecieVariety(String idspecie, String idvariety) {
        TypedQuery<Variety> query = em.createNamedQuery("Variety.findByIdSpecieIdVariety", Variety.class);
            query.setParameter("idspecie", idspecie);
            query.setParameter("idvariety", idvariety);
            return query.getResultList();
    }
        

    
}
