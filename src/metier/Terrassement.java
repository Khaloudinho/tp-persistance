package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Terrassement extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private int volumeTerre;

	public Terrassement() {}

	public Terrassement(int numero, Date dateDebut, int dureeEstimee, int coutEstime, int avancement, int coutReel, Date dateFinReel, int volumeTerre) {
		super(numero, dateDebut, dureeEstimee, coutEstime, avancement, coutReel, dateFinReel);
		this.volumeTerre = volumeTerre;
	}

	public int getVolumeTerre() {
		return volumeTerre;
	}

	public void setVolumeTerre(int volumeTerre) {
		this.volumeTerre = volumeTerre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}