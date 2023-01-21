package VetIlerna; //paquete

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Mascota implements Serializable {  //clase

	/* para poder guardar objetos java en disco, se ha de realizar a traves de un flujo o stream 
	 * para que un objeto pueda ser transportado a través de un stream, este objeto debe ser serializable
	 * tambien es imprescindible que todas las propiedades de una clase serializable sean a su vez serializables
	 * */
	
	private String nombre, genero; //atributos o propiedades de la clase
	private static int contador = 1;
	private int codigo;
	private HashMap<String,String> tratamientos;	// <fecha, tratamiento>
		
	public Mascota() {	//constructor vacio que no recibe parametros
		codigo = contador++;
		tratamientos = new HashMap<>();
	} 
	
	public Mascota(String nombre, String genero)  // constructor con parametros de tipo string e int
	{
		codigo = contador++;
		this.nombre=nombre; //enlace de atributos de la clase con los parámetros del constructor
		this.genero=genero;
		tratamientos = new HashMap<>();
	}
	
	public void addTratamiento(String fecha, String tratamiento) {
		//tratamientos.put(fecha, tratamiento);
		
		if(tratamientos.put(fecha,tratamiento) != null) {
			System.out.println("Error la fecha ya existe");
		}
	}
	
	public String getNombre()  // metodo get 
	{
		return nombre;
	}
	
	public String getGenero()
	{
		return genero;
	}
	
	public int getCodigo ()
	{
		return codigo;
	}
	
	public void setNombre(String nombre) //metodo set
	{
		this.nombre=nombre;
	}
	
	public void setGenero(String genero)
	{
		this.genero=genero;
	}
	
	public void setCodigo(int codigo)
	{
		this.codigo=codigo;
	}
	
	public String toString() //metodo tostring 
	{
		String resultado = nombre + " con el código " + this.codigo + " es " + genero + "tratamientos: {";
		 
		for (Map.Entry<String, String> entry : tratamientos.entrySet()) {
		    resultado += "[" + entry.getKey() + " : " + entry.getValue() + "]";
		}
		return resultado + "}";
	}
}
