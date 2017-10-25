package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Terrassement extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int volumeTerre;

	public Terrassement() {}

	public Terrassement(int volumeTerre) {
		this.volumeTerre = volumeTerre;
	}

	public int getVolumeTerre() {
		return volumeTerre;
	}

	public void setVolumeTerre(int volumeTerre) {
		this.volumeTerre = volumeTerre;
	}
}