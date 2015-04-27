/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import objet.metier.creation.LectureResultesTemp;
import javax.ejb.embeddable.EJBContainer;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class LectureResultesTempNGTest {
    
    public LectureResultesTempNGTest() {
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
     * Test of process method, of class LectureResultesTemp.
     */
    @Test
    public void testProcess() throws Exception {
        System.out.println("process");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
        LectureResultesTemp instance = (LectureResultesTemp)container.getContext().lookup("java:global/classes/LectureResultesTemp");
        instance.process();
        }finally{
        container.close();
        }

    }
    
}
