//controlador
public class Jugador {
	private String nombre;
	private int puntuacion;
	private int acciones;
	private int vacunas;

	public Jugador(String nombre, int puntuacion, int acciones, int vacunas) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.acciones = acciones;
		this.vacunas = vacunas;
	}
	public int curarCiudad() {
		
		return 0;
	}
	public int investigarCura() {
		
		return 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public int getAcciones() {
		return this.acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}
	public int getVacunas() {
		return this.vacunas;
	}

	public void setVacunas(int vacunas) {
		this.vacunas = vacunas;
	}
	
}
