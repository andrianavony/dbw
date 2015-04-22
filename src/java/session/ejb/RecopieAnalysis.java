/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis ;
import entite.Batch;
import entite.Samples;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import utilities.AnalysisUtility;
import utilities.CasefileUtility;
import utilities.Constant;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class RecopieAnalysis {

    @Inject Find find;
    
    @Inject CasefileUtility casefileUtility;
    
    @Inject AnalysisUtility analysisUtility;
    
    public void doHeritage(Analysis analysisEvent) {
        if(null==analysisEvent){
            return;
        }
        List<Batch> batchList =find.getListBatchDescendants(analysisEvent.getIdbatch());
        if(null==batchList){
            return;
        }
        doHeritage(analysisEvent,batchList);
    }

    public void doHeritage(Analysis analysisEvent, List<Batch> batchList) {
        if(null==batchList){
            return;
        }
        for(Batch b : batchList){
            doHeritage(analysisEvent, b);
        }
        
    }

    public void doHeritage(Analysis analysisACopier, Batch idbatch) {
       Samples samples =casefileUtility.createOrRetriveSampleForTypeDeCopie(idbatch,Constant.typeDeCopie.HERITAGE);
       doHeritage( analysisACopier,  samples) ;
    }
    
    public void doHeritage(Analysis analysisACopier, Samples samples) {
        analysisUtility.copierAnalysis(analysisACopier, samples, Constant.typeDeCopie.HERITAGE);
    }
}
