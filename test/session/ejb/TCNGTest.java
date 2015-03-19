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
import javax.ejb.embeddable.EJBContainer;
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
public class TCNGTest {
    Specie specie;
    Variety variety;
    Stage stage;
    Generation generation;
    Article expResult;
    
    public TCNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        specie=null;
        variety=null;
        stage=null;
        generation=null;   
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    public void initialisation(String idarticle){
        specie = new Specie(ForItem.getIdSpecie(idarticle));
        variety = new Variety(ForItem.getIdVariety(idarticle), ForItem.getIdSpecie(idarticle));
        stage =new Stage(ForItem.getIdStage(idarticle));
        generation = new Generation(ForItem.getIdGeneration(idarticle));
        
        expResult = new Article();
        expResult.setIdarticle(idarticle);
        
        expResult.setIdspecie(specie);
        expResult.setIdvariety(variety);
        expResult.setIdstage(stage);
        expResult.setIdgeneration(generation);
        
        
    }
    /**
     * Insertion du code article dans la base en utilisant le nom de l'article.
     * On verifie que l'article, l'espece, la variété, le stade et génération sont crée dans la base
     */
    @Test
    public void testCreateOrUpdateArticle_String() throws Exception {
        System.out.println("createOrUpdateArticle");
        String idarticle = "S0101S10097C04";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TC instance = (TC)container.getContext().lookup("java:global/classes/TC");
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
        String idarticle = "S0101S10096C04_KG";
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TC instance = (TC)container.getContext().lookup("java:global/classes/TC");
        
        try {
        String idstage = "COM";
        String idspecie = "S0101";
        String idvariety = "S10096";
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
    
    
}
