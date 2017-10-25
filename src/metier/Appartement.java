package metier;

import util.ETypeAppart;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Appartement implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int niveau;
	private int type;
	private ETypeAppart surface;

	@ManyToOne
	private Immeuble immeuble;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}
}