import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;

public class Acciones {

     // Propiedades
     private Departamento d = new Departamento();
     


     public void datToXML(String rutaDAT, String rutaXML){
          try{
                boolean finFichero = false;
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaDAT));
                Vector<Departamento> listado = new Vector<Departamento>();
                
                do{
                     try{
                          d = (Departamento)entrada.readObject();
                          listado.add(d);
                     }
                     catch(EOFException e){
                          finFichero = true;
                     }
                }while(!finFichero);
                
                entrada.close();
                
                XStream xs = new XStream();
                xs.alias("EMPRESAS", Vector.class);
                xs.alias("Departamento", Departamento.class);
                xs.toXML(listado, new FileOutputStream(new File(rutaXML)));
          }
          catch(ClassNotFoundException e){
                e.printStackTrace();
          }
          catch(FileNotFoundException e){
                e.printStackTrace();
          }
          catch(Exception e){
                e.printStackTrace();
          }
     }
     
     public void verXML(String ruta){
          XStream xs = new XStream();
          xs.alias("EMPRESA", Vector.class);
          xs.alias("DEPARTAMENTO", Departamento.class);
          
          Vector<Departamento> listado = (Vector<Departamento>)xs.fromXML(new File(ruta));
          Iterator<Departamento> iterator = listado.listIterator();
          
          System.out.println("<EMPRESA>");
          while(iterator.hasNext()){
                System.out.println(((Departamento)iterator.next()).toString());
          }
          System.out.println("</EMPRESA>");
     }
}