import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest2 {
	private Calculadora calcu;
	private int resultado;
	
	@Before
	public void creaCalculadora() {
		calcu = new Calculadora(20, 10);
	}
	
	@After
	public void borraCalculadora() {
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
