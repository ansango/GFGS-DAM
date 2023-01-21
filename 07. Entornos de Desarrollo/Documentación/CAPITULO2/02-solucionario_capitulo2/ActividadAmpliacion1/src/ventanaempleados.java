import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ventanaempleados extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNum;
	private JTextField txtNom;
	private JTextField txtPob;
	private JTextField txtOfi;
	private JTextField txtSala;
	private JTextField txtDep;
	private JLabel lblMensaje = new JLabel("-------------------------------------------------------------------------");
	String basedatos = "EMPLEADOS2.DAT";
	/////////////////////////////////
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaempleados frame = new ventanaempleados();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/////////////////////////////////
	public ventanaempleados() {
		
		setTitle("Mantenimiento de empleados");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("NOMBRE: Nombre de alumno");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBounds(114, 11, 234, 27);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Operaciones EMPLEADOS");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBackground(Color.ORANGE);
			label.setBounds(114, 37, 234, 27);
			contentPanel.add(label);
		}
		{
			JLabel lblNumeroEmpleado = new JLabel("N\u00FAmero Empleado:");
			lblNumeroEmpleado.setFont(new Font("Meiryo UI", Font.BOLD, 13));
			lblNumeroEmpleado.setBounds(79, 79, 151, 21);
			contentPanel.add(lblNumeroEmpleado);
		}
		{
			JLabel lblNombreempleado = new JLabel("Nombre:");
			lblNombreempleado.setFont(new Font("Meiryo UI", Font.BOLD, 13));
			lblNombreempleado.setBounds(79, 111, 76, 21);
			contentPanel.add(lblNombreempleado);
		}
		{
			JLabel lblPoblacin = new JLabel("Poblaci\u00F3n: ");
			lblPoblacin.setFont(new Font("Meiryo UI", Font.BOLD, 13));
			lblPoblacin.setBounds(79, 143, 86, 21);
			contentPanel.add(lblPoblacin);
		}
		{
			JLabel lblOficio = new JLabel("Oficio:");
			lblOficio.setFont(new Font("Meiryo UI", Font.BOLD, 13));
			lblOficio.setBounds(79, 175, 62, 21);
			contentPanel.add(lblOficio);
		}
		{
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setFont(new Font("Meiryo UI", Font.BOLD, 13));
			lblSalario.setBounds(79, 207, 76, 21);
			contentPanel.add(lblSalario);
		}
		
		txtNum = new JTextField();
		txtNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNum.setBounds(212, 80, 86, 20);
		contentPanel.add(txtNum);
		txtNum.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(142, 112, 172, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		txtPob = new JTextField();
		txtPob.setColumns(10);
		txtPob.setBounds(152, 144, 172, 20);
		contentPanel.add(txtPob);
		
		txtOfi = new JTextField();
		txtOfi.setColumns(10);
		txtOfi.setBounds(151, 177, 172, 20);
		contentPanel.add(txtOfi);
		
		txtSala = new JTextField();
		txtSala.setColumns(10);
		txtSala.setBounds(155, 208, 78, 20);
		contentPanel.add(txtSala);
		
		JButton btnInsertarEmpleado = new JButton("Insertar Empleado");
		btnInsertarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 lblMensaje.setText("INSERTAR Datos del empleado ....");				}
		});
		btnInsertarEmpleado.setForeground(Color.BLUE);
		btnInsertarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsertarEmpleado.setBounds(24, 321, 141, 22);
		contentPanel.add(btnInsertarEmpleado);
		
		JButton btnBorrarEmpleado = new JButton("Borrar Empleado");
		btnBorrarEmpleado.setForeground(Color.BLUE);
		btnBorrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		     	 lblMensaje.setText("BORRAR Datos del empleado .... ");	
			}
		});
		btnBorrarEmpleado.setBounds(175, 321, 131, 22);
		contentPanel.add(btnBorrarEmpleado);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 lblMensaje.setText("CONSULTAR Datos del empleado .... ");	
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setForeground(Color.BLUE);
		btnConsultar.setBounds(327, 75, 89, 23);
		contentPanel.add(btnConsultar);
		
		JButton btnModificarEmpleado = new JButton("Modificar Empleado");
		btnModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 lblMensaje.setText("MODIFICAR Datos del empleado ... ");	
			}
		});
		btnModificarEmpleado.setForeground(Color.BLUE);
		btnModificarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificarEmpleado.setBounds(309, 321, 143, 22);
		contentPanel.add(btnModificarEmpleado);
		
		JLabel lblNumDepartamento = new JLabel("Num Departamento:");
		lblNumDepartamento.setFont(new Font("Meiryo UI", Font.BOLD, 13));
		lblNumDepartamento.setBounds(79, 238, 164, 21);
		contentPanel.add(lblNumDepartamento);
		
		txtDep = new JTextField();
		txtDep.setBounds(238, 240, 62, 20);
		contentPanel.add(txtDep);
		txtDep.setColumns(10);
		
	
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(24, 285, 452, 14);
		contentPanel.add(lblMensaje);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.PINK);
		panel.setBounds(10, 37, 466, 322);
		contentPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}// fin clase
