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
        acteursPeintreExperts.add(cornevin);
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

        Lots charpenteLotissement10L8E10A = new Charpente(ECharpente.toitPlat);
        Lots couvertureLotissement10L8E10A = new Charpente(ECharpente.toitPlat);
        Lots dallageLotissement10L8E10A = new Dallage(2000);
        Lots electriciteLotissement10L8E10A = new Electricite(4, 101.57f);
        Lots menuiseriesLotissement10L8E10A = new Menuiseries(8, 15, 2);
        Lots peintureLotissement10L8E10A = new Peinture(20);
        Lots peintureExterieureLotissement10L8E10A = new Peinture(200);
        Lots platerieLotissement10L8E10A = new Platerie(200, 1450);
        Lots plomberieLotissement10L8E10A = new Reseaux(150.67f);
        Lots electriciteReseauLotissement10L8E10A = new Reseaux(170.67f);

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

        lotissement10L8E10A.setLots(lotsLotissement10L8E10A);

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

        Charpente charpenteImmeuble10A8L7E8A = new Charpente(ECharpente.fermette);
        Dallage dallageImmeuble10A8L7E8A = new Dallage(2000);
        Electricite electriciteImmeuble10A8L7E8A = new Electricite(9, 91.57f);
        Fondation fondationImmeuble10A8L7E8A = new Fondation(13);
        Maconnerie maconnerieImmeuble10A8L7E8A = new Maconnerie(1500, 8);
        Menuiseries menuiseriesImmeuble10A8L7E8A = new Menuiseries(53, 25, 8);
        Platerie platerieImmeuble10A8L7E8A = new Platerie(1500, 6000);
        Reseaux reseauxImmeuble10A8L7E8A = new Reseaux(99.97f);

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

        // Un hôpital : 10 lots, 9 entreprises, 11 acteurs -------------------------------------------------------------

        Projet hopital = new Hopital(357, 24);

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

        // Une maison : 5 lots, 4 entreprises, 4 acteurs ---------------------------------------------------------------

        Lots charpenteMaison5L4E4A = new Charpente(ECharpente.traditionnelle);
        Lots dallageMaison5L4E4A = new Dallage(150);
        Lots electriciteMaison5L4E4A = new Electricite(2, 88.57f);
        Lots maconnerieMaison5L4E4A = new Maconnerie(500, 4);
        Lots reseauxMaison5L4E4A = new Reseaux(73.67f);

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

        // Un établissement scolaire : pas de lots ---------------------------------------------------------------------

        Projet etablissementScolaire0L = new EtablissementScolaire("EtablissementScolaire0L", "Lycée les Lavandes",
                1500, "En cours", new Date(2017-9-18), 2500000, false,
                new Date(2017-12-9), "Education Nationale",1142, EEtaScolaire.lycee);

        // Un immeuble : 8 appartements, 7 lots ------------------------------------------------------------------------

        Appartement appart1Immeuble8A7L = new Appartement(1, ETypeAppart.T1, 30);
        Appartement appart2Immeuble8A7L = new Appartement(1, ETypeAppart.T2, 40);
        Appartement appart3Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart4Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart5Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart6Immeuble8A7L = new Appartement(2, ETypeAppart.Studio, 20);
        Appartement appart7Immeuble8A7L = new Appartement(3, ETypeAppart.T4, 75);
        Appartement appart8Immeuble8A7L = new Appartement(3, ETypeAppart.Studio, 25);

        Set<Appartement> appartsImmeuble8A7L =  new HashSet<Appartement>();
        appartsImmeuble8A7L.add(appart1Immeuble8A7L);
        appartsImmeuble8A7L.add(appart2Immeuble8A7L);
        appartsImmeuble8A7L.add(appart3Immeuble8A7L);
        appartsImmeuble8A7L.add(appart4Immeuble8A7L);
        appartsImmeuble8A7L.add(appart5Immeuble8A7L);
        appartsImmeuble8A7L.add(appart6Immeuble8A7L);
        appartsImmeuble8A7L.add(appart7Immeuble8A7L);
        appartsImmeuble8A7L.add(appart8Immeuble8A7L);

        Lots terrassementImmeuble8A7L = new Terrassement(100);
        Lots dallageImmeuble8A7L = new Dallage(1000);
        Lots menuiseriesImmeuble8A7L = new Menuiseries(16, 10, 4);
        Lots fondationsImmeuble8A7L = new Fondation(20);
        Lots maconnerieImmeuble8A7L = new Maconnerie(2000, 20);
        Lots electriciteImmeuble8A7L = new Electricite(10, 100);
        Lots reseauxImmeuble8A7L = new Reseaux(1000);

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

        // Un musée : 10 lots, 8 entreprises, 15 acteurs ---------------------------------------------------------------

        Lots terrassementMusee10L8E15A = new Terrassement(100);
        Lots dallageMusee10L8E15A = new Dallage(1000);
        Lots menuiseriesMusee10L8E15A = new Menuiseries(16, 10, 4);
        Lots fondationsMusee10L8E15A = new Fondation(20);
        Lots maconnerieMusee10L8E15A = new Maconnerie(2000, 20);
        Lots electriciteMusee10L8E15A = new Electricite(10, 100);
        Lots reseauxMusee10L8E15A = new Reseaux(1000);
        Lots peintureMusee10L8E15A = new Peinture(100);
        Lots peintureMuseeHall10L8E15A = new Peinture(30);
        Lots platerieMusee10L8E15A = new Platerie(500,700);

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
                "En cours", new Date(2017-5-5), 6520000, false, new Date(2017-12-31),
                "Culture", 8);

        musee10L8E15A.setLots(lotsMusee10L8E15A);

        //em.persist();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
