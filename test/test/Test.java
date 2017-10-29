package test;

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

        Seeder.initialize(em);

        // Requetes
        // 1 - Quelles sont les entreprises avec lesquelles le cabinet travaille ?
        Query queryEntreprisesTravaillantAvecCabinet = em.createNamedQuery("Entreprise.entreprisesTravaillantAvecCabinet", String.class);
        List<String> entreprisesTravaillantAvecCabinet = queryEntreprisesTravaillantAvecCabinet.getResultList();
        displayOneAttributeResults(entreprisesTravaillantAvecCabinet, "Nom entreprise :");

        twoNewLineInConsole();

        // 2 - Quels sont les projets en cours ?
        Query queryProjetEnCours = em.createNamedQuery("Projet.projetsEnCours", String.class);
        List<String> projetsEnCours = queryProjetEnCours.getResultList();
        displayOneAttributeResults(projetsEnCours, "Nom projet :");

        // 3 - Quel est lʼavancement du projet de reference « PLot12 » ?
        // 4 - Combien de projets portant sur un etablissement scolaire ont ete realise ?
        // 5 - Quelles sont les entreprises de plomberie ?
        // 6 - Quels sont les noms des contacts de lʼentreprise « General Batiment» ?
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
