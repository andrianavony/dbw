/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

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

/**
 *
 * @author S.ANDRIANAVONY
 */
public class CaseFileFindNGTest {
    
    public CaseFileFindNGTest() {
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
     * Test of findCasefileForHeritage method, of class CasefileManager.
     */
    @Test
    public void testFindCasefileForHeritage() throws Exception {
        System.out.println("findCasefileForHeritage");
        BigInteger bi_idbatch = new BigInteger("1649");
        Batch idbatch = new Batch(bi_idbatch);
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
        CaseFileFind instance = (CaseFileFind)container.getContext().lookup("java:global/classes/CaseFileFind");
        
        List <Casefile> result = instance.findCasefileForTypedeCopie(idbatch, Constant.typeDeCopie.HERITAGE);
        assertEquals(result.size(),1);// apres 1 premiere mpassage
        assertEquals(result.get(0).getIdcasefile(),new BigInteger("7") );// apres 1 premiere mpassage
        }
        finally{
            container.close();
        }
    }
    
    /**
     * Test of findExistingCasefile method, of class CaseFileFind.
     */
    @Test
    public void testFindExistingCasefile() throws Exception {
        System.out.println("findExistingCasefile");
        BigInteger idcasefile = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CaseFileFind instance = (CaseFileFind)container.getContext().lookup("java:global/classes/CaseFileFind");
        Casefile expResult = null;
        Casefile result = instance.findExistingCasefile(idcasefile);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findExistingFolderno method, of class CaseFileFind.
     */
    @Test
    public void testFindExistingFolderno() throws Exception {
        System.out.println("findExistingFolderno");
        String limsfolderno = "";
        Integer numdemandelims = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CaseFileFind instance = (CaseFileFind)container.getContext().lookup("java:global/classes/CaseFileFind");
        Casefile expResult = null;
        Casefile result = instance.findExistingFolderno(limsfolderno, numdemandelims);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCaseFile method, of class CaseFileFind.
     */
    @Test
    public void testFindCaseFile() throws Exception {
        System.out.println("findCaseFile");
        Batch batch = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CaseFileFind instance = (CaseFileFind)container.getContext().lookup("java:global/classes/CaseFileFind");
        List expResult = null;
        List result = instance.findCaseFile(batch);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCasefileForTypedeCopie method, of class CaseFileFind.
     */
    @Test
    public void testFindCasefileForTypedeCopie() throws Exception {
        System.out.println("findCasefileForTypedeCopie");
        Batch idbatch = null;
        Constant.typeDeCopie typeDeCopie = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CaseFileFind instance = (CaseFileFind)container.getContext().lookup("java:global/classes/CaseFileFind");
        List expResult = null;
        List result = instance.findCasefileForTypedeCopie(idbatch, typeDeCopie);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
