package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Dallage extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int surfaceTotale;

	public Dallage() {
	}

	public Dallage(int surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public int getSurfaceTotale() {
		return surfaceTotale;
	}

	public void setSurfaceTotale(int surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}