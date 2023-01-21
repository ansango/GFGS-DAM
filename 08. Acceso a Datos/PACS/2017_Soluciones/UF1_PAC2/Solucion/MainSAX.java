import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

     public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

          SAXReader gestor = new SAXReader();
          gestor.leerXML("Departamento.xml");
     }

}
