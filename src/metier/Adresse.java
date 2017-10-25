package metier;

public class Adresse implements java.io.Serializable {

	private int numero;
	private int rue;
	private int CP;
	private int ville;

	public Adresse() {
	}

	public Adresse(int numero, int rue, int CP, int ville) {
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

	public int getRue() {
		return rue;
	}

	public void setRue(int rue) {
		this.rue = rue;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int CP) {
		this.CP = CP;
	}

	public int getVille() {
		return ville;
	}

	public void setVille(int ville) {
		this.ville = ville;
	}
}