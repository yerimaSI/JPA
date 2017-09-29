/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
@Table(name = "tp_Beneficiaire")
public class Beneficiaire  extends Personne implements Serializable {

    private static final long serialVersionUID = 2058887037642443990L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @ManyToMany()
    @JoinColumn(nullable = false)
    private List<Projet> projet;
    
    @ManyToMany(mappedBy = "beneficiaire")
    @JoinColumn(nullable = false)
    private List<Programme> programme;
     
    public Beneficiaire() {
        super();
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

    public List<Programme> getProgramme() {
        return programme;
    }

    public void setProgramme(List<Programme> programme) {
        this.programme = programme;
    }

}
