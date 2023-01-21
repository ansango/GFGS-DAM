package utils;

import javax.swing.*;

/**
 * Creamos esta clase para montar un diálogo de error genérico para toda la aplicación,
 * con texto dinámico sobre el mensaje a mostrar
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
	 * Método que muestra la ventana de mensaje
	 */
    public void mensajeError(String mensaje)
    {	
    	//Este componente es similar al ShowModalDialog de Microsoft, la opción de Error
    	//pinta en el mensaje un símbolo de error para dar más énfasis
    	JOptionPane.showMessageDialog( null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
	
}