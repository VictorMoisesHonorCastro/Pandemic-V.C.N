//Modelo
public class Vacunas {
	private String nombre;
	private int porcentajeCura;

	public Vacunas(String nombre, int porcentajeCura) {
		this.nombre = nombre;
		this.porcentajeCura = porcentajeCura;
	}

	public String getNombreVacuna() {
		return nombre;
	}

	public void setNombreVacuna(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentajeCura() {
		return this.porcentajeCura;
	}

	public void setPorcentajeCura(int porcentajeCura) {
		this.porcentajeCura = porcentajeCura;
	}
}
