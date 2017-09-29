/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.Serializable;

/**
 *
 * @author Iskilou Yerima
 */
public class ObjectCrud {

    private DataManager dataManager;
    protected String message;
    private String detailMessage;


    public void checkDatamanager() {

        if (dataManager == null) {
            dataManager = new DataManager();
            dataManager.initEntityManager();

        }

        if (dataManager.isConected == false) {
            dataManager.initEntityManager();
        }

    }

    public boolean persiste(Serializable o) {
        try {
            this.getDataManager().BeginTransaction();
            this.getDataManager().getEm().persist(o);
            this.getDataManager().CloseTransaction();
            try {
                this.getDataManager().getEm().refresh(o);
            } catch (Exception e) {
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public void refresh(Serializable o) {
        try {
            this.getDataManager().getEm().refresh(o);
        } catch (Exception e) {
            e.getMessage();

        }
    }

    public boolean merge(Serializable o) {
        try {
            this.getDataManager().BeginTransaction();
            this.getDataManager().getEm().merge(o);
            this.getDataManager().CloseTransaction();
            try {
                this.getDataManager().getEm().refresh(o);
            } catch (Exception e) {
                e.getMessage();

            }

            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
    
    

    public Serializable find( Serializable Tclass, int objectId) {
        try {
            Serializable serializable = getDataManager().getEm().find(Tclass.getClass(), objectId);
            this.refresh(serializable);
            return serializable;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

   
    public boolean delete(Serializable o) {
        try {
            this.getDataManager().BeginTransaction();
            this.getDataManager().getEm().remove(o);
            this.getDataManager().CloseTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObjectCrud(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

}
