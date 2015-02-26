/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMouvements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Tasnime
 */
@WebService(serviceName = "TestMouvementsWS")
public class TestMouvementsWS {

   String operations[] = {"Virement reçu", "Communission virement reçu", "TVA" , "Retrait espèces" , "Versement"};

    Random randN = new Random();
 
    int NbrOperations = randN.nextInt(120);
    /**
     * This is a sample web service operation
     */
  
  @WebMethod(operationName = "mouvements")
  
    public List<mouvements.mouvement> mouvements(@WebParam(name = "d1") String d1, @WebParam(name = "d2") String d2) throws ParseException {
  
SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd"); 
Date dateObj1 = curFormater.parse(d1); 
Date dateObj2 = curFormater.parse(d2);
Calendar calendar1 = Calendar.getInstance();
Calendar calendar2 = Calendar.getInstance();
calendar1.setTime(dateObj1);
calendar2.setTime(dateObj2);
   
int annee1 = calendar1.get(Calendar.YEAR);
int mois1 = calendar1.get(Calendar.MONTH)+1; 
int jour1 = calendar1.get(Calendar.DAY_OF_MONTH); 
 String dd=jour1 +"/"+ mois1+"/"+annee1;

 
 
int annee2 = calendar2.get(Calendar.YEAR);
int mois2 = calendar2.get(Calendar.MONTH)+1;  
int jour2 = calendar2.get(Calendar.DAY_OF_MONTH);
 String dd2=jour2 +"/"+ mois2+"/"+annee2;

    
        Random rand = new Random();
  
        List<mouvements.mouvement> list = new ArrayList();
         
       for(int i=0; i<NbrOperations;i++){
      mouvements.mouvement cc = new mouvements.mouvement();
      
       int debit = 0;
        int credit = 0;
       
        int mvmt = rand.nextInt(4);
       String lmvmt=operations[mvmt];
      /* int jour = rand.nextInt(28 - 1 + 1) + 1;
        int mois = rand.nextInt(12 - 1 + 1) + 1;
        int annee = rand.nextInt(2015 - 1990 + 1) + 1990;*/
        int jour = rand.nextInt(Math.abs(jour2 - jour1) + 1) + jour1;
        int mois = rand.nextInt(Math.abs(mois2 - mois1) + 1) + mois1;
        int annee = rand.nextInt(Math.abs(annee2 - annee1) + 1) + annee1;
       // String dateOp=jour+"/"+mois+"/"+annee;
        String j=""+jour;
        String m=""+mois;
        if(mois<10){
            m="0"+mois;
        }

        if(jour<10){
            j="0"+jour;
        }
       String dateOp=annee+"-"+m+"-"+j;
        
     //  String dateOp=annee+"-"+"01"+"-"+"01";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(dateOp));
c.add(Calendar.DATE, 1);  // number of days to add
String date1 = sdf.format(c.getTime()); // dt is now the new date
        
        
/*

SimpleDateFormat curFormater1 = new SimpleDateFormat("yyyy-MM-dd"); 

Date dateV = curFormater1.parse(date1);
Calendar calendarV = Calendar.getInstance();

calendarV.setTime(dateV);

   
//int annee1 = calendar1.get(Calendar.YEAR);
int moisV = calendarV.get(Calendar.MONTH)+1; 
int jourV = calendarV.get(Calendar.DAY_OF_MONTH); 

if((moisV==01 && (jourV==01 || jourV==03 || jourV==14)) || (moisV==03 && jourV==20) || (moisV==04 && jourV==9) || (moisV==05 && jourV==01) || (moisV==07 && (jourV==18 || jourV==25)) || (moisV==8 && jourV==13) || (moisV==9 && jourV==23) || (moisV==10 && jourV==15))
   
{
  
c.setTime(sdf.parse(date1));
c.add(Calendar.DATE, 1); 
date1 = sdf.format(c.getTime());
        

}*/
       
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
