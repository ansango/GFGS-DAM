import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest3 {
	private static Calculadora calcu;
	private int resultado;
	
	@BeforeClass
	public static void creaCalculadora() {
		calcu = new Calculadora(20, 10);
	}
	
	@AfterClass
	public static void borraCalculadora() {
		calcu = null;
	}
	
	@Test
	public void testSuma() {		 
		 resultado = calcu.suma();		 
		 assertEquals(30, resultado); 
	}

	@Test
	public void testResta() {		
		resultado = calcu.resta();
		assertEquals(10, resultado);
	}

	@Test
	public void testMultiplica() {		
		resultado = calcu.multiplica();
		assertEquals(200, resultado);
	}

	@Test
	public void testDivide() {		
		resultado = calcu.divide();
		assertEquals(2, resultado);
	}

}
