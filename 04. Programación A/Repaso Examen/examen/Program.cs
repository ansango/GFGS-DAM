// Crear un array. Rellenar con números aleatorios e indicar cuantos números son mayores de 3.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_1_1_3
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numeros = new int[10];
            Random aleatorios = new Random();
            int contador=0;

            for (int i = 0; i < numeros.Length; i++)
			{
                numeros[i] = aleatorios.Next(1, 11);
                if (numeros[i]>3)
                {
                    contador++;
                }
			}
            
            Console.WriteLine("Hay {0} números mayores de 3", contador);
            Console.Read();
        }
    }
}
