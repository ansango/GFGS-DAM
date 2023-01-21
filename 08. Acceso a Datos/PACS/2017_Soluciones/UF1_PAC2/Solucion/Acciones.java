import java.io.*;
import java.util.Scanner;

public class Acciones {

     // Propiedades
     Departamento d = new Departamento();
     ConfigurarXML c = new ConfigurarXML();
     
     // Constructor
     public Acciones(){}
     
     // Métodos
     
     private void generarDepartamento(){
          Scanner sc = new Scanner(System.in);
          
          System.out.println("Generador de departamento");
          System.out.println("Escribe NumDepartamento");
          d.setNombre(sc.nextLine());
			System.out.println("Escribe Nombre");
          d.setNombre(sc.nextLine());
          System.out.println("Escribe Localidad");
          d.setEdad(Integer.parseInt(sc.nextLine()));
          sc.close(); // Cierro el scanner
     }
     
     public void escribirDat() throws IOException, ClassNotFoundException{
          File people = new File("departamento.dat");
          
          generarDepartamento();
          // Escribir en fichero
          if(people.exists()){
                EscribirSinCabecera salida = new EscribirSinCabecera(new FileOutputStream("departamento.dat", true));
                d.writeExternal(salida);
               salida.close();
          }
          else{
                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("departamento.dat", true));
                d.writeExternal(salida);
                salida.close();
          }
     }
     
     // Agrego datos al xml conforme voy leyendo
     public void cargarDatEnXML(String ruta) throws IOException, ClassNotFoundException{
          boolean finFichero = false;
          File f = new File(ruta);
          ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("departamento.dat"));
          
          // Machaco el anterior (en caso de que exista) para no duplicar datos
          c.crearXML("Empresa", ruta);
          
          do{
                try{
                     d.readExternal(entrada);
                     c.anadirDOM(d.getNumDepartamento(), String.valueOf(d.getNombre(),d.getLocalidad()), ruta);
                }
                catch(EOFException e){
                     finFichero = true;
                }
          }while(!finFichero);
     }
}