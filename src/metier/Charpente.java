package metier;

public class Charpente extends Lots implements java.io.Serializable {

	private ECharpente typeCharpente;

	public Charpente() {
	}

	public Charpente(ECharpente typeCharpente) {
		this.typeCharpente = typeCharpente;
	}

	public ECharpente getTypeCharpente() {
		return typeCharpente;
	}

	public void setTypeCharpente(ECharpente typeCharpente) {
		this.typeCharpente = typeCharpente;
	}
}