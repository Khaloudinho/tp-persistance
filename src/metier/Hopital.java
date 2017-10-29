package metier;

import util.EAvancement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Hopital extends BatimentPublic implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int nbLits;
	private int nbServices;

	public Hopital() {
	}

	public Hopital(String refProjet, String nom, int surfaceTotale, EAvancement avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, String ministere, int nbLits, int nbServices) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle, ministere);
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

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}