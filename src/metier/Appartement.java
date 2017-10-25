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
	private int type;
	private ETypeAppart surface;

	public Appartement() {
	}

	public Appartement(int niveau, int type, ETypeAppart surface) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ETypeAppart getSurface() {
		return surface;
	}

	public void setSurface(ETypeAppart surface) {
		this.surface = surface;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}