//Modelo
public class Ciudades  {
	private String nombre;
	private int nivel_infeccion;
	private String tipo_variante;

	public Ciudades(String nombre, int nivel_infeccion, String tipo_variante) {
		this.nombre = nombre;
		this.nivel_infeccion = nivel_infeccion;
		this.tipo_variante = tipo_variante;
	}

	public String getNombreCiudad() {
		return nombre;
	}

	public void setNombreCiudad(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel_infeccion() {
		return nivel_infeccion;
	}

	public void setNivel_infeccion(int nivel_infeccion) {
		this.nivel_infeccion = nivel_infeccion;
	}

	public String getTipo_variante() {
		return tipo_variante;
	}

	public void setTipo_variante(String tipo_variante) {
		this.tipo_variante = tipo_variante;
	}
}
