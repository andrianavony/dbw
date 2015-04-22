/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Analysis;
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
     * Test of retrieveBatchFromIdBatch method, of class FacadeSaisieResultats.
     */
    @Test
    public void testCreateBatch_4args_2() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance =  (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        try{
        System.out.println("createBatch inexistant ");
        String batchname = "lotInexistant";
        String idarticle = "S0101S10128C04_C";
        String idcompany = "lvh";
        BigInteger limsbatchid = new BigInteger("1");
        
        
        Batch result = instance.createOrRetrieveBatch(batchname, idarticle, idcompany, limsbatchid);
            assertNotNull(result);
            
        assertEquals(result.getBatchname(), batchname);
        assertEquals(result.getIdarticle().getIdarticle(), idarticle);
        assertEquals(result.getIdbatch(), limsbatchid);
        
        } finally {
            container.close();
        }
    }
    
/**
     * Test of findExistingBatchByBatchId method, of class FacadeSaisieResultats.
     */
    @Test
    public void testFindExistingBatchByBatchId() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance =  (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        try{
        System.out.println("retrieveBatchFromIdBatch");
        BigInteger idbatch = new BigInteger("1");
        Batch expResult = new Batch(idbatch) ;
        Batch result = instance.retrieveBatchFromIdBatch(idbatch);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "ES00NE13S10128C04C00321703");        
        } finally {
            container.close();
        }
    }
    
        /**
     * Le lot existe déjà
     */
    @Test
    public void testCreateBatchLotExistant() throws Exception {
        
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BatchManager instance =  (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
        try{    
        System.out.println("createBatch");
        String batchname = "";
        String articlename = "";
        String idcompany = "";
        BigInteger limsbatchid = new BigInteger ("80604");
        BigInteger idbatch = new BigInteger("10");
        Batch expResult = new Batch(idbatch) ;
        
        Batch result = instance.createOrRetrieveBatch(batchname, articlename, idcompany, limsbatchid);
        assertEquals(result, expResult);
        assertEquals(result.getBatchname(), "FR26AV13S01010184");
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
            Batch result = instance.createOrRetrieveBatch(idspecie, idvariety, idstage, idgeneration, batchname, companyname);
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
     * On cree un lot puis on demande la creation de DL
     * On test que le lot associé au DL est bien le lot utilisé pour la creation du DL.
     * Si on crée un deuxième lot avec les 3 mêmes critères on obtient bien le même lots 
     */
    @Test
    public void testsameCaseFile() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        try{
            System.out.println(" avant creation BatchManager ");
            BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
            System.out.println(" apres creation BatchManager ");
            
            Article article= new Article("S0101S10095C04");
            Batch batch=instance.createOrUpdateBatch(batchname, "S0101S10095C04", "unknomnCompagny");//companyname); 
            
            assertEquals(batch, instance.getBatchCurrent());
            entite.Casefile casefile = instance.createOrRetriveCaseFileCurrent();
            assertNotNull(casefile.getIdcasefile());
            assertTrue(casefile.getIscurrent());
            
            
            Batch batchfromCaseFile =casefile.getIdbatch();
            assertEquals(batch, batchfromCaseFile);
           Batch sameBatch=instance.createOrUpdateBatch(batchname, "S0101S10095C04", "unknomnCompagny");//companyname);
            
            assertEquals(sameBatch, batch);
            instance.setBatchCurrent(sameBatch);
            entite.Casefile samecasefile = instance.createOrRetriveCaseFileCurrent();
            assertNotNull(samecasefile.getIdcasefile(), " le dossier doit être le meme avec le meme triplet");

            assertEquals(samecasefile, casefile);
            
            container.close();
        } finally {
            container.close();
        }
            
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
        //try{
            System.out.println(" avant creation BatchManager dans testAddresults ");
            BatchManager instance = (BatchManager)container.getContext().lookup("java:global/classes/BatchManager");
            System.out.println(" apres creation BatchManager dans testAddresults");
            
            Article article= new Article("S0101S10095C04");
            Batch batch=instance.createOrUpdateBatch(batchname, "S0101S10095C04", "unknomnCompagny");//companyname);
            //OF026803
            batch=instance.createOrUpdateBatch("F0964W010226GF2", "S0101S10041C04_A", "LVH");//companyname);
            //F0964W005540NZ S0101S10041C04
            System.out.println(" jaona batch "+batch.getIdcompany());
            System.out.println("demande test BatchManager addresults");
            entite.Analysis analysis=instance.addresults( new BigInteger("357"),"Grains Entiers", mesurename, rawresults);
            assertNotNull(analysis);
            assertNotNull(analysis.getIdsamples());
           
            AnalysisManager analysisManager = (AnalysisManager)container.getContext().lookup("java:global/classes/AnalysisManager");
            
            analysisManager.setAnalysis (analysis);
            mesurename="Poids Sec";
            rawresults="11";                              
            assertNotNull(analysisManager);
            
            Analysis memeAnalysis= analysisManager.addresults(new BigInteger("357"),"Grains Entiers", mesurename, rawresults);
           assertEquals(memeAnalysis, analysis);
            container.close();
            
        /*
        } finally {
            container.close();
        }
        */    
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

   


    
}
