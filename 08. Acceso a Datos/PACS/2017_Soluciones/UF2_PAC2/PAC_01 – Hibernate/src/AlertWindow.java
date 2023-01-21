import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Label;

/*
 * Esta clase es usada simplemente como contenedor de tipo alert, recibe un String
 * y muestra una alerta con ese mismo texto
 */
public class AlertWindow extends Frame {
	String texto;
	

	private static final long serialVersionUID = 1L;

	public AlertWindow(String texto){					
			this.addWindowListener(new WindowAdapter() {				
				public void windowClosing(WindowEvent e) {					
					 dispose();
					}
			}); 	
			this.texto=texto;
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			Label lblAlert= new Label(texto);
			Button btnOkCancel= new Button("Aceptar");
			btnOkCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 dispose();
					
				}
			});
			this.add(lblAlert);
			this.add(btnOkCancel);
			this.setBounds(400,500,200, 100);
			this.setResizable(false);	
			
	}
	
	public void showAlert(){
		
		this.setVisible(true);
		
	}
		

}
