package metier;

import util.EAvancement;
import util.ECharpente;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Charpente extends Lots implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	@Enumerated(EnumType.STRING)
	private ECharpente typeCharpente;

	public Charpente() {
	}

	public Charpente(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int coutReel, Date dateFinReel, ECharpente typeCharpente) {
		super(numero, dateDebut, dureeEstimee, coutEstime, coutReel, dateFinReel);
		this.typeCharpente = typeCharpente;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public ECharpente getTypeCharpente() {
		return typeCharpente;
	}

	public void setTypeCharpente(ECharpente typeCharpente) {
		this.typeCharpente = typeCharpente;
	}
}