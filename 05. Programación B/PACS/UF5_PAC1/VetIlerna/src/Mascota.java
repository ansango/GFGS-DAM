import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Mascota {
	private String nombre;
	private int codigo;
	private Genero genero;
	private ArrayList<HashMap<String, String>> tratamientos;
	
	Mascota () {
		this.nombre = "";
		this.codigo = 0;
		this.genero = null;
		this.tratamientos = null;
	}
	
	Mascota (String nombre, Genero genero, ArrayList<HashMap<String, String>> tratamientos) {
		Random rand = new Random();
		this.nombre = nombre;
		this.codigo = rand.nextInt(1000);
		this.genero = genero;
		this.tratamientos = tratamientos;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getCodigo () {
		return this.codigo;
	}
	
	public Genero getGenero () {
		return this.genero;
	}
	
	public ArrayList<HashMap<String, String>> getTratamientos () {
		return this.tratamientos;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setGenero (Genero genero) {
		this.genero = genero;
	}
	
	public void setTratamientos (ArrayList<HashMap<String, String>> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	public String toString () {
		String tratamientos = "";
		for (int i = 0; i < this.tratamientos.size(); i++) {
			tratamientos.concat(", " + i);
		}
		return this.nombre + " con el código " + this.codigo + " es " + this.genero + ". Ha recibido los siguientes tratamientos: " + tratamientos;
	}
}
