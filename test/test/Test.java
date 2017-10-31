package test;

import util.EAvancement;
import util.ECorpsMetier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test {

    private static void displayOneAttributeResults(List<String> results, String resultIdentifier){
        System.out.println(resultIdentifier);
        for (String result : results) System.out.println(result);
    }

    public static long getDateDiff(java.sql.Date date1, java.sql.Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private static void twoNewLinesInConsole(){
        System.out.println("\n");
    }

    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Génère le jeu de données
        Seeder.initialize(em);

        // Requêtes ----------------------------------------------------------------------------------------------------

        // 1 - Quelles sont les entreprises avec lesquelles le cabinet travaille ? OK

        twoNewLinesInConsole();

        System.out.println("======================== REQUÊTE 1 : Quelles sont les entreprises avec lesquelles le cabinet travaille ? ======================== \n");
        Query queryEntreprisesTravaillantAvecCabinet = em.createNamedQuery("Entreprise.entreprisesTravaillantAvecCabinet", String.class);
        List<String> entreprisesTravaillantAvecCabinet = queryEntreprisesTravaillantAvecCabinet.getResultList();
        displayOneAttributeResults(entreprisesTravaillantAvecCabinet, "Nom des entreprises travaillant avec le cabinet : ");

        twoNewLinesInConsole();

        // 2 - Quels sont les projets en cours ? OK

        System.out.println("======================== REQUÊTE 2 : Quels sont les projets en cours ? ======================== \n");
        Query queryProjetsEnCours = em.createNamedQuery("Projet.projetsEnCours", String.class);
        queryProjetsEnCours.setParameter("avancement", EAvancement.enCours);
        List<String> projetsEnCours = queryProjetsEnCours.getResultList();
        displayOneAttributeResults(projetsEnCours, "Nom des projets en cours : ");

        twoNewLinesInConsole();

        // 3 - Quel est lʼavancement du projet de reference « PLot12 » ? OK
        System.out.println("======================== REQUÊTE 3 : Quel est lʼavancement du projet de référence « PLot12 » ? ======================== \n");
        Query queryAvancementProjetsPLot12 = em.createNamedQuery("Projet.avancementProjetPLot12", EAvancement.class);
        queryAvancementProjetsPLot12.setParameter("reference", "PLot12");
        List<Enum> projetsDeReferencePLot12 = queryAvancementProjetsPLot12.getResultList();
        for (Enum e : projetsDeReferencePLot12) {
            System.out.println("Avancement du projet PLot12 : " + e.toString());
        }

        twoNewLinesInConsole();

        // 4 - Combien de projets portant sur un etablissement scolaire ont été realisés ? OK

        System.out.println("======================== REQUÊTE 4 : Combien de projets portant sur un établissement scolaire ont été realisés ? ======================== \n");
        Query queryNombreProjetsEtablissementScolaire = em.createNamedQuery("EtablissementScolaire.nombreDeProjets", Object.class);
        Object nombreProjetsEtablissementScolaire = queryNombreProjetsEtablissementScolaire.getResultList();
        System.out.println("Nombre de projets relatif à un établissement scolaire : " + nombreProjetsEtablissementScolaire.toString());

        twoNewLinesInConsole();

        // 5 - Quelles sont les entreprises de plomberie ? OK

        System.out.println("======================== REQUÊTE 5 : Quelles sont les entreprises de plomberie ? ======================== \n");
        Query queryEntreprisesPlomberie = em.createNamedQuery("Entreprise.entreprisesCorpsMetier", String.class);
        queryEntreprisesPlomberie.setParameter("corpsMetier", ECorpsMetier.Plombier);
        List<String> entreprisesPlomberie = queryEntreprisesPlomberie.getResultList();
        displayOneAttributeResults(entreprisesPlomberie, "Nom des entreprises de plomberie : ");

        twoNewLinesInConsole();

        // 6 - Quels sont les noms des contacts de lʼentreprise « General Batiment » ? OK

        System.out.println("======================== REQUÊTE 6 : Quels sont les noms des contacts de lʼentreprise « General Batiment » ? ======================== \n");
        Query queryContactsEntrepriseGeneralBatiment = em.createNamedQuery("Acteur.contactsEntrepriseGeneralBatiment", String.class);
        queryContactsEntrepriseGeneralBatiment.setParameter("entreprise", "General Batiment");
        List<String> nomsContactEntrepriseGeneralBatiment = queryContactsEntrepriseGeneralBatiment.getResultList();
        displayOneAttributeResults(nomsContactEntrepriseGeneralBatiment, "Nom des contacts de l'entreprise Berbe et fils SARL : ");

        twoNewLinesInConsole();

        // 7 - A quels projets termines lʼentreprise « General Batiment » a participé ? OK

        System.out.println("======================== REQUÊTE 7 : À quels projets terminés lʼentreprise « General Batiment » a-t-elle participé ? ======================== \n");
        Query queryProjetsTerminesAvecGeneralBatiment = em.createNamedQuery("Lots.projetsTerminesAvecGeneralBatiment", String.class);
        queryProjetsTerminesAvecGeneralBatiment.setParameter("avancement", EAvancement.terminé);
        queryProjetsTerminesAvecGeneralBatiment.setParameter("entreprise", "General Batiment");
        List<String> projetsTerminesAvecGeneralBatiment = queryProjetsTerminesAvecGeneralBatiment.getResultList();
        displayOneAttributeResults(projetsTerminesAvecGeneralBatiment, "Projets terminés de l'entreprise General Batiment : ");

        twoNewLinesInConsole();

        // 8 - Quels sont les lots des projets en cours auxquels participe lʼentreprise « General Batiment » ? OK

        System.out.println("======================== REQUÊTE 8 : Quels sont les lots des projets en cours auxquels participe lʼentreprise « General Batiment » ? ======================== \n");
        Query queryLotsDesProjetsEnCoursDeGeneralBatiment = em.createNamedQuery("Lots.lotsDesProjetsEnCoursDeGeneralBatiment", Integer.class);
        queryLotsDesProjetsEnCoursDeGeneralBatiment.setParameter("entreprise", "General Batiment");
        queryLotsDesProjetsEnCoursDeGeneralBatiment.setParameter("avancement", EAvancement.terminé);
        List<Integer> lotsDesProjetsEnCoursDeGeneralBatiment = queryLotsDesProjetsEnCoursDeGeneralBatiment.getResultList();
        System.out.println("Lot des projets en cours auxquels participe General Batiment : ");
        for (Integer i : lotsDesProjetsEnCoursDeGeneralBatiment){
            System.out.println("Numéro du lot : " + i);
        }

        twoNewLinesInConsole();

        // 9 - Quels sont les acteurs (et leur entreprise) participant au projet de reference « PLot12 » ? OK

        System.out.println("======================== REQUÊTE 9 : Quels sont les acteurs (et leur entreprise) participant au projet de référence « PLot12 » ? ======================== \n");
        Query queryActeursEtEntrepriseProjetPLot12 = em.createNamedQuery("Lots.acteursEtEntrepriseDuProjetPLot12", Object[].class);
        queryActeursEtEntrepriseProjetPLot12.setParameter("refProjet", "PLot12");
        List<Object[]> acteursEtEntrepriseProjetPLot12 = queryActeursEtEntrepriseProjetPLot12.getResultList();
        System.out.println("Employés travaillant sur le projet PLot12 : ");
        for (Object[] o : acteursEtEntrepriseProjetPLot12){
            System.out.println("Acteur : " + o[0].toString() + " - Entreprise : " +  o[1].toString());
        }

        twoNewLinesInConsole();

        // 10 - Combien de lots a le projet de reference « PLot12 » ? OK

        System.out.println("======================== REQUÊTE 10 : Combien de lots a le projet de reference « PLot12 » ? ======================== \n");
        Query queryNombreLotsProjetPLot12 = em.createNamedQuery("Lots.nombreLotsProjetsPLot12", Object.class);
        queryNombreLotsProjetPLot12.setParameter("refProjet", "PLot12");
        Object nombreLotsProjetPLot12 = queryNombreLotsProjetPLot12.getResultList();
        System.out.println("Nombre de lots du projet PLot12 : " + nombreLotsProjetPLot12.toString());

        twoNewLinesInConsole();

        // 11 - Quel est le coût total estimé du projet de référence « PLot12 » ? OK
        System.out.println("======================== REQUÊTE 11 : Quel est le coût total estimé du projet de référence « PLot12 » ? ======================== \n");
        Query queryCoutProjetPLot12 = em.createNamedQuery("Projet.coutProjetPLot12", Integer.class);
        queryCoutProjetPLot12.setParameter("refProjet", "PLot12");
        List<Integer> coutProjetPLot12 = queryCoutProjetPLot12.getResultList();
        for (Integer i : coutProjetPLot12){
            System.out.println("Coût du projet PLot12 : " + i);
        }

        twoNewLinesInConsole();

        // 12 - Quelles sont les entreprises (et leur adresse) qui ont realisé les menuiseries dans les projets de musées ? OK

        System.out.println("======================== REQUÊTE 12 : Quelles sont les entreprises (et leur adresse) qui ont realisé les menuiseries dans les projets de musées ? ======================== \n");
        Query queryEntreprisesMenuiseriesProjetsMusees = em.createNamedQuery("Lots.entreprisesMenuiseriesProjetsMusees", Object[].class);
        List<Object[]> entreprisesMenuiseriesProjetsMusees = queryEntreprisesMenuiseriesProjetsMusees.getResultList();
        for (Object[] o : entreprisesMenuiseriesProjetsMusees) {
            System.out.println("Entreprise de menuiserie ayant participé à un projet musée : ");
            System.out.println("Entreprise : " + o[0].toString() + " - Adresse : " + o[1].toString() + " " + o[2].toString() + ", " + o[3].toString() + " " + o[4].toString());
        }

        twoNewLinesInConsole();

        // 13 - Quelles sont les durées estimées des différents projets en cours ? OK

        System.out.println("======================== REQUÊTE 13 : Quelles sont les durées estimées des différents projets en cours ? ======================== \n");
        Query queryDureesEstimeesProjetsEnCours = em.createNamedQuery("Projet.dureesEstimeesProjetsEnCours", Object[].class);
        queryDureesEstimeesProjetsEnCours.setParameter("avancement", EAvancement.enCours);
        List<Object[]> dureesEstimeesProjetsEnCours = queryDureesEstimeesProjetsEnCours.getResultList();
        System.out.println("Durées restantes à ce jour des projets en cours : ");
        for(Object[] o : dureesEstimeesProjetsEnCours) {
            System.out.println("Projet : " + o[0].toString() + " - Durée estimée : " + getDateDiff(new Date(new java.util.Date().getTime()), (Date)o[1], TimeUnit.DAYS) + " jours");
        }

        twoNewLinesInConsole();

        // 14 - Quels sont les avancements des lots (et leur type) du projet de reference « PLot12 » ? OK

        System.out.println("======================== REQUÊTE 14 : Quels sont les avancements des lots (et leur type) du projet de reference « PLot12 » ? ======================== \n");
        Query queryAvancementEtTypeLotsProjetPLot12 = em.createNamedQuery("Lots.avancementEtTypeLotsProjetPLot12", Object[].class);
        queryAvancementEtTypeLotsProjetPLot12.setParameter("refProjet", "PLot12");
        List<Object[]> avancementEtTypeLotsProjetPLot12 = queryAvancementEtTypeLotsProjetPLot12.getResultList();
        System.out.println("Lots du projet de référence PLot12 : ");
        for(Object[] o : avancementEtTypeLotsProjetPLot12) {
            System.out.println("Numéro du lot : " + o[0].toString() + " - Type : " + o[1].toString().replace("class metier.", "") + " - Avancement : " + o[2].toString());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
