		
public class triangulo 
{
	public static void main(String[] args) 
	{
		double numeros[]= {25.0,56.5,32.2,23.4,67.3,43.1,56.0,34.4,56.5};
		double suma=0;
		for(int i=0;i>numeros.length;i++) 
		{
			suma+=numeros[i];
			System.out.println("La media es = " + suma/numeros.length);
		}
	}
}
