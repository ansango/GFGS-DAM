import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	SimpleDateFormat formato;
	Date hoy;

	//
	public Fecha() {
		hoy = new Date();
	}

	//
	public String DevuelveFecha(int tipo) {
		String cad = "";
		switch (tipo) {
		case 1: {
			formato = new SimpleDateFormat("yyyy/MM");// 2014/03
			cad = formato.format(hoy);
			break;
		}
		case 2: {
			formato = new SimpleDateFormat("MM/yyyy");// 03/2014
			cad = formato.format(hoy);
			break;
		}
		case 3: {
			formato = new SimpleDateFormat("MM/yy");// 03/14
			cad = formato.format(hoy);
			break;
		}
		default: {
			cad = "ERROR";
		}
		}
		return cad;
	}
}//
