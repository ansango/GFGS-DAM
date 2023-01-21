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
		this.tratamientos = new ArrayList<>();
	}
	
	Mascota (String nombre, Genero genero) {
		Random rand = new Random();
		this.nombre = nombre;
		this.codigo = rand.nextInt(1000);
		this.genero = genero;
		this.tratamientos = new ArrayList<>();
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
	
	public HashMap<String, String> getTratamiento (int indice) {
		return this.tratamientos.get(indice);
	}
		
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setGenero (Genero genero) {
		this.genero = genero;
	}
	
	public void añadirTratamientos (HashMap<String, String> tratamiento) {
		this.tratamientos.add(tratamiento);
	}
	
	public String toString () {		
		return this.nombre + " con el código " + this.codigo + " es " + this.genero + ". Ha recibido los siguientes tratamientos: " + tratamientos;
	}
}
