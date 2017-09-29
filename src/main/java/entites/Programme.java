/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Iskilou Yerima
 */
@Entity
@Table(name = "tp_Programme")
public class Programme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String objectif;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date dateDeDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date dateDeFin;

    @JoinColumn(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    @OneToMany(mappedBy = "programme")
    private List<Projet> projet;
    @Column(nullable = false)
    private int budgetPrevisionnel;

    @Column(nullable = false)
    private int budgetEffectif;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "tp_ProgrammeBeneficiaire",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "beneficiaire_id"))
    private List<Beneficiaire> beneficiaire;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "tp_ProgrammeFournisseur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "fournisseur_id"))
    private List<Fournisseur> fournisseur;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "tp_ProgrammeBailleur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "bailleur_id"))
    private List<Bailleur> bailleur;

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public List<Bailleur> getBailleur() {
        return bailleur;
    }

    public void setBailleur(List<Bailleur> bailleur) {
        this.bailleur = bailleur;
    }

    public Programme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public List<Beneficiaire> getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(List<Beneficiaire> beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public List<Fournisseur> getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(List<Fournisseur> fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

    public int getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    public void setBudgetPrevisionnel(int budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    public int getBudgetEffectif() {
        return budgetEffectif;
    }

    public void setBudgetEffectif(int budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
    }

}
