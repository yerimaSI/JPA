/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import entites.IndicateurPerformance;
import entites.IndicateurQualitatif;
import entites.IndicateurQuantitatif;
import java.util.ArrayList;

/**
 *
 * @author Iskilou Yerima
 */
public class IndicateurPerformanceCrud extends ObjectCrud {
 
    public IndicateurPerformanceCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
        
    }
 
    public void creerIndicateurPerformance(IndicateurPerformance  indicateurPerformance )
    {
        if(indicateurPerformance== null)
        {
            indicateurPerformance.setLibelle("fiabilité");
            indicateurPerformance.setNature("annuel");
            indicateurPerformance.setValeur("satisfaisant");
            indicateurPerformance.setIndicateurQualitatif( new ArrayList<IndicateurQualitatif>());
            indicateurPerformance.setIndicateurQuantitatif( new ArrayList<IndicateurQuantitatif>());
            
        }
          try {
                this.persiste(indicateurPerformance);
            } catch (Exception e) {
                e.getMessage();
            }

          
    }
      
     public  IndicateurPerformance lireIndicateurPerformance(int reference )
             
     {
         
         IndicateurPerformance indicateur = new IndicateurPerformance();
         
         indicateur = this.getDataManager().getEm().find(IndicateurPerformance.class, reference);
         
         return  null;
     }
    
}
