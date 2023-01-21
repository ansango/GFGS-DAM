public class LlenarPersonas {
  public static void main(String[] args)  {  
   int n=9;     
   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                       "Julio","Antonio","María Jesús"};					   
   int edades[] = {14,15,13,15,16,12,16,14,13};	
   Persona []   tablaPersonas= new Persona [n];
   
   //llenar array
   for (int i = 0; i < n; i++)
	   tablaPersonas[i] = new Persona (nombres[i], edades[i]);   
	    
   //mostrar array
   for (int i = 0; i < n; i++)
	   System.out.println( tablaPersonas[i].getNombre()+ "*"+ tablaPersonas[i].getEdad());   
   }
}//main