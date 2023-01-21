/*Carlos Garcia Bruña 
 *
 * He tenido dificultades para cerrar los flujos de la entrada por teclado en los 2 ejercicios con bucle. No se donde colocarlos (teclado.close()) 
 * porque siempre me devolvia una excepcion aunque el codigo a pesar de tener una excepcion se seguia ejecutando... Por más que intentaba cerrar 
 * en cada vuelta o en varios puntos distintos, automaticamente me dejaba de aceptar el input del teclado y el programa realmente dejaba de funcionar... 
 * Eclipse lo marca como warning, pero lo ejecuta igualmente y de forma correcta... Es necesario cerrarlos? Gracias ^_^ */

import java.util.Scanner;

public class Finanzas {
	
	private static double ValorDolar;
	
	Finanzas() {
	ValorDolar = 1.12;
	}
	
	Finanzas(double ValorDolar) {
		this.ValorDolar = ValorDolar;
	}
	
	//Funcion simple que recibe como parametro el valor en Euros, para la opcion 1 y realiza el calculo.
	public double EurosADolares(double euros) { 
		return (euros * ValorDolar); 
	}
	
	//Funcion simple que recibe como parametro el valor en Euros, para la opcion 2 y realiza el calculo.
	public double DolaresAEuros(double dolares) { 
			return (dolares / ValorDolar); 
	}
			
	public static void main(String[] args) {
		
		int menu = 0;
		//Variable para opcion 1 y opcion 2
		double monedas = 0;
		Finanzas Funciones = new Finanzas();
				
		//mientras opcion no sea = 5, seguimos mostrando el menu tras las operaciones.
		do {
			//Mostramos un menú al usuario para que seleccione que opcion desea.
			System.out.println("Introduzca la opción deseada:\n1.Cambiar de Euros a Dólares\n2.Cambiar de Dólares a Euros\n3.Cambiar el valor del Dolar respecto al Euro\n4.Restablecer el valor del dolar (Por defecto 1 Euro = 1.12 Dolares) \n5.Salir");
			
			//Con el método Scanner, leemos el int que el usuario a introducido.
			Scanner teclado = new Scanner(System.in);
			menu = teclado.nextInt();
						
			
			//Si el usuario marca la opción 1
			if (menu == 1) {
			//Le pedimos que introduzca los Euros a convertir
					System.out.println("Introduzca la cantidad de Euros a convertir");
					Scanner teclado1 = new Scanner(System.in);
					monedas = teclado1.nextDouble();
			//llamamos a la funcion que se encarga de hacer el cálculo y se lo mostramos al usuario
			System.out.println(monedas+" Euros, equivalen a "+Funciones.EurosADolares(monedas)+" dólares americanos. El valor del dólar empleado fue de "+ ValorDolar);
			}
			
			//Si el usuario marca la opción 2
			else if (menu == 2) {
			//Le pedimos que introduzca los Dólares a convertir
					System.out.println("Introduzca la cantidad de Dolares a convertir");
					Scanner teclado2 = new Scanner(System.in);
					monedas = teclado2.nextDouble();
			//llamamos a la funcion que se encarga de hacer el cálculo y se lo mostramos al usuario
			System.out.println(monedas+" Dólares, equivalen a "+Funciones.DolaresAEuros(monedas)+" euros. Un Euro son "+ValorDolar+ " Dólares.");
			}
			
			//Pedimos al usuario si desea cambiar el valor del dolar vs Euro
			else if (menu == 3) {
				//Le pedimos que introduzca los Euros a convertir
						System.out.println("Introduzca el nuevo valor del dolar:");
						Scanner teclado3 = new Scanner(System.in);
						ValorDolar = teclado3.nextDouble();
			}
			
			else if (menu == 4) {
				//Restablecemos el valor del dolar a 1.12
						
						ValorDolar = 1.12;
						System.out.println("Valor del Dólar restablecido con éxito!!!");
			}
			
			
			else {
				System.out.println("Opción no válida");
			}
									
			
		} while (menu != 5);
		

	}

}
