/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Method;
import entite.Modelanalysis;
import entite.Results;
import entite.Samples;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AnalysisUtility;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class AnalysisManagerNGTest {
    
    public AnalysisManagerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

  
 
  

    


    /**
     * Test of validation method, of class AnalysisManager.
     */
    @Test
    public void testValidation() throws Exception {
        System.out.println("validation");
        Analysis analyseAValider = new Analysis();
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(); try{
        AnalysisManager instance = (AnalysisManager)container.getContext().lookup("java:global/classes/AnalysisManager");
        Analysis expResult = null;
        //Analysis result = 
                instance.validation(analyseAValider);
        //assertEquals(result, expResult);
        } finally {container.close();}
        
    }
    
}
