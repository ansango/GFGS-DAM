package VetIlerna;

public class Gato extends Mascota { //con extends hacemos herencia de la clase Mascota a Gato
	
	private String color; //atributo propio de la clase Gato
	
	public Gato() {} 
	
	public Gato(String color) //constructor con parametro de tipo String
	{ 
		super(); //llamar al constructor de la clase Mascota
		this.color=color;
	}
	
	public String getColor() // metodo get color
	{
		return color;
	}
	
	public void  setColor(String color) //metodo set color
	{
		this.color=color;
	} 
	
	public String toString()  //metodo toString
	{
		return super.toString() + " y es un gato de color " + color; 
	}
	
	

}
