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
public class TracaBeanNGTest {
    String CompanyId="LMG";
    String Warehouse_Id="NZAT63";
    String Reference_Id="P02_012719";
    String Transaction_Type="ProdLine";
    String Item_Number="S0101S10032C04_C";
    String Year="2011";
    String Bassin="LIMAGNE";
    String Producteur="GAEC DELOCHE LEMEE";
    String Contract="0353 1 L00408";
    public TracaBeanNGTest() {
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
     * Test of createTraca method, of class TracaBean.
     */
    @Test
    public void testCreateTraca() throws NamingException {
        System.out.println("createTraca");
        
        Double MGR_Unit_Quantity=-35909.09;
        Double MGV_Unit_Quantity=-32318.18;
        Double KG_Unit_Quantity=-2370.00;
        String Batch_Number="FR63AL11S01010002";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TracaBean instance = (TracaBean)container.getContext().lookup("java:global/classes/TracaBean");
        try{
        
        instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
        instance.createTraca();
        
                
        MGR_Unit_Quantity=-40606.06;
        MGV_Unit_Quantity=-36545.45;
        KG_Unit_Quantity=-2680.00;
        Batch_Number="FR63AL11S01010004";
        
        
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
        
        
        MGR_Unit_Quantity=-37575.76;
        MGV_Unit_Quantity=-33818.18;
        KG_Unit_Quantity=-2480.00;
        Batch_Number="FR63AL11S01010005";
        
        
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
        
        MGR_Unit_Quantity=-40606.06;
        MGV_Unit_Quantity=-36545.45;
        KG_Unit_Quantity=-3440.00;
        Batch_Number="FR63AL11S01010006";
        
        
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
        
        
        MGR_Unit_Quantity=-40606.06;
        MGV_Unit_Quantity=-36545.45;
        KG_Unit_Quantity=-1280.00;
        Batch_Number="FR63AL11S01010026";
        
        
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
        
            MGR_Unit_Quantity=-40606.06;
        MGV_Unit_Quantity=-36545.45;
        KG_Unit_Quantity=11072.00;
        Transaction_Type ="Production";
        
        Batch_Number="NEK000990NZ";
        
        
            instance.setInfo( CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type,  MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number,  Year,  Bassin,  Producteur,  Contract);
            instance.createTraca();
            
        }
        finally {
            container.close();
        }
        
        
        
        

    }
    
}
