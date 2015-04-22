/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Resultstemp;
import error.AnalysisWithoutSamplesError;
import error.BatchIdNotFindError;
import error.SampleWithoutCasefileError;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class LectureResultesTemp {
@PersistenceContext ()
    protected EntityManager em;    
 
@Inject I_FacadeSaisieResultats facadeSaisieResultats;

public void process(){
 
    TypedQuery<entite.Resultstemp> q = em.createNamedQuery("Resultstemp.findByIsresultsinserted", entite.Resultstemp.class);
    q.setParameter("isresultsinserted", false);
    List<Resultstemp> listeResults=q.getResultList();
    
    entite.Batch batch=null;
    entite.Casefile casefile=null;
    entite.Samples samples=null;
    entite.Analysis analysis=null;
    entite.Results results=null;

    for(Resultstemp result : listeResults ){
        try {
            batch=facadeSaisieResultats.retrieveBatchFromIdBatch(result.getIdbatch());
        } catch (BatchIdNotFindError ex) {
            Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            continue;
        }
        try {
            casefile=facadeSaisieResultats.createOrRetrieveCasefile(batch, result.getLimsfolderno(),1);
        } catch (BatchIdNotFindError ex) {
            Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            continue;
        }
        try {
                samples=facadeSaisieResultats.createSample(casefile, result.getLimssampleid());
            } catch (SampleWithoutCasefileError ex) {
                Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            analysis=facadeSaisieResultats.createAnalysisViaInfoLims(samples, result.getLimsanalysisorigrec(), result.getLimsidanalysis(),result.getAnalysisname(),result.getMethodname(), result.getLimsidseries());
        } catch (AnalysisWithoutSamplesError ex) {
            Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            continue;
        }
            //(idsamples, limsanalysisorigrec, limsanalysisid, analysisname,  methodname, limsidseries)
            analysis=facadeSaisieResultats.saisirResultatIssusLims
               (analysis, result.getLimsanalysisorigrec(), result.getMeasurename(), result.getLimsmeasureid(), result.getRawresults(), result.getFormated(), result.getRepetition(), result.getUsername(), result.getDateofentry(), result.getStatuslabel());
        
    }
    
}

}
