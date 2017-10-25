package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Maison extends Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int nbPièces;
	private int nbNiveaux;

	@ManyToOne
	private Lotissement lotissement;

	public Maison() {}

	public Maison(int refProjet, int nom, int surfaceTotale, int avancement, int dateFinEstimee, int coutTotalEstime, boolean termine, int dateFinReelle, int nbPièces, int nbNiveaux) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle);
		this.nbPièces = nbPièces;
		this.nbNiveaux = nbNiveaux;
	}

	public int getNbPièces() {
		return nbPièces;
	}

	public void setNbPièces(int nbPièces) {
		this.nbPièces = nbPièces;
	}

	public int getNbNiveaux() {
		return nbNiveaux;
	}

	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lotissement getLotissement() {
		return lotissement;
	}

	public void setLotissement(Lotissement lotissement) {
		this.lotissement = lotissement;
	}
}