
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Alumni {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile file=null;
		int option = 0;
		

		/* Inicializamos la lectura para el menú y creamos el menú con el condicional do while */

		Scanner typing = new Scanner(System.in);
		do {
			do {
				System.out.println("Elige una opción para continuar:");
				System.out.println("1. Crear fichero");
				System.out.println("2. Introduce alumno");
				System.out.println("3. Modificar asignaturas matriculadas");
				System.out.println("4. Eliminar alumno");
				System.out.println("5. Mostrar datos");
				System.out.println("6. Salir");
				option = typing.nextInt();
				
			}while(option<1 || option>6);
			
 		/* Utlizaremos switch para abordar los casos del menú que dirigiremos a las funciones correspondientes, listadas a continuación*/

			switch (option) {
			case 1:
				file = createFile(".\\alumnos.dat");
				break;
			case 2:
				createAlumn(file);
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
			}
			
		}while(option!=6);
        typing.close();
	}
	
	
	/* 1 - Creamos el fichero con el nombre de "alumnos.dat". */
	
	public static RandomAccessFile createFile(String file) throws FileNotFoundException {
		File fichero = new File(file);
		return new RandomAccessFile(fichero,"rw" );
	}
	
	/* 2 - Introducimos un alumno. */
		
	public static boolean createAlumn(RandomAccessFile file) throws IOException {
		Scanner scan = new Scanner(System.in);
		int id = 0, course= 0, position;
		String name;
		
		position = (id - 1) * 48;
		
		System.out.println("Introduce un nombre (Máximo 25 caracteres): ");
		name = scan.next();
		
		if (name.length()>25) name = name.substring(0, 25);
		System.out.println("Introduce un número (entero) de asignaturas: ");
		course = scan.nextInt();
		
		try {
			file.seek(position);
			file.writeInt(id);
			
			StringBuffer buffer = new StringBuffer(name);
			buffer.setLength(25);
			file.writeChars(buffer.toString());
			file.writeInt(course);
			return true;
			
		} catch (IOException exception) {
			return false;
		}
		
	}
	
	/* 3 - Modificamos el número de asignaturas matriculadas. */
	
	public static void alterData(RandomAccessFile file) throws IOException {
		Scanner scan = new Scanner(System.in);
		int id, course;
		
		System.out.println("Introduce el id del alumno a modificar: ");
		id = scan.nextInt();
		
		System.out.println("Introduce el nuevo número (entero) de alumnos: ");
		course = scan.nextInt();
		
		int position = 0;
		position = (id - 1) * 48;
		
		if(position >= file.length()) {
			System.out.println("La asignatura introducida no existe.");
		} else {
			file.seek(position + 24);
			file.writeInt(course);
			file.close();
			System.out.println("Cambios realizados con éxito");
		}
	}
	
	/* 4 - Eliminamos un alumno. */
	
	public static void deleteData(RandomAccessFile file) throws IOException {
		Scanner scan = new Scanner(System.in);
		int id ;
		
		System.out.println("Introduce el id del alumno a modificar: ");
		id = scan.nextInt();
		
		int position = 0;
		position = (id - 1) * 48;
		
		if (position > file.length()) {
			System.out.println("La asignatura introducida no existe.");
		} else {
			file.seek(position);
			file.writeInt(0);
			file.writeChars("");
			file.writeInt(0);
			System.out.println("Eliminación realizada");
		}
	}
	
	/* 5 - Mostramos los datos. */
	
	public static void showData(RandomAccessFile randomFile) throws IOException{
		String name = "";
		int position=0, id , alumns;
		char ch;
		
		if(randomFile.length()>0)
		{
			while(true){
				randomFile.seek(position);
				
				id = randomFile.readInt();
				
				if(id == ((position/48)+1))
				{
					//Leemos la cadena
					for(int i=0;i<20;i++){
						ch = randomFile.readChar();
						if((int)ch>0 && (int)ch<128)
							name +=ch;
					}
					alumns = randomFile.readInt();			
					System.out.println("id: " + id + " Nombre: "+ name +" Alumnos: "+ alumns);
					name = "";
				}
				position += 48;
				if(position == randomFile.length()) break;
			}
		}
		
	}
	
	/* 6 - Salimos del programa. */
}

