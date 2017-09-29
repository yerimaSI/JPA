/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.Bailleur;
import entites.Fournisseur;
import entites.Programme;
import entites.Projet;
import entites.TypeDeBailleur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Iskilou Yerima
 */
public class BailleurCrud extends ObjectCrud {

    public BailleurCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();

    }

    public boolean creerBailleur(Bailleur bailleur) {

        boolean bol = false;

        bailleur.setNom("OMS");
        bailleur.setTypeDeBailleur(TypeDeBailleur.PARTENAIREINTERNATIONALE);
        if (bailleur.getProgramme() == null) {
            bailleur.setProgramme(new ArrayList<Programme>());
        }
        if (bailleur.getProjet() == null) {
            bailleur.setProjet(new ArrayList<Projet>());
        }
        try {
            if (bailleur != null) {
                bol = this.persiste(bailleur);
            }

            return bol;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean modifierBailleur(Bailleur bailleur) {
        Bailleur b = new Bailleur();
        boolean bol = false;

        return bol;
    }

    public List<Bailleur> findBailleurByProgramme() {
        List<Bailleur> bailleur = new ArrayList<Bailleur>();

        try {
            String requete = "SELECT  b  FROM  tp_Bailleur b  LEFT OUT JOIN tp_Programme.Bailleur  b ";
            Query query = this.getDataManager().getEm().createQuery(requete);
            bailleur = query.getResultList();
            return bailleur;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Bailleur> findBailleurbyProject() {
        List<Bailleur> bailleur = new ArrayList<Bailleur>();
        try {
            String requete = "SELECT  b  FROM  tp_Bailleur b  LEFT OUT JOIN tp_Programme.Bailleur  b ";
            Query query = this.getDataManager().getEm().createQuery(requete);

            bailleur = query.getResultList();
            return bailleur;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
