/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author flvivet
 */
public class AccessTrainJPA {
    
    private EntityManager em = null;

    public EntityManager getEm() {
        if (this.em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainPU");
            this.em = emf.createEntityManager();
        }
        return em;
    }
    
    public void closeEntityManager(){
        if(em!=null){ em.close(); em = null;}
    }
    
    public List<TrainStation> getAllTrainStation() {
        EntityManager manager = this.getEm();
        Query query = manager.createQuery("Select * FROM TrainStation");
        return (List<TrainStation>) query.getResultList();
        
    }
    
    public TrainStation createTrainStation(int id, String name, String road, String city, int postal_code, float price){
        EntityTransaction trans = null;
        TrainStation ts = null;
         
            trans = getEm().getTransaction();    
            trans.begin(); 
            ts = new TrainStation(id, name, road, city, postal_code, price);
            getEm().persist(ts);
            trans.commit();
        
        return ts;
    }
    
}

