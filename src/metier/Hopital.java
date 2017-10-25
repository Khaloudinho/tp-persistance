package metier;

public class Hopital extends BatimentPublic implements java.io.Serializable {

	private int nbLits;
	private int nbServices;

	public Hopital() {
	}

	public Hopital(int nbLits, int nbServices) {
		this.nbLits = nbLits;
		this.nbServices = nbServices;
	}

	public int getNbLits() {
		return nbLits;
	}

	public void setNbLits(int nbLits) {
		this.nbLits = nbLits;
	}

	public int getNbServices() {
		return nbServices;
	}

	public void setNbServices(int nbServices) {
		this.nbServices = nbServices;
	}
}