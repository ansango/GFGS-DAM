import java.util.HashSet;

/*******************************************************************************
 * 2014, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Plantilla.
 * 
 * @author ARM
 */
public class Plantilla {
	/**
	 * Description of the property comercials.
	 */
	public HashSet<Comercial> comercials = new HashSet<Comercial>();

	/**
	 * Description of the property administrativos.
	 */
	public HashSet<Administrativo> administrativos = new HashSet<Administrativo>();

	/**
	 * Description of the property limpiadors.
	 */
	public HashSet<Limpiador> limpiadors = new HashSet<Limpiador>();

	/**
	 * Description of the property encargados.
	 */
	public HashSet<Encargado> encargados = new HashSet<Encargado>();

	// Start of user code (user defined attributes for Plantilla)

	// End of user code

	/**
	 * The constructor.
	 */
	public Plantilla() {
		// Start of user code constructor for Plantilla)
		super();
		// End of user code
	}

	/**
	 * Description of the method contratarempeado.
	 * @param emple 
	 */
	public void contratarempeado(Empleado emple) {
		// Start of user code for method contratarempeado
		// End of user code
	}

	/**
	 * Description of the method buscarempleado.
	 * @param emple 
	 */
	public void buscarempleado(int emple) {
		// Start of user code for method buscarempleado
		// End of user code
	}

	/**
	 * Description of the method despedirempleado.
	 * @param emple 
	 */
	public void despedirempleado(Empleado emple) {
		// Start of user code for method despedirempleado
		// End of user code
	}

	// Start of user code (user defined methods for Plantilla)

	// End of user code
	/**
	 * Returns comercials.
	 * @return comercials 
	 */
	public HashSet<Comercial> getComercials() {
		return this.comercials;
	}

	/**
	 * Returns administrativos.
	 * @return administrativos 
	 */
	public HashSet<Administrativo> getAdministrativos() {
		return this.administrativos;
	}

	/**
	 * Returns limpiadors.
	 * @return limpiadors 
	 */
	public HashSet<Limpiador> getLimpiadors() {
		return this.limpiadors;
	}

	/**
	 * Returns encargados.
	 * @return encargados 
	 */
	public HashSet<Encargado> getEncargados() {
		return this.encargados;
	}

}
