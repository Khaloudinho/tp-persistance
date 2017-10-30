package test;

import metier.Entreprise;
import util.EAvancement;
import util.ECorpsMetier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test {

    private static void displayOneAttributeResults(List<String> results, String resultIdentifier){
        System.out.print(resultIdentifier);
        for (String result : results) System.out.print(result + ", ");
    }

    private static void displayOneAttributeResultsForEnums(List<Enum> results, String resultIdentifier){
        System.out.print(resultIdentifier);
        for (Enum result : results) System.out.print(result + ", ");
    }

    private static void displayOneAttributeResultsForInt(List<Integer> results, String resultIdentifier){
        System.out.print(resultIdentifier);
        for (Integer result : results) System.out.print(result + ", ");
    }

    public static long getDateDiff(java.sql.Date date1, java.sql.Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private static void twoNewLineInConsole(){
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

        twoNewLineInConsole();

        System.out.println("======================== REQUÊTE 1 : Quelles sont les entreprises avec lesquelles le cabinet travaille ? ======================== \n");
        Query queryEntreprisesTravaillantAvecCabinet = em.createNamedQuery("Entreprise.entreprisesTravaillantAvecCabinet", String.class);
        List<String> entreprisesTravaillantAvecCabinet = queryEntreprisesTravaillantAvecCabinet.getResultList();
        displayOneAttributeResults(entreprisesTravaillantAvecCabinet, "Nom entreprise : ");

        twoNewLineInConsole();

        // 2 - Quels sont les projets en cours ? OK

        System.out.println("======================== REQUÊTE 2 : Quels sont les projets en cours ? ======================== \n");
        Query queryProjetsEnCours = em.createNamedQuery("Projet.projetsEnCours", String.class);
        queryProjetsEnCours.setParameter("avancement", EAvancement.enCours);
        List<String> projetsEnCours = queryProjetsEnCours.getResultList();
        displayOneAttributeResults(projetsEnCours, "Nom projet : ");

        twoNewLineInConsole();

        // 3 - Quel est lʼavancement du projet de reference « PLot12 » ? OK
        System.out.println("======================== REQUÊTE 3 : Quel est lʼavancement du projet de référence « PLot12 » ? ======================== \n");
        Query queryAvancementProjetsPLot12 = em.createNamedQuery("Projet.avancementProjetPLot12", EAvancement.class);
        queryAvancementProjetsPLot12.setParameter("reference", "Immeuble10A8L7E8A");
        List<Enum> projetsDeReferencePLot12 = queryAvancementProjetsPLot12.getResultList();
        displayOneAttributeResultsForEnums(projetsDeReferencePLot12, "Avancement du projet Immeuble10A8L7E8A : ");

        twoNewLineInConsole();

        // 4 - Combien de projets portant sur un etablissement scolaire ont été realisés ? OK
        /*
            RAPPEL : EtablissementScolaire extends de BatimentPublic qui lui meme extends de Projet,
            la denomination EtablisementScolaire correspond meme si elle trompeuse a un Projet
        */

        System.out.println("======================== REQUÊTE 4 : Combien de projets portant sur un établissement scolaire ont été realisés ? ======================== \n");
        Query queryNombreProjetsEtablissementScolaire = em.createNamedQuery("EtablissementScolaire.nombreDeProjets", Object.class);
        Object nombreProjetsEtablissementScolaire = queryNombreProjetsEtablissementScolaire.getResultList();
        System.out.println("Nombre de projets : " + nombreProjetsEtablissementScolaire.toString());

        twoNewLineInConsole();

        // 5 - Quelles sont les entreprises de plomberie ? OK
        /*
            Il n'est pas possible de passer la valeur de l'enumeration directement on a recours donc a une requete parametree
            ce qui apporte au final plus de flexibilite / et moins de redondance si jamais on decidait de faire des requetes
            sur plusieurs types d'entreprises
        */

        System.out.println("======================== REQUÊTE 5 : Quelles sont les entreprises de plomberie ? ======================== \n");
        Query queryEntreprisesPlomberie = em.createNamedQuery("Entreprise.entreprisesCorpsMetier", String.class);
        queryEntreprisesPlomberie.setParameter("corpsMetier", ECorpsMetier.Plombier);
        List<String> entreprisesPlomberie = queryEntreprisesPlomberie.getResultList();
        displayOneAttributeResults(entreprisesPlomberie, "Nom entreprise : ");

        twoNewLineInConsole();

        // 6 - Quels sont les noms des contacts de lʼentreprise « General Batiment » ? KO
        // A valider je ne sais pas ce que le professeur veut vraiement ==> les contacts ==> les acteurs ? ou le tel simplement ?
        // Je ne comprends pa l'interet du cross join (ntlr a la place d'un inner) genere par hibernate mais les resultats sont corrects

        System.out.println("======================== REQUÊTE 6 : Quels sont les noms des contacts de lʼentreprise « General Batiment » ? ======================== \n");
        Query queryContactsEntrepriseGeneralBatiment = em.createNamedQuery("Acteur.contactsEntrepriseGeneralBatiment", String.class);
        queryContactsEntrepriseGeneralBatiment.setParameter("entreprise", "Berbe et fils SARL");
        List<String> nomsContactEntrepriseGeneralBatiment = queryContactsEntrepriseGeneralBatiment.getResultList();
        displayOneAttributeResults(nomsContactEntrepriseGeneralBatiment, "Nom contact : ");

        twoNewLineInConsole();

        // 7 - A quels projets termines lʼentreprise « General Batiment » a participé ?

        System.out.println("======================== REQUÊTE 7 : À quels projets terminés lʼentreprise « General Batiment » a-t-elle participé ? ======================== \n");
        Query queryProjetsTerminesAvecGeneralBatiment = em.createNamedQuery("Projet.projetsTerminesAvecGeneralBatiment", String.class);
        queryProjetsTerminesAvecGeneralBatiment.setParameter("avancement", EAvancement.terminé);
        queryProjetsTerminesAvecGeneralBatiment.setParameter("entreprise", "Sancho et fils SARL");
        List<String> projetsTerminesAvecGeneralBatiment = queryProjetsTerminesAvecGeneralBatiment.getResultList();
        displayOneAttributeResults(projetsTerminesAvecGeneralBatiment, "Projets terminés de Général Bâtiment : ");

        twoNewLineInConsole();

        // 8 - Quels sont les lots des projets en cours auxquels participe lʼentreprise « General Batiment » ?

        // Pour avoir le nom du lot on devrait ce base sur le nom de la table fille.. relativement complexe

        System.out.println("======================== REQUÊTE 8 : Quels sont les lots des projets en cours auxquels participe lʼentreprise « General Batiment » ? ======================== \n");
        Query queryLotsDesProjetsEnCoursDeGeneralBatiment = em.createNamedQuery("Lots.lotsDesProjetsEnCoursDeGeneralBatiment", Integer.class);
        queryLotsDesProjetsEnCoursDeGeneralBatiment.setParameter("entreprise", "Sancho et fils SARL");
        queryLotsDesProjetsEnCoursDeGeneralBatiment.setParameter("avancement", EAvancement.terminé);
        List<Integer> lotsDesProjetsEnCoursDeGeneralBatiment = queryLotsDesProjetsEnCoursDeGeneralBatiment.getResultList();
        displayOneAttributeResultsForInt(lotsDesProjetsEnCoursDeGeneralBatiment, "Lot d'un projet en cours auxquels participe General Batiment : ");

        twoNewLineInConsole();

        // 9 - Quels sont les acteurs (et leur entreprise) participant au projet de reference « PLot12 » ?
        /*
                "SELECT DISTINCT a.nom, e.nom " +
                "FROM acteur a, entreprise e, entreprise_acteur ea, lots_entreprise l, projet_lots p " +
                "WHERE ea.entreprise_id = l.entreprisesRealisatrices_id AND l.lots_id = p.lots_id AND a.id = e.acteurs_id " +
                "AND e.id = l.entreprisesRealisatrices_id AND p.refProjet = 'Immeuble8A7L' ";
        */

        System.out.println("======================== REQUÊTE 9 : Quels sont les acteurs (et leur entreprise) participant au projet de référence « PLot12 » ? ======================== \n");
        Query queryActeursEtEntrepriseProjetPLot12 = em.createNamedQuery("Acteur.acteursEtEntrepriseDuProjetPLot12", Object[].class);
        queryActeursEtEntrepriseProjetPLot12.setParameter("refProjet", "Musee10L8E15A");
        List<Object[]> acteursEtEntrepriseProjetPLot12 = queryActeursEtEntrepriseProjetPLot12.getResultList();
        for (Object[] o : acteursEtEntrepriseProjetPLot12){
            System.out.println(o[0].toString() + " de l'entreprise " + o[1].toString() + " travaille sur le projet PLot12");
        }

        twoNewLineInConsole();

        // 10 - Combien de lots a le projet de reference " PLot12 " ?

        System.out.println("======================== REQUÊTE 10 : Combien de lots a le projet de reference « PLot12 » ? ======================== \n");
        Query queryNombreLotsProjetPLot12 = em.createNamedQuery("Lots.nombreLotsProjetsPLot12", Object.class);
        queryNombreLotsProjetPLot12.setParameter("refProjet", "Musee10L8E15A");
        Object nombreLotsProjetPLot12 = queryNombreLotsProjetPLot12.getResultList();
        System.out.println("Nombre de lots du projet PLot12 : " + nombreLotsProjetPLot12.toString());

        twoNewLineInConsole();

        // 11 - Quel est le coût total estimé du projet de référence « PLot12 » ?
        System.out.println("======================== REQUÊTE 11 : Quel est le coût total estimé du projet de référence « PLot12 » ? ======================== \n");
        Query queryCoutProjetPLot12 = em.createNamedQuery("Projet.coutProjetPLot12", Integer.class);
        queryCoutProjetPLot12.setParameter("refProjet", "Musee10L8E15A");
        List<Integer> coutProjetPLot12 = queryCoutProjetPLot12.getResultList();
        displayOneAttributeResultsForInt(coutProjetPLot12, "Coût du projet PLot12 : ");

        twoNewLineInConsole();

        // 12 - Quelles sont les entreprises (et leur adresse) qui ont realisé les menuiseries dans les projets de musées ?
        /*
        System.out.println("======================== REQUÊTE 12 : Quelles sont les entreprises (et leur adresse) qui ont realisé les menuiseries dans les projets de musées ? ======================== \n");
        Query queryEntreprisesMenuiseriesProjetsMusees = em.createNamedQuery("Projet.entreprisesMenuiseriesProjetsMusees", Object[].class);
        queryEntreprisesMenuiseriesProjetsMusees.setParameter("refProjet", "Musee10L8E15A");
        List<Object[]> entreprisesMenuiseriesProjetsMusees = queryCoutProjetPLot12.getResultList();
        for (Object[] o : entreprisesMenuiseriesProjetsMusees){
            System.out.println("Entreprise ayant réalisé des menuiseries sur un projet musée : " + o[0].toString() + " (" + o[1].toString() + ")");
        }
        */

        // 13 - Quelles sont les durées estimées des différents projets en cours ?
        System.out.println("======================== REQUÊTE 13 : Quelles sont les durées estimées des différents projets en cours ? ======================== \n");
        Query queryDureesEstimeesProjetsEnCours = em.createNamedQuery("Projet.dureesEstimeesProjetsEnCours", Object[].class);
        queryDureesEstimeesProjetsEnCours.setParameter("avancement", EAvancement.enCours);
        List<Object[]> dureesEstimeesProjetsEnCours = queryDureesEstimeesProjetsEnCours.getResultList();
        for(Object[] o : dureesEstimeesProjetsEnCours) {
            System.out.println("Projet : " + o[0].toString() + ", durée estimée : " + getDateDiff(new Date(new java.util.Date().getTime()), (Date)o[1], TimeUnit.DAYS) + " jours");
        }

        twoNewLineInConsole();

        // 14 - Quels sont les avancements des lots (et leur type) du projet de reference « PLot12 » ?
        System.out.println("======================== REQUÊTE 14 : Quels sont les avancements des lots (et leur type) du projet de reference « PLot12 » ? ======================== \n");
        Query queryAvancementEtTypeLotsProjetPLot12 = em.createNamedQuery("Lots.avancementEtTypeLotsProjetPLot12", Object[].class);
        queryAvancementEtTypeLotsProjetPLot12.setParameter("refProjet", "Musee10L8E15A");
        List<Object[]> avancementEtTypeLotsProjetPLot12 = queryAvancementEtTypeLotsProjetPLot12.getResultList();
        for(Object[] o : avancementEtTypeLotsProjetPLot12) {
            System.out.println("ID Lot : " + o[0].toString() + ", avancement : " + o[1].toString() + ", type : " + o[0].getClass());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
