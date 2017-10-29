package test;

import metier.*;
import util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static Date maintenant = new java.sql.Date(new java.util.Date().getTime());

    public static void save(EntityManager entityManager, Set<Object> objects){
        for (Object object:
             objects) {
            entityManager.persist(object);
        }
    }

    public static void save(EntityManager entityManager, Object object){
        entityManager.persist(object);
    }

    public static Date getDateInDays(Date currentDate, int numberOfDaysInFuture){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_YEAR,numberOfDaysInFuture);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Date(cal.getTimeInMillis());
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

        // Un lotissement : 10 lots, 8 entreprises, 10 acteurs ---------------------------------------------------------


        Date dans100Jours = Test.getDateInDays(Test.maintenant, 100);
        Date dans110Jours = Test.getDateInDays(Test.maintenant, 110);
        Date dans120Jours = Test.getDateInDays(Test.maintenant, 120);
        Date dans130Jours = Test.getDateInDays(Test.maintenant, 130);
        Date dans140Jours = Test.getDateInDays(Test.maintenant, 140);

        Lots charpenteLotissement10L8E10A = new Charpente(1, maintenant,  10, 150, 1, 70, dans100Jours, ECharpente.toitPlat);
        Lots couvertureLotissement10L8E10A = new Charpente(2, maintenant,  3, 100, 1, 50, dans100Jours,ECharpente.toitPlat);
        Lots dallageLotissement10L8E10A = new Dallage(3, maintenant, 3, 2, 1, 5, dans110Jours,2000);
        Lots electriciteLotissement10L8E10A = new Electricite(4, maintenant, 3, 20, 1, 30, dans120Jours,4, 101.57f);
        Lots menuiseriesLotissement10L8E10A = new Menuiseries(5, maintenant, 1, 3, 1, 2, dans130Jours,8, 15, 2);
        Lots peintureLotissement10L8E10A = new Peinture(6, maintenant, 2, 1, 1, 3, dans130Jours,20);
        Lots peintureExterieureLotissement10L8E10A = new Peinture(7, maintenant, 2, 2, 1, 4, dans110Jours,200);
        Lots platerieLotissement10L8E10A = new Platerie(8, maintenant, 2, 1, 1, 2, dans130Jours,200, 1450);
        Lots plomberieLotissement10L8E10A = new Reseaux(9, maintenant, 4, 10, 1, 20, dans140Jours,150.67f);
        Lots electriciteReseauLotissement10L8E10A = new Reseaux(10, maintenant, 3, 15, 1, 30, dans110Jours,170.67f);

        Set<Lots> lotsLotissement10L8E10A = new HashSet<>();
        lotsLotissement10L8E10A.add(charpenteLotissement10L8E10A);
        lotsLotissement10L8E10A.add(couvertureLotissement10L8E10A);
        lotsLotissement10L8E10A.add(dallageLotissement10L8E10A);
        lotsLotissement10L8E10A.add(electriciteLotissement10L8E10A);
        lotsLotissement10L8E10A.add(menuiseriesLotissement10L8E10A);
        lotsLotissement10L8E10A.add(peintureLotissement10L8E10A);
        lotsLotissement10L8E10A.add(peintureExterieureLotissement10L8E10A);
        lotsLotissement10L8E10A.add(platerieLotissement10L8E10A);
        lotsLotissement10L8E10A.add(plomberieLotissement10L8E10A);
        lotsLotissement10L8E10A.add(electriciteReseauLotissement10L8E10A);

        Set<Entreprise> entreprisesCharpenteLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesDallageLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesElectriciteLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesMenuiseriesLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesPeintureLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesPlaterieLotissement10L8E10A = new HashSet<>();
        Set<Entreprise> entreprisesReseauxLotissement10L8E10A = new HashSet<>();

        entreprisesCharpenteLotissement10L8E10A.add(entrepriseProCharpente);
        entreprisesCharpenteLotissement10L8E10A.add(entrepriseCouvreTout);
        entreprisesDallageLotissement10L8E10A.add(entrepriseSancho);
        entreprisesElectriciteLotissement10L8E10A.add(entrepriseDehaye);
        entreprisesMenuiseriesLotissement10L8E10A.add(entrepriseArnoult);
        entreprisesPeintureLotissement10L8E10A.add(entreprisePeintreExperts);
        entreprisesPlaterieLotissement10L8E10A.add(entreprisePlatrever);
        entreprisesReseauxLotissement10L8E10A.add(entrepriseBombardi);


        charpenteLotissement10L8E10A.setEntrepriseResponsable(entrepriseProCharpente);
        charpenteLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesCharpenteLotissement10L8E10A);

        couvertureLotissement10L8E10A.setEntrepriseResponsable(entrepriseCouvreTout);
        couvertureLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesCharpenteLotissement10L8E10A);

        dallageLotissement10L8E10A.setEntrepriseResponsable(entrepriseSancho);
        dallageLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesDallageLotissement10L8E10A);

        electriciteLotissement10L8E10A.setEntrepriseResponsable(entrepriseDehaye);
        electriciteLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesElectriciteLotissement10L8E10A);

        menuiseriesLotissement10L8E10A.setEntrepriseResponsable(entrepriseArnoult);
        menuiseriesLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesMenuiseriesLotissement10L8E10A);

        peintureLotissement10L8E10A.setEntrepriseResponsable(entreprisePeintreExperts);
        peintureLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesPeintureLotissement10L8E10A);

        peintureExterieureLotissement10L8E10A.setEntrepriseResponsable(entreprisePeintreExperts);
        peintureExterieureLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesPeintureLotissement10L8E10A);

        platerieLotissement10L8E10A.setEntrepriseResponsable(entreprisePlatrever);
        platerieLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesPlaterieLotissement10L8E10A);

        plomberieLotissement10L8E10A.setEntrepriseResponsable(entrepriseBombardi);
        plomberieLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesReseauxLotissement10L8E10A);

        electriciteReseauLotissement10L8E10A.setEntrepriseResponsable(entrepriseBombardi);
        electriciteReseauLotissement10L8E10A.setEntreprisesRealisatrices(entreprisesReseauxLotissement10L8E10A);

        Lotissement lotissement10L8E10A = new Lotissement("Lotissement10L8E10A",
                "Lotissement les Fleurs Bleues", 2000, "Terminé", new Date(2017-12-12),
                1520000, true, new Date(2017-10-22), 14);

        em.persist(lotissement10L8E10A);

        lotissement10L8E10A.setLots(lotsLotissement10L8E10A);


        charpenteLotissement10L8E10A.setProjet(lotissement10L8E10A);
        couvertureLotissement10L8E10A.setProjet(lotissement10L8E10A);
        dallageLotissement10L8E10A.setProjet(lotissement10L8E10A);
        electriciteLotissement10L8E10A.setProjet(lotissement10L8E10A);
        menuiseriesLotissement10L8E10A.setProjet(lotissement10L8E10A);
        peintureLotissement10L8E10A.setProjet(lotissement10L8E10A);
        peintureExterieureLotissement10L8E10A.setProjet(lotissement10L8E10A);
        platerieLotissement10L8E10A.setProjet(lotissement10L8E10A);
        plomberieLotissement10L8E10A.setProjet(lotissement10L8E10A);
        electriciteReseauLotissement10L8E10A.setProjet(lotissement10L8E10A);

        em.persist(charpenteLotissement10L8E10A);
        em.persist(couvertureLotissement10L8E10A);
        em.persist(dallageLotissement10L8E10A);
        em.persist(electriciteLotissement10L8E10A);
        em.persist(menuiseriesLotissement10L8E10A);
        em.persist(peintureLotissement10L8E10A);
        em.persist(peintureExterieureLotissement10L8E10A);
        em.persist(platerieLotissement10L8E10A);
        em.persist(plomberieLotissement10L8E10A);
        em.persist(electriciteReseauLotissement10L8E10A);

        // Un immeuble : 10 appartements, 8 lots, 7 entreprises, 8 acteurs ---------------------------------------------

        Appartement appart1Immeuble10A8L7E8A = new Appartement(2, ETypeAppart.T2, 50);
        Appartement appart2Immeuble10A8L7E8A = new Appartement(3, ETypeAppart.T3, 80);
        Appartement appart3Immeuble10A8L7E8A = new Appartement(2, ETypeAppart.T2, 65);
        Appartement appart4Immeuble10A8L7E8A = new Appartement(1, ETypeAppart.Studio, 20);
        Appartement appart5Immeuble10A8L7E8A = new Appartement(1, ETypeAppart.Studio, 17);
        Appartement appart6Immeuble10A8L7E8A = new Appartement(1, ETypeAppart.Studio, 15);
        Appartement appart7Immeuble10A8L7E8A = new Appartement(1, ETypeAppart.Studio, 27);
        Appartement appart8Immeuble10A8L7E8A = new Appartement(2, ETypeAppart.T2, 75);
        Appartement appart9Immeuble10A8L7E8A = new Appartement(4, ETypeAppart.T4, 150);
        Appartement appart10Immeuble10A8L7E8A = new Appartement(3, ETypeAppart.T3, 100);

        em.persist(appart1Immeuble10A8L7E8A);
        em.persist(appart2Immeuble10A8L7E8A);
        em.persist(appart3Immeuble10A8L7E8A);
        em.persist(appart4Immeuble10A8L7E8A);
        em.persist(appart5Immeuble10A8L7E8A);
        em.persist(appart6Immeuble10A8L7E8A);
        em.persist(appart7Immeuble10A8L7E8A);
        em.persist(appart8Immeuble10A8L7E8A);
        em.persist(appart9Immeuble10A8L7E8A);
        em.persist(appart10Immeuble10A8L7E8A);

        Set<Appartement> appartsImmeuble10A8L7E8A =  new HashSet<Appartement>();
        appartsImmeuble10A8L7E8A.add(appart1Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart2Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart3Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart4Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart5Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart6Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart7Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart8Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart9Immeuble10A8L7E8A);
        appartsImmeuble10A8L7E8A.add(appart10Immeuble10A8L7E8A);

        Charpente charpenteImmeuble10A8L7E8A = new Charpente(1, maintenant, 30, 150, 1, 40, dans110Jours,ECharpente.fermette);
        Dallage dallageImmeuble10A8L7E8A = new Dallage(2, maintenant, 5, 20, 1, 10, dans100Jours,2000);
        Electricite electriciteImmeuble10A8L7E8A = new Electricite(3, maintenant, 7, 30, 1, 15, dans120Jours,9, 91.57f);
        Fondation fondationImmeuble10A8L7E8A = new Fondation(4, maintenant, 10, 26, 1, 20, dans100Jours,13);
        Maconnerie maconnerieImmeuble10A8L7E8A = new Maconnerie(5, maintenant, 20, 16, 1, 30, dans130Jours,1500, 8);
        Menuiseries menuiseriesImmeuble10A8L7E8A = new Menuiseries(6, maintenant, 7, 10, 1, 5, dans130Jours,53, 25, 8);
        Platerie platerieImmeuble10A8L7E8A = new Platerie(7, maintenant, 3, 6, 1, 3, dans140Jours,1500, 6000);
        Reseaux reseauxImmeuble10A8L7E8A = new Reseaux(8, maintenant, 2, 12, 1, 6, dans140Jours,99.97f);


        Set<Lots> lotsImmeuble10A8L7E8A = new HashSet<>();
        lotsImmeuble10A8L7E8A.add(charpenteImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(dallageImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(electriciteImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(fondationImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(maconnerieImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(menuiseriesImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(platerieImmeuble10A8L7E8A);
        lotsImmeuble10A8L7E8A.add(reseauxImmeuble10A8L7E8A);

        Set<Entreprise> entreprisesCharpenteImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesDallageImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesElectriciteImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesMaconnerieImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesMenuiseriesImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesPlaterieImmeuble10A8L7E8A = new HashSet<>();
        Set<Entreprise> entreprisesReseauxImmeuble10A8L7E8A = new HashSet<>();

        entreprisesCharpenteImmeuble10A8L7E8A.add(entrepriseProCharpente);
        entreprisesDallageImmeuble10A8L7E8A.add(entrepriseSancho);
        entreprisesElectriciteImmeuble10A8L7E8A.add(entrepriseDehaye);
        entreprisesMaconnerieImmeuble10A8L7E8A.add(entrepriseAkar);
        entreprisesMenuiseriesImmeuble10A8L7E8A.add(entrepriseArnoult);
        entreprisesPlaterieImmeuble10A8L7E8A.add(entreprisePlatrever);
        entreprisesReseauxImmeuble10A8L7E8A.add(entrepriseBombardi);

        charpenteImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseProCharpente);
        charpenteImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesCharpenteImmeuble10A8L7E8A);

        dallageImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseSancho);
        dallageImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesDallageImmeuble10A8L7E8A);

        electriciteImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseDehaye);
        electriciteImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesElectriciteImmeuble10A8L7E8A);

        fondationImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseAkar);
        fondationImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesMaconnerieImmeuble10A8L7E8A);

        maconnerieImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseAkar);
        maconnerieImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesMaconnerieImmeuble10A8L7E8A);

        menuiseriesImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseArnoult);
        menuiseriesImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesMenuiseriesImmeuble10A8L7E8A);

        platerieImmeuble10A8L7E8A.setEntrepriseResponsable(entreprisePlatrever);
        platerieImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesPlaterieImmeuble10A8L7E8A);

        reseauxImmeuble10A8L7E8A.setEntrepriseResponsable(entrepriseBombardi);
        reseauxImmeuble10A8L7E8A.setEntreprisesRealisatrices(entreprisesReseauxImmeuble10A8L7E8A);

        Projet immeuble10A8L7E8A = new Immeuble("Immeuble10A8L7E8A", "Immeuble de rapport 10 appartements",
                2500, "Terminé", new Date(2017-5-11), 1620000, true, new Date(2017-5-24),
                4, appartsImmeuble10A8L7E8A);
        immeuble10A8L7E8A.setLots(lotsImmeuble10A8L7E8A);

        em.persist(immeuble10A8L7E8A);

        charpenteImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        dallageImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        electriciteImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        fondationImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        maconnerieImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        menuiseriesImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        platerieImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);
        reseauxImmeuble10A8L7E8A.setProjet(immeuble10A8L7E8A);

        em.persist(charpenteImmeuble10A8L7E8A);
        em.persist(dallageImmeuble10A8L7E8A);
        em.persist(electriciteImmeuble10A8L7E8A);
        em.persist(fondationImmeuble10A8L7E8A);
        em.persist(maconnerieImmeuble10A8L7E8A);
        em.persist(menuiseriesImmeuble10A8L7E8A);
        em.persist(platerieImmeuble10A8L7E8A);
        em.persist(reseauxImmeuble10A8L7E8A);

        // Un hôpital : 10 lots, 9 entreprises, 11 acteurs -------------------------------------------------------------

        Charpente charpenteHopital10L9E11A = new Charpente(1, maintenant, 40, 2000, 1, 1000, dans100Jours,ECharpente.toitPlat);
        Dallage dallageHopital10L9E11A = new Dallage(2, maintenant, 10, 400, 1, 200, dans110Jours,20000);
        Electricite electriciteHopital10L9E11A = new Electricite(3, maintenant, 20, 800, 1, 400, dans120Jours,12, 101.57f);
        Fondation fondationHopital10L9E11A = new Fondation(4, maintenant, 10, 1000, 1, 500, dans100Jours,25);
        Maconnerie maconnerieHopital10L9E11A = new Maconnerie(5, maintenant, 20, 1200, 1, 600, dans110Jours,1500, 22);
        Menuiseries menuiseriesHopital10L9E11A = new Menuiseries(6, maintenant, 10, 600, 1, 300, dans120Jours,113, 55, 0);
        Peinture peintureHopital10L9E11A = new Peinture(7, maintenant, 5, 300, 1, 150, dans130Jours,25000);
        Platerie platerieHopital10L9E11A = new Platerie(8, maintenant, 7, 400, 1, 200, dans120Jours,2000, 8500);
        Reseaux reseauxHopital10L9E11A = new Reseaux(9, maintenant, 5, 800, 1, 400, dans110Jours,1510.97f);
        Terrassement terrassementHopital10L9E11A = new Terrassement(10, maintenant, 10, 100, 1, 50, dans100Jours,65000);

        Set<Lots> lotsHopital10L9E11A = new HashSet<>();
        lotsHopital10L9E11A.add(charpenteHopital10L9E11A);
        lotsHopital10L9E11A.add(dallageHopital10L9E11A);
        lotsHopital10L9E11A.add(electriciteHopital10L9E11A);
        lotsHopital10L9E11A.add(fondationHopital10L9E11A);
        lotsHopital10L9E11A.add(maconnerieHopital10L9E11A);
        lotsHopital10L9E11A.add(menuiseriesHopital10L9E11A);
        lotsHopital10L9E11A.add(peintureHopital10L9E11A);
        lotsHopital10L9E11A.add(platerieHopital10L9E11A);
        lotsHopital10L9E11A.add(reseauxHopital10L9E11A);
        lotsHopital10L9E11A.add(terrassementHopital10L9E11A);

        Set<Entreprise> entreprisesCharpenteHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesDallageHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesElectriciteHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesFondationHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesMaconnerieHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesMenuiseriesHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesPeintureHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesPlaterieHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesReseauxHopital10L9E11A = new HashSet<>();
        Set<Entreprise> entreprisesTerrassementHopital10L9E11A = new HashSet<>();

        entreprisesCharpenteHopital10L9E11A.add(entrepriseProCharpente);
        entreprisesDallageHopital10L9E11A.add(entrepriseSancho);
        entreprisesElectriciteHopital10L9E11A.add(entrepriseDehaye);
        entreprisesFondationHopital10L9E11A.add(entrepriseAkar);
        entreprisesMaconnerieHopital10L9E11A.add(entrepriseAkar);
        entreprisesMenuiseriesHopital10L9E11A.add(entrepriseArnoult);
        entreprisesPeintureHopital10L9E11A.add(entreprisePeintreExperts);
        entreprisesPlaterieHopital10L9E11A.add(entreprisePlatrever);
        entreprisesReseauxHopital10L9E11A.add(entrepriseBombardi);
        entreprisesTerrassementHopital10L9E11A.add(entrepriseCouvreTout);

        charpenteHopital10L9E11A.setEntrepriseResponsable(entrepriseProCharpente);
        charpenteHopital10L9E11A.setEntreprisesRealisatrices(entreprisesCharpenteHopital10L9E11A);

        dallageHopital10L9E11A.setEntrepriseResponsable(entrepriseSancho);
        dallageHopital10L9E11A.setEntreprisesRealisatrices(entreprisesDallageHopital10L9E11A);

        electriciteHopital10L9E11A.setEntrepriseResponsable(entrepriseDehaye);
        electriciteHopital10L9E11A.setEntreprisesRealisatrices(entreprisesElectriciteHopital10L9E11A);

        fondationHopital10L9E11A.setEntrepriseResponsable(entrepriseAkar);
        fondationHopital10L9E11A.setEntreprisesRealisatrices(entreprisesFondationHopital10L9E11A);

        maconnerieHopital10L9E11A.setEntrepriseResponsable(entrepriseAkar);
        maconnerieHopital10L9E11A.setEntreprisesRealisatrices(entreprisesMaconnerieHopital10L9E11A);

        menuiseriesHopital10L9E11A.setEntrepriseResponsable(entrepriseArnoult);
        menuiseriesHopital10L9E11A.setEntreprisesRealisatrices(entreprisesMenuiseriesHopital10L9E11A);

        peintureHopital10L9E11A.setEntrepriseResponsable(entreprisePeintreExperts);
        peintureHopital10L9E11A.setEntreprisesRealisatrices(entreprisesPeintureHopital10L9E11A);

        platerieHopital10L9E11A.setEntrepriseResponsable(entreprisePlatrever);
        platerieHopital10L9E11A.setEntreprisesRealisatrices(entreprisesPlaterieHopital10L9E11A);

        reseauxHopital10L9E11A.setEntrepriseResponsable(entrepriseBombardi);
        reseauxHopital10L9E11A.setEntreprisesRealisatrices(entreprisesReseauxHopital10L9E11A);

        terrassementHopital10L9E11A.setEntrepriseResponsable(entrepriseCouvreTout);
        terrassementHopital10L9E11A.setEntreprisesRealisatrices(entreprisesTerrassementHopital10L9E11A);

        Projet hopital10L9E11A = new Hopital("hopital10L9E11A", "Hôpital Saint-Martin", 6000,
                "Terminé", new Date(2016-5-5), 5420000, true, new Date(2017-5-19), "Santé",
                357, 24);

        hopital10L9E11A.setLots(lotsHopital10L9E11A);

        em.persist(hopital10L9E11A);

        charpenteHopital10L9E11A.setProjet(hopital10L9E11A);
        dallageHopital10L9E11A.setProjet(hopital10L9E11A);
        electriciteHopital10L9E11A.setProjet(hopital10L9E11A);
        fondationHopital10L9E11A.setProjet(hopital10L9E11A);
        maconnerieHopital10L9E11A.setProjet(hopital10L9E11A);
        menuiseriesHopital10L9E11A.setProjet(hopital10L9E11A);
        peintureHopital10L9E11A.setProjet(hopital10L9E11A);
        platerieHopital10L9E11A.setProjet(hopital10L9E11A);
        reseauxHopital10L9E11A.setProjet(hopital10L9E11A);
        terrassementHopital10L9E11A.setProjet(hopital10L9E11A);

        em.persist(charpenteHopital10L9E11A);
        em.persist(dallageHopital10L9E11A);
        em.persist(electriciteHopital10L9E11A);
        em.persist(fondationHopital10L9E11A);
        em.persist(maconnerieHopital10L9E11A);
        em.persist(menuiseriesHopital10L9E11A);
        em.persist(peintureHopital10L9E11A);
        em.persist(platerieHopital10L9E11A);
        em.persist(reseauxHopital10L9E11A);
        em.persist(terrassementHopital10L9E11A);

        // Une maison : 5 lots, 4 entreprises, 4 acteurs ---------------------------------------------------------------

        Lots charpenteMaison5L4E4A = new Charpente(1, maintenant, 10, 40, 1, 20, dans100Jours, ECharpente.traditionnelle);
        Lots dallageMaison5L4E4A = new Dallage(2, maintenant, 2, 10, 1, 5, dans110Jours, 150);
        Lots electriciteMaison5L4E4A = new Electricite(3, maintenant, 3, 8, 1, 4, dans130Jours, 2, 88.57f);
        Lots maconnerieMaison5L4E4A = new Maconnerie(4, maintenant, 4, 20, 1, 10, dans120Jours, 500, 4);
        Lots reseauxMaison5L4E4A = new Reseaux(5, maintenant, 1, 4, 1, 2, dans140Jours, 73.67f);

        Set<Lots> lotsMaison5L4E4A = new HashSet<>();
        lotsMaison5L4E4A.add(charpenteMaison5L4E4A);
        lotsMaison5L4E4A.add(dallageMaison5L4E4A);
        lotsMaison5L4E4A.add(electriciteMaison5L4E4A);
        lotsMaison5L4E4A.add(maconnerieMaison5L4E4A);
        lotsMaison5L4E4A.add(reseauxMaison5L4E4A);

        Set<Entreprise> entreprisesCarrelageMaison5L4E4A = new HashSet<>();
        Set<Entreprise> entreprisesElectriciteMaison5L4E4A = new HashSet<>();
        Set<Entreprise> entreprisesPlomberieMaison5L4E4A = new HashSet<>();
        Set<Entreprise> entreprisesCharpenterieMaison5L4E4A = new HashSet<>();

        entreprisesCarrelageMaison5L4E4A.add(entrepriseSancho);
        entreprisesElectriciteMaison5L4E4A.add(entrepriseBombardi);
        entreprisesPlomberieMaison5L4E4A.add(entrepriseDehaye);
        entreprisesCharpenterieMaison5L4E4A.add(entrepriseProCharpente);

        charpenteMaison5L4E4A.setEntrepriseResponsable(entrepriseProCharpente);
        charpenteMaison5L4E4A.setEntreprisesRealisatrices(entreprisesCharpenterieMaison5L4E4A);

        dallageMaison5L4E4A.setEntrepriseResponsable(entrepriseSancho);
        dallageMaison5L4E4A.setEntreprisesRealisatrices(entreprisesCarrelageMaison5L4E4A);

        electriciteMaison5L4E4A.setEntrepriseResponsable(entrepriseBombardi);
        electriciteMaison5L4E4A.setEntreprisesRealisatrices(entreprisesElectriciteMaison5L4E4A);

        maconnerieMaison5L4E4A.setEntrepriseResponsable(entrepriseSancho);
        maconnerieMaison5L4E4A.setEntreprisesRealisatrices(entreprisesCarrelageMaison5L4E4A);

        reseauxMaison5L4E4A.setEntrepriseResponsable(entrepriseDehaye);
        reseauxMaison5L4E4A.setEntreprisesRealisatrices(entreprisesPlomberieMaison5L4E4A);

        Projet maison5L4E4A = new Maison("Maison5L4E4A", "Maison pour 4 personnes", 150,
                "Terminé", new Date(2017-12-1), 400000, true, new Date(2017-10-11),
                5, 2);

        maison5L4E4A.setLots(lotsMaison5L4E4A);

        em.persist(maison5L4E4A);

        charpenteMaison5L4E4A.setProjet(maison5L4E4A);
        dallageMaison5L4E4A.setProjet(maison5L4E4A);
        electriciteMaison5L4E4A.setProjet(maison5L4E4A);
        maconnerieMaison5L4E4A.setProjet(maison5L4E4A);
        reseauxMaison5L4E4A.setProjet(maison5L4E4A);

        em.persist(charpenteMaison5L4E4A);
        em.persist(dallageMaison5L4E4A);
        em.persist(electriciteMaison5L4E4A);
        em.persist(maconnerieMaison5L4E4A);
        em.persist(reseauxMaison5L4E4A);

        // Un établissement scolaire : pas de lots ---------------------------------------------------------------------

        Projet etablissementScolaire0L = new EtablissementScolaire("EtablissementScolaire0L", "Lycée les Lavandes",
                1500, "En cours", new Date(2017-9-18), 2500000, false,
                new Date(2017-12-9), "Education Nationale",1142, EEtaScolaire.lycee);

        em.persist(etablissementScolaire0L);

        // Un immeuble : 8 appartements, 7 lots ------------------------------------------------------------------------

        Appartement appart1Immeuble8A7L = new Appartement(1, ETypeAppart.T1, 30);
        Appartement appart2Immeuble8A7L = new Appartement(1, ETypeAppart.T2, 40);
        Appartement appart3Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart4Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart5Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart6Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart7Immeuble8A7L = new Appartement(3, ETypeAppart.T4, 75);
        Appartement appart8Immeuble8A7L = new Appartement(3, ETypeAppart.Studio, 25);

        em.persist(appart1Immeuble8A7L);
        em.persist(appart2Immeuble8A7L);
        em.persist(appart3Immeuble8A7L);
        em.persist(appart4Immeuble8A7L);
        em.persist(appart5Immeuble8A7L);
        em.persist(appart6Immeuble8A7L);
        em.persist(appart7Immeuble8A7L);
        em.persist(appart8Immeuble8A7L);

        Set<Appartement> appartsImmeuble8A7L =  new HashSet<Appartement>();
        appartsImmeuble8A7L.add(appart1Immeuble8A7L);
        appartsImmeuble8A7L.add(appart2Immeuble8A7L);
        appartsImmeuble8A7L.add(appart3Immeuble8A7L);
        appartsImmeuble8A7L.add(appart4Immeuble8A7L);
        appartsImmeuble8A7L.add(appart5Immeuble8A7L);
        appartsImmeuble8A7L.add(appart6Immeuble8A7L);
        appartsImmeuble8A7L.add(appart7Immeuble8A7L);
        appartsImmeuble8A7L.add(appart8Immeuble8A7L);

        Lots terrassementImmeuble8A7L = new Terrassement(1, maintenant, 5, 60, 1, 30, dans100Jours, 100);
        Lots dallageImmeuble8A7L = new Dallage(2, maintenant, 10, 20, 1, 10, dans120Jours, 1000);
        Lots menuiseriesImmeuble8A7L = new Menuiseries(3, maintenant, 3, 16, 1, 8, dans130Jours, 16, 10, 4);
        Lots fondationsImmeuble8A7L = new Fondation(4, maintenant, 5, 20, 1, 10, dans100Jours, 20);
        Lots maconnerieImmeuble8A7L = new Maconnerie(5, maintenant, 8, 30, 1, 15, dans110Jours, 2000, 20);
        Lots electriciteImmeuble8A7L = new Electricite(6, maintenant, 3, 40, 1, 20, dans130Jours, 10, 100);
        Lots reseauxImmeuble8A7L = new Reseaux(7, maintenant, 2, 4, 1, 2, dans140Jours, 1000);

        Set<Lots> lotsImmeuble8A7L = new HashSet<>();
        lotsImmeuble8A7L.add(terrassementImmeuble8A7L);
        lotsImmeuble8A7L.add(dallageImmeuble8A7L);
        lotsImmeuble8A7L.add(menuiseriesImmeuble8A7L);
        lotsImmeuble8A7L.add(fondationsImmeuble8A7L);
        lotsImmeuble8A7L.add(maconnerieImmeuble8A7L);
        lotsImmeuble8A7L.add(electriciteImmeuble8A7L);
        lotsImmeuble8A7L.add(reseauxImmeuble8A7L);

        Projet immeuble8A7L = new Immeuble("Immeuble8A7L", "Immeuble HLM", 2500, "En cours",
                new Date(2017-5-26), 3000000, false, new Date(2018-5-26), 7, appartsImmeuble8A7L);

        immeuble8A7L.setLots(lotsImmeuble8A7L);

        em.persist(immeuble8A7L);

        terrassementImmeuble8A7L.setProjet(immeuble8A7L);
        dallageImmeuble8A7L.setProjet(immeuble8A7L);
        menuiseriesImmeuble8A7L.setProjet(immeuble8A7L);
        fondationsImmeuble8A7L.setProjet(immeuble8A7L);
        maconnerieImmeuble8A7L.setProjet(immeuble8A7L);
        electriciteImmeuble8A7L.setProjet(immeuble8A7L);
        reseauxImmeuble8A7L.setProjet(immeuble8A7L);

        em.persist(terrassementImmeuble8A7L);
        em.persist(dallageImmeuble8A7L);
        em.persist(menuiseriesImmeuble8A7L);
        em.persist(fondationsImmeuble8A7L);
        em.persist(maconnerieImmeuble8A7L);
        em.persist(electriciteImmeuble8A7L);
        em.persist(reseauxImmeuble8A7L);





        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
