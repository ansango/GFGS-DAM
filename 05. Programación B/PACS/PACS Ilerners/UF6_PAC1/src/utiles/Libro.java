package utiles;

import java.util.GregorianCalendar;

public class Libro implements ILibro{
	private String referencia;
	private String titLibro;
	private String autor;
	private int numPaginas;
	private GregorianCalendar fechaPublicacion;
	private double importe;
	private long ventaEjemplares;
	private TipoPrestamo prestamo;

	public Libro(String referencia, String titLibro, String autor, int numPaginas, 
	          GregorianCalendar fechaPublicacion, double importe, 
	          long ventaEjemplares, TipoPrestamo prestamo) {
		setReferencia(referencia);
		setAutor(autor);
		setTitulo(titLibro);
		setPaginas(numPaginas);
		setFecha(fechaPublicacion);
		setImporte(importe);
		setVenta(ventaEjemplares);
		setPrestamo(prestamo);
	}

	@Override
	public void setReferencia(String ref) {
		this.referencia=ref;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titLibro=titulo;
	}

	@Override
	public void setAutor(String autor) {
		this.autor=autor;
	}

	@Override
	public void setPaginas(int paginas) {
		this.numPaginas=paginas;
	}

	@Override
	public void setFecha(GregorianCalendar fecha) {
		this.fechaPublicacion=fecha;
	}

	@Override
	public void setImporte(double importe) {
		this.importe=importe;
	}

	@Override
	public void setVenta(long venta) {
		this.ventaEjemplares=venta;
	}

	@Override
	public void setPrestamo(TipoPrestamo tipo) {
		this.prestamo=tipo;
	}
	
	@Override
	public String getReferencia() {
		return this.referencia;
	}

	@Override
	public String getTitulo() {
		return this.titLibro;
	}

	@Override
	public String getAutor() {
		return this.autor;
	}

	@Override
	public int getPaginas() {
		return this.numPaginas;
	}

	@Override
	public GregorianCalendar getFecha() {
		return this.fechaPublicacion;
	}
	
	@Override
	public double getImporte() {
		return this.importe;
	}
	
	@Override
	public long getVenta() {
		return this.ventaEjemplares;
	}

	@Override
	public TipoPrestamo getPrestamo() {
		return this.prestamo;
	}
}
