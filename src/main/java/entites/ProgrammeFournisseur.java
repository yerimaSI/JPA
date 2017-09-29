/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
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
@Table(name = "tp_ProgrammeFournisseur")
public class ProgrammeFournisseur implements Serializable {
    
    private static final long serialVersionUID = -710284143254183384L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "programme_id", nullable = false, referencedColumnName = "id")
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Programme programme;

    @JoinColumn(name = "fournisseur_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private Bailleur bailleur;

    @Column(nullable = false)
    private String     dureeContrat;

    public ProgrammeFournisseur() {
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

    public String getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(String dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    @Override
    public String toString() {
        return "ProgrammeFournisseur{" + "id=" + id + ", programme=" + programme + ", bailleur=" + bailleur + ", dureeContrat=" + dureeContrat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.programme);
        hash = 97 * hash + Objects.hashCode(this.bailleur);
        hash = 97 * hash + Objects.hashCode(this.dureeContrat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgrammeFournisseur other = (ProgrammeFournisseur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dureeContrat, other.dureeContrat)) {
            return false;
        }
        if (!Objects.equals(this.programme, other.programme)) {
            return false;
        }
        if (!Objects.equals(this.bailleur, other.bailleur)) {
            return false;
        }
        return true;
    }

    
    

}
