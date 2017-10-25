package metier;

import util.EEtaScolaire;

@Entity
public class EtablissementScolaire extends BatimentPublic {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private int nbEleves;
	private EEtaScolaire categorie;

}