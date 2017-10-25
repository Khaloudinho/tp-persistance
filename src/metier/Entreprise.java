public class Entreprise implements java.io.Serializable {

	private int nom;
	private ECorpsMetier corpsMetier;
	private int numTel;

	public Entreprise() {
	}

	public Entreprise(int nom, ECorpsMetier corpsMetier, int numTel) {
		this.nom = nom;
		this.corpsMetier = corpsMetier;
		this.numTel = numTel;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public ECorpsMetier getCorpsMetier() {
		return corpsMetier;
	}

	public void setCorpsMetier(ECorpsMetier corpsMetier) {
		this.corpsMetier = corpsMetier;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
}