//controlador
public class Parametros {
	private int num_brotes;
	private int num_ciudades_infectadas;
	private int porcentaje_cura;
	
	public Parametros(int num_brotes, int num_ciudades_infectadas, int porcentaje_cura) {
		this.num_brotes = num_brotes;
		this.num_ciudades_infectadas = num_ciudades_infectadas;
		this.porcentaje_cura = porcentaje_cura;
	}
	
	public int cambiarDificultad() {
		
		return 0;
	}
	
	
	public int getNum_brotes() {
		return num_brotes;
	}

	public void setNum_brotes(int num_brotes) {
		this.num_brotes = num_brotes;
	}

	public int getNum_ciudades_infectadas() {
		return num_ciudades_infectadas;
	}

	public void setNum_ciudades_infectadas(int num_ciudades_infectadas) {
		this.num_ciudades_infectadas = num_ciudades_infectadas;
	}

	public int getPorcentaje_cura() {
		return porcentaje_cura;
	}

	public void setPorcentaje_cura(int porcentaje_cura) {
		this.porcentaje_cura = porcentaje_cura;
	}
}
