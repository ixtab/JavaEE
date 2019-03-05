package vivienda;
	
public class Piso {
	private int habitaciones;
	private String color;
	private int aseos;
	private int metros;
	
	public Piso() {
		habitaciones=2;
		color="Blanco";
		aseos=1;
		metros=70;
	}	
	
	public Piso(int habitaciones, String color, int aseos, int metros) {

		this.habitaciones = habitaciones;
		this.color = color;
		this.aseos = aseos;
		this.metros = metros;
	}

	@Override
	public String toString() {
		return "Piso [habitaciones=" + habitaciones + ", color=" + color + ", aseos=" + aseos + ", metros=" + metros
				+ "]";
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones=habitaciones;
	}
	public int getHabitaciones() {
		return habitaciones;
	}

	public void setColor(String color) {
		this.color=color;
	}
	public String getColor() {
		return color;
	}

	public void setAseos(int aseos) {	
		this.aseos=aseos;
	}
	public int getAseos() {
		return aseos;
	}
	
	public void setMetros(int metros) {
		this.metros=metros;
	}
	
	public int getMetros() {
		return metros;
	}
}
