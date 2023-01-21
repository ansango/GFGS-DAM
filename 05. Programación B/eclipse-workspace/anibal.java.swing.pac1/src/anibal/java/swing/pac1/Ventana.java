package anibal.java.swing.pac1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame implements ActionListener {
	
	Pantalla1 pantPrimera;
	PantallaMascota pantMascota;
	PantallaRegistro pantRegistro;
	PantallaTratamiento pantTratamiento;
	
	JMenuBar  barraMenu;
	JMenu     menu;
	JMenuItem pRegistro, pNuevaMascota, pTratamiento;
		
	
	
	public Ventana() {
		
		// menu
		barraMenu = new JMenuBar();
		menu = new JMenu("Opciones");
		pRegistro = new JMenuItem("Registro");
		pNuevaMascota = new JMenuItem("Nueva Mascota");
		pTratamiento = new JMenuItem("Tratamiento");
		
		// añadimos los componentes a la jerarquía
		menu.add(pRegistro);
		menu.add(pNuevaMascota);
		menu.add(pTratamiento);
		barraMenu.add(menu);
		
		// asignamos escuchador de eventos a los elementos del menú
		pRegistro.addActionListener(this);
		pNuevaMascota.addActionListener(this);
		pTratamiento.addActionListener(this);
		
		
		// Creamos las pantallas
		pantPrimera = new Pantalla1("Bienvenido a la Clínica VetIlerna");
		pantRegistro = new PantallaRegistro(this);
		pantMascota = new PantallaMascota(this);
		pantTratamiento = new PantallaTratamiento(this);
		
		
		pantPrimera.setEnabled(true);
		pantPrimera.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if( e.getSource() == pantMascota.roedor) {
			if(pantMascota.roedor.isSelected()) {
				pantMascota.conejo.setEnabled(true);
				pantMascota.raton.setEnabled(true);
				
				pantMascota.perro.setSelected(false);
				pantMascota.gato.setSelected(false);
				
			}
			else {
				pantMascota.conejo.setEnabled(false);
				pantMascota.raton.setEnabled(false);
			}
		}
		else if( e.getSource() == pantMascota.gato) {
			if( pantMascota.gato.isSelected() ) {
				pantMascota.perro.setSelected(false);
				pantMascota.roedor.setSelected(false);
				
				pantMascota.conejo.setEnabled(false);
				pantMascota.raton.setEnabled(false);
			}
		}
		//...
		else if( e.getSource() == pRegistro) {
			//
		}
		else if( e.getSource() == pNuevaMascota) {
			pantPrimera.setVisible(false);
			pantPrimera.setEnabled(false);
			
			pantRegistro.setVisible(false);
			pantRegistro.setEnabled(false);
			
			pantTratamiento.setVisible(false);
			pantTratamiento.setEnabled(false);
			
			pantMascota.setVisible(true);
			pantMascota.setEnabled(true);
		}
		
	}

}
