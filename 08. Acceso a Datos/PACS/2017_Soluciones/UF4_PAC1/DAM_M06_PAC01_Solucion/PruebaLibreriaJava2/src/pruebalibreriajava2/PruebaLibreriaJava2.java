package pruebalibreriajava2;

import MisBeans.Pedido;
import MisBeans.Producto;

/**
 *
 * @author Albert
 */
public class PruebaLibreriaJava2 {

    public static void main(String[] args) {
        //Creamos los productos
    	Producto producto1 = new Producto(1,"DVD Babylon 5", 20, 10, 60);
        Producto producto2 = new Producto(2,"Albornoz del Wookiee Chewbacca", 10, 5, 150);
        Producto producto3 = new Producto(3,"Taza Dr Who", 15, 5, 20);
        Producto producto4 = new Producto(4,"Insignia Comunicador Estelar Star Trek", 12, 3, 30);
        Producto producto5 = new Producto(5,"Camiseta Battle Star Galactica", 20, 10, 40);
        
        Pedido pedido = new Pedido();
        
        //Indicamos a los productos que en caso de cambio avisen al objeto pedido
        producto1.addPropertyChangeListener(pedido);
        producto2.addPropertyChangeListener(pedido);
        producto3.addPropertyChangeListener(pedido);
        producto4.addPropertyChangeListener(pedido);
        producto5.addPropertyChangeListener(pedido);
        
        
        //Actualizamos el stock de algunos pedidos
        System.out.println("Modifico el stock del producto 2, reduciendolo a 2, por debajo del stock mínimo.");
        producto2.setStockactual(2);  //Cambiamos el stock del producto 2 a 2        
        if(pedido.isPedir()){
            System.out.println("REALIZAR PEDIDO EN PRODUCTO: " + producto2.getDescripcion());
            pedido.setPedir(false);
        }
        else
            System.out.println("NO ES NECESARIO REALIZAR PEDIDO EN PRODUCTO: " + producto2.getDescripcion());
        
        System.out.println("\nModifico el stock del producto 4, reduciendolo a 5, por encima del stock mínimo.");
        producto4.setStockactual(5);  //Cambiamos el stock del producto 4 a 5
        if(pedido.isPedir()){
            System.out.println("REALIZAR PEDIDO EN PRODUCTO: " + producto4.getDescripcion());
            pedido.setPedir(false);
        }
        else
            System.out.println("NO ES NECESARIO REALIZAR PEDIDO EN PRODUCTO: " + producto4.getDescripcion());

        System.out.println("\nModifico el stock del producto 5, reduciendolo a 1, por debajo del stock mínimo.");
        producto4.setStockactual(1);  //Cambiamos el stock del producto 5 a 1
        if(pedido.isPedir()){
            System.out.println("REALIZAR PEDIDO EN PRODUCTO: " + producto5.getDescripcion());
            pedido.setPedir(false);
        }
        else
            System.out.println("NO ES NECESARIO REALIZAR PEDIDO EN PRODUCTO: " + producto5.getDescripcion());
        
       
        //Listamos el stock mínimo de todos los productos
        System.out.println("\n\nListado de stock mínimo de productos");
        System.out.println("El stock mínimo del producto: " + producto1.getDescripcion() + " es " + producto1.getStockminimo());
        System.out.println("El stock mínimo del producto: " + producto2.getDescripcion() + " es " + producto1.getStockminimo());
        System.out.println("El stock mínimo del producto: " + producto3.getDescripcion() + " es " + producto1.getStockminimo());
        System.out.println("El stock mínimo del producto: " + producto4.getDescripcion() + " es " + producto1.getStockminimo());
        System.out.println("El stock mínimo del producto: " + producto5.getDescripcion() + " es " + producto1.getStockminimo());
        
    }

	
}
