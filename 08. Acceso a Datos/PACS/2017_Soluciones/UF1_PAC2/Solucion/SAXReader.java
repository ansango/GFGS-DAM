import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.omg.Messaging.SyncScopeHelper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReader extends DefaultHandler{

     public void leerXML(String ruta){
          try{
                /* Obtengo y configuro el parseador SAX*/
                SAXParserFactory factory = SAXParserFactory.newInstance();
                
                /* Obtengo el objeto del SAX parser*/
                SAXParser sParser = factory.newSAXParser();
                
                /* Manejador por defecto. Los tres métodos se escriben dentro de él*/
                DefaultHandler manejador = new DefaultHandler(){
                     	String NumDepartamentoTag = "close";
						String NombreTag="close"
                     	String localidadTag = "close";
                     
                     /* Abro los elementos para capturar los datos contenidos*/
                     public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
                          System.out.println("<"+qName+">");
                          
                     } /* fin función startElement*/
                     
                     /* Imprime los datos contenidos entre < y >*/
                     public void characters(char ch[], int start, int length) throws SAXException{
                          String contenido = new String(ch, start, length).trim();
                          if (contenido.length() > 0)
                               System.out.println(contenido);
                     } /* Fin función caracteres*/
                     
                     /* Cierro los elementos para dejar de capturar datos*/
                     public void endElement(String uri, String localName, String qName) throws SAXException{
                          System.out.println("</"+qName+">");
                     } /* Fin función endElement*/
                     
                }; /* Fin DefaultHandler*/
                
                sParser.parse(ruta, manejador);
          }
          catch(Exception e){
                e.printStackTrace();
          }
     }
     
}