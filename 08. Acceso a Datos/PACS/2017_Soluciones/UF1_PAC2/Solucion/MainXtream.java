import java.io.IOException;

public class Main {

     public static void main(String[] args) {
          
          Acciones a = new Acciones();
          
          /*Generar .dat para prueba
           * try{
                a.escribirDat("Departamento.dat");
          }
          catch(ClassNotFoundException e){
                e.printStackTrace();
          }
          catch(IOException e){
                e.printStackTrace();
          }*/
          
          a.datToXML("Departamento.dat", "Departamento.xml");
          a.verXML("Departamento.xml");
     }
}