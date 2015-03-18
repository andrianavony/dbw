/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author S.ANDRIANAVONY
 * 
 * S0101S10096C04_A
 * 

 */
public class ForItem {
    public static String getIdSpecie(String IdArticle ){
        if (null==IdArticle){
            return "";
        }
        return IdArticle.substring(0,5);
    }
    
    public static String getIdVariety(String IdArticle ){
        if (null==IdArticle){
            return "";
        }
        return IdArticle.substring(5,11);
    }
    
    public static String getIdGeneration(String IdArticle ){
        if (null==IdArticle){
            return "";
        }
        return IdArticle.substring(11,14);
    }
    
    public static String getIdStage(String IdArticle ){
        if (null==IdArticle){
            return "";
        }
        if(IdArticle.length()==14){
        return "COM";
        }
        
        if(IdArticle.endsWith("_KG")){
        return "COM";
        }
        
        return IdArticle.substring(15,IdArticle.length());
    }

}
