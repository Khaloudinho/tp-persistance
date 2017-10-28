package metier;

import util.ECharpente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Charpente extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private ECharpente typeCharpente;

	public Charpente() {
	}

	public Charpente(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutReel, Date dateFinReel, ECharpente typeCharpente) {
		super(numero, dateDebut, dureeEstimee, coutEstime, avancement, coutReel, dateFinReel);
		this.typeCharpente = typeCharpente;
	}

	public ECharpente getTypeCharpente() {
		return typeCharpente;
	}

	public void setTypeCharpente(ECharpente typeCharpente) {
		this.typeCharpente = typeCharpente;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}