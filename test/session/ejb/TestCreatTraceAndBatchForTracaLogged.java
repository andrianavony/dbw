/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
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
public class TestCreatTraceAndBatchForTracaLogged {
    
    public TestCreatTraceAndBatchForTracaLogged() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CreateTracaLogged instance = (CreateTracaLogged)container.getContext().lookup("java:global/classes/CreateTracaLogged");
        try {
            instance.createTraceAndBatchForTracaLogged();
        }
        finally {
            container.close();
        }

    }
}
