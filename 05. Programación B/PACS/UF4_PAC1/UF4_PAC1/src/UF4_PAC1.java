import java.util.Scanner;
public class UF4_PAC1 {

	public static void main (String [] args) {
		
		Scanner sc= new Scanner(System.in);
		int num1, num2;
		int factorial=1;
		
				
		System.out.print("Introduce numero 1: ");
		num1 = sc.nextInt();
		
		int aux=num1;
		
		System.out.print("Introduce numero 2: ");
		num2 = sc.nextInt();
		
		if (num1 > num2) {System.out.println("El numero mayor es: " + num1);}
		else {System.out.println("El numero mayor es:" + num2);}
		
		while (aux!=0) {
			factorial=factorial*aux;
			aux--;
			}
		System.out.println("El factorial del numero 1 es: " + factorial );
	}	
}
