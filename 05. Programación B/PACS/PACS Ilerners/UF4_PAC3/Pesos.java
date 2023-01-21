//Carlos Garcia Bruña. Pac3 UF 4 31/03/2017

//Importamos el m´dulo Scanner para la lectura de datos introducidos por teclado
import java.util.Scanner;


public class Pesos {
	
	//Declaramos todas la variables:
	//La primera la damos por teclado, Parte A
	private double PesoIntroducido;
	//Las siguientes ya estan predefinidas y se utilzarán para convertir el valor introducido al resto
	private double Gramo = 0.001;
	private double Libra = 0.453;
	private double Onza = Libra * 0.0625;
	private double Penique = Onza * 0.05;
	private double Quintal = Libra * 100;
	private double Lingote = Libra * 32.17;
	private byte condicion = 0;
	
	//Parte B: Constructor con Referencias de Conversión con los parámetros Peso y Medida
	
	
	Pesos (double PesoIntroducido, String Unidades){
		
		do { 
		switch (Unidades) {
			case "Gramo":
				this.PesoIntroducido = PesoIntroducido * Gramo;
				condicion = 1;
				break;
			case "Libra":
				this.PesoIntroducido = PesoIntroducido * Libra;
				condicion = 1;
				break;
			case "Onza":
				this.PesoIntroducido = PesoIntroducido * Onza;
				condicion = 1;
				break;
			case "Penique":
				this.PesoIntroducido = PesoIntroducido * Penique;
				condicion = 1;
				break;
			case "Quintal":
				this.PesoIntroducido = PesoIntroducido * Quintal;
				condicion = 1;
				break;
			case "Lingote":
				this.PesoIntroducido = PesoIntroducido * Lingote;
				condicion = 1;
			default: this.PesoIntroducido = 0;
				condicion = 1;
			
			
		}
				
		}while (condicion == 0);
	}
		
	//Fin Parte B
	
		//CalculoPesosIF (double PesoIntroducido, String Unidades){} A completar más tarde
		
		//Parte C: Los 3 métodos, dentro de getpeso llamamos a los otros dos para la conversión.	
	
	
		public double getPeso(String Unidades) {
		switch (Unidades) {
		//Los dos primeros llaman a los métodos solicitados
			case "Libra":
				return getLibras();
			case "Lingote":
				return getLingotes();
			case "Quintal":
				return PesoIntroducido / Quintal;
			case "Gramo":
				return PesoIntroducido / Gramo;
			case "Penique":
				return PesoIntroducido / Penique;
			case "Onza":
				return PesoIntroducido / Onza;
						}
		return PesoIntroducido;
		}
		
		public double getLingotes() {
			return (PesoIntroducido / Lingote);
		}
		
		public double getLibras() {
			
			return (PesoIntroducido / Libra);
		}
		
		//Fin parte C
		
	
	public static void main(String[] args) {
		String Unidades = "_";
		Double PesoIntroducido;
		Pesos Peso;
		
		//Pedimos los valores al usuario, tanto el peso a convertir como a que desea convertirlo
		Scanner Teclado1 = new Scanner(System.in);
		System.out.println("Vamos a realizar conversiones entre distintos pesos!");
		System.out.println("Introduce el peso que deseas convertir:");
		PesoIntroducido = Double.parseDouble(Teclado1.nextLine());
		System.out.println("Introduce la medida a convertir:");
		System.out.println("Las posibles opciones son: Gramo, Libra, Onza, Penique, Quintal o Lingote:");
		Unidades = Teclado1.nextLine();
		
		//Llamamos al constructor
		Peso = new Pesos(PesoIntroducido, Unidades);
		
		//Mostramos datos por pantalla.
		System.out.println("El peso introducido ha sido de: " + PesoIntroducido +" "+ Unidades);
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getLibras() + " libras");
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getLingotes() + " lingotes");
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getPeso("Penique") + " peniques");
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getPeso("Quintal") + " quintales");
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getPeso("Onza") + " onzas");
		System.out.println(PesoIntroducido +" "+ Unidades+" equivalen a: " + Peso.getPeso("Gramo") + " gramos");
		Teclado1.close();
	}

}
