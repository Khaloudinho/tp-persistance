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
public class Menuiseries extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int nbFenetres;
	private int nbPortes;
	private int nbFenetreToit;

	public Menuiseries() {}

	public Menuiseries(int numero, Date dateDebut, int dureeEstimee, int coutEstime, EAvancement avancement, int coutReel, Date dateFinReel, int nbFenetres, int nbPortes, int nbFenetreToit) {
		super(numero, dateDebut, dureeEstimee, coutEstime, avancement, coutReel, dateFinReel);
		this.nbFenetres = nbFenetres;
		this.nbPortes = nbPortes;
		this.nbFenetreToit = nbFenetreToit;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getNbFenetres() {
		return nbFenetres;
	}

	public void setNbFenetres(int nbFenetres) {
		this.nbFenetres = nbFenetres;
	}

	public int getNbPortes() {
		return nbPortes;
	}

	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}

	public int getNbFenetreToit() {
		return nbFenetreToit;
	}

	public void setNbFenetreToit(int nbFenetreToit) {
		this.nbFenetreToit = nbFenetreToit;
	}
}