package poo;

public class coche 
{
	private int ruedas; //nº de ruedas //private es modificador de acceso (encapsula la variable y no se puede modificar desde otro sitio que no sea su clase)
	private int largo; // cm de ancho
	private int ancho; // cn de largo
	private int motor; //cm cubicos de motor
	private int peso_plataforma; // kg de peso
	
	private String color;
	int peso_total;
	boolean asientos_cuero, climatizador;
	
	//para poder acceder a modificadores private deberemos crear metodos (capitulo 30 de pildoras)
	
	
	public coche() //metodo constructor se encarga de dar un estado inical a nuestro objeto -- caracteristicas comunes 
	{
		ruedas=4;
		largo=2000;
		ancho=300;
		peso_plataforma=500;
	}
	
	//metodo getter -- hace que podamos usar el metodo en cualquier otra clase
	
	public String dime_datos_generales() //getter siempre con intruccion return, devuelve un dato de tipo String
	{
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas " + " . Mide " + largo/1000 + " metros con un ancho de " + ancho + " cm y un perso de plataforma de "
				+ peso_plataforma + " kg. ";
	}
	
	//metodo setter -- no devuelve valor es void, no lleva return
	
	public void establece_color(String color_coche) //paso de parametro dentro de parentesis de tipo String
	{
		//color = "azul";
		color=color_coche;
		
	}
	
	//metodo getter que nos informa del color
	
	public String dime_color() 
	{
		return "El color del coche es " + color;
	}
	
	public void configura_asientos(String asientos_cuero /*argumento*/ ) // setter asientos cuero
	{
		if (asientos_cuero=="si") 
		{
			this.asientos_cuero=true;
		}
		else 
		{
			this.asientos_cuero=false;
		}
	}
	
	public String dime_asientos() //getter asientos cuero
	{
		if(asientos_cuero==true) 
		{
			return "El coche tiene asientos de cuero";
		}
		else 
		{
			return "El coche tiene asientos de serie";
		}
	}
	
}
