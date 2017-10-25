package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Acteur implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int ID;

	private int nom;
	private ETitre titre;
	private EStatut statut;

	public Acteur() {

	}

	public Acteur(int nom, ETitre titre, EStatut statut) {
		this.nom = nom;
		this.titre = titre;
		this.statut = statut;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}