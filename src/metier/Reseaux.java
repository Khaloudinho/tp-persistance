package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Reseaux extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private float longueur;

	public Reseaux() {
	}

	public Reseaux(float longueur) {
		this.longueur = longueur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
}