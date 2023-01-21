package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Departamento;
import logica.Empleado;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * CLASE OPERACIONES EMPLE
 * <h2>Esta clase se encarga del mantenimiento de los datos de los empleados, se realizan altas, bajas modificaciones y consultas.
 * @author ARM
 * @version 1-2014
*/

@SuppressWarnings("serial")
public class OperacionesEmple extends JDialog {
	private static final String BBDD="Empleados.dat";
	private JPanel contentPane;
	private JTextField txNumEmple;
	private JTextField txNombre;
	private JTextField txPoblacion;
	private JTextField txOficio;
	private JTextField txSalario;
	private JTextField txNumDepart;
	private JLabel lblResultado;
	
	private final class modificaremple implements ActionListener {
		// Modificar registro de la BD.
		public void actionPerformed(ActionEvent arg0) {
		   int numEmple, numDepar;
			double salario;
			ODB odb=ODBFactory.open(BBDD);
			
			try{
				numEmple=Integer.parseInt(txNumEmple.getText());
				IQuery query=new CriteriaQuery(Empleado.class, Where.equal("emp_no", numEmple));
				if(!odb.getObjects(query).isEmpty()){
					Empleado emple=(Empleado)odb.getObjects(query).getFirst();
					if(!txNombre.getText().isEmpty()){
						if(!txPoblacion.getText().isEmpty()){
							if(!txOficio.getText().isEmpty()){
								try{
									salario=Double.parseDouble(txSalario.getText());
									if(salario>0){
										try{
											numDepar=Integer.parseInt(txNumDepart.getText());
											query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", numDepar));
											if(!odb.getObjects(query).isEmpty()){
												Departamento dep=(Departamento)odb.getObjects(query).getFirst();
												emple.setNombre(txNombre.getText());
												emple.setPobla(txPoblacion.getText());
												emple.setOficio(txOficio.getText());
												emple.setSalario(salario);
												emple.setDept(dep);
												odb.store(emple);
												lblResultado.setText("Empleado modificado correctamente");
											}
											else
												lblResultado.setText("Error, el departamento no existe");
										}
										catch(NumberFormatException e){
											lblResultado.setText("Error, numero de departamento erroneo");
										}
									}
									else
										lblResultado.setText("Error, el salario debe ser positivo");
								}
								catch(NumberFormatException e){
									lblResultado.setText("Error, salario erroneo");
								}
							}
							else
								lblResultado.setText("Error, oficio vacio");
						}
						else
							lblResultado.setText("Error, poblacion vacia");
					}
					else
						lblResultado.setText("Error, nombre vacio");
				}
				else
					lblResultado.setText("Error, el empleado no existe");
			}catch(NumberFormatException e){
			lblResultado.setText("Error, numero de empleado incorrecto");
			}
			finally{
			odb.close();
			}
		}
	}

	private final class borraremple implements ActionListener {
		// Borrar registro de la BD
		public void actionPerformed(ActionEvent arg0) {
		
			int numEmple;
			ODB odb=ODBFactory.open(BBDD);
			
			try{
				numEmple=Integer.parseInt(txNumEmple.getText());
				IQuery query=new CriteriaQuery(Empleado.class, Where.equal("emp_no", numEmple));
				if(!odb.getObjects(query).isEmpty()){
					Empleado emple=(Empleado)odb.getObjects(query).getFirst();
					odb.delete(emple);
					lblResultado.setText("Empleado borrado correctamente");
				}
				else
					lblResultado.setText("Error, el empleado no existe");
			}catch(NumberFormatException e){
				lblResultado.setText("Error, numero de empleado incorrecto");
			}
			finally{
				odb.close();
			}
		}
	}

	private final class consultaremple implements ActionListener {
		// Consultar un registro de la BD
		public void actionPerformed(ActionEvent arg0) {

			int numEmple;
			ODB odb=ODBFactory.open(BBDD);
			
			try{
				numEmple=Integer.parseInt(txNumEmple.getText());
				IQuery query=new CriteriaQuery(Empleado.class, Where.equal("emp_no", numEmple));
				if(!odb.getObjects(query).isEmpty()){
					Empleado emple=(Empleado)odb.getObjects(query).getFirst();
					txNombre.setText(emple.getNombre());
					txPoblacion.setText(emple.getPobla());
					txOficio.setText(emple.getOficio());
					txSalario.setText(String.valueOf(emple.getSalario()));
					if(emple.getDept()!=null)
						txNumDepart.setText(String.valueOf(emple.getDept().getDept_no()));
					else
						txNumDepart.setText("No tiene deparamento asignado");
					lblResultado.setText("Consulta correcta");
				}
				else
					lblResultado.setText("Error, el empleado no existe");
			}catch(NumberFormatException e){
				lblResultado.setText("Error, numero de empleado incorrecto");
			}
			finally{
				odb.close();
			}
		}
	}

