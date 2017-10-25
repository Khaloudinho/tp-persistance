package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Platerie extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int surfacePlafond;
	private int surfaceMur;

	public Platerie() {}

	public Platerie(int surfacePlafond, int surfaceMur) {
		this.surfacePlafond = surfacePlafond;
		this.surfaceMur = surfaceMur;
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