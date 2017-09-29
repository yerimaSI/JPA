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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Iskilou Yerima
 */
public class ProgrammeCrud extends ObjectCrud{

    public ProgrammeCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }
    
    
    public boolean   creerProgramme( )
    {
        
        Programme programme = new  Programme();
        boolean bol = false;
        programme.setNom("Aide aux defavorisés");
        programme.setObjectif("Aider les pauvres");
        programme.setDateDeDebut(new Date());
        programme.setDateDeFin(new Date());
        programme.setBudgetPrevisionnel(100000);
        programme.setBudgetEffectif(20000);
        programme.setFournisseur(new ArrayList<>());
        programme.setProjet(new ArrayList<>());
        programme.setBailleur(new ArrayList<>());
        try {
            if ( programme != null) {
                bol = this.persiste( programme);
            }

            return bol;
        } catch (Exception e) {
            return false;
        }

    }
    
  
                
    }
            

