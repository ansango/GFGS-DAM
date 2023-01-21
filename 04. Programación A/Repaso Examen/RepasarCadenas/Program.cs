// Contar cuantas mayusculas tiene el texto y cuantas a y e tiene. y Mostrarlo.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepasarCadenas
{
    class Program
    {
        static void Main(string[] args)
        {
            string linea;
            int contadorA=0;
            int contadorE=0;
            int mayusculas = 0;
            Console.Write("Introducir texto: ");
            linea = Console.ReadLine();
                     

            for (int i = 0; i < linea.Length; i++)
            {
                if (char.IsUpper(linea[i]))
                {
                    mayusculas++;
                }
            }

            linea = linea.ToLower();
                        
            for (int i = 0; i < linea.Length; i++)
            {
                if (linea[i]=='a')
                {
                    contadorA++;
                }

                if (linea[i] == 'e')
                {
                    contadorE++;
                }
            }

            Console.WriteLine("El texto introducido tiene {0} máyusculas, {1} (a) y {2} (e)", mayusculas, contadorA, contadorE);
            Console.ReadLine(); 
        }
    }
}
