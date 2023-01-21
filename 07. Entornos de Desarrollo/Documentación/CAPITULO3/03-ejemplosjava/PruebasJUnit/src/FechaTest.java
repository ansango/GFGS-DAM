import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FechaTest {
		private int tipo;
		private String resul;		
	
		public FechaTest(int tipo, String resul) {
			this.tipo = tipo;
			this.resul=resul;
		}

		@Parameters
		public static Collection<Object[]> numeros() {
			return Arrays.asList(new Object[][] {
			{ 1, "2014/03" }, 
			{ 2, "03/2014" },	
			{ 3,  "03/14"} ,
			{ 3, "2014/03" }, 
			{ 1, "03/2014" },	
			{ 2,  "03/14"}, 
			{ 4,  "ERROR"},
			{ 5,  null}					
			});
		}	
	

	@Test 
	public void testDevuelveFecha() 
	  {
		 Fecha fec = new Fecha();
		 assertTrue( fec.DevuelveFecha(tipo).equals(resul) );		  
	}
}
