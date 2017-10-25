import java.io.Serializable;

public class Terrassement extends Lots implements Serializable {

	private int volumeTerre;

	public Terrassement() {}

	public Terrassement(int volumeTerre) {
		this.volumeTerre = volumeTerre;
	}

	public int getVolumeTerre() {
		return volumeTerre;
	}

	public void setVolumeTerre(int volumeTerre) {
		this.volumeTerre = volumeTerre;
	}
}