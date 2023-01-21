public class Main {

	public static void main(String[] args) {
		/*
		 * En esta PAC hay varios aspectos a tener en cuenta:
		 * 	1º Primero debemos crear el fichero de documentación de Hibernate:
		 * 		En nuestro caso es el fichero hibernate.cfg.xml, contiene la configuración 
		 * 		básica de conexión a la BBDD
		 * 
		 * 	2º Creamos los ficheros HBM correspondientes a cada una de las tablas de la BBDD
		 * 	4º Creamos las clases correspondientes a los ficheros HBM.
		 * 	5º De nuevo en el fichero de configuración debemos mapear las clases con los
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
