import java.util.HashMap;

public class Mascota {
	private String nombre;
	private static int codigo = 0; //valor inicial, estático para que cada vez que creemos mascota nueva, y recuperamos el ultimo valor que teniamos
	private Genero genero;
	
	//Hashmap (tiene clave: fecha ,,,,, y valor: tratamiento)
	
	private HashMap<String, String> tratamientos;
	
	//cada vez que creemos Mascota vacio o no vacio suma un codigo (por la variable estática
	
	Mascota () {
		
		this.codigo++;
		this.tratamientos = new HashMap<String,String>(); //inicializamos el hashmap
	}
	
	Mascota (String nombre, Genero genero) {
				
		this.nombre = nombre;
		this.codigo++;
		this.genero = genero;
		this.tratamientos = new HashMap<String, String>();
	}
	
	//añadimos tratamiento al hashmap, recibimos fecha y tratamiento
	
	public void addTratamiento(String fecha, String tratamiento) {
		tratamientos.put(fecha,  tratamiento); //como trabajamos con mapas no utilizamos add sino put
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
	
	public HashMap<String, String> getTratamientos () {
		return this.tratamientos;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setGenero (Genero genero) {
		this.genero = genero;
	}
	
	public void setTratamientos (HashMap<String, String> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	public String toString () {
		String cadenaTratamientos = "";
		
		for (String fecha: tratamientos.keySet()) { //el keyset nos devuelve la coleccion de claves (al ser coleccion podermos recorrerla)
			cadenaTratamientos.concat(fecha + " : " + tratamientos.get(fecha) + "\n");
		}
		
		
		return this.nombre + " con el codigo " + this.codigo + " es " + this.genero + ". Ha recibido los siguientes tratamientos: " + tratamientos;
	}
}
