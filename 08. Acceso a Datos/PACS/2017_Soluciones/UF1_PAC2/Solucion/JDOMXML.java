import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMtoXML {

     public void generarXML(String nombreDAT, String nombreXML) throws IOException, ClassNotFoundException{
          boolean finFichero = false;
          Departamento d = new Departamento();
          ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreDAT));
          Element raiz = new Element("EMPRESA");
          Document doc = new Document();
          
          doc.setRootElement(raiz);
          do{
                try{
                     d.readExternal(entrada);
                     Element empresa = new Element("DEPARTAMENTO");
						empresa.addContent(new Element("NUMDEPARTAMENTO").setText(String.valueOf(d.getNumDepartamento()));
                     	empresa.addContent(new Element("NOMBRE").setText(d.getNombre()));
                     	empresa.addContent(new Element("LOCALIDAD").setText((d.getLocalidad()));
                     	doc.getRootElement().addContent(empresa);
                }
                catch(EOFException e){
                     finFichero = true;
                }
          }while(!finFichero); /* Dejo de recorrer el fichero .dat*/
          
          XMLOutputter x = new XMLOutputter();
          x.setFormat(Format.getPrettyFormat());
          x.output(doc, new FileWriter(nombreXML));
          System.out.println("Fichero generado correctamente");
     }
     
     public void leerXML(String ruta){
          SAXBuilder b = new SAXBuilder();
          File x = new File(ruta);
          
          try{
                /* Creo el document*/
                Document d = (Document)b.build(x);
                
                /* Leo la raíz*/
                Element raiz = d.getRootElement();
                
                /* Obtengo listado de los hijos*/
                List listaHijos = raiz.getChildren("DEPARTAMENTO");
                
                System.out.println(NUMDEPARTAMENTO + "\t\t" +NOMBRE+"\t\t"+LOCALIDAD);
                System.out.println("---------------------");
                for(int i = 0; i < listaHijos.size(); i++){
                     /* Obtengo el elemento persona*/
                     Element departamento = (Element)listaHijos.get(i);
						String NumDepartamento=departamento.getChildTextTrim("NUMDEPARTAMENTO");
                     String nombre = departamento.getChildTextTrim("NOMBRE");
                     String edad = departamento.getChildTextTrim("LOCALIDAD");
                     
                     System.out.println(NumDepartamento + "\t\t" +nombre+"\t\t"+localidad);                   
                }
          }
          catch(IOException e){
                e.printStackTrace();
          }
          catch(JDOMException e){
                e.printStackTrace();
          }
     }
}
