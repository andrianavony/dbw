/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import entite.Generation;
import entite.Results;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import javax.ejb.LocalBean;
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
public class CreateResultsDauphinoise {
   @PersistenceContext
    protected EntityManager em;
   //*************************
   // Pourl acreation du lot
   //*************************
   final String  idGeneration ="C04";
   final String idCompany="lvh";
   String idvariety;
   String batchName;
   String stageLabel;
   //*************************

   String yearHaverest;
   String producer;
   String fieldName;
   String batchFather;
   Double kgQuantitiesAssembly;
   Double kgWeight;
   Integer numberOfDose50MGR;
   Double humidityPc;
   Double pmg;
   Double fgDef;
   Double fgMorts;
   Double fgAnormaux;
   Double ctDef;
   Double ctMorts;
   Double ctAnormaux;
   Double PuretéSpécifiquePc;
   Double MatièresInertesPc;
   Double CassésPc;
   Double RongésPc;
   Double ContaminésPc;
   Double EchaudésPc;
   Double ImmaturesPc;
   Double PrégermésPc;
   Double GermésPc;
   Double EclatésPc;
   Double FendusPc;
   Double StriésPc;
   Double ImpuretésRaflesPc;
   Double ImpuretésGrainsPc;
   //AUTRES ESPECES		
   Double SemencesAutresPlantes;
   Double NombreAutresEspèceKg;
   Double IdentificationDesAutresEspèces;
   // HOMOGENEITE & TRAITEMENT
   String HomogénéitéDesCalibres;
   String TraitementUtilisé;
   String NoteDeTraitement;
   String observation;


   String idmeasure;
   
   @Inject BatchManager batchManager; 
   
   
   
   public Batch createtBatch(){
       batchManager.createBatch(idvariety, stageLabel, idGeneration, batchName, idCompany);
       return batchManager.getBatchCurrent();
   }
   
   public Batch process(){
       batchManager.addresults("humidityPc", humidityPc);
       return batchManager.getBatchCurrent();
   }
   
   
   
    
   public Results CreateOrUpdateResultsanalysis (String idarticle){
       if (idarticle==null){
           return null;
       }
        String idspecie = ForItem.getIdSpecie(idarticle);
        String idvariety = ForItem.getIdVariety(idarticle);
        String idstage = ForItem.getIdStageFromItem(idarticle);
        String idgeneration=ForItem.getIdGeneration(idarticle);
        return CreateOrUpdateResultsanalysis ( idarticle,  idstage,  idspecie,  idvariety,idgeneration);
    }
            
    public Results CreateOrUpdateResultsanalysis (String idarticle, String idstage, String idspecie, String idvariety,String idgeneration){
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
        return CreateOrUpdateResultsanalysis( a);
    }
    protected Results CreateOrUpdateResultsanalysis(Article article){
        return null;// em.merge(article);
    }
}
