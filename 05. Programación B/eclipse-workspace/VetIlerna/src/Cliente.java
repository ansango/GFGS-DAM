import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String dni;
	private ArrayList<Mascota> mascotas;
	
	Cliente (String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.mascotas = new ArrayList<>();
	}
	
	Cliente () {
	
		this.mascotas = new ArrayList<>();
	}
	
	public void anadirMascota(Mascota mascota) {
		this.mascotas.add(mascota);
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getDni () {
		return this.dni;
	}
	
	//metodo para añadir mascotas
	
	public ArrayList<Mascota> getMascotas () {
		return this.mascotas;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni (String dni) {
		this.dni = dni;
	}
	
	public void setMascota (ArrayList<Mascota> mascota) {
		this.mascotas = mascota;
	}
	
	public String toString () {
		String cadena = this.nombre + " con DNI " + this.dni + " tiene como mascotas: ";
		
		/*for(Mascota m : mascotas){
			cadena+=m.getNombre();
			
		} */
		
		for (int i = 0; i < this.mascotas.size(); i++) {
			cadena += mascotas.get(i).getNombre();
		}
		return cadena;
	}
}
