package metier;

import util.EEtaScolaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class EtablissementScolaire extends BatimentPublic {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int nbEleves;
	private EEtaScolaire categorie;

}