/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import java.math.BigInteger;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class BatchManagerNGTest {
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
    
    @PersistenceContext ()
    protected EntityManager em;
    
    public BatchManagerNGTest() {
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
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
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
     * Test of createOrUpdateBatch method, of class BatchManager.
     */
    @Test
    public void testCreateOrUpdateBatch_6args() throws Exception {
        System.out.println("testCreateOrUpdateBatch_6args");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");

        try {
            Batch result = instance.createOrUpdateBatch(idspecie, idvariety, idstage, idgeneration, batchname, companyname);
            System.out.println("result jaona 6 args "+result);

            setResults(result);
            
            System.out.println("idspecieRes "+idspecieRes);
            System.out.println("idstageRes "+idstageRes);
            System.out.println("idvarietyRes "+idvarietyRes);
            System.out.println(batchname +" batchname => batchnameRes "+batchnameRes);
            System.out.println(companyname + " companyname => companynameRes "+companynameRes);
            
            


            assertEquals(idspecie ,idspecieRes );
            assertEquals(idstage ,idstageRes );
            assertEquals(idvariety ,idvarietyRes);
            assertEquals(batchname ,batchnameRes );
            assertEquals(companyname ,companynameRes); 
        } finally {
            container.close();
        }
    }

    /**
     * Test of createOrUpdateBatch method, of class BatchManager.
     */
    //@Test
    public void testCreateOrUpdateBatch_5args() throws Exception {
        System.out.println("createOrUpdateBatch");
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        
        try{
        Batch result = instance.createOrUpdateBatch(idvariety, idstage, idgeneration, batchname, companyname);
            System.out.println("result 5 args jaona "+result);
            System.out.println("idspecieRes "+idspecieRes);
            System.out.println(idstage +" idstageRes "+idstageRes);
            System.out.println("idvarietyRes "+idvarietyRes);
            System.out.println("batchnameRes "+batchnameRes);
            System.out.println("companynameRes"+companynameRes);
            
            assertEquals(idspecie ,idspecieRes );
            assertEquals(idstage ,idstageRes );
            assertEquals(idvariety ,idvarietyRes);
            assertEquals(batchname ,batchnameRes);
            assertEquals(companyname ,companynameRes); 
         } finally {
            container.close();
        }
    }

    /**
     * Test of createOrUpdateBatch method, of class BatchManager.
     */
    //@Test
    public void testCreateOrUpdateBatch_3args() throws Exception {
        System.out.println("createOrUpdateBatch");
        String batchName = "";
        Article idarticle = null;
        String companyName = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        Batch expResult = null;
        Batch result = instance.createOrUpdateBatch(batchName, idarticle, companyName);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatchCurrent method, of class BatchManager.
     */
    //@Test
    public void testGetBatchCurrent() throws Exception {
        System.out.println("getBatchCurrent");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        Batch expResult = null;
        Batch result = instance.getBatchCurrent();
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addresults method, of class BatchManager.
     */
    @Test
    public void testAddresults() throws Exception {
        System.out.println("***************************************** addresults");
        String mesurename = "Moyenne Humidité";
        String rawresults = "10";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
            System.out.println(" avant creation BatchManager ");
            BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
            System.out.println(" apres creation BatchManager ");
            
            Article article= new Article("S0101S10095C04");
            Batch batch=instance.createOrUpdateBatch(batchname, "S0101S10095C04", "unknomnCompagny");//companyname);
            System.out.println(" jaona batch "+batch.getIdcompany());
            System.out.println("demande test BatchManager addresults");
            instance.addresults(batch, new BigInteger("357"),"Grains Entiers", mesurename, rawresults);
            mesurename="Poids Sec";
            rawresults="11";
            instance.addresults(batch, new BigInteger("357"),"Grains Entiers", mesurename, rawresults);
            container.close();
        } finally {
            container.close();
        }
            
    }
    
    public void setResults(Batch batch){


    Article article =   batch.getIdarticle();
    idspecieRes = article.getIdspecie().getIdspecie();
    idvarietyRes =article.getIdvariety().getIdvariety();
     idstageRes=article.getIdstage().getIdstage();
     idgenerationRes =article.getIdgeneration().getIdgeneration();
     batchnameRes = batch.getBatchname() ;
     companynameRes=batch.getIdcompany().getIdcompany();
    }

    /**
     * Test of getArticleByVarietyStageLagel method, of class BatchManager.
     */
    //@Test
    public void testGetArticleByVarietyStageLagel() throws Exception {
        System.out.println("getArticleByVarietyStageLagel");
        String idvariety = "";
        String stageLabel = "";
        String idgeneration = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        Article expResult = null;
        Article result = instance.getArticleByVarietyStageLagel(idvariety, stageLabel, idgeneration);
        assertEquals(result, expResult);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
