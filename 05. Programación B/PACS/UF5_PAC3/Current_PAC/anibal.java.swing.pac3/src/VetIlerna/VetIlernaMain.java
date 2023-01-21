package VetIlerna;

public class VetIlernaMain {

	public static void main(String[] args) 
	{
		// UF4 PAC2
		
		Cliente cliente1 = new Cliente (); // metodo constructor vacio sin parametros
			
		cliente1.setNombre("Maria"); // parametros a parte
		cliente1.setDni("70873351E");
		
		System.out.println(cliente1.toString());
		
		Cliente cliente2 = new Cliente("Jose","70984453Z"); // metodo constructor con parametros
		
		System.out.println(cliente2.toString());
		
		Mascota mascota1= new Mascota();
		
		mascota1.setNombre("Kenia");
		mascota1.setGenero("hembra");
		mascota1.setCodigo(7083191);
		
		Mascota mascota2= new Mascota();
		
		mascota2.setNombre("Luna");
		mascota2.setGenero("hembra");
		mascota2.setCodigo(7145678);
		
		System.out.println(mascota1.toString());
		System.out.println(mascota2.toString());
		
		// UF4 PAC3
		
		Gato gato1=new Gato(); // definimos el metodo nuevo
		
		gato1.setNombre("Luna"); //parametro de la clase Mascota
		gato1.setColor("blanco"); //parametro de la subclase Gato
		
		System.out.println(gato1.getNombre() + gato1.toString()); //impresion de subclase con métodos de Mascota y su subclase.
		
		Perro perro1=new Perro(); //Repetimos el proceso con los siguiente ejemplos viendo las diferencias en los atributos de cada subclase
		
		perro1.setNombre("Luna");
		perro1.setRaza("podenco");
		
		System.out.println(perro1.getNombre() + perro1.toString());
		
		Roedor roedor1=new Roedor();
		
		roedor1.setNombre("Luna");
		roedor1.setTipo("ratón");
		
		System.out.println(roedor1.getNombre() + roedor1.toString());

	}

}

