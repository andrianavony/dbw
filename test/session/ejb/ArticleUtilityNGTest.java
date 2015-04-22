/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import utilities.ArticleUtility;
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
public class ArticleUtilityNGTest {
    
    String idspecie ;
    String idvariety ;
    String idstage;
    String idgeneration;
    String batchname ;
    String companyname ;

    String idspecieRes ;
    String idvarietyRes ;
    String idstageRes;
    String idgenerationRes;
    String batchnameRes ;
    String companynameRes ;
    
    
     Specie specie;
    Variety variety;
    Stage stage;
    Generation generation;
    Article expResult;
    
    //@Inject ArticleUtility createOrUpdateArticle;
    
    public ArticleUtilityNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
         idspecie = "S0101";
         idvariety = "S10095";
         idstage = "COM";
         idgeneration = "C04";
         batchname = "unknomnBatch";
         companyname = "unknomnCompagny";
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
        /**
     * Test of createOrUpdateArticle method, of class BatchManager.
     */
    @Test
    public void testCreateOrUpdateArticle() throws Exception {
        System.out.println("createOrUpdateArticle");
        String idspecie = "S0101";
        String idvariety = "S10095";
        String idgeneration = "C04";
        String idstage = "COM";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/ArticleUtility");
        Article expResult = null;
        try{
            Article result = instance.createOrUpdateArticle(idspecie, idvariety, idgeneration, idstage);
            
            System.out.println("result 5 args jaona "+result);
            idspecieRes=result.getIdspecie().getIdspecie();
            System.out.println("idspecieRes "+idspecieRes);
            idstageRes=result.getIdstage().getIdstage();
            System.out.println("idstageRes "+idstageRes);
            idvarietyRes=result.getIdvariety().getIdvariety();
            System.out.println("idvarietyRes "+idvarietyRes);
            idgenerationRes=result.getIdgeneration().getIdgeneration();
            System.out.println("idgenerationRes "+idgenerationRes);
            
            System.out.println("batchnameRes "+batchnameRes);
            System.out.println("companynameRes"+companynameRes);
            
            assertEquals(idspecie,idspecieRes );
            assertEquals(idstage , idstageRes );
            assertEquals(idvariety ,idvarietyRes);
            assertEquals(idgeneration ,idgenerationRes);
         } finally {
            container.close();
        }
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
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/ArticleUtility");
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
        ArticleUtility instanceMAJArt = (ArticleUtility)container.getContext().lookup("java:global/classes/ArticleUtility");
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
    
    /***
     * une varité n'appartinent qu à une seule espece
     * @throws NamingException 
     */
    @Test
    public void getArticleByVariety() throws NamingException{
        
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
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
        String idvariety="S10095";
        String stageLabel="B";
        String idGeneration="C04";
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        String expResult = "S0101S10095C04_B";
        Article result = instance.getArticleByVarietyStageLagel(idvariety,stageLabel,idGeneration);
        assertEquals(result.getIdarticle(), expResult);
        }
        finally {
            container.close();
        }
    }
    
    @Test
    public void getArticleByVarietyStageLagelKG() throws NamingException{
        String idvariety="S10095";
        String stageLabel="KG";
        String idGeneration="C04";
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        try {
        String expResult = "S0101S10095C04_KG";
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
     * Test of getArticleBySpecieVariety method, of class ArticleUtility.
     */
    @Test
    public void testGetArticleBySpecieVariety() throws Exception {
        System.out.println("getArticleBySpecieVariety");
        String idvariety="S10095";
        String idspecie = "S0101";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ArticleUtility instance = (ArticleUtility)container.getContext().lookup("java:global/classes/CreateOrUpdateArticle");
        Variety expResult = null;
        try {
            Variety result = instance.getArticleBySpecieVariety(idspecie, idvariety);
            assertEquals(result, expResult);
        }
        finally {
            container.close();
        }
    }
}
