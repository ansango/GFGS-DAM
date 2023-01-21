using System; // Anibal Santos Gomez
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            int debe; // introducimos variables
            int haber;
            int vuelta;
            int moneda200;
            int moneda100;
            int moneda50;
            int moneda20;
            int moneda10;
            int moneda5;
            int moneda2;
            int moneda1;
            int numCasos;
            int i = 0;

            numCasos = int.Parse(Console.ReadLine());
            for (i = 0; i < numCasos; i++)
            {
                debe = int.Parse(Console.ReadLine());
                haber = int.Parse(Console.ReadLine());

                if (debe > haber) // condicion dinero insuficiente
                {
                    int falta = debe - haber;
                    Console.WriteLine("Debe" + falta);
                }
                else
                {
                    vuelta = haber - debe;
                    moneda200 = vuelta / 200;
                    vuelta = vuelta % 200;
                    moneda100 = vuelta / 100;
                    vuelta = vuelta % 100;
                    moneda50 = vuelta / 50;
                    vuelta = vuelta % 50;
                    moneda20 = vuelta / 20;
                    vuelta = vuelta % 20;
                    moneda10 = vuelta / 10;
                    vuelta = vuelta % 10;
                    moneda5 = vuelta / 5;
                    vuelta = vuelta % 5;
                    moneda2 = vuelta / 2;
                    moneda1 = vuelta % 2;
                    Console.WriteLine("" + moneda200 + " " + moneda100 + " " + moneda50 + " " + moneda20 + " " + moneda10 + " " + moneda5 + " " + moneda2 + " " + moneda1);

                }
            }
        }
    }
}
