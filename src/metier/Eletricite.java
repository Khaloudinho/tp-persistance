package metier;

public class Eletricite extends Lots implements java.io.Serializable {

	private int nbTableau;
	private int longueurTable;

	public Eletricite() {
	}

	public Eletricite(int nbTableau, int longueurTable) {
		this.nbTableau = nbTableau;
		this.longueurTable = longueurTable;
	}

	public int getNbTableau() {
		return nbTableau;
	}

	public void setNbTableau(int nbTableau) {
		this.nbTableau = nbTableau;
	}

	public int getLongueurTable() {
		return longueurTable;
	}

	public void setLongueurTable(int longueurTable) {
		this.longueurTable = longueurTable;
	}
}