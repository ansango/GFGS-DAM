/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Encargado.
 * 
 * @author ARM
 */
public class Encargado extends Empleado {
	/**
	 * Description of the property empleadosasucargo.
	 */
	public int empleadosasucargo = 0;

	/**
	 * Description of the property oficinatrabajo.
	 */
	public String oficinatrabajo = "";

	// Start of user code (user defined attributes for Encargado)

	// End of user code

	/**
	 * The constructor.
	 */
	public Encargado() {
		// Start of user code constructor for Encargado)
		super();
		// End of user code
	}

	/**
	 * Description of the method Calcularsubida.
	 * @param numemple 
	 * @return 
	 */
	public int Calcularsubida(int numemple) {
		// Start of user code for method Calcularsubida
		int Calcularsubida = 0;
		return Calcularsubida;
		// End of user code
	}

	/**
	 * Description of the method CrearEncargado.
	 */
	public void CrearEncargado() {
		// Start of user code for method CrearEncargado
		// End of user code
	}

	// Start of user code (user defined methods for Encargado)

	// End of user code
	/**
	 * Returns empleadosasucargo.
	 * @return empleadosasucargo 
	 */
	public int getEmpleadosasucargo() {
		return this.empleadosasucargo;
	}

	/**
	 * Sets a value to attribute empleadosasucargo. 
	 * @param newEmpleadosasucargo 
	 */
	public void setEmpleadosasucargo(int newEmpleadosasucargo) {
		this.empleadosasucargo = newEmpleadosasucargo;
	}

	/**
	 * Returns oficinatrabajo.
	 * @return oficinatrabajo 
	 */
	public String getOficinatrabajo() {
		return this.oficinatrabajo;
	}

	/**
	 * Sets a value to attribute oficinatrabajo. 
	 * @param newOficinatrabajo 
	 */
	public void setOficinatrabajo(String newOficinatrabajo) {
		this.oficinatrabajo = newOficinatrabajo;
	}

}
