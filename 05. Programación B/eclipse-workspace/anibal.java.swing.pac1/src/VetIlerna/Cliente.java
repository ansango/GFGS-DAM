package VetIlerna; //paquete

public class Cliente { //clase
	
	private String nombre, dni; //atributos o propiedades de la clase
	
	public Cliente() {} //constructor vacio que no recibe parametros
	
	public Cliente (String nombre,String dni) // constructor con parametros de tipo string
	{
		this.nombre=nombre; //enlace de atributos de la clase con los parámetros del constructor
		this.dni=dni;
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
		return nombre + " con DNI: " + dni;
	}
}
