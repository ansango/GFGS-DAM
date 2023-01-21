package VetIlerna; //paquete

public class Mascota {  //clase

	private String nombre, genero; //atributos o propiedades de la clase
	private int codigo;
	
	public Mascota() {} //constructor vacio que no recibe parametros
	
	public Mascota(String nombre, String genero,int codigo)  // constructor con parametros de tipo string e int
	{
		this.nombre=nombre; //enlace de atributos de la clase con los parámetros del constructor
		this.genero=genero;
		this.codigo=codigo;
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
		return nombre + " con el código " + codigo + " es " + genero;
	}
}
