import java.util.Scanner;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

public class Actividad5_7 {

	static Scanner teclado = new Scanner(System.in);
	static String driver = "org.exist.xmldb.DatabaseImpl";
	static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas"; 																					
	static String usu = "admin";
	static String usuPwd = "root";
	static Collection col = null;

	public static void main(String[] args) {

		int op = 0, n = 0, de;
		do {
			dibujaMenu();
			System.out.println("TECLEA OPERACIÓN: ");
			op = teclado.nextInt();
			switch (op) {
			case 1:
				System.out.println("TECLEA Número de departamento: ");
				de = teclado.nextInt();
				visualizarEmpleDepart(de);
				break;
			case 2:
				// Inserta uno fijo
				System.out.println("TECLEA Número de departamento: ");
				de = teclado.nextInt();
				teclado.nextLine();
				System.out.println("TECLEA Nombre de departamento: ");
				String nom = teclado.nextLine();
				System.out.println("TECLEA Localidad de departamento: ");
				String loc = teclado.nextLine();

				insertarDep(de, nom, loc);
				break;
			case 3: // consultar un dep
				System.out.println("Teclea el número de departamento a consultar: ");
				n = teclado.nextInt();
				consultarDep(n);
				break;
			case 4: // Modificar
				System.out.println("Teclea el número de dep a modificar: ");
				n = teclado.nextInt();
				teclado.nextLine();
				System.out.println("TECLEA NUEVO Nombre de departamento: ");
				nom = teclado.nextLine();
				System.out.println("TECLEA NUEVA Localidad de departamento: ");
				loc = teclado.nextLine();
				modificarDep(n, nom, loc);
				break;
			case 5: // borrar un dep
				System.out.println("Teclea el número de dep a borrar: ");
				n = teclado.nextInt();
				borrarRegistroDep(n);
				break;
			case 6: // borrar un dep
				System.out.println("VER TODOS ");
				listarDep();
				break;
			}// cierra Sub menu

		} while (op != 0);

	}// fin main
		////////////////////////////////////////////////////////////////////////////////////

	private static void dibujaMenu() {
		System.out.println("............................................................\n"
				+ ".  1 Listar empleados de un departamento. \n" 
				+ ".  2 Insertar un departamento.  \n"
				+ ".  3 Consultar un departamento.\n" 
				+ ".  4 Modificar un departamento. \n"
				+ ".  5 Borrar un departamento.\n" 
				+ ".  6 Ver todos.\n" 
				+ ".  0 SALIR.\n"
				+ "............................................................\n");

	} // fin dibujamenu

	public static Collection conectar() {

		try {
			Class<?> cl = Class.forName(driver); // Cargar del driver
			Database database = (Database) cl.newInstance(); // Instancia de la
																// BD
			DatabaseManager.registerDatabase(database); // Registro del driver
			col = DatabaseManager.getCollection(URI, usu, usuPwd);
			return col;
		} catch (XMLDBException e) {
			System.out.println("Error al inicializar la BD eXist.");
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el driver.");
			// e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("Error al instanciar la BD.");
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Error al instanciar la BD.");
			// e.printStackTrace();
		}
		return null;
	}

	private static void listarDep() {
		if (conectar() != null) {
			try {
				XPathQueryService servicio;
				servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				ResourceSet result = servicio
						.query("for $dep in doc('departamentos.xml')/departamentos/DEP_ROW return $dep");
				// recorrer los datos del recurso.
				ResourceIterator i;
				i = result.getIterator();
				if (!i.hasMoreResources()) {
					System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
				}
				while (i.hasMoreResources()) {
					Resource r = i.nextResource();
					System.out.println("--------------------------------------------");
					System.out.println((String) r.getContent());
				}
				col.close();
			} catch (XMLDBException e) {
				System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
				e.printStackTrace();
			}
		} else {
			System.out.println("Error en la conexión. Comprueba datos.");
		}

	}

	private static void insertarDep(int dep, String dnombre, String loc) {

		String nuevodep = "<DEP_ROW><DEPT_NO>" + dep + "</DEPT_NO>" + "<DNOMBRE>" + dnombre + "</DNOMBRE><LOC>" + loc
				+ "</LOC>" + "</DEP_ROW>";
		if (comprobarDep(dep)) {
			System.out.println("Departamento A INSERTAR YA EXISTE. ");
		} else

		if (conectar() != null) {
			try {
				XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				System.out.printf("Inserto: %s \n", nuevodep);
				servicio
						.query("update insert " + nuevodep + " into doc('departamentos.xml')/departamentos");
				col.close(); // borramos
				System.out.println("Dep insertado.");
			} catch (Exception e) {
				System.out.println("Error al insertar empleado.");
				e.printStackTrace();
			}
		} else {
			System.out.println("Error en la conexión. Comprueba datos.");
		}
	}

