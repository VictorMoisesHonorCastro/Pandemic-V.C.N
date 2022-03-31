//Controlador
public class Infecta {
	private int cantidadInfeccion;
	private String ciudad;
	private String virus;

	public Infecta(int cantidadInfeccion,String ciudad,String virus) {
		this.cantidadInfeccion = cantidadInfeccion;
		this.ciudad = ciudad;
		this.virus = virus;
	}

	public int getCantidadInfeccion() {
		return this.cantidadInfeccion;
	}

	public void setCantidadInfeccion(int cantidadInfeccion) {
		this.cantidadInfeccion = cantidadInfeccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getVirus() {
		return this.virus;
	}

	public void setVirus(String virus) {
		this.virus = virus;
	}
}
