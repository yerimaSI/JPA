/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Iskilou Yerima
 */
public class DataManager {

    public boolean isConected = false;
    private EntityManagerFactory emf;
    private EntityManager em;
    private String PERSISTENCE_UNIT_NAME = "tpjpaPU";
    private EntityTransaction Transaction;

    public DataManager() {
    }

    public void initEntityManager() {
        Map parameters = new HashMap();
        parameters.put("javax.persistence.jdbc.user", "root");
        parameters.put("javax.persistence.jdbc.password", "toor");
        parameters.put("javax.persistence.jdbc.url", "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "bootcamp");
        parameters.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        parameters.put("javax.persistence.provider", "org.eclipse.persistence.jpa.PersistenceProvider");
        parameters.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        //setEmf(Persistence.createEntityManagerFactory(getPERSISTENCE_UNIT_NAME(), parameters));
        setEmf(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
        setEm(getEmf().createEntityManager());
        isConected = true;

    }

    public void BeginTransaction() {
        Transaction = em.getTransaction();
        Transaction.begin();
    }

    public void CloseTransaction() {
        Transaction.commit();
    }

    public void closeEntityManager() {
        getEm().close();
        getEmf().close();
        isConected = false;
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the PERSISTENCE_UNIT_NAME
     */
    public String getPERSISTENCE_UNIT_NAME() {
        return PERSISTENCE_UNIT_NAME;
    }

    /**
     * @param PERSISTENCE_UNIT_NAME the PERSISTENCE_UNIT_NAME to set
     */
    public void setPERSISTENCE_UNIT_NAME(String PERSISTENCE_UNIT_NAME) {
        this.PERSISTENCE_UNIT_NAME = PERSISTENCE_UNIT_NAME;
    }
}
