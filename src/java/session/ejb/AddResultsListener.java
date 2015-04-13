/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Batch;
import entite.Company;
import entite.Results;
import entite.Wo;
import entite.Traca;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.TypedQuery;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class AddResultsListener {
    public AddResultsListener(){        
    }
    @PersistenceContext ()
    protected EntityManager em;
    
    private entite.Results resultatInserted;
    
    @Inject I_FacadeSaisieResultats facadeSaisieResultats;
    
    @PostPersist
    public void heritageDesResultats(entite.Results resultatInserted){
        
        System.out.println(" saisie résultats de "+resultatInserted.getAnalysisname() + " avec la valeur " + resultatInserted.getRawresults());
       this.resultatInserted=resultatInserted;
        List<entite.Batch> descendantsList= listBatchDescendants();
        if(null==descendantsList){
            return;
        }
        for (entite.Batch descendantsBatch: descendantsList ){
            facadeSaisieResultats.copieResultats(resultatInserted,descendantsBatch,"heritage");
        }
        
    }
    
    /**
     * @return the resultatInserted
     */
    public entite.Results getResultatInserted() {
        return resultatInserted;
    }

    /**
     * @param resultatInserted the resultatInserted to set
     */
    public void setResultatInserted(entite.Results resultatInserted) {
        this.resultatInserted = resultatInserted;
    }
    
    /***
     * trouve les lots qui ont été produits a partir du lot du résultats d'analyse
     * OF028712
     **/
    public List<entite.Batch> listBatchDescendants(){
        Batch batchPereSaisie=resultatInserted.getIdbatch();
        List<entite.Traca> woProduction = listeWoProduction (batchPereSaisie);
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

    

    
}
