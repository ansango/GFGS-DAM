package anibal.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame implements ActionListener

{
	
	Pantalla1 primera;
	PantallaMascota panMascota;
	
	JMenuBar barraMenu;
	JMenu menu;	
	JMenuItem pRegistro, pNuevaMascota, pTratamiento;
	
	public Ventana()
	{
		primera = new Pantalla1("Bienvenido a la Clínica VetIlerna");
		
		// menu
		barraMenu = new JMenuBar();
		menu = new JMenu("Opciones");
		pRegistro = new JMenuItem("Registro");
		pNuevaMascota = new JMenuItem("Nueva Mascota");
		pTratamiento = new JMenuItem("Tratamiento");
		
		//añadimos los componentes a la jerarquia
		menu.add(pRegistro);
		menu.add(pNuevaMascota);
		menu.add(pTratamiento);
		barraMenu.add(menu);
		
		//asignamos escuchador de eventos a los elementos del menu
		
		pRegistro.addActionListener(this);
		pNuevaMascota.addActionListener(this);
		pTratamiento.addActionListener(this);
		
		//creamos las pantallas
		
		
		panMascota = new PantallaMascota(this);
		panRegistro = new PantallaRegistro(this);
		panTratamiento = new PantallaTratamiento(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(e.getsource() == panMascota.roedor) 
		{
			if(panMascota.roedor.isSelected()) 
			{
				panMascota.conejo.setEnabled(true); // comprobamos si est seleccionado
				panMascota.raton.setEnabled(true);
				
				panMascota.perro.setSelected(false); 
				panMascota.gato.setSelected(false);
			}
			else
			{
				panMascota.conejo.setEnabled(false);
				panMascota.raton.setEnabled(false);
				
				panMascota.perro.setSelected(true); 
				panMascota.gato.setSelected(true);
			}			
		}
		else if(e.getSource()== panMascota.gato) 
		{
			if(panMascota.gato.isSelected())
		} 
		
	}

}
