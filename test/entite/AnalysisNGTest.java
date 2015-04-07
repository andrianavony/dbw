/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.persistence.Persistence;
/**
 *
 * @author S.ANDRIANAVONY
 */
public class AnalysisNGTest {
    
    protected static EntityManagerFactory emf;
    
    protected  EntityManager em;
    
    
    public AnalysisNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("dbwEJBwsPU"); 
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        emf.close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        if (em.isOpen()) {
            em.close();
        }
    }
    
    
    @Test
    public void fingExistingMethod(){
        BigInteger idmodelanalysis=new BigInteger("307");
        String methodname="Grains Entiers";
        assertNotNull(em);
        TypedQuery<Method> query = em.createNamedQuery("Method.findByIdmethodMethodname", Method.class);
            query.setParameter("idmodelanalysis",idmodelanalysis);
            query.setParameter("methodname", methodname);
            List<Method> methodList =query.getResultList();
            
        assertNull(methodList);
    }
    

    /**
     * Test of getCopiedfromidbatch method, of class Analysis.
     */
    @Test
    public void testGetCopiedfromidbatch() {
        System.out.println("getCopiedfromidbatch");
        Analysis instance = new Analysis();
        Batch expResult = null;
        Batch result = instance.getCopiedfromidbatch();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopiedfromidbatch method, of class Analysis.
     */
    @Test
    public void testSetCopiedfromidbatch() {
        System.out.println("setCopiedfromidbatch");
        Batch copiedfromidbatch = null;
        Analysis instance = new Analysis();
        instance.setCopiedfromidbatch(copiedfromidbatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdanalysis method, of class Analysis.
     */
    @Test
    public void testGetIdanalysis() {
        System.out.println("getIdanalysis");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getIdanalysis();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdanalysis method, of class Analysis.
     */
    @Test
    public void testSetIdanalysis() {
        System.out.println("setIdanalysis");
        BigInteger idanalysis = null;
        Analysis instance = new Analysis();
        instance.setIdanalysis(idanalysis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimsid method, of class Analysis.
     */
    @Test
    public void testGetLimsid() {
        System.out.println("getLimsid");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getLimsid();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimsid method, of class Analysis.
     */
    @Test
    public void testSetLimsid() {
        System.out.println("setLimsid");
        BigInteger limsid = null;
        Analysis instance = new Analysis();
        instance.setLimsid(limsid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimssampleid method, of class Analysis.
     */
    @Test
    public void testGetLimssampleid() {
        System.out.println("getLimssampleid");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getLimssampleid();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimssampleid method, of class Analysis.
     */
    @Test
    public void testSetLimssampleid() {
        System.out.println("setLimssampleid");
        String limssampleid = "";
        Analysis instance = new Analysis();
        instance.setLimssampleid(limssampleid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimsidanalysis method, of class Analysis.
     */
    @Test
    public void testGetLimsidanalysis() {
        System.out.println("getLimsidanalysis");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getLimsidanalysis();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimsidanalysis method, of class Analysis.
     */
    @Test
    public void testSetLimsidanalysis() {
        System.out.println("setLimsidanalysis");
        BigInteger limsidanalysis = null;
        Analysis instance = new Analysis();
        instance.setLimsidanalysis(limsidanalysis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdcasefile method, of class Analysis.
     */
    @Test
    public void testGetIdcasefile() {
        System.out.println("getIdcasefile");
        Analysis instance = new Analysis();
        Casefile expResult = null;
        Casefile result = instance.getIdcasefile();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdcasefile method, of class Analysis.
     */
    @Test
    public void testSetIdcasefile() {
        System.out.println("setIdcasefile");
        Casefile idcasefile = null;
        Analysis instance = new Analysis();
        instance.setIdcasefile(idcasefile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimsidseries method, of class Analysis.
     */
    @Test
    public void testGetLimsidseries() {
        System.out.println("getLimsidseries");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getLimsidseries();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimsidseries method, of class Analysis.
     */
    @Test
    public void testSetLimsidseries() {
        System.out.println("setLimsidseries");
        BigInteger limsidseries = null;
        Analysis instance = new Analysis();
        instance.setLimsidseries(limsidseries);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdseries method, of class Analysis.
     */
    @Test
    public void testGetIdseries() {
        System.out.println("getIdseries");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getIdseries();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdseries method, of class Analysis.
     */
    @Test
    public void testSetIdseries() {
        System.out.println("setIdseries");
        BigInteger idseries = null;
        Analysis instance = new Analysis();
        instance.setIdseries(idseries);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdmethoddetails method, of class Analysis.
     */
    @Test
    public void testGetIdmethoddetails() {
        System.out.println("getIdmethoddetails");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getIdmethoddetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdmethoddetails method, of class Analysis.
     */
    @Test
    public void testSetIdmethoddetails() {
        System.out.println("setIdmethoddetails");
        BigInteger idmethoddetails = null;
        Analysis instance = new Analysis();
        instance.setIdmethoddetails(idmethoddetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimsbatchid method, of class Analysis.
     */
    @Test
    public void testGetLimsbatchid() {
        System.out.println("getLimsbatchid");
        Analysis instance = new Analysis();
        BigInteger expResult = null;
        BigInteger result = instance.getLimsbatchid();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimsbatchid method, of class Analysis.
     */
    @Test
    public void testSetLimsbatchid() {
        System.out.println("setLimsbatchid");
        BigInteger limsbatchid = null;
        Analysis instance = new Analysis();
        instance.setLimsbatchid(limsbatchid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimsfolderno method, of class Analysis.
     */
    @Test
    public void testGetLimsfolderno() {
        System.out.println("getLimsfolderno");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getLimsfolderno();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimsfolderno method, of class Analysis.
     */
    @Test
    public void testSetLimsfolderno() {
        System.out.println("setLimsfolderno");
        String limsfolderno = "";
        Analysis instance = new Analysis();
        instance.setLimsfolderno(limsfolderno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchname method, of class Analysis.
     */
    @Test
    public void testGetBatchname() {
        System.out.println("getBatchname");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getBatchname();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBatchname method, of class Analysis.
     */
    @Test
    public void testSetBatchname() {
        System.out.println("setBatchname");
        String batchname = "";
        Analysis instance = new Analysis();
        instance.setBatchname(batchname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdstatus method, of class Analysis.
     */
    @Test
    public void testGetIdstatus() {
        System.out.println("getIdstatus");
        Analysis instance = new Analysis();
        short expResult = 0;
        short result = instance.getIdstatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdstatus method, of class Analysis.
     */
    @Test
    public void testSetIdstatus() {
        System.out.println("setIdstatus");
        short idstatus = 0;
        Analysis instance = new Analysis();
        instance.setIdstatus(idstatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatuslabel method, of class Analysis.
     */
    @Test
    public void testGetStatuslabel() {
        System.out.println("getStatuslabel");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getStatuslabel();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatuslabel method, of class Analysis.
     */
    @Test
    public void testSetStatuslabel() {
        System.out.println("setStatuslabel");
        String statuslabel = "";
        Analysis instance = new Analysis();
        instance.setStatuslabel(statuslabel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdapprobationstatus method, of class Analysis.
     */
    @Test
    public void testGetIdapprobationstatus() {
        System.out.println("getIdapprobationstatus");
        Analysis instance = new Analysis();
        short expResult = 0;
        short result = instance.getIdapprobationstatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdapprobationstatus method, of class Analysis.
     */
    @Test
    public void testSetIdapprobationstatus() {
        System.out.println("setIdapprobationstatus");
        short idapprobationstatus = 0;
        Analysis instance = new Analysis();
        instance.setIdapprobationstatus(idapprobationstatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApprobationstatuslabel method, of class Analysis.
     */
    @Test
    public void testGetApprobationstatuslabel() {
        System.out.println("getApprobationstatuslabel");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getApprobationstatuslabel();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApprobationstatuslabel method, of class Analysis.
     */
    @Test
    public void testSetApprobationstatuslabel() {
        System.out.println("setApprobationstatuslabel");
        String approbationstatuslabel = "";
        Analysis instance = new Analysis();
        instance.setApprobationstatuslabel(approbationstatuslabel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Analysis.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Analysis.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Analysis instance = new Analysis();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsvirtual method, of class Analysis.
     */
    @Test
    public void testGetIsvirtual() {
        System.out.println("getIsvirtual");
        Analysis instance = new Analysis();
        Boolean expResult = null;
        Boolean result = instance.getIsvirtual();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsvirtual method, of class Analysis.
     */
    @Test
    public void testSetIsvirtual() {
        System.out.println("setIsvirtual");
        Boolean isvirtual = null;
        Analysis instance = new Analysis();
        instance.setIsvirtual(isvirtual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsfinal method, of class Analysis.
     */
    @Test
    public void testGetIsfinal() {
        System.out.println("getIsfinal");
        Analysis instance = new Analysis();
        Boolean expResult = null;
        Boolean result = instance.getIsfinal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsfinal method, of class Analysis.
     */
    @Test
    public void testSetIsfinal() {
        System.out.println("setIsfinal");
        Boolean isfinal = null;
        Analysis instance = new Analysis();
        instance.setIsfinal(isfinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccurence method, of class Analysis.
     */
    @Test
    public void testGetOccurence() {
        System.out.println("getOccurence");
        Analysis instance = new Analysis();
        Short expResult = null;
        Short result = instance.getOccurence();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOccurence method, of class Analysis.
     */
    @Test
    public void testSetOccurence() {
        System.out.println("setOccurence");
        Short occurence = null;
        Analysis instance = new Analysis();
        instance.setOccurence(occurence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOfficialename method, of class Analysis.
     */
    @Test
    public void testGetOfficialename() {
        System.out.println("getOfficialename");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getOfficialename();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOfficialename method, of class Analysis.
     */
    @Test
    public void testSetOfficialename() {
        System.out.println("setOfficialename");
        String officialename = "";
        Analysis instance = new Analysis();
        instance.setOfficialename(officialename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLimscounteranalysissampelid method, of class Analysis.
     */
    @Test
    public void testGetLimscounteranalysissampelid() {
        System.out.println("getLimscounteranalysissampelid");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getLimscounteranalysissampelid();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLimscounteranalysissampelid method, of class Analysis.
     */
    @Test
    public void testSetLimscounteranalysissampelid() {
        System.out.println("setLimscounteranalysissampelid");
        String limscounteranalysissampelid = "";
        Analysis instance = new Analysis();
        instance.setLimscounteranalysissampelid(limscounteranalysissampelid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCounteranalysis method, of class Analysis.
     */
    @Test
    public void testGetCounteranalysis() {
        System.out.println("getCounteranalysis");
        Analysis instance = new Analysis();
        Short expResult = null;
        Short result = instance.getCounteranalysis();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCounteranalysis method, of class Analysis.
     */
    @Test
    public void testSetCounteranalysis() {
        System.out.println("setCounteranalysis");
        Short counteranalysis = null;
        Analysis instance = new Analysis();
        instance.setCounteranalysis(counteranalysis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApporved method, of class Analysis.
     */
    @Test
    public void testGetApporved() {
        System.out.println("getApporved");
        Analysis instance = new Analysis();
        Short expResult = null;
        Short result = instance.getApporved();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApporved method, of class Analysis.
     */
    @Test
    public void testSetApporved() {
        System.out.println("setApporved");
        Short apporved = null;
        Analysis instance = new Analysis();
        instance.setApporved(apporved);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApporvedby method, of class Analysis.
     */
    @Test
    public void testGetApporvedby() {
        System.out.println("getApporvedby");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getApporvedby();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApporvedby method, of class Analysis.
     */
    @Test
    public void testSetApporvedby() {
        System.out.println("setApporvedby");
        String apporvedby = "";
        Analysis instance = new Analysis();
        instance.setApporvedby(apporvedby);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApporveddate method, of class Analysis.
     */
    @Test
    public void testGetApporveddate() {
        System.out.println("getApporveddate");
        Analysis instance = new Analysis();
        Date expResult = null;
        Date result = instance.getApporveddate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApporveddate method, of class Analysis.
     */
    @Test
    public void testSetApporveddate() {
        System.out.println("setApporveddate");
        Date apporveddate = null;
        Analysis instance = new Analysis();
        instance.setApporveddate(apporveddate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHerited method, of class Analysis.
     */
    @Test
    public void testGetHerited() {
        System.out.println("getHerited");
        Analysis instance = new Analysis();
        Boolean expResult = null;
        Boolean result = instance.getHerited();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHerited method, of class Analysis.
     */
    @Test
    public void testSetHerited() {
        System.out.println("setHerited");
        Boolean herited = null;
        Analysis instance = new Analysis();
        instance.setHerited(herited);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsidered method, of class Analysis.
     */
    @Test
    public void testGetConsidered() {
        System.out.println("getConsidered");
        Analysis instance = new Analysis();
        Boolean expResult = null;
        Boolean result = instance.getConsidered();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsidered method, of class Analysis.
     */
    @Test
    public void testSetConsidered() {
        System.out.println("setConsidered");
        Boolean considered = null;
        Analysis instance = new Analysis();
        instance.setConsidered(considered);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysisname method, of class Analysis.
     */
    @Test
    public void testGetAnalysisname() {
        System.out.println("getAnalysisname");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getAnalysisname();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnalysisname method, of class Analysis.
     */
    @Test
    public void testSetAnalysisname() {
        System.out.println("setAnalysisname");
        String analysisname = "";
        Analysis instance = new Analysis();
        instance.setAnalysisname(analysisname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMethodname method, of class Analysis.
     */
    @Test
    public void testGetMethodname() {
        System.out.println("getMethodname");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getMethodname();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMethodname method, of class Analysis.
     */
    @Test
    public void testSetMethodname() {
        System.out.println("setMethodname");
        String methodname = "";
        Analysis instance = new Analysis();
        instance.setMethodname(methodname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdarticle method, of class Analysis.
     */
    @Test
    public void testGetIdarticle() {
        System.out.println("getIdarticle");
        Analysis instance = new Analysis();
        Article expResult = null;
        Article result = instance.getIdarticle();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdarticle method, of class Analysis.
     */
    @Test
    public void testSetIdarticle() {
        System.out.println("setIdarticle");
        Article idarticle = null;
        Analysis instance = new Analysis();
        instance.setIdarticle(idarticle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdspecie method, of class Analysis.
     */
    @Test
    public void testGetIdspecie() {
        System.out.println("getIdspecie");
        Analysis instance = new Analysis();
        Specie expResult = null;
        Specie result = instance.getIdspecie();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdspecie method, of class Analysis.
     */
    @Test
    public void testSetIdspecie() {
        System.out.println("setIdspecie");
        Specie idspecie = null;
        Analysis instance = new Analysis();
        instance.setIdspecie(idspecie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdstage method, of class Analysis.
     */
    @Test
    public void testGetIdstage() {
        System.out.println("getIdstage");
        Analysis instance = new Analysis();
        Stage expResult = null;
        Stage result = instance.getIdstage();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdstage method, of class Analysis.
     */
    @Test
    public void testSetIdstage() {
        System.out.println("setIdstage");
        Stage idstage = null;
        Analysis instance = new Analysis();
        instance.setIdstage(idstage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultsList method, of class Analysis.
     */
    @Test
    public void testGetResultsList() {
        System.out.println("getResultsList");
        Analysis instance = new Analysis();
        List expResult = null;
        List result = instance.getResultsList();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultsList method, of class Analysis.
     */
    @Test
    public void testSetResultsList() {
        System.out.println("setResultsList");
        List<Results> resultsList = null;
        Analysis instance = new Analysis();
        instance.setResultsList(resultsList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdmethod method, of class Analysis.
     */
    @Test
    public void testGetIdmethod() {
        System.out.println("getIdmethod");
        Analysis instance = new Analysis();
        Method expResult = null;
        Method result = instance.getIdmethod();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdmethod method, of class Analysis.
     */
    @Test
    public void testSetIdmethod() {
        System.out.println("setIdmethod");
        Method idmethod = null;
        Analysis instance = new Analysis();
        instance.setIdmethod(idmethod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysisList method, of class Analysis.
     */
    @Test
    public void testGetAnalysisList() {
        System.out.println("getAnalysisList");
        Analysis instance = new Analysis();
        List expResult = null;
        List result = instance.getAnalysisList();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnalysisList method, of class Analysis.
     */
    @Test
    public void testSetAnalysisList() {
        System.out.println("setAnalysisList");
        List<Analysis> analysisList = null;
        Analysis instance = new Analysis();
        instance.setAnalysisList(analysisList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdmotheranalysis method, of class Analysis.
     */
    @Test
    public void testGetIdmotheranalysis() {
        System.out.println("getIdmotheranalysis");
        Analysis instance = new Analysis();
        Analysis expResult = null;
        Analysis result = instance.getIdmotheranalysis();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdmotheranalysis method, of class Analysis.
     */
    @Test
    public void testSetIdmotheranalysis() {
        System.out.println("setIdmotheranalysis");
        Analysis idmotheranalysis = null;
        Analysis instance = new Analysis();
        instance.setIdmotheranalysis(idmotheranalysis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdmodelanalysis method, of class Analysis.
     */
    @Test
    public void testGetIdmodelanalysis() {
        System.out.println("getIdmodelanalysis");
        Analysis instance = new Analysis();
        Modelanalysis expResult = null;
        Modelanalysis result = instance.getIdmodelanalysis();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdmodelanalysis method, of class Analysis.
     */
    @Test
    public void testSetIdmodelanalysis() {
        System.out.println("setIdmodelanalysis");
        Modelanalysis idmodelanalysis = null;
        Analysis instance = new Analysis();
        instance.setIdmodelanalysis(idmodelanalysis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdbatch method, of class Analysis.
     */
    @Test
    public void testGetIdbatch() {
        System.out.println("getIdbatch");
        Analysis instance = new Analysis();
        Batch expResult = null;
        Batch result = instance.getIdbatch();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdbatch method, of class Analysis.
     */
    @Test
    public void testSetIdbatch() {
        System.out.println("setIdbatch");
        Batch idbatch = null;
        Analysis instance = new Analysis();
        instance.setIdbatch(idbatch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdsamples method, of class Analysis.
     */
    @Test
    public void testGetIdsamples() {
        System.out.println("getIdsamples");
        Analysis instance = new Analysis();
        Samples expResult = null;
        Samples result = instance.getIdsamples();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdsamples method, of class Analysis.
     */
    @Test
    public void testSetIdsamples() {
        System.out.println("setIdsamples");
        Samples idsamples = null;
        Analysis instance = new Analysis();
        instance.setIdsamples(idsamples);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdspecification method, of class Analysis.
     */
    @Test
    public void testGetIdspecification() {
        System.out.println("getIdspecification");
        Analysis instance = new Analysis();
        Specification expResult = null;
        Specification result = instance.getIdspecification();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdspecification method, of class Analysis.
     */
    @Test
    public void testSetIdspecification() {
        System.out.println("setIdspecification");
        Specification idspecification = null;
        Analysis instance = new Analysis();
        instance.setIdspecification(idspecification);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Analysis.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Analysis instance = new Analysis();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Analysis.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Analysis instance = new Analysis();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Analysis.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopiedfromidsample method, of class Analysis.
     */
    @Test
    public void testGetCopiedfromidsample() {
        System.out.println("getCopiedfromidsample");
        Analysis instance = new Analysis();
        Samples expResult = null;
        Samples result = instance.getCopiedfromidsample();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCopiedfromidsample method, of class Analysis.
     */
    @Test
    public void testSetCopiedfromidsample() {
        System.out.println("setCopiedfromidsample");
        Samples copiedfromidsample = null;
        Analysis instance = new Analysis();
        instance.setCopiedfromidsample(copiedfromidsample);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdgroup method, of class Analysis.
     */
    @Test
    public void testGetProdgroup() {
        System.out.println("getProdgroup");
        Analysis instance = new Analysis();
        String expResult = "";
        String result = instance.getProdgroup();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProdgroup method, of class Analysis.
     */
    @Test
    public void testSetProdgroup() {
        System.out.println("setProdgroup");
        String prodgroup = "";
        Analysis instance = new Analysis();
        instance.setProdgroup(prodgroup);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
