//Declarar función. Llamarla desde el main.
// Pasar un array a una función, que lo relene con el número que se pide y sumarle la posición.
//Mostrar desde el Main el array.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_1_2_1_2
{
    class Program
    {
        static void Main(string[] args)
        {
            int [] numeros=new int[10];
            RellenarArray(numeros);
            
            for (int i = 0; i < numeros.Length; i++)
            {
                Console.WriteLine("Posición {0}: Número: {1}", i, numeros[i]);
            }

            Console.ReadLine();
        }

        static void RellenarArray(int[] numeros) 
        {
            int numero;
            Console.WriteLine("Introducir número");
            numero = int.Parse(Console.ReadLine());

            for (int i = 0; i < numeros.Length; i++)
            {
                numeros[i] = numero + i;
            }
        }
    }
}
