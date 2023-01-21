package interfaz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.neodatis.odb.ODB;

public class Etiquetas {
	public JPanel contentPane;
	public JLabel lblResultado;
	public JButton btnDepar;
	public JButton btnEmple;
	public JButton btnEstadDepar;
	public JButton btnEstadEmple;
	public JLabel label_1;
	public ODB odb;

	public Etiquetas(JButton btnDepar, JButton btnEmple, JButton btnEstadDepar,
			JButton btnEstadEmple, JLabel label_1, ODB odb) {
		this.btnDepar = btnDepar;
		this.btnEmple = btnEmple;
		this.btnEstadDepar = btnEstadDepar;
		this.btnEstadEmple = btnEstadEmple;
		this.label_1 = label_1;
		this.odb = odb;
	}
}