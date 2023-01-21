import java.io.IOException;
     
public class main {
     public static void main(String[] args) {
          JDOMtoXML j = new JDOMtoXML();
                
          try{
                j.generarXML("departamento.dat", "departamento.xml");
               j.leerXML("departamento.xml");
          }
          catch(IOException e){
                e.printStackTrace();
          }
          catch(ClassNotFoundException e){
               e.printStackTrace();
          }
     }

}


 