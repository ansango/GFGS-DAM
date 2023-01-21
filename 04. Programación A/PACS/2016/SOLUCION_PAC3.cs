using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace solucionPAC3
{
    class Program
    {
        static void Main(string[] args)
        {
            int monedas200, monedas100, monedas50, monedas20, monedas10, monedas5, monedas2, monedas1;
            int casos, importe, entregado, cantidad;
            //pido casos controlando el error
            do
            {
                Console.WriteLine("Cuantos casos de prueba?");
                casos = int.Parse(Console.ReadLine());
            } while (casos < 0);
            //hago un bucle que se ejecutara tantas veces como casos valga
            for (int i = 0; i < casos; i++)
            {
                //reinicio el valor de las variables de monedas
                monedas200 = monedas100 = monedas50 = monedas20 = monedas10 = monedas5 = monedas2 = monedas1 = 0;
                //controlo negativo de importe
                do
                {
                    Console.WriteLine("Importe?");
                    importe = int.Parse(Console.ReadLine());
                } while (importe < 0);
                //controlo negativo de entregado
                do
                {
                    Console.WriteLine("Entregado?");
                    entregado = int.Parse(Console.ReadLine());
                } while (entregado < 0);
                //si entregado menor que importe, debo dinero.
                if (entregado < importe)
                {
                    cantidad = importe - entregado;
                    Console.WriteLine("DEBE " + cantidad);
                }
                else
                {
                    //calculo monedas y muestro.
                    cantidad = entregado - importe;
                    monedas200 = cantidad / 200;
                    cantidad = cantidad % 200;
                    monedas100 = cantidad / 100;
                    cantidad = cantidad % 100;
                    monedas50 = cantidad / 50;
                    cantidad = cantidad % 50;
                    monedas20 = cantidad / 20;
                    cantidad = cantidad % 20;
                    monedas10 = cantidad / 10;
                    cantidad = cantidad % 10;
                    monedas5 = cantidad / 5;
                    cantidad = cantidad % 5;
                    monedas2 = cantidad / 2;
                    monedas1 = cantidad % 2;
                    Console.WriteLine("Cambio: " + monedas200 + " " + monedas100 + " " + monedas50 + " "
                         + monedas20 + " " + monedas10 + " " + monedas5 + " " + monedas2 + " "
                          + monedas1 + " ");
                }
            }
            Console.WriteLine("Fin de programa: Pulse una tecla para finalizar");

            
            Console.ReadLine();
        }
        
    }
}
