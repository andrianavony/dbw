/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Results;
import java.math.BigInteger;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class ElementaryResults {
    
    BigInteger idAnalysis;
    BigInteger idMesure;
    String rawResults;
    BigInteger idUser;
            
    public ElementaryResults(){}
    
    public ElementaryResults(BigInteger idAnalysis, BigInteger idMesure, String rawResults, BigInteger idUser ){
    this.idAnalysis=idAnalysis;
    this.idMesure=idMesure;
    this.rawResults=rawResults;
    this.idUser=idUser;
    
    }
    
}
