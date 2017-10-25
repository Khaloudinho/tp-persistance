package metier;

import java.io.Serializable;

public class Musee extends BatimentPublic implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
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