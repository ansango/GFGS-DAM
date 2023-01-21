package VetIlerna;

import java.io.Serializable;
import java.util.ArrayList;

//paquete

public class Cliente implements Serializable { //clase serializamos la clase UF5_PAC4
	
	/* para poder guardar objetos java en disco, se ha de realizar a traves de un flujo o stream 
	 * para que un objeto pueda ser transportado a través de un stream, este objeto debe ser serializable
	 * */
	
	private String nombre, dni; //atributos o propiedades de la clase
	private ArrayList<Mascota> mascotas;
	
	public Cliente() {	//constructor vacio que no recibe parametros
		mascotas = new ArrayList<>();
	} 
	
	public Cliente (String nombre,String dni) // constructor con parametros de tipo string
	{
		this.nombre=nombre; //enlace de atributos de la clase con los parámetros del constructor
		this.dni=dni;
		mascotas = new ArrayList<>();
	}
	
	public void addMascota(Mascota m) {
		mascotas.add(m);		
	}
	
	public ArrayList<Mascota> getMascotas(){
		return mascotas;
	}
	
	
	public String getDni()  // metodo get 
	{
		return dni;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) //metodo set
	{
		this.nombre=nombre;
	}
	
	public void setDni(String dni) 
	{
		this.dni=dni;
	}
	
	public String toString() //metodo tostring 
	{
		String resultado = nombre + " con DNI: " + dni + " tiene las siguientes mascotas: \n";
		
		for(Mascota m : mascotas) {
			resultado = resultado + "\t " + m + "\n";
		}
		
		return resultado;
	}
}
