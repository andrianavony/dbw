/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import entite.Generation;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import utilities.ForItem;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class TC {
    @PersistenceContext
    protected EntityManager em;

    String Stock;
    String Specie;
    String Generation;
    String Variety;
    String Var_AX;
    String Level;
    String Item;
    String Batch;
    String Year;
    String Area;
    String Producer;
    String Contrat;
    String Origin;
    String Treatment;
    String Packing;
    String AX_TKW;
    String Germination;
    String Cold_Test;
    String Germ;
    String OGM;
    String Conserv;
    String Purity;
    String TKW;
    String Quality;
    String Profile;
    String Blocked;
    String Blocked_Reason;
    String Sales_Blocked;	
    String Sales_Blocked_Reason;
    Double Production_KG;
    Double Production_MGR;
    Double Production_MGV;
    Double Stock_KG;
    Double Stock_MGR;
    Double Stock_MGV;
    Double Sales_KG;
    Double Sales_MGR;
    Double Sales_MGV;
    String Sample;
    String TKW_LIMS;
    String Germination_LIMS;
    String Cold_Test_LIMS;

    
    @Inject
    CreateOrUpdateArticle createOrUpdateArticle;
    
    public TC(){
    }
    
    public Article createOrUpdateArticle (String idarticle){
        return createOrUpdateArticle.createOrUpdateArticle (idarticle);
    }
            
    public Article createOrUpdateArticle (String idarticle, String idstage, String idspecie, String idvariety,String idgeneration){
        return createOrUpdateArticle.createOrUpdateArticle (idarticle, idstage, idspecie, idvariety,idgeneration);
    }
    protected Article createOrUpdateArticle(Article article){
        return createOrUpdateArticle.createOrUpdateArticle(article);
    }
    
    public void process(){
        Batch lot = new Batch();
        lot.setBatchname(Batch);
        lot.setIdarticle(new Article(Item));
        
        TypedQuery<Batch> query =em.createNamedQuery("Batch.findByIdarticleBatchname",Batch.class)
                .setParameter("batchname", lot.getBatchname())
                .setParameter("idarticle", lot.getIdarticle());
         List <Batch> listBatch =query.getResultList();
         Iterator<Batch> iBatch =listBatch.iterator();
         while (iBatch.hasNext()) {
            Batch nextBatch = iBatch.next();
            nextBatch.setContract(Contrat);
            if (Sample != null) {
                nextBatch.setLimsfolderno(Sample.substring(0, 9));
                em.merge(nextBatch);
            }
        }
         System.out.println("Variety ******************************************************** "+Variety);        
         String VarietyCode=Item.substring(5,11);
         System.out.println("VarietyCode ******************************************************** "+VarietyCode);
         TypedQuery<Variety> queryVariety =em.createNamedQuery("Variety.findByIdvariety",Variety.class).setParameter("idvariety", VarietyCode);
         Variety variety =queryVariety.getSingleResult();
         variety.setVarietyname(Variety);
       System.out.println("******************************************************** ");        
         System.out.println("Changement de nom pour la variete "+ VarietyCode);
         System.out.println("nouveau nom "+variety);
         System.out.println("******************************************************** ");        
         em.merge(variety);
    }
    
    public void SetInfo(String Stock,    String Specie,String Generation,
    String Variety,    String Var_AX,    String Level,    String Item,
    String Batch,    String Year,    String Area,    String Producer,
    String Contrat,    String Origin,    String Treatment,    String Packing,
    String AX_TKW,    String Germination,    String Cold_Test,    String Germ,
    String OGM,    String Conserv,    String Purity,    String TKW,
    String Quality,    String Profile,    String Blocked,    String Blocked_Reason,
    String Sales_Blocked,	    String Sales_Blocked_Reason,
    Double Production_KG,    Double Production_MGR,    Double Production_MGV,    Double Stock_KG,
    Double Stock_MGR,    Double Stock_MGV,    Double Sales_KG,    Double Sales_MGR,
    Double Sales_MGV,    String Sample,    String TKW_LIMS,    String Germination_LIMS,
    String Cold_Test_LIMS){
    this.Stock= Stock;
    this.Specie= Specie;
    this.Generation= Generation;
    this.Variety= Variety;
    this.Var_AX= Var_AX;
    this.Level= Level;
    this.Item= Item;
    this.Batch= Batch;
    this.Year= Year;
    this.Area= Area;
    this.Producer= Producer;
    this.Contrat= Contrat;
    this.Origin= Origin;
    this.Treatment= Treatment;
    this.Packing= Packing;
    this.AX_TKW= AX_TKW;
    this.Germination= Germination;
    this.Cold_Test= Cold_Test;
    this.Germ= Germ;
    this.OGM= OGM;
    this.Conserv= Conserv;
    this.Purity= Purity;
    this.TKW= TKW;
    this.Quality= Quality;
    this.Profile= Profile;
    this.Blocked= Blocked;
    this.Blocked_Reason= Blocked_Reason;
    this.Sales_Blocked= Sales_Blocked;	
    this.Sales_Blocked_Reason= Sales_Blocked_Reason;
    this.Production_KG= Production_KG;
    this.Production_MGR= Production_MGR;
    this.Production_MGV= Production_MGV;
    this.Stock_KG= Stock_KG;
    this.Stock_MGR= Stock_MGR;
    this.Stock_MGV= Stock_MGV;
    this.Sales_KG= Sales_KG;
    this.Sales_MGR= Sales_MGR;
    this.Sales_MGV= Sales_MGV;
    this.Sample= Sample;
    this.TKW_LIMS= TKW_LIMS;
    this.Germination_LIMS= Germination_LIMS;
    this.Cold_Test_LIMS= Cold_Test_LIMS;
        
    }
    
    
    
}
