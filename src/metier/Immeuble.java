public class Immeuble extends Projet implements java.io.Serializable {

	private int nbNiveaux;

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
}