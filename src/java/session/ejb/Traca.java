/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.ejb;

import entite.Article;
import entite.Batch;
import entite.Company;
import entite.Trace;
import entite.Wo;
import entite.WoPK;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class Traca {
    String CompanyId;
    String Warehouse_Id;
    String Reference_Id;
    String Transaction_Type;
    Double MGR_Unit_Quantity;
    Double MGV_Unit_Quantity;
    Double KG_Unit_Quantity;
    String Item_Number;
    String Batch_Number;
    String Year;
    String Bassin;
    String Producteur;
    String Contract;
    

    @PersistenceContext
    protected EntityManager em;
    
    @Inject
    CreateOrUpdateArticle createOrUpdateArticle;
    
    Trace trace;

     Wo wo;
    
    public Traca() {
        
    }

    public Traca(String CompanyId, String Warehouse_Id, String Reference_Id, String Transaction_Type, Double MGR_Unit_Quantity, Double MGV_Unit_Quantity, Double KG_Unit_Quantity, String Item_Number, String Batch_Number, String Year, String Bassin, String Producteur, String Contract) {
        this.CompanyId = CompanyId;
        this.Warehouse_Id = Warehouse_Id;
        this.Reference_Id = Reference_Id;
        this.Transaction_Type = Transaction_Type;
        this.MGR_Unit_Quantity = MGR_Unit_Quantity;
        this.MGV_Unit_Quantity = MGV_Unit_Quantity;
        this.KG_Unit_Quantity = KG_Unit_Quantity;
        this.Item_Number = Item_Number;
        this.Batch_Number = Batch_Number;
        this.Year = Year;
        this.Bassin = Bassin;
        this.Producteur = Producteur;
        this.Contract = Contract;
    }
    
    
    public void setInfo(String CompanyId, String Warehouse_Id, String Reference_Id, String Transaction_Type, Double MGR_Unit_Quantity, Double MGV_Unit_Quantity, Double KG_Unit_Quantity, String Item_Number, String Batch_Number, String Year, String Bassin, String Producteur, String Contract) {
        this.CompanyId=CompanyId ;
        this.Warehouse_Id=Warehouse_Id ;
        this.Reference_Id=Reference_Id ;
        this.Transaction_Type=Transaction_Type ;
        this.MGR_Unit_Quantity= MGR_Unit_Quantity;
        this.MGV_Unit_Quantity=MGV_Unit_Quantity ;
        this.KG_Unit_Quantity= KG_Unit_Quantity; 
        this.Item_Number= Item_Number;
        System.out.println("Article $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+this.Item_Number);
        this.Batch_Number= Batch_Number;
        this.Year= Year; 
        this.Bassin= Bassin;
        this.Producteur= Producteur;
        this.Contract=Contract;        
    }
        
    public void createTraca(){    
        //createOrUpdateArticle.createOrUpdateArticle("S0101S10031C04_C");
        
        //createOrUpdateArticle = new  CreateOrUpdateArticle();
        Article idarticle = createOrUpdateArticle.createOrUpdateArticle(this.Item_Number);
        
        
        trace = new Trace();
        trace.setWarehouse(Warehouse_Id);
        trace.setIdarticle(idarticle);
        Company company = new Company(CompanyId);
        trace.setIdcompany(company);
        
        wo = createWo();// CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type, MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number, Year, Bassin, Producteur, Contract); 
        trace.setIdwo(wo);
        
        createBatch();// CompanyId,  Warehouse_Id,  Reference_Id,  Transaction_Type, MGR_Unit_Quantity,  MGV_Unit_Quantity,  KG_Unit_Quantity,  Item_Number,  Batch_Number, Year, Bassin, Producteur, Contract);
        
        setTraceQuantity();
        em.merge(trace);
    }

    private Wo createWo(){//String CompanyId, String Warehouse_Id, String Reference_Id, String Transaction_Type, Double MGR_Unit_Quantity, Double MGV_Unit_Quantity, Double KG_Unit_Quantity, String Item_Number, String Batch_Number, String Year, String Bassin, String Producteur, String Contract) {
        
        WoPK woPK =new WoPK(Reference_Id, CompanyId);
        wo = new Wo(woPK);
        return wo;
    }
    
    private void setTraceQuantity(){
        trace.setQuantity(this.KG_Unit_Quantity);
        trace.setUnits("Kg");
        trace.setTracetype(Transaction_Type);
    }
    private void createBatch(){//String CompanyId, String Warehouse_Id, String Reference_Id, String Transaction_Type, Double MGR_Unit_Quantity, Double MGV_Unit_Quantity, Double KG_Unit_Quantity, String Item_Number, String Batch_Number, String Year, String Bassin, String Producteur, String Contract) {
        Batch batch= new Batch();
        batch.setBatchname(Batch_Number);
        batch.setIdarticle(trace.getIdarticle());
        batch.setIdwo(trace.getIdwo());
        batch.setContract(Contract);
    
        trace.setBatchname(batch);
        //return trace;
    }


    
}
