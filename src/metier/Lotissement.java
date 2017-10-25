package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lotissement extends Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int nbMaisons;

	public Lotissement() {}

	public Lotissement(String refProjet, String nom, int surfaceTotale, int avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, int nbMaisons) {
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
}