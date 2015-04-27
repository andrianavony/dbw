/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Reprensente une ligne à prendre en charge dans la table des resultats temporaire.
 * @author S.ANDRIANAVONY
 */
public class ResultsTempTampon {
    
    private BigInteger batch;
    private String limsfolderno;
    private String limssampleid;
    private BigInteger limsanalysisorigrec;
    private BigInteger limsidanalysis;
    private String analysisname;
    private String methodname;
    private BigInteger limsidseries;
    
    List<ResultsTempResult> resultsTempResultList = new ArrayList<>();
    
    
    
    public ResultsTempTampon(entite.Resultstemp result){
        this.batch=result.getIdbatch();
        this.limsfolderno = result.getLimsfolderno();
        this.limssampleid =result.getLimssampleid();
        this.limsanalysisorigrec = result.getLimsanalysisorigrec();
        this.limsidanalysis= result.getLimsidanalysis();
        this.analysisname = result.getAnalysisname();
        this.methodname = result.getMethodname(); 
        this.limsidseries = result.getLimsidseries();
    }
    
    public Boolean addResultsTemp(entite.Resultstemp result){
        Boolean Ok = false;
        if(batch.compareTo(result.getIdbatch())==0){
            
        }
        return false;
    }

    public BigInteger getBatch() {
        return batch;
    }

    public void setBatch(BigInteger batch) {
        this.batch = batch;
    }

    public String getLimsfolderno() {
        return limsfolderno;
    }

    public void setLimsfolderno(String limsfolderno) {
        this.limsfolderno = limsfolderno;
    }

    public String getLimssampleid() {
        return limssampleid;
    }

    public void setLimssampleid(String limssampleid) {
        this.limssampleid = limssampleid;
    }

    public BigInteger getLimsanalysisorigrec() {
        return limsanalysisorigrec;
    }

    public void setLimsanalysisorigrec(BigInteger limsanalysisorigrec) {
        this.limsanalysisorigrec = limsanalysisorigrec;
    }

    public BigInteger getLimsidanalysis() {
        return limsidanalysis;
    }

    public void setLimsidanalysis(BigInteger limsidanalysis) {
        this.limsidanalysis = limsidanalysis;
    }

    public String getAnalysisname() {
        return analysisname;
    }

    public void setAnalysisname(String analysisname) {
        this.analysisname = analysisname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public BigInteger getLimsidseries() {
        return limsidseries;
    }

    public void setLimsidseries(BigInteger limsidseries) {
        this.limsidseries = limsidseries;
    }

    public List<ResultsTempResult> getResultsTempResultList() {
        return resultsTempResultList;
    }

    public void setResultsTempResultList(List<ResultsTempResult> resultsTempResultList) {
        this.resultsTempResultList = resultsTempResultList;
    }
    
    
}
