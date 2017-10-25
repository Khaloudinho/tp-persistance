import java.io.Serializable;

public class Musee extends BatimentPublic implements Serializable {

	private int nbSalles;

	public Musee() {}

	public Musee(int nbSalles) {
		this.nbSalles = nbSalles;
	}

	public int getNbSalles() {
		return nbSalles;
	}

	public void setNbSalles(int nbSalles) {
		this.nbSalles = nbSalles;
	}
}