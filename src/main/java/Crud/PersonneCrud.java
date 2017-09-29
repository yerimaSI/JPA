/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import entites.Personne;
import entites.TypePersonne;

/**
 *
 * @author Iskilou Yerima
 */
public class PersonneCrud extends ObjectCrud {

    public PersonneCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }

    public void creerPersonne() throws NullPointerException {
        Personne personne = new  Personne();
        if (personne == null) {
            personne.setNom("Enzo");
            personne.setPrenom("Ferrari");
            personne.setFonction("Ingenieur");
            personne.setAdresse("C2078 Cotonou");
            personne.setTypePersonne(TypePersonne.PERSONNEPHYSIQUE);

            try {
                this.persiste(personne);
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }
    
       
    
    
}
