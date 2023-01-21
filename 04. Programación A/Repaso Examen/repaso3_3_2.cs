// Escribir en un fichero con las frases dadas por teclado hasta que se escriba "ADIOS".

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace repaso_3_3_2
{
    class Program
    {
        static void Main(string[] args)
        {
            FileStream flujo = new FileStream("resultado.txt", FileMode.Create, FileAccess.Write);
            StreamWriter fichero = new StreamWriter(flujo);
            string linea;

            do
            {
                Console.Write("Introducir texto: ");
                linea = Console.ReadLine();

                if (linea!="ADIOS")
                {
                    fichero.WriteLine(linea);
                }
                
            } while (linea!="ADIOS");

            fichero.Close();
            flujo.Close();
        }
    }
}
