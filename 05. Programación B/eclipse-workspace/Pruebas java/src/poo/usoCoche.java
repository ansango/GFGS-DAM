package poo;

public class usoCoche {

	public static void main(String[] args) //clase principal siempre con metodo main
	{
		//coche Renault= new coche(); //instanciar una clase. Ejemplar de clase
		
		//Renault.ruedas=3; //esto seria sin encapsular
		
		// para modificar las clases lo hacemos a través de metodos (setter getter)
		
			// setter o definidores
		
			// getter o captadores
		
				//System.out.println("Este coche tiene " + Renault.ruedas + " ruedas.");
		
		//System.out.println(Renault.dime_largo());
		
		// -------------------------------------------
		
		coche micoche = new coche(); //1 instanciamos un objeto de la clase coche
		
		micoche.establece_color("amarillo "); //2
		
		System.out.println(micoche.dime_datos_generales());
		
		//micoche.color="rosa"; //esto sería sin encapsular, no podemos manipular la propiedad desde aqui-- hay que poner private en los atributos en la clase
		
		System.out.println(micoche.dime_color()); //3
		
		micoche.configura_asientos("si");
		
		System.out.println(micoche.dime_asientos());
		
	}

}
