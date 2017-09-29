/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
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
@Table(name = "tp_Fournisseur")
public class Fournisseur extends Personne implements Serializable {

    private static final long serialVersionUID = 8576534951801197696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "fournisseur")
    @JoinColumn(nullable = false)
    private List<Programme> programme;

    @ManyToMany(mappedBy = "fournisseur")
    @JoinColumn(nullable = false)
    private List<Projet> projet;

    public Fournisseur() {
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
