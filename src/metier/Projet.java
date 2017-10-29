package metier;

import util.EAvancement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
		@NamedQuery(
				name="Projet.projetsEnCours",
				query="SELECT p.nom FROM Projet p WHERE p.avancement = :avancement"
		),
		@NamedQuery(
				name="Projet.avancementProjetPLot12",
				query="SELECT p.avancement FROM Projet p WHERE p.refProjet = :reference"
		),
		@NamedQuery(
				name="Projet.projetsTerminesAvecGeneralBatiment",
				query="SELECT p.nom, COUNT(p.nom) " +
						"FROM Projet p " +
						"JOIN Lots l ON l.projet = p " +
						"WHERE p.avancement = :avancement " +
						"GROUP BY p.nom"
		),
		/*
		query="SELECT p.nom " +
						"FROM Projet p" +
						"JOIN Lots l, IN(l.entreprisesRealisatrices) e " +
						"WHERE p.avancement = :avancement AND e = (SELECT nom FROM Entreprise WHERE nom = :entreprise)"
		@NamedQuery(
				name="Projet.lotsDesProjetsEnCoursDeGeneralBatiment",
				query="SELECT p.nom FROM Projet p JOIN Lots lots ON lots.projet = p WHERE p.avancement=\'enCours\' " +
						"AND (lots.entrepriseResponsable.nom=:nomEntreprise) " +
						"SELECT p.nom FROM Projet p JOIN Lots lots " +
						"ON lots.projet=p WHERE p.avancement=\'Terminé\' AND (lots.entrepriseResponsable.nom=:nomEntreprise)"
		),*/
})
public abstract class Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private String refProjet;
	private String nom;
	private int surfaceTotale;

	@Enumerated(EnumType.STRING)
	private EAvancement avancement;

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

	public Projet(String refProjet, String nom, int surfaceTotale, EAvancement avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle) {
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

	public EAvancement getAvancement() {
		return avancement;
	}

	public void setAvancement(EAvancement avancement) {
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