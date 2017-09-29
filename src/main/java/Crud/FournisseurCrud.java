/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.Fournisseur;
import entites.Programme;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Iskilou Yerima
 */
public class FournisseurCrud extends ObjectCrud {

    public FournisseurCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }

    public boolean creerFournisseur() {

        boolean bol = false;
        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setNom("MISP");
        fournisseur.setProgramme(new ArrayList<Programme>());
        fournisseur.setProjet(new ArrayList<>());

        try {
            if (fournisseur != null) {
                bol = this.persiste(fournisseur);
            }

            return bol;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Fournisseur> findFournisseurbyProgramme() {

        try {
            String requete = "SELECT  f FROM  tp_Fournisseur  f LEFT OUT JOIN tp_Programme.Fournisseur f   ";
            Query query = this.getDataManager().getEm().createQuery(requete);

            List<Fournisseur> fournisseurs = query.getResultList();

            return fournisseurs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Fournisseur> findFournisseurbyProjet() {

        try {

            String requete = "SELECT  f FROM  tp_Fournisseur  f LEFT OUT JOIN tp_Programme.Fournisseur f   ";
            Query query = this.getDataManager().getEm().createQuery(requete);

            List<Fournisseur> fournisseurs = query.getResultList();

            return fournisseurs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
}