	private static void consultarDep(int dep) {
		if (comprobarDep(dep)) {
			if (conectar() != null) {
				try {
					XPathQueryService servicio;
					servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
					ResourceSet result = servicio
							.query("doc('departamentos.xml')/departamentos/DEP_ROW[DEPT_NO=" + dep + "]");
					// recorrer los datos del recurso.
					ResourceIterator i;
					i = result.getIterator();
					if (!i.hasMoreResources()) {
						System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
					} else {
						Resource r = i.nextResource();
						System.out.println("--------------------------------------------");
						System.out.println((String) r.getContent());
					}
					col.close();
				} catch (XMLDBException e) {
					System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
					e.printStackTrace();
				}
			} else {
				System.out.println("Error en la conexión. Comprueba datos.");
			}
		} else {
			System.out.println("El departamento NO EXISTE.");
		}

	}

	private static void modificarDep(int dep, String dnombre, String loc) {

		if (comprobarDep(dep)) {

			if (conectar() != null) {
				try {
					System.out.printf("Actualizo el departamento: %s\n", dep);
					XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
					servicio
							.query("update value doc('departamentos.xml')/departamentos/DEP_ROW[DEPT_NO=" + dep
									+ "]/DNOMBRE with data('" + dnombre + "') ");
					servicio.query("update value doc('departamentos.xml')/departamentos/DEP_ROW[DEPT_NO=" + dep
							+ "]/LOC with data('" + loc + "') ");

					col.close();
					System.out.println("Dep actualizado.");
				} catch (Exception e) {
					System.out.println("Error al actualizar.");
					e.printStackTrace();
				}
			} else {
				System.out.println("Error en la conexión. Comprueba datos.");
			}
		} else {
			System.out.println("El departamento NO EXISTE.");
		}
	}

	private static void borrarRegistroDep(int dep) {
		if (comprobarDep(dep)) {
			if (conectar() != null) {
				try {
					System.out.printf("Borro el departamento: %s\n", dep);
					XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
					servicio
							.query("update delete doc('departamentos.xml')/departamentos/DEP_ROW[DEPT_NO=" + dep + "]");
					col.close();
					System.out.println("Dep borrado.");
				} catch (Exception e) {
					System.out.println("Error al borrar.");
					e.printStackTrace();
				}
			} else {
				System.out.println("Error en la conexión. Comprueba datos.");
			}
		} else {
			System.out.println("El departamento NO EXISTE.");
		}

	}

	private static boolean comprobarDep(int dep) {
		// Devuelve true si el dep existe
		if (conectar() != null) {
			try {
				XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				ResourceSet result = servicio
						.query("doc('departamentos.xml')/departamentos/DEP_ROW[DEPT_NO=" + dep + "]");
				ResourceIterator i;
				i = result.getIterator();
				col.close();
				if (!i.hasMoreResources()) {
					return false;
				} else {
					return true;
				}
			} catch (Exception e) {
				System.out.println("Error al consultar.");
				// e.printStackTrace();
			}
		} else {
			System.out.println("Error en la conexión. Comprueba datos.");
		}

		return false;

	}// comprobardep

	private static void visualizarEmpleDepart(int dep) {

		if (conectar() != null) {
			try {
				XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				ResourceSet result = servicio.query("for $em in /EMPLEADOS/EMP_ROW[DEPT_NO=" + dep + "] return $em");
				// Recorrer los datos del recurso.
				ResourceIterator i;
				i = result.getIterator();
				System.out.println(" Se han obtenido " + result.getSize() + " empleados.");
				if (!i.hasMoreResources())
					System.out.println(" LA CONSULTA NO DEVUELVE NADA.");
				while (i.hasMoreResources()) {
					Resource r = i.nextResource();
					System.out.println((String) r.getContent());
				}
				col.close(); // borramos
			} catch (Exception e) {
				System.out.println("Error al inicializar la BD eXist");
				e.printStackTrace();
			}

		}

	}
}
