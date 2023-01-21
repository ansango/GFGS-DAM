import java.util.ArrayList;
import java.util.HashMap;

public class Perro extends Mascota {
	private String raza;
	
	Perro () {
		super ();
		this.raza = "";
	}
	
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
