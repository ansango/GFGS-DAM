using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ContarVocalesyConsonantes
{
    class Program
    {
        static void Main(string[] args)
        {
            String palabra;
            int contadorVocales = 0;
            int contadorConsonantes;
            Console.Write("Introducir palabra: ");
            palabra = Console.ReadLine();

            for (int i = 0; i < palabra.Length; i++)
            {
                if (palabra[i] == 'a' || palabra[i] == 'e' || palabra[i] == 'i' || palabra[i] == 'o' || palabra[i] == 'u')
                {
                    contadorVocales++;
                }
            }

            contadorConsonantes = palabra.Length - contadorVocales;

            Console.WriteLine("La palabra {0} tiene {1} caracteres, {2} vocales y {3} consonantes", palabra, palabra.Length, contadorVocales,contadorConsonantes);
            Console.ReadLine();
        }
    }
}