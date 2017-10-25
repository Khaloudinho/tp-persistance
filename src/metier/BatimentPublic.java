package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BatimentPublic extends Projet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private String ministere;

	public BatimentPublic() {
	}

	public BatimentPublic(int ministere) {
		ministere = ministere;
	}

	public String getMinistère() {
		return ministere;
	}

	public void setMinistère(String ministère) {
		ministere = ministère;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}