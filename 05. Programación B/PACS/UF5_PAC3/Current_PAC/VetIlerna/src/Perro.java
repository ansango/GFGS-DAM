import java.util.ArrayList;
import java.util.HashMap;

public class Perro extends Mascota {
	private String raza;
	
	Perro () {
		super ();
		this.raza = "";
	}
	
	Perro (String nombre, Genero genero, ArrayList<HashMap<String, String>> tratamientos, String raza) {
		super (nombre, genero, tratamientos);
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
