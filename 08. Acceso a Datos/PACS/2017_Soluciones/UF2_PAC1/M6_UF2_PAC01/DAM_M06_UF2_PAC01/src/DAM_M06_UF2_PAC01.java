import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DAM_M06_UF2_PAC01 {

	/*
	 * Esta clase es la encargada de insertar y 
	 * visualizar los datos de las tablas clientes y productos
	 */
	
	 /*
	  * ######################################################################################
	  * ################################ Código común  #######################################
	  * ######################################################################################
	  */
	
	//Establecemos el conector que usaremos y la BBDD
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/ud2";

	   //Usuario y Password de la BBDD
	   static final String USER = "ejemplo";
	   static final String PASS = "ejemplo";
	   static Connection conn = null;
	   static Statement stmt = null;
	   
	   //Función encargada de establecer la conexión
	   public void conectar(){
		   try {
			   //Registramos el JDBC
			   Class.forName("com.mysql.jdbc.Driver");
			   //Abrimos la conexión
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   } catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }	      
	   }
	   
	   //Función encargada de cerrar la conexión
	   public void desconectar(){
		   try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		  
	   }
	   
	   /*
	    * ######################################################################################
	    * ################################ EJERCICIO 2 #########################################
	    * ######################################################################################
	    */
	   public void ejercicio2() {	   
	   try{	  	   
	      //Vamos a insertar algunos clientes y productos en la BBDD.
	      //PRODUCTOS
	      insertProduto("Monitor",45,20,200);
	      insertProduto("Procesaor", 20, 10, 145);
	      insertProduto("Teclado", 22, 20, 43);	      
	      //CLIENTES	
	      insertCliente("Pepe", "Calle Falsa", "Lleida", "555121212", "00000000F");
	      insertCliente("Juan", "Calle JC", "Madrid", "555343434", "111111111F");
	      insertCliente("Maria", "Calle Felipe VI", "Barcelona", "5555676767", "2222222F");
	      insertCliente("Marta", "Calle del Suspiro Verde", "Albacete", "555232323", "4444444F");	      
	      //Mostramos los datos introducidos
	      showClientes();
	      System.out.println("------------------------------------------------------------");
	      System.out.println("");
	      showProductos();	     
	   }catch(Exception e){	     
	      e.printStackTrace();	   
	   }	  
	}
	   
	   /*
	    * Esta función es la engargada de insertar registros en la tabla productos
	    */
	   public static boolean insertProduto(String des, int stockA, int stockM, float pvp){
		   try {
			   stmt = conn.createStatement();	//Creamos una nueva sentencia sql		   
			   String sql;
			   sql = "insert into productos (productos.Descripcion, productos.StockActual, productos.StockMinimo, productos.PVP) values('"+des+"',"+stockA+","+stockM+","+pvp+");";
			   int result= stmt.executeUpdate(sql); //La ejecutamos y registramos en un int para saber si ha sido exitoso.
			   stmt.close();
			   if(result>0) return true;
			   else return false;
		   } catch (SQLException e) {
			   return false;
		   }	  
	   } 
	   
	   /*
	    * Esta función es la engargada de insertar registros en la tabla clientes
	    */
	   public static boolean insertCliente(String nombre, String direc, String pobla, String telef, String nif){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   sql = "insert into clientes (clientes.Nombre, clientes.Direccion, clientes.Poblacion, clientes.Telef, clientes.Nif) values('"+nombre+"','"+direc+"','"+pobla+"','"+telef+"','"+nif+"');";
			   int result= stmt.executeUpdate(sql);
			   stmt.close();
			   if(result>0) return true;
			   else return false;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return false;
		   }	  
	   } 
	   
	   /*
	    * Esta función muestra el contenido de la tabla clientes
	    */
	   public static void showClientes(){
		   try {
			   //Creamos la sentencia sql
			   stmt = conn.createStatement();
			   String sql;
			   sql = "SELECT * FROM Clientes";
			   ResultSet rs = stmt.executeQuery(sql); //Registramos el resultado en un resultSet
			   int count=0;
			   //Recorremos el resultSet 
			   while(rs.next()){	
				   count ++;
				   //Vamos obteniendo el contenido de cada row
				   int id  = rs.getInt("ID");
				   String nombre = rs.getString("Nombre");	
				   String direc = rs.getString("Direccion");	
				   String local = rs.getString("Poblacion");	
				   String tele = rs.getString("Telef");
				   String nif = rs.getString("Nif");	
				   
				   //Finalmente lo mostramos
				   System.out.println("ID: "+id+" Nombre: "+nombre+" Dir.: "+direc+" Local.: "+local+" Telf.: "+tele+" NIF: "+ nif);				  	        
			   }
			   stmt.close();
			   System.out.println("CLIENTES: "+count);
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   
	   /*
	    * Esta función muestra el contenido de la tabla productos
	    */
	   public static void showProductos(){
		   try {
			   stmt = conn.createStatement();
			   String sql;
			   sql = "SELECT * FROM Productos";
			   ResultSet rs = stmt.executeQuery(sql);
			   int count=0;
			   while(rs.next()){	
				   count ++;
				   int id  = rs.getInt("ID");
				   String desc = rs.getString("Descripcion");	
				   int sa  = rs.getInt("StockActual");
				   int sm  = rs.getInt("StockMinimo");
				   int pvp  = rs.getInt("pvp");
				   System.out.println("ID: "+id+" Desc: "+desc+" StockA: "+sa+" StockM: "+sm+" PVP: "+pvp);				  	        
			   }
			   stmt.close();
			   System.out.println("PRODUCTOS: "+count);
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }		   
	   }
	   /*
	    * ######################################################################################
	    * ################################ EJERCICIO 3 #########################################
	    * ######################################################################################
	    */
	   
	   //Creamos funciones para comprobar si existen registros en cada una de las tablas. 
	   public static boolean clienteExiste(int id){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   boolean existe = false;
			   sql = "select * from clientes where id="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.last();
			   if(result.getRow()>0)
				   existe=true;
			   else{
				   System.out.println("No existe cliente");
				   existe = false;			 
			   }
			   stmt.close();
			   return existe;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return false;
		   }
	   }
	   public static boolean productoExiste(int id){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   boolean existe = false;
			   sql = "select * from productos where id="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.last();
			   if(result.getRow()>0)
				   existe = true;
			   else{
				   System.out.println("No existe el producto");
				   existe = false;			 
			   }
			   stmt.close();
			   return existe;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return false;
		   }
	   }
	   
	   public static boolean ventaExiste(int id){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   boolean existe = true;
			   sql = "select * from ventas where IDVenta="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.last();
			   if(result.getRow()>0){
				   System.out.println("El número de venta ya está registrado");
				   existe = true;
			   }
			   else{
				   existe = false;			 
			   }
			   stmt.close();
			   return existe;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return false;
		   }
	   }
	   
	   //Creamos una función para comprobar si hay stock de un producto determinado.
	   public static boolean comprobarStock(int id, int requerido){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   boolean existe = false;
			   sql = "select * from productos where id="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.next();
			   int sa  = result.getInt("StockActual");
			   int sm  = result.getInt("StockMinimo");
			   int disponibles=sa-sm;
			   if(disponibles>=requerido)
				   existe = true;
			   else{
				   System.out.println("No hay suficiente Stock");
				   existe = false;			 
			   }
			   stmt.close();
			   return existe;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return false;
		   }		  
	   }
	   
	   //Esta función es la encargada de registrar filas en la tabla ventas
	   public boolean insertVenta(int iD, int iD_Cliente, int iD_Producto, int cantidad){
		   if(clienteExiste(iD_Cliente) && productoExiste(iD_Producto)&& !ventaExiste(iD) && comprobarStock(iD_Producto, cantidad)){
			   try {
				   //Obtenemos la fecha actual
				   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				   Calendar cal = Calendar.getInstance();
				   
				   //Creamos la sentencia
				   stmt = conn.createStatement();			   
				   boolean venta_ok = false;
				   String sql;
				   sql = "insert into ventas (ventas.IDVenta, ventas.FechaVenta, ventas.IDCliente, ventas.IDProducto, ventas.Cantidad) values('"+iD+"','"+dateFormat.format(cal.getTime())+"','"+iD_Cliente+"','"+iD_Producto+"','"+cantidad+"');";
				   //La ejecutamos
				   int result= stmt.executeUpdate(sql);
				   if(result>0){
					   System.out.println("Venta insertada con exito");
					   venta_ok = true;
				   }
				   else{
					   System.out.println("Error al insertar la venta");
					   venta_ok = false;
				   }
				   stmt.close();
				   return venta_ok;
			   } catch (SQLException e) {
				   e.printStackTrace();
				   return false;
			   }	  
		   }
		   return false;
	   }
	   
	   /*
	    * ######################################################################################
	    * ################################ EJERCICIO 4 #########################################
	    * ######################################################################################
	    */
	   
	   //Función que muestra las ventas formateadas como se piden en el ejercicio
	   public void showVentas(int idcliente){
		   try {
			   stmt = conn.createStatement();
			   String sql;
			   sql="Select nombre from clientes where ID=" + idcliente;
			   ResultSet sr=stmt.executeQuery(sql);
			   sr.last();
			   String nombre=sr.getString("Nombre");
			   sql = "SELECT * FROM Ventas WHERE IDCliente=" + idcliente;
			   ResultSet rs = stmt.executeQuery(sql);
			   int count=0;
			   float importe=0, importeTotal=0;
			   System.out.println("Ventas del cliente: " +nombre);
			   while(rs.next()){	
				   count ++;
				   int id  = rs.getInt("IDVenta");
				   int idProducto=rs.getInt("IDProducto");
				   int cantidad=rs.getInt("Cantidad");
				   System.out.println("Venta "+id);
				   System.out.println("\t Producto "+ getDesc( idProducto));
				   System.out.println("\t Cantidad: "+ cantidad);
				   importe=cantidad*getPvp(idProducto);
				   importeTotal+=importe;
				   System.out.println("\t Importe: "+importe);			  	        
			   }
			   stmt.close();
			   System.out.println("Número total de Ventas: "+count);
			   System.out.println("Importe total: "+ importeTotal);
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }		   
	   }
	   
	   //Devuelve el PVP de un determinado producto
	   public static float getPvp(int id){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   sql = "select * from productos where id="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.next();
			   float pvp  = result.getInt("pvp");
			   stmt.close();
			   return pvp;
			 
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return 0;	
			  
		   }
			   
	   }
	   
	   //Devuelve la descripción de un determinado producto
	   public static String getDesc(int id){
		   try {
			   stmt = conn.createStatement();			   
			   String sql;
			   sql = "select * from productos where id="+id+";";
			   ResultSet result= stmt.executeQuery(sql);
			   result.next();
			   String desc  = result.getString("Descripcion");
			   stmt.close();
			   return desc;
			 
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return "";
		   }
			   
	   }
	   
	   
}
