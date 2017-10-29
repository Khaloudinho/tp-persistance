package metier;

import util.EAvancement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Electricite extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int nbTableau;
	private float longueurTable;

	public Electricite() {
	}

	public Electricite(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel, int nbTableau, float longueurTable) {
		super(numero, dateDebut, dureeEstimee, coutEstime, coutReel, dateFinReel);
		this.nbTableau = nbTableau;
		this.longueurTable = longueurTable;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
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
}