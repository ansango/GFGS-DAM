
package grafico;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import VetIlerna.Cliente;
import VetIlerna.Gato;
import VetIlerna.Mascota;
import VetIlerna.Perro;
import VetIlerna.Roedor;

public class VentanaDefinitiva implements ActionListener {
	
	private ArrayList<Cliente> clientes;
	
	private JFrame frame;
	private JMenuItem jmiRegistro;
	private JMenuItem jmiNuevaMascota;
	private JMenuItem jmiTratamiento;
	private JPanel panel1;
	private JPanel panelRegistro;
	private JPanel panelMascota;
	private JPanel panelTratamiento;
	
	/* Panel de registro */
	private JLabel reg_regClienteLabel;
	private JTextField reg_nombreClienteText;
	private JTextField reg_direccionClienteText;
	private JTextField reg_dniClienteText;
	private JLabel reg_datosMascotaLabel;
	private JTextField reg_nombreMascotaText;
	private JLabel reg_tipoLabel;
	private ButtonGroup reg_tipoMascotaBG;
	private JRadioButton reg_gatoRB;
	private JRadioButton reg_perroRB;
	private JRadioButton reg_roedorRB;
	private JTextField reg_colorText;
	private JTextField reg_razaText;
	private JLabel reg_especieRoedorLabel;
	private ButtonGroup reg_especieRoedor;
	private JRadioButton reg_conejoRB;
	private JRadioButton reg_ratonRB;
	private JRadioButton reg_machoRB;
	private JRadioButton reg_hembraRB;
	private JButton reg_insertarButton;
	private ButtonGroup reg_sexoBG;
	
	
	/* Panel tratamiento */

	private JTextField trat_dniClienteText;
	private JButton trat_buscarButton;
	private Vector<String> trat_mascotas;
	private JComboBox<String> trat_mascotasComboBox;
	private JLabel trat_datosMascotaLabel;
	private JLabel trat_datosMascotaSeleccionadaLabel;
	private JLabel trat_tratamientoLabel;
	private JTextField trat_fechaText;
	private JTextField trat_tratamientoText;
	private JButton trat_anadirButton;
	private JTextArea trat_listadoTA;
	
	
	/* Panel nueva mascota */
    private JLabel nue_dniClienteLabel;
    private JTextField nue_dniClienteText;
    private JButton nue_buscarButton;
    private JLabel nue_nombre_clienteLabel;
    private JTextField nue_nombreMascotaText;
    private ButtonGroup nue_tipoMascotaBG;
    private JRadioButton nue_gatoRB;
    private JRadioButton nue_perroRB;
    private JRadioButton nue_roedorRB;
    private JTextField nue_colorText;
    private JTextField nue_razaText;
    private JLabel nue_especieRoedorLabel;
    private ButtonGroup nue_especieRoedor;
    private JRadioButton nue_conejoRB;
    private JRadioButton nue_ratonRB;
    private ButtonGroup nue_sexoRB;
    private JRadioButton nue_machoRB;
    private JRadioButton nue_hembraRB;
    private JButton nue_insertarButton;
    
    private BBDDVetIlerna bbddMySQL;
	
	
	
