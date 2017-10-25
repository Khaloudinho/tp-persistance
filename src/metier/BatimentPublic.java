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

	private int Ministere;

	public BatimentPublic() {
	}

	public BatimentPublic(int ministère) {
		Ministère = ministère;
	}

	public int getMinistère() {
		return Ministère;
	}

	public void setMinistère(int ministère) {
		Ministère = ministère;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}