	private final class insertaremple implements ActionListener {
		// Insertar un registro a la BD
		public void actionPerformed(ActionEvent arg0) {
			
				int numEmple, numDepar;
				String nombre, oficio, pobla;
				double salario;
				ODB odb=ODBFactory.open(BBDD);
				
				try{
					numEmple=Integer.parseInt(txNumEmple.getText());
					if(numEmple>0){
						IQuery query=new CriteriaQuery(Empleado.class, Where.equal("emp_no", numEmple));
						if(odb.getObjects(query).isEmpty()){
							if(!txNombre.getText().isEmpty()){
								if(!txPoblacion.getText().isEmpty()){
									if(!txOficio.getText().isEmpty()){
										try{
											salario=Double.parseDouble(txSalario.getText());
											if(salario>0){
												try{
													numDepar=Integer.parseInt(txNumDepart.getText());
													query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", numDepar));
													if(!odb.getObjects(query).isEmpty()){
														Departamento dep=(Departamento)odb.getObjects(query).getFirst();
														nombre=txNombre.getText();
														pobla=txPoblacion.getText();
														oficio=txOficio.getText();
														odb.store(new Empleado(numEmple, nombre, pobla, oficio, salario, dep));
														lblResultado.setText("Empleado insertado correctamente");
													}
													else
														lblResultado.setText("Error, el departamento no existe");
												}
												catch(NumberFormatException e){
													lblResultado.setText("Error, numero de departamento erroneo");
												}
											}
											else
												lblResultado.setText("Error, el salario debe ser positivo");
										}
										catch(NumberFormatException e){
											lblResultado.setText("Error, salario erroneo");
										}
									}
									else
										lblResultado.setText("Error, oficio vacio");
								}
								else
									lblResultado.setText("Error, poblacion vacia");
							}
							else
								lblResultado.setText("Error, nombre vacio");
						}
						else
							lblResultado.setText("Error, numero de empleado duplicado");
					}
					else
						lblResultado.setText("Error, numero de empleado no permitido");
				}catch(NumberFormatException e){
				lblResultado.setText("Error, numero de empleado incorrecto");
				}
				finally{
					odb.close();
				}
			}
	}



	public OperacionesEmple() {
		setTitle("Operaciones con Empleados");
		setModal(true);
		setBounds(100, 100, 470, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Operaciones EMPLEADOS");
		lblEmpleados.setForeground(Color.BLUE);
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmpleados.setBounds(120, 11, 232, 35);
		contentPane.add(lblEmpleados);
		
		JLabel lblNumEmple = new JLabel("Numero empleado");
		lblNumEmple.setBounds(37, 74, 115, 14);
		contentPane.add(lblNumEmple);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 101, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPoblacion = new JLabel("Población");
		lblPoblacion.setBounds(37, 126, 58, 14);
		contentPane.add(lblPoblacion);
		
		JLabel lblOficio = new JLabel("Oficio");
		lblOficio.setBounds(37, 151, 46, 14);
		contentPane.add(lblOficio);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(37, 176, 46, 14);
		contentPane.add(lblSalario);
		
		JLabel lblNumDepart = new JLabel("Num Departamento");
		lblNumDepart.setBounds(37, 199, 115, 14);
		contentPane.add(lblNumDepart);
		
		txNumEmple = new JTextField();
		txNumEmple.setBounds(164, 71, 98, 20);
		contentPane.add(txNumEmple);
		txNumEmple.setColumns(10);
		
		txNombre = new JTextField();
		txNombre.setBounds(164, 96, 218, 20);
		contentPane.add(txNombre);
		txNombre.setColumns(10);
		
		txPoblacion = new JTextField();
		txPoblacion.setBounds(164, 121, 218, 20);
		contentPane.add(txPoblacion);
		txPoblacion.setColumns(10);
		
		txOficio = new JTextField();
		txOficio.setBounds(164, 146, 218, 20);
		contentPane.add(txOficio);
		txOficio.setColumns(10);
		
		txSalario = new JTextField();
		txSalario.setBounds(164, 171, 218, 20);
		contentPane.add(txSalario);
		txSalario.setColumns(10);
		
		txNumDepart = new JTextField();
		txNumDepart.setBounds(164, 196, 218, 20);
		contentPane.add(txNumDepart);
		txNumDepart.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnConsultar.setBounds(293, 70, 89, 23);
		contentPane.add(btnConsultar);
		
		lblResultado = new JLabel("---------------------------------------------------------------------");
		lblResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(37, 230, 345, 14);
		contentPane.add(lblResultado);
		
		JButton btnInsertar = new JButton("Insertar Empleado");
		btnInsertar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnInsertar.setBounds(21, 274, 130, 26);
		contentPane.add(btnInsertar);
		
		JButton btnBorrar = new JButton("Borrar Empleado");
		btnBorrar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnBorrar.setBounds(163, 274, 124, 26);
		contentPane.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modifcar Empleado");
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnModificar.setBounds(302, 274, 129, 26);
		contentPane.add(btnModificar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(21, 46, 398, 211);
		contentPane.add(panel);
		
		//Listeners botones
		//Accion boton insertar
		btnInsertar.addActionListener(new insertaremple());
		
		//Accion boton consultar
		btnConsultar.addActionListener(new consultaremple());
		
		//Accion boton borrar
		btnBorrar.addActionListener(new borraremple());
		
		//Accion boton modificar
		btnModificar.addActionListener(new modificaremple());
	}
}
