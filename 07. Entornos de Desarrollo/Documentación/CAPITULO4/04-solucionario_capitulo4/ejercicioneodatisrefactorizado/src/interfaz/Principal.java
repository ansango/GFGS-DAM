package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;



/**
 * CLASE PRINCIPAL.
 * <h2>Proyecto examen 2014, Este proyecto realiza el mantenimiento de la BD neodatis Empleados.dat. La base de datos está formada por las clases persistentes de Empleados y Departamentos. Un departamento tiene muchos empleados. 
 * @author ARM
 * @version 1-2014
*/

@SuppressWarnings("serial")
public class Principal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Practica NEODATIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("OPERACIONES BD EMPLEADOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(128, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(69, 32, 287, 37);
		contentPane.add(lblTitulo);

		JButton btnEmple = new JButton("Operaciones Empleados");
		btnEmple.setBounds(116, 98, 202, 23);
		contentPane.add(btnEmple);
		btnEmple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OperacionesEmple opEmple=new OperacionesEmple();
				opEmple.setVisible(true);
			}
		});

		JButton btnDepart = new JButton("Operaciones Departamentos");
		btnDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OperacionesDepart opDepart=new OperacionesDepart();
				opDepart.setVisible(true);
			}
		});
		btnDepart.setBounds(116, 139, 202, 23);
		contentPane.add(btnDepart);
		
		
		JButton btnConsultas = new JButton("Consultas a la BD");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultas con=new Consultas();
				con.setVisible(true);
			}
		});
		btnConsultas.setBounds(116, 175, 202, 23);
		contentPane.add(btnConsultas);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 3));
		panel.setBackground(Color.CYAN);
		panel.setBounds(69, 80, 296, 138);
		contentPane.add(panel);
		
	}
}
