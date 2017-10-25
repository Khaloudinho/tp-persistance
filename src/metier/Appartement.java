package metier;

import util.ETypeAppart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Appartement implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int niveau;
	private ETypeAppart type;
	private int surface;

	public Appartement() {
	}

	public Appartement(int niveau, ETypeAppart type, int surface) {
		this.niveau = niveau;
		this.type = type;
		this.surface = surface;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public ETypeAppart getType() {
		return type;
	}

	public void setType(ETypeAppart type) {
		this.type = type;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}