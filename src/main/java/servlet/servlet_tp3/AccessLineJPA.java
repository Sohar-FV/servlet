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
class AccessLineJPA {
    
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
    
    public Line createLine(int id){
        EntityTransaction trans = null;
        Line line = null;
         
        trans = getEm().getTransaction();    
        trans.begin(); 
            
        line = new Line(id);
        getEm().persist(line);
        trans.commit();
        
        return line;
    }

    public List<Line> getAllLines() {
        EntityManager manager = this.getEm();
        
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Line> cq = cb.createQuery(Line.class);
        Root<Line> rootEntry = cq.from(Line.class);
        CriteriaQuery<Line> all = cq.select(rootEntry);
        TypedQuery<Line> allQuery = manager.createQuery(all);
        List<Line> result = allQuery.getResultList();
        
        return result;
    }
    
}
