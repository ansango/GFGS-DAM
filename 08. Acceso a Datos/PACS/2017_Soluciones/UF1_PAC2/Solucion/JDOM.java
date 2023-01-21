import java.io.*;

public class Departamento implements Externalizable{

     /* Propiedades*/
     			private int NumDepartamento;
                private String Nombre;
				private String Localidad;
     
     /* Constructor*/
     public Departamento(){}
     
     /* Métodos*/
     			public void set NumDepartamento(int Num){NumDepartamento=Num;}
                public void setNombre (String nom) { nombre=nom;}
                public void setLocalidad (int Loc) {Localidad=Loc;}
                
				public int NumDepartamento(){return NumDepartamento;}
                public String getNombre() {return nombre;}
                public String Localidad() {return Localidad;}
     public void writeExternal(ObjectOutput out) throws IOException{
    	    	  out.writeObject(NumDepartamento);
        	  		out.writeObject(Nombre);
					out.writeObject(Localidad);
     }
     
     public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
          
          	NumDepartamento = (int)in.readObject();
			nombre = (String)in.readObject();
			localidado=(String)in.readObject();
     }
}