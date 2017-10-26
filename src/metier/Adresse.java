package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Adresse implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private int numero;
	private String rue;
	private int CP;
	private String ville;

	public Adresse() {
	}

	public Adresse(int numero, String rue, int CP, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.CP = CP;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int CP) {
		this.CP = CP;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}