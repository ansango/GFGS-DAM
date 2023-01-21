// Crear array y un número aleatorio.
// Indicar cuantos números del array son mayores que el número aleatorio.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_3_1_4_3_4
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] ArrayNumeros = new int[10]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            Random aleatorio = new Random();
            int numero;
            int contador=0;
            numero = aleatorio.Next(1,11);

            for (int i = 0; i < ArrayNumeros.Length; i++)
            {
                if (ArrayNumeros[i]>numero)
                {
                    contador++;
                }
            }
            Console.WriteLine("Hay {0} números mayores que el número aleatorio ({1})", contador, numero);
            Console.ReadLine();
        }
    }
}