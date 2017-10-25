public class Immeuble extends Projet {

	private int nbNiveaux;

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