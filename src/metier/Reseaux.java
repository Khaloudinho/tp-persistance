package metier;

import java.io.Serializable;

public class Reseaux extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int longueur;

	public Reseaux() {
	}

	public Reseaux(int longueur) {
		this.longueur = longueur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
}