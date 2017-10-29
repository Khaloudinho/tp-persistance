package metier;

import util.EAvancement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Fondation extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int profondeur;

	public Fondation() {
	}

	public Fondation(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel, int profondeur) {
		super(numero, dateDebut, dureeEstimee, coutEstime, coutReel, dateFinReel);
		this.profondeur = profondeur;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
}