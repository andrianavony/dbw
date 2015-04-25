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
import utilities.Constant;

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
     * =>OK
     * le lot existe déjà et on veut le recuperer.
     * Cas utilisation : imports des résultats. les lots existe déjà
     * public entite.Casefile createOrRretriveCasefileForTypeDeCopie(entite.Batch idbatch, Constant.typeDeCopie typeDeCopie){
     */
    @Test
    public void createOrRretrive_CASEFILE_ForTypeDeCopieTest() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        
        try{
        System.out.println("createBatch");
        BigInteger idbatch = new BigInteger("3010");
        Batch batch = new Batch(idbatch) ;
        batch.setBatchname("F0964W005540NZ");
        Casefile result = instance.createOrRretriveCasefileForTypeDeCopie(batch, Constant.typeDeCopie.HERITAGE);
            
        assertEquals(result.getIdbatch(), batch);
        assertTrue(result.getCasefiletype().equalsIgnoreCase(Constant.typeDeCopie.HERITAGE.toString()));
        assertEquals(result.getBatchname(), "F0964W005540NZ");
        
        BigInteger idCasefile=result.getIdcasefile();
        result = instance.createOrRretriveCasefileForTypeDeCopie(batch, Constant.typeDeCopie.HERITAGE);
            assertTrue(idCasefile.compareTo(result.getIdcasefile())==0);
        
            
        } finally {
            container.close();
      }
    }  
    
    
    /**
     * =>OK
     * le lot existe déjà et on veut le recuperer.
     * Cas utilisation : imports des résultats. les lots existe déjà
     * public entite.Casefile createOrRretriveCasefileForTypeDeCopie(entite.Batch idbatch, Constant.typeDeCopie typeDeCopie){
     */
    @Test
    public void createOrRetreiveSampleCurrentForTypeDeCopieTest() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        I_FacadeSaisieResultats instance =  (I_FacadeSaisieResultats)container.getContext().lookup("java:global/classes/FacadeSaisieResultats");
        
        try{
        System.out.println("createBatch");
        Batch b= new Batch(new BigInteger("3010"));
        BigInteger idCasefile = new BigInteger("22");
        Casefile casefile=new Casefile(idCasefile);
        casefile.setBatchname("F0964W005540NZ");
       casefile.setIdbatch(b); 
        Samples result = instance.createOrRetreiveSampleCurrent(casefile);
            
        
        assertEquals(result.getIdcasefile(),casefile);
        assertEquals(result.getBatchname(), "F0964W005540NZ");
        assertEquals(result.getIdbatch(), b);
        assertNotNull(result.getIdsamples());
            
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
        Batch result = instance.retrieveBatchFromIdBatch(idbatch);
            
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "ES00NE13S10128C04C00321703");
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
        Casefile result = instance.retrieveCasefile(idcasefile);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "unknomnBatch");
        } finally {
            container.close();
        }
    }

    
    
    /**
     * Test of retrieveCasefile method, of class FacadeSaisieResultats.
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
        
        Casefile result = instance.createOrRetrieveCasefile(idbatch, limsfolderno, numdemandelims);
        assertEquals(result.getBatchname(), "unknomnBatch");
        assertEquals(result.getIdbatch(), idbatch);
        assertEquals(result.getLimsfolderno(), limsfolderno);
        assertEquals(result.getNumdemandelims(), numdemandelims);
        
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
        
        Casefile idcasefile  = instance.createOrRetrieveCasefile(idbatch, limsfolderno, numdemandelims);
        
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
