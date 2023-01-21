
package grafico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import VetIlerna.Cliente;

public class Main /*implements ActionListener*/{


	public static void main(String[] args) {
		
		String ruta = "vetIlerna.bin";
		
		//ArrayList<Cliente> clientes = new ArrayList<>();
		
		// comprobamos primero si esta el fichero (si ya existe)
		
		ArrayList<Cliente> clientes = leerEnDiscoBinario(ruta);
		
		
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		
		VentanaDefinitiva v = new VentanaDefinitiva(clientes);
		
		
		
		/*
		 * Antes de cerrar el programa guardamos los datos en el disco
		 * 
		 * */
		
		escribirEnDiscoBinario(clientes, ruta);
			
	}
	
	//Escritura
	
	private static void escribirEnDiscoBinario(ArrayList<Cliente> clientes, String ruta) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream(ruta);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(clientes);
			oos.close();
			
		} 
		
		catch (IOException e) {
			
			System.out.println("ERROR: El fichero no existe");
			e.printStackTrace();
		}
	}
	
	//Lectura
	
	private static ArrayList<Cliente> leerEnDiscoBinario(String ruta)  {

		try(FileInputStream fis = new FileInputStream(ruta);
			ObjectInputStream ois = new ObjectInputStream(fis);
		   )
		/*
		 * Esto es un try con recursos de forma que cuando termina o falla cierra los recursos automaticamente
		 * No necesitamos cerrarlos manualmente
		 * */
		
		{
			return (ArrayList<Cliente>)ois.readObject();
			
		} catch( IOException | ClassNotFoundException e ) {
			
			
			if (e instanceof FileNotFoundException) {
				
			//if (e.getMessage().indexOf("No existe") != -1 ) {
				
				System.out.println("Primera ejecución del programa.");
				
			}else {
				e.printStackTrace();
				
			}			
			
			return null;
			
			
		}
	}
}
