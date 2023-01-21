package pruebas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import utiles.ILibro.TipoPrestamo;
import utiles.Libro;
import utiles.Listas;


public class Principal {
	public static void main(String[] args)
	{
		//Declaramos el objeto con el que vamos a invocar a los métodos de la clase
		Principal obj = new Principal();
		
		//Lectura de opción de usuario
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader tecla = new BufferedReader (entrada);
		
		//Inicializamos la opción del menú
		int opcion=-1;
		
		//Solicitar opción de menú y obtener la misma
		pintarMenu();
		
		while(opcion!=0)
		{
			//Solicitar opción de menú y obtener la misma
			opcion = obj.escribirTeclado(tecla);

			switch(opcion)
			{
				case 1:
				{
					//Lanzamos el ejercicio 1
					obj.ejercicio1();
					break;
				}
				case 2:
				{
					//Lanzamos el ejercicio 2
					obj.ejercicio2();
					break;
				}
				default:
				{
					opcion=0;
					break;
				}
			}
			
			//Una vez finalizada la ejecución de la opción seleccionada solicitamos otra
			if(opcion!=0)
			{
				System.out.println("\n\n ***************");
				System.out.println("Seleccione una opción u otro valor para salir: ");
			}
		}
	}
	
	/**
	 * Método para pintar el menú de opciones
	 */
	private static void pintarMenu()
	{
		System.out.println("**************************************************");
		System.out.println("**\t\tMENÚ DE OPCIONES\t\t**");
		System.out.println("**************************************************");
		System.out.print("\n1. Ejercicio 1.a: Lista de nombres y apellidos");
		System.out.print("\n2. Ejercicio 1.b: Lista de libros");
		System.out.print("\n");
		System.out.print("\n\n\nSeleccione una opción u otro valor para salir: ");
	}
	
	/**
	 * Permite introducir y capturar datos por teclado, los datos serán numéricos
	 * 
	 * @param lectura
	 * @param menu
	 * @return
	 */
	private int escribirTeclado(BufferedReader lectura)
	{
		int teclaPulsada;
		
		//Controlamos las excepciones del Buffer de lectura
		try
		{
			teclaPulsada=Integer.parseInt(lectura.readLine());
			return teclaPulsada;
		}
		catch (Exception errorControlado)
		{
			return 0;
		}
	}
	
	/**
	 * Método para probar el ejercicio 1 de la práctica
	 */
	protected void ejercicio1()
	{
		//Declaramos el objeto de Listas y el arrayList de salida
		Listas prueba = new Listas();
		
		ArrayList<String> resultado;
		
		//Declaramos la lista de nombres y apellidos
		ArrayList<String> listaNombres = new ArrayList<String>();
		ArrayList<String> listaApellidos = new ArrayList<String>();
		
		//Cargamos la lista de nombres para la prueba
		listaNombres.add("Pepe");
		listaNombres.add("Luis");
		listaNombres.add("Ana");		
		
		//Cargamos la lista de apellidos para la prueba
		listaApellidos.add("García");
		listaApellidos.add("Romero");
		listaApellidos.add("Pérez");
				
		//Invocamos al método de combinación de nombres con apellidos y mostramos la salida
		resultado=prueba.combinar(listaNombres, listaApellidos, 5);
		
		//Comprobamos el tamaño para mostrar los resultados
		if(resultado.size()>0)
		{
			//Formateamos la salida
			System.out.print("[\n");
			
			//Si sólo existe un elemento no iteramos
			if(resultado.size()==1)
			{
				//Mostramos en pantalla el resultado
				System.out.print(resultado.get(0));
			}
			else
			{
				for(int x=0;x<resultado.size();x++)
				{
					//Mostramos cada elemento de la lista
					System.out.print(resultado.get(x));
					
					//El último no tendrá la coma separadora al no haber más elementos
					if(x!=resultado.size()-1)
						System.out.println(", ");
				}
			}
			
			System.out.print("\n]");
		}
	}
	
	/**
	 * Método para probar el ejercicio 2 de la práctica
	 */
	protected void ejercicio2()
	{
		//Declaramos el array de salida
		int [] arrLibros=null;
		
		//Declaramos el objeto de Listas y el arrayList de entrada
		Listas prueba = new Listas();
		
		//Declaramos la lista de libros
		ArrayList<Libro> listaDeLibros = new ArrayList<Libro>(); 
		
		//Objetos para la lista de libros
		Libro libro1 = new Libro("978-84-96208-96-4", "Juego de Tronos", "George R.R. Martin", 800, new GregorianCalendar(1988,Calendar.FEBRUARY,2),17.60, 15000000, TipoPrestamo.DIARIO);
		
		Libro libro2 = new Libro("978-84-339-2042-3", "La conjura de los negocios", "John Kennedy Toole", 392, new GregorianCalendar(1990,Calendar.APRIL,19),10.00, 30000000, TipoPrestamo.SEMANAL);
		
		Libro libro3 = new Libro("978-84-450-7753-5", "El Silmarillion", "J.R.R. Tolkien", 448, new GregorianCalendar(1991,Calendar.APRIL,8),10.95, 3700000, TipoPrestamo.MENSUAL);
		
		Libro libro4 = new Libro("978-84-9793-353-7", "El fin de la eternidad", "Isaac Asimov", 288, new GregorianCalendar(1995,Calendar.DECEMBER,1),8.95, 30000000, TipoPrestamo.SEMANAL);
		
		Libro libro5 = new Libro("978-84-08-05304-0", "Cosmos", "Carl Sagan", 384, new GregorianCalendar(1990,Calendar.FEBRUARY,8),36.00, 15000000, TipoPrestamo.DIARIO);
		
		Libro libro6 = new Libro("978-84-272-0309-9", "Viaje al centro de la Tierra", "Julio Verne", 274, new GregorianCalendar(2012,Calendar.AUGUST,6),18.00, 35000000, TipoPrestamo.DIARIO);
		
		//Añadimos los libros a la lista
		listaDeLibros.add(libro1);
		listaDeLibros.add(libro2);
		listaDeLibros.add(libro3);
		listaDeLibros.add(libro4);
		listaDeLibros.add(libro5);
		listaDeLibros.add(libro6);
		
		//Invocamos al método del ejercicio 2
		arrLibros=prueba.prestamoLibros(listaDeLibros);
		
		//Como hemos inicializado el array siempre tendremos 3 elementos, por lo que
		//asumimos que se devuelve el array y tiene valores
		System.out.print("[");
		
		for(int x=0; x<arrLibros.length; x++)
		{
			if(x<arrLibros.length-1)
				System.out.print(arrLibros[x] + ", ");
			else
				System.out.print(arrLibros[x] + "]");
		}
	}

}
