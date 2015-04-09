/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
import entite.Article;
import entite.Batch;
import entite.Casefile;
import entite.Samples;
import java.math.BigInteger;
import java.util.Date;
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
public class FacadeSaisieResultatsNGTest {
    
    public FacadeSaisieResultatsNGTest() {
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
     * Test of findExistingBatchByBatchId method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingBatchByBatchId() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("findExistingBatchByBatchId");
        BigInteger idbatch = new BigInteger("1");
        Batch expResult = new Batch(idbatch) ;
        Batch result = instance.findExistingBatchByBatchId(idbatch);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "ES00NE13S10128C04C00321703");        
        } finally {
            container.close();
        }
    }

    /**
     * le lot existe déjà et on veut le recuperer.
     * Cas utilisation : imports des résultats. les lots existe déjà
     */
    @Test
    public void testCreateBatch_BigInteger() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        
        try{
        System.out.println("createBatch");
        BigInteger idbatch = new BigInteger("1");
        Batch expResult = new Batch(idbatch) ;
        Batch result = instance.createBatch(idbatch);
            
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "ES00NE13S10128C04C00321703");
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of findExistingBatchByLimsBatchId method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingBatchByLimsBatchId() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("findExistingBatchByLimsBatchId");
        String limsbatchid = "80604";
        BigInteger idbatch = new BigInteger("10");
        Batch expResult = new Batch(idbatch) ;
        
        Batch result = instance.findExistingBatchByLimsBatchId(limsbatchid);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "FR26AV13S01010184");
        } finally {
            container.close();
        }
    }

    /**
     * Le lot existe déjà
     */
    @Test
    public void testCreateBatchLotExistant() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{    
        System.out.println("createBatch");
        String batchname = "";
        String articlename = "";
        String idcompany = "";
        String limsbatchid = "80604";
        BigInteger idbatch = new BigInteger("10");
        Batch expResult = new Batch(idbatch) ;
        
        Batch result = instance.createBatch(batchname, articlename, idcompany, limsbatchid);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "FR26AV13S01010184");
        } finally {
            container.close();
        }
    }
    /**
     * Test of createBatch method, of class FacadeSaisieResultats.
     */
    @Test
    public void testCreateBatch_4args_2() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createBatch inexistant ");
        String batchname = "lotInexistant";
        String idarticle = "S0101S10128C04_C";
        String idcompany = "lvh";
        String limsbatchid = "1";
        
        
        Batch result = instance.createBatch(batchname, idarticle, idcompany, limsbatchid);
            assertNotNull(result);
            
        assertEquals(result.getBatchname(), batchname);
        assertEquals(result.getIdarticle().getIdarticle(), idarticle);
        assertEquals(result.getIdbatch(), new BigInteger(limsbatchid));
        
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of findExistingCasefile method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingCasefile() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("findExistingCasefile");
        BigInteger idcasefile =  new BigInteger("1");
        Casefile expResult = new Casefile(idcasefile);

        Casefile result = instance.findExistingCasefile(idcasefile);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
        } finally {
            container.close();
        }
    }

    /**
     * On connais le numero du dossier lot
     * on souhaite le recuperer
     */
    @Test
    public void testCreateCasefile_BigInteger() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createCasefile");
        BigInteger idcasefile =  new BigInteger("1");
        Casefile expResult = new Casefile(idcasefile);
        Casefile result = instance.createCasefile(idcasefile);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
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
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("findExistingFolderno");
        String limsfolderno = "E007";
        Integer numdemandelims = 7;
        BigInteger idcasefile =  new BigInteger("1");
        Casefile expResult = new Casefile(idcasefile);
        Casefile result = instance.findExistingFolderno(limsfolderno, numdemandelims);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of createCasefile method, of class FacadeSaisieResultats.
     */
    @Test
    public void testCreateCasefile_3args() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createCasefile");
        BigInteger b_idbatch =  new BigInteger("3201");
        Batch idbatch = new Batch(b_idbatch);
        String limsfolderno = "E009";
        Integer numdemandelims = 9;
        
        Casefile result = instance.createCasefile(idbatch, limsfolderno, numdemandelims);
        assertEquals(result.getBatchname(), "unknomnBatch");
        assertEquals(result.getIdbatch(), idbatch);
        assertEquals(result.getLimsfolderno(), limsfolderno);
        assertEquals(result.getNumdemandelims(), numdemandelims);
        
        } finally {
            container.close();
        }
    }
    
    /**
     * Test of findExistingFolderno method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingSample() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("findExistingSample");
        String limssampleid = "E011_1";
        
        Samples result = instance.findExistingSamples(limssampleid);
        
        assertEquals(result.getBatchname(), "unknomnBatch");
        assertEquals(result.getLimssampleid(), limssampleid);
        
        } finally {
            container.close();
        }
    }

    /**
     * Test of createSample method, of class FacadeSaisieResultats.
     */
    @Test
    public void testCreateSample() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createSample");
        BigInteger b_idbatch =  new BigInteger("3201"); //unknomnBatch
        Batch idbatch = new Batch(b_idbatch);
        String limsfolderno = "E012";
        Integer numdemandelims = 12;
        
        Casefile idcasefile  = instance.createCasefile(idbatch, limsfolderno, numdemandelims);
        
        String limssampleid = "E012_1";
        
        
        Samples result = instance.createSample(idcasefile, limssampleid);
        assertEquals(result.getIdbatch(), idbatch);
        assertEquals(result.getIdcasefile(), idcasefile);
        assertEquals(result.getLimssampleid(), limssampleid);
        assertEquals(result.getLimsfolderno(), limsfolderno);
        
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
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createAnalysis");
        String limssampleid = "E012_1";
        
        Samples idsamples = instance.findExistingSamples(limssampleid);

        
        //Analysis expResult = null;
        Analysis result = instance.createAnalysisViaInfoLims(idsamples,  limsanalysisorigrec, limsidanalysis,  analysisname,     limsmethodname,  limsidseries);
        //assertEquals(result, expResult);
        } finally {
            container.close();
        }
    }
    
    
    
    
    /**
     * Test of createAnalysis method, of class FacadeSaisieResultats.
     */
    //@Test
    public void testCreateAnalysis() throws Exception {
        assertTrue(false);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createAnalysis");
        Samples idsamples = null;
        BigInteger idmodelanalysis = null;
        BigInteger idmethod = null;
        
        Analysis expResult = null;
        Analysis result = instance.createAnalysis(idsamples, idmodelanalysis, idmethod);
        assertEquals(result, expResult);
        } finally {
            container.close();
        }
    }

    /**
     * Test of createAnalysisViaMethodDetails method, of class FacadeSaisieResultats.
     */
    //@Test
    public void testCreateAnalysisViaMethodDetails() throws Exception {
        assertTrue(false);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createAnalysisViaMethodDetails");
        Samples idsamples = null;
        BigInteger idmethoddetails = null;
        
        Analysis expResult = null;
        Analysis result = instance.createAnalysisViaMethodDetails(idsamples, idmethoddetails);
        assertEquals(result, expResult);
        } finally {
            container.close();
        }
    }

    /**
     * Test of createAnalysisViaLimsAnalysis method, of class FacadeSaisieResultats.
     */
    //@Test
    public void testCreateAnalysisViaLimsAnalysis() throws Exception {
        assertTrue(false);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createAnalysisViaLimsAnalysis");
        Samples idsamples = null;
        BigInteger limsidanalysis = null;
        String limsidmethod = "";
        
        Analysis expResult = null;
        Analysis result = instance.createAnalysisViaLimsAnalysis(idsamples, limsidanalysis, limsidmethod);
        assertEquals(result, expResult);
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
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("createAnalysis");
        String limssampleid = "E012_1";
        
        Samples idsamples = instance.findExistingSamples(limssampleid);

        
        //Analysis expResult = null;
        Analysis result = instance.getOrCreateAnalysisViaLimsAnalysisOrigrec(idsamples,  limsanalysisorigrec, limsidanalysis,  analysisname,     limsmethodname,  limsidseries);
        assertEquals(result.getIdanalysis(), new BigInteger("5"));
        } finally {
            container.close();
        }
    }
    

    /**
     * Test of saisirResultat method, of class FacadeSaisieResultats.
     */
    @Test
    public void testSaisirResultat() throws Exception {
        BigInteger limsanalysisorigrec= new BigInteger("789");
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        try{
        System.out.println("saisirResultat");
        Analysis idanalysis = instance.getOrCreateAnalysisViaLimsAnalysisOrigrec(null,  limsanalysisorigrec, null,  null,     null,  null);
        
        String measurename="Poids Sec";
        BigInteger limsmeasureid=new BigInteger("7") ;
        String username = "JANZ";
        Date dateofentry = utilities.DateManager.getNow();
        String statutsLabel="logged";
        
        String rawresults = "10.78";
        String formated = "10.1";
        Short repetition=1;
        
        Analysis expResult = null;
        Analysis result = instance.saisirResultatIssusLims(idanalysis,  limsanalysisorigrec, measurename, limsmeasureid , rawresults, formated, repetition,   username,  dateofentry, statutsLabel);
        
         rawresults = "11.02";
        formated = "11.1";
         repetition=2;
        
         result = instance.saisirResultatIssusLims(idanalysis,  limsanalysisorigrec, measurename, limsmeasureid , rawresults, formated, repetition,   username,  dateofentry, statutsLabel);
        
        //assertEquals(result, expResult);
        
        } finally {
            container.close();
        }
    }

    

    

    

    
    
}
