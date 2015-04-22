/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Results;
import javax.ejb.Stateless;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class ResultsUtility {

    public static Results getCopieResults(Results m) {
        Results c = new Results();
        c.setCopiedfromidanalysis(m);
        c.setRawresults(m.getRawresults());
        c.setRepetition(m.getRepetition());
        c.setSubrepetition(m.getSubrepetition());
        c.setAnalysisname(m.getAnalysisname());
        c.setBatchname(m.getBatchname());
        
        return c;
    }
    
}
