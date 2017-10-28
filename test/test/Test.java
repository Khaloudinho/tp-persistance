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



        /*em.persist(etablissementScolaire0L);
        em.persist(immeuble8A7L);
        em.persist(musee10L8E15A);*/

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
