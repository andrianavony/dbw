/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class ResultsTempResult {
    private BigInteger limsanalysisorigrec;
    private String measurename;
    private BigInteger limsmeasureid;
    private String rawresults;
    private String formated;
    private Short repetition;
    private String username;
    private Date dateofentry;
    private String statuslabel;
    
    public ResultsTempResult(){
        
    }
    
    public ResultsTempResult(entite.Resultstemp result){
        this.limsanalysisorigrec = result.getLimsanalysisorigrec();
        this.measurename = result.getMeasurename();
        this.limsmeasureid = result.getLimsmeasureid();
        this.rawresults= result.getRawresults(); 
        this.formated = result.getFormated();
        this.repetition = result.getRepetition(); 
        this.username= result.getUsername();
        this.dateofentry =result.getDateofentry(); 
        this.statuslabel = result.getStatuslabel();
    }
}
