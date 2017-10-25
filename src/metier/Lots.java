package metier;

import javax.persistence.*;
import java.io.Serializable;
<<<<<<< HEAD
import java.util.Set;
=======
import java.sql.Date;
>>>>>>> f5c50704afe123a2eded894b221758dd4ceaaf2c

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int numero;
	private Date dateDebut;
	private int dureeEstimee;
	private int coutEstime;
	private int avancement;
<<<<<<< HEAD
	private int coutReel;
	private int dateFinReel;

	@ManyToOne
	private Entreprise entrepriseResponsable;

	@ManyToMany
	private Set<Entreprise> entreprisesRealisatrices;

	@ManyToOne
	private Projet projet;

	public Lots() {}

	public Lots(int numero, int dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutReel, int dateFinReel) {
=======
	private int coutRéel;
	private Date dateFinRéel;

	public Lots() {}

	public Lots(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutRéel, Date dateFinRéel) {
>>>>>>> f5c50704afe123a2eded894b221758dd4ceaaf2c
		this.numero = numero;
		this.dateDebut = dateDebut;
		this.dureeEstimee = dureeEstimee;
		this.coutEstime = coutEstime;
		this.avancement = avancement;
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

	public int getAvancement() {
		return avancement;
	}

	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public int getCoutReel() {
		return coutReel;
	}

	public void setCoutReel(int coutReel) {
		this.coutReel = coutReel;
	}

<<<<<<< HEAD
	public int getDateFinReel() {
		return dateFinReel;
	}

	public void setDateFinReel(int dateFinReel) {
		this.dateFinReel = dateFinReel;
=======
	public Date getDateFinRéel() {
		return dateFinRéel;
	}

	public void setDateFinRéel(Date dateFinRéel) {
		this.dateFinRéel = dateFinRéel;
>>>>>>> f5c50704afe123a2eded894b221758dd4ceaaf2c
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