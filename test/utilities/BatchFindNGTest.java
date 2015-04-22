/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Article;
import entite.Batch;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session.ejb.I_FacadeSaisieResultats;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class BatchFindNGTest {
    
    public BatchFindNGTest() {
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
     * Test of findExistingBatchByLimsBatchId method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingBatchByLimsBatchId() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance =  (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        try{
        System.out.println("findExistingBatchByLimsBatchId");
        String limsbatchid = "80604";
        BigInteger idbatch = new BigInteger("10");
        Batch expResult = new Batch(idbatch) ;
        
        List<Batch>   result = instance.findExistingBatchByLimsBatchId(limsbatchid);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), expResult);
        assertEquals(result.get(0).getBatchname(), "FR26AV13S01010184");
        } finally {
            container.close();
        }
    }

    /**
     * Test of findBatchExisting method, of class BatchFind.
     */
    @Test
    public void testFindBatchExisting() throws Exception {
        System.out.println("findBatchExisting");
        String batchName = "";
        String idarticle = "";
        String idcompany = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance = (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        List expResult = null;
        List result = instance.findBatchExisting(batchName, idarticle, idcompany);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findExistingBatchByIdBatch method, of class BatchFind.
     */
    @Test
    public void testFindExistingBatchByIdBatch() throws Exception {
        System.out.println("findExistingBatchByIdBatch");
        BigInteger idbatch = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance = (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        List expResult = null;
        List result = instance.findExistingBatchByIdBatch(idbatch);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findExistingBatchByLimsBatchId method, of class BatchFind.
     */
    @Test
    public void testFindExistingBatchByLimsBatchId_String() throws Exception {
        System.out.println("findExistingBatchByLimsBatchId");
        String limsbatchid = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance = (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        List expResult = null;
        List result = instance.findExistingBatchByLimsBatchId(limsbatchid);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findExistingBatchByLimsBatchId method, of class BatchFind.
     */
    @Test
    public void testFindExistingBatchByLimsBatchId_BigInteger() throws Exception {
        System.out.println("findExistingBatchByLimsBatchId");
        BigInteger limsbatchid = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance = (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        List expResult = null;
        List result = instance.findExistingBatchByLimsBatchId(limsbatchid);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByIdarticleBatchname method, of class BatchFind.
     */
    @Test
    public void testFindByIdarticleBatchname() throws Exception {
        System.out.println("findByIdarticleBatchname");
        String batchname = "";
        Article article = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchFind instance = (BatchFind)container.getContext().lookup("java:global/classes/BatchFind");
        List expResult = null;
        List result = instance.findByIdarticleBatchname(batchname, article);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
