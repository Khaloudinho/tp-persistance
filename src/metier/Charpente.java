package metier;

import util.ECharpente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	public Charpente(ECharpente typeCharpente) {
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