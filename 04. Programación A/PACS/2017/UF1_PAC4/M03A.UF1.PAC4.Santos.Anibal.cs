using System;

namespace UF1_PAC4
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			//Aníbal Santos Gómez UF1_PAC4 - Desarrollo de Aplicaciones Multiplataforma.

			//a) Array de 16 numeros:

			int[] A = new int[16];
			Random aleatorio = new Random();

			//Introducimos los numeros aleatorio en el array y mostramos su contenido:

			Console.WriteLine("\na) Creamos y mostramos el vector: ");
			for (int i = 0; i < 16; i++) 
			{
				A[i] = aleatorio.Next(-10, 20);
				Console.Write("{0}", A[i]);
			}

			//b) Multiplos de 2 no negativos:

			Console.WriteLine("\nb) Mostramos la cantidad de pares positivos: ");
			int contador = 0;
			for (int i = 0; i < 16; i++) 
			{
				if (A[i] % 2 == 0 && A[i] > 0) 
				{
					contador++;
				}
			}
			Console.WriteLine("\n Hay " + contador + " números positivos y pares. ");

			//c) Matriz de 4x4:

			//La matriz será de 4x5 para guardar la suma en la última columna.

			int[,] matriz = new int[4, 5];
			int k = 0; //indice del vector.
			Console.Write("\nc) Pasamos el contenido del vector a la matriz: ");
			Console.Write("\n\n");
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++) 
				{
					matriz[i, j] = A[k]; // aquí estamos guardando en la posición i,j lo que hay en la posición k del vector.
					Console.Write("\t{0}", matriz[i, j]); //imprimimos matriz con tabulación para generar espacio horizontal entre números.
					k++;
				}
				Console.WriteLine(); //imprimimos línea para así generar columnas.
			}

			//d) Positivamos la matriz mostrando la suma de las filas:

			Console.Write("\nd) Positivamos la matriz y sumamos la suma de las filas: ");
			Console.Write("\n\n");
			int suma;
			for (int i = 0; i < 4; i++) 
			{
				suma = 0; //iniciamos suma a cero.
				for (int j = 0; j < 4; j++) 
				{
					if (matriz[i, j] < 0) 
					{
						matriz[i, j] = matriz[i, j] * -1; //si el numero es menor que cero multiplicamos por -1 (positivamos).
						Console.Write("\t{0}", matriz[i, j]); //mostramos el número.
						suma += matriz[i, j]; //acumulamos su suma.
					}
					//guardamos la suma en la última columna y mostramos:

					matriz[i, 4] = suma;
					Console.WriteLine("\t" + matriz[i, 4]);
				}
			}

			//e) Puntos de bitácora de la matriz:

			Console.Write("\ne) Puntos de bitácora de la matriz: ");
			for (int i = 0; i < 4; i++) 
			{
				for (int j = 0; j < 4; j++) 
				{
					if (matriz[i, j] != 0) //evitamos hacer suma ya que si dividieramos por 0 generaría indeterminación
					{
						if ((matriz[i, j] % 3 == 0 || matriz[i, j] % 4 == 0) && (matriz[i, 4] % matriz[i, j] == 0)) 
						{
							Console.WriteLine("Número " + matriz[i, j] + " (posición " + i + ", " + j + "), ya que es múltiplo de 3 o 4" + " y divide exáctamente a la suma de la fila " + i + "("+matriz[i, 4] + ")");
						}
					}
				}
			}
				
		}
	}
}
