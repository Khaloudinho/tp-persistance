package metier;

import util.ECorpsMetier;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NamedQueries({
		@NamedQuery(
				name="Entreprise.entreprisesTravaillantAvecCabinet",
				query="SELECT e.nom FROM Entreprise e"),
		@NamedQuery(
				name="Entreprise.entreprisesCorpsMetier",
				query="SELECT e.nom FROM Entreprise e WHERE e.corpsMetier = :corpsMetier"),
})
public class Entreprise implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;

	private String nom;

	@Enumerated(EnumType.STRING)
	private ECorpsMetier corpsMetier;
	private String numTel;

	@OneToMany
	private Set<Acteur> acteurs;

	@OneToOne
	private Adresse adresse;

	@ManyToMany
	private Set<Lots> lotsARealiser;

	@OneToMany
	private Set<Lots> lotsSousResponsabilite;

	public Entreprise() {
	}

	public Entreprise(String nom, ECorpsMetier corpsMetier, String numTel) {
		this.nom = nom;
		this.corpsMetier = corpsMetier;
		this.numTel = numTel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ECorpsMetier getCorpsMetier() {
		return corpsMetier;
	}

	public void setCorpsMetier(ECorpsMetier corpsMetier) {
		this.corpsMetier = corpsMetier;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Lots> getLotsARealiser() {
		return lotsARealiser;
	}

	public void setLotsARealiser(Set<Lots> lotsARealiser) {
		this.lotsARealiser = lotsARealiser;
	}

	public Set<Lots> getLotsSousResponsabilite() {
		return lotsSousResponsabilite;
	}

	public void setLotsSousResponsabilite(Set<Lots> lotsSousResponsabilite) {
		this.lotsSousResponsabilite = lotsSousResponsabilite;
	}

	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}


}