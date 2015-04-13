/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Resultstemp;
import java.math.BigInteger;
import java.util.List;
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
    
    entite.Batch batch;
    entite.Casefile casefile;
    entite.Samples samples;
    entite.Analysis analysis;
    entite.Results results;

    for(Resultstemp result : listeResults ){
        batch=facadeSaisieResultats.createBatch(result.getIdbatch());
        casefile=facadeSaisieResultats.createCasefile(batch, result.getLimsfolderno(),1);
        samples=facadeSaisieResultats.createSample(casefile, result.getLimssampleid());
        analysis=facadeSaisieResultats.createAnalysisViaInfoLims(samples, result.getLimsanalysisorigrec(), result.getLimsidanalysis(),result.getAnalysisname(),result.getMethodname(), result.getLimsidseries());
        //(idsamples, limsanalysisorigrec, limsanalysisid, analysisname,  methodname, limsidseries)
        analysis=facadeSaisieResultats.saisirResultatIssusLims
       (analysis, result.getLimsanalysisorigrec(), result.getMeasurename(), result.getLimsmeasureid(), result.getRawresults(), result.getFormated(), result.getRepetition(), result.getUsername(), result.getDateofentry(), result.getStatuslabel());
    }
    
}

}
