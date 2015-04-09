/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Batch;
import entite.Company;
import entite.Results;
import entite.Wo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AddResultsListenerNGTest {
    
    public AddResultsListenerNGTest() {
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
     * Test Case Simple
     * S0101S10111C04-D_A
     * 10M28075550SCN-ST
     *                      OP1101385 => 10M28075550SCN-M  S0101S10111C04_A
     * 10M28075550SCN-M
     * 
     * PB dans traca on n'a que la partie basse
     */
    @Test
    public void testHeritageDesResultats() throws Exception {
        System.out.println("heritageDesResultats 1-> 1");
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        HashMap<entite.Batch, Integer> listesLotAttendu = new HashMap(); 
        
        BigInteger numLotSaisie=new BigInteger("2894");
        Batch lotSaisie =new Batch(numLotSaisie);
        
        
        BigInteger numLotProduit=new BigInteger("1649");
        Batch produit =new Batch(numLotProduit);
        try{
            AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
            resultatInserted = new Results();
            resultatInserted.setIdbatch(lotSaisie);
            
            instance.setResultatInserted(resultatInserted);
            instance.heritageDesResultats(resultatInserted);
        }finally{
        
        container.close();
        }
            }

    /**
     * Test of getResultatInserted method, of class AddResultsListener.
     */
    @Test
    public void testGetResultatInserted() throws Exception {
        System.out.println("getResultatInserted");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
        Results expResult = null;
        Results result = instance.getResultatInserted();
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultatInserted method, of class AddResultsListener.
     */
    @Test
    public void testSetResultatInserted() throws Exception {
        System.out.println("setResultatInserted");
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
        instance.setResultatInserted(resultatInserted);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test Case Simple
     * S0101S10111C04-D_A
     * 10M28075550SCN-ST
     *                      OP1101385 => 10M28075550SCN-M  S0101S10111C04_A
     * 10M28075550SCN-M
     * 
     * PB dans traca on n'a que la partie basse
     */
    @Test
    public void testListBatchDescendants() throws Exception {
        System.out.println("listBatchDescendants");
        HashMap<entite.Batch, Integer> listesLotAttendu = new HashMap(); 
        
        BigInteger numLotSaisie=new BigInteger("2894");
        Wo wo =new Wo("OP1101385", "LNS");
        Company com = new Company("LNS");
        
        Batch lotSaisie =new Batch(numLotSaisie);
        
        lotSaisie.setIdwo(wo);
        lotSaisie.setIdcompany(com);
        
        BigInteger numLotProduit=new BigInteger("1649");
        Batch produit =new Batch(numLotProduit);
        
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
            resultatInserted = new Results();
            resultatInserted.setIdbatch(lotSaisie);
            
            AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
            instance.setResultatInserted(resultatInserted);
            
            List<Batch> expResult = new ArrayList<>(1);
            expResult.add(produit);
            List<Batch> result = instance.listBatchDescendants();
            assertEquals(result, expResult);
        }
        finally{
            container.close();
        }
    }
    
}
