/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Article;
import entite.Batch;
import java.math.BigInteger;
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
public class BatchUtilityNGTest {
    
    public BatchUtilityNGTest() {
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
     * Test of createBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateBatch_6args() throws Exception {
        System.out.println("createBatch");
        String idspecie = "";
        String idvariety = "";
        String idstage = "";
        String idgeneration = "";
        String batchname = "";
        String companyname = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createBatch(idspecie, idvariety, idstage, idgeneration, batchname, companyname);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrRetrieveBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateOrRetrieveBatch_6args() throws Exception {
        System.out.println("createOrRetrieveBatch");
        String idspecie = "";
        String idvariety = "";
        String idstage = "";
        String idgeneration = "";
        String batchname = "";
        String companyname = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createOrRetrieveBatch(idspecie, idvariety, idstage, idgeneration, batchname, companyname);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrRetrieveBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateOrRetrieveBatch_4args_1() throws Exception {
        System.out.println("createOrRetrieveBatch");
        String batchname = "";
        String articlename = "";
        String idcompany = "";
        BigInteger limsbatchid = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createOrRetrieveBatch(batchname, articlename, idcompany, limsbatchid);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrRetrieveBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateOrRetrieveBatch_4args_2() throws Exception {
        System.out.println("createOrRetrieveBatch");
        String batchname = "";
        Article idarticle = null;
        String idcompany = "";
        BigInteger limsbatchid = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createOrRetrieveBatch(batchname, idarticle, idcompany, limsbatchid);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateBatch_3args() throws Exception {
        System.out.println("createBatch");
        String batchName = "";
        Article idarticle = null;
        String companyName = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createBatch(batchName, idarticle, companyName);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBatch method, of class BatchUtility.
     */
    @Test
    public void testCreateBatch_4args() throws Exception {
        System.out.println("createBatch");
        String batchName = "";
        Article idarticle = null;
        String companyName = "";
        BigInteger limsbatchid = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchUtility instance = (BatchUtility)container.getContext().lookup("java:global/classes/BatchUtility");
        Batch expResult = null;
        Batch result = instance.createBatch(batchName, idarticle, companyName, limsbatchid);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
