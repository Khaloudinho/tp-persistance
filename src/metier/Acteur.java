
public class Acteur implements java.io.Serializable {

	private int nom;
	private ETitre titre;
	private EStatut statut;

	public Acteur() {

	}

	public Acteur(int nom, ETitre titre, EStatut statut) {
		this.nom = nom;
		this.titre = titre;
		this.statut = statut;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public ETitre getTitre() {
		return titre;
	}

	public void setTitre(ETitre titre) {
		this.titre = titre;
	}

	public EStatut getStatut() {
		return statut;
	}

	public void setStatut(EStatut statut) {
		this.statut = statut;
	}
}