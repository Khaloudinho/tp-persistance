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

	public Immeuble(int nbNiveaux, Set<Appartement> appartements) {
		this.nbNiveaux = nbNiveaux;
		this.appartements=appartements;
	}

	public int getNbNiveaux() {
		return nbNiveaux;
	}

	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Set<Appartement> getAppartements() {
		return appartements;
	}

	public void setAppartements(Set<Appartement> appartements) {
		this.appartements = appartements;
	}
}