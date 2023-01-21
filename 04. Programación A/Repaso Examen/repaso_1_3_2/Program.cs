//Generar un fichero con dos números enteros con la suma de estos.
//El programa se acaba cuando los dos números son 0;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace repaso_1_3_2
{
    class Program
    {
        static void Main(string[] args)
        {
            int numero1, numero2, suma;

            FileStream flujo = new FileStream("resultado.txt", FileMode.Create, FileAccess.Write);
            StreamWriter fichero = new StreamWriter(flujo);
                                
            do
            {
                Console.Write("Introducir primer número: ");
                numero1 = int.Parse(Console.ReadLine());

                Console.Write("Introducir segundo número: ");
                numero2 = int.Parse(Console.ReadLine());

                suma = numero1 + numero2;

                if (numero1 != 0 || numero2 != 0)
                {
                    fichero.WriteLine("{0}+{1}={2}", numero1, numero2, suma);
                }
   
            } while (numero1!=0 || numero2!=0);

            fichero.Close();
            flujo.Close();

        }
    }
}
