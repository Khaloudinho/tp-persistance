package metier;

import util.EStatut;
import util.ETitre;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NamedQueries({
		@NamedQuery(
				name="Acteur.contactsEntrepriseGeneralBatiment",
				query="SELECT a.nom FROM Acteur a WHERE a.entreprise.nom = :entreprise"
		),
})
public class Acteur implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private String nom;
	private ETitre titre;

	@Enumerated(EnumType.STRING)
	private EStatut statut;

	@ManyToOne
	private Entreprise entreprise;

	@ManyToMany
	private Set<Projet> projet;

	public Acteur() {

	}

	public Acteur(String nom, ETitre titre, EStatut statut) {
		this.nom = nom;
		this.titre = titre;
		this.statut = statut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ETitre getTitre() {
		return titre;
	}

	public void setTitre(ETitre titre) {
		this.titre = titre;
	}

	public EStatut getStatut() {
		return statut;
	}

	public void setStatut(EStatut statut) {
		this.statut = statut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Projet> getProjet() {
		return projet;
	}

	public void setProjet(Set<Projet> projet) {
		this.projet = projet;
	}
}