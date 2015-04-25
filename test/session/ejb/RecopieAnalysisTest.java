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
import entite.Traca;
import java.math.BigInteger;
import java.util.List;
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
public class RecopieAnalysisTest {
    
    public RecopieAnalysisTest() {
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
     * Test of listeAnalyseAFaireHeriter method, of class RecopieAnalysis.
     */
    @Test
    public void testListeAnalyseAFaireHeriter() throws Exception {
        System.out.println("listeAnalyseAFaireHeriter");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Analysis> expResult = null;
        List<Analysis> result = instance.listeAnalyseAFaireHeriter();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doHeritage method, of class RecopieAnalysis.
     */
    @Test
    public void testDoHeritage_0args() throws Exception {
        System.out.println("doHeritage");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Analysis> expResult = null;
        List<Analysis> result = instance.doHeritage();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doHeritage method, of class RecopieAnalysis.
     */
    @Test
    public void testDoHeritage_Analysis() throws Exception {
        System.out.println("doHeritage");
        Analysis analysisACopier = new Analysis(new BigInteger("64"));
        analysisACopier.setIdbatch(new Batch((new BigInteger("2730"))));
        //analysisACopier.setIdcasefile(new Batch((new BigInteger("9"))));
        //analysisACopier.setIdsamples(new Batch((new BigInteger("16"))));
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Analysis> expResult = null;
        List<Analysis> result = instance.doHeritage(analysisACopier);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getListBatchDescendants method, of class RecopieAnalysis.
     */
    @Test
    public void testGetListBatchDescendants() throws Exception {
        System.out.println("getListBatchDescendants");
        Batch lotParent = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Batch> expResult = null;
        List<Batch> result = instance.getListBatchDescendants(lotParent);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeWoProduction method, of class RecopieAnalysis.
     */
    @Test
    public void testListeWoProduction() throws Exception {
        System.out.println("listeWoProduction");
        Batch batchProduit = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Traca> expResult = null;
        List<Traca> result = instance.listeWoProduction(batchProduit);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchFromTraca method, of class RecopieAnalysis.
     */
    @Test
    public void testGetBatchFromTraca() throws Exception {
        System.out.println("getBatchFromTraca");
        Traca traca = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        List<Batch> expResult = null;
        List<Batch> result = instance.getBatchFromTraca(traca);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBatch method, of class RecopieAnalysis.
     */
    @Test
    public void testGetIdBatch() throws Exception {
        System.out.println("getIdBatch");
        Analysis analysis = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        Batch expResult = null;
        Batch result = instance.getIdBatch(analysis);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchByIdbatch method, of class RecopieAnalysis.
     */
    @Test
    public void testGetBatchByIdbatch() throws Exception {
        System.out.println("getBatchByIdbatch");
        BigInteger bi_idbatch = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        Batch expResult = null;
        Batch result = instance.getBatchByIdbatch(bi_idbatch);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCasefileSample method, of class RecopieAnalysis.
     */
    @Test
    public void testCreateCasefileSample() throws Exception {
        System.out.println("createCasefileSample");
        Batch batch= new Batch(new BigInteger("3010"));
        BigInteger idCasefile = new BigInteger("22");
        Casefile casefile=new Casefile(idCasefile);
        casefile.setBatchname("F0964W005540NZ");
        casefile.setIdbatch(batch);
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        RecopieAnalysis instance = (RecopieAnalysis)container.getContext().lookup("java:global/classes/RecopieAnalysis");
        Samples expResult = null;
        Samples result = instance.createCasefileSample(batch);
        assertEquals(result.getIdbatch(), batch);
        
        assertEquals(result.getIdcasefile(),casefile);
        assertEquals(result.getBatchname(), "F0964W005540NZ");
        assertNotNull(result.getIdsamples());
        
        container.close();
    }
    
}
