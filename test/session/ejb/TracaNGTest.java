/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
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
public class TracaNGTest {
    String CompanyId="LMG";
    String Warehouse_Id="NZAT63";
    String Reference_Id="P02_012719";
    String Transaction_Type="ProdLine";
    String Item_Number="S0101S10032C04_C";
    String Year="2011";
    String Bassin="LIMAGNE";
    String Producteur="GAEC DELOCHE LEMEE";
    String Contract="0353 1 L00408";
    public TracaNGTest() {
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
     * Test of createTraca method, of class Traca.
     */
    @Test
    public void testCreateTraca() throws NamingException {
        System.out.println("createTraca");
        
        Double MGR_Unit_Quantity=-35909.09;
        Double MGV_Unit_Quantity=-32318.18;
        Double KG_Unit_Quantity=-2370.00;
        String Batch_Number="FR63AL11S01010002";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Traca instance = (Traca)container.getContext().lookup("java:global/classes/Traca");
        try {
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
        }
        finally {
            container.close();
        }

    }
    
}
