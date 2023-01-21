
public class Cliente {
	private String nombre;
	private String dni;
	
	Cliente (String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	Cliente () {
		this.nombre = "";
		this.dni = "00000000A";
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getDni () {
		return this.dni;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni (String dni) {
		this.dni = dni;
	}
	
	public String toString () {
		return this.nombre + " con DNI " + this.dni;
	}
}
