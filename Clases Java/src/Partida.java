//controlador
public class Partida  {
	private int ronda;
	private int brotes;
	private int idPartida;

	public Partida(int ronda, int brotes, int idPartida) {
		this.ronda = ronda;
		this.brotes = brotes;
		this.idPartida = idPartida;
	}

	public String mostrarInfecciones() {

		return null;
	}

	public String mostrarMapa() {

		return null;
	}

	public Boolean comprobarPartida() {

		return null;
	}

	public int getRonda() {
		return this.ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public int getBrotes() {
		return this.brotes;
	}

	public void setBrotes(int brotes) {
		this.brotes = brotes;
	}

	public int getIdPartida() {
		return this.idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
}
