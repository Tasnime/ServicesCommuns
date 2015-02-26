/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Tasnime
 */
@WebService(serviceName = "ComptesWS")
public class ComptesWS {

   
    Random randN = new Random();
    //int NbrComptes = randN.nextInt(6 - 1 + 1) + 1;
    int NbrComptes = randN.nextInt(6);

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Numcomptes")
    public List Numcomptes(@WebParam(name = "name") String txt) {
        List list = new ArrayList();
        
        for(int i=0; i<NbrComptes;i++){
        Random rand = new Random();
        
      //  long value = rand.nextLong(9999999999999-1000000000000+1)+1000000000000;
       // long v=rand.nextLong();
        int nombreAleatoire = rand.nextInt(2000000 - 100000 + 1) + 100000;
        list.add (nombreAleatoire);
        }
        return list ;
    }
    
    /*  @WebMethod(operationName = "comptes")
    public List<compte> comptes(@WebParam(name = "name") String txt) {
        List<compte> list = new ArrayList();
        compte cc = new compte(); 
          Random rand = new Random();
       for(int i=0; i<NbrComptes;i++){
     
       int nombreAleatoire = rand.nextInt(2000000 - 100000 + 1) + 100000;
       
       
       cc.setNumc(nombreAleatoire);
       
        list.add (cc);
        //System.out.println(list.get(0));
        }
        return list ;
    
    }  */
    
    
         @WebMethod(operationName = "comptes")
    public List<compte> comptes(@WebParam(name = "name") String txt) {
        Random rand = new Random();
  
        List<compte> list = new ArrayList();
         
       for(int i=0; i<NbrComptes;i++){
      compte cc = new compte();
       int numCompte = rand.nextInt(2000000 - 100000 + 1) + 100000;
       double solde = rand.nextInt(500000 - 10 + 1) + 10;
        int jour = rand.nextInt(28 - 1 + 1) + 1;
        int mois = rand.nextInt(12 - 1 + 1) + 1;
        int annee = rand.nextInt(2015 - 1990 + 1) + 1990;
        String dateOuv=jour+"/"+mois+"/"+annee;
       
       
       cc.setNumc(numCompte);
       cc.setSolde(solde);
       cc.setDateOuverture(dateOuv);
       list.add (cc);
       }
        return list ;
    }
}
