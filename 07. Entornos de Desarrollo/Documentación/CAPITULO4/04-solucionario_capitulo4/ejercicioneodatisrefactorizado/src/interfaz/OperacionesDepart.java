package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import javax.swing.SwingConstants;

import logica.Departamento;
import logica.Empleado;
import logica.Excepciones.NumDepartDuplicado;


/**
 * CLASE OPERACIONES DEPART
 * <h2>Esta clase se encarga del mantenimiento de los datos de departamentos, se realizan altas, bajas modificaciones y consultas. 
 * @author ARM
 * @version 1-2014
*/
public class OperacionesDepart extends JDialog implements Interfazdepart {
	private static final String BBDD="Empleados.dat";
	private JPanel contentPane;
	private JTextField txNumDepart;
	private JTextField txNombre;
	private JTextField txPoblacion;
	private JLabel lblRespuesta;

	public OperacionesDepart() {
		setTitle("Operaciones departamentos.");
		setModal(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperaciones = new JLabel("Operaciones DEPARTAMENTOS");
		lblOperaciones.setBackground(Color.YELLOW);
		lblOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperaciones.setForeground(Color.BLUE);
		lblOperaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperaciones.setBounds(75, 11, 292, 35);
		contentPane.add(lblOperaciones);
		
		JLabel lblNumDepart = new JLabel("Num Departamento");
		lblNumDepart.setBounds(36, 74, 112, 16);
		contentPane.add(lblNumDepart);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 102, 55, 16);
		contentPane.add(lblNombre);
		
		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n");
		lblPoblacion.setBounds(36, 130, 69, 16);
		contentPane.add(lblPoblacion);
		
		txNumDepart = new JTextField();
		txNumDepart.setBounds(166, 72, 95, 20);
		contentPane.add(txNumDepart);
		txNumDepart.setColumns(10);
		
		txNombre = new JTextField();
		txNombre.setBounds(166, 100, 215, 20);
		contentPane.add(txNombre);
		txNombre.setColumns(10);
		
		txPoblacion = new JTextField();
		txPoblacion.setBounds(166, 128, 215, 20);
		contentPane.add(txPoblacion);
		txPoblacion.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnConsultar.setBounds(292, 69, 89, 23);
		contentPane.add(btnConsultar);
		
		lblRespuesta = new JLabel("---------------------------------------------------------------------");
		lblRespuesta.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRespuesta.setForeground(Color.RED);
		lblRespuesta.setBounds(34, 169, 345, 14);
		contentPane.add(lblRespuesta);
		
		JButton btnInsertarDepartamento = new JButton("Insertar Departamento");
		btnInsertarDepartamento.setMargin(new Insets(2, 4, 2, 4));
		btnInsertarDepartamento.setFont(new Font("Dialog", Font.BOLD, 10));
		btnInsertarDepartamento.setBounds(12, 224, 124, 26);
		contentPane.add(btnInsertarDepartamento);
		
		JButton btnBorrarDepartamento = new JButton("Borrar Departamento");
		btnBorrarDepartamento.setMargin(new Insets(2, 4, 2, 4));
		btnBorrarDepartamento.setFont(new Font("Dialog", Font.BOLD, 10));
		btnBorrarDepartamento.setBounds(150, 224, 124, 26);
		contentPane.add(btnBorrarDepartamento);
		
		JButton btnModifcarDepartamento = new JButton("Modifcar Departamento");
		btnModifcarDepartamento.setMargin(new Insets(2, 4, 2, 4));
		btnModifcarDepartamento.setFont(new Font("Dialog", Font.BOLD, 10));
		btnModifcarDepartamento.setBounds(288, 224, 129, 26);
		contentPane.add(btnModifcarDepartamento);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		panel.setForeground(Color.BLUE);
		panel.setBounds(12, 45, 399, 156);
		contentPane.add(panel);
		
		//Action listeners
		//Accion boton insertar departamento
		btnInsertarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num;
				String nom, pob;
				ODB odb=ODBFactory.open(BBDD);
				
				try{
					insertardep(odb);
				}
				catch(NumberFormatException e){
					lblRespuesta.setText("Error, numero de departamento erroneo");
				}
				catch(NumDepartDuplicado e){
					lblRespuesta.setText("Error, "+e.getMessage());
				}
				finally{
					odb.close();
				}
			}
		});
		
		//Accion boton borrar departamento
		btnBorrarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num=0;
				ODB odb=ODBFactory.open(BBDD);
				
				try{
					borrardep(odb);
				}
				catch(NumberFormatException e){
					lblRespuesta.setText("Error, numero de departamento erroneo");
				}
				finally{
					odb.close();
				}
			}
		});
		
		//Accion boton consultar departamento
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num;
				ODB odb=ODBFactory.open(BBDD);
				
				try{
					consultardep(odb);
				}
				catch(NumberFormatException e){
					lblRespuesta.setText("Error, numero de departamento erroneo");
				}
				finally{
					odb.close();
				}
			}
		});
		
		//Accion boton modificar departamento
		btnModifcarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num;
				ODB odb=ODBFactory.open(BBDD);
				
				try{
					modificardep(odb);
				}
				catch(NumberFormatException e){
					lblRespuesta.setText("Error, numero de departamento erroneo");
				}
				finally{
					odb.close();
				}
			}
		});
	}
	
	private void comprobarNumDepart(ODB odb, int num) throws NumDepartDuplicado{
		IQuery query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", num));
		Objects<Departamento> dep=odb.getObjects(query);
		
		if(num<1)
			throw new NumDepartDuplicado("numero de departamento no valido");
		if(!dep.isEmpty())
			throw new NumDepartDuplicado("numero de departamento duplicado");
	}

	/* (non-Javadoc)
	 * @see interfaz.Interfazdepart#insertardep(org.neodatis.odb.ODB)
	 */
	@Override
	public void insertardep(ODB odb) throws NumDepartDuplicado {
		int num;
		String nom;
		String pob;
		num=Integer.parseInt(txNumDepart.getText());
		comprobarNumDepart(odb, num);
		if(!txNombre.getText().equals("")){
			if(!txPoblacion.getText().equals("")){
				nom=txNombre.getText();
				pob=txPoblacion.getText();
				odb.store(new Departamento(num,nom,pob));
				
				lblRespuesta.setText("Departamento insertado correctamente");
			}
			else
				lblRespuesta.setText("Error, poblacion vacia");
		}
		else
			lblRespuesta.setText("Error, nombre de departamento vacio");
	}

	/* (non-Javadoc)
	 * @see interfaz.Interfazdepart#borrardep(org.neodatis.odb.ODB)
	 */
	@Override
	public void borrardep(ODB odb) {
		int num;
		num=Integer.parseInt(txNumDepart.getText());
		IQuery query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", num));
		Objects<Departamento> dep=odb.getObjects(query);
		if(!dep.isEmpty()){
			IQuery query2=new CriteriaQuery(Empleado.class, 
					Where.equal("dept.dept_no", dep.getFirst().getDept_no()));
			Objects<Empleado> emp=odb.getObjects(query2);
			for(Empleado e:emp){
				e.setDept(null);
				odb.store(e);
			}
			odb.delete(dep.getFirst());
			lblRespuesta.setText("Departamento borrado correctamente");
		}
		else
			lblRespuesta.setText("Error, el departamento no existe");
	}

	/* (non-Javadoc)
	 * @see interfaz.Interfazdepart#consultardep(org.neodatis.odb.ODB)
	 */
	@Override
	public void consultardep(ODB odb) {
		int num;
		num=Integer.parseInt(txNumDepart.getText());
		IQuery query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", num));
		Objects<Departamento> dep=odb.getObjects(query);
		if(!dep.isEmpty()){
			txNombre.setText(dep.getFirst().getDnombre());
			txPoblacion.setText(dep.getFirst().getLoc());
			lblRespuesta.setText("Consulta satisfactoria");
		}
		else
			lblRespuesta.setText("Error, el departamento no existe");
	}

	/* (non-Javadoc)
	 * @see interfaz.Interfazdepart#modificardep(org.neodatis.odb.ODB)
	 */
	@Override
	public void modificardep(ODB odb) {
		int num;
		num=Integer.parseInt(txNumDepart.getText());
		IQuery query=new CriteriaQuery(Departamento.class, Where.equal("dept_no", num));
		Objects<Departamento> dep=odb.getObjects(query);
		if(!dep.isEmpty()){
			if(!txNombre.getText().equals("")){
				if(!txPoblacion.getText().equals("")){
					Departamento depar;
					depar=dep.getFirst();
					depar.setDnombre(txNombre.getText());
					depar.setLoc(txPoblacion.getText());
					odb.store(depar);
					lblRespuesta.setText("Modifcacion satisfactoria");
				}
				else
					lblRespuesta.setText("Error, poblacion vacia");
			}
			else
				lblRespuesta.setText("Error, nombre de departamento vacio");
		}
		else
			lblRespuesta.setText("Error, el departamento no existe");
	}
}
