import java.math.BigDecimal;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import MisBeans.Pedido;
import MisBeans.Producto;
import MisBeans.Venta;

public class LlenarVentas_v2 {
	public static void main(String[] args){
		
		//Comprobamos que tenga los argumentso necesarios (idproducto y cantidad)
		if(args.length==2){
				
			//Datos de entrada para la venta
			int idproducto = Integer.parseInt(args[0]); //idproducto
			int cantidad = Integer.parseInt(args[1]); //cantidad
			
			ODB odb = ODBFactory.open("Producto_Ped.BD"); //Abrir BD
			//Comprobamos si existe el producto
			IQuery query = new CriteriaQuery(Producto.class, Where.equal("idproducto", idproducto));
			Objects<Producto> objetos = odb.getObjects(query);
			
			try{
				//Obtiene solo el primer objeto encontrado
				Producto pro = (Producto) objetos.getFirst();
				System.out.println("ID=>" + idproducto + ": " + pro.getDescripcion() + " * STOCK-ACT:" + pro.getStockactual() + " * PVP:" + pro.getPvp() + " * STOCK-MIN:" + pro.getStockminimo());
				
				if(cantidad>0){ //Comprobar cantidad > 0
					java.sql.Date fechaActual = getCurrentDate();
					
					System.out.println("CANTIDAD A VENDER: " + cantidad);
					if(actualizarStock(pro,odb,cantidad)){
						int numeroventa = obtenerNumeroVenta(odb);
						Venta ven = new Venta(numeroventa,idproducto,fechaActual,cantidad);
						odb.store(ven); //Almacenar venta
						System.out.println("VENTA: " + numeroventa + " INSERTADA...");
					}else{
						System.out.println("VENTA NO INSERTADA. NO HAY STOCK...");
					}
				}else{
					System.out.println("LA CANTIDAD DEBE SER MAYOR QUE 0");
				}
			}catch(IndexOutOfBoundsException e){
				System.out.println("NO EXISTE EL PRODUCTO");
			}finally{
				odb.close(); //Cerrar BD
			}
		}
		else{
			System.out.println("No se han especificado argumentos. Para la correcta ejecucic??n del programa es necesario indicar la idproducto y la cantidad tal como se indica a continuaci??n:");
			System.out.println("LlenarVentas_v2 idproducto cantidad");
		}
	}
	
	//Actualizar stock o Generar pedido
	private static boolean actualizarStock(Producto producto, ODB odb, int cantidad)
	{
		Pedido pedido = new Pedido();
		java.sql.Date fechaActual=getCurrentDate();
		producto.addPropertyChangeListener(pedido); //A??adir oyente
		int nuevostock = producto.getStockactual() - cantidad; //Calculo del stock
		boolean actualizar = false;
		
		producto.setStockactual(nuevostock); //Cambiamos el stock actual
		
		if(pedido.isPedir()){
			System.out.println("REALIZAR PEDIDO EN PRODUCTO: " + producto.getDescripcion() + " CANTIDAD: " + cantidad);
			int numeropedido = obtenerNumeroPedido(odb);
			pedido.setCantidad(cantidad);
			pedido.setIdproducto(producto.getIdproducto());
			pedido.setNumeropedido(numeropedido);
			pedido.setFecha(fechaActual);
			odb.store(pedido); //Generar pedido
			System.out.println("PEDIDO " + numeropedido + " GENERADO...");
			
		}else{
			odb.store(producto); //actualizar stock en la BD
			System.out.println("STOCK ACTUALIZADO...");
			actualizar=true;
		}
		return actualizar;
	}
	
	//Obtener el n??mero de pedido a insertar en la BD
	private static int obtenerNumeroPedido(ODB odb)
	{
		Values val4 = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeropedido","ped_max"));
		ObjectValues ov4 = val4.nextValues();
		BigDecimal maxima = (BigDecimal) ov4.getByAlias("ped_max");
		
		return maxima.intValue()+1;
	}
	
	//Obtener el n??mero de venta a insertar en la BD
	private static int  obtenerNumeroVenta(ODB odb){
		Values val4 = odb.getValues(new ValuesCriteriaQuery(Venta.class).max("numeroventa","ven_max"));
		ObjectValues ov4 = val4.nextValues();
		BigDecimal maxima = (BigDecimal) ov4.getByAlias("ven_max");
		
		return maxima.intValue()+1;
	}
	
	//Obtener la fecha actual
	private static java.sql.Date getCurrentDate(){
		java.util.Date hoy = new java.util.Date();
		return new java.sql.Date(hoy.getTime());
	}
}

