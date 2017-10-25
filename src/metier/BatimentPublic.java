public class BatimentPublic extends Projet implements java.io.Serializable {

	private int Ministère;

	public BatimentPublic() {
	}

	public BatimentPublic(int ministère) {
		Ministère = ministère;
	}

	public int getMinistère() {
		return Ministère;
	}

	public void setMinistère(int ministère) {
		Ministère = ministère;
	}
}