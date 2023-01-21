package anibal.java.swing.pac1;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PantallaMascota extends JPanel {

	JLabel tituloDni;
	JTextField campoDni;
	JButton botonBuscar;
	JTextField campoNombreMascota;
	JRadioButton gato;
	JRadioButton perro;
	JRadioButton roedor;
	JRadioButton conejo;
	JRadioButton raton;
	JRadioButton macho;
	JRadioButton hembra;
	JButton botonInsertar;
	//JLabel especieRoedor;
	JTextField color;
	JTextField raza;
	Ventana ventanaActionListener;
	
	public PantallaMascota( Ventana ventanaActionListener ) {
		this.ventanaActionListener = ventanaActionListener; 
		inicializarComponentes();		
	}
	
	public void inicializarComponentes() {
		
		// inicializamos los elementos
		tituloDni = new JLabel("Introduce el DNI del Cliente");
		campoDni = new JTextField("DNI cliente");
		botonBuscar = new JButton("Buscar");
		campoNombreMascota = new JTextField();
		gato = new JRadioButton("Gato");
		perro = new JRadioButton("Perro");
		roedor = new JRadioButton("Roedor");
		conejo = new JRadioButton("Conejo");
		raton = new JRadioButton("Ratón");
		macho = new JRadioButton("macho");
		hembra = new JRadioButton("hembra");
		botonInsertar = new JButton("Insertar");
		//JLabel especieRoedor;
		color = new JTextField("color");
		raza = new JTextField("raza");
		
		
		// posicionamos los elementos en el panel
		tituloDni.setBounds(20, 20, 60, 20);
		campoDni.setBounds(20, 40, 60, 20);
		botonBuscar.setBounds(80, 30, 40, 20);
		
		campoNombreMascota.setBounds(20, 100, 60, 20);
		
		gato.setBounds(20,150,60,20 );
		perro.setBounds(20,170,60,20);
		roedor.setBounds(20,190,60,20);
		
		color.setBounds(80,150,60,20);
		raza.setBounds(80,170,60,20);
		
		conejo.setBounds(80,210,60,20);
		raton.setBounds(80,230,60,20);
		
		macho.setBounds(160,150,60,20);
		hembra.setBounds(160,170,60,20);
		
		botonInsertar.setBounds(40,280,60,20);
		
		
		
		ArrayList<JComponent> componentes = new ArrayList<>();
		componentes.add(tituloDni);
		componentes.add(campoDni);
		componentes.add(botonBuscar);
		componentes.add(campoNombreMascota);
		componentes.add(gato);
		componentes.add(perro);
		componentes.add(roedor);
		componentes.add(conejo);
		componentes.add(raton);
		componentes.add(macho);
		componentes.add(hembra);
		componentes.add(botonInsertar);
		componentes.add(color);
		componentes.add(raza);
/*				
		for (JComponent c : componentes) {
			this.add(c);
			c.setVisible(true);			
		}
		
		for (int i = 0; i < componentes.size(); i++) {
			JComponent c = componentes.get(i);
			this.add(c);
			c.setVisible(true);			
		}
*/		
		
		// Añadimos los componentes al panel		
		this.add(tituloDni);
		this.add(campoDni);
		this.add(botonBuscar);
		this.add(campoNombreMascota);
		this.add(gato);
		this.add(perro);
		this.add(roedor);
		this.add(conejo);
		this.add(raton);
		this.add(macho);
		this.add(hembra);
		this.add(botonInsertar);
		this.add(color);
		this.add(raza);

		// ponemos los elementos visibles
		tituloDni.setVisible(true);
		campoDni.setVisible(true);
		botonBuscar.setVisible(true);
		campoNombreMascota.setVisible(true);
		gato.setVisible(true);
		perro.setVisible(true);
		roedor.setVisible(true);
		conejo.setVisible(true);
		raton.setVisible(true);
		macho.setVisible(true);
		hembra.setVisible(true);
		botonInsertar.setVisible(true);
		color.setVisible(true);
		raza.setVisible(true);
		
		// asignar el manejador de eventos
		//tituloDni
		campoDni.addActionListener(ventanaActionListener);
		botonBuscar.addActionListener(ventanaActionListener);
		campoNombreMascota.addActionListener(ventanaActionListener);
		gato.addActionListener(ventanaActionListener);
		perro.addActionListener(ventanaActionListener);
		roedor.addActionListener(ventanaActionListener);
		conejo.addActionListener(ventanaActionListener);
		raton.addActionListener(ventanaActionListener);
		macho.addActionListener(ventanaActionListener);
		hembra.addActionListener(ventanaActionListener);
		botonInsertar.addActionListener(ventanaActionListener);
		color.addActionListener(ventanaActionListener);
		raza.addActionListener(ventanaActionListener);
		
	}
	
	
	
}
