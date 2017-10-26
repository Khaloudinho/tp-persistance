package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Immeuble extends Projet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int nbNiveaux;

	@OneToMany
	private Set<Appartement> appartements;

	public Immeuble() {
	}

	public Immeuble(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	public int getNbNiveaux() {
		return nbNiveaux;
	}

	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}