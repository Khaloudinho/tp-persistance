package metier;

import util.EAvancement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lotissement extends Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int nbMaisons;

	@OneToMany
	private Set<Maison> maisons;

	public Lotissement() {}

	public Lotissement(String refProjet, String nom, int surfaceTotale, EAvancement avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, int nbMaisons) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle);
		this.nbMaisons = nbMaisons;
	}

	public int getNbMaisons() {
		return nbMaisons;
	}

	public void setNbMaisons(int nbMaisons) {
		this.nbMaisons = nbMaisons;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Maison> getMaisons() {
		return maisons;
	}

	public void setMaisons(Set<Maison> maisons) {
		this.maisons = maisons;
	}
}