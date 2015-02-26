/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;



/**
 *
 * @author Tasnime
 */
@WebService(serviceName = "CartesWS")
public class CartesWS {
String cartes[] = {"Carte classique", "Carte Gold", "Master Card"};
    /**
     * This is a sample web service operation
     * @return 
     */
     @WebMethod(operationName = "cartes")
     public List<carte> cartes() {

        List<carte> list = new ArrayList();
         
    for (String carte : cartes) {
        carte cc = new carte();
        cc.setType(carte);
        list.add (cc);
    }

        return list ;
    }

}
