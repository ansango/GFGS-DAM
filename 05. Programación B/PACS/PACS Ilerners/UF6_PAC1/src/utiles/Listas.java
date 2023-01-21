package utiles;

import java.util.ArrayList;
import java.util.Random;

public class Listas {
	public ArrayList<String> combinar(ArrayList<String> nombres, ArrayList<String> apellidos, int n)
	{
		//Declaramos la lista que vamos a devolver
		ArrayList<String> salida = new ArrayList<String>();
		
		//Obtenemos el tama�o de las listas
		int tamNombres = 0;
		int tamApellidos = 0;
		int numAleatorioNombre;
		int numAleatorioApellido1;
		int numAleatorioApellido2;
		
		//Declaramos las variables a utilizar en el programa
		String nombreGenerado="";
		Random aleatorio = new Random();
		
		
		//Aunque el objetivo no es el control de errores vamos a controlar las listas de
		//manera que hagamos iteraciones innecesarias, ni generemos errores.
		//Ser� obligatorio que ambas listas lleguen y que adem�s tengan informaci�n.
		if((nombres!=null && apellidos!=null)&&(nombres.size()>0 && apellidos.size()>0))
		{
			//Obtenemos el tama�o de las listas
			tamNombres = nombres.size();
			tamApellidos = apellidos.size();
			
			//Iteramos para ir creando las combinaciones de los elementos, como en el enunciado
			//no especifican el n�mero de combinaciones a obtener generaremos tantos como
			//iteraciones completas de nombres y apellidos
			//Al generar los nombres completos se permitir�n duplicados
			for(int x=0; x<n; x++)
			{

				//Generamos n�meros aleatorios para obtener el nombre y los apellidos de la lista
				numAleatorioNombre=aleatorio.nextInt(tamNombres);
				numAleatorioApellido1=aleatorio.nextInt(tamApellidos);
				numAleatorioApellido2=aleatorio.nextInt(tamApellidos);
				
				//Escogemos aleatoriamente un nombre y a�adimos los dos apellidos aleatorios, 
				//por el ejemplo que viene en la pr�ctica parece que se quiere obtener en orden Apellidos + Nombre
				nombreGenerado = apellidos.get(numAleatorioApellido1) + " ";
				nombreGenerado = nombreGenerado + " " + apellidos.get(numAleatorioApellido2);
				nombreGenerado = nombreGenerado + " " + nombres.get(numAleatorioNombre) + " ";				
				
				//A�adimos el nombre generado a la lista
				salida.add(nombreGenerado);
				
			}
		}
		
		return salida;
	}
	
	/**
	 * Un m�todo que dada una lista de libros, devuelva un array de enteros con
	 * tres elementos que indiquen cu�ntos libros de pr�stamo diario, semanal, o
	 * mensual, respectivamente, hay en la lista de entrada 
	 * 
	 * @param libros
	 * @return
	 */
	public int[] prestamoLibros(ArrayList<Libro> libros)
	{
		//Declaramos el arraya que vamos a devolver y lo inicializmos
		int[] prestamos={0,0,0};
		
		//Recorremos la lista de libros
		for(int x=0;x<libros.size();x++)
		{	
			//Aprovechando que se nos pide la informaci�n en el mismo orden que los elementos de la enumeraci�n
			//utilizamos el orden del tipo de pr�stamo para contabilizar cada pr�stamo, de esta manera no 
			//necesitamos comparar los valores mediante IF�s.
			prestamos[libros.get(x).getPrestamo().ordinal()]=prestamos[libros.get(x).getPrestamo().ordinal()]+1;
		}
		
		return prestamos;
	}

}
