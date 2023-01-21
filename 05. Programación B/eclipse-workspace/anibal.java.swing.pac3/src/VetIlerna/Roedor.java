package VetIlerna;

public class Roedor extends Mascota { //con extends hacemos herencia de la clase Mascota a Roedor
	
private String tipo; //atributo propio de la clase Roedor
	
	public Roedor() {}
	
	public Roedor(String tipo)  //constructor con parametro de tipo String
	{
		super(); //llamar al constructor de la clase Mascota
		this.tipo=tipo;
	}
	
	public String getTipo() // metodo get tipo
	{
		return tipo;
	}
	
	public void setTipo(String tipo) //metodo set tipo
	{
		this.tipo=tipo;
	}
	
	public String toString() //metodo toString
	{
		return super.toString() + " y es un " + tipo;
	}

}
