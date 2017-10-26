package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BatimentPublic extends Projet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private String ministere;

	public BatimentPublic() {
	}

	public BatimentPublic(String ministere) {
		ministere = ministere;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getMinistere() {
		return ministere;
	}

	public void setMinistere(String ministere) {
		this.ministere = ministere;
	}
}