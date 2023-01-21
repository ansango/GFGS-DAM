package utiles;

import java.util.GregorianCalendar;

public interface ILibro {
	public enum TipoPrestamo {DIARIO,SEMANAL,MENSUAL};

	//Métodos set para asignar valor a las variables
	public void setReferencia(String ref);
	public void setTitulo(String titulo);
	public void setAutor(String autor);
	public void setPaginas(int paginas);
	public void setFecha(GregorianCalendar fecha);
	public void setImporte(double importe);
	public void setVenta(long venta);
	public void setPrestamo(TipoPrestamo tipo);	

	//Métodos get para obtener valor de las variables
	public String getReferencia();
	public String getTitulo();
	public String getAutor();
	public int getPaginas();
	public GregorianCalendar getFecha();
	public double getImporte();
	public long getVenta();
	public TipoPrestamo getPrestamo();	

}
