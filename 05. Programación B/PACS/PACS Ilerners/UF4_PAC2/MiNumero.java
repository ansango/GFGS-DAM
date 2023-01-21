/*Carlos Garcia Bruña 
 *
 * He tenido dificultades para cerrar los flujos de la entrada por teclado en los 2 ejercicios con bucle. No se donde colocarlos (teclado.close()) 
 * porque siempre me devolvia una excepcion aunque el codigo a pesar de tener una excepcion se seguia ejecutando... Por más que intentaba cerrar 
 * en cada vuelta o en varios puntos distintos, automaticamente me dejaba de aceptar el input del teclado y el programa realmente dejaba de funcionar... 
 * Eclipse lo marca como warning, pero lo ejecuta igualmente y de forma correcta... Es necesario cerrarlos? Gracias ^_^ */

import java.util.Scanner;

public class MiNumero {
	
	public static int NumeroIntroducido;
	
	MiNumero(int NumeroIntroducido){
		
		//Hacemos referencia a la variable de la clase, asignando el valor pasado como parametro al constructor de la variable
		
		this.NumeroIntroducido =  NumeroIntroducido;
		
	}
	
	//funciones para los cálculos
	private int duplicar() {
		
		return (NumeroIntroducido * 2);
	}
	
	private int triplicar() {
		
		return (NumeroIntroducido * 3);
	}
	
	private int cuadruplicar() {	
		
		return (NumeroIntroducido * 4);
	}
	//fin funciones.
		
	public static void main(String[] args) {
		
		MiNumero Funciones = new MiNumero(NumeroIntroducido);
		int menu = 0;
		
		//mientras opcion no sea = 4, seguimos mostrando el menu tras las operaciones.
				do {
					
					//Con el método Scanner, leemos el int que el usuario a introducido.
					System.out.println("Introduzca un número: ");
					Scanner teclado = new Scanner(System.in);
					NumeroIntroducido = teclado.nextInt();
					
					//Mostramos un menú al usuario para que seleccione que opcion desea.
					System.out.println("Introduzca la opción deseada:\n1.Duplicar el número introducido\n2.Triplicar ese número\n3.Cuadriplicar el número insertado\n4.Salir");
					Scanner teclado2 = new Scanner(System.in);
					menu = teclado2.nextInt();
									
					//Para menu 1
					if (menu ==1) {
						System.out.println("El número multiplicado por 2 equivale a: "+Funciones.duplicar());	
					}
					
					//Para menu 2
					if (menu ==2) {
						System.out.println("El número triplicado equivale a: "+Funciones.triplicar());	
					}
					
					//Para menu 3
					if (menu ==3) {
						System.out.println("Su número cuadriplicado tiene un valor de: "+Funciones.cuadruplicar());	
					}
															
				}while (menu!=4);
				
	}

}
