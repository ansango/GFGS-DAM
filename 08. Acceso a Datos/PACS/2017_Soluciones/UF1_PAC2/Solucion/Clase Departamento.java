import java.io.Serializable;
public class Departamento  {
                private int NumDepartamento;
                private String Nombre;
				private String Localidad;
                public Departamento(int NumDepartamento, String Nombre, String Localidad) {
                               this.Nombre=nombre;
                               this.Localidad=localidad;
                               
                }
                public Departamento(){
                               
								this.Nombre=null;
								this.Localidad=null;
                }
				public void set NumDepartamento(int Num){NumDepartamento=Num;}
                public void setNombre (String nom) { nombre=nom;}
                public void setLocalidad (int Loc) {Localidad=Loc;}
                
				public int NumDepartamento(){return NumDepartamento;}
                public String getNombre() {return nombre;}
                public String Localidad() {return Localidad;}

} 