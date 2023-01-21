// Leer un fichero y que diga por pantalla cuantas líneas con más de 50 caracteres.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace repaso_1_3_1
{
    class Program
    {
        static void Main(string[] args)
        {
            FileStream flujo = new FileStream ("archivo.txt", FileMode.Open, FileAccess.Read);
            StreamReader fichero = new StreamReader(flujo);
            String linea = " ";
            int contador = 0;
            while ((linea=fichero.ReadLine()) !=null)
            {
                if (linea.Length>50)
                {
                    contador++;
                }
            }
            fichero.Close();
            flujo.Close();

            Console.WriteLine("Hay {0} líneas con más de 50 caracteres", contador);
            Console.ReadLine();
        }
    }
}
