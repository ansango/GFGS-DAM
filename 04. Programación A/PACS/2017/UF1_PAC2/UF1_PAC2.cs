//Anibal Santos Gomez

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio_01
{
	class Program
	{
		static void Main(string[] args)
		{

			//1. Recoger 2 números e indicar cuál de los dos es mayor o igual que el otro.

			int num1, num2;

			Console.WriteLine("Introduce numero 1: ");
			num1 = int.Parse(Console.ReadLine());
			Console.WriteLine("Introduce numero 2: ");
			num2 = int.Parse(Console.ReadLine());
			if (num1 > num2)
			{
				Console.WriteLine(num1 + " es mayor que " + num2);
			}

			else if (num2 > num1)
			{
				Console.WriteLine(num2 + " es mayor que " + num1);
			}

			else {Console.WriteLine("El primer y segundo número son iguales."); }


			//2. Introducir 1 número e indicar si es positivo, negativo o cero.

			int numero;

			Console.WriteLine(" Introduce un número: ");
			numero = int.Parse(Console.ReadLine());

			if (numero > 1)
			{ Console.WriteLine("El número es positivo"); }
			else if (numero< 0)
			{ Console.WriteLine("El número es negativo"); }
			else { Console.WriteLine("El número es 0"); }


			//3. Introduciendo un número del 1 al 7 el programa nos tiene que informar del día de la semana.

			int num;

			Console.WriteLine("Introduce un numero del 1 al 7");
			num = int.Parse(Console.ReadLine());
			switch (numero)
			{
			
				case 1:

					Console.WriteLine("Hoy es lunes");
					break;

				case 2:

					Console.WriteLine("Hoy es martes");
					break;
				
				case 3:

					Console.WriteLine("Hoy es miércoles");
					break;
				
				case 4:

					Console.WriteLine("Hoy es jueves");
					break;
				
				case 5:

					Console.WriteLine("Hoy es viernes");
					break;
				
				case 6:

					Console.WriteLine("Hoy es sábado");
					break;

				case 7:

					Console.WriteLine("Hoy es domingo");
					break;
			}


			//4. Sacar todos los números del 1 al 100 utilizando el for y el while.

			for (int i = 1; i <= 100; i++)
			{

				Console.WriteLine(i);
			}

			//5.  Invéntate un menú utilizando el do while.

			Console.WriteLine("Elige una opción del siguiente menú: ");
			Console.WriteLine();
			Console.WriteLine("1. Ajustes del sistema.");
			Console.WriteLine("2. El tiempo.");
			Console.WriteLine("3. Mapas.");
			Console.WriteLine("4. Noticias.");
			Console.WriteLine();
			Console.WriteLine("5. Para salir. ");

			int numer = 0;

			do 
			
			{ 
				numer = int.Parse(Console.ReadLine());

				Console.WriteLine(" Ha elegido la opción " + numer + " \n ");

				switch (numer) 

				{
					case 1:

						Console.WriteLine("Ajustes: " + "\n 1. Wifi. " + "\n 2. Red móvil." + "\n 3. Pantalla." + "\n 4. Sonido.");
						break;

					case 2:

						string localidad;
						Console.WriteLine("Introduce localidad");
						localidad = Console.ReadLine();
						Console.WriteLine("El tiempo en " + localidad + " es soleado. ");
						break;

					case 3:
						string lugar;
						Console.WriteLine("Introduce un lugar al que ir");
						lugar = Console.ReadLine();
						Console.WriteLine("Estamos a una distancia considerable de " + lugar + " prepárate para caminar"); 
						
						break;

					case 4:

						Console.WriteLine("El resumen del día: " + "\n - Guerra en Siria continua con 100 fallecidos." + "\n - El conflicto en España se acentua." + "\n - Las lluvias brillan por su ausencia este otoño.");
						
						break;
				}
			} 
			while (numer < 5);

		}
	}
}