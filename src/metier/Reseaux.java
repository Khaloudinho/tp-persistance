import java.io.Serializable;

public class Reseaux extends Lots implements Serializable {

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