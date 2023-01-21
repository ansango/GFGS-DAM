// Crear un array de 10 posiciones y rellenarlo con datos solicitados por pantalla.
//Buscar el minimo de ese array y mostrarlo por pantalla.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_3_1_4_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] datos = new int[10];
            int dato;
            int minimo;
            for (int i = 0; i < datos.Length; i++)
            {
                Console.Write("Introducir datos para la posición {0}: ", i);
                dato = int.Parse(Console.ReadLine());
                datos[i] = dato;
            }

            minimo=datos[0];

            for (int i = 1; i < datos.Length; i++)
            {
                if (datos[i]<minimo)
                {
                    minimo=datos[i];
                }
            }
            Console.WriteLine(" ");
            Console.WriteLine("El número minimo del array es: {0}", minimo);
            Console.ReadLine();
        }
    }
}
