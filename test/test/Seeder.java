package test;

import metier.*;
import util.*;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Seeder {
    public static Date maintenant = new java.sql.Date(new java.util.Date().getTime());

    public static void save(EntityManager entityManager, Set<Object> objects){
        for (Object object : objects) {
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

    public static void initialize(EntityManager em){

        // Entreprises réalisant les projets ---------------------------------------------------------------------------

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

        // Acteurs réalisant les projets -------------------------------------------------------------------------------

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
        
        // On donne une adresse à chaque entreprise
        
        Adresse adresseEntrepriseBerbe = new Adresse(12, "rue des Peupliers", "67500", "Haguenau");
        Adresse adresseEntrepriseSancho = new Adresse(154, "rue des Rosiers", "70200", "Héricourt");
        Adresse adresseEntrepriseArnoult = new Adresse(20, "rue d'Austrasie", "54000", "Nancy");
        Adresse adresseEntrepriseDehaye = new Adresse(26, "rue des Fusillés", "57000", "Metz");
        Adresse adresseEntreprisePeintreExperts = new Adresse(111, "rue de l'Europe", "54000", "Laxou");
        Adresse adresseEntrepriseBombardi = new Adresse(45, "rue des Tulipiers", "10000", "Troyes");
        Adresse adresseEntrepriseBellorti = new Adresse(37, "avenue Jean Jaurès", "59000", "Lille");
        Adresse adresseEntreprisePlacoExpert = new Adresse(59, "impasse des Coquelicots", "88000", "Epinal");
        Adresse adresseEntrepriseProCharpente = new Adresse(22, "route des Romains", "83000", "Toulon");
        Adresse adresseEntrepriseCouvreTout = new Adresse(36, "rue de Cambrai", "93400", "Clichy-sous-Bois");
        Adresse adresseEntreprisePlatrever = new Adresse(69, "rue du Duc", "L-2850", "Luxembourg");
        Adresse adresseEntrepriseAkar = new Adresse(123, "rue Aristide Briand", "67000", "Strasbourg");
        Adresse adresseImmeuble10A8L7E8A = new Adresse(37, "avenue Jean Jaurès", "59000", "Lille");
        Adresse adresseHopital10L9E11A = new Adresse(590, "rue du Commandant Girardot", "70000", "Vesoul");
        Adresse adresseMaison5L4E4A = new Adresse(22, "route de la Victoire", "83000", "Toulon");
        Adresse adresseEtablissementScolaire0L = new Adresse(44, "rue des Sources", "93400", "Clichy-sous-Bois");
        Adresse adresseImmeuble8A7L = new Adresse(9, "rue Marie Curie", "L-2850", "Luxembourg");
        Adresse adresseMusee10L8E15A = new Adresse(188, "rue Napoléon Bonaparte", "67000", "Strasbourg");

        em.persist(adresseEntrepriseBerbe);
        em.persist(adresseEntrepriseSancho);
        em.persist(adresseEntrepriseArnoult);
        em.persist(adresseEntrepriseDehaye);
        em.persist(adresseEntreprisePeintreExperts);
        em.persist(adresseEntrepriseBombardi);
        em.persist(adresseEntrepriseBellorti);
        em.persist(adresseEntreprisePlacoExpert);
        em.persist(adresseEntrepriseProCharpente);
        em.persist(adresseEntrepriseCouvreTout);
        em.persist(adresseEntreprisePlatrever);
        em.persist(adresseEntrepriseAkar);
        em.persist(adresseImmeuble10A8L7E8A);
        em.persist(adresseHopital10L9E11A);
        em.persist(adresseMaison5L4E4A);
        em.persist(adresseEtablissementScolaire0L);
        em.persist(adresseImmeuble8A7L);
        em.persist(adresseMusee10L8E15A);

        entrepriseBerbe.setAdresse(adresseEntrepriseBerbe);
        entrepriseSancho.setAdresse(adresseEntrepriseSancho);
        entrepriseArnoult.setAdresse(adresseEntrepriseArnoult);
        entrepriseDehaye.setAdresse(adresseEntrepriseDehaye);
        entreprisePeintreExperts.setAdresse(adresseEntreprisePeintreExperts);
        entrepriseBombardi.setAdresse(adresseEntrepriseBombardi);
        entrepriseBellorti.setAdresse(adresseEntrepriseBellorti);
        entreprisePlacoExpert.setAdresse(adresseEntreprisePlacoExpert);
        entrepriseProCharpente.setAdresse(adresseEntrepriseProCharpente);
        entrepriseCouvreTout.setAdresse(adresseEntrepriseCouvreTout);
        entreprisePlatrever.setAdresse(adresseEntreprisePlatrever);
        entrepriseAkar.setAdresse(adresseEntrepriseAkar);
        
        // Un lotissement : 10 lots, 8 entreprises, 10 acteurs ---------------------------------------------------------

        Date dans100Jours = getDateInDays(maintenant, 100);
        Date dans110Jours = getDateInDays(maintenant, 110);
        Date dans120Jours = getDateInDays(maintenant, 120);
        Date dans130Jours = getDateInDays(maintenant, 130);
        Date dans140Jours = getDateInDays(maintenant, 140);

        Lots charpenteLotissement10L8E10A = new Charpente(1, maintenant,  10, 150, 70, dans100Jours, ECharpente.toitPlat);
        Lots couvertureLotissement10L8E10A = new Charpente(2, maintenant,  3, 100, 50, dans100Jours,ECharpente.toitPlat);
        Lots dallageLotissement10L8E10A = new Dallage(3, maintenant, 3, 2, 5, dans110Jours,2000);
        Lots electriciteLotissement10L8E10A = new Electricite(4, maintenant, 3, 20, 30, dans120Jours,4, 101.57f);
        Lots menuiseriesLotissement10L8E10A = new Menuiseries(5, maintenant, 1, 3, 2, dans130Jours,8, 15, 2);
        Lots peintureLotissement10L8E10A = new Peinture(6, maintenant, 2, 1, 3, dans130Jours,20);
        Lots peintureExterieureLotissement10L8E10A = new Peinture(7, maintenant, 2, 2, 4, dans110Jours,200);
        Lots platerieLotissement10L8E10A = new Platerie(8, maintenant, 2, 1, 2, dans130Jours,200, 1450);
        Lots plomberieLotissement10L8E10A = new Reseaux(9, maintenant, 4, 10, 20, dans140Jours,150.67f);
        Lots electriciteReseauLotissement10L8E10A = new Reseaux(10, maintenant, 3, 15, 30, dans110Jours,170.67f);

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
                "Lotissement les Fleurs Bleues", 2000, EAvancement.terminé, dans140Jours,
                1520000, true, dans100Jours, 14);

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

        Charpente charpenteImmeuble10A8L7E8A = new Charpente(1, maintenant, 30, 150, 40, dans110Jours,ECharpente.fermette);
        Dallage dallageImmeuble10A8L7E8A = new Dallage(2, maintenant, 5, 20, 10, dans100Jours,2000);
        Electricite electriciteImmeuble10A8L7E8A = new Electricite(3, maintenant, 7, 30, 15, dans120Jours,9, 91.57f);
        Fondation fondationImmeuble10A8L7E8A = new Fondation(4, maintenant, 10, 26, 20, dans100Jours,13);
        Maconnerie maconnerieImmeuble10A8L7E8A = new Maconnerie(5, maintenant, 20, 16, 30, dans130Jours,1500, 8);
        Menuiseries menuiseriesImmeuble10A8L7E8A = new Menuiseries(6, maintenant, 7, 10, 5, dans130Jours,53, 25, 8);
        Platerie platerieImmeuble10A8L7E8A = new Platerie(7, maintenant, 3, 6,3, dans140Jours,1500, 6000);
        Reseaux reseauxImmeuble10A8L7E8A = new Reseaux(8, maintenant, 2, 12, 6, dans140Jours,99.97f);
        
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
                2500, EAvancement.terminé, dans120Jours, 1620000, true, dans100Jours,
                4, appartsImmeuble10A8L7E8A);

        immeuble10A8L7E8A.setAdresse(adresseImmeuble10A8L7E8A);
        immeuble10A8L7E8A.setLots(lotsImmeuble10A8L7E8A);

        appart1Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart2Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart3Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart4Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart5Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart6Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart7Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart8Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart9Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);
        appart10Immeuble10A8L7E8A.setImmeuble((Immeuble)immeuble10A8L7E8A);

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

        Charpente charpenteHopital10L9E11A = new Charpente(1, maintenant, 40, 2000, 1000, dans100Jours,ECharpente.toitPlat);
        Dallage dallageHopital10L9E11A = new Dallage(2, maintenant, 10, 400, 200, dans110Jours,20000);
        Electricite electriciteHopital10L9E11A = new Electricite(3, maintenant, 20, 800, 400, dans120Jours,12, 101.57f);
        Fondation fondationHopital10L9E11A = new Fondation(4, maintenant, 10, 1000, 500, dans100Jours,25);
        Maconnerie maconnerieHopital10L9E11A = new Maconnerie(5, maintenant, 20, 1200, 600, dans110Jours,1500, 22);
        Menuiseries menuiseriesHopital10L9E11A = new Menuiseries(6, maintenant, 10, 600, 300, dans120Jours,113, 55, 0);
        Peinture peintureHopital10L9E11A = new Peinture(7, maintenant, 5, 300, 150, dans130Jours,25000);
        Platerie platerieHopital10L9E11A = new Platerie(8, maintenant, 7, 400, 200, dans120Jours,2000, 8500);
        Reseaux reseauxHopital10L9E11A = new Reseaux(9, maintenant, 5, 800, 400, dans110Jours,1510.97f);
        Terrassement terrassementHopital10L9E11A = new Terrassement(10, maintenant, 10, 100, 50, dans100Jours,65000);

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
                EAvancement.terminé, dans140Jours, 5420000, true, dans110Jours, EMinistere.santé,
                357, 24);

        hopital10L9E11A.setAdresse(adresseHopital10L9E11A);
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

        Lots charpenteMaison5L4E4A = new Charpente(1, maintenant, 10, 40, 20, dans100Jours, ECharpente.traditionnelle);
        Lots dallageMaison5L4E4A = new Dallage(2, maintenant, 2, 10, 5, dans110Jours, 150);
        Lots electriciteMaison5L4E4A = new Electricite(3, maintenant, 3, 8, 4, dans130Jours, 2, 88.57f);
        Lots maconnerieMaison5L4E4A = new Maconnerie(4, maintenant, 4, 20, 10, dans120Jours, 500, 4);
        Lots reseauxMaison5L4E4A = new Reseaux(5, maintenant, 1, 4, 2, dans140Jours, 73.67f);

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
                EAvancement.terminé, dans120Jours, 400000, true, dans100Jours,
                5, 2);

        maison5L4E4A.setAdresse(adresseMaison5L4E4A);
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
                1500, EAvancement.enCours, dans100Jours, 2500000, false,
                dans140Jours, EMinistere.education,1142, EEtaScolaire.lycee);

        etablissementScolaire0L.setAdresse(adresseEtablissementScolaire0L);
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

        Lots terrassementImmeuble8A7L = new Terrassement(1, maintenant, 5, 60, 30, dans100Jours, 100);
        Lots dallageImmeuble8A7L = new Dallage(2, maintenant, 10, 20, 10, dans120Jours, 1000);
        Lots menuiseriesImmeuble8A7L = new Menuiseries(3, maintenant, 3, 16, 8, dans130Jours, 16, 10, 4);
        Lots fondationsImmeuble8A7L = new Fondation(4, maintenant, 5, 20, 10, dans100Jours, 20);
        Lots maconnerieImmeuble8A7L = new Maconnerie(5, maintenant, 8, 30, 15, dans110Jours, 2000, 20);
        Lots electriciteImmeuble8A7L = new Electricite(6, maintenant, 3, 40, 20, dans130Jours, 10, 100);
        Lots reseauxImmeuble8A7L = new Reseaux(7, maintenant, 2, 4, 2, dans140Jours, 1000);

        Set<Lots> lotsImmeuble8A7L = new HashSet<>();
        lotsImmeuble8A7L.add(terrassementImmeuble8A7L);
        lotsImmeuble8A7L.add(dallageImmeuble8A7L);
        lotsImmeuble8A7L.add(menuiseriesImmeuble8A7L);
        lotsImmeuble8A7L.add(fondationsImmeuble8A7L);
        lotsImmeuble8A7L.add(maconnerieImmeuble8A7L);
        lotsImmeuble8A7L.add(electriciteImmeuble8A7L);
        lotsImmeuble8A7L.add(reseauxImmeuble8A7L);

        Projet immeuble8A7L = new Immeuble("Immeuble8A7L", "Immeuble HLM", 2500, EAvancement.enCours,
                dans110Jours, 3000000, false, dans120Jours, 7, appartsImmeuble8A7L);

        immeuble8A7L.setAdresse(adresseImmeuble8A7L);
        immeuble8A7L.setLots(lotsImmeuble8A7L);

        appart1Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart2Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart3Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart4Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart5Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart6Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart7Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);
        appart8Immeuble8A7L.setImmeuble((Immeuble)immeuble8A7L);

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

        // Un musée : 10 lots, 8 entreprises, 15 acteurs ---------------------------------------------------------------

        Lots terrassementMusee10L8E15A = new Terrassement(1, maintenant, 3, 20, 10, dans100Jours, 100);
        Lots dallageMusee10L8E15A = new Dallage(2, maintenant, 2, 10, 5, dans110Jours, 1000);
        Lots menuiseriesMusee10L8E15A = new Menuiseries(3, maintenant, 1, 14, 7, dans120Jours, 16, 10, 4);
        Lots fondationsMusee10L8E15A = new Fondation(4, maintenant, 2, 20, 10, dans110Jours, 20);
        Lots maconnerieMusee10L8E15A = new Maconnerie(5, maintenant, 5, 30, 15, dans100Jours, 2000, 20);
        Lots electriciteMusee10L8E15A = new Electricite(6, maintenant, 3, 18, 9, dans130Jours, 10, 100);
        Lots reseauxMusee10L8E15A = new Reseaux(7, maintenant, 1, 6, 3, dans140Jours, 1000);
        Lots peintureMusee10L8E15A = new Peinture(8, maintenant, 4, 4, 2, dans130Jours, 100);
        Lots peintureMuseeHall10L8E15A = new Peinture(9, maintenant, 1, 2, 1, dans130Jours, 30);
        Lots platerieMusee10L8E15A = new Platerie(10, maintenant, 3, 6, 3, dans120Jours, 500,700);

        Set<Lots> lotsMusee10L8E15A = new HashSet<>();
        lotsMusee10L8E15A.add(terrassementMusee10L8E15A);
        lotsMusee10L8E15A.add(dallageMusee10L8E15A);
        lotsMusee10L8E15A.add(menuiseriesMusee10L8E15A);
        lotsMusee10L8E15A.add(fondationsMusee10L8E15A);
        lotsMusee10L8E15A.add(maconnerieMusee10L8E15A);
        lotsMusee10L8E15A.add(electriciteMusee10L8E15A);
        lotsMusee10L8E15A.add(reseauxMusee10L8E15A);
        lotsMusee10L8E15A.add(peintureMusee10L8E15A);
        lotsMusee10L8E15A.add(peintureMuseeHall10L8E15A);
        lotsMusee10L8E15A.add(platerieMusee10L8E15A);

        Set<Entreprise> entreprisesTerrassementMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesDallageMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesMenuiseriesMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesFondationsMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesElectriciteReseauxMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesPeintureMusee10L8E15A = new HashSet<>();
        Set<Entreprise> entreprisesPlaterieMusee10L8E15A = new HashSet<>();

        entreprisesTerrassementMusee10L8E15A.add(entrepriseBerbe);
        entreprisesDallageMusee10L8E15A.add(entrepriseSancho);
        entreprisesMenuiseriesMusee10L8E15A.add(entrepriseArnoult);
        entreprisesFondationsMusee10L8E15A.add(entrepriseBerbe);
        entreprisesFondationsMusee10L8E15A.add(entrepriseBellorti);
        entreprisesElectriciteReseauxMusee10L8E15A.add(entrepriseDehaye);
        entreprisesPeintureMusee10L8E15A.add(entreprisePeintreExperts);
        entreprisesPlaterieMusee10L8E15A.add(entreprisePlacoExpert);

        terrassementMusee10L8E15A.setEntrepriseResponsable(entrepriseBerbe);
        terrassementMusee10L8E15A.setEntreprisesRealisatrices(entreprisesTerrassementMusee10L8E15A);

        dallageMusee10L8E15A.setEntrepriseResponsable(entrepriseSancho);
        dallageMusee10L8E15A.setEntreprisesRealisatrices(entreprisesDallageMusee10L8E15A);

        menuiseriesMusee10L8E15A.setEntrepriseResponsable(entrepriseArnoult);
        menuiseriesMusee10L8E15A.setEntreprisesRealisatrices(entreprisesMenuiseriesMusee10L8E15A);

        fondationsMusee10L8E15A.setEntrepriseResponsable(entrepriseBellorti);
        fondationsMusee10L8E15A.setEntreprisesRealisatrices(entreprisesFondationsMusee10L8E15A);

        maconnerieMusee10L8E15A.setEntrepriseResponsable(entrepriseBellorti);
        maconnerieMusee10L8E15A.setEntreprisesRealisatrices(entreprisesFondationsMusee10L8E15A);

        electriciteMusee10L8E15A.setEntrepriseResponsable(entrepriseDehaye);
        electriciteMusee10L8E15A.setEntreprisesRealisatrices(entreprisesElectriciteReseauxMusee10L8E15A);

        reseauxMusee10L8E15A.setEntrepriseResponsable(entrepriseDehaye);
        reseauxMusee10L8E15A.setEntreprisesRealisatrices(entreprisesElectriciteReseauxMusee10L8E15A);

        peintureMusee10L8E15A.setEntrepriseResponsable(entreprisePeintreExperts);
        peintureMusee10L8E15A.setEntreprisesRealisatrices(entreprisesPeintureMusee10L8E15A);

        peintureMuseeHall10L8E15A.setEntrepriseResponsable(entreprisePeintreExperts);
        peintureMuseeHall10L8E15A.setEntreprisesRealisatrices(entreprisesPeintureMusee10L8E15A);

        platerieMusee10L8E15A.setEntrepriseResponsable(entreprisePeintreExperts);
        platerieMusee10L8E15A.setEntreprisesRealisatrices(entreprisesPlaterieMusee10L8E15A);

        Projet musee10L8E15A = new Musee("Musee10L8E15A", "Musée des Arts Modernes", 6000,
                EAvancement.enCours, dans100Jours, 6520000, false, dans120Jours,
                EMinistere.culture, 8);

        musee10L8E15A.setAdresse(adresseMusee10L8E15A);
        musee10L8E15A.setLots(lotsMusee10L8E15A);

        em.persist(musee10L8E15A);

        terrassementMusee10L8E15A.setProjet(musee10L8E15A);
        dallageMusee10L8E15A.setProjet(musee10L8E15A);
        menuiseriesMusee10L8E15A.setProjet(musee10L8E15A);
        fondationsMusee10L8E15A.setProjet(musee10L8E15A);
        maconnerieMusee10L8E15A.setProjet(musee10L8E15A);
        electriciteMusee10L8E15A.setProjet(musee10L8E15A);
        reseauxMusee10L8E15A.setProjet(musee10L8E15A);
        peintureMusee10L8E15A.setProjet(musee10L8E15A);
        peintureMuseeHall10L8E15A.setProjet(musee10L8E15A);
        platerieMusee10L8E15A.setProjet(musee10L8E15A);

        em.persist(terrassementMusee10L8E15A);
        em.persist(dallageMusee10L8E15A);
        em.persist(menuiseriesMusee10L8E15A);
        em.persist(fondationsMusee10L8E15A);
        em.persist(maconnerieMusee10L8E15A);
        em.persist(electriciteMusee10L8E15A);
        em.persist(reseauxMusee10L8E15A);
        em.persist(peintureMusee10L8E15A);
        em.persist(peintureMuseeHall10L8E15A);
        em.persist(platerieMusee10L8E15A);
    }
}
