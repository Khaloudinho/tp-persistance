package metier;

import util.EEtaScolaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class EtablissementScolaire extends BatimentPublic implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int nbEleves;
	private EEtaScolaire categorie;

	public EtablissementScolaire(int nbEleves, EEtaScolaire categorie) {
		this.nbEleves = nbEleves;
		this.categorie = categorie;
	}

	public EtablissementScolaire(String refProjet, String nom, int surfaceTotale, String avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, String ministere, int nbEleves, EEtaScolaire categorie) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle, ministere);
		this.nbEleves = nbEleves;
		this.categorie = categorie;
	}

	public EtablissementScolaire() {
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getNbEleves() {
		return nbEleves;
	}

	public void setNbEleves(int nbEleves) {
		this.nbEleves = nbEleves;
	}

	public EEtaScolaire getCategorie() {
		return categorie;
	}

	public void setCategorie(EEtaScolaire categorie) {
		this.categorie = categorie;
	}
}