	public VentanaDefinitiva(ArrayList<Cliente> clientes) {
		
		this.clientes = clientes;
		
		//UF6-PAC2 conexion objeto bbdd
		
		bbddMySQL = new BBDDVetIlerna("mysql.hostinger.es", "3306", "u508027557_ansan", "u508027557_asg", "721989");
		
		
		frame = new JFrame("Clínica veterinaria");
		frame.setSize(900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// UF5_PAC4
		
		frame.addWindowListener(new WindowListener() { //creamo objeto anonimo
			
			@Override
			public void windowClosing(WindowEvent e) {
				String ruta = "vetilerna.bin";
				try {
					FileOutputStream fos = new FileOutputStream(ruta);

					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject(clientes);
					
					oos.close();
					
				} catch ( IOException ex ) {
					
					System.out.println("ERROR: el fichero no existe");
					ex.printStackTrace();
				} 
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowOpened(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowDeactivated(WindowEvent e) {}
		});
			
		
			
			
		
		
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
	private void colocaComponentesPanel1(JPanel panel) {
		panel.setLayout(null);

		JLabel bienvenidaLabel = new JLabel("Bienvenido a la Clínica VetIlerna");
		bienvenidaLabel.setFont(new Font(null, 0, 30));
		bienvenidaLabel.setBounds(200, 250 , bienvenidaLabel.getText().length()*30, 80);
		panel.add(bienvenidaLabel);
	}
	
	

	/* 
	 * JPanel de Registro
	 */
	private void colocaComponentesPanelRegistro(JPanel panel) {
		panel.setLayout(null);

		reg_regClienteLabel = new JLabel("Registro Cliente");
		reg_regClienteLabel.setBounds(50, 20, reg_regClienteLabel.getText().length()*12, 80);	// utilizamos tamaño relativo al contenido
		panel.add(reg_regClienteLabel);
		
		
		reg_nombreClienteText = new JTextField(20);
		reg_nombreClienteText.setBounds(50, reg_regClienteLabel.getHeight() + reg_regClienteLabel.getY(), 200, 25);	// utilizamos posicionamiento relativo al/los componente/s anterior/es
		reg_nombreClienteText.setText("Nombre Cliente");
		panel.add(reg_nombreClienteText);
		reg_nombreClienteText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(reg_nombreClienteText.getText().equals("") )
					reg_nombreClienteText.setText("Nombre Cliente");					
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(reg_nombreClienteText.getText().equals("Nombre Cliente") )
					reg_nombreClienteText.setText("");					
			}
		});
		
		
		reg_direccionClienteText = new JTextField(20);
		reg_direccionClienteText.setBounds(50, reg_nombreClienteText.getHeight() + reg_nombreClienteText.getY() + 20, 200, 25);
		reg_direccionClienteText.setText("Direccion Cliente");
		panel.add(reg_direccionClienteText);
		reg_direccionClienteText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(reg_direccionClienteText.getText().equals("") )
					reg_direccionClienteText.setText("Direccion Cliente");					
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(reg_direccionClienteText.getText().equals("Direccion Cliente") )
					reg_direccionClienteText.setText("");
			}
		});
		
		
		reg_dniClienteText = new JTextField(20);
		reg_dniClienteText.setBounds(reg_nombreClienteText.getWidth() + 200, reg_nombreClienteText.getY(), 200 , 25);
		reg_dniClienteText.setText("DNI Cliente");
		panel.add(reg_dniClienteText);
		reg_dniClienteText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(reg_dniClienteText.getText().equals("") )
					reg_dniClienteText.setText("DNI Cliente");					
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(reg_dniClienteText.getText().equals("DNI Cliente") )
					reg_dniClienteText.setText("");
			}
		});
		
	
		
		reg_datosMascotaLabel = new JLabel("Datos mascota");
		reg_datosMascotaLabel.setBounds(50, reg_dniClienteText.getY() + reg_dniClienteText.getHeight() + 50, reg_datosMascotaLabel.getText().length()*12, 80);
		panel.add(reg_datosMascotaLabel);
		
		reg_nombreMascotaText = new JTextField(20);
		reg_nombreMascotaText.setBounds(50, reg_datosMascotaLabel.getHeight() + reg_datosMascotaLabel.getY(), 200, 25);
		reg_nombreMascotaText.setText("Nombre Mascota");
		panel.add(reg_nombreMascotaText);
		reg_nombreMascotaText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(reg_nombreMascotaText.getText().equals("") )
					reg_nombreMascotaText.setText("Nombre Mascota");
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(reg_nombreMascotaText.getText().equals("Nombre Mascota") )
					reg_nombreMascotaText.setText("");
			}
		});

		
		reg_tipoLabel = new JLabel("Tipo");
		reg_tipoLabel.setBounds(50, reg_nombreMascotaText.getY() + reg_nombreMascotaText.getHeight() + 20, reg_tipoLabel.getText().length()*12, 80);
		panel.add(reg_tipoLabel);
		
		
		reg_tipoMascotaBG = new ButtonGroup();
		
		reg_gatoRB = new JRadioButton("Gato");
		reg_gatoRB.setBounds(50, reg_tipoLabel.getHeight() + reg_tipoLabel.getY(), 200, 25);
		reg_gatoRB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (reg_gatoRB.isSelected()) 
					reg_colorText.setEnabled(true);
				else 
					reg_colorText.setEnabled(false);
			}
		});
		reg_tipoMascotaBG.add(reg_gatoRB);
		panel.add(reg_gatoRB);

		
		reg_perroRB = new JRadioButton("Perro");
		reg_perroRB.setBounds(50, reg_gatoRB.getHeight() + reg_gatoRB.getY(), 200, 25);
		reg_perroRB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (reg_perroRB.isSelected()) 
					reg_razaText.setEnabled(true);
				else
					reg_razaText.setEnabled(false);
			}
		});
		reg_tipoMascotaBG.add(reg_perroRB);
		panel.add(reg_perroRB);
		
		reg_roedorRB = new JRadioButton("Roedor");
		reg_roedorRB.setBounds(50, reg_perroRB.getHeight() + reg_perroRB.getY(), 200, 25);
		reg_roedorRB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (reg_roedorRB.isSelected()) {
					reg_especieRoedorLabel.setEnabled(true);
					reg_conejoRB.setEnabled(true);
					reg_ratonRB.setEnabled(true);
				} else {
					reg_especieRoedorLabel.setEnabled(false);
					reg_conejoRB.setEnabled(false);
					reg_ratonRB.setEnabled(false);
				}
			}
		});
		reg_tipoMascotaBG.add(reg_roedorRB);
		panel.add(reg_roedorRB);

		
		reg_colorText = new JTextField(20);
		reg_colorText.setBounds(reg_dniClienteText.getX(), reg_gatoRB.getY(), 200, 25);
		reg_colorText.setText("color");
		reg_colorText.setEnabled(false);
		panel.add(reg_colorText);
		
		reg_razaText = new JTextField(20);
		reg_razaText.setBounds(reg_colorText.getX(), reg_perroRB.getY(), 200, 25);
		reg_razaText.setText("raza");
		reg_razaText.setEnabled(false);
		panel.add(reg_razaText);

		
		reg_especieRoedorLabel = new JLabel("Especialización de Roedor");
		reg_especieRoedorLabel.setBounds(reg_razaText.getX(), reg_roedorRB.getY() - reg_roedorRB.getHeight(), reg_especieRoedorLabel.getText().length()*12, 80);
		reg_especieRoedorLabel.setEnabled(false);
		panel.add(reg_especieRoedorLabel);
		
		reg_especieRoedor = new ButtonGroup();
		
		reg_conejoRB = new JRadioButton("Conejo");
		reg_conejoRB.setBounds(reg_especieRoedorLabel.getX(), reg_especieRoedorLabel.getHeight() + reg_especieRoedorLabel.getY(), 200, 25);
		reg_conejoRB.setEnabled(false);
		reg_especieRoedor.add(reg_conejoRB);
		panel.add(reg_conejoRB);

		reg_ratonRB = new JRadioButton("Ratón");
		reg_ratonRB.setBounds(reg_especieRoedorLabel.getX(), reg_conejoRB.getHeight() + reg_conejoRB.getY(), 200, 25);
		reg_ratonRB.setEnabled(false);
		reg_especieRoedor.add(reg_ratonRB);
		panel.add(reg_ratonRB);
		
		
		reg_sexoBG = new ButtonGroup();
		
		reg_machoRB = new JRadioButton("macho");
		reg_machoRB.setBounds(reg_especieRoedorLabel.getX()+reg_especieRoedorLabel.getWidth(), reg_especieRoedorLabel.getY()-25, 200, 25);
		reg_sexoBG.add(reg_machoRB);
		panel.add(reg_machoRB);

		reg_hembraRB = new JRadioButton("hembra");
		reg_hembraRB.setBounds(reg_machoRB.getX(), reg_machoRB.getHeight() + reg_machoRB.getY(), 200, 25);
		reg_sexoBG.add(reg_hembraRB);
		panel.add(reg_hembraRB);
		
		
		
		reg_insertarButton = new JButton("Insertar");
		reg_insertarButton.setBounds(100, reg_ratonRB.getY() + reg_ratonRB.getHeight() + 50, reg_insertarButton.getText().length()*12, 25);
		panel.add(reg_insertarButton);
		
		// asignamos un escuchador de acciones al botón de insertar
		reg_insertarButton.addActionListener(this);

	}
	
	

	/* 
	 * JPanel de Nueva Mascota
	 */
    private void colocaComponentesPanelMascota(JPanel panel) {
        panel.setLayout(null);

        nue_dniClienteLabel = new JLabel("Introduce el DNI del Cliente");
        nue_dniClienteLabel.setBounds(50, 20 , nue_dniClienteLabel.getText().length()*12, 80);  
        panel.add(nue_dniClienteLabel);
        
        
        nue_dniClienteText = new JTextField(20);
        nue_dniClienteText.setBounds(50, nue_dniClienteLabel.getHeight() + nue_dniClienteLabel.getY(), 200, 25);    // utilizamos posicionamiento relativo al/los componente/s anterior/es
        nue_dniClienteText.setText("DNI Cliente");
        panel.add(nue_dniClienteText);
        nue_dniClienteText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(nue_dniClienteText.getText().equals("") )
					nue_dniClienteText.setText("DNI Cliente");					
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(nue_dniClienteText.getText().equals("DNI Cliente") )
					nue_dniClienteText.setText("");
			}
		});
        
        nue_buscarButton = new JButton("Buscar");
        nue_buscarButton.setBounds(nue_dniClienteText.getWidth() + 200, nue_dniClienteText.getY(), 200 , 25);
        panel.add(nue_buscarButton);
        nue_buscarButton.addActionListener(this);

        nue_nombre_clienteLabel = new JLabel("nombre cliente");
        nue_nombre_clienteLabel.setBounds(50, nue_dniClienteText.getHeight() + nue_dniClienteText.getY()+20, 200, 25);
        panel.add(nue_nombre_clienteLabel);
        
        nue_nombreMascotaText = new JTextField(20);
        nue_nombreMascotaText.setBounds(50, nue_dniClienteLabel.getHeight() + nue_dniClienteLabel.getY() + 150, 200, 25);
        nue_nombreMascotaText.setText("Nombre Mascota");
        panel.add(nue_nombreMascotaText);
        nue_nombreMascotaText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(nue_nombreMascotaText.getText().equals("") )
					nue_nombreMascotaText.setText("Nombre Mascota");			
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(nue_nombreMascotaText.getText().equals("Nombre Mascota") )
					nue_nombreMascotaText.setText("");
			}
		});

        nue_tipoMascotaBG = new ButtonGroup();
        nue_gatoRB = new JRadioButton("Gato");
        nue_gatoRB.setBounds(50, nue_nombreMascotaText.getY() + nue_nombreMascotaText.getHeight() + 75, nue_gatoRB.getText().length()*15, 25);
        panel.add(nue_gatoRB);
        nue_tipoMascotaBG.add(nue_gatoRB);
        nue_gatoRB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (nue_gatoRB.isSelected()) 
					nue_colorText.setEnabled(true);
				else
					nue_colorText.setEnabled(false);
			}
		});

        nue_perroRB = new JRadioButton("Perro");
        nue_perroRB.setBounds(50, nue_gatoRB.getY() + nue_gatoRB.getHeight(), 200, 25);
        panel.add(nue_perroRB);
        nue_tipoMascotaBG.add(nue_perroRB);
        nue_perroRB.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (nue_perroRB.isSelected()) 
					nue_razaText.setEnabled(true);
				else
					nue_razaText.setEnabled(false);
			}
		});

        nue_roedorRB = new JRadioButton("Roedor");
        nue_roedorRB.setBounds(50, nue_perroRB.getHeight() + nue_perroRB.getY(), 200, 25);
        panel.add(nue_roedorRB);
        nue_tipoMascotaBG.add(nue_roedorRB);
        nue_roedorRB.addChangeListener(new ChangeListener() {
        	@Override
			public void stateChanged(ChangeEvent e) {
	                if (nue_roedorRB.isSelected()) {
	                    nue_especieRoedorLabel.setEnabled(true);
	                    nue_conejoRB.setEnabled(true);
	                    nue_ratonRB.setEnabled(true);
		            } else {
		                    nue_especieRoedorLabel.setEnabled(false);
		                    nue_conejoRB.setEnabled(false);
		                    nue_ratonRB.setEnabled(false);
		            }
        		}
			});
        

        nue_colorText = new JTextField(20);
        nue_colorText.setBounds(nue_buscarButton.getX(), nue_gatoRB.getY(), 200, 25);
        nue_colorText.setText("color");
        nue_colorText.setEnabled(false);
        panel.add(nue_colorText);
        
        nue_razaText = new JTextField(20);
        nue_razaText.setBounds(nue_colorText.getX(), nue_perroRB.getY(), 200, 25);
        nue_razaText.setText("raza");
        nue_razaText.setEnabled(false);
        panel.add(nue_razaText);

        nue_especieRoedorLabel = new JLabel("Especialización de Roedor");
        nue_especieRoedorLabel.setBounds(nue_razaText.getX(), nue_roedorRB.getY() - nue_roedorRB.getHeight(), nue_especieRoedorLabel.getText().length()*12, 80);
        nue_especieRoedorLabel.setEnabled(false);
        panel.add(nue_especieRoedorLabel);
        
        nue_especieRoedor = new ButtonGroup();
        
        nue_conejoRB = new JRadioButton("Conejo");
        nue_conejoRB.setBounds(nue_razaText.getX(), nue_razaText.getHeight() + nue_razaText.getY() + 50, 200, 25);
        nue_conejoRB.setEnabled(false);
        panel.add(nue_conejoRB);
        nue_especieRoedor.add(nue_conejoRB);

        nue_ratonRB = new JRadioButton("Roedor");
        nue_ratonRB.setBounds(nue_conejoRB.getX(), nue_conejoRB.getY() + nue_conejoRB.getHeight(), 200, 25);
        nue_ratonRB.setEnabled(false);
        panel.add(nue_ratonRB);
        nue_especieRoedor.add(nue_ratonRB);
        
        
        nue_sexoRB = new ButtonGroup();
        
        nue_machoRB = new JRadioButton("macho");
        nue_machoRB.setBounds(nue_razaText.getX() + nue_razaText.getWidth() + 25, nue_colorText.getY(), 200, 25);
        panel.add(nue_machoRB);
        nue_sexoRB.add(nue_machoRB);

        nue_hembraRB = new JRadioButton("hembra");
        nue_hembraRB.setBounds(nue_razaText.getX() + nue_razaText.getWidth() + 25, nue_razaText.getY(), 200, 25);
        panel.add(nue_hembraRB);
        nue_sexoRB.add(nue_hembraRB);
        
        
        nue_insertarButton = new JButton("Insertar");
        nue_insertarButton.setBounds(100, nue_ratonRB.getY() + nue_ratonRB.getHeight() + 50, nue_insertarButton.getText().length()*12, 25);
        panel.add(nue_insertarButton);
        nue_insertarButton.addActionListener(this);
    }	


	/* 
	 * JPanel de Tratamiento
	 */
	
	private void colocaComponentesPanelTratamiento(JPanel panel) {
		panel.setLayout(null);

		trat_dniClienteText = new JTextField(20);
		trat_dniClienteText.setBounds(50, 20, 200, 25);	// utilizamos posicionamiento relativo al/los componente/s anterior/es
		trat_dniClienteText.setText("DNI Cliente");
		panel.add(trat_dniClienteText);
		trat_dniClienteText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(trat_dniClienteText.getText().equals("") )
					trat_dniClienteText.setText("DNI Cliente");
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(trat_dniClienteText.getText().equals("DNI Cliente") )
					trat_dniClienteText.setText("");
			}
		});
		
		trat_buscarButton = new JButton("Buscar");
		trat_buscarButton.setBounds(trat_dniClienteText.getWidth() + 150, trat_dniClienteText.getY(), 150 , 25);
		panel.add(trat_buscarButton);
		trat_buscarButton.addActionListener(this);
		
		trat_mascotasComboBox = new JComboBox<>();
		trat_mascotasComboBox.setBounds(trat_buscarButton.getX() + trat_buscarButton.getWidth() + 100, trat_buscarButton.getY(), 200, 25);
		trat_mascotasComboBox.setEnabled(false);
		trat_mascotasComboBox.addItemListener(new ItemListener () {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (trat_mascotasComboBox.getSelectedItem() == "Mascotas") {
					trat_fechaText.setEnabled(false);
					trat_tratamientoText.setEnabled(false);
				} else {
					trat_fechaText.setEnabled(true);
					trat_tratamientoText.setEnabled(true);
				}
			}
		});
		
		panel.add(trat_mascotasComboBox);
		
		trat_datosMascotaLabel = new JLabel("Datos mascota");
		trat_datosMascotaLabel.setBounds(trat_dniClienteText.getX(), trat_dniClienteText.getY() + 50, 200, 25);
		panel.add(trat_datosMascotaLabel);
		
		trat_datosMascotaSeleccionadaLabel = new JLabel("Datos mascota");
		trat_datosMascotaSeleccionadaLabel.setBounds(trat_dniClienteText.getX(), trat_datosMascotaLabel.getY() + 50, 200, 25);
		panel.add(trat_datosMascotaSeleccionadaLabel);
		
		
		trat_tratamientoLabel = new JLabel("Tratamiento");
		trat_tratamientoLabel.setBounds(trat_dniClienteText.getX(), trat_datosMascotaLabel.getY() + 100, 200, 25);
		panel.add(trat_tratamientoLabel);
		
		trat_fechaText = new JTextField(20);
		trat_fechaText.setBounds(trat_dniClienteText.getX(), trat_tratamientoLabel.getHeight() + trat_tratamientoLabel.getY(), 200, 25);
		trat_fechaText.setText("Fecha");
		trat_fechaText.setEnabled(false);
		panel.add(trat_fechaText);
		trat_fechaText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(trat_fechaText.getText().equals("") )
					trat_fechaText.setText("Fecha");
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(trat_fechaText.getText().equals("Fecha") )
					trat_fechaText.setText("");
			}
		});
		
		trat_tratamientoText = new JTextField(20);
		trat_tratamientoText.setBounds(trat_buscarButton.getX(), trat_fechaText.getY(), 200, 25);
		trat_tratamientoText.setText("Tratamiento");
		trat_tratamientoText.setEnabled(false);
		panel.add(trat_tratamientoText);
		trat_tratamientoText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(trat_tratamientoText.getText().equals("") )
					trat_tratamientoText.setText("Tratamiento");
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(trat_tratamientoText.getText().equals("Tratamiento") )
					trat_tratamientoText.setText("");
			}
		});
		
		trat_anadirButton = new JButton("Añadir");
		trat_anadirButton.setBounds(trat_mascotasComboBox.getX() + 50, trat_tratamientoText.getY(), 150 , 25);
		panel.add(trat_anadirButton);
		trat_anadirButton.addActionListener(this);

		trat_listadoTA = new JTextArea();
		trat_listadoTA.setBounds(trat_fechaText.getX(), trat_fechaText.getY() + trat_fechaText.getHeight() + 25, trat_datosMascotaLabel.getY() + 430 , 400);
		panel.add(trat_listadoTA);		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
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
		else if( e.getSource() == reg_insertarButton ) {
			
			
			// primer punto (continuacion UF5_PAC4
			
			//comprobamos validez del DNI
			
			String dni = reg_dniClienteText.getText();
			
			if(validaDNI(dni) == true ) {
				
				Mascota mascota = null;
				
				if(reg_gatoRB.isSelected()) {
					mascota = new Gato();
					((Gato) mascota).setColor(reg_colorText.getText());
				}
				else if(reg_perroRB.isSelected()) {
					mascota = new Perro();
					((Perro) mascota).setRaza(reg_razaText.getText());
				}
				else if(reg_roedorRB.isSelected()) {
					mascota = new Roedor();
					((Roedor) mascota).setTipo(reg_conejoRB.isSelected()?"conejo":"roedor");
				}
				String nombre = reg_nombreMascotaText.getText();
				mascota.setNombre(nombre);
				//mascota.setNombre(reg_nombreMascotaText.getText());
				mascota.setGenero(reg_machoRB.isSelected()?"macho":"hembra");
				
				Cliente cliente = new Cliente();
				
				cliente.setDni(dni);
				cliente.setNombre(reg_nombreClienteText.getText());
				
				cliente.addMascota(mascota);
				
				
				// añadimos el cliente a la "base de datos"
				clientes.add(cliente);
				
				/////PAC UF 6 -- 02 !!
				
				/* Guradamos el cliente en la bddd mysql
				 * 
				 * 
				 * 
				 */
				
				bbddMySQL.nuevoClienteBBDD(cliente); /// UF6 PAC 2
				
				/*
				 * 
				 * 
				 * Fin de BBDD MySQL
				 */ 
				
				
				System.out.println("Datos cliente: " + cliente);
				
			}
			
			else {
				
				System.out.println("ERROR: El DNi no es valido");
			}
			
			

		}
		else if( e.getSource() == trat_buscarButton ) {
			
			
			
			String dni = trat_dniClienteText.getText();
			
			if (validaDNI(dni) == true) {
				
				trat_mascotasComboBox.removeAllItems();
				
				for (Cliente cli: clientes) {
					if (cli.getDni().equalsIgnoreCase(dni)) {
						for (Mascota m : cli.getMascotas()) {
							String nombreMascota = m.getNombre();
							//trat_mascotas.add(nombreMascota);
							trat_mascotasComboBox.addItem(nombreMascota);
						}
						trat_mascotasComboBox.setEnabled(true);
						break;
					}
				}
				
			}
			
			else {
				System.out.println("ERROR: El DNi no es valido");
			}
						
			
		}
		else if( e.getSource() == trat_anadirButton ) {
			
			
			
			String dni = trat_dniClienteText.getText();
			
			if (validaDNI(dni) == true) {
				
				for (Cliente cli: clientes) {
					if (cli.getDni().equalsIgnoreCase(dni)) {
						for (Mascota m : cli.getMascotas()) {
							String nombreMascota = m.getNombre();
							//trat_mascotas.add(nombreMascota);
							String fecha = trat_fechaText.getText();
							String tratamiento = trat_tratamientoText.getText();
							m.addTratamiento(fecha, tratamiento);
							
							/* Guradamos el cliente en la bddd mysql
							 * 
							 * 
							 * 
							 */
							
							bbddMySQL.nuevoTratamiento(m, fecha, tratamiento); //// UF 6 PAC 2
							
							/*
							 * 
							 * 
							 * Fin de BBDD MySQL
							 */ 
							
							System.out.println(m.getNombre() + " :: fecha: " + fecha + " - tratamiento: " + tratamiento);
						}
						trat_mascotasComboBox.setEnabled(true);
						break;
					}
				}
			}
			
			else {
				System.out.println("ERROR: El DNi no es valido");
				
			}
			
			
			
		}
		
		
		else if(e.getSource() == nue_buscarButton) {
			String dni = nue_dniClienteText.getText();
			
			if (validaDNI(dni) == true) {
				for (Cliente cli: clientes) {
					if (cli.getDni().equalsIgnoreCase(dni)) {
						nue_nombre_clienteLabel.setText(cli.getNombre());
						break;
					}
					else {
						nue_nombre_clienteLabel.setText("Cliente no encontrado");
					}
				}	
			}
			
			else {
				System.out.println("ERROR: El DNi no es valido");
			}
					
		}
		else if(e.getSource() == nue_insertarButton ) {
			
			String dni = nue_dniClienteText.getText();
			
			if (validaDNI(dni) == true) {
				Mascota mascota = null;
	             
	             if(nue_gatoRB.isSelected()) {
	                     mascota = new Gato();
	                     ((Gato) mascota).setColor(nue_colorText.getText());
	             }
	             else if(nue_perroRB.isSelected()) {
	                     mascota = new Perro();
	                     ((Perro) mascota).setRaza(nue_razaText.getText());
	             }
	             else if(nue_roedorRB.isSelected()) {
	                     mascota = new Roedor();
	                     ((Roedor) mascota).setTipo(nue_conejoRB.isSelected()?"conejo":"roedor");
	             }
	             String nombre = nue_nombreMascotaText.getText();
	             mascota.setNombre(nombre);
	             //mascota.setNombre(nue_nombreMascotaText.getText());
	             mascota.setGenero(nue_machoRB.isSelected()?"macho":"hembra");
	             
	             
	             for (Cliente cli : clientes) {
	            	 	if( cli.getDni().equalsIgnoreCase(dni)) {
	            	 		cli.addMascota(mascota);
	            	 		
	            	 		/* Guradamos el cliente en la bddd mysql
	        				 * 
	        				 * 
	        				 * 
	        				 */
	        				
	        				bbddMySQL.nuevaMascotaBBDD(cli, mascota); ////// UF6 PAC 2
	        				
	        				/*
	        				 * 
	        				 * 
	        				 * Fin de BBDD MySQL
	        				 */ 
	            	 		
	            	 		System.out.println("NUEVA MASCOTA:: Datos cliente: " + cli);
	            	 		break;
	            	 		}
	            	 
	            	 
	             	}
					     
             }
			
			else {
				System.out.println("ERROR: El DNi no es valido");
			}
             
		}
		
	}
	
	// primer punto de la practica UF5_PAC4
	
	
	private boolean validaDNI(String dni) {
		
		// numeros y 1 letra (longitud 9)
		
		if (dni.length() != 9) {
			System.out.println("El DNI no tiene caraceteres correctos");
			return false;
		}
		
		else if(Character.isLetter(dni.charAt(8)) == false) {
			System.out.println("El DNI no tiene letra");
			return false;
					
		}
		
		char [] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		
		int numero= Integer.parseInt(dni.substring(0,8)); //convertirmos el dni en entero
		
		// calculamos el resto
		
		int resto = numero%23;
		
		if(letrasDNI[resto] == dni.toUpperCase().charAt(8)){
			return true;	 //la letra es correcta
		}
		
		else {
			return false; //la letra no es correcta
		}
		
				
		
	}
	
	
	

}



