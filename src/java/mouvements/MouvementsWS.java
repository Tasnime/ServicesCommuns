/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouvements;


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
@WebService(serviceName = "MouvementsWS")
public class MouvementsWS {
    
  /* public static Date d2=new Date();
   public static Date d1=new Date("02/02/2013");
  
  // Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse("31/02/2000");*/
 
String operations[] = {"Virement reçu", "Communission virement reçu", "TVA" , "Retrait espèces" , "Versement"};

    Random randN = new Random();
 
    int NbrOperations = randN.nextInt(20);
    /**
     * This is a sample web service operation
     */
  
  @WebMethod(operationName = "mouvements")
  /*(@WebParam(name = "i") int i, 
      @WebParam(name = "j") int j*/
  
    public List<mouvement> mouvements(@WebParam(name = "name") String txt) {
       
      /*  int jour1=d1.getDay();
        int mois1=d1.getMonth()+1;
        int annee1=d1.getYear();
        
        int jour2=d2.getDay();
        int mois2=d2.getMonth()+1;
        int annee2=d2.getYear();*/
        //d1="02/02/2013";
        
     
        Random rand = new Random();
  
        List<mouvement> list = new ArrayList();
         
       for(int i=0; i<NbrOperations;i++){
      mouvement cc = new mouvement();
       
      ////
      
       int debit = 0;
        int credit = 0;
       
        int mvmt = rand.nextInt(4);
       String lmvmt=operations[mvmt];
       int jour = rand.nextInt(28 - 1 + 1) + 1;
        int mois = rand.nextInt(12 - 1 + 1) + 1;
        int annee = rand.nextInt(2015 - 1990 + 1) + 1990;
      /*  int jour = rand.nextInt(Math.abs(jour2 - jour1) + 1) + jour1;
        int mois = rand.nextInt(Math.abs(mois2 - mois1) + 1) + mois1;
        int annee = rand.nextInt(Math.abs(annee2 - annee1) + 1) + annee1;*/
        String dateOp=jour+"/"+mois+"/"+annee;
       
       if(mvmt==0)
       {
         
           credit=rand.nextInt(100000 - 100 + 1) + 100;
       }
        
        if(mvmt==1)
       {
           debit=rand.nextInt(100000 - 10 + 1) + 10;
          
       }
        
        if(mvmt==2)
       {
           debit=rand.nextInt(100 - 1 + 1) + 1;
         
       }
        
        if(mvmt==3)
       {
           debit=rand.nextInt(10000 - 10 + 1) + 10;
           
       }
         if(mvmt==4)
       {
           
           credit=rand.nextInt(100000 - 10 + 1) + 10;
           
       }
      
      
      
      //// 
       cc.setDateOp(dateOp);
       cc.setDateVal("");
       cc.setOperation(lmvmt);
       cc.setDebit(debit);
       cc.setCredit(credit);
       list.add (cc);
       }
        return list ;
    }


}


