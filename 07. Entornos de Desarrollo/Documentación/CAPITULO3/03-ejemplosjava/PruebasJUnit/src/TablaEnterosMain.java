public class TablaEnterosMain {
	public static void main(String[] args) {

		Integer[] tabla = new Integer[5];
		for (Integer i = 0; i < 5; i++)
			tabla[i] = i * 30 + 3;	
	
		 int resul= 1 / 0;
		TablaEnteros T = new TablaEnteros(tabla);

		System.out.println("Suma: " + T.sumaTabla());
		System.out.println("Mayor: " + T.mayorTabla());
		System.out.println("Posicion del 3: " + T.posicionTabla(3));
		
		//System.out.println("Posicion del 333: " + T.posicionTabla(333));
		//java.util.NoSuchElementException: No existe:333
		
		Integer[] tabla2 = null;
		TablaEnteros T2 = new TablaEnteros(tabla2);
		//java.lang.IllegalArgumentException: No hay elementos

	}
}
