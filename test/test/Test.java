package test;

import util.ECorpsMetier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class Test {

    private static void displayOneAttributeResults(List<String> results, String resultIdentifier){
        for (String result : results) {
            System.out.println(resultIdentifier + " " +result);
        }
    }

    private static void twoNewLineInConsole(){
        System.out.println("\n\n");
    }

    public static void main(String [] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpersistancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Genere le jeu de donnees
        Seeder.initialize(em);

        // Requetes
        // 1 - Quelles sont les entreprises avec lesquelles le cabinet travaille ?
        System.out.println("Quelles sont les entreprises avec lesquelles le cabinet travaille ?\n");
        Query queryEntreprisesTravaillantAvecCabinet = em.createNamedQuery("Entreprise.entreprisesTravaillantAvecCabinet", String.class);
        List<String> entreprisesTravaillantAvecCabinet = queryEntreprisesTravaillantAvecCabinet.getResultList();
        displayOneAttributeResults(entreprisesTravaillantAvecCabinet, "Nom entreprise :");

        twoNewLineInConsole();

        // 2 - Quels sont les projets en cours ?
        System.out.println("Quels sont les projets en cours ?\n");
        Query queryProjetsEnCours = em.createNamedQuery("Projet.projetsEnCours", String.class);
        List<String> projetsEnCours = queryProjetsEnCours.getResultList();
        displayOneAttributeResults(projetsEnCours, "Nom projet :");

        twoNewLineInConsole();

        // 3 - Quel est lʼavancement du projet de reference « PLot12 » ?
        System.out.println("Quel est lʼavancement du projet de reference « PLot12 » ?\n");
        Query queryProjetsDeReferencePLot12 = em.createNamedQuery("Projet.projetDeReference", String.class);
        //Chez nous par exemple
        //queryProjetsDeReferencePLot12.setParameter("reference", "Immeuble10A8L7E8A");
        queryProjetsDeReferencePLot12.setParameter("reference", "PLot12");
        List<String> projetsDeReferencePLot12 = queryProjetsDeReferencePLot12.getResultList();
        displayOneAttributeResults(projetsDeReferencePLot12, "Nom projet :");

        twoNewLineInConsole();

        // 4 - Combien de projets portant sur un etablissement scolaire ont ete realise ?
        /* RAPPEL : EtablissementScolaire extends de BatimentPublic qui lui meme extends de Projet,
         la denomination EtablisementScolaire correspond _meme si elle trompeuse_ a un Projet
          */
        System.out.println("Combien de projets portant sur un etablissement scolaire ont ete realise ?\n");
        Query queryNombreProjetsEtablissementScolaire = em.createNamedQuery("EtablissementScolaire.nombreDeProjets", Object.class);
        Object nombreProjetsEtablissementScolaire = queryNombreProjetsEtablissementScolaire.getResultList();
        System.out.println("Nombre de projets :"+nombreProjetsEtablissementScolaire.toString());

        twoNewLineInConsole();

        // 5 - Quelles sont les entreprises de plomberie ?
        /*
            Il n'est pas possible de passer la valeur de l'enumeration directement on a recours donc a une requete parametree
            ce qui apporte au final plus de flexibilite / et moins de redondance si jamais on decidait de faire des requetes sur plusieurs types d'entreprises
        */
        System.out.println("Quelles sont les entreprises de plomberie ?\n");
        Query queryEntreprisesPlomberie = em.createNamedQuery("Entreprise.entreprisesCorpsMetier", String.class);
        queryEntreprisesPlomberie.setParameter("corpsMetier", ECorpsMetier.Plombier);
        List<String> entreprisesPlomberie = queryEntreprisesPlomberie.getResultList();
        displayOneAttributeResults(entreprisesPlomberie, "Nom entreprise :");

        twoNewLineInConsole();

        // 6 - Quels sont les noms des contacts de lʼentreprise « General Batiment» ?
        // A valider je ne sais pas ce que le professeur veut vraiement
        // Je ne comprends pa l'interet du cross join (ntlr a la place d'un inner) genere par hibernate mais les resultats sont corrects
        System.out.println("Quels sont les noms des contacts de lʼentreprise « General Batiment» ?\n");
        Query queryNomsContactEntrepriseGeneralBatiment = em.createNamedQuery("Acteur.contactEntreprise", String.class);
        // Chez nous
        //queryNomsContactEntrepriseGeneralBatiment.setParameter("nomEntreprise", "Berbe et fils SARL");
        queryNomsContactEntrepriseGeneralBatiment.setParameter("nomEntreprise", "General Batiment");
        List<String> nomsContactEntrepriseGeneralBatiment = queryNomsContactEntrepriseGeneralBatiment.getResultList();
        displayOneAttributeResults(nomsContactEntrepriseGeneralBatiment, "Nom contact :");

        twoNewLineInConsole();

        // 7 - A quels projets termines lʼentreprise « General Batiment» a participe ?
        // 8 - Quels sont les lots des projets en cours auxquels participe lʼentreprise « General Batiment» ?
        // 9 - Quels sont les acteurs (et leur entreprise) participant au projet de reference « PLot12 » ?
        // 10 - Combien de lots a le projet de reference " PLot12 " ?
        // 11 - Quel est le cout total estime du projet de reference « PLot12 »?
        // 12 - Quelles sont les entreprises (et leur adresse) qui ont realisees les menuiseries dans les projets de Musee ?
        // 13 - Quelles sont les durees estimees des differents projets en cours ?
        // 14 - Quels sont les avancements des lots (et leur type) du projet de reference « PLot12 » ?

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
