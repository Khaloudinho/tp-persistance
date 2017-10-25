package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Hopital extends BatimentPublic implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int ID;

	private int nbLits;
	private int nbServices;

	public Hopital() {
	}

	public Hopital(int nbLits, int nbServices) {
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

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void setID(int ID) {
		this.ID = ID;
	}
}