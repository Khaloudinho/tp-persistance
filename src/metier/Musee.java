package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Musee extends BatimentPublic implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int nbSalles;

	public Musee() {}

	public Musee(String refProjet, String nom, int surfaceTotale, String avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, String ministere, int nbSalles) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle, ministere);
		this.nbSalles = nbSalles;
	}

	public int getNbSalles() {
		return nbSalles;
	}

	public void setNbSalles(int nbSalles) {
		this.nbSalles = nbSalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}