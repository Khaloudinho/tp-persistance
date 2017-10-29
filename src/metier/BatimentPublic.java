package metier;

import util.EAvancement;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BatimentPublic extends Projet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private String ministere;

	public BatimentPublic() {
	}

	public BatimentPublic(String refProjet, String nom, int surfaceTotale, EAvancement avancement, Date dateFinEstimee, int coutTotalEstime, boolean termine, Date dateFinReelle, String ministere) {
		super(refProjet, nom, surfaceTotale, avancement, dateFinEstimee, coutTotalEstime, termine, dateFinReelle);
		this.ministere = ministere;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getMinistere() {
		return ministere;
	}

	public void setMinistere(String ministere) {
		this.ministere = ministere;
	}
}