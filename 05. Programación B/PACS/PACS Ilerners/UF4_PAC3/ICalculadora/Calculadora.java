//carlos Garcia Bruña
//Java me añade automaticamente los override que no los entiendo muy bien para que son...
//Añadidos los metodos automaticamente.

package ICalculadora;

import java.util.Scanner;

public class Calculadora implements ICalculadora {
	
	//2.0 Atributos privados tipo double
	private double NumeroA, NumeroB;
	

	public Calculadora() {
		
		this.NumeroA = 0;
		this.NumeroB = 0;
	}
	
	Calculadora(double Numero1, double Numero2) {
		
		this.NumeroA = Numero1;
		this.NumeroB = Numero2;
		
		}

	@Override //Metodo 1.b.a
	public double Sumar() {
		
		return this.NumeroA + this.NumeroB;
	}

	@Override //Metodo 1.b.b
	public double Sumar(double SumaFinalParametro) {
		
		return this.NumeroA + this.NumeroB + SumaFinalParametro;
	}

	@Override //Metodo 1.c
	public double Restar() {
		
		return this.NumeroA - this.NumeroB;
	}

	@Override //Metodo 1.d.a
	public double GetNum1() {
		
		return this.NumeroA;
	}

	@Override //Metodo 1.d.b
	public double GetNum2() {
		
		return this.NumeroB;
	}

	@Override //Metodo 1.e.a
	public void SetNum1(double NumeroDevueltoSet) {
		
		this.NumeroA = NumeroDevueltoSet;
		
	}

	@Override  //Metodo 1.e.b
	public void SetNum2(double NumeroDevueltoSet) {
		
		this.NumeroB = NumeroDevueltoSet;
		
	}

	public double Raiz () { //Metodo 2.e
		
		return Math.sqrt(this.NumeroA);
		
		}
	
	public double Potencia (double d) { //Metodo 2.f
		
		return Math.pow(this.NumeroA, d);
		
		}
	

public static void main (String[] args) {
	//Objetos sin parámetros 3.a
	Calculadora Calculo = new Calculadora();
	Calculadora Calculo2;
	double Numero1, Numero2;
	
	Scanner Teclado = new Scanner(System.in);
	/*TEST_TEST_TEST
	 * //Calculadora Calculo2;
	System.out.println("Números: ");
	Calculo.SetNum1(Teclado.nextDouble());
	Calculo2.SetNum1(Teclado.nextDouble());
	System.out.println(Calculo.NumeroA);
	System.out.println(Calculo2.NumeroA); TEST_TEST_TEST*/
	
	//Pedimos números al usuario, lo haré del tirón sin pedir menú ni opciones.
	System.out.println("Numero? ");
	Calculo.SetNum1(Teclado.nextDouble());
	
	System.out.println("Numero 2? ");
	Calculo.SetNum2(Teclado.nextDouble());
	
	//Llegado a este punto el objeto creado Calculo,ya tiene los valores por teclado Parte 3.a.i
	
	//Pedimos dos numeros más y los añadimos directamente al objeto como se indica en la parte 3.a.ii
	
	System.out.println("Numero 3? ");
	Numero1 = (Teclado.nextDouble());
	
	System.out.println("Numero 4? ");
	Numero2 = (Teclado.nextDouble());
	
	//Y inicializamos el objeto con los valores que hemos pedido
	
	Calculo2 = new Calculadora(Numero1, Numero2);
	
	//-------------------------------CALCULOS-------------------------------//
	//--------------------------------SUMAS---------------------------------//
	System.out.println("//--------------------------------SUMAS---------------------------------//");
	System.out.println("Suma 1 y 2:");
	//Basadas en los primeros dos numeros del primer objeto y los otros dos del segundo objeto
	System.out.println(Calculo.GetNum1() + " + " + Calculo.GetNum2() + " = " + Calculo.Sumar());
	System.out.println(Calculo2.GetNum1() + " + " + Calculo2.GetNum2() + " = " + Calculo.Sumar());
	
	//El tercer numero de la primera es el primer número del segundo constructor y el tercer número de la segunda es el cuarto numero del construcor
	System.out.println("Suma 3 y 4 con los parámetros para el tercer número:");
	System.out.println(Calculo.GetNum1() + " + " + Calculo.GetNum2() + " + " + Numero1 + " = " + Calculo.Sumar(Numero1));
	System.out.println(Calculo2.GetNum1() + " + " + Calculo2.GetNum2() + " + " + Numero2 + " = " + Calculo2.Sumar(Numero2));
	
	//--------------------------------RESTA---------------------------------//
	//No tiene mucho secreto basandonos en la parte de la Suma.....//
	
	System.out.println("//--------------------------------RESTA---------------------------------//");
	System.out.println("Resta 1:");
	System.out.println(Calculo.GetNum1() + " - " + Calculo.GetNum2() + " = " + Calculo.Restar());
	System.out.println("Resta 2:");
	System.out.println(Calculo2.GetNum1() + " - " + Calculo2.GetNum2() + " = " + Calculo2.Restar());
	
	//--------------------------------RAIZ CUADRADA---------------------------------//
	System.out.println("//----------------------------RAIZ CUADRADA---------------------------------//");
	System.out.println("La raiz cuadrada de " + Calculo.GetNum1() + " es " + Calculo.Raiz());
	
	//----------------------------------POTENCIA------------------------------------//
	System.out.println("//----------------------------RAIZ CUADRADA---------------------------------//");
	System.out.println(Calculo2.GetNum1() + " elevado a " + Calculo2.GetNum2() + " es " + Calculo2.Potencia(Calculo2.GetNum2()));

	Teclado.close();
}


}
