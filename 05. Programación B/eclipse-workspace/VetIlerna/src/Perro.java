public class Perro extends Mascota {
	private String raza;
	
	Perro () {}
	
	Perro (String nombre, Genero genero, String raza) {
		super (nombre, genero);
		this.raza = raza;
	}
	
	public String getRaza () {
		return this.raza;
	}
	
	public void setRaza (String raza) {
		this.raza = raza;
	}
	
	public String toString () {
		return this.getNombre() + " es un perro de raza " + this.raza;
	}
}
