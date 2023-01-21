import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void testSuma() {
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.suma();
		assertEquals(30, resultado);
	}

	@Test
	public void testResta() {
		Calculadora calcu = new Calculadora(5, 10);
		int resultado = calcu.resta();
		assertEquals(-5, resultado);
	}

	@Test
	public void testMultiplica() {
		Calculadora calcu = new Calculadora(20, 50);
		int resultado = calcu.multiplica();
		assertEquals("Fallo en la multiplicación: ", 200, resultado);
	}

	@Test
	public void testDivide() {
		Calculadora calcu = new Calculadora(20, 0);
		int resultado = calcu.divide();		
		assertEquals(2, resultado);		
	}

	
	@Test
	public void testExcepcion() {
		try {
			Calculadora calcu = new Calculadora(20, 0);
			int resultado = calcu.divide();			
			fail("FALLO, Deberia haber lanzado una excepcion");
		} catch (ArithmeticException e) {
			// PRUEBA satisfactoria			
		}
	}
	@Test
	public void testResta2() {
		Calculadora calcu = new Calculadora(20, 30);
		boolean resultado = calcu.resta2();
		assertTrue("No es true" ,resultado);//, 
	}
	@Test
	public void testDivide2() {
		Calculadora calcu = new Calculadora(20, 0);
		Integer resultado = calcu.divide2();
		assertNull("No es nulo" ,resultado);//, 	
	}

	@Test(expected = java.lang.ArithmeticException.class)
	public void testDivide0() {
		Calculadora calcu = new Calculadora(20, 0);
		Integer resultado = calcu.divide0();		
	}
	
	
	
}
