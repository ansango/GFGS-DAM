public class Main {

	public static void main(String[] args) {
		/*
		 * En esta PAC hay varios aspectos a tener en cuenta:
		 * 	1� Primero debemos crear el fichero de documentaci�n de Hibernate:
		 * 		En nuestro caso es el fichero hibernate.cfg.xml, contiene la configuraci�n 
		 * 		b�sica de conexi�n a la BBDD
		 * 
		 * 	2� Creamos los ficheros HBM correspondientes a cada una de las tablas de la BBDD
		 * 	4� Creamos las clases correspondientes a los ficheros HBM.
		 * 	5� De nuevo en el fichero de configuraci�n debemos mapear las clases con los
		 * 		ficheros HBM.
		 * 
		 * 
		 * -------------------
		 * 
		 * Una vez hecho esto hemos creado la clase Controller, que es la encargada
		 * de interactuar con BBDD a traves de las clases de Hibernate.
		 * 
		 * Finalmente las clases MainWindow y AlertWindow son las encargadas de la GUI
		 */
		
		
		MainWindow gestDepartamentos=new MainWindow();
		gestDepartamentos.showMe();		
	}

}
