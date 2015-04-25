/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Batch;
import entite.Casefile;
import entite.Samples;
import java.math.BigInteger;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class SamplesManagerTest {
    
    public SamplesManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Ok create
     * Ok Retreive
     * Test of getSampleCurrent method, of class SamplesManager.
     */
    @Test
    public void testGetSampleCurrent() throws Exception {
        System.out.println("getSampleCurrent");
        System.out.println("createCasefileSample");
        Batch batch= new Batch(new BigInteger("3010"));
        BigInteger idCasefile = new BigInteger("17");
        Casefile casefile=new Casefile(idCasefile);
        casefile.setBatchname("F0964W005540NZ");
        casefile.setIdbatch(batch);
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        Samples expResult = null;
        Samples result = instance.createOrRetreiveSampleCurrent(casefile);
        assertEquals(result.getIdbatch(), batch);
        
        assertEquals(result.getIdcasefile(),casefile);
        assertEquals(result.getBatchname(), "F0964W005540NZ");
        assertNotNull(result.getIdsamples());
        
        container.close();
    }
    

    /**
     * Test of addresults method, of class SamplesManager.
     */
    @Test
    public void testAddresults() throws Exception {
        System.out.println("addresults");
        Casefile casefileCurrent = null;
        BigInteger idModelanalysis = null;
        String methodname = "";
        String mesureName = "";
        String rawresult = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        Analysis expResult = null;
        Analysis result = instance.addresults(casefileCurrent, idModelanalysis, methodname, mesureName, rawresult);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCasefile method, of class SamplesManager.
     */
    @Test
    public void testSetCasefile() throws Exception {
        System.out.println("setCasefile");
        Casefile casefileCurrent = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        instance.setCasefile(casefileCurrent);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSamples method, of class SamplesManager.
     */
    @Test
    public void testCreateSamples_String() throws Exception {
        System.out.println("createSamples");
        String limssampleid = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        Samples expResult = null;
        Samples result = instance.createSamples(limssampleid);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSamplesWithLimssampleid method, of class SamplesManager.
     */
    @Test
    public void testCreateSamplesWithLimssampleid() throws Exception {
        System.out.println("createSamplesWithLimssampleid");
        String limssampleid = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        Samples expResult = null;
        Samples result = instance.createSamplesWithLimssampleid(limssampleid);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSamples method, of class SamplesManager.
     */
    @Test
    public void testCreateSamples_0args() throws Exception {
        System.out.println("createSamples");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesManager instance = (SamplesManager)container.getContext().lookup("java:global/classes/SamplesManager");
        Samples expResult = null;
        Samples result = instance.createSamples();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
