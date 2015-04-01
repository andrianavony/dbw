/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

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
public class ForItemNGTest {
    String IdArticle ;
    String specie;
    String  variety;
    String stage;
    String  generation;
    String  expResult;
    
    public ForItemNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
         IdArticle=null ;
         specie=null;
          variety=null;
         stage=null;
          generation=null;
          expResult=null;
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getIdSpecie method, of class ForItem.
     */
    @Test
    public void testGetIdSpecie() {
        System.out.println("getIdSpecie");
        String IdArticle = "S0101S10098C04";
        String expResult = "S0101";
        String result = ForItem.getIdSpecie(IdArticle);
        assertEquals(result, expResult);
    }

    /**
     * Test of getIdVariety method, of class ForItem.
     */
    @Test
    public void testGetIdVariety() {
        System.out.println("getIdVariety");
        String IdArticle = "S0101S10098C04";
        String expResult = "S10098";
        String result = ForItem.getIdVariety(IdArticle);
        assertEquals(result, expResult);
    }

    /**
     * Test of getIdGeneration method, of class ForItem.
     */
    @Test
    public void testGetIdGeneration() {
        System.out.println("getIdGeneration");
        String IdArticle = "S0101S10098C04";
        String expResult = "C04";
        String result = ForItem.getIdGeneration(IdArticle);
        assertEquals(result, expResult);
    }

    /**
     * Test of getIdStage method, of class ForItem.
     */
    @Test
    public void testGetIdStage() {
        System.out.println("getIdStage");
        String IdArticle = "S0101S10098C04";
        String expResult = "COM";
        String result = ForItem.getIdStageFromItem(IdArticle);
        assertEquals(result, expResult);
    }
    
     /**
     * Test of getIdStage method, of class ForItem.
     */
    @Test
    public void testGetIdStage_KG() {
        System.out.println("getIdStage KG");
        String IdArticle = "M0101M10006C04_KG";
        String expResult = "COM";
        String result = ForItem.getIdStageFromItem(IdArticle);
        assertEquals(result, expResult);
    }

    /**
     * Test of getIdArticle method, of class ForItem.
     */
    @Test
    public void testGetIdArticle() {
        System.out.println("getIdArticle");
        String idspecie = "M0101";
        String idvariety = "M10006";
        String idgeneration = "C04";
        String idstage = "_KG";
        String expResult = "M0101M10006C04_KG";
        String result = ForItem.getIdArticle(idspecie, idvariety, idgeneration, idstage);
        assertEquals(result, expResult);
    }
    
}
