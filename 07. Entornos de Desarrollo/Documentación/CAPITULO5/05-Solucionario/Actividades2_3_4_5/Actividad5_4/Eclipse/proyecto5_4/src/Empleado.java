/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Empleado.
 * 
 * @author ARM
 */
public class Empleado {
	/**
	 * Description of the property dni.
	 */
	public int dni = 0;

	/**
	 * Description of the property nombre.
	 */
	public String nombre = "";

	/**
	 * Description of the property direccion.
	 */
	public String direccion = "";

	// Start of user code (user defined attributes for Empleado)

	// End of user code

	/**
	 * The constructor.
	 */
	public Empleado() {
		// Start of user code constructor for Empleado)
		super();
		// End of user code
	}

	/**
	 * Description of the method Calcularsueldo.
	 * @return 
	 */
	public int Calcularsueldo() {
		// Start of user code for method Calcularsueldo
		int Calcularsueldo = 0;
		return Calcularsueldo;
		// End of user code
	}

	/**
	 * Description of the method CrearEmpleado.
	 * @param dni 
	 * @param nom 
	 * @param dire 
	 */
	public void CrearEmpleado(int dni, String nom, String dire) {
		// Start of user code for method CrearEmpleado
		// End of user code
	}

	// Start of user code (user defined methods for Empleado)

	// End of user code
	/**
	 * Returns dni.
	 * @return dni 
	 */
	public int getDni() {
		return this.dni;
	}

	/**
	 * Sets a value to attribute dni. 
	 * @param newDni 
	 */
	public void setDni(int newDni) {
		this.dni = newDni;
	}

	/**
	 * Returns nombre.
	 * @return nombre 
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets a value to attribute nombre. 
	 * @param newNombre 
	 */
	public void setNombre(String newNombre) {
		this.nombre = newNombre;
	}

	/**
	 * Returns direccion.
	 * @return direccion 
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Sets a value to attribute direccion. 
	 * @param newDireccion 
	 */
	public void setDireccion(String newDireccion) {
		this.direccion = newDireccion;
	}

}
