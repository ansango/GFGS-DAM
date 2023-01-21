/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Comercial.
 * 
 * @author ARM
 */
public class Comercial extends Empleado {
	/**
	 * Description of the property contratosrealizados.
	 */
	public int contratosrealizados = 0;

	/**
	 * Description of the property nombrezona.
	 */
	public String nombrezona = "";

	// Start of user code (user defined attributes for Comercial)

	// End of user code

	/**
	 * The constructor.
	 */
	public Comercial() {
		// Start of user code constructor for Comercial)
		super();
		// End of user code
	}

	/**
	 * Description of the method Calcularprimazona.
	 * @param zona 
	 * @return 
	 */
	public int Calcularprimazona(String zona) {
		// Start of user code for method Calcularprimazona
		int Calcularprimazona = 0;
		return Calcularprimazona;
		// End of user code
	}

	/**
	 * Description of the method Calcularzonatrabajo.
	 * @return 
	 */
	public String Calcularzonatrabajo() {
		// Start of user code for method Calcularzonatrabajo
		String Calcularzonatrabajo = "";
		return Calcularzonatrabajo;
		// End of user code
	}

	/**
	 * Description of the method CrearComercial.
	 */
	public void CrearComercial() {
		// Start of user code for method CrearComercial
		// End of user code
	}

	// Start of user code (user defined methods for Comercial)

	// End of user code
	/**
	 * Returns contratosrealizados.
	 * @return contratosrealizados 
	 */
	public int getContratosrealizados() {
		return this.contratosrealizados;
	}

	/**
	 * Sets a value to attribute contratosrealizados. 
	 * @param newContratosrealizados 
	 */
	public void setContratosrealizados(int newContratosrealizados) {
		this.contratosrealizados = newContratosrealizados;
	}

	/**
	 * Returns nombrezona.
	 * @return nombrezona 
	 */
	public String getNombrezona() {
		return this.nombrezona;
	}

	/**
	 * Sets a value to attribute nombrezona. 
	 * @param newNombrezona 
	 */
	public void setNombrezona(String newNombrezona) {
		this.nombrezona = newNombrezona;
	}

}
