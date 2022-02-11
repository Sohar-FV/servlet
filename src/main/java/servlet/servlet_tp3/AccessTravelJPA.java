/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author flvivet
 */
public class AccessTravelJPA {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
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
    
    public List<Travel> getAllTravels() {
        EntityManager manager = this.getEm();
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Travel> cq = cb.createQuery(Travel.class);
        Root<Travel> rootEntry = cq.from(Travel.class);
        CriteriaQuery<Travel> all = cq.select(rootEntry);
        TypedQuery<Travel> allQuery = manager.createQuery(all);
        
        List<Travel> result = allQuery.getResultList();
        
        return result;
 
    }
    
    public Travel createTravel(int id, TrainStation departureStation, TrainStation arrivalStation){
        EntityTransaction trans = null;
        Travel tvl = null;
         
        trans = getEm().getTransaction();    
        trans.begin(); 
        tvl = new Travel(id, departureStation, arrivalStation);
        getEm().persist(tvl);
        trans.commit();
        
        return tvl;
    }
   
}
