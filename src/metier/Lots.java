package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int numero;
	private int dateDebut;
	private int dureeEstimee;
	private int coutEstime;
	private int avancement;
	private int coutRéel;
	private int dateFinRéel;

	public Lots() {}

	public Lots(int numero, int dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutRéel, int dateFinRéel) {
		this.numero = numero;
		this.dateDebut = dateDebut;
		this.dureeEstimee = dureeEstimee;
		this.coutEstime = coutEstime;
		this.avancement = avancement;
		this.coutRéel = coutRéel;
		this.dateFinRéel = dateFinRéel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(int dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDureeEstimee() {
		return dureeEstimee;
	}

	public void setDureeEstimee(int dureeEstimee) {
		this.dureeEstimee = dureeEstimee;
	}

	public int getCoutEstime() {
		return coutEstime;
	}

	public void setCoutEstime(int coutEstime) {
		this.coutEstime = coutEstime;
	}

	public int getAvancement() {
		return avancement;
	}

	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public int getCoutRéel() {
		return coutRéel;
	}

	public void setCoutRéel(int coutRéel) {
		this.coutRéel = coutRéel;
	}

	public int getDateFinRéel() {
		return dateFinRéel;
	}

	public void setDateFinRéel(int dateFinRéel) {
		this.dateFinRéel = dateFinRéel;
	}
}