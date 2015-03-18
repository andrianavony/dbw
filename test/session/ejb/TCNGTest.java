/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Generation;
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
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of createOrUpdateArticle method, of class TC.
     */
    @Test
    public void testCreateOrUpdateArticle_String() throws Exception {
        System.out.println("createOrUpdateArticle");
        String idarticle = "S0101S10096C04";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TC instance = (TC)container.getContext().lookup("java:global/classes/TC");
        Article result = instance.createOrUpdateArticle(idarticle);
        System.out.println("*********************************insertion faite");
        Article expResult = new Article();
        expResult.setIdarticle(idarticle);
        //expResult.setIdspecie(ForItem.getIdSpecie(idarticle));
        
        //solofo expResult.setIdvariety(ForItem.getIdVariety(idarticle));
        Variety variety = new Variety(ForItem.getIdVariety(idarticle), ForItem.getIdSpecie(idarticle));
        expResult.setIdvariety(variety);//variety(ForItem.getIdVariety(idarticle));

        expResult.setIdstage(new Stage(ForItem.getIdStage(idarticle)));
        expResult.setIdgeneration(new Generation(ForItem.getIdStage(idarticle)));
        
        assertEquals(result, expResult);
        container.close();

    }

    /**
     * Test of createOrUpdateArticle method, of class TC.
     */
    @Test 
    public void testCreateOrUpdateArticle_4args() throws Exception {
        System.out.println("createOrUpdateArticle args ");
        String idarticle = "S0101S10096C04_KG";
        String idstage = "COM";
        String idspecie = "S0101";
        String idvariety = "S1009";
        String idgeneration="C04";
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TC instance = (TC)container.getContext().lookup("java:global/classes/TC");
        Article expResult = new Article();
        expResult.setIdarticle(idarticle);
        //expResult.setIdspecie(ForItem.getIdSpecie(idarticle));
        //expResult.setIdvariety(ForItem.getIdVariety(idarticle));
        Variety variety = new Variety(ForItem.getIdVariety(idarticle), ForItem.getIdSpecie(idarticle));
        expResult.setIdvariety(variety);//variety(ForItem.getIdVariety(idarticle));

        expResult.setIdstage(new Stage(ForItem.getIdStage(idarticle)));
        expResult.setIdgeneration(new Generation(ForItem.getIdStage(idarticle)));
        Article result = instance.createOrUpdateArticle(idarticle, idstage, idspecie, idvariety,idgeneration);
        assertEquals(result, expResult);
        container.close();

    }
    
    
}
