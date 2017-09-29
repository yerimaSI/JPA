/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Iskilou Yerima
 */
@Entity
@Table(name = "tp_ProgrammeBailleur")
public class ProgrammeBailleur implements Serializable {

    private static final long serialVersionUID = 3918811750748518746L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "programme_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private Programme programme;

    @JoinColumn(name = "bailleur_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private Bailleur bailleur;

    @Column(nullable = false)
    private Double montantSubvention;

    public ProgrammeBailleur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Double getMontantSubvention() {
        return montantSubvention;
    }

    public void setMontantSubvention(Double montantSubvention) {
        this.montantSubvention = montantSubvention;
    }

}
