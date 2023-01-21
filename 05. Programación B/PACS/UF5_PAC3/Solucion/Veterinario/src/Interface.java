import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JFrame implements ActionListener {
	private JFrame frame;
	private JPanel panelInicial;
	private JPanel panelRegistro;
	private JPanel panelTratamiento;
	private JPanel panelNuevaMascota;
	
	private Container contentPane;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem registro, tratamiento, nuevaMascota;
	
	private JLabel label;
	
	//Campos panel registro
	private JLabel registroC;
	private JLabel registroM;
	private JLabel tipo;
	private JLabel roedorT;
		
	private JTextField nombreC;
	private JTextField dniC;
	private JTextField direccionC;
	private JTextField nombreM;
	
	private ButtonGroup tipoM;
	private ButtonGroup tipoR;
	private ButtonGroup genero;
	
	private JRadioButton gato;
	private JRadioButton perro;
	private JRadioButton roedor;
	
	private JRadioButton conejo;
	private JRadioButton raton;
	
	private JRadioButton macho;
	private JRadioButton hembra;
	
	private JTextField color;
	private JTextField raza;
	
	private JButton insertar;
	
	//Campos panel tratamiento
	private JLabel datosM;
	private JLabel tratamientoM;
	
	private JTextField dni;
	private JTextField fecha;
	private JTextField tratamientoMascota;
	
	private JLabel nombreMascota;
	private JLabel tipoMascota;
	
	private JButton buscar;
	private JButton añadir;
	
	private JComboBox mascotas;
	
	private JList tratamientos;
	
	//Campos panel nuevaMascota (comparte muchos elementos con registro)
	private JLabel dniCliente;
	private JLabel nombreCliente;
	
	private JTextField dniBuscar;
	
	private JButton buscarC;
	
	private ArrayList<Cliente> clientes;
	private int indice;
	private int indice2;
	
	Interface () {
		frame = new JFrame("Clínica veterinaria");
		panelInicial = new JPanel();
		panelRegistro = new JPanel();
		panelTratamiento = new JPanel();
		panelNuevaMascota = new JPanel();
		
		clientes = new ArrayList<>();
				
		//Indicamos la medida de la ventana
		frame.setBounds(10,20,1000,700);
			
		//Asignamos la acción por defecto a la X de la ventana, aunque en Swing ya trae una
	    //por defecto para cerrar la ventana, nos aseguramos de que se cierra
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = frame.getContentPane();
		
		//Creamos el menú
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu ("Opciones");
		menuBar.add(menu);
		
		registro = new JMenuItem ("Registro");
		registro.addActionListener(this);
		menu.add(registro);
		
		tratamiento = new JMenuItem ("Tratamiento");
		tratamiento.addActionListener(this);
		menu.add(tratamiento);
		
		nuevaMascota = new JMenuItem("Nueva mascota");
		nuevaMascota.addActionListener(this);
		menu.add(nuevaMascota);
		
		//Pantalla inicio
		label = new JLabel();
		label.setText("Bienvenido a la Clínica VetIlerna");
		label.setFont(new Font("Helvetica", Font.BOLD, 30));
	}
	
	public void inicializar () {
		//Ponemos visible la ventana
		frame.setVisible(true);

		menuBar.setVisible(true);
		
		panelInicial.setLayout(null);
			
		label.setBounds(300,100,700,350);
		panelInicial.add(label);
		
		contentPane.add(panelInicial);
	}
	
	public void registro () {
		panelRegistro.setLayout(null);
		
		registroC = new JLabel("Registro Cliente");
		registroC.setBounds(100, 20, 200, 20);
		
		registroM = new JLabel("Datos mascota");
		registroM.setBounds(100, 150, 200, 20);
		
		tipo = new JLabel("Tipo");
		tipo.setBounds(100, 250, 200, 20);
		
		roedorT = new JLabel("Especialización de roedor");
		roedorT.setBounds(400, 360, 200, 20);
		roedorT.setEnabled(false);
		
		nombreC = new JTextField("Nombre Cliente");
		nombreC.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				nombreC.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		nombreC.setBounds(100, 50, 200, 20);
		
		dniC = new JTextField("DNI Cliente");
		dniC.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				dniC.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		dniC.setBounds(400, 50, 200, 20);
		
		direccionC = new JTextField("Dirección Cliente");
		direccionC.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				direccionC.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		direccionC.setBounds(100, 100, 200, 20);

		nombreM = new JTextField("Nombre Mascota");
		nombreM.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				nombreM.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		nombreM.setBounds(100, 200, 200, 20);
		
		tipoM = new ButtonGroup();
		gato = new JRadioButton("Gato");
		gato.setBounds(100, 300, 200, 20);
		gato.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (gato.isSelected()) 
					color.setEnabled(true);
				else 
					color.setEnabled(false);
			}
			
		});
		tipoM.add(gato);
		
		perro = new JRadioButton("Perro");
		perro.setBounds(100, 330, 200, 20);
		perro.addActionListener(this);
		perro.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (perro.isSelected()) 
					raza.setEnabled(true);
				else 
					raza.setEnabled(false);
			}
			
		});
		tipoM.add(perro);
		
		roedor = new JRadioButton("Roedor");
		roedor.setBounds(100, 360, 200, 20);
		roedor.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (roedor.isSelected()) {
					roedorT.setEnabled(true);
					conejo.setEnabled(true);
					raton.setEnabled(true);
				} else {
					roedorT.setEnabled(false);
					conejo.setEnabled(false);
					raton.setEnabled(false);
				}
			}
			
		});
		tipoM.add(roedor);
		
		tipoR = new ButtonGroup();
				
		conejo = new JRadioButton("Conejo");
		conejo.setBounds(400, 410, 200, 20);
		conejo.setEnabled(false);
		tipoR.add(conejo);
				
		raton = new JRadioButton("Ratón");
		raton.setBounds(400, 440, 200, 20);
		raton.setEnabled(false);
		tipoR.add(raton);
		
		genero = new ButtonGroup();
		
		macho = new JRadioButton("macho");
		macho.setBounds(700, 300, 200, 20);
		genero.add(macho);
		
		hembra = new JRadioButton("hembra");
		hembra.setBounds(700, 330, 200, 20);
		genero.add(hembra);
		
		color = new JTextField("color");
		color.setBounds(400, 300, 200, 20);
		color.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				color.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		color.setEnabled(false);
		
		raza = new JTextField("raza");
		raza.setBounds(400, 330, 200, 20);
		raza.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				raza.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		raza.setEnabled(false);
		
		insertar = new JButton("Insertar");
		insertar.setBounds(150, 500, 100, 20);
		insertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Mascota mascota = null;
				
				if (gato.isSelected()) {
					if (macho.isSelected()) {
						mascota = new Gato(nombreM.getText().toString(), Genero.macho, color.getText().toString());
					} else {
						mascota = new Gato(nombreM.getText().toString(), Genero.hembra, color.getText().toString());
					}
				} else if (perro.isSelected()) {
					if (macho.isSelected()) {
						mascota = new Perro(nombreM.getText().toString(), Genero.macho, raza.getText().toString());
					} else {
						mascota = new Perro(nombreM.getText().toString(), Genero.hembra, raza.getText().toString());
					}
				} else if (roedor.isSelected()) {
					String tipo =  "";
					
					if (conejo.isSelected()) {
						tipo = "conejo";
					} else {
						tipo = "raton";
					}
					
					if (macho.isSelected()) {
						mascota = new Roedor(nombreM.getText().toString(), Genero.macho, tipo);
					} else {
						mascota = new Roedor(nombreM.getText().toString(), Genero.hembra, tipo);
					}
				}
				
				Cliente cliente = new Cliente(nombreC.getText().toString(), dniC.getText().toString());
				cliente.añadirMascota(mascota);
				
				clientes.add(cliente);
				
				System.out.println(cliente.toString());
			}
			
		});
		
		panelRegistro.add(registroC);
		panelRegistro.add(registroM);
		panelRegistro.add(tipo);
		panelRegistro.add(roedorT);
		
		panelRegistro.add(nombreC);
		panelRegistro.add(dniC);
		panelRegistro.add(direccionC);
		panelRegistro.add(nombreM);
		
		panelRegistro.add(gato);
		panelRegistro.add(perro);
		panelRegistro.add(roedor);
		
		panelRegistro.add(conejo);
		panelRegistro.add(raton);
		
		panelRegistro.add(color);
		panelRegistro.add(raza);
		
		panelRegistro.add(macho);
		panelRegistro.add(hembra);
		
		panelRegistro.add(insertar);
		
		contentPane.remove(panelInicial);
		contentPane.remove(panelTratamiento);
		contentPane.remove(panelNuevaMascota);
		contentPane.add(panelRegistro);
		panelRegistro.updateUI();
	}
	
	public void tratamiento () {
		panelTratamiento.setLayout(null);
		
		datosM = new JLabel("Datos mascota");
		datosM.setBounds(100, 50, 200, 20);
		
		tratamientoM = new JLabel("Tratamiento");
		tratamientoM.setBounds(100, 120, 200, 20);
		
		dni = new JTextField("DNI cliente");
		dni.setBounds(100, 20, 200, 20);
		dni.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				dni.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		fecha = new JTextField("Fecha");
		fecha.setBounds(100, 150, 200, 20);
		fecha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				fecha.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		fecha.setEnabled(false);
		
		tratamientoMascota = new JTextField("Tratamiento");
		tratamientoMascota.setBounds(400, 150, 200, 20);
		tratamientoMascota.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				tratamientoMascota.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		tratamientoMascota.setEnabled(false);
		
		nombreMascota = new JLabel("");
		nombreMascota.setBounds(100, 80, 200, 20);
		
		tipoMascota = new JLabel("");
		tipoMascota.setBounds(400, 80, 200, 20);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(400, 20, 100, 20);
				
		mascotas = new JComboBox();
		mascotas.addItem("Mascotas");
		
		mascotas.addItemListener(new ItemListener () {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (mascotas.getSelectedItem() == "Mascotas") {
					fecha.setEnabled(false);
					tratamientoMascota.setEnabled(false);
				} else {
					fecha.setEnabled(true);
					tratamientoMascota.setEnabled(true);
				}
			}
			
		});
		mascotas.setBounds(600, 20, 200, 20);
		
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < clientes.size(); i++) {
					if (dni.getText().toString().equals(clientes.get(i).getDni())) {
						System.out.println(clientes.get(i).getNombre());
						indice = i;
						mascotas.removeAllItems();
						for (int j = 0; j < clientes.get(i).getMascota().size(); j++) {
							System.out.println(clientes.get(i).getMascota().get(j).getNombre());
							indice2 = j;
							mascotas.addItem(clientes.get(i).getMascota().get(j).getNombre());
						}
					} 
				}
			}
			
		});
		
		añadir = new JButton("Añadir");
		añadir.setBounds(700, 150, 100, 20);
		
		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HashMap <String, String> tratamiento = new HashMap<String, String>();
				
				tratamiento.put(fecha.getText().toString(), tratamientoMascota.getText().toString());
				
				System.out.println(clientes.get(indice).getMascota().get(mascotas.getSelectedIndex()));
				clientes.get(indice).getMascota().get(mascotas.getSelectedIndex()).añadirTratamientos(tratamiento);
				
				for (int i = 0; i < clientes.size(); i++) {
					System.out.println(clientes.get(i).toString());
				}
				
			}
			
		});
		
		tratamientos = new JList();
		tratamientos.setBounds(100, 200, 500, 300);
		
		panelTratamiento.add(datosM);
		panelTratamiento.add(tratamientoM);
		
		panelTratamiento.add(dni);
		panelTratamiento.add(fecha);
		panelTratamiento.add(tratamientoMascota);

		panelTratamiento.add(nombreMascota);
		panelTratamiento.add(tipoMascota);
		
		panelTratamiento.add(buscar);
		
		panelTratamiento.add(mascotas);
		
		panelTratamiento.add(añadir);
		
		panelTratamiento.add(tratamientos);
		
		contentPane.remove(panelInicial);
		contentPane.remove(panelRegistro);
		contentPane.remove(panelNuevaMascota);
		contentPane.add(panelTratamiento);
		panelTratamiento.updateUI();
	}
	
	public void nuevaMascota () {	
		indice = -1;
		
		panelNuevaMascota.setLayout(null);
		
		dniCliente = new JLabel("Introduce el DNI del cliente");
		dniCliente.setBounds(100, 50, 200, 20);
		
		dniBuscar = new JTextField("DNI cliente");
		dniBuscar.setBounds(100, 80, 200, 20);
		
		nombreM.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				dniBuscar.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		buscarC = new JButton("Buscar");
		buscarC.setBounds(400, 65, 100, 20);
		
		nombreCliente = new JLabel("");
		nombreCliente.setBounds(600, 80, 200, 20);
		
		nombreM = new JTextField("Nombre Mascota");
		nombreM.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				nombreM.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		buscarC.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < clientes.size(); i++) {
					if (dniBuscar.getText().toString().equals(clientes.get(i).getDni())) {
						nombreCliente.setText(clientes.get(i).getNombre());
						System.out.println(clientes.get(i).getNombre());
						indice = i;
					}
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		nombreM.setBounds(100, 200, 200, 20);
		
		tipoM = new ButtonGroup();
		gato = new JRadioButton("Gato");
		gato.setBounds(100, 300, 200, 20);
		gato.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (gato.isSelected()) 
					color.setEnabled(true);
				else 
					color.setEnabled(false);
			}
			
		});
		tipoM.add(gato);
		
		perro = new JRadioButton("Perro");
		perro.setBounds(100, 330, 200, 20);
		perro.addActionListener(this);
		perro.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (perro.isSelected()) 
					raza.setEnabled(true);
				else 
					raza.setEnabled(false);
			}
			
		});
		tipoM.add(perro);
		
		roedor = new JRadioButton("Roedor");
		roedor.setBounds(100, 360, 200, 20);
		roedor.addChangeListener(new ChangeListener () {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				if (roedor.isSelected()) {
					roedorT.setEnabled(true);
					conejo.setEnabled(true);
					raton.setEnabled(true);
				} else {
					roedorT.setEnabled(false);
					conejo.setEnabled(false);
					raton.setEnabled(false);
				}
			}
			
		});
		tipoM.add(roedor);
		
		tipoR = new ButtonGroup();
				
		conejo = new JRadioButton("Conejo");
		conejo.setBounds(400, 410, 200, 20);
		conejo.setEnabled(false);
		tipoR.add(conejo);
				
		raton = new JRadioButton("Ratón");
		raton.setBounds(400, 440, 200, 20);
		raton.setEnabled(false);
		tipoR.add(raton);
		
		genero = new ButtonGroup();
		
		macho = new JRadioButton("macho");
		macho.setBounds(700, 300, 200, 20);
		genero.add(macho);
		
		hembra = new JRadioButton("hembra");
		hembra.setBounds(700, 330, 200, 20);
		genero.add(hembra);
		
		color = new JTextField("color");
		color.setBounds(400, 300, 200, 20);
		color.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				color.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		color.setEnabled(false);
		
		raza = new JTextField("raza");
		raza.setBounds(400, 330, 200, 20);
		raza.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				raza.setText("");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		raza.setEnabled(false);
		
		insertar = new JButton("Insertar");
		insertar.setBounds(150, 500, 100, 20);
		insertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!nombreCliente.getText().toString().equals("")) {
					Mascota mascota = null;
					
					if (gato.isSelected()) {
						if (macho.isSelected()) {
							mascota = new Gato(nombreM.getText().toString(), Genero.macho, color.getText().toString());
						} else {
							mascota = new Gato(nombreM.getText().toString(), Genero.hembra, color.getText().toString());
						}
					} else if (perro.isSelected()) {
						if (macho.isSelected()) {
							mascota = new Perro(nombreM.getText().toString(), Genero.macho, raza.getText().toString());
						} else {
							mascota = new Perro(nombreM.getText().toString(), Genero.hembra, raza.getText().toString());
						}
					} else if (roedor.isSelected()) {
						String tipo =  "";
						
						if (conejo.isSelected()) {
							tipo = "conejo";
						} else {
							tipo = "raton";
						}
						
						if (macho.isSelected()) {
							mascota = new Roedor(nombreM.getText().toString(), Genero.macho, tipo);
						} else {
							mascota = new Roedor(nombreM.getText().toString(), Genero.hembra, tipo);
						}
					}
										
					clientes.get(indice).añadirMascota(mascota);
					

					System.out.println(clientes.get(indice).toString());
				}
			}
			
		});
		
		panelNuevaMascota.add(dniCliente);
		panelNuevaMascota.add(dniBuscar);
		panelNuevaMascota.add(buscarC);
		panelNuevaMascota.add(nombreCliente);
		
		panelNuevaMascota.add(nombreM);
		
		panelNuevaMascota.add(gato);
		panelNuevaMascota.add(perro);
		panelNuevaMascota.add(roedor);
		
		panelNuevaMascota.add(conejo);
		panelNuevaMascota.add(raton);
		
		panelNuevaMascota.add(color);
		panelNuevaMascota.add(raza);
		
		panelNuevaMascota.add(macho);
		panelNuevaMascota.add(hembra);
		
		panelNuevaMascota.add(insertar);
		
		contentPane.remove(panelInicial);
		contentPane.remove(panelTratamiento);
		contentPane.remove(panelRegistro);
		contentPane.add(panelNuevaMascota);
		panelNuevaMascota.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == registro) {
			registro ();
		} else if (arg0.getSource() == tratamiento) {
			tratamiento ();
		} else if (arg0.getSource() == nuevaMascota) {
			nuevaMascota ();
		}
		
	}
	
}
