package metier;

import java.io.Serializable;

public class Menuiseries extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int nbFenetres;
	private int nbPortes;
	private int nbFenetreToit;

	public Menuiseries() {}

	public Menuiseries(int nbFenetres, int nbPortes, int nbFenetreToit) {
		this.nbFenetres = nbFenetres;
		this.nbPortes = nbPortes;
		this.nbFenetreToit = nbFenetreToit;
	}

	public int getNbFenetres() {
		return nbFenetres;
	}

	public void setNbFenetres(int nbFenetres) {
		this.nbFenetres = nbFenetres;
	}

	public int getNbPortes() {
		return nbPortes;
	}

	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}

	public int getNbFenetreToit() {
		return nbFenetreToit;
	}

	public void setNbFenetreToit(int nbFenetreToit) {
		this.nbFenetreToit = nbFenetreToit;
	}
}