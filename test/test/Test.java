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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Etablissement scolaire
        Projet etablissementScolaire = new EtablissementScolaire("Education", 1500, EEtaScolaire.lycee);

        // Immeuble
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

        Set<Lots> immeubleLots = new HashSet<Lots>();
        Lots terassement = new Terrassement(100);
        Lots dallage = new Dallage(1000);
        Lots menuiseries = new Menuiseries(16, 10, 4);
        Lots fondations = new Fondation(20);
        Lots maconnerie = new Maconnerie(2000, 20);
        Lots electricite = new Electricite(10, 100);
        Lots reseaux = new Reseaux(1000);

        immeubleLots.add(terassement);
        immeubleLots.add(dallage);
        immeubleLots.add(menuiseries);
        immeubleLots.add(fondations);
        immeubleLots.add(maconnerie);
        immeubleLots.add(electricite);
        immeubleLots.add(reseaux);

        Projet immeuble = new Immeuble(3, appartements);
        immeuble.setLots(immeubleLots);

        // Musee
            Set<Lots> museeLots = new HashSet<Lots>();
            Lots terassementMusee = new Terrassement(100);
            Lots dallageMusee = new Dallage(1000);
            Lots menuiseriesMusee = new Menuiseries(16, 10, 4);
            Lots fondationsMusee = new Fondation(20);
            Lots maconnerieMusee = new Maconnerie(2000, 20);
            Lots electriciteMusee = new Electricite(10, 100);
            Lots reseauxMusee = new Reseaux(1000);
            Lots peintureMusee = new Peinture(100);
            Lots peintureMuseeHall = new Peinture(30);
            Lots platerieMusee = new Platerie(500,700);


            immeubleLots.add(terassementMusee);
            immeubleLots.add(dallageMusee);
            immeubleLots.add(menuiseriesMusee);
            immeubleLots.add(fondationsMusee);
            immeubleLots.add(maconnerieMusee);
            immeubleLots.add(electriciteMusee);
            immeubleLots.add(reseauxMusee);
            immeubleLots.add(peintureMusee);
            immeubleLots.add(peintureMuseeHall);
            immeubleLots.add(platerieMusee);

            Acteur martin = new Acteur("martin", ETitre.Architecte, EStatut.Directeur);
            Acteur berbe = new Acteur("berbe", ETitre.Technicien, EStatut.Responsable);
            Acteur grossi = new Acteur("grossi", ETitre.Technicien, EStatut.Ouvrier);
            Acteur gareau = new Acteur("gareau", ETitre.Technicien, EStatut.Ouvrier);
            Acteur martel = new Acteur("martel", ETitre.Ingenieur, EStatut.Responsable);
            Acteur boudin = new Acteur("boudin", ETitre.Ingenieur, EStatut.ChefEquipe);
            Acteur lagarde = new Acteur("lagarde", ETitre.Ingenieur, EStatut.BIMManager);
            Acteur slim = new Acteur("slim", ETitre.Docteur, EStatut.Employe);
            Acteur mohamed = new Acteur("mohamed", ETitre.Technicien, EStatut.Ouvrier);
            Acteur souleman = new Acteur("souleman", ETitre.Ingenieur, EStatut.Employe);
            Acteur vignarde = new Acteur("vignarde", ETitre.Architecte, EStatut.Employe);
            Acteur cornevin = new Acteur("cornevin", ETitre.Ingenieur, EStatut.ChefEquipe);
            Acteur villemin = new Acteur("villemin", ETitre.Architecte, EStatut.Employe);
            Acteur sanchez = new Acteur("sanchez", ETitre.Architecte, EStatut.Responsable);
            Acteur ivanov = new Acteur("ivanov", ETitre.Ingenieur, EStatut.Employe);

            Entreprise entreprise = new Entreprise(nom, ECorpsMetier corpsMetier, 0325871035);

            Projet musee = new Musee(15);
            musee.setLots(museeLots);


        //em.persist();

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
