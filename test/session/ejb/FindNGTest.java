/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Results;
import entite.Traca;
import java.math.BigInteger;
import java.util.List;
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
public class FindNGTest {
    
    public FindNGTest() {
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
     * Test of listeWoProduction method, of class Find.
     */
    @Test
    public void testListeWoProduction() throws Exception {
        System.out.println("listeWoProduction");
        Batch batchProduit = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        List expResult = null;
        List result = instance.listeWoProduction(batchProduit);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchFromTraca method, of class Find.
     */
    @Test
    public void testGetBatchFromTraca() throws Exception {
        System.out.println("getBatchFromTraca");
        Traca traca = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        List expResult = null;
        List result = instance.getBatchFromTraca(traca);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListBatchDescendants method, of class Find.
     */
    @Test
    public void testGetListBatchDescendants() throws Exception {
        System.out.println("getListBatchDescendants");
        Batch lotParent = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        List expResult = null;
        List result = instance.getListBatchDescendants(lotParent);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBatch method, of class Find.
     */
    @Test
    public void testGetIdBatch_Results() throws Exception {
        System.out.println("getIdBatch");
        Results resultat = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        Batch expResult = null;
        Batch result = instance.getIdBatch(resultat);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBatch method, of class Find.
     */
    @Test
    public void testGetIdBatch_Analysis() throws Exception {
        System.out.println("getIdBatch");
        Analysis analysis = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        Batch expResult = null;
        Batch result = instance.getIdBatch(analysis);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchByIdbatch method, of class Find.
     */
    @Test
    public void testGetBatchByIdbatch() throws Exception {
        System.out.println("getBatchByIdbatch");
        BigInteger bi_idbatch = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Find instance = (Find)container.getContext().lookup("java:global/classes/Find");
        Batch expResult = null;
        Batch result = instance.getBatchByIdbatch(bi_idbatch);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
