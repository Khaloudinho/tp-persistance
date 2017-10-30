package metier;

import util.EAvancement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
		@NamedQuery(
				name = "Lots.lotsDesProjetsEnCoursDeGeneralBatiment",
				query = "SELECT DISTINCT l.id " +
						"FROM Lots l, IN(l.entreprisesRealisatrices) e " +
						"JOIN l.projet p " +
						"WHERE e = (SELECT id FROM Entreprise WHERE nom = :entreprise) " +
						"AND p.avancement = :avancement "
		),
		@NamedQuery(
				name = "Lots.nombreLotsProjetsPLot12",
				query = "SELECT COUNT(l.id) " +
						"FROM Lots l " +
						"JOIN l.projet p " +
						"WHERE p.refProjet = :refProjet "
		),
		@NamedQuery(
				name = "Lots.projetsTerminesAvecGeneralBatiment",
				query = "SELECT DISTINCT p.nom " +
						"FROM Lots l " +
						"JOIN l.entreprisesRealisatrices e " +
						"JOIN l.projet p " +
						"WHERE e.nom = :entreprise " +
						"AND p.avancement = :avancement"
		),
		@NamedQuery(
				name = "Lots.entreprisesMenuiseriesProjetsMusees",
				query = "SELECT e.nom, a.numero, a.rue, a.CP, a.ville " +
						"FROM Lots l " +
						"JOIN l.projet p " +
						"JOIN l.entreprisesRealisatrices e " +
						"JOIN e.adresse a " +
						"WHERE type(p) = Musee " +
						"AND type(l) = Menuiseries "
		),
		@NamedQuery(
				name = "Lots.avancementEtTypeLotsProjetPLot12",
				query = "SELECT l.id, type(l.id), l.avancement " +
						"FROM Lots l " +
						"JOIN l.projet p " +
						"WHERE p.refProjet = :refProjet "
		),
		@NamedQuery(
				name = "Lots.acteursEtEntrepriseDuProjetPLot12",
				query = "SELECT DISTINCT a.nom, e.nom " +
						"FROM Lots l " +
						"JOIN l.projet p " +
						"JOIN l.entreprisesRealisatrices e " +
						"JOIN e.acteurs a " +
						"WHERE p.refProjet = :refProjet "
		)
})

public abstract class Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int numero;
	private Date dateDebut;
	private int dureeEstimee;
	private int coutEstime;

	@Enumerated(EnumType.STRING)
	private EAvancement avancement;

	private int coutReel;

	@Column(nullable = true)
	private Date dateFinReel;

	@ManyToOne
	private Entreprise entrepriseResponsable;

	@ManyToMany
	private Set<Entreprise> entreprisesRealisatrices;

	@ManyToOne
	private Projet projet;

	public Lots() {}

	public Lots(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel) {
		this.numero = numero;
		this.dateDebut = dateDebut;
		this.dureeEstimee = dureeEstimee;
		this.coutEstime = coutEstime;
		this.avancement = EAvancement.enCours;
		this.coutReel = coutReel;
		this.dateFinReel = dateFinReel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDureeEstimee() {
		return dureeEstimee;
	}

	public void setDureeEstimee(int dureeEstimee) {
		this.dureeEstimee = dureeEstimee;
	}

	public int getCoutEstime() {
		return coutEstime;
	}

	public void setCoutEstime(int coutEstime) {
		this.coutEstime = coutEstime;
	}

	public EAvancement getAvancement() {
		return avancement;
	}

	public void setAvancement(EAvancement avancement) {
		this.avancement = avancement;
	}

	public int getCoutReel() {
		return coutReel;
	}

	public void setCoutReel(int coutReel) {
		this.coutReel = coutReel;
	}

	public Date getDateFinReel() {
		return dateFinReel;
	}

	public void setDateFinReel(Date dateFinReel) {
		this.dateFinReel = dateFinReel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Entreprise getEntrepriseResponsable() {
		return entrepriseResponsable;
	}

	public void setEntrepriseResponsable(Entreprise entrepriseResponsable) {
		this.entrepriseResponsable = entrepriseResponsable;
	}

	public Set<Entreprise> getEntreprisesRealisatrices() {
		return entreprisesRealisatrices;
	}

	public void setEntreprisesRealisatrices(Set<Entreprise> entreprisesRealisatrices) {
		this.entreprisesRealisatrices = entreprisesRealisatrices;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
}