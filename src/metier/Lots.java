package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int numero;
	private Date dateDebut;
	private int dureeEstimee;
	private int coutEstime;
	private int avancement;
	private int coutRéel;
	private Date dateFinRéel;

	public Lots() {}

	public Lots(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutRéel, Date dateFinRéel) {
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
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

	public Date getDateFinRéel() {
		return dateFinRéel;
	}

	public void setDateFinRéel(Date dateFinRéel) {
		this.dateFinRéel = dateFinRéel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}