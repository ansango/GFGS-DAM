import static org.junit.Assert.*;
import org.junit.Test;
public class FactorialTest {

	@Test
	public void testCalculo() {
		int n = Factorial.calculo(12);
		assertEquals(479001600, n);		
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testCalculoExcep1() {
		Factorial.calculo(-22);	
		Factorial.calculo(-1);	    
	}
	
	@Test(expected = java.lang.ArithmeticException.class)
	public void testCalculoExcep2() {
		Factorial.calculo(18);	
	}
}
