package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Eletricite extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int ID;

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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}