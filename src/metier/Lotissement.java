package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lotissement extends Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int nbMaisons;

	public Lotissement() {}

	public Lotissement(int refProjet, int nom, int surfaceTotale, int avancement, int dateFinEstimee, int coutTotalEstime, boolean termine, int dateFinReelle, int nbMaisons) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle);
		this.nbMaisons = nbMaisons;
	}

	public int getNbMaisons() {
		return nbMaisons;
	}

	public void setNbMaisons(int nbMaisons) {
		this.nbMaisons = nbMaisons;
	}
}