import java.io.*;

public class EscribirSinCabecera extends ObjectOutputStream{

     // Constructor
     public EscribirSinCabecera(OutputStream out) throws IOException{
          super(out);
     }
          
     public EscribirSinCabecera() throws IOException, SecurityException{
          super();
     }
          
     /* Métodos*/
     /*
      * (non-Javadoc)
      * @see java.io.ObjectOutputStream#writeStreamHeader()
      * 
      * Redefino el método de escribir la cabecera para que no haga nada
      */
     protected void writeStreamHeader() throws IOException{}
}