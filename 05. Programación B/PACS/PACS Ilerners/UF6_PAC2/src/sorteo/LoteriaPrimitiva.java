package sorteo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.*;
/*
 CREATE DATABASE IF NOT EXISTS sorteo;
 USE sorteo;
 DROP TABLE IF EXISTS sorteo;
 CREATE TABLE sorteo(
   jornada int(9) not null auto_increment,
   fecha date not null,
   n1 int(2) not null,
   n2 int(2) not null,    
   n3 int(2) not null,
   n4 int(2) not null,
   n5 int(2) not null,
   complementario int(2) not null,
   PRIMARY KEY(jornada),
   UNIQUE KEY (fecha)
 );
*/
public class LoteriaPrimitiva extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Declaraciones de la clase
	private JLabel lblFecha;
	private JTextField txtFecha;
	
	private JLabel lblN1;
	private JTextField txtN1;

	private JLabel lblN2;
	private JTextField txtN2;

	private JLabel lblN3;
	private JTextField txtN3;

	private JLabel lblN4;
	private JTextField txtN4;

	private JLabel lblN5;
	private JTextField txtN5;

	private JLabel lblComplementario;
	private JTextField txtComplementario;
	
	private JLabel lblJornadas;
	
	private JButton btnCerrar;
	private JButton btnAnadir;
	private JButton btnListar;
	
	//Constantes
	final static String titulo = "Administración del sorte de Lotería Primitiva";
	
	//Utilidades y conexión con BBDD
	UtilidadesBBDD conectado = new UtilidadesBBDD();
	Connection con = conectado.conexionBBDD();
	
	//Control de los errores
	ControlErrores msjError = new ControlErrores();
	
	/**
	 * Constructor de la clase 
	 */
	public LoteriaPrimitiva()
	{
		//Utilizaremos this, ya que la clase extiende de JFrame y por tanto en sí
		//es un JFrame con todos sus métodos, además de implementar los métodos de los
		//eventos que vamos a utilizar
		
		//Titulo para la ventana
		this.setTitle(titulo);
		
		//Tamaño y posición de la ventana
		//Pintamos la ventana en la posición (eje horizontal, eje vertical, ancho y alto)
		this.setBounds(200, 100, 570, 530);
		
		//Asignamos la acción por defecto a la X de la ventana, aunque en Swing ya trae una
	    //por defecto para cerrar la ventana, nos aseguramos de que se cierra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Vamos a pintar los componentes manualmente
		this.getContentPane().setLayout(null);
		
		//Declaramos los componentes que vamos a utilizar
		//Label de cada campo en ventana
		lblFecha = new JLabel("Fecha sorteo");
		lblFecha.setName("lblFecha");
		lblN1 = new JLabel("N1");
		lblN1.setName("lblN1");
		lblN2 = new JLabel("N2");
		lblN2.setName("lblN2");
		lblN3 = new JLabel("N3");
		lblN3.setName("lblN3");
		lblN4 = new JLabel("N4");
		lblN4.setName("lblN4");
		lblN5 = new JLabel("N5");
		lblN5.setName("lblN5");
		lblComplementario = new JLabel("Complementario");
		lblComplementario.setName("lblComplementario");
		lblJornadas = new JLabel();
		lblJornadas.setName("lblJornadas");
		lblJornadas.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		lblJornadas.setVerticalAlignment(1);
		
		//Textfield de los elementos de ventana
		txtFecha = new JTextField();
		txtFecha.setName("txtFecha");
		txtN1 = new JTextField();
		txtN1.setName("txtN1");
		txtN2 = new JTextField();
		txtN2.setName("txtN2");
		txtN3 = new JTextField();
		txtN3.setName("txtN3");
		txtN4 = new JTextField();
		txtN4.setName("txtN4");
		txtN5 = new JTextField();
		txtN5.setName("txtN5");
		txtComplementario = new JTextField();
		txtComplementario.setName("txtComplementario");
		
		//Botonera de la ventana
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setName("btnCerrar");

		btnAnadir = new JButton("Añadir");
		btnAnadir.setName("btnAnadir");

		btnListar = new JButton("Listar");
		btnListar.setName("btnListar");
		
		//Posicionamos los componentes
		lblFecha.setBounds(10, 10, 100, 20);
		txtFecha.setBounds(10, 30, 68, 20);
		
		lblN1.setBounds(100, 10, 20, 20);
		txtN1.setBounds(100, 30, 20, 20);

		lblN2.setBounds(120, 10, 20, 20);
		txtN2.setBounds(120, 30, 20, 20);

		lblN3.setBounds(140, 10, 20, 20);
		txtN3.setBounds(140, 30, 20, 20);

		lblN4.setBounds(160, 10, 20, 20);
		txtN4.setBounds(160, 30, 20, 20);
		
		lblN5.setBounds(180, 10, 20, 20);
		txtN5.setBounds(180, 30, 20, 20);

		lblComplementario.setBounds(200, 10, 100, 20);
		txtComplementario.setBounds(200, 30, 20, 20);
		
		lblJornadas.setBounds(10, 55, 400, 400);
		
		btnCerrar.setBounds(420, 460, 120, 25);
		btnAnadir.setBounds(420, 55, 120, 25);
		btnListar.setBounds(420, 85, 120, 25);
		
		//Como JFrame lleva un panel contendor para colocar los componentes,
		//añadimos los componentes al contenedor
		this.getContentPane().add(lblFecha);
		this.getContentPane().add(lblN1);
		this.getContentPane().add(lblN2);
		this.getContentPane().add(lblN3);
		this.getContentPane().add(lblN4);
		this.getContentPane().add(lblN5);
		this.getContentPane().add(lblComplementario);
		this.getContentPane().add(lblJornadas);

		this.getContentPane().add(txtFecha);
		this.getContentPane().add(txtN1);
		this.getContentPane().add(txtN2);
		this.getContentPane().add(txtN3);
		this.getContentPane().add(txtN4);
		this.getContentPane().add(txtN5);
		this.getContentPane().add(txtComplementario);		
		
		this.getContentPane().add(btnCerrar);
		this.getContentPane().add(btnAnadir);
		this.getContentPane().add(btnListar);
		
		//Vamos a darle un color de fondo
		this.getContentPane().setBackground(new Color(225,240,235));
		
		//Asociamos los eventos a los componentes que queremos tratar
		btnListar.addActionListener(this);
		btnAnadir.addActionListener(this);
		btnCerrar.addActionListener(this);
		
		//Ponemos visible la ventana
		this.setVisible(true);
	}
	
	/**
	 * Para poder ejecutar el programa utilizamos el main
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		//Invocamos al constructor mediante la creación de un objeto para pintar la ventana
		LoteriaPrimitiva loteria = new LoteriaPrimitiva();
	}
	
	/**
	 * Método que permite añadir un registro en la tabla con los datos introducidos en ventana.
	 * Se realizarán algunas validaciones para controlar lo que guardamos en Base de Datos
	 */
	private void insertarRegistro()
	{
		//Validación de campos vacíos
		if (validarCampos())
		{
			//Validación del formato de fecha
			if (validarFecha())
			{
				//Validación de números repetidos en la combinación
				if(validarRepetidos())
				{
					//Validación del intervalo, cada número de la combinación tiene
					//que estar comprendido entre el 1 y el 49, inclusive ambos límites
					if(validarIntervalo())
					{
						//Declaramos las variables para los datos y la query
						String datos="";
						String consultaInsercion = "INSERT INTO sorteo (fecha, n1, n2, n3, n4, n5, complementario) VALUES (";
						
						//Preparamos los datos que vamos a insertar en la tabla mediante
						//la query de inserción
						datos = "\'" + formateaFecha(this.txtFecha.getText()) + "\', ";
						datos = datos + this.txtN1.getText() +", ";
						datos = datos + this.txtN2.getText() +", ";
						datos = datos + this.txtN3.getText() +", ";
						datos = datos + this.txtN4.getText() +", ";
						datos = datos + this.txtN5.getText() +", ";
						datos = datos + this.txtComplementario.getText() +")";
						
						//Montamos la consulta completa
						consultaInsercion = consultaInsercion + datos;
						
						//Es necesario controlar las excepciones al interactuar con la BBDD
						try
						{
							//Preparamos la sentencia, ejecutamos y cerramos
							Statement consulta = con.createStatement();
							consulta.executeUpdate(consultaInsercion);
							conectado.cerrarConexion(consulta);
						}
						catch (Exception errores)
						{
							//En caso de error al añadir, mostramos un mensaje genérico y el específico del gestor
							msjError.mensajeError("Se ha producido un error al añadir el registro.\n"+
													errores.toString());
						}
					}
				}
				else
				{
					//Error por números repetidos
					msjError.mensajeError("Revise la combinación, uno de los números está repetido.");
				}
			}
			else
			{
				//Error por formato de fecha
				msjError.mensajeError("El formato de fecha introducido es erróneo.\n"
						+ "El formato correcto es DD/MM/AAAA (día/mes/año).");
			}
		}
		else
		{
			//Error debido a que alguno de los campos está vacío
			msjError.mensajeError("Alguno de los campos está vacío, por favor rellene "
					+ "todos los\ncampos para guardar los resultados de la jornada.");
		}
	}
	
	/**
	 * Método que permite consultar los datos de la tabla y mostrarlos en pantalla
	 * 
	 * Se utiliza la capacidad de la JLabel para leer HTML
	 */
	private void consultarTabla()
	{
		// Controlamos las excepciones del sistema
		try
		{
			//Variable para mostrar el resultado en la label. Aprovechamos que el JLabel
			//puede interpretar HTML para sacar los datos correctamente
			String salidaAmostrar="<html><body>";
			
			//Creamos la sentencia
			Statement consulta = con.createStatement();
			
			//Obtenemos el resulSet con los datos de la consulta
			ResultSet salida = consulta.executeQuery("SELECT * FROM sorteo");
			
			//Iteramos mientras tengamos registros en el resulset
			while(salida.next())
			{
				//Preparamos y formateamos los datos que vamos a mostrar en la label.
				salidaAmostrar = salidaAmostrar + "Jornada nº: " + salida.getInt("jornada") + "; Fecha:" + desFormateaFecha(salida.getDate("fecha")) 
								 + "; Combinación: " + salida.getInt("n1") + ", " + salida.getInt("n2") +", " + salida.getInt("n3") + ", "
								 + salida.getInt("n4") + ", " + salida.getInt("n5") + ", " + salida.getInt("complementario") + "<br>";
			}
			
			//Cerramos las conexiones
			conectado.cerrarConexion(consulta);
			conectado.cerrarConexion(salida);
			
			//Terminamos de montar la salida, cerramos el HTML
			salidaAmostrar = salidaAmostrar + "</body></html>";
			
			//Mostramos el resultado en el label
			this.lblJornadas.setText(salidaAmostrar);
		}
		catch (Exception errores)
		{
			//Si falla la consulta mostramos un error genérico y el específico del gesto
			msjError.mensajeError("Se ha producido un error al realizar la consulta.\n"+
					errores.toString());
		}
	}
	
	/**
	 * Comprueba si los campos de la ventana están informados
	 * @return
	 */
	private boolean validarCampos()
	{	
		if	(campoIformado(this.txtFecha) && campoIformado(this.txtN1) && campoIformado(this.txtN2) &&
			campoIformado(this.txtN3) && campoIformado(this.txtN4) && campoIformado(this.txtN5) && campoIformado(this.txtComplementario))
			return true;
		else
			return false;
	}
	
	/* Permite validar que la fecha se introduzca en formato DD/MM/AAAA,
	 * también podríamos usar una variable de tipo fecha para pasar el campo a fecha
	 * y utilizar los métodos la clase DATE u otros métodos de validación de fechas.
	 * Lo vamos a validar por caracteres directamente y no tendremos en cuenta si se
	 * introduce una fecha coherente, si se introduce un día 40 o algo similar saltará
	 * la validación en la BBDD.
	 */
	/**
	 * Permite validar el formato del campo de fecha para verificar que está correctamente introducido
	 * @return
	 */
	private boolean validarFecha()
	{
		//Booleano que nos permite controlar si la fecha es valida
		boolean valido = false;
		
		//Obtenemos el valor de la fecha que hemos introducido en ventana
		String fecha = this.txtFecha.getText();
		
		//Array con las partes de la fecha
		String [] caracteres = null;
		
		//Comprobamos que se compone de 10 dígitos
		if(fecha.length()==10)
		{
			//Comprobamos que tiene las dos barras que componen la fecha
			if(fecha.indexOf("/")!=-1)
			{
				if(fecha.indexOf("/", fecha.indexOf("/"))!=-1)
				{
					//Dividimos las partes de la fecha
					caracteres = fecha.split("/");
					
					//Tenemos que tener tres partes que son el día, mes y año
					if(caracteres.length==3)
					{
						//Comprobamos las longitudes de cada parte de la fecha
						if((caracteres[0].length()==2 && valorNumerico(caracteres[0])) && 
							(caracteres[1].length()==2 && valorNumerico(caracteres[1]))&& 
							(caracteres[2].length()==4 && valorNumerico(caracteres[2])))
						{
							return true;
						}
					}
				}
			}
		}
		
		return valido;
	}
	
	/**
	 * Comprueba que no existan números repetidos
	 * 
	 * @return
	 */
	private boolean validarRepetidos()
	{
		//Inicializamos el booleano
		boolean noRepetido = true;
		
		//Declaración de un array numérico para validar los datos
		int [] combinacion = new int[6];
		
		//Contador
		int x = 0;
		
		//Cargamos el array con los números
		combinacion[0]=Integer.parseInt(this.txtN1.getText());
		combinacion[1]=Integer.parseInt(this.txtN2.getText());
		combinacion[2]=Integer.parseInt(this.txtN3.getText());
		combinacion[3]=Integer.parseInt(this.txtN4.getText());
		combinacion[4]=Integer.parseInt(this.txtN5.getText());
		combinacion[5]=Integer.parseInt(this.txtComplementario.getText());
		
		//Comprobamos los elementos para ver si existe alguno repetido
		//Comprobaremos cada número de la combinación con el resto
		while(noRepetido==true && x<combinacion.length)
		{
			for(int y=0;y<combinacion.length;y++)
			{
				//Tenemos en cuenta que no se comparen así mismos, ya que darían un resultado
				//falso
				if(y!=x && combinacion[x]==combinacion[y])
				{
					noRepetido=false;
					break;
				}
			}
			x++;
		}
		
		return noRepetido;
	}
	
	/**
	 * Valida que el campo de texto pasado por parámetro no esté vacío
	 * 
	 * @param campo
	 * @return
	 */
	private boolean campoIformado(JTextField campo)
	{
		//Eliminamos los posibles espacios y comparamos con vacío para saber si el campo
		//está o no informado
		if("".equalsIgnoreCase(campo.getText().trim()))
			return false;
		else
			return true;
	}
	
	/**
	 * Comprueba que un valor pasado por parámetro sea numérico
	 * 
	 * @param valor
	 * @return
	 */
	private boolean valorNumerico(String valor)
	{
		//Utilizamos la expresión regular para comprobar si el valor del campo es numérico
		//ponemos otra barra porque es el carácter de escape, ya que en una expresión \d
		//es un dígito, el más es para obligar que al menos haya un número
		if(valor.matches("\\d+"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Validamos que los números de la combinación estén entre el 1 y el 49 en cada
	 * uno de los números.
	 * 
	 * @return
	 */
	private boolean validarIntervalo()
	{	
		//Control de mensajes
		boolean mostrarMsj = false;
		
		//Creamos un array de números para guardar los valores de los campos de la
		//combinación introducida
		int [] numeros = new int[6];
		
		//Contador para evaluar los campos
		int contador=0;
		
		//Cargamos el array a validar dejando fuera la fecha
		numeros[0]=Integer.parseInt(this.txtN1.getText());
		numeros[1]=Integer.parseInt(this.txtN2.getText());
		numeros[2]=Integer.parseInt(this.txtN3.getText());
		numeros[3]=Integer.parseInt(this.txtN4.getText());
		numeros[4]=Integer.parseInt(this.txtN5.getText());
		numeros[5]=Integer.parseInt(this.txtComplementario.getText());

		//Iteramos el array de números que nos hemos creado
		while(contador < numeros.length)
		{	
			//Según el sorteo de la primitiva un número de la primitiva tiene que ser
			//como mínimo 1 y máximo 49
			if(numeros[contador]>0 && numeros[contador]<50)
			{
				contador++;
			}
			else
			{
				mostrarMsj = true;
				//Rompemos el bucle principal, ya que hemos encontrado un número que
				//inclumple el intervalo
				contador = numeros.length;
			}
		}
		
		//Mostramos el mensaje si hay un número que incumple el criterio
		if(mostrarMsj)
		{
			msjError.mensajeError("Los números de la combinación sólo admite valores numéricos entre 1 y 49.\nPor favor, revise los números introducidos.");
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * Formatea la fecha a formato AAAA-MM-DD para grabar en la BBDD
	 * No se realizan validaciones del campo, porque previamente a la llamada ya han
	 * sido realizadas
	 * 
	 * @param fecha
	 * @return
	 */
	private String formateaFecha(String fecha)
	{
		//Obtenemos los campos que forman la fecha
		String [] fechaCompleta = fecha.split("/");
		String fechaResultante="";
		
		//Monamos la fecha en formato AAAA-MM-DD
		fechaResultante = fechaCompleta[2]+"-"+fechaCompleta[1]+"-"+fechaCompleta[0];
		
		return fechaResultante;
	}
	
	/**
	 * Formatea la fecha a formato DD/MM/AAAA desde el formato AAAA-MM-DD
	 * No se realizan validaciones del campo, porque nos llegará de la BBDD y para
	 * insertarlo ya lo hemos validado
	 * 
	 * @param fecha
	 * @return
	 */
	private String desFormateaFecha(Date fecha)
	{
		//Obtenemos los campos
		String [] fechaCompleta = fecha.toString().split("-");
		String fechaResultante="";
		
		fechaResultante = fechaCompleta[2]+"/"+fechaCompleta[1]+"/"+fechaCompleta[0];
		
		return fechaResultante;
	}
	
	//Implementamos los métodos de la interfaz de ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Controlamos los botones de la ventana
		//Valor de la opción invocante
		String valor = e.getActionCommand().toString(); 
		
		//Evaluamos a qué opción corresponde
		if(valor.equalsIgnoreCase(this.btnAnadir.getText()))
		{
			//Invocamos al método para añadir un registro a la tabla
			insertarRegistro();
		}
		else if(valor.equalsIgnoreCase(this.btnListar.getText()))
		{
			//Invocamos al método para consultar todos los datos de la tabla
			consultarTabla();
		}
		else if(valor.equalsIgnoreCase(this.btnCerrar.getText()))
		{
			//Cerramos la conexión con la Base de datos
			conectado.cerrarConexion(con);
			
			//Liberamos la ventana de memoria y cerramos el programa
			this.dispose();
			System.exit(0);
		}
	}
}