package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Departamento;
import logica.Empleado;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import javax.swing.border.CompoundBorder;


/**
 * CLASE CONSULTAS
 * <h2>Esta clase se encarga de realizar consultas estadísticas de empleados y departamentos. También obtiene un listado de empleados y un listado de departamentos.
 * @author ARM
 * @version 1-2014
*/
@SuppressWarnings("serial")
public class Consultas extends JDialog implements ActionListener  {

	Etiquetas data = new Etiquetas(new JButton("Ver departamentos"), new JButton("Ver empleados"), new JButton("Estadisticas departamentos"),
			new JButton("Estadisticas empleados"), new JLabel("CONSULTAS A LA BBDD"), null);

	public Consultas() {
		
		setTitle("CONSULTAS A LA BD");
		setModal(true);
		setBounds(100, 100, 450, 340);
		data.contentPane = new JPanel();
		setContentPane(data.contentPane);
		data.contentPane.setLayout(null);
		

		data.label_1.setForeground(Color.BLUE);
		data.label_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		data.label_1.setBounds(112, 24, 217, 32);
		data.contentPane.add(data.label_1);
		
	
		data.btnDepar.setBounds(111, 92, 218, 23);
		data.contentPane.add(data.btnDepar);
		

		data.btnEmple.setBounds(111, 128, 218, 23);
		data.contentPane.add(data.btnEmple);
		
	
		data.btnEstadDepar.setBounds(111, 164, 218, 23);
		data.contentPane.add(data.btnEstadDepar);
		
	
		data.btnEstadEmple.setBounds(111, 200, 218, 23);
		data.contentPane.add(data.btnEstadEmple);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setBackground(Color.GREEN);
		panel.setBounds(60, 67, 314, 181);
		data.contentPane.add(panel);
		
		data.lblResultado = new JLabel("---------------------------------------------------------------------");
		data.lblResultado.setForeground(Color.RED);
		data.lblResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		data.lblResultado.setBounds(44, 272, 345, 14);
		data.contentPane.add(data.lblResultado);
		
		
		data.btnDepar.addActionListener(this);
		data.btnEmple.addActionListener(this);
		data.btnEstadDepar.addActionListener(this);
		data.btnEstadEmple.addActionListener(this);
	
	}	

public void actionPerformed(ActionEvent e) 
{   
	
	String BBDD="Empleados.dat";
	data.odb = ODBFactory.open(BBDD);
	
    if (e.getSource() == data.btnDepar) { consuldepart(0, 0);  	}
	
	if (e.getSource() == data.btnEmple) { consulemple();  	}
	
	if (e.getSource() == data.btnEstadDepar) { estadisdepart();  	}
	
	if (e.getSource() == data.btnEstadEmple) { estadisemple();  	}
	
}		
	
/////////////////////////////////////////////////////////////////

public String consuldepart(int n1, int n2) {
				IQuery query=new CriteriaQuery(Departamento.class);
				query.orderByAsc("dept_no");
				Objects<Departamento> depar=data.odb.getObjects(query);
				
				if(!depar.isEmpty()){
					int cont=depar.size();
					String cabecera=String.format("%10s  %15s  %15s  %15s  %1s",
							"Num depart", "Nombre", "Población", "Num Empleados", "Salario Medio");
					System.out.println(cabecera);
					System.out.println("-----------------------------------------------------------------------------");
					for(Departamento d:depar){					
						Values values=data.odb.getValues(new ValuesCriteriaQuery(Empleado.class,
								Where.equal("dept.dept_no", d.getDept_no()))
								.count("emp_no")
								.sum("salario"));
						
						if(!values.isEmpty()){
							ObjectValues ob=values.nextValues();
							double media=((BigDecimal)ob.getByIndex(1)).doubleValue()/((BigInteger)ob.getByIndex(0)).intValue();
							BigInteger count=(BigInteger)ob.getByIndex(0);
							
							String salida=String.format("%10s  %15s  %15s  %15s  %.2f", 
									d.getDept_no(), d.getDnombre(), d.getLoc(), count.toString(),
									(Double.isNaN(media) ? 0 : media));
							
							System.out.println(salida);
						}
						data.lblResultado.setText("Hay "+cont+" departamentos");
					}
				}
				else{
					String error = "No existen datos de departamentos";
					System.out.println(error);
					data.lblResultado.setText(error);
				}
				System.out.println("-----------------------------------------------------------------------------");
				data.odb.close();
		return "Hola";
	}
///////////////////////////////////////////////////////////////
public void consulemple() {		
		//Consultar empleados
	
			IQuery query=new CriteriaQuery(Empleado.class);
				query.orderByAsc("emp_no");
				Objects<Empleado> emp=data.odb.getObjects(query);
				
				if(!emp.isEmpty()){
					int cont=emp.size();
					String cabecera=String.format("%11s  %15s  %15s  %15s  %10s  %15s  %10s",
							"NumEmpleado", "Nombre", "Dirección", "Oficio", "Salario","NumDep", "NombreDep");
					System.out.println(cabecera);
					System.out.println("-------------------------------------------------------------------------------------------------------");
					for(Empleado e:emp){
						String salida=String.format("%11s  %15s  %15s  %15s  %10s  ",
								e.getEmp_no(), e.getNombre(), e.getPobla(),
								e.getOficio(), e.getSalario());
						if(e.getDept()!=null)
							salida+=String.format("%15s  %10s", e.getDept().getDept_no(), e.getDept().getDnombre());
						else
							salida+=String.format("%30s", "No tiene departamento asociado");
						System.out.println(salida);
					}
					data.lblResultado.setText("Hay "+cont+" empleados");
				}
				else{
					String error = "No existen datos de empleados";
					System.out.println(error);
					data.lblResultado.setText(error);
				}
				System.out.println("-------------------------------------------------------------------------------------------------------\n");
				data.odb.close();
			}
//////////////////////////////////
//Estadisticas departamentos
public void estadisdepart() {

				int max=0;
				double maxSal=0;
				String nombre=null;
				String nombreSal=null;
				
				Values values=data.odb.getValues(new ValuesCriteriaQuery(Empleado.class, Where.isNotNull("dept")).
						field("dept.dnombre").count("emp_no").sum("salario").groupBy("dept.dnombre"));
							
				for(ObjectValues o:values){
					int intValue=((BigInteger)o.getByIndex(1)).intValue();
					if(intValue>max){
						max=intValue;
						nombre=(String)o.getByIndex(0);
					}
					if (((BigInteger)o.getByIndex(1)).intValue() !=0)
					{
					  double mediaSal=((BigDecimal)o.getByIndex(2)).doubleValue() / ((BigInteger)o.getByIndex(1)).intValue();
					  if(mediaSal>maxSal){
						maxSal=mediaSal;
						nombreSal=(String)o.getByIndex(0);
					}
					}
				}
				if(nombre!=null) {
					System.out.println("El departamento con mas empleados es: "+nombre+" con "+max+" empleados");
					System.out.println("El departamento con mas media de salario es: "+nombreSal+" con "+maxSal+"€");
					data.lblResultado.setText("Estadisticas de departamentos mostradas");
				}
				else{
					String error = "No hay estadisticas de departamentos";
					System.out.println(error);
					data.lblResultado.setText(error);
				}
				
				System.out.println("-----------------------------------------------\n");
				data.odb.close();
			}
/////////////////////////////////////////////////////////
		
//Estadisticas empleados
	public void estadisemple() {
					
				//Empleado con mas salario
				Values values=data.odb.getValues(new ValuesCriteriaQuery(Empleado.class, 
						Where.equal("salario", data.odb.getValues(new ValuesCriteriaQuery(Empleado.class).max("salario")).next().getByIndex(0)))
						.field("salario").field("nombre", "nom"));
				if(!values.isEmpty()){
					ObjectValues o=values.next();
					System.out.println("El empleado con mas salario es: "+o.getByAlias("nom")+" con un salario de "+o.getByIndex(0)+"€");
					
					//Media de salario
					values=data.odb.getValues(new ValuesCriteriaQuery(Empleado.class).count("emp_no").sum("salario"));
					ObjectValues o2=values.next();
					double media=((BigDecimal)o2.getByIndex(1)).doubleValue()/((BigInteger)o2.getByIndex(0)).intValue();
					System.out.println("La media de salario de los empleados es: "+media+"€");
					
					//Numero de empleados por oficio
					values=data.odb.getValues(new ValuesCriteriaQuery(Empleado.class).count("emp_no").field("oficio").groupBy("oficio"));
					String cabecera=String.format("%15s  %10s", "Oficio", "Num emple");
					System.out.println(cabecera);
					System.out.println("---------------------------");
					for(ObjectValues o3:values){
						String datos=String.format("%15s  %10s", o3.getByIndex(1), o3.getByIndex(0));
						System.out.println(datos);
					}
					data.lblResultado.setText("Estadisticas de empleados mostradas");
				}
				else{
					String error = "No hay empleados";
					System.out.println(error);
					data.lblResultado.setText(error);
				}
				System.out.println("---------------------------\n");
				data.odb.close();
			}
////////////////////////////////////////
}
