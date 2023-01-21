package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que nos permite conectarnos a la BBDD y cerrar los elementos que actúan sobre ella
 * 
 * 
 *
 */
public class UtilidadesBBDD {

	//Declaramos las constantes para la cadena de conexión, las password no la pondríamos
	//aquí directamente y buscaríamos una forma de almacenarla segura y no visible, pero
	//para las prácticas lo hacemos así.
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/sorteo";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "pitufina";
	
	//Creamos un objeto para el control de errores
	ControlErrores msjErr = new ControlErrores();
	
	/**
	 * Método que crea una conexión a la Base de datos
	 * 
	 * 
	 * 
	 * @return
	 */
	public Connection conexionBBDD()
	{
		//Declaramos una variable para la cadena de conexión
		Connection conec=null;
		
		//Controlamos las excepciones que aparecen al interactuar con la BBDD
		try
		{
			//Registrar el driver
			Class.forName(DRIVER);
			//Crear una conexión a la Base de Datos
			conec = DriverManager.getConnection(BBDD, USUARIO, PASSWORD);
			
		}
		catch (Exception errores)
		{
			//Control de errores de la conexión a la BBDD
			msjErr.mensajeError("Se ha producido un error al conectar con la Base de Datos.\n"+
					errores.toString());
		}
		
		return conec;
	}
	
	/**
	 * Creamos un método cerrarConexion que sobrecargamos para poder cerrar todas las conexiones
	 * con la BBDD y las tablas
	 * 
	 * @param conexion
	 */
	public void cerrarConexion(Connection conexion)
	{
		try
		{
			//Cierre de conexión
			conexion.close();
		}
		catch (SQLException e)
		{
			//Controlamos excepción que se pueda producir al cierre de la conexión
			msjErr.mensajeError("Se ha producido un error al conectar con la Base de Datos.\n"+
					e.toString());
		}
	}
	
	/**
	 * Método para cerrar el resulset
	 * 
	 * @param conexion
	 */
	public void cerrarConexion(ResultSet conexion)
	{
		try
		{
			//Cerramos el resultset
			conexion.close();
		}
		catch (SQLException e)
		{
			//Controlamos excepción que se pueda producir
			msjErr.mensajeError("Se ha producido un error al conectar con la Base de Datos.\n"+
					e.toString());
		}
	}
	
	/**
	 * Cerramos la apertura de sentencia para actuar sobre la tabla
	 * 
	 * @param conexion
	 */
	public void cerrarConexion(Statement conexion)
	{
		try
		{
			//Cerramos la sentencia
			conexion.close();
		}
		catch (SQLException e)
		{
			//Controlamos excepción que se pueda producir
			msjErr.mensajeError("Se ha producido un error al conectar con la Base de Datos.\n"+
					e.toString());
		}
	}
}
