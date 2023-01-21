
import javax.swing.*;
public class Bucles {

	public static void main(String[] args) //Bucle while
	{
		String clave="Anibal";
		
		String pass="";
		
		while (clave.equals(pass)==false) 
		{
			pass=JOptionPane.showInputDialog("Introduce contraseña");
			
			if (clave.equals(pass)==false) 
			{
				System.out.println("Contraseña incorrecta");
			}
		}
		
		System.out.println("Contraseña correcta");

	}

}
