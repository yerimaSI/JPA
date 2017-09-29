/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import entites.IndicateurPerformance;
import entites.Livrable;
import entites.Projet;
import java.util.Date;

/**
 *
 * @author Iskilou Yerima
 */
public class LivrableCrud extends ObjectCrud {

    public LivrableCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }

    public void creerLivrable() {
        Livrable livrable = new Livrable();

        livrable.setDateDeDebut(new Date());
        livrable.setDateDeLivraison(new Date());
        livrable.setNom(" Rapport");
        livrable.setProjet(new Projet());
        livrable.setIndicateurPerformance(new IndicateurPerformance());
        try {

               this.persiste(livrable);
        } catch (Exception e) {
        }

    }
}
