
public class matrizAleatorios {

	public static void main(String[] args) {
		

		int[] matrizAle=new int[150];
		
		for(int i=0; i<matrizAle.length; i++) 
		{
			matrizAle[i]=(int)Math.round(Math.random()*100); //round para redondear// y random()*100 pxq va del 0 al 100
		}
		
		for(int numeros:matrizAle) {System.out.println(numeros + " " );}

	}

}
