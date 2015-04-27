/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbw.ws.tc;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;
import objet.metier.excel.TC;

/**
 *
 * @author S.ANDRIANAVONY
 */
@WebService(serviceName = "WS_TC")
@Stateless()
public class WS_TC {

    @Inject 
    TC tc ;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addArticle")
    public String addArticle(@WebParam(name = "idArticle") String idArticle) {
        
        tc.createOrUpdateArticle (idArticle);
        return "OK";
    }
}
