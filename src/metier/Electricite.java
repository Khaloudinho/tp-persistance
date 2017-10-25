package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Electricite extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int nbTableau;
	private float longueurTable;

	public Electricite() {
	}

	public Electricite(int nbTableau, float longueurTable) {
		this.nbTableau = nbTableau;
		this.longueurTable = longueurTable;
	}

	public int getNbTableau() {
		return nbTableau;
	}

	public void setNbTableau(int nbTableau) {
		this.nbTableau = nbTableau;
	}

	public float getLongueurTable() {
		return longueurTable;
	}

	public void setLongueurTable(float longueurTable) {
		this.longueurTable = longueurTable;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}