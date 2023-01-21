import javax.swing.*;
public class matriz2 {

	public static void main(String[] args) 
	{
		// forearch
		
		String [] paises= new String[8];
		
		/*paises[0]="España ";
		paises[1]="Italia";
		paises[2]="UK";
		paises[3]="EEUU";
		paises[4]="Lituania";
		paises[5]="Francia";
		paises[6]="Chile";
		paises[7]="Perú";*/
		
		/*for(int i=0; i<paises.length;i++) 
		{
			System.out.println("Pais " + (i+1) + " " + paises[i]);
		}*/
		
		for(int i=0; i<8;i++) 
		{
			paises[i]=JOptionPane.showInputDialog("Introduce país: " + (i+1));
		}
		
		for(String elemento: paises) //MUY UTIL SIN CASI USA ITERADOR
		{
			System.out.println(elemento);
		}
		
	}

}
