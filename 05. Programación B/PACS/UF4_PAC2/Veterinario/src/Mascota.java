import java.util.Random;

public class Mascota {
	private String nombre;
	private int codigo;
	private String genero;

	Mascota () {
		this.nombre = "";
		this.codigo = 0;
		this.genero = "";
	}
	
	Mascota (String nombre, String genero) {
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

	public String getGenero () {
		return this.genero;
	}
		
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo (int codigo) {
		this.codigo = codigo;
	}


	public void setGenero (String genero) {
		this.genero = genero;
	}
	
	public String toString () {
		return this.nombre + " tiene el código " + this.codigo;
	}
}
