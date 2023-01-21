import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.hibernate.StaleStateException;
import org.hibernate.exception.ConstraintViolationException;


/*
 * Esta clase es la que realmente lleva el peso de la ejecución
 * Contiene la ventana principal e instancia a las clases Controller y AlertWindow.
 */
public class MainWindow  extends Frame{
	
	private static final long serialVersionUID = 1L;
	Controller controlDep= new Controller(); //Creamos el controlador
	

	public MainWindow(){
		try {			
			this.addWindowListener(new WindowAdapter() {				
				public void windowClosing(WindowEvent e) {					
					System.exit(0);
					}
			}); 
			
			//Montamos la ventana como la que nos pide el enunciado.
			this.setLayout(new FlowLayout(FlowLayout.LEFT));			
			Label title=new Label("GESTIÓN DE DEPARTAMENTOS");
			this.add(title);			
			Label lblNDep= new Label("Nº Departamento:                                            ");
			TextField tfdNDep= new TextField(2);	
			
			this.add(lblNDep);
			this.add(tfdNDep);			
			Label lblNombre=new Label("Nombre:   ");
			TextField tfdNombre= new TextField(27);
			this.add(lblNombre);
			this.add(tfdNombre);			
			Label lblLocalidad= new Label("Localidad:");
			TextField tfdLocalidad=new TextField(27);
			this.add(lblLocalidad);
			this.add(tfdLocalidad);			
			Button btnAlta= new Button("Alta");
			Button btnBaja= new Button("Baja");
			Button btnMod= new Button("Modificación");
			this.add(btnAlta);
			this.add(btnBaja);
			this.add(btnMod);		
			
			
			//Agregamos el evento al boton de alta
			btnAlta.addActionListener( new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if(tfdNDep.getText().length()>0){
						//Llamamos a la función de crear departamento
						controlDep.createDepartamento(Integer.parseInt(tfdNDep.getText()), tfdNombre.getText(), tfdLocalidad.getText());
						//Si todo es correcto, mostramos el mensaje y limpiamos los campos
						AlertWindow alert= new AlertWindow("Departamento Introducido");
						alert.showAlert();
						tfdLocalidad.setText("");
						tfdNombre.setText("");
						tfdNDep.setText("");
						}else{
							AlertWindow alert= new AlertWindow("Campo vacio");
							alert.showAlert();
						}
					} catch (Exception e1) {
						//En caso de que se produzca un error....
						if(e1 instanceof ConstraintViolationException){
							AlertWindow alert= new AlertWindow("Departamento ya existente");
							alert.showAlert();
							controlDep.closeSession();
						}else{
							AlertWindow alert= new AlertWindow("Error desconocido");
							alert.showAlert();
							e1.printStackTrace();
							controlDep.closeSession();
						}		
												
					}	
					
				}
			});
			btnBaja.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if(tfdNDep.getText().length()>0){
						controlDep.deleteDepartamento(Integer.parseInt(tfdNDep.getText()));
						AlertWindow alert= new AlertWindow("Departamento eliminado");
						alert.showAlert();
						tfdLocalidad.setText("");
						tfdNombre.setText("");
						tfdNDep.setText("");
						}else{
							AlertWindow alert= new AlertWindow("Campo vacio");
							alert.showAlert();
						}
					} catch (StaleStateException e1) {
						
						if(e1 instanceof StaleStateException){
							AlertWindow alert= new AlertWindow("Departamento no existe");
							controlDep.closeSession();
							alert.showAlert();
						}else{
							AlertWindow alert= new AlertWindow("Error desconocido");
							controlDep.closeSession();
							alert.showAlert();
							e1.printStackTrace();
						}						
					}					
				}
			});
			
			btnMod.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if(tfdNDep.getText().length()>0){
							controlDep.alterDepartamento(Integer.parseInt(tfdNDep.getText()), tfdNombre.getText(), tfdLocalidad.getText());
							AlertWindow alert= new AlertWindow("Departamento Modificado");
							alert.showAlert();
							tfdLocalidad.setText("");
							tfdNombre.setText("");
							tfdNDep.setText("");
						}else{
							AlertWindow alert= new AlertWindow("Id vacio");
							alert.showAlert();
						}
						
					} catch (Exception e1) {
						if(e1 instanceof StaleStateException){
							AlertWindow alert= new AlertWindow("Departamento no existe");
							controlDep.closeSession();
							alert.showAlert();
						}else{
							AlertWindow alert= new AlertWindow("Error desconocido");
							controlDep.closeSession();
							alert.showAlert();
							e1.printStackTrace();
						}		
					}
				}
			});
			
			
			this.setTitle("M7_UF1_PAC02_Ejer1"); 
			this.setBounds(400,400,300, 180); 
			
			this.setResizable(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void showMe(){
		this.setVisible(true); 
	}

}
