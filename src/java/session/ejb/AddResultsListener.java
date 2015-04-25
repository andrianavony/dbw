/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Company;
import entite.Results;
import entite.Traca;
import entite.Wo;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.TypedQuery;
import utilities.AnalysisUtility;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class AddResultsListener {

    @PersistenceContext ()
    public EntityManager em;
    
    //private entite.Results resultatInserted;
    
    @Inject RecopieAnalysis recopieAnalysis;
   
    @Inject 
    //@EJB
             public Find find;
    
    
    
    
    public AddResultsListener(){
        System.out.println(" Creation AddResultsListener debut =================================================**********************************************"+find);
        
        /*
        try {
           
            find = InitialContext.doLookup("java:global/classes/Find!session.ejb.Find");//java:global/classes/Find!session.ejb.Find, java:global/classes/Find
        } catch (NamingException ex) {
            Logger.getLogger(AddResultsListener.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(" Creation AddResultsListener FIN =================================================**********************************************"+find);
//         System.out.println(" Ceration AddResultsListener =========================================="+find.em);
       */ 
    
    }
    
    @PostConstruct
    public void log(){
        System.out.println(" Post creation Ceration AddResultsListener =================================================***************************************"+find);
    }
        
    
    public void heritageDesResultats(entite.Results resultatInserted){
        
        System.out.println(" saisie résultats de "+resultatInserted.getIdresult()+ " avec la valeur " + resultatInserted.getRawresults());
       

        System.out.println(" *************** Saotra Find dans AddResultsListener ====================================================="+em);
        System.out.println(" *************** Saotra Find dans AddResultsListener=====================================================************************************************" + find);
        System.out.println(" *************** Saotra Find dans AddResultsListener=====================================================");

       Batch batch= find.getIdBatch(resultatInserted);
        List<entite.Batch> descendantsList= find.getListBatchDescendants(batch);
        if(null==descendantsList){
            return;
        }
        System.out.println("==================================================== descendantsList.size()  "+descendantsList.size());
        for (entite.Batch descendantsBatch: descendantsList ){
            System.out.println("Insertion heritage dans "+descendantsBatch);
            //facadeSaisieResultats.copieResultats(resultatInserted,descendantsBatch,Constant.typeDeCopie.HERITAGE, );
        }
        
    }
    
    
    /*
    public List<entite.Traca> listeWoProduction(Batch batchProduit) {
        return find.listeWoProduction(batchProduit);
    }

    public List<Batch>  getBatchFromTraca(Traca traca) {
        return find.getBatchFromTraca(traca);
    }

    public List<Batch> getListBatchDescendants(Results resultatInserted) {
        return find.getListBatchDescendants(resultatInserted.getIdbatch());
    }
*/
    public List<Batch> getListBatchDescendants(Results resultatInserted) {
        return getListBatchDescendants(resultatInserted.getIdbatch());
    }
    
    public List<entite.Traca> listeWoProduction(Batch batchProduit) {
        if(null == batchProduit){
            return null;
        }
        Wo idWo= batchProduit.getIdwo();
        Company idcompany =batchProduit.getIdcompany();
        System.out.println("idWo "+idWo);
        System.out.println("idcompany"+idcompany);
        TypedQuery<entite.Traca> q = em.createNamedQuery("Traca.findByIdwo_Production", entite.Traca.class);
        q.setParameter("idwo", idWo); 
        q.setParameter("idcompany", idcompany.getIdcompany());
        List<entite.Traca> tmp=q.getResultList();
        System.out.println("q "+q);
        return tmp;
        
    }
    
    public List<Batch>  getBatchFromTraca(Traca traca) {
        TypedQuery<Batch> q =em.createNamedQuery("Batch.findByIdarticleBatchnameCompanynameIdWo", Batch.class);
        q.setParameter("batchname",traca.getBatchname() ); 
        q.setParameter("idarticle", traca.getIdarticle()); 
        q.setParameter("idcompany", traca.getIdcompany());
        String idwo =traca.getIdwo().getWoPK().getIdwo();
        System.out.println("idwo "+idwo);
        q.setParameter("idwo", traca.getIdwo());
        
        return q.getResultList(); 
        
    }
    
    /***
     * trouve les lots qui ont été produits a partir du lot du résultats d'analyse
     * OF028712
     **/
    public List<entite.Batch> getListBatchDescendants(Batch lotParent){
        
        List<entite.Traca> woProduction = listeWoProduction (lotParent);
        if(null==woProduction){
            return null;
        }
        if(woProduction.isEmpty()){
            return null;
        }
        
        List<entite.Batch> descendants = null; //new ArrayList<>(woProduction.size());
        for(entite.Traca traca : woProduction){
            System.out.println(" traca trouver "+traca );
            descendants=getBatchFromTraca(traca);
            System.out.println("descendants "+descendants.size());
        }
        
        return descendants;
    }

    public Batch getIdBatch(Results resultat) {        
        if(resultat == null){
            return null;
        }
        return getBatchByIdbatch(resultat.getIdbatch().getIdbatch());
    }
    
    public Batch getIdBatch(Analysis analysis) {        
        if(analysis == null){
            return null;
        }
        return getBatchByIdbatch(analysis.getIdbatch().getIdbatch());
    }

    public Batch getBatchByIdbatch(BigInteger bi_idbatch) {
        System.out.println(" entrer dans getBatchByIdbatch ***********************************************");
        Batch idbatch = new Batch(bi_idbatch);
        TypedQuery<Batch> q =em.createNamedQuery("Batch.findByIdbatch", Batch.class);
        q.setParameter("idbatch",idbatch );
        if(q.getResultList().isEmpty()){
            return null;
        }
        return q.getResultList().get(0); 
    }
}   

    
