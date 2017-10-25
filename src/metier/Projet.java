package metier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String refProjet;
	private String nom;
	private int surfaceTotale;
	private int avancement;
	private Date dateFinEstimee;
	private int coutTotalEstime;
	private boolean termine;
	private Date dateFinReelle;

	@OneToOne
	private Adresse adresse;

	@ManyToMany
	private Set<Acteur> acteurs;

	@OneToMany
	private Set<Lots> lots;

	public Projet() {
	}

	public Projet(String refProjet, String nom, int surfaceTotale, int avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle) {
		this.refProjet = refProjet;
		this.nom = nom;
		this.surfaceTotale = surfaceTotale;
		this.avancement = avancement;
		this.dateFinEstimee = dateFinEstimee;
		this.coutTotalEstime = coutTotalEstime;
		this.termine = termine;
		this.dateFinReelle = dateFinReelle;
	}

	public String getRefProjet() {
		return refProjet;
	}

	public void setRefProjet(String refProjet) {
		this.refProjet = refProjet;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
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

	public Date getDateFinEstimee() {
		return dateFinEstimee;
	}

	public void setDateFinEstimee(Date dateFinEstimee) {
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

	public Date getDateFinReelle() {
		return dateFinReelle;
	}

	public void setDateFinReelle(Date dateFinReelle) {
		this.dateFinReelle = dateFinReelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public Set<Lots> getLots() {
		return lots;
	}

	public void setLots(Set<Lots> lots) {
		this.lots = lots;
	}
}