import java.io.*;

public class Departamento implements Serializable{

     /* Propiedades*/
     			private int NumDepartamento;
                private String Nombre;
				private String Localidad;
     
     /* Constructor*/
     public Departamento(){}
     public Departamento(int NumDepartamento, String nombre, String localidad){
          this.Nombre=nombre;
          this.Localidad=localidad;
     }
     
     /* Métodos*/
     			public void set NumDepartamento(int Num){NumDepartamento=Num;}
                public void setNombre (String nom) { nombre=nom;}
                public void setLocalidad (int Loc) {Localidad=Loc;}
                
				public int NumDepartamento(){return NumDepartamento;}
                public String getNombre() {return nombre;}
                public String Localidad() {return Localidad;}
     
     public String toString(){
          String resultado = "\t<DEPARTAMENTO>\n" + "\t\t<NumDepartamento>" + NumDepartamento + "</NumDepartamento>\n" + "\t\t<NOMBRE>" + nombre + "</NOMBRE>\n" +  "\t\t<LOCALIDAD>" + localidad + "</LOCALIDAD>\n"+"\t</DEPARTAMENTO>";
          return resultado;
     }
}