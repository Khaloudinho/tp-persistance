package metier;

import java.io.Serializable;

public class Peinture extends Lots implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int surface;

	public Peinture() {}

	public Peinture(int surface) {
		this.surface = surface;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}
}