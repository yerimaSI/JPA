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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Iskilou Yerima
 */
@Entity
@Table(name = "tp_Bailleur")
public class Bailleur extends Personne implements Serializable {

    private static final long serialVersionUID = 7004006712498801154L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeDeBailleur typeDeBailleur;

    @ManyToMany(mappedBy = "bailleur")
    @JoinColumn(nullable = false)
    private List<Programme> programme;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Projet> projet;

    public Bailleur() {
        super();
    }

    public List<Programme> getProgramme() {
        return programme;
    }

    public void setProgramme(List<Programme> programme) {
        this.programme = programme;
    }

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
    }

    @Override
    public String toString() {
        return "Bailleur{" + "id=" + id + ", typeDeBailleur=" + typeDeBailleur + '}';
    }

}
