package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int refProjet;
	private int nom;
	private int surfaceTotale;
	private int avancement;
	private int dateFinEstimee;
	private int coutTotalEstime;
	private boolean termine;
	private int dateFinReelle;

	public Projet() {
	}

	public Projet(int refProjet, int nom, int surfaceTotale, int avancement, int dateFinEstimee, int coutTotalEstime, boolean termine, int dateFinReelle) {
		this.refProjet = refProjet;
		this.nom = nom;
		this.surfaceTotale = surfaceTotale;
		this.avancement = avancement;
		this.dateFinEstimee = dateFinEstimee;
		this.coutTotalEstime = coutTotalEstime;
		this.termine = termine;
		this.dateFinReelle = dateFinReelle;
	}

	public int getRefProjet() {
		return refProjet;
	}

	public void setRefProjet(int refProjet) {
		this.refProjet = refProjet;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public int getSurfaceTotale() {
		return surfaceTotale;
	}

	public void setSurfaceTotale(int surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public int getAvancement() {
		return avancement;
	}

	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public int getDateFinEstimee() {
		return dateFinEstimee;
	}

	public void setDateFinEstimee(int dateFinEstimee) {
		this.dateFinEstimee = dateFinEstimee;
	}

	public int getCoutTotalEstime() {
		return coutTotalEstime;
	}

	public void setCoutTotalEstime(int coutTotalEstime) {
		this.coutTotalEstime = coutTotalEstime;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public int getDateFinReelle() {
		return dateFinReelle;
	}

	public void setDateFinReelle(int dateFinReelle) {
		this.dateFinReelle = dateFinReelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}