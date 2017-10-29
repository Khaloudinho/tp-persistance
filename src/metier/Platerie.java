package metier;

import util.EAvancement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Platerie extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int surfacePlafond;
	private int surfaceMur;

	public Platerie() {}

	public Platerie(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel, int surfacePlafond, int surfaceMur) {
		super(numero, dateDebut, dureeEstimee, coutEstime, coutReel, dateFinReel);
		this.surfacePlafond = surfacePlafond;
		this.surfaceMur = surfaceMur;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getSurfacePlafond() {
		return surfacePlafond;
	}

	public void setSurfacePlafond(int surfacePlafond) {
		this.surfacePlafond = surfacePlafond;
	}

	public int getSurfaceMur() {
		return surfaceMur;
	}

	public void setSurfaceMur(int surfaceMur) {
		this.surfaceMur = surfaceMur;
	}
}