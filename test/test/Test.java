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
        Platerie pl = new Platerie(200, 1450);
        Reseaux r = new Reseaux(150.67f);
        Terrassement t = new Terrassement(1600);

        // Un immeuble : 10 appartements, 8 lots, 7 entreprises, 8 acteurs

        Immeuble immeuble = new Immeuble(12);

        Charpente c2 = new Charpente(ECharpente.fermette);
        Dallage d2 = new Dallage(2000);
        Electricite e2 = new Electricite(9, 91.57f);
        Fondation f2 = new Fondation(13);
        Maconnerie m2 = new Maconnerie(1500, 8);
        Menuiseries me2 = new Menuiseries(53, 25, 8);
        Platerie pl2 = new Platerie(1500, 6000);
        Reseaux r2 = new Reseaux(99.97f);

        // Un hôpital : 10 lots, 9 entreprises, 11 acteurs

        Hopital hopital = new Hopital(357, 24);

        Charpente c3 = new Charpente(ECharpente.toitPlat);
        Dallage d3 = new Dallage(20000);
        Electricite e3 = new Electricite(12, 101.57f);
        Fondation f3 = new Fondation(25);
        Maconnerie m3 = new Maconnerie(1500, 22);
        Menuiseries me3 = new Menuiseries(113, 55, 0);
        Peinture p3 = new Peinture(25000);
        Platerie pl3 = new Platerie(2000, 8500);
        Reseaux r3 = new Reseaux(1510.97f);
        Terrassement t3 = new Terrassement(65000);

        // Une maison : 5 lots, 4 entreprises, 4 acteurs

        Maison maison = new Maison("Maison5Lots",
                "Pavillon 5 personnes", 150, "Terminé", new Date(2017-12-1),
                400000, true, new Date(2017-10-11), 5, 2);

        Charpente c4 = new Charpente(ECharpente.traditionnelle);
        Dallage d4 = new Dallage(150);
        Electricite e4 = new Electricite(2, 88.57f);
        Fondation f4 = new Fondation(5);
        Maconnerie m4 = new Maconnerie(500, 4);
        Reseaux r4 = new Reseaux(73.67f);

        // Entreprises et acteurs communs à tous les projets

        Entreprise ent1 = new Entreprise("Charpentiers passionnés", ECorpsMetier.Charpentier, "0694758455");
        Entreprise ent2 = new Entreprise("Carreleurs au grand coeur", ECorpsMetier.Carreleur, "0694758454");
        Entreprise ent3 = new Entreprise("Electriciens de demain", ECorpsMetier.Electricien, "0694758453");
        Entreprise ent4 = new Entreprise("Maçonnerie de famille", ECorpsMetier.Macon, "0694758452");
        Entreprise ent5 = new Entreprise("Menuisiers experts", ECorpsMetier.Menuisier, "0694758451");
        Entreprise ent6 = new Entreprise("Van Gogh peinture", ECorpsMetier.Peintre, "0694758450");
        Entreprise ent7 = new Entreprise("Le Plâtre depuis 1955", ECorpsMetier.Platrier, "0694758492");
        Entreprise ent8 = new Entreprise("Canalisations attention", ECorpsMetier.Plombier, "0694758405");
        Entreprise ent9 = new Entreprise("Gruss architecture", ECorpsMetier.Macon, "0694658405");

        Acteur act1 = new Acteur("Jean François", ETitre.Technicien, EStatut.ChefEquipe);
        Acteur act2 = new Acteur("Martin Daniel", ETitre.Technicien, EStatut.Employe);
        Acteur act3 = new Acteur("Tarek Atri", ETitre.Technicien, EStatut.Employe);
        Acteur act4 = new Acteur("Feng Chao", ETitre.Technicien, EStatut.Ouvrier);
        Acteur act5 = new Acteur("Gilles Dupont", ETitre.Technicien, EStatut.Ouvrier);
        Acteur act6 = new Acteur("Geoffrey Almeida", ETitre.Technicien, EStatut.Employe);
        Acteur act7 = new Acteur("Mamadou Cissokho", ETitre.Technicien, EStatut.Employe);
        Acteur act8 = new Acteur("Yeray Lopez", ETitre.Technicien, EStatut.Employe);
        Acteur act9 = new Acteur("Camille Martin", ETitre.Technicien, EStatut.ChefEquipe);
        Acteur act10 = new Acteur("Vanessa Durand", ETitre.Ingenieur, EStatut.Responsable);
        Acteur act11 = new Acteur("Arlette Gruss", ETitre.Architecte, EStatut.Directeur);

        //em.persist();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
