package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Maison extends Projet implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int nbPieces;
	private int nbNiveaux;

	@ManyToOne
	private Lotissement lotissement;

	public Maison() {}

	public Maison(String refProjet, String nom, int surfaceTotale, String avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, int nbPieces, int nbNiveaux) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle);
		this.nbPieces = nbPieces;
		this.nbNiveaux = nbNiveaux;
	}

	public int getNbPièces() {
		return nbPieces;
	}

	public void setNbPièces(int nbPièces) {
		this.nbPieces = nbPièces;
	}

	public int getNbNiveaux() {
		return nbNiveaux;
	}

	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lotissement getLotissement() {
		return lotissement;
	}

	public void setLotissement(Lotissement lotissement) {
		this.lotissement = lotissement;
	}
}