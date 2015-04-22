/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Analysis;
import entite.Casefile;
import entite.Samples;
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
public class SamplesFindNGTest {
    
    public SamplesFindNGTest() {
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
     * Test of findSamplesCurrent method, of class SamplesFind.
     */
    @Test
    public void testFindSamplesCurrent() throws Exception {
        System.out.println("findSamplesCurrent");
        Casefile casefile = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesFind instance = (SamplesFind)container.getContext().lookup("java:global/classes/SamplesFind");
        List expResult = null;
        List result = instance.findSamplesCurrent(casefile);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findExistingFolderno method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingSample() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesFind instance = (SamplesFind)container.getContext().lookup("java:global/classes/SamplesFind");
        try{
        System.out.println("findExistingSample");
        String limssampleid = "E011_1";
        
        List<Samples> result = instance.findExistingSamples(limssampleid);
        
        assertEquals(result.get(0).getBatchname(), "unknomnBatch");
        assertEquals(result.get(0).getLimssampleid(), limssampleid);
        
        } finally {
            container.close();
        }
    }
    /**
     * Test of createAnalysis method, of class FacadeSaisieResultats.
     */
    @Test
    public void testCreateAnalysisViaInfoLims() throws Exception {
        
        BigInteger limsanalysisorigrec= new BigInteger("789");
        BigInteger limsidanalysis= new BigInteger("357") ;
        String analysisname= "Teneur en Eau" ;
        String limsmethodname= "Grains Entiers" ; 
        BigInteger limsidseries= new BigInteger("123") ;;
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesFind instance = (SamplesFind)container.getContext().lookup("java:global/classes/SamplesFind");
        
        try{
        System.out.println("createAnalysis");
        String limssampleid = "E012_1";
        
        List<Samples> idsamples = instance.findExistingSamples(limssampleid);

        
        //Analysis expResult = null;
        //Analysis result = instance.createAnalysisViaInfoLims(idsamples,  limsanalysisorigrec, limsidanalysis,  analysisname,     limsmethodname,  limsidseries);
        //assertEquals(result, expResult);
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of createAnalysis method, of class FacadeSaisieResultats.
     */
    @Test
    public void testGetAnalysisViaInfoLims() throws Exception {
        
        BigInteger limsanalysisorigrec= new BigInteger("789");
        BigInteger limsidanalysis= new BigInteger("357") ;
        String analysisname= "Teneur en Eau" ;
        String limsmethodname= "Grains Entiers" ; 
        BigInteger limsidseries= new BigInteger("123") ;;
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SamplesFind instance = (SamplesFind)container.getContext().lookup("java:global/classes/SamplesFind");
        try{
        System.out.println("createAnalysis");
        String limssampleid = "E012_1";
        
        List<Samples> idsamples = instance.findExistingSamples(limssampleid);

        
        //Analysis expResult = null;
        //Analysis result = instance.getOrCreateAnalysisViaLimsAnalysisOrigrec(idsamples,  limsanalysisorigrec, limsidanalysis,  analysisname,     limsmethodname,  limsidseries);
        //assertEquals(result.getIdanalysis(), new BigInteger("5"));
        } finally {
            container.close();
        }
    }
    
}
