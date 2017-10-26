package test;

import metier.*;
import util.ECharpente;
import util.ECorpsMetier;
import util.EStatut;
import util.ETitre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class Test {
    public static void main(String [] args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Un lotissement : 10 lots, 8 entreprises, 10 acteurs

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
        Reseaux r = new Reseaux(150.67f);
        Terrassement t = new Terrassement(1600);

        // Un immeuble : 10 appartements, 8 lots, 7 entreprises, 8 acteurs

        // Un hôpital : 10 lots, 9 entreprises, 11 acteurs


        // Une maison : 5 lots, 4 entreprises, 4 acteurs

        Maison maison = new Maison("Maison5Lots",
                "Pavillon 5 personnes", 150, "Terminé", new Date(2017-12-01),
                400000, true, new Date(2017-10-11), 5, 2);

        Charpente c2 = new Charpente(ECharpente.traditionnelle);
        Dallage d2 = new Dallage(150);
        Electricite e2 = new Electricite(2, 88.57f);
        Fondation f2 = new Fondation(5);
        Maconnerie m2 = new Maconnerie(500, 4);
        Reseaux r2 = new Reseaux(73.67f);

        // Entreprises et acteurs communs à tous les projets

        Entreprise e1 = new Entreprise("Charpentiers passionnés", ECorpsMetier.Charpentier, "0694758455");
        Entreprise e2 = new Entreprise("Carreleurs au grand coeur", ECorpsMetier.Carreleur, "0694758454");
        Entreprise e3 = new Entreprise("Electriciens de demain", ECorpsMetier.Electricien, "0694758453");
        Entreprise e4 = new Entreprise("Maçonnerie de famille", ECorpsMetier.Macon, "0694758452");
        Entreprise e5 = new Entreprise("Menuisiers experts", ECorpsMetier.Menuisier, "0694758451");
        Entreprise e6 = new Entreprise("Van Gogh peinture", ECorpsMetier.Peintre, "0694758450");
        Entreprise e7 = new Entreprise("Le Plâtre depuis 1955", ECorpsMetier.Platrier, "0694758492");
        Entreprise e8 = new Entreprise("Canalisations attention", ECorpsMetier.Plombier, "0694758405");
        Entreprise e9 = new Entreprise("Gruss architecture", ECorpsMetier.Macon, "0694658405");

        Acteur a1 = new Acteur("Jean François", ETitre.Technicien, EStatut.ChefEquipe);
        Acteur a2 = new Acteur("Martin Daniel", ETitre.Technicien, EStatut.Employe);
        Acteur a3 = new Acteur("Tarek Atri", ETitre.Technicien, EStatut.Employe);
        Acteur a4 = new Acteur("Feng Chao", ETitre.Technicien, EStatut.Ouvrier);
        Acteur a5 = new Acteur("Gilles Dupont", ETitre.Technicien, EStatut.Ouvrier);
        Acteur a6 = new Acteur("Geoffrey Almeida", ETitre.Technicien, EStatut.Employe);
        Acteur a7 = new Acteur("Mamadou Cissokho", ETitre.Technicien, EStatut.Employe);
        Acteur a8 = new Acteur("Yeray Lopez", ETitre.Technicien, EStatut.Employe);
        Acteur a9 = new Acteur("Camille Martin", ETitre.Technicien, EStatut.ChefEquipe);
        Acteur a10 = new Acteur("Vanessa Durand", ETitre.Ingenieur, EStatut.Responsable);
        Acteur a11 = new Acteur("Arlette Gruss", ETitre.Architecte, EStatut.Directeur);

        //em.persist();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
