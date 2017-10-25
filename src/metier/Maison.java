import java.io.Serializable;

public class Maison extends Projet implements Serializable {

	private int nbPièces;
	private int nbNiveaux;

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
}