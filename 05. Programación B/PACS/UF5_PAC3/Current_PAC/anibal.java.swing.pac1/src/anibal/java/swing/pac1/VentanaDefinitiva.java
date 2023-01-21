
	package anibal.java.swing.pac1;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Vector;

	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;

	public class VentanaDefinitiva implements ActionListener {
		
		private JFrame frame;
		private JMenuItem jmiRegistro;
		private JMenuItem jmiNuevaMascota;
		private JMenuItem jmiTratamiento;
		private JPanel panel1;
		private JPanel panelRegistro;
		private JPanel panelMascota;
		private JPanel panelTratamiento;
		
		public VentanaDefinitiva() {
			
			frame = new JFrame("Clínica veterinaria");
			frame.setSize(900, 700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// Menú
			JMenuBar jMenuBar = new JMenuBar();
			JMenu jMenu = new JMenu("Opciones");
			jmiRegistro = new JMenuItem("Registro");
			jmiNuevaMascota = new JMenuItem("Nueva Mascota");
			jmiTratamiento = new JMenuItem("Tratamiento");
			
			jmiRegistro.addActionListener(this);
			jmiNuevaMascota.addActionListener(this);
			jmiTratamiento.addActionListener(this);
			
			// añadimos los componentes a la jerarquía
			jMenu.add(jmiRegistro);
			jMenu.add(jmiNuevaMascota);
			jMenu.add(jmiTratamiento);
			jMenuBar.add(jMenu);
			
			// aplicamos el menú a la ventana
			frame.setJMenuBar(jMenuBar);
			
			// Bienvenida
			panel1 = new JPanel();
			frame.add(panel1);
			colocaComponentesPanel1(panel1);

			// Registro
			panelRegistro = new JPanel();
//			frame.add(panelRegistro);
			colocaComponentesPanelRegistro(panelRegistro);

			// Mascota
			panelMascota = new JPanel();
			colocaComponentesPanelMascota(panelMascota);
			
			// Tratamiento
			panelTratamiento = new JPanel();
//			frame.add(panelTratamiento);
			colocaComponentesPanelTratamiento(panelTratamiento);
			
			panel1.setVisible(true);
			panelTratamiento.setVisible(true);	// ocultamos temporalmente el panel de Tratamiento
			panelMascota.setVisible(true);	// ocultamos temporalmente el panel de Mascota
			panelRegistro.setVisible(true);	// ocultamos temporalmente el panel de Registro

			frame.setVisible(true);
			
		}

		
		// JPanel de pantalla de bienvenida
		private static void colocaComponentesPanel1(JPanel panel) {
			panel.setLayout(null);

			JLabel bienvenidaLabel = new JLabel("Bienvenido a la Clínica VetIlerna");
			bienvenidaLabel.setBounds(300, 250 , bienvenidaLabel.getText().length()*12, 80);
			panel.add(bienvenidaLabel);
		}
		
		

		// JPanel de Registro
		private static void colocaComponentesPanelRegistro(JPanel panel) {
			panel.setLayout(null);

			JLabel regClienteLabel = new JLabel("Registro Cliente");
			regClienteLabel.setBounds(50, 20, regClienteLabel.getText().length()*12, 80);	// utilizamos tamaño relativo al contenido
			panel.add(regClienteLabel);
			
			
			JTextField nombreClienteText = new JTextField(20);
			nombreClienteText.setBounds(50, regClienteLabel.getHeight() + regClienteLabel.getY(), 200, 25);	// utilizamos posicionamiento relativo al/los componente/s anterior/es
			nombreClienteText.setText("Nombre Cliente");
			panel.add(nombreClienteText);
			
			JTextField direccionClienteText = new JTextField(20);
			direccionClienteText.setBounds(50, nombreClienteText.getHeight() + nombreClienteText.getY() + 20, 200, 25);
			direccionClienteText.setText("Dirección Cliente");
			panel.add(direccionClienteText);
			
			JTextField dniClienteText = new JTextField(20);
			dniClienteText.setBounds(nombreClienteText.getWidth() + 200, nombreClienteText.getY(), 200 , 25);
			dniClienteText.setText("DNI Cliente");
			panel.add(dniClienteText);
		
			
			JLabel datosMascotaLabel = new JLabel("Datos mascota");
			datosMascotaLabel.setBounds(50, dniClienteText.getY() + dniClienteText.getHeight() + 50, datosMascotaLabel.getText().length()*12, 80);
			panel.add(datosMascotaLabel);
			
			JTextField nombreMascotaText = new JTextField(20);
			nombreMascotaText.setBounds(50, datosMascotaLabel.getHeight() + datosMascotaLabel.getY(), 200, 25);
			nombreMascotaText.setText("Nombre Mascota");
			panel.add(nombreMascotaText);

			
			JLabel tipoLabel = new JLabel("Tipo");
			tipoLabel.setBounds(50, nombreMascotaText.getY() + nombreMascotaText.getHeight() + 20, tipoLabel.getText().length()*12, 80);
			panel.add(tipoLabel);
			
			JRadioButton gatoRB = new JRadioButton("Gato");
			gatoRB.setBounds(50, tipoLabel.getHeight() + tipoLabel.getY(), 200, 25);
			panel.add(gatoRB);
		
			JRadioButton perroRB = new JRadioButton("Perro");
			perroRB.setBounds(50, gatoRB.getHeight() + gatoRB.getY(), 200, 25);
			panel.add(perroRB);

			JRadioButton roedorRB = new JRadioButton("Roedor");
			roedorRB.setBounds(50, perroRB.getHeight() + perroRB.getY(), 200, 25);
			panel.add(roedorRB);
			

			JTextField colorText = new JTextField(20);
			colorText.setBounds(dniClienteText.getX(), gatoRB.getY(), 200, 25);
			colorText.setText("color");
			colorText.setEnabled(false);
			panel.add(colorText);
			
			JTextField razaText = new JTextField(20);
			razaText.setBounds(colorText.getX(), perroRB.getY(), 200, 25);
			razaText.setText("raza");
			razaText.setEnabled(false);
			panel.add(razaText);

			
			JLabel especieRoedorLabel = new JLabel("Especialización de Roedor");
			especieRoedorLabel.setBounds(razaText.getX(), roedorRB.getY() - roedorRB.getHeight(), especieRoedorLabel.getText().length()*12, 80);
			especieRoedorLabel.setEnabled(false);
			panel.add(especieRoedorLabel);
			
			JRadioButton conejoRB = new JRadioButton("Conejo");
			conejoRB.setBounds(especieRoedorLabel.getX(), especieRoedorLabel.getHeight() + especieRoedorLabel.getY(), 200, 25);
			conejoRB.setEnabled(false);
			panel.add(conejoRB);

			JRadioButton ratonRB = new JRadioButton("Ratón");
			ratonRB.setBounds(especieRoedorLabel.getX(), conejoRB.getHeight() + conejoRB.getY(), 200, 25);
			ratonRB.setEnabled(false);
			panel.add(ratonRB);
			
			
			JRadioButton machoRB = new JRadioButton("macho");
			machoRB.setBounds(especieRoedorLabel.getX()+especieRoedorLabel.getWidth(), especieRoedorLabel.getY(), 200, 25);
			panel.add(machoRB);

			JRadioButton hembraRB = new JRadioButton("hembra");
			hembraRB.setBounds(machoRB.getX(), machoRB.getHeight() + machoRB.getY(), 200, 25);
			panel.add(hembraRB);
			
			
			
			JButton insertarButton = new JButton("Insertar");
			insertarButton.setBounds(100, ratonRB.getY() + ratonRB.getHeight() + 50, insertarButton.getText().length()*12, 25);
			panel.add(insertarButton);

		}
		

		// JPanel de Mascota
		private static void colocaComponentesPanelMascota(JPanel panel) {
			panel.setLayout(null);

			JLabel dniClienteLabel = new JLabel("Introduce el DNI del Cliente");
			dniClienteLabel.setBounds(50, 20 , dniClienteLabel.getText().length()*12, 80);	
			panel.add(dniClienteLabel);
			
			
			JTextField dniClienteText = new JTextField(20);
			dniClienteText.setBounds(50, dniClienteLabel.getHeight() + dniClienteLabel.getY(), 200, 25);	// utilizamos posicionamiento relativo al/los componente/s anterior/es
			dniClienteText.setText("DNI Cliente");
			panel.add(dniClienteText);
			
			
			JButton buscarButton = new JButton("Buscar");
			buscarButton.setBounds(dniClienteText.getWidth() + 200, dniClienteText.getY(), 200 , 25);
			panel.add(buscarButton);
		
			
			JTextField nombreMascotaText = new JTextField(20);
			nombreMascotaText.setBounds(50, dniClienteLabel.getHeight() + dniClienteLabel.getY() + 150, 200, 25);
			nombreMascotaText.setText("Nombre Mascota");
			panel.add(nombreMascotaText);

			
			JRadioButton gatoRB = new JRadioButton("Gato");
			gatoRB.setBounds(50, nombreMascotaText.getY() + nombreMascotaText.getHeight() + 75, gatoRB.getText().length()*15, 25);
			panel.add(gatoRB);
		
			JRadioButton perroRB = new JRadioButton("Perro");
			perroRB.setBounds(50, gatoRB.getY() + gatoRB.getHeight(), 200, 25);
			panel.add(perroRB);

			JRadioButton roedorRB = new JRadioButton("Roedor");
			roedorRB.setBounds(50, perroRB.getHeight() + perroRB.getY(), 200, 25);
			panel.add(roedorRB);
			

			JTextField colorText = new JTextField(20);
			colorText.setBounds(buscarButton.getX(), gatoRB.getY(), 200, 25);
			colorText.setText("color");
			colorText.setEnabled(false);
			panel.add(colorText);
			
			JTextField razaText = new JTextField(20);
			razaText.setBounds(colorText.getX(), perroRB.getY(), 200, 25);
			razaText.setText("raza");
			razaText.setEnabled(false);
			panel.add(razaText);

			
			JRadioButton conejoRB = new JRadioButton("Conejo");
			conejoRB.setBounds(razaText.getX(), razaText.getHeight() + razaText.getY() + 105, 200, 25);
			conejoRB.setEnabled(false);
			panel.add(conejoRB);

			JRadioButton ratonRB = new JRadioButton("Roedor");
			ratonRB.setBounds(conejoRB.getX(), conejoRB.getY() + conejoRB.getHeight(), 200, 25);
			ratonRB.setEnabled(false);
			panel.add(ratonRB);
			
			
			JRadioButton machoRB = new JRadioButton("macho");
			machoRB.setBounds(razaText.getX() + razaText.getWidth() + 25, colorText.getY(), 200, 25);
			panel.add(machoRB);

			JRadioButton hembraRB = new JRadioButton("hembra");
			hembraRB.setBounds(razaText.getX() + razaText.getWidth() + 25, razaText.getY(), 200, 25);
			panel.add(hembraRB);
			
			
			
			JButton insertarButton = new JButton("Insertar");
			insertarButton.setBounds(100, ratonRB.getY() + ratonRB.getHeight() + 50, insertarButton.getText().length()*12, 25);
			panel.add(insertarButton);
		}
		


		// JPanel de Tratamiento
		private static void colocaComponentesPanelTratamiento(JPanel panel) {
			panel.setLayout(null);

			JTextField dniClienteText = new JTextField(20);
			dniClienteText.setBounds(50, 20, 200, 25);	// utilizamos posicionamiento relativo al/los componente/s anterior/es
			dniClienteText.setText("DNI Cliente");
			panel.add(dniClienteText);
			
			JButton buscarButton = new JButton("Buscar");
			buscarButton.setBounds(dniClienteText.getWidth() + 150, dniClienteText.getY(), 150 , 25);
			panel.add(buscarButton);
			
			Vector mascotas = new Vector<>();
		    mascotas.addElement("Mascotas");
		    //mascotas.addElement("Mascota #1");
		    //mascotas.addElement("Mascota #2");
			JComboBox mascotasComboBox = new JComboBox<>(mascotas);
			mascotasComboBox.setBounds(buscarButton.getX() + buscarButton.getWidth() + 100, buscarButton.getY(), 200, 25);
			mascotasComboBox.setEnabled(false);
			panel.add(mascotasComboBox);
			
			JLabel datosMascotaLabel = new JLabel("Datos mascota");
			datosMascotaLabel.setBounds(dniClienteText.getX(), dniClienteText.getY() + 50, 200, 25);
			panel.add(datosMascotaLabel);
			
			JLabel tratamientoLabel = new JLabel("Tratamiento");
			tratamientoLabel.setBounds(dniClienteText.getX(), datosMascotaLabel.getY() + 100, 200, 25);
			panel.add(tratamientoLabel);
			
			JTextField fechaText = new JTextField(20);
			fechaText.setBounds(dniClienteText.getX(), tratamientoLabel.getHeight() + tratamientoLabel.getY(), 200, 25);
			fechaText.setText("Fecha");
			fechaText.setEnabled(false);
			panel.add(fechaText);
			
			JTextField tratamientoText = new JTextField(20);
			tratamientoText.setBounds(buscarButton.getX(), fechaText.getY(), 200, 25);
			tratamientoText.setText("Tratamiento");
			tratamientoText.setEnabled(false);
			panel.add(tratamientoText);
			
			JButton anadirButton = new JButton("Añadir");
			anadirButton.setBounds(mascotasComboBox.getX() + 50, tratamientoText.getY(), 150 , 25);
			panel.add(anadirButton);

			JTextArea listadoTA = new JTextArea();
			listadoTA.setBounds(fechaText.getX(), fechaText.getY() + fechaText.getHeight() + 25, datosMascotaLabel.getY() + 430 , 400);
			panel.add(listadoTA);		
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(((JMenuItem)e.getSource()).getText());
			if(e.getSource() == jmiRegistro ) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panelRegistro);
				frame.validate();
				frame.repaint();
				
			}
			else if (e.getSource() == jmiNuevaMascota ) {
				frame.getContentPane().removeAll();
				frame.remove(panelTratamiento);
				frame.add(panelMascota);
				frame.validate();
				frame.repaint();
			}
			else if( e.getSource() == jmiTratamiento ) {
				frame.getContentPane().removeAll();
				frame.remove(panelTratamiento);
				frame.add(panelTratamiento);
				frame.validate();
				frame.repaint();
			}
			
		}
		

	}



