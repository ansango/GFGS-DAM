package logica;

public class Excepciones{
	@SuppressWarnings("serial")
	public static class NumDepartDuplicado extends Exception{
		public NumDepartDuplicado(String mensaje){
			super(mensaje);
		}
	}
}
