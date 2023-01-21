//Crear un fichero.
//Pedir por teclado 3 numeros.
//Escribir en el fichero el resultado de multiplicar los dos primeros y restarle el tercero.
//El programa termina cuando el resultado sea cero.        
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Repaso31_3_2
{
    class Program
    {
        static void Main(string[] args)
        {
            int numero1, numero2, numero3, resultado;

            FileStream flujo = new FileStream("resultado.txt",FileMode.Create,FileAccess.Write);
            StreamWriter fichero = new StreamWriter(flujo);

            do
            {
                Console.Write("Introducir primer número: ");
                numero1 = int.Parse(Console.ReadLine());
                
                Console.Write("Introducir segundo número: ");
                numero2 = int.Parse(Console.ReadLine());
                
                Console.Write("Introducir tercer número: ");
                numero3 = int.Parse(Console.ReadLine());

                resultado=(numero1*numero2)-numero3;

                if (resultado>=0)
                {
                    fichero.WriteLine("({0}*{1})-{2}={3}",numero1,numero2,numero3,resultado);
                }
                
            } while (resultado>=0);

            fichero.Close();
            flujo.Close();
        }
    }
}