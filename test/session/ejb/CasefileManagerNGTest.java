/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Casefile;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Constant;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class CasefileManagerNGTest {
    
    public CasefileManagerNGTest() {
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
     * Test of createOrRetriveCaseFileCurrent method, of class CasefileManager.
     */
    @Test
    public void testCreateOrRetriveCaseFileCurrent() throws Exception {
        System.out.println("createOrRetriveCaseFileCurrent");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance = (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        Casefile expResult = null;
        Casefile result = instance.createOrRetriveCaseFileCurrent();
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class CasefileManager.
     */
    @Test
    public void testMerge() throws Exception {
        System.out.println("merge");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance = (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        Casefile expResult = null;
        Casefile result = instance.merge();
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    



    /**
     * Test of addresults method, of class CasefileManager.
     */
    @Test
    public void testAddresults() throws Exception {
        System.out.println("addresults");
        BigInteger idModelanalysis = null;
        String methodname = "";
        String mesurename = "";
        String rawresults = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance = (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        Analysis expResult = null;
        Analysis result = instance.addresults(idModelanalysis, methodname, mesurename, rawresults);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of createCaseFile method, of class CasefileManager.
     */
    @Test
    public void testCreateCaseFile_String_Integer() throws Exception {
        System.out.println("createCaseFile");
        String limsfolderno = "";
        Integer numdemandelims = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance = (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        Casefile expResult = null;
        Casefile result = instance.createCaseFile(limsfolderno, numdemandelims);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    



    /**
     * Test of createOrRretriveCasefileForHeritage method, of class CasefileManager.
     */
    @Test
    public void testCreateOrRretriveCasefileForHeritage() throws Exception {
        System.out.println("createOrRretriveCasefileForHeritage");
        BigInteger bi_idbatch = new BigInteger("1649");
        Batch idbatch = new Batch(bi_idbatch);
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
            CasefileManager instance = (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
            Casefile result = instance.createOrRretriveCasefileForTypeDeCopie(idbatch, Constant.typeDeCopie.HERITAGE);
            assertEquals(result.getCasefiletype(),Constant.HERITAGE );
            assertEquals(result.getIdcasefile(),new BigInteger("7") );// apres 1 premiere mpassage
        }finally{
            container.close();
        }

    }

     /**
     * Test of findExistingCasefile method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingCasefile() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance =  (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        try{
        System.out.println("findExistingCasefile");
        
        BigInteger bi_idbatch = new BigInteger("1649");
        Batch batch = new Batch(bi_idbatch);
        
        BigInteger idcasefile =  new BigInteger("3201");
        Casefile expResult = new Casefile(idcasefile);

        Casefile result = instance.retrieveCasefile(idcasefile);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
        assertEquals(result.getIdbatch(), batch);
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of findExistingFolderno method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingFolderno() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CasefileManager instance =  (CasefileManager)container.getContext().lookup("java:global/classes/CasefileManager");
        try{
        System.out.println("findExistingFolderno");
        BigInteger bi_idbatch = new BigInteger("1649");
        Batch batch = new Batch(bi_idbatch);
        
        String limsfolderno = "E007";
        Integer numdemandelims = 7;
        BigInteger idcasefile =  new BigInteger("3201");
        Casefile expResult = new Casefile(idcasefile);
        Casefile result = instance.retrieveCasefile(limsfolderno, numdemandelims);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
        assertEquals(result.getIdbatch(), batch);
        } finally {
            container.close();
        }
    }
    
}
