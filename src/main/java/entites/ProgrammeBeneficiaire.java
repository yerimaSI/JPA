/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "tp_ProgrammeBeneficiaire")
public class ProgrammeBeneficiaire implements Serializable {

    private static final long serialVersionUID = 1949690712986540065L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "programme_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private Programme programme;

    @JoinColumn(name = "beneficiare_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private Beneficiaire beneficiaire;

    @Column(nullable = false)
    private String duree;

    public ProgrammeBeneficiaire() {
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

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "ProgrammeBeneficiaire{" + "id=" + id + ", programme=" + programme + ", beneficiaire=" + beneficiaire + ", duree=" + duree + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.programme);
        hash = 83 * hash + Objects.hashCode(this.beneficiaire);
        hash = 83 * hash + Objects.hashCode(this.duree);
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
        final ProgrammeBeneficiaire other = (ProgrammeBeneficiaire) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.duree, other.duree)) {
            return false;
        }
        if (!Objects.equals(this.programme, other.programme)) {
            return false;
        }
        if (!Objects.equals(this.beneficiaire, other.beneficiaire)) {
            return false;
        }
        return true;
    }

}
