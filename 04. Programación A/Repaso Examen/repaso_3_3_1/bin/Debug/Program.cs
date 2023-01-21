// Abrir un fichero contar la longitud de las líneas y decir cuantas tienen una longitud mayor de 100.
// Escribir en un fichero con las frases dadas por teclado hasta que se escriba "ADIOS".

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace repaso_3_3_1
{
    class Program
    {
        static void Main(string[] args)
        {
            FileStream flujo = new FileStream("TEXTO.txt", FileMode.Open, FileAccess.Read);
            StreamReader fichero = new StreamReader(flujo);
            
            string linea = " ";
            int contador = 0;

            while ((linea=fichero.ReadLine())!=null)
            {
                if (linea.Length>100)
                {
                    contador++;
                }
            }

            fichero.Close();
            flujo.Close();

            Console.WriteLine("Hay {0} líneas con más de 100 caracteres", contador);
            Console.ReadLine();
        }
    }
}
