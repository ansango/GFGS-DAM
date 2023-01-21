package VetIlerna;

public class VetIlernaMain {

	public static void main(String[] args) 
	{
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
		
		mascota2.setNombre("Congo");
		mascota2.setGenero("macho");
		mascota2.setCodigo(7145678);
		
		System.out.println(mascota1.toString());
		System.out.println(mascota2.toString());

	}

}
