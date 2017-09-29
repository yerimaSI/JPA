/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.IndicateurPerformance;
import entites.IndicateurQualitatif;

/**
 *
 * @author Iskilou Yerima
 */
public class IndicateurQualitatifCrud extends ObjectCrud {
    
    public IndicateurQualitatifCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
        
    }
      
    public void creerIndicateurQualitatif(IndicateurQualitatif indicateurQualitatif)
    {
         indicateurQualitatif.setNom("attractif");
         indicateurQualitatif.setPropriete("pondere");
         indicateurQualitatif.setValeur("assez-bien");
         indicateurQualitatif.setIndicateurPerformance(this.getDataManager().getEm().find(IndicateurPerformance.class, 1));
         
         try {
                this.persiste(indicateurQualitatif);
            } catch (Exception e) {
                e.getMessage();
            }

    }
    
    
}
