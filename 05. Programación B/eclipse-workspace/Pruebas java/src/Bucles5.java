import javax.swing.JOptionPane;

public class Bucles5 {

	public static void main(String[] args) {
		
		int resultado=1;
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Dame un numero"));
		
		for(int i=numero;i>0;i--) 
		{
			resultado= resultado*i;
		}
		System.out.println("El factorial de " + numero + " es " + resultado );
	}

}
