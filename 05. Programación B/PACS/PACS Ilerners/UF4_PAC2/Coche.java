/*Carlos Garcia Bruña 
 *
 *Aqui no he tenido problemas con el cerrar el Input porque el programa no se repite en un bucle..... */

import java.util.Scanner;

public class Coche {
	
		//Creamos variables
		public String marca;
		public String model;
		
		//las inicializamos, con cualquier valor ya que sera los que el usuario introducirá finalmente
		Coche () {
			marca = "a";
			model = "a";
		}
		//Nuestro vehiculo con los parametros predefinidos
			Coche (String marca, String model) {
					this.marca = marca;
					this.model = model;

			}
		//Funcion para la marca que inserta el usuario	
		public String getMarca () {
			
			return marca;
		}
			
		//Funcion para el modelo que inserta el usuario
		public String getModel () {
				
			return model;
		}
			
		//Funcion con parametro con la marca predefinida
		public void setMarca (String marca) {
			
			this.marca = marca;
		}
			
		//Funcion con parametro con el modelo predefinido
		public void setModel (String model) {
			
			this.model = model;
		}
			
		//MAIN
		public static void main(String[] args) {
			
			//Primer vehiculo que insertara el usuario
				Coche VehiculoIntroducido = new Coche();
				
			//Nuestro vehiculo predefinido con los parametros para los constructores/funciones
				Coche VehiculoPredefinido = new Coche("Honda", "Civic");
				
			//Pedimos al usuario la marca....
				System.out.println("Escriba la marca: ");
				
			//metodo scanner para ller el teclado
				Scanner teclado = new Scanner (System.in);
				VehiculoIntroducido.setMarca(teclado.next());
				
			//... y pedimos el modelo y repetimos el metodo de lectura con scanner	
				System.out.println("Escriba el modelo: ");
				Scanner teclado1 = new Scanner (System.in);
				VehiculoIntroducido.setModel(teclado.next());
			
				
			//Con los datos introducidos los mostramos en pantalla. El introducido llama a sus constructores correspondientes y el
			//Predefinido coge la marca y el modelo con los parametros predefinidos.
				System.out.println("El vehículo introducido es el siguiente: " + VehiculoIntroducido.getMarca() + " " + VehiculoIntroducido.getModel());
				System.out.println("El vehículo predefinido era: " + VehiculoPredefinido.getMarca() + " " + VehiculoPredefinido.getModel());
			//Cerramos el flujo
				teclado.close();
				teclado1.close();
}
}