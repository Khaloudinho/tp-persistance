public class Dallage extends Lots implements java.io.Serializable {

	private int surfaceTotale;

	public Dallage() {
	}

	public Dallage(int surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public int getSurfaceTotale() {
		return surfaceTotale;
	}

	public void setSurfaceTotale(int surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}
}