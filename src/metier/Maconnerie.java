package metier;

import java.io.Serializable;

public class Maconnerie extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int surfaceMur;
	private int nbPoteaux;

	public Maconnerie() {}

	public Maconnerie(int surfaceMur, int nbPoteaux) {
		this.surfaceMur = surfaceMur;
		this.nbPoteaux = nbPoteaux;
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