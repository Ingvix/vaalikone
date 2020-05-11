package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import persist.Ehdokkaat;


public class EhdokasDao {
    
	private static EntityManagerFactory emf;
    private static EntityManager getEntityManager() {
        if (emf==null) {
            emf=Persistence.createEntityManagerFactory("vaalikones");
        }
        return emf.createEntityManager();
    }
	
	
	public static boolean deleteEhdokas(int id) {
        EntityManager em=getEntityManager();
        Ehdokkaat b=em.find(Ehdokkaat.class, id);
        if (b!=null) {
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }
	
	
}