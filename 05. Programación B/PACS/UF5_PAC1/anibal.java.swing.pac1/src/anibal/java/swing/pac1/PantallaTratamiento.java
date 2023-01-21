package anibal.java.swing.pac1;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PantallaTratamiento extends JPanel {
	Ventana escuchador;
	
	JComboBox cbMascotas;
	
	public PantallaTratamiento(Ventana escuchador) {
		this.escuchador = escuchador;
		
		String[] mascotas = {"Congo", "Kenia"};
		
		cbMascotas = new JComboBox<>(mascotas);
				
		
		
	}

}
