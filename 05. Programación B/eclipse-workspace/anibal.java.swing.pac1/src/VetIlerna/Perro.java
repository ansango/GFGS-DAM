package VetIlerna;

public class Perro extends Mascota { //con extends hacemos herencia de la clase Mascota a Perro
	
	private String raza; //atributo propio de la clase Perro
	
	public Perro() {} 
	
	public Perro(String raza) //constructor con parametro de tipo String
	{
		super(); //llamar al constructor de la clase Mascota
		this.raza=raza;
	}
	
	public String getRaza() // metodo get raza
	{
		return raza;
	}
	
	public void setRaza(String raza) //metodo set raza
	{
		this.raza=raza;
	}
	
	public String toString() //metodo toString
	{
		return " es un perro de raza " + raza;
	}

}
