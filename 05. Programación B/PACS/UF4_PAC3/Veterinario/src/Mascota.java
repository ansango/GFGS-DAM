import java.util.Random;

public class Mascota {
	private String nombre;
	private int codigo;
	private Genero genero;
	
	Mascota () {
		this.nombre = "";
		this.codigo = 0;
		this.genero = null;
	}
	
	Mascota (String nombre, Genero genero) {
		Random rand = new Random();
		this.nombre = nombre;
		this.codigo = rand.nextInt(1000);
		this.genero = genero;
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
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setGenero (Genero genero) {
		this.genero = genero;
	}
	
	public String toString () {
		return this.nombre + " con el código " + this.codigo + " es " + this.genero;
	}
}
