// Función se le pasa un array y un número. Sumar nº Registro mas número. Rellenar Array.
// Añadir a Función un numero a Restar, Mostrar por pantalla el número menos los datos del Array.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso2_2_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int numero;
            int numeroResta;
            int[] numeros = new int[10];

            Console.Write("Introduce número: ");
            numero = int.Parse(Console.ReadLine());

            Console.Write("Introduce número a Restar: ");
            numeroResta = int.Parse(Console.ReadLine());
            
            RellenarArray(numeros, numero, numeroResta);

            Console.ReadLine();
        }

        static void RellenarArray(int[] numeros, int numero, int numeroResta) 
        {
            for (int i = 0; i < numeros.Length; i++)
            {
                numeros[i] = numero + 1 + i;
            }

            for (int i = 0; i < numeros.Length; i++)
            {
                Console.WriteLine(numeroResta - numeros[i]);
            }
        }
    }
}