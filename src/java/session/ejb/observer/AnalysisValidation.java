/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb.observer;

import entite.Analysis;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import session.ejb.RecopieAnalysis;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class AnalysisValidation {
    
    @Inject RecopieAnalysis recopieAnalysis;

    public void onAnalysis(@Observes(during = TransactionPhase.AFTER_SUCCESS) Analysis analysisEvent){
        //analysisManager.doOnAnalysis(event);
        System.out.println(" dans Facade declenchement evenement " + analysisEvent.getIdanalysis());
        if(analysisEvent.getHerited()){
            recopieAnalysis.doHeritage(analysisEvent);
        }
    }
}
