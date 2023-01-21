import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String dni;
	private ArrayList<Mascota> mascota;
	
	Cliente (String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.mascota = new ArrayList<>();
	}
	
	Cliente () {
		this.nombre = "";
		this.dni = "00000000A";
		this.mascota = new ArrayList<>();
	}
	
	public void añadirMascota(Mascota mascota) {
		this.mascota.add(mascota);
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getDni () {
		return this.dni;
	}
	
	public ArrayList<Mascota> getMascota () {
		return this.mascota;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni (String dni) {
		this.dni = dni;
	}
	
	public void setMascota (ArrayList<Mascota> mascota) {
		this.mascota = mascota;
	}
	
	public String toString () {
		String cadena = this.nombre + " con DNI " + this.dni + " tiene como mascotas: ";
		for (int i = 0; i < this.mascota.size(); i++) {
			cadena += mascota.get(i).getNombre();
		}
		return cadena;
	}
}
