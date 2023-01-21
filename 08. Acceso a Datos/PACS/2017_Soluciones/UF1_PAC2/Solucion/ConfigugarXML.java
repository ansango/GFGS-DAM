import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.*;
import javax.xml.transform.*;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.w3c.dom.DOMImplementation;

public class ConfigurarXML {

     /* Propiedades*/
     Document doc = null;
     
     /* Métodos*/
     
     /* Genero un XML cargando la raíz en él*/
     public void crearXML(String raiz, String ruta){
          try{
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementacion = builder.getDOMImplementation();
                doc = implementacion.createDocument(null, raiz, null);
                doc.setXmlVersion("1.0");
                Source source = new DOMSource(doc);
                Result result = new StreamResult(new java.io.File(ruta));
                guardarCambiosXML(source, result);
          }
          catch(Exception e){
                e.printStackTrace();
          }
     }
     
     public int anadirDOM(String nombre, String edad, String ruta){
          try{
                Node nNombre = doc.createElement("Nombre");
                Node nNombreTexto = doc.createTextNode(nombre);
                nNombre.appendChild(nNombreTexto);
                Node nEdad = doc.createElement("Edad");
                Node nEdadTexto = doc.createTextNode(edad);
                nEdad.appendChild(nEdadTexto);
                
                Node nPersona = doc.createElement("Persona");
                nPersona.appendChild(nNombre);
                nPersona.appendChild(nEdad);
                
                Node raiz = doc.getChildNodes().item(0);
                raiz.appendChild(nPersona);
                
                Source source = new DOMSource(doc);
                Result result = new StreamResult(new java.io.File(ruta));
                guardarCambiosXML(source, result);
                return 0;
          }
          catch(Exception e){
                e.printStackTrace();
                return -1;
          }
     }
     
     /* Convierte el Document a fichero XML*/
     public void guardarCambiosXML(Source fuente, Result salida){
          try{
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.transform(fuente, salida);
          }
          catch(Exception e){
                e.printStackTrace();
          }    
     }
     
     public String leerXML(String ruta){
          File archivo = new File(ruta);
          abrirDoc(archivo);
          String datosNodo[] = null;
          String salida = "";
          Node n;
          
          /* Obtengo el primer hijo del DOM*/
          Node raiz = doc.getFirstChild();
          /* Listo todos los nodos hijos de raiz*/
          NodeList listado = raiz.getChildNodes();
          
          for(int i = 0; i < listado.getLength(); i++){
                n = listado.item(i);
                datosNodo = procesarDepartamento(n);
                salida = salida + "NumDepartamento: " + datosNodo[0];
                salida = salida + "\n" + "Nombre: " + datosNodo[1];
				salida = salida + "\n" + "Localidad " + datosNodo[2];
                salida = salida + "\n\n";
          }
          
          return salida;
     }
     
     protected String[] procesarDeparamento(Node n){
          String datos[] = new String[3];
          Node tmp = null;
          int contador = 0;
          
          /* Hijos del libro*/
          NodeList nodos = n.getChildNodes();
          for(int i = 0; i < nodos.getLength(); i++){
               tmp = nodos.item(i);
                
                if (tmp.getNodeType() == Node.ELEMENT_NODE){
                     /* Accedo al noto TEXT hijo de tmp para obtener nombre y edad*/
                     datos[contador] = tmp.getChildNodes().item(0).getNodeValue();
                     contador++;
                }
          }
          
          return datos;
     }
     
     protected void abrirDoc(File f){
          doc = null;
          
          try{
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setIgnoringComments(true); /* No contempla comentarios*/
                factory.setIgnoringElementContentWhitespace(true); /* Ignoro los espacios en blanco*/
                DocumentBuilder b = factory.newDocumentBuilder();
                doc = b.parse(f);
          }
          catch(Exception e){
                e.printStackTrace();
          }
     }
}