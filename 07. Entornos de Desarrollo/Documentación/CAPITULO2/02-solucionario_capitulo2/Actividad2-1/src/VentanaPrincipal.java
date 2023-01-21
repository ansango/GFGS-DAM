import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal {

	private JFrame frmPruebaDeVentanas;
	private JTextField txtCod;
	private JTextField Nombre;
	private JTextField Loca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmPruebaDeVentanas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPruebaDeVentanas = new JFrame();
		frmPruebaDeVentanas.setTitle("PRUEBA DE VENTANAS");
		frmPruebaDeVentanas.setBounds(100, 100, 450, 300);
		frmPruebaDeVentanas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPruebaDeVentanas.getContentPane().setLayout(null);
		
		JLabel lblDatosDeDepartamentos = new JLabel("DATOS DE DEPARTAMENTOS");
		lblDatosDeDepartamentos.setBackground(new Color(204, 204, 204));
		lblDatosDeDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeDepartamentos.setForeground(Color.BLUE);
		lblDatosDeDepartamentos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatosDeDepartamentos.setBounds(97, 11, 232, 27);
		frmPruebaDeVentanas.getContentPane().add(lblDatosDeDepartamentos);
		
		JLabel lblCdigoDepartamento = new JLabel("C\u00F3digo Departamento: ");
		lblCdigoDepartamento.setFont(new Font("Arial", Font.BOLD, 12));
		lblCdigoDepartamento.setBounds(47, 66, 149, 27);
		frmPruebaDeVentanas.getContentPane().add(lblCdigoDepartamento);
		
		JLabel lblNombreDepartamento = new JLabel("Nombre Departamento: ");
		lblNombreDepartamento.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombreDepartamento.setBounds(47, 98, 149, 27);
		frmPruebaDeVentanas.getContentPane().add(lblNombreDepartamento);
		
		JLabel lblLocalidadDepartamento = new JLabel("Localidad Departamento: ");
		lblLocalidadDepartamento.setFont(new Font("Arial", Font.BOLD, 12));
		lblLocalidadDepartamento.setBounds(47, 126, 149, 27);
		frmPruebaDeVentanas.getContentPane().add(lblLocalidadDepartamento);
		
		txtCod = new JTextField();
		txtCod.setBackground(new Color(255, 153, 255));
		txtCod.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCod.setHorizontalAlignment(SwingConstants.CENTER);
		txtCod.setBounds(206, 70, 62, 20);
		frmPruebaDeVentanas.getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Nombre.setColumns(10);
		Nombre.setBounds(206, 102, 162, 20);
		frmPruebaDeVentanas.getContentPane().add(Nombre);
		
		Loca = new JTextField();
		Loca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Loca.setColumns(10);
		Loca.setBounds(206, 130, 162, 20);
		frmPruebaDeVentanas.getContentPane().add(Loca);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setForeground(new Color(255, 102, 255));
		panel.setBounds(22, 47, 380, 137);
		frmPruebaDeVentanas.getContentPane().add(panel);
		
		JButton btnInsertarDatos = new JButton("Insertar Datos");
		btnInsertarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(" SE HA PULSADO EL BOTÓN INSERTAR");
				
			}
		});
		btnInsertarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsertarDatos.setBounds(81, 207, 129, 23);
		frmPruebaDeVentanas.getContentPane().add(btnInsertarDatos);
		
		JButton btnLimpiarDatos = new JButton("Limpiar Datos");
		btnLimpiarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(" SE HA PULSADO EL BOTÓN LIMPIAR");
			}
		});
		btnLimpiarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiarDatos.setBounds(239, 207, 129, 23);
		frmPruebaDeVentanas.getContentPane().add(btnLimpiarDatos);
	}
}
