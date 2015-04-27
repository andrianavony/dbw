/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet.metier.creation;

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
import org.hibernate.validator.internal.util.Contracts;
import session.ejb.I_FacadeSaisieResultats;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateful
public class LectureResultesTemp {
@PersistenceContext ()
    protected EntityManager em;    
 
@Inject I_FacadeSaisieResultats facadeSaisieResultats;

/*
    private BigInteger bi_Idbatch=null;
    private String limsfolderno=null;
    private String limssampleid=null;
    private BigInteger limsanalysisorigrec=null;
    private BigInteger limsidanalysis=null;
    private String analysisname=null;
    private String methodname=null;
    private BigInteger limsidseries=null;
*/
    
    entite.Batch batch=null;
    entite.Casefile casefile=null;
    entite.Samples samples=null;
    entite.Analysis analysis=null;
    entite.Results results=null;
        
public void process(){
 
    TypedQuery<entite.Resultstemp> q = em.createNamedQuery("Resultstemp.findByIsresultsinserted", entite.Resultstemp.class);
    q.setParameter("isresultsinserted", false);
    List<Resultstemp> listeResults=q.getResultList();
    
    
    process(listeResults);
}
    
    public void process(List<Resultstemp> listeResults){
        System.out.println( "**************************************************************************************************************** nouvelle "+analysis);
    for(Resultstemp result : listeResults ){
        proccesResult( result);
    }
    if(! listeResults.isEmpty()){
        doHeritage();
    }        
}
    
    public void proccesResult(entite.Resultstemp result){
        System.out.println(result.getIdresult()+ " ******************************************************************************************************************  entrer dans proccesResult pour le lot "+result.getIdbatch());
        System.out.println(result.getIdresult()+ "**************************************************************************************************************** nouvelle "+analysis);
        if(estUnNouveauLot(result)) {
            try {
                batch=facadeSaisieResultats.retrieveBatchFromIdBatch(result.getIdbatch());
            } catch (BatchIdNotFindError ex) {
                Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Contracts.assertNotNull(batch);
        if(estUnNouveauDossierLot(result)) {
            try {
                casefile=facadeSaisieResultats.createOrRetrieveCasefile(batch, result.getLimsfolderno(),1);
            } catch (BatchIdNotFindError ex) {
                Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);            
            }
        }
        Contracts.assertNotNull(casefile);
        
        if(estUnNouveauSample(result)) {
            try {
                    samples=facadeSaisieResultats.createSample(casefile, result.getLimssampleid());
                } catch (SampleWithoutCasefileError ex) {
                    Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        Contracts.assertNotNull(samples);
        
        System.out.println(result.getIdresult()+ "**************************************************************************************************************** apres sample analysis "+analysis);

        if(estUnNouvelleAnalyses(result)) {
            System.out.println(result.getIdresult()+ "**************************************************************************************************************** estUnNouvelleAnalyses "+analysis);
            if( null != analysis) {
                em.flush();
                System.out.println(" avant demande de heritage "+analysis.getIdanalysis());
                //entite.Analysis  a = facadeSaisieResultats.getAnalysisCurrent();
                //System.out.println("**************************************************************************************************************** avant Heritage Analyse dans analyseManager  "+a.getIdanalysis());
                System.out.println("**************************************************************************************************************** avant Heritage Analyse dans analyseManager  ");
                doHeritage();
                
            }
            System.out.println(result.getIdresult()+ "**************************************************************************************************************** nouvelle Creation Analyse "+analysis);
            try {
                analysis=facadeSaisieResultats.createAnalysisViaInfoLims(samples, result.getLimsanalysisorigrec(), result.getLimsidanalysis(),result.getAnalysisname(),result.getMethodname(), result.getLimsidseries());
                System.out.println(result.getIdresult()+ "****************************************************************************************************************  Creation Analyse "+analysis);
            } catch (AnalysisWithoutSamplesError ex) {
                Logger.getLogger(LectureResultesTemp.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }else{
            System.out.println("************************************************************************************************************************************* ELSE (PAS) *** nouvelle "+analysis);
        }
        
        System.out.println(" demande de saisie résultats pour "+result.getMeasurename() );
            //(idsamples, limsanalysisorigrec, limsanalysisid, analysisname,  methodname, limsidseries)
            analysis=facadeSaisieResultats.saisirResultatIssusLims
               (analysis, result.getLimsanalysisorigrec(), result.getMeasurename(), result.getLimsmeasureid(), result.getRawresults(), result.getFormated(), result.getRepetition(), result.getUsername(), result.getDateofentry(), result.getStatuslabel());
            result.setIsresultsinserted(Boolean.TRUE);
            em.merge(result);
            System.out.println("****************************************************************************************************************" );
            System.out.println(result.getIdresult()+ "**************************************************************************************************************** apres sample analysis "+analysis);
        System.out.println("************************************************************ FINI ****************************************************" );
    
    
    }

    public void doHeritage() {
        facadeSaisieResultats.doHeritage();
    }

    public boolean estUnNouveauLot(Resultstemp result) {
        if(null==batch){
            return true;
        }
        if(batch.getIdbatch().compareTo(result.getIdbatch())==0){
            return false;
        }
        return true;
    }

    public boolean estUnNouveauDossierLot(Resultstemp result) {
     if(null==casefile){
            return true;
        }
        if(casefile.getLimsfolderno().equalsIgnoreCase(result.getLimsfolderno())){
            return false;
        }
        return true;
    }


    private boolean estUnNouveauSample(Resultstemp result) {
        if(null==samples){
            return true;
        }
        if(samples.getLimssampleid().equalsIgnoreCase(result.getLimssampleid())){
            return false;
        }
        return true;
    }

    private boolean estUnNouvelleAnalyses(Resultstemp result) {
        if(null==analysis){
            System.out.println(" treu analysis null");
            return true;
        }
        if(analysis.getLimsidanalysis().compareTo(result.getLimsidanalysis())==0){
            System.out.println("false car "+ analysis.getLimsidanalysis() + " ==   "+result.getLimsidanalysis());
            return false;
        }
        System.out.println(" true par defaut  " +analysis.getLimsidanalysis() + " et "+result.getLimsidanalysis());
        return true;
    }
    
}

