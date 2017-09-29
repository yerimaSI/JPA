/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Iskilou Yerima
 */
@Entity
@Table(name = "tp_Livrable")
public class Livrable implements Serializable {

    private static final long serialVersionUID = -4098812319657731L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Projet projet;

    @JoinColumn(nullable = false)
    @OneToOne
    private IndicateurPerformance indicateurPerformance;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date dateDeDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date dateDeLivraison;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Livrable() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeLivraison() {
        return dateDeLivraison;
    }

    public void setDateDeLivraison(Date dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
    }

}
