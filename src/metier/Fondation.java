package metier;

public class Fondation extends Lots implements java.io.Serializable {

	private int profondeur;

	public Fondation() {
	}

	public Fondation(int profondeur) {
		this.profondeur = profondeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
}