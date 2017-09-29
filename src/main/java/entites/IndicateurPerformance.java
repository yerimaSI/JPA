/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Iskilou Yerima
 */
@Entity
@Table(name = "tp_IndicateurPerformance")
public class IndicateurPerformance implements Serializable {

    private static final long serialVersionUID = 8390088550752484116L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String nature;

    @Column(nullable = false)
    private String valeur;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQualitatif> indicateurQualitatif;
    @OneToMany(cascade=CascadeType.ALL , mappedBy = "indicateurPerformance")
    private List<IndicateurQuantitatif> indicateurQuantitatif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public IndicateurPerformance() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public List<IndicateurQualitatif> getIndicateurQualitatif() {
        return indicateurQualitatif;
    }

    public void setIndicateurQualitatif(List<IndicateurQualitatif> indicateurQualitatif) {
        this.indicateurQualitatif = indicateurQualitatif;
    }

    public List<IndicateurQuantitatif> getIndicateurQuantitatif() {
        return indicateurQuantitatif;
    }

    public void setIndicateurQuantitatif(List<IndicateurQuantitatif> indicateurQuantitatif) {
        this.indicateurQuantitatif = indicateurQuantitatif;
    }

}
