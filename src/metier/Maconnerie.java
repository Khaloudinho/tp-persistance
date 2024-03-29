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
public class Maconnerie extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int surfaceMur;
	private int nbPoteaux;

	public Maconnerie() {}

	public Maconnerie(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel, int surfaceMur, int nbPoteaux) {
		super(numero, dateDebut, dureeEstimee, coutEstime, coutReel, dateFinReel);
		this.surfaceMur = surfaceMur;
		this.nbPoteaux = nbPoteaux;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getSurfaceMur() {
		return surfaceMur;
	}

	public void setSurfaceMur(int surfaceMur) {
		this.surfaceMur = surfaceMur;
	}

	public int getNbPoteaux() {
		return nbPoteaux;
	}

	public void setNbPoteaux(int nbPoteaux) {
		this.nbPoteaux = nbPoteaux;
	}
}