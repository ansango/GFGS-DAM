
public class Main {
	
	public static void main(String[] args) {
		
		DAM_M06_UF2_PAC01 uf2=new DAM_M06_UF2_PAC01();
		//Conectamos a la BD
		uf2.conectar();
		
		//Rellenamos la tabla Clientes y Productos
		uf2.ejercicio2();
		//La inserción de la primera venta fallará al no existir el Producto
		uf2.insertVenta(1, 1, 40, 1);
		//Insertamos dos ventas más, que si són correctas
		uf2.insertVenta(1, 1, 1, 5);
		uf2.insertVenta(2, 1, 2, 10);
		//Mostramos las ventas del cliente 1
		uf2.showVentas(1);
		
		//Desconectamos de la BD
		uf2.desconectar();
	}

}
