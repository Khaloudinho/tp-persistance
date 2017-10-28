package test;

import metier.*;
import util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void save(EntityManager entityManager, Set<Object> objects){
        for (Object object:
             objects) {
            entityManager.persist(object);
        }
    }

    public static void save(EntityManager entityManager, Object object){
        entityManager.persist(object);
    }
    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Entreprises pour les projets --------------------------------------------------------------------------------

        Entreprise entrepriseBerbe = new Entreprise("Berbe et fils SARL", ECorpsMetier.Macon, "0325871035");
        Entreprise entrepriseSancho = new Entreprise("Sancho et fils SARL", ECorpsMetier.Carreleur, "0325871036");
        Entreprise entrepriseArnoult = new Entreprise("Arnoult SA", ECorpsMetier.Menuisier, "0325871037");
        Entreprise entrepriseDehaye = new Entreprise("Dehaye et fils SARL", ECorpsMetier.Electricien, "0325871038");
        Entreprise entreprisePeintreExperts = new Entreprise("Peintre experts SARL", ECorpsMetier.Peintre, "0325871039");
        Entreprise entrepriseBombardi = new Entreprise("Bombardi SARL", ECorpsMetier.Plombier, "0325871045");
        Entreprise entrepriseBellorti = new Entreprise("Belortti Holding en commandite", ECorpsMetier.Macon, "0325871046");
        Entreprise entreprisePlacoExpert = new Entreprise("Placo expert SAS", ECorpsMetier.Platrier, "0325871047");
        Entreprise entrepriseProCharpente = new Entreprise("Les pros de la charpente", ECorpsMetier.Charpentier, "0326887047");
        Entreprise entrepriseCouvreTout = new Entreprise("Couvre tout SARL", ECorpsMetier.Couvreur, "032366047");
        Entreprise entreprisePlatrever = new Entreprise("Platre 4 Ever", ECorpsMetier.Platrier, "0326887117");
        Entreprise entrepriseAkar = new Entreprise("Akar maçons SA", ECorpsMetier.Macon, "0325871046");

        em.persist(entrepriseBerbe);
        em.persist(entrepriseSancho);
        em.persist(entrepriseArnoult);
        em.persist(entrepriseDehaye);
        em.persist(entreprisePeintreExperts);
        em.persist(entrepriseBombardi);
        em.persist(entrepriseBellorti);
        em.persist(entreprisePlacoExpert);
        em.persist(entrepriseProCharpente);
        em.persist(entrepriseCouvreTout);
        em.persist(entreprisePlatrever);
        em.persist(entrepriseAkar);

        // Acteurs réalisant tous les projets --------------------------------------------------------------------------

        Acteur martin = new Acteur("Martin", ETitre.Architecte, EStatut.Directeur);
        Acteur berbe = new Acteur("Berbe", ETitre.Technicien, EStatut.Responsable);
        Acteur grossi = new Acteur("Grossi", ETitre.Technicien, EStatut.Ouvrier);
        Acteur gareau = new Acteur("Gareau", ETitre.Technicien, EStatut.Ouvrier);
        Acteur martel = new Acteur("Martel", ETitre.Ingenieur, EStatut.Responsable);
        Acteur boudin = new Acteur("Boudin", ETitre.Ingenieur, EStatut.ChefEquipe);
        Acteur lagarde = new Acteur("Lagarde", ETitre.Ingenieur, EStatut.BIMManager);
        Acteur slim = new Acteur("Slim", ETitre.Docteur, EStatut.Employe);
        Acteur mohamed = new Acteur("Mohamed", ETitre.Technicien, EStatut.Ouvrier);
        Acteur souleymane = new Acteur("Souleymane", ETitre.Ingenieur, EStatut.Employe);
        Acteur vignarde = new Acteur("Vignarde", ETitre.Architecte, EStatut.Employe);
        Acteur cornevin = new Acteur("Cornevin", ETitre.Ingenieur, EStatut.ChefEquipe);
        Acteur villemin = new Acteur("Villemin", ETitre.Architecte, EStatut.Employe);
        Acteur sanchez = new Acteur("Sanchez", ETitre.Architecte, EStatut.Responsable);
        Acteur ivanov = new Acteur("Ivanov", ETitre.Ingenieur, EStatut.Employe);
        Acteur durand = new Acteur("Durand", ETitre.Ingenieur, EStatut.BIMManager);
        Acteur guizane = new Acteur("Guizane", ETitre.Technicien, EStatut.Ouvrier);
        Acteur kenny = new Acteur("Kenny", ETitre.Technicien, EStatut.Ouvrier);
        Acteur hakki = new Acteur("Hakki", ETitre.Technicien, EStatut.Directeur);

        // 1 - On enregistre les acteurs
        martin.setEntreprise(entrepriseBerbe);
        berbe.setEntreprise(entrepriseBerbe);
        grossi.setEntreprise(entrepriseBerbe);
        gareau.setEntreprise(entreprisePeintreExperts);
        martel.setEntreprise(entrepriseArnoult);
        boudin.setEntreprise(entreprisePlacoExpert);
        lagarde.setEntreprise(entreprisePlacoExpert);
        slim.setEntreprise(entrepriseBellorti);
        mohamed.setEntreprise(entrepriseBellorti);
        souleymane.setEntreprise(entreprisePlacoExpert);
        vignarde.setEntreprise(entrepriseBellorti);
        cornevin.setEntreprise(entrepriseDehaye);
        villemin.setEntreprise(entrepriseBombardi);
        sanchez.setEntreprise(entrepriseSancho);
        ivanov.setEntreprise(entrepriseArnoult);
        durand.setEntreprise(entrepriseProCharpente);
        guizane.setEntreprise(entrepriseCouvreTout);
        kenny.setEntreprise(entreprisePlatrever);
        hakki.setEntreprise(entrepriseAkar);

        em.persist(martin);
        em.persist(berbe);
        em.persist(grossi);
        em.persist(gareau);
        em.persist(martel);
        em.persist(boudin);
        em.persist(lagarde);
        em.persist(slim);
        em.persist(mohamed);
        em.persist(souleymane);
        em.persist(vignarde);
        em.persist(cornevin);
        em.persist(villemin);
        em.persist(sanchez);
        em.persist(ivanov);
        em.persist(durand);
        em.persist(guizane);
        em.persist(kenny);
        em.persist(hakki);

        // Peupler les entreprises avec des acteurs --------------------------------------------------------------------

        Set<Acteur> acteursBerbe = new HashSet<>();
        Set<Acteur> acteursSancho = new HashSet<>();
        Set<Acteur> acteursArnoult = new HashSet<>();
        Set<Acteur> acteursDehaye = new HashSet<>();
        Set<Acteur> acteursPeintreExperts = new HashSet<>();
        Set<Acteur> acteursBombardi = new HashSet<>();
        Set<Acteur> acteursBellorti = new HashSet<>();
        Set<Acteur> acteursPlacoExpert = new HashSet<>();
        Set<Acteur> acteursProCharpente = new HashSet<>();
        Set<Acteur> acteursCouvreTout = new HashSet<>();
        Set<Acteur> acteursPlatrever = new HashSet<>();
        Set<Acteur> acteursAkar = new HashSet<>();

        acteursBerbe.add(berbe);
        acteursBerbe.add(martin);
        acteursBerbe.add(grossi);
        acteursSancho.add(sanchez);
        acteursArnoult.add(ivanov);
        acteursArnoult.add(martel);
        acteursDehaye.add(cornevin);
        //acteursPeintreExperts.add(cornevin);
        acteursPeintreExperts.add(gareau);
        acteursBombardi.add(villemin);
        acteursBellorti.add(vignarde);
        acteursBellorti.add(mohamed);
        acteursBellorti.add(slim);
        acteursPlacoExpert.add(souleymane);
        acteursPlacoExpert.add(boudin);
        acteursPlacoExpert.add(lagarde);
        acteursProCharpente.add(durand);
        acteursCouvreTout.add(guizane);
        acteursPlatrever.add(kenny);
        acteursAkar.add(hakki);

        entrepriseBerbe.setActeurs(acteursBerbe);
        entrepriseSancho.setActeurs(acteursSancho);
        entrepriseArnoult.setActeurs(acteursArnoult);
        entrepriseDehaye.setActeurs(acteursDehaye);
        entreprisePeintreExperts.setActeurs(acteursPeintreExperts);
        entrepriseBombardi.setActeurs(acteursBombardi);
        entrepriseBellorti.setActeurs(acteursBellorti);
        entreprisePlacoExpert.setActeurs(acteursPlacoExpert);
        entrepriseProCharpente.setActeurs(acteursProCharpente);
        entrepriseCouvreTout.setActeurs(acteursCouvreTout);
        entreprisePlatrever.setActeurs(acteursPlatrever);
        entrepriseAkar.setActeurs(acteursAkar);

        /*em.persist(etablissementScolaire0L);
        em.persist(immeuble8A7L);
        em.persist(musee10L8E15A);*/

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
