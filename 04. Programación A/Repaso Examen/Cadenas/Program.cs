using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cadenas
{
    class Program
    {
        static void Main(string[] args)
        {
            //MANEJO DE SUBSTRING EN C#
            String Cadena = "Hola Mundo";
            String Cadena1;
            String Cadena2;
            Cadena1 = Cadena.Substring(0,4);
            Cadena2 = Cadena.Substring(5, 5);
            Console.WriteLine("{0} {1}", Cadena2,Cadena1);
            Console.ReadLine();

        }
    }
}
