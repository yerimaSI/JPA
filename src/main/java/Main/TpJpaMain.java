/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Crud.FournisseurCrud;
import Crud.PersonneCrud;
import Utiles.DataManager;

/**
 *
 * @author Iskilou Yerima
 */
public class TpJpaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        dataManager.initEntityManager();
        PersonneCrud personneCrud = new PersonneCrud(dataManager);
        personneCrud.creerPersonne();
        FournisseurCrud fournisseurCrud = new FournisseurCrud(dataManager);
        

        System.out.println("maven project");

    }

    public boolean Enregistrer(Object obj) {

        return false;
    }

}
