import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/*
 * Esta clase es la encargada de operar con la BBDD a traves de hibernate
 */
public class Controller {
	Configuration configuration; 
	SessionFactory sf; //Usamos el patron factoria para las sesiones
	Session ss;
	
	public Controller(){
		//Inicializamos las variables
		configuration=new Configuration();  
		configuration.configure();  
		sf=configuration.buildSessionFactory();  
		
	}
	
	/*
	 * Crea un departamento nuevo en la BBDD
	 */
	public void createDepartamento(int num, String nombre, String localidad){
		//Creamos un objeto de tipo departamento
		Departamentos dp= new Departamentos();
		dp.setLocalidaddep(localidad);
		dp.setNombredep(nombre);
		dp.setNumerodep((byte)num);
		
		//Creamos una sesión a partir del SessionFactory
		ss=sf.openSession();  
		//Usamos la sesión para realizar la operación, en este caso de un insert
		ss.beginTransaction();  	
		ss.save(dp);  //CREA
		ss.getTransaction().commit();  //Hacemos el commit para fijar la operación
		ss.close(); //Cerramos la sesión
		
		//Este procedimiento se repite en borrar y modificar cambiando la operación
	}
	public void closeSession(){
		
		if(ss!=null){
			if(ss.getTransaction()!=null)ss.getTransaction().rollback();
			ss.close(); 
		}
		
	}
	
	/*
	 * Borra un departamento de la BBDD
	 */
	public void deleteDepartamento(int num){
		Departamentos dp= new Departamentos();
		dp.setNumerodep((byte)num);
		ss=sf.openSession();  
		ss.beginTransaction();  	
		ss.delete(dp);  //BORRA
		ss.getTransaction().commit(); 
		ss.close();
	}
	
	/*
	 * Modifica un departamento
	 */
	public void alterDepartamento(int num, String nombre, String localidad){
		Departamentos dp= new Departamentos();
		dp.setLocalidaddep(localidad);
		dp.setNombredep(nombre);
		dp.setNumerodep((byte)num);
		ss=sf.openSession();  
		ss.beginTransaction();  
		ss.update(dp); //MODIFICA
		ss.getTransaction().commit(); 
		ss.close();
	}


	

}
