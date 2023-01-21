import java.util.Scanner;

public class Ejemplo {
	public static void main(String[] args) {
	
		int n = 1;
		int[] tabla = enteros(n);
			
		int a=10/0;
		try {
			System.out.println("Número de elementos: " + tabla.length);
			for (int i = 0; i < n; i++)
				System.out.println("Elemento:"+i+"=>"+ tabla[i]);
		} catch (NullPointerException e) {
			System.out.println("Array fuera de los límites");
		}

		visualizarMedia(4, 5);
		
		System.out.println(parImpar(2014));
			
		System.out.println(Contador1(1,2));
		System.out.println("Fin");
	}
    //
	static String parImpar(int n) {
		String cad = "";
		if (n % 2 == 0)
			cad = "Par";
		else
			cad = "Impar";
		return cad;

	}

	// devuelve un array de n enteros, el array supera unos limites devuelve
	// nulo
	static int[] enteros(int n) {
		if (n < 1 || n > 10)
			return null;
		int[] tabla = new int[n];
		int j = 0;
		for (int i = 10; j < n; i++, j++)
			tabla[j] = i;
		return tabla;
	}
    //
	static void visualizarMedia(float x, float y) {
		float resultado = 0;
		if (x < 0 || y < 0)
			System.out.println("X e Y deben ser positivos");
		else {
			resultado = (x + y) / 2;

			System.out.println("La media es: " + resultado);
		}
	}

	//
	static int Contador1(int x, int y) {
		Scanner entrada = new Scanner(System.in);
		int num, c = 0;
		if (x > 0 && y > 0) {			
			System.out.println("Escribe un número");
			num = entrada.nextInt();			
			if (num >= x && num <= y){ 
					System.out.println("\tNúmero en el rango");
					c++;
			}
			else
		  		    System.out.println("\tNúmero fuera de rango");				
		}
		else
			c = -1;
		entrada.close();
		return c;
	}//

	
	static int Contador2(int x, int y) {
		Scanner entrada = new Scanner(System.in);
		int num, c = 0;
		if (  x > 0   &&   y >   0) {			
			System.out.println("Escribe un número");
			num = entrada.nextInt();
			while (num != 0) {
				
				if (  num >= x  &&   num <= y ) {
					
					System.out.println("\tNúmero en el rango");
					c++;
				} else
					System.out.println("\tNúmero fuera de rango");
				
				System.out.println("Escribe un número");
				num = entrada.nextInt();
				
			}//fin while
		}
		else
			c = -1;	
		entrada.close();
		return c;
	}	
}
