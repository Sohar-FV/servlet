/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import jakarta.persistence.EntityTransaction;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<TrainStation> cq = cb.createQuery(TrainStation.class);
        Root<TrainStation> rootEntry = cq.from(TrainStation.class);
        CriteriaQuery<TrainStation> all = cq.select(rootEntry);
        TypedQuery<TrainStation> allQuery = manager.createQuery(all);
        
        List<TrainStation> result = allQuery.getResultList();
        
        return result;
 
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

