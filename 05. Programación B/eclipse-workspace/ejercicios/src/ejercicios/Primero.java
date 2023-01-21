package ejercicios;

public class Primero {

	public static void main(String[] args) {
		double a,b,c;
		double x1,x2,d;
		
		System.out.println("introduce el primer coeficiente (a):");
		a=Entrada.entero();
		System.out.println("introduce el segundo coeficiente (b):");
		b=Entrada.entero();
		System.out.println("introduce el tercer coeficiente (c):");
		c=Entrada.entero();
		
		d = ((b*b))-4*a*c;
		
		if(d<0) System.out.println("no hay soluciones");
		else {
			x1=(-b+Math.sqrt(d))/(2*a);
			x2=(-b-Math.sqrt(d))/(2*a);
			
		}

	}

}
