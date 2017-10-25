public class Hopital extends BatimentPublic {

	private int nbLits;
	private int nbServices;

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