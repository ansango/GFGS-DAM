import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculadoraTestMultiplica {
	private int nume1;
	private int nume2;
	private int resul;

	public CalculadoraTestMultiplica(int nume1, int nume2, int resul) {
		this.nume1 = nume1;
		this.nume2 = nume2;
		this.resul = resul;
	}

	@Parameters
	public static Collection<Object[]> numeros() {
		return Arrays.asList(new Object[][] {
		{ 20, 10, 200 }, { 30, -2, -60 },	{ 5, 2, 3 } });
	}

	@Test
	public void testMultiplica() {
		Calculadora calcu = new Calculadora(nume1, nume2);
		int resultado = calcu.multiplica();
		assertEquals(resul, resultado);
	}

}
