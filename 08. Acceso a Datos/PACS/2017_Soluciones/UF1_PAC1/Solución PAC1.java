import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class DAM_M06_UF1_PAC01 {


	public static void main(String[] args) throws IOException {
		RandomAccessFile file=null;
		int op=0;
		Scanner keyboard = new Scanner(System.in);
		do{
			do{
				System.out.println("\n\n");
				System.out.println("1. Crear fichero binario vacio");
				System.out.println("2. Introducir modulo");
				System.out.println("3. Modificar número de alumnos");
				System.out.println("4. Eliminar módulo");
				System.out.println("5. Mostrar datos");
				System.out.println("6. Salir");
				System.out.print("Selecciona opción: ");
				op=keyboard.nextInt();
				System.out.println("\n\n");
			}while(op<1 || op>6);
			
			switch (op) {
			case 1:
				file=createFile(".\\ilerna2.dat");
				break;
			case 2:
				createModulo(file);
				break;
			case 3:
				alterData(file);
				break;
			case 4:
				deleteData(file);
				break;
			case 5:
				showData(file);
				break;		
			case 6:
				file.close();
				break;
	
			default:
				break;
			}	
		}while(op!=6);	
		//keyboard.close();
	}
	/*
	 * Función de creación/apertura del archivo
	 * 		
	 */
	public static RandomAccessFile createFile(String file) throws FileNotFoundException{
		//Creamos un fichero en la ruta que pasamos por parametro.
		File fichero=new File(file);
		
		//Creamos y retornamos un nuevo fichero de acceso aleatorio generado a partir del fichero anterior
		return new RandomAccessFile(fichero, "rw");
		
	}
	
	/*
	 * Esta función nos permite agregar nuevos módulos
	 * 
	 */
	public static boolean createModulo(RandomAccessFile file) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		int modulo, alumnos, posicion;
		String nombre;

		//Leemos por teclado los datos del nuevo módulo

		System.out.println("Introduce el ID del módulo (un número entero mayor que 0)");
		modulo=keyboard.nextInt();
		
		
		posicion=(modulo-1)*48;
		
		System.out.println("Introduce nombre (String)(20 Caracteres Max)");
		nombre=keyboard.next();
		//Para evitarnos problemas en caso que nos ponga un nombre de módulo mayor de 20 carácteres
		//si es mayor de 20, nos quedamos únicamente con los 20 primeros
        if(nombre.length()>20)
			nombre=nombre.substring(0,20);
		
		System.out.println("Introduce numero de alumnos (int)");
		alumnos=keyboard.nextInt();
		
		try {
			file.seek(posicion); //Como queremos añadir el nuevo registro al final del fichero, situamos el puntero en la última posición posible			
			file.writeInt(modulo);//Escribimos el entero que hemos leido por teclado
			/*
			 * Para el caso de las cadenas debemos 
			 * usar un StringBuffer para poder 
			 * escribirlas en el fichero
			 */
			StringBuffer buffer=new StringBuffer(nombre); //Creamos el StringBuilder a partir del String que habiamos leido por teclado
			buffer.setLength(20); //Establecemos la longitud IMPORTANTE--> TODAS LAS CADENAS DEBEN TENER EL MISMO TAMAÑO.
			file.writeChars(buffer.toString()); //Escribimos la cadena en el archivo
			file.writeInt(alumnos); //Escribimos el número de alumnos en el fichero.
			return true;
		} catch (IOException e) {
			return false;
		}		
	}
	/*
	 * Esta función es la encargada de modificar el numero de alumnos de un modulo dado.
	 */
	public static boolean alterData(RandomAccessFile file) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		int modulo, nuevoNumero;
		System.out.println("Introduzca el numero del modulo que desea modificar");
		modulo=keyboard.nextInt();		
		System.out.println("Introduzca el nuevo número de alumnos");		
		nuevoNumero=keyboard.nextInt();
			
		int posicion=0;
		//Para situarnos en el registro que queremos realizamos la siguiente operacion.
		posicion=(modulo -1)*48;
		
		if(posicion>=file.length()){
			System.out.println("El módulo solicitado no exite");
			return false;
		}else{
			//Si no existe el módulo, lo indicamos y no hacemos nada más
			file.seek(posicion);
			if(file.readInt()!=modulo)
			{	
				System.out.println("El módulo solicitado no exite");
				return false;
			}
			//Sino, modificamos el núm de alumnos del módulo
			posicion+=44;
			file.seek(posicion);
			file.writeInt(nuevoNumero);
		}
		return true;		
	}
	
	public static boolean deleteData(RandomAccessFile file) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		
		int posicion=0, modulo;
		System.out.println("Introduzca el numero del modulo que desea borrar");
		modulo=keyboard.nextInt();	
		

		//Para situarnos en el registro que queremos realizamos la siguiente operacion.
		posicion=(modulo-1)*48;

		if(posicion>=file.length()){
			System.out.println("El módulo solicitado no exite");
			return false;
		}else{
			//Para borrar pongo a 0 el id, a espacios el string y a 0 el num de alumnos
			file.seek(posicion);
			file.writeInt(0);
			String nombre="                   ";
			StringBuffer buffer=new StringBuffer(nombre); //Creamos el StringBuilder a partir de
														  //un string de 20 caracteres vacio para asegurarnos de borrar lo que pudiese haber antes
			buffer.setLength(20); //Establecemos la longitud IMPORTANTE--> TODAS LAS CADENAS DEBEN TENER EL MISMO TAMAÑO.
			file.writeChars(buffer.toString()); //Escribimos la cadena en el archivo
			file.writeInt(0);
		}
		return true;		
				
	}
	
	
	/*
	 * Esta función muestra toda la información de nuestro fichero
	 */
	public static void showData(RandomAccessFile randomFichero) throws IOException{
		String nombre_ = "";
		int posicion=0, modulo_,alumnos_;
		char ch;
		boolean seguir_leyendo = true;
		
		if(randomFichero.length()>0)
		{
			while(true){
				randomFichero.seek(posicion);
				//Leemos primer entero
				modulo_=randomFichero.readInt();
				//Comprobamos si hay algo escrito en este registro
				if(modulo_==((posicion/48)+1))
				{
					//Leemos la cadena
					for(int i=0;i<20;i++){
						ch=randomFichero.readChar();
						if((int)ch>0 && (int)ch<128)
							nombre_+=ch;
					}
					alumnos_=randomFichero.readInt();			
					System.out.println("ID: " +modulo_+" NOMBRE: "+nombre_+" ALUMNOS: "+alumnos_);
					nombre_="";
				}
				posicion+=48;
				if(posicion==randomFichero.length()) break;
			}
		}
		
	}
	
	


}