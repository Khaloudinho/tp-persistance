package metier;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BatimentPublic extends Projet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private String ministere;

	public BatimentPublic() {
	}

	public BatimentPublic(int ministere) {
		ministere = ministere;
	}

	public String getMinistere() {
		return ministere;
	}

	public void setMinistere(String ministere) {
		ministere = ministere;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}