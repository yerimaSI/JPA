/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.Bailleur;
import entites.Beneficiaire;
import entites.Fournisseur;
import entites.IndicateurPerformance;
import entites.Livrable;
import entites.Programme;
import entites.Projet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Iskilou Yerima
 */
public class ProjetCrud extends ObjectCrud {

    public ProjetCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }

    public void creerProjet() {
        Projet projet = new Projet();

        List<Bailleur> bailleurs = new ArrayList<>();
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Bailleur bailleur = this.getDataManager().getEm().find(Bailleur.class, 1);
        Fournisseur fournisseur = this.getDataManager().getEm().find(Fournisseur.class, 1);
        Programme programme = this.getDataManager().getEm().find(Programme.class, 1);
        fournisseurs.add(fournisseur);
        if (projet == null) {
            projet.setNom("SOS");
            projet.setLivrable(new ArrayList<Livrable>());
            projet.setBeneficiaire(new ArrayList<Beneficiaire>());
            projet.setObjectif("Enfant déshérité");
            projet.setDateDeDebut(new Date());
            projet.setDateDeFin(new Date());
            projet.setBudgetEffectif(15000);
            projet.setBudgetPrevisionnel(16000);
            projet.setFournisseur(fournisseurs);
            projet.setProgramme(programme);

        }
        if (projet.getIndicateurPerformance() == null) {
            projet.setIndicateurPerformance(this.getDataManager().getEm().find(IndicateurPerformance.class, 1));
        }

        if (projet.getBailleur() == null) {
            bailleurs.add(bailleur);
            projet.setBailleur(bailleurs);

        }

        try {
            this.persiste(projet);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<Projet> lireProjet() {

        Query query = this.getDataManager().getEm().createQuery("select p from Projet p ");

        List<Projet> projets = query.getResultList();
        return projets;
    }

}
