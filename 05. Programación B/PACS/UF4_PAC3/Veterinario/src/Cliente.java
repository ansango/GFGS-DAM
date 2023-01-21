
public class Cliente {
	private String nombre;
	private String dni;
	private Mascota mascota;
	
	Cliente (String nombre, String dni, Mascota mascota) {
		this.nombre = nombre;
		this.dni = dni;
		this.mascota = mascota;
	}
	
	Cliente () {
		this.nombre = "";
		this.dni = "00000000A";
		this.mascota = null;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getDni () {
		return this.dni;
	}
	
	public Mascota getMascota () {
		return this.mascota;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni (String dni) {
		this.dni = dni;
	}
	
	public void setMascota (Mascota mascota) {
		this.mascota = mascota;
	}
	
	public String toString () {
		return this.nombre + " con DNI " + this.dni + " tiene un " + this.mascota + " como mascota.";
	}
}
