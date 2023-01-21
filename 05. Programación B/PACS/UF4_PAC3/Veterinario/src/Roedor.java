import java.util.ArrayList;
import java.util.HashMap;

public class Roedor extends Mascota {
	private String tipo;
	
	Roedor () {
		this.tipo = "";
	}
	
	Roedor (String nombre, Genero genero, String tipo) {
		super (nombre, genero);
		this.tipo = tipo;
	}
	
	public String getTipo () {
		return this.tipo;
	}
	
	public void setTipo (String tipo) {
		this.tipo = tipo;
	}
	
	public String toString () {
		return this.getNombre() + " es un " + this.tipo;
	}
}
