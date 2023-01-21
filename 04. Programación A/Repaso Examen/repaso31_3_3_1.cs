//sacar por teclado cuantas lineas tiene, cuantas tienen mas de 3 espacios y cuantas superan los 100 caracteres                  

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
            int LineasEspacios = 0;
            int contarLineas = 0;

            while ((linea = fichero.ReadLine()) != null)
            {
                String [] Espacios = linea.Split(' ');
                int contarEspacios = (Espacios.Length) - 1;
                
                if (contarEspacios>3)
                {
                    LineasEspacios++;
                }
                              
                if (linea.Length > 100)
                {
                    contador++;
                }
                contarLineas++;
            }

            fichero.Close();
            flujo.Close();

            Console.WriteLine("El archivo tiene {0} lineas.", contarLineas);
            Console.WriteLine("Hay {0} lineas que tienen más de 3 espacios.", LineasEspacios);
            Console.WriteLine("Hay {0} lineas que tienen más de 100 caracteres.", contador);
            Console.ReadLine();
        }
    }
}