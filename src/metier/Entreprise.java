package metier;

import util.ECorpsMetier;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Entreprise implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;

	private String nom;
	private ECorpsMetier corpsMetier;
	private int numTel;

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

	public Entreprise(String nom, ECorpsMetier corpsMetier, int numTel) {
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

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
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