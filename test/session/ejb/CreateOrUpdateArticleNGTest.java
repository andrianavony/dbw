/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Generation;
import entite.Specie;
import entite.Stage;
import entite.Variety;
import entite.VarietyPK;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ForItem;

/**
 *
 * @author S.ANDRIANAVONY
 */
public class CreateOrUpdateArticleNGTest {
     Specie specie;
    Variety variety;
    Stage stage;
    Generation generation;
    Article expResult;
    
    //@Inject CreateOrUpdateArticle createOrUpdateArticle;
    
    public CreateOrUpdateArticleNGTest() {
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
     * Insertion du code article dans la base en utilisant le nom de l'article.
     * On verifie que l'article, l'espece, la variété, le stade et génération sont crée dans la base
     */
    @Test
    public void testCreateOrUpdateArticle_String() throws Exception {
        System.out.println("createOrUpdateArticle");
        String idarticle = "S0101S10098C04";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        Article result = instance.createOrUpdateArticle(idarticle);

        initialisation( idarticle);        
        assertEquals(result, expResult);
        assertEquals(specie, result.getIdspecie());
        assertEquals(variety, result.getIdvariety());
        assertEquals(stage, result.getIdstage());
        assertEquals(generation, result.getIdgeneration());
        }
        finally {
            container.close();
        }

    }
    
   

    /**
     * Insertion du code article dans la base en utilisant 
     *      le nom de l'article.
     *      l'espece
     *      la variété
     *      le stade 
     *      et génération 
     * On verifie que l'article, l'espece, la variété, le stade et génération sont crée dans la base
     */
    @Test 
    public void testCreateOrUpdateArticle_4args() throws Exception {
        System.out.println("createOrUpdateArticle args ");
        String idarticle = "S0101S10095C04_KG";
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TC instance = (TC)container.getContext().lookup("java:global/classes/TC");
        
        try {
        String idstage = "COM";
        String idspecie = "S0101";
        String idvariety = "S10095";
        String idgeneration="C04";
        
        Article result = instance.createOrUpdateArticle(idarticle, idstage, idspecie, idvariety,idgeneration);
        
        initialisation( idarticle);
        
        assertEquals(result, expResult);
        assertEquals(specie, result.getIdspecie());
        assertEquals(variety, result.getIdvariety());
        assertEquals(stage, result.getIdstage());
        assertEquals(generation, result.getIdgeneration());
        }
        finally {
            container.close();
        }

    }

    
    @Test
    public void getArticleBySpecieVariety() throws NamingException{
        
         
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instanceMAJArt = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        
        String idvariety="S10095";
        String specie = "S0101";
        Variety expResult = new Variety(idvariety, specie)  ;
        
        Variety result = instanceMAJArt.getArticleBySpecieVariety(specie,  idvariety) ;
        assertEquals(result, expResult);
        }
        finally {
            container.close();
        }
    }
    
    @Test
    public void getArticleByVariety() throws NamingException{
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        String idvariety="S10095";
        String specie = "S0101";
        Variety expResult = new Variety(idvariety, specie)  ;
        
        Variety result = instance.getArticleByVariety(idvariety);
        assertEquals(result, expResult);
        }
        finally {
            container.close();
        }
    }
    
    @Test
    public void getArticleByVarietyStageLagelB() throws NamingException{
        String idvariety="S10039";
        String stageLabel="B";
        String idGeneration="C04";
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        String expResult = "S0101S10039C04_B";
        Article result = instance.getArticleByVarietyStageLagel(idvariety,stageLabel,idGeneration);
        assertEquals(result.getIdarticle(), expResult);
        }
        finally {
            container.close();
        }
    }
    
    @Test
    public void getArticleByVarietyStageLagelKG() throws NamingException{
        String idvariety="S10039";
        String stageLabel="KG";
        String idGeneration="C04";
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        String expResult = "S0101S10039C04_B";
        Article result = instance.getArticleByVarietyStageLagel(idvariety,stageLabel,idGeneration);
        assertEquals(result.getIdarticle(), expResult);
        }
        finally {
            container.close();
        }
    }
    
    public void initialisation(String idarticle){
        specie = new Specie(ForItem.getIdSpecie(idarticle));
        variety = new Variety(ForItem.getIdVariety(idarticle), ForItem.getIdSpecie(idarticle));
        stage =new Stage(ForItem.getIdStageFromItem(idarticle));
        generation = new Generation(ForItem.getIdGeneration(idarticle));
        
        expResult = new Article();
        expResult.setIdarticle(idarticle);
        
        expResult.setIdspecie(specie);
        expResult.setIdvariety(variety);
        expResult.setIdstage(stage);
        expResult.setIdgeneration(generation);
        
        
    }

    /**
     * Test of getArticleByVarietyStageLagel method, of class CreateOrUpdateArticle.
     */
    @Test
    public void testGetArticleByVarietyStageLagel() throws Exception {
        System.out.println("getArticleByVarietyStageLagel");
        String idvariety = "";
        String stageLabel = "";
        String idGeneration = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        Article expResult = null;
        Article result = instance.getArticleByVarietyStageLagel(idvariety, stageLabel, idGeneration);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrUpdateArticle method, of class CreateOrUpdateArticle.
     */
    @Test
    public void testCreateOrUpdateArticle_5args() throws Exception {
        System.out.println("createOrUpdateArticle");
        String idarticle = "";
        String idstage = "";
        String idspecie = "";
        String idvariety = "";
        String idgeneration = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        Article expResult = null;
        Article result = instance.createOrUpdateArticle(idarticle, idstage, idspecie, idvariety, idgeneration);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArticleByVariety method, of class CreateOrUpdateArticle.
     */
    @Test
    public void testGetArticleByVariety() throws Exception {
        System.out.println("getArticleByVariety");
        String idvariety = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        Variety expResult = null;
        Variety result = instance.getArticleByVariety(idvariety);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArticleBySpecieVariety method, of class CreateOrUpdateArticle.
     */
    @Test
    public void testGetArticleBySpecieVariety() throws Exception {
        System.out.println("getArticleBySpecieVariety");
        String idspecie = "";
        String idvariety = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateOrUpdateArticle instance = (CreateOrUpdateArticle)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        Variety expResult = null;
        Variety result = instance.getArticleBySpecieVariety(idspecie, idvariety);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
