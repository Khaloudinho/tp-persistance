package test;

import metier.*;
import util.ECharpente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class Test {
    public static void main(String [] args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /* 4 projets terminés :
                - 1 lotissement : 10 lots, 8 entreprises, 10 acteurs
                refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle, nbMaisons
                - 1 immeuble : 10 appartements, 8 lots, 7 entreprises, 8 acteurs,
                - 1 Hôpital : 10 lots, 9 entreprises, 11 acteurs
                - 1 Maison : 5 lots, 4 entreprises, 4 acteurs
        */

        Lotissement lotissement = new Lotissement("Lotissement10Lots8Entreprises10Acteurs",
                "Lotissement les Fleurs Bleues", 2000, "Terminé", new Date(2017-12-12),
                1520000, true, new Date(2017-10-22), 14);

        Charpente c = new Charpente(ECharpente.toitPlat);
        Dallage d = new Dallage(2000);
        Electricite e = new Electricite(4, 101.57f);
        Fondation f = new Fondation(12);
        Maconnerie m = new Maconnerie(150, 6);
        Menuiseries me = new Menuiseries(8, 15, 2);
        Peinture p = new Peinture(20);
        Platerie pl = new Platerie(200, 145);
        Reseaux r = new Reseaux(150.57f);
        Terrassement t = new Terrassement(1600);

        Adresse adresse = new Adresse(9, "rue de l'Europe", 70000, "Noidans-lès-Vesoul");

        em.persist(adresse);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
