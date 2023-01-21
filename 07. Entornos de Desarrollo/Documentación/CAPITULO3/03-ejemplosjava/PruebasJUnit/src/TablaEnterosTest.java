import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class TablaEnterosTest {

	private static Integer[] tabla;

	@BeforeClass
	public static void inicioPruebas() {
		tabla = new Integer[5];
		for (Integer i = 0; i < 5; i++)
			tabla[i] = i * 30 + 3;
		// 3,33,63,93,123
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testTablaEnterosNull() {
		TablaEnteros T = new TablaEnteros(null);
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void testPosicionTablaExcepcion() {
		TablaEnteros T = new TablaEnteros(tabla);
		assertEquals(1, T.posicionTabla(693));		
	}

	@Test
	public void testSumaTabla() {
		TablaEnteros T = new TablaEnteros(tabla);
		assertEquals(315, T.sumaTabla());
	}

	@Test
	public void testMayorTabla() {
		TablaEnteros T = new TablaEnteros(tabla);
		assertEquals(123, T.mayorTabla());
	}

	@Test
	public void testPosicionTabla() {
		TablaEnteros T = new TablaEnteros(tabla);
		assertEquals(3, T.posicionTabla(63));
	}
}
