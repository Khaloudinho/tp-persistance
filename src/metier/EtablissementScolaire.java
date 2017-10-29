package metier;

import util.EAvancement;
import util.EEtaScolaire;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NamedQueries({
		@NamedQuery(
				name="EtablissementScolaire.nombreDeProjets",
				query="SELECT count(e) FROM EtablissementScolaire e"),
})
public class EtablissementScolaire extends BatimentPublic implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int nbEleves;

	@Enumerated(EnumType.STRING)
	private EEtaScolaire categorie;

	public EtablissementScolaire() {
	}

	public EtablissementScolaire(String refProjet, String nom, int surfaceTotale, EAvancement avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, String ministere, int nbEleves, EEtaScolaire categorie) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle, ministere);
		this.nbEleves = nbEleves;
		this.categorie = categorie;
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