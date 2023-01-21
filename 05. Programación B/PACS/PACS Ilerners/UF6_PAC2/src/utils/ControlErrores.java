package utils;

import javax.swing.*;

/**
 * Creamos esta clase para montar un di�logo de error gen�rico para toda la aplicaci�n,
 * con texto din�mico sobre el mensaje a mostrar
 * 
 * 
 *
 */
public class ControlErrores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3529037437265555145L;
	//Constantes
	final static String titulo = "Error";
	
	/**
	 * M�todo que muestra la ventana de mensaje
	 */
    public void mensajeError(String mensaje)
    {	
    	//Este componente es similar al ShowModalDialog de Microsoft, la opci�n de Error
    	//pinta en el mensaje un s�mbolo de error para dar m�s �nfasis
    	JOptionPane.showMessageDialog( null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
	
}