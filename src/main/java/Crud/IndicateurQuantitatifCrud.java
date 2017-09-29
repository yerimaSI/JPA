/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.IndicateurPerformance;
import entites.IndicateurQuantitatif;

/**
 *
 * @author Iskilou Yerima
 */
public class IndicateurQuantitatifCrud extends ObjectCrud {
    
    public IndicateurQuantitatifCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
        
    }
   public  void creerIndicateurQuantitatif(IndicateurQuantitatif indicateurQuantitatif)
   {
        if (indicateurQuantitatif ==null) {
           indicateurQuantitatif.setNom("progression");
           indicateurQuantitatif.setPropriete("level");
           indicateurQuantitatif.setValeur(0);
           indicateurQuantitatif.setIndicateurPerformance(this.getDataManager().getEm().find(IndicateurPerformance.class, 1));
       }
        try {
           this.persiste(indicateurQuantitatif);
       } catch (Exception e) {
       }
   }
}
