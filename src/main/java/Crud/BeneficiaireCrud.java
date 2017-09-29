/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import Utiles.DataManager;
import Utiles.ObjectCrud;
import entites.Beneficiaire;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Iskilou Yerima
 */
public class BeneficiaireCrud extends ObjectCrud{
    
    public BeneficiaireCrud(DataManager dataManager) {
        super(dataManager);
        this.setDataManager(dataManager);
        this.checkDatamanager();
    }
    
     public boolean creerBeneficiaire( Beneficiaire  beneficiaire) {
        
        boolean bol = false;
        
         beneficiaire.setNom("MISP");
         beneficiaire.setProgramme(null);
         beneficiaire.setProjet(null);
        try {
            if ( beneficiaire != null) {
                bol = this.persiste( beneficiaire);
            }

            return bol;
        } catch (Exception e) {
            return false;
        }

    }
     public List<Beneficiaire> findBeneficiairebyProgramme()
     {
         String requete =" SELECT b FROM tp_Beneficiaire b  INNER    JOIN  tp_Beneficiaire.programme  p";
         
         Query query = this .getDataManager().getEm().createNamedQuery(requete);
         
          List<Beneficiaire> beneficiaires= query.getResultList();
          
          return  beneficiaires;
                  
         
     }
       public List<Beneficiaire> findBeneficiairebyProjet()
     {
         String requete =" SELECT b FROM tp_Beneficiaire  LEFT OUT   JOIN  tp_Projet.beneficiaire  b";
         
         Query query = this .getDataManager().getEm().createNamedQuery(requete);
         
          List<Beneficiaire> beneficiaires= query.getResultList();
          
          return  beneficiaires;
                  
         
     }
}
