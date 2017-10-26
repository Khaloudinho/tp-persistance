package test;

import metier.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.*;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2-hibernatePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


















        // Etablissement scolaire
        Projet etablissementScolaire = new EtablissementScolaire("Education", 1500, EEtaScolaire.lycee);



        Set<Appartement> appartements =  new HashSet<Appartement>();
        Appartement appartement1 = new Appartement(1, ETypeAppart.T1, 30);
        Appartement appartement2 = new Appartement(1, ETypeAppart.T2, 40);
        Appartement appartement3 = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appartement4 = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appartement5 = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appartement6 = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appartement7 = new Appartement(3, ETypeAppart.T4, 75);
        Appartement appartement8 = new Appartement(3, ETypeAppart.Studio, 25);

        appartements.add(appartement1);
        appartements.add(appartement2);
        appartements.add(appartement3);
        appartements.add(appartement4);
        appartements.add(appartement5);
        appartements.add(appartement6);
        appartements.add(appartement7);
        appartements.add(appartement8);

        Projet immeuble = new Immeuble(3, appartements);
        Projet musee = new Projet();



        //em.persist();

        em.getTransaction().commit();

    }
}
