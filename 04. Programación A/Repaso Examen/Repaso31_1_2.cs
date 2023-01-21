// Decir si la frase contiene las cinco primeras letras del alfabeto.
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso_31_1_2
{
    class Program
    {
        static void Main(string[] args)
        {
            string texto;
            Console.Write("Introducir línea: ");
            texto = Console.ReadLine();

            bool a, b, c, d, e;

            a = texto.Contains('a');
            b = texto.Contains('b');
            c = texto.Contains('c');
            d = texto.Contains('d');
            e = texto.Contains('e');

            if ((a && b && c && d && e)==true)
            {
                Console.WriteLine("La frase contiene las 5 letras.");
            }

            else
            {
                Console.WriteLine("La frase no contiene las 5 letras."); 
            }

            Console.ReadLine();
        }
    }
}