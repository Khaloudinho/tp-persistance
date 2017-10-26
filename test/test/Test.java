package test;

import metier.Adresse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Adresse adresse = new Adresse(3, "rue de Bourbonne", 52400, "Metz");

        em.persist(adresse);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
