import java.util.*;
public class Bucles2 {

	public static void main(String[] args)  //Adivinar numero , metodo random
	{
		
		int aleatorio = (int)(Math.random()*100);
		
		Scanner entrada = new Scanner(System.in);
		int numero=0;
		int intentos=0;
		
		/* do */while (numero!=aleatorio) 
		{
			intentos++;
			System.out.println("dame numero");
			numero= entrada.nextInt();
			
			if(aleatorio<numero) 
			{
				System.out.println("Más bajo");
			}
			else if (aleatorio>numero) 
			{
				System.out.println("Más alto");
			}
			
		} /* while (numero!=aleatorio) */
		System.out.println("Correcto. lo has logrado en " + intentos + " intentos");
		

	}

}
