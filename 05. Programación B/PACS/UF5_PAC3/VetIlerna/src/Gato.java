
public class Gato extends Mascota {
	private String color;
	
	Gato () {}
	
	Gato (String nombre, Genero genero, String color) {
		super (nombre, genero);
		this.color = color;
	}
	
	public String getColor () {
		return this.color;
	}
	
	public void setColor (String color) {
		this.color = color;
	}
	
	public String toString () {
		return this.getNombre() + " es un gato de color " + this.color;
	}
	
}
