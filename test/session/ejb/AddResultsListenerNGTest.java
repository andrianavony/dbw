/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Batch;
import entite.Company;
import entite.Results;
import entite.Traca;
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
    
    entite.Traca tracaConsommation = new Traca();
    entite.Traca tracaProduction = new Traca();
    
    String batchName ="10M28075550SCN-M";
    String Idcompany="LNS";
    String s_wo="OP1101385";
    
    BigInteger numLotSaisie=new BigInteger("2894");
    Batch lotSaisie ;
    
    BigInteger numLotProduit=new BigInteger("1649");
    Batch produit;
            
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
        
        Wo wo =new Wo(s_wo, Idcompany);
        Company com = new Company(Idcompany);
        
        
        lotSaisie =new Batch(numLotSaisie);
         lotSaisie.setIdwo(wo);
        lotSaisie.setIdcompany(com);

        
        
        
        produit =new Batch(numLotProduit);
        produit.setIdcompany(com);
        
        tracaProduction.setIdtraca(new BigInteger("20887"));
        tracaProduction.setIdwo(wo);
        tracaProduction.setIdarticle("S0101S10111C04_A");
        tracaProduction.setBatchname(batchName);
        tracaProduction.setIdcompany(Idcompany);
       
        tracaConsommation.setIdtraca(new BigInteger("20888"));
        tracaConsommation.setIdwo(wo);
        tracaConsommation.setIdarticle("S0101S10111C04-D_A");
        tracaConsommation.setBatchname(batchName);
        tracaConsommation.setIdcompany(Idcompany);
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
    //@Test
    public void testHeritageDesResultats() throws Exception {
        System.out.println("heritageDesResultats 1-> 1");
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        HashMap<entite.Batch, Integer> listesLotAttendu = new HashMap(); 
        
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
    public void testListWoProduction() throws Exception {
        System.out.println("listBatchDescendants");
        HashMap<entite.Batch, Integer> listesLotAttendu = new HashMap(); 
        /*
        BigInteger numLotSaisie=new BigInteger("2894");
        String batchName ="10M28075550SCN-M";
        String Idcompany="LNS";
        
        Wo wo =new Wo("OP1101385", Idcompany);
        Company com = new Company(Idcompany);
        assertEquals(Idcompany, com.getIdcompany());
        Batch lotSaisie =new Batch(numLotSaisie);
        
        lotSaisie.setIdwo(wo);
        lotSaisie.setIdcompany(com);
        
        entite.Traca traca = new Traca();
        traca.setIdtraca(new BigInteger("20887"));
        traca.setIdwo(wo);
        traca.setIdarticle("S0101S10111C04_A");
        traca.setBatchname(batchName);
        traca.setIdcompany(Idcompany);
        */
        
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        try{
            resultatInserted = new Results();
            resultatInserted.setIdbatch(lotSaisie);
            
            AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
            instance.setResultatInserted(resultatInserted);
            
            List<entite.Traca> expResult = new ArrayList<>(1);
            expResult.add(tracaProduction);
            List<entite.Traca> result = instance.listeWoProduction(lotSaisie);
            assertEquals(result.size(), 1);
            assertEquals(result, expResult);
        }
        finally{
            container.close();
        }
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
    public void testGetBatchFromTraca() throws Exception {
        System.out.println("listBatchDescendants");
        HashMap<entite.Batch, Integer> listesLotAttendu = new HashMap(); 
      
        Results resultatInserted = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        try{
            resultatInserted = new Results();
            resultatInserted.setIdbatch(lotSaisie);
            
            AddResultsListener instance = (AddResultsListener)container.getContext().lookup("java:global/classes/AddResultsListener");
            instance.setResultatInserted(resultatInserted);
            
            List<entite.Batch> expResult = new ArrayList<>(1);
            expResult.add(produit);
            List<entite.Batch> result = instance.getBatchFromTraca(tracaProduction);
            assertEquals(result.size(), 1);
            assertEquals(result, expResult);
        }
        finally{
            container.close();
        }
    }
}
