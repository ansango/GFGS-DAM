using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace solucionParejas
{
    class Program
    {
        static void Main(string[] args)
        {
            int nivel;
            nivel = menu();
            //uso la matiz tablero, de caracteres con la solucion
            //uso la matriz aciertos, de booleans, para saber si se acerto o no la casilla
            char [,] tablero= new char[nivel,nivel];
		    Boolean [,]aciertos=new Boolean[nivel,nivel];
		    //rellenamos la matriz y la solucion
		    llenarMatriz(tablero,nivel,aciertos);
		    //iniciamos el juego
		    juego(tablero,nivel,aciertos);
        }
        static int menu()
        {
            Console.WriteLine("Bienvenido al juego de las parejas!");
            int opcion = 0;
            //bucle para que el nivel sea par, y entre el 2,4,6 y 8
            while(opcion<=0 || opcion>8 || opcion%2!=0)
            {
                Console.WriteLine("Cuantas filas/columnas quieres? (Maximo 8)");
                opcion = int.Parse(Console.ReadLine());


            }
            return opcion;
        }
        //funcion del juego
        static void juego(char[,] matrix, int tamano, Boolean [,] solucion)
        {
            Boolean fin=false;
		    int rondas=0;
		    int[] jugadas = new int[4];
		    //mostrarTablero
            mostrarMatriz(matrix, tamano, solucion, true);
		    mostrarMatriz(matrix, tamano, solucion,false);
		    while (!fin)
		    {
			    //siempre seguimos la misma dinamica: pido casillas, muestro la matriz con las casillas indicadas, 
			    //compruevo si son correctas, vuelvo a mostrar la matriz tal como nos queda,
			    //incrementamos ronda, y comprovamos si hemos acertado todo el tablero.
			
			    pedirCasillas(jugadas,solucion,tamano);
			    mostrarMatriz(matrix, tamano, solucion, false);
			    //Voy a comprovar si realmente he acertado... para volver a mostrar la matriz.
			    if(matrix[jugadas[0],jugadas[1]] == matrix[jugadas[2],jugadas[3]])
			    {
				    //he acertado, como ya tenia marcada la solucion como "buena", la dejo tal cual.
                    Console.WriteLine("Acertaste!!");
			    }
			    else
			    {
				    //he fallado, tengo que desmarcar de la matriz "solucion" los dos valores.
                    Console.WriteLine("Fallaste!!");
				    solucion[jugadas[0],jugadas[1]]=false;
				    solucion[jugadas[2],jugadas[3]]=false;
			    }
			   //vuelvo a mostrar matriz
                mostrarMatriz(matrix, tamano, solucion, false);
			    rondas++;
                //compruebo el tablero, para saber si he terminado
			    fin=comprobarFin(solucion,tamano);
		    }
		
		    Console.WriteLine("Felicidades!! Ganaste!! Has tardado "+ rondas+ " rondas!!");
		    Console.WriteLine("Fin del juego!");
            Console.ReadLine();

        }
        static Boolean comprobarFin(Boolean[,] solucion, int tamano)
        {
            //si encuentro una posicion falssa, devuelvo false, ya que no he terminado 
            //Si no encuentro ninguna dalsa, devuelvo true, ya que habré terminado;
            for (int i = 0; i < tamano; i++)
            {
                for (int j = 0; j < tamano; j++)
                {
                    if (solucion[i,j] == false)
                        return false;
                }
            }
            return true;

        }
        //esta funcion sirve para pedir las posiciones al usuario, controlando los posibles errores
        static void pedirCasillas(int[] casillas, Boolean[,] solucion, int tamano)
	    {
		
		int fila, columna;
		//posicion 1. Comprovaremos que no sean negativos los valores, que no sean superiores al limite de la matriz
		//y que aun esten por descubrir esas posiciones.
		
		Boolean validado;
		do{
			validado=true;
			fila=-1;columna=-1;
			Console.WriteLine("Introduzca Casilla 1: fila");
			fila=int.Parse(Console.ReadLine());
			Console.WriteLine("Introduzca Casilla 1: Columna");
			columna=int.Parse(Console.ReadLine());
			//comprovacion de errores
			if(fila<0 || columna <0 || fila>=tamano ||columna>=tamano)
			{
				Console.WriteLine("No se pueden escoger filas o columnas fuera de los intervalos");
				validado=false;
			}
			else if(solucion[fila,columna]==true)
			{
				Console.WriteLine("Posicion descubierta. Escoja otra.");
				validado=false;
			}
		}while (!validado);
		casillas[0]=fila;
		casillas[1]=columna;
		//posicion 2. Igual que el anterior, pero controlando que no hayan escogido la misma que antes
		do{
			validado=true;
			fila=-1;columna=-1;
			Console.WriteLine("Introduzca Casilla 2: fila");
			fila=int.Parse(Console.ReadLine());
            Console.WriteLine("Introduzca Casilla 2: Columna");
			columna=int.Parse(Console.ReadLine());
			//comprovacion de errores
			if(fila<0 || columna <0 || fila>=tamano ||columna>=tamano)
			{
				Console.WriteLine("No se pueden escoger filas o columnas fuera de los intervalos");
				validado=false;
			}
			else if(solucion[fila,columna]==true)
			{
				Console.WriteLine("Posicion descubierta. Escoja otra.");
				validado=false;
			}
			else if(casillas[0]==fila && casillas[1]==columna)
			{
                Console.WriteLine("Posicion repetida. Escoja otra.");
				validado=false;
			}
		}while (!validado);

		casillas[2]=fila;
		casillas[3]=columna;
		//Marco la solucion como correcta, para que la funcion mostrar me destape estas posiciones.
		//Mas adelante comprovare que sean o no correctas.
		solucion[casillas[0],casillas[1]]=true;
		solucion[casillas[2],casillas[3]]=true;
		
		
	}
    
        //esta funcion nos sirve para mostrar la matriz. Si en la matriz solucion tengo un valor true, voy a mostrar
	    //el valor verdadero. Si tengo un false, voy a mostrar el interrogante. La variable debug sirve para ver una vez toda la matriz
        //es para facilitar las pruebas.
	    static void mostrarMatriz(char [,] matrix, int tamano, Boolean [,] solucion, Boolean debug)
	    {
		    Console.WriteLine();
		    for(int i=0;i<tamano;i++)
		    {
			    for(int j=0;j<tamano;j++)
			    {
				    if(solucion[i,j]==true ||debug==true)
				    {
					    Console.Write("{0} ",matrix[i,j]);
				    }
				    else
				    {
					    Console.Write("? ");
				    }
				
			    }
			    Console.WriteLine();
		    }
            Console.WriteLine();
		
		
	    }
	    //FUNCIONES PARA RELLENAR LA MATRIZ INICIAL
	    static void llenarMatriz(char[,] matrix, int tamano, Boolean [,] solucion)
	    {
		    //esta funcion sirve para poner en una matriz las letras con las que se jugaran.
		    //previamente, las ponemos en un array y las desordenamos (funcion rellenarVector).
		    char[] vector=new char[tamano*tamano];
		    int k=0;
		
		    rellenarVector(vector, tamano);
		    //tengo el array con las letras desordenadas. Lo pongo en la matriz "tal cual" me ha llegado (ya desordenado)
		    for(int i=0;i<tamano;i++)
		    {
			    for(int j=0;j<tamano;j++)
			    {
				    solucion[i,j]=false;
				    matrix[i,j]=vector[k];
				    k++;
			    }
		    }
		
	    }
	    static void rellenarVector(char[] vector, int tamano)
	    {
		    //esta funcion sirve para poner en un array las letras con las que se jugar� dependiendo del nivel.
		    String abecedario="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456";
		    int j=0;
		    //LO PONGO EN EL ARRAY, de dos en dos
		    for(int i=0;i<tamano*tamano/2;i++)
		    {
			    vector[j]=abecedario[i];
			    j++;
			    vector[j]=abecedario[i];
			    j++;
		    }
		    //MEZCLO EL ARRAY. para ello doy tantas vueltas como la longitud del array con el que juego
            //y para cada casilla, hago un aleatorio, y cambio la posicion actual por la que me ha salido aleatoriamente

		    Random rnd = new Random();
		    for (int i = vector.Length - 1; i > 0; i--)
		    {
		          int index = rnd.Next(i + 1);
		          if(index!=i)
		          {
		    	      char a = vector[index];
		    	      vector[index] = vector[i];
		    	      vector[i] = a;
		          }
		    }
	    }
    }
}
