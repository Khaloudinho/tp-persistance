public class Charpente extends Lots {

	private ECharpente typeCharpente;